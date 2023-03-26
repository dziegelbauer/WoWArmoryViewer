package org.ziegelbauer.wowarmoryviewer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.ziegelbauer.wowarmoryviewer.model.document.ItemIconDocument;

public interface ItemIconRepository extends MongoRepository<ItemIconDocument, Integer> {
}
