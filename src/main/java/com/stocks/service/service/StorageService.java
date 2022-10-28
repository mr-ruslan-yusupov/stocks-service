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

    public Collection<Storage> findAll() {
        return storageRepository.findAll();
    }

    public Storage saveOrUpdate(Storage storage) {
        return storageRepository.saveAndFlush(storage);
    }

}
