package com.stocks.service.service;

import com.stocks.service.model.Storage;
import com.stocks.service.repository.StorageRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StorageService {
    final private StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public Collection<Storage> findAllStorages() {
        return storageRepository.findAll();
    }

    public Storage findStorageByName(String storageName) {
        return storageRepository.findStorageByStorageName(storageName);
    }

    public Storage saveOrUpdateStorage(Storage storage) {
        return storageRepository.saveAndFlush(storage);
    }

}
