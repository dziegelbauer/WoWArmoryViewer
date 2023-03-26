package org.ziegelbauer.wowarmoryviewer.services;

import org.springframework.stereotype.Service;
import org.ziegelbauer.wowarmoryviewer.model.document.ItemIconDocument;
import org.ziegelbauer.wowarmoryviewer.repository.ItemIconRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DataCacheServiceImpl implements DataCacheService {
    private final ItemIconRepository itemIconRepository;
    private final BattleNetService battleNetService;

    public DataCacheServiceImpl(
            ItemIconRepository itemIconRepository,
            BattleNetService battleNetService
    ) {
        this.itemIconRepository = itemIconRepository;
        this.battleNetService = battleNetService;
    }

    public byte[] getItemIcon(Integer id) {
        Optional<ItemIconDocument> itemIcon = itemIconRepository.findById(id);
        if(itemIcon.isPresent()) {
            if(itemIcon.get().getLastRefreshed().isBefore(LocalDateTime.now().minusDays(30))) {
                return this.refreshIcon(id);
            } else {
                return itemIcon.get().getJpegData();
            }
        } else {
            return this.refreshIcon(id);
        }
    }

    private byte[] refreshIcon(Integer id) {
        byte[] jpegData = battleNetService.getItemIcon(id);
        ItemIconDocument itemIcon = new ItemIconDocument(id, jpegData, LocalDateTime.now());
        itemIconRepository.insert(itemIcon);
        return jpegData;
    }
}
