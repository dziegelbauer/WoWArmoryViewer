package org.ziegelbauer.wowarmoryviewer.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("itemicons")
@AllArgsConstructor
@Getter @Setter
public class ItemIconDocument {
    @Id
    private Integer id;
    private byte[] jpegData;
    private LocalDateTime lastRefreshed;
}
