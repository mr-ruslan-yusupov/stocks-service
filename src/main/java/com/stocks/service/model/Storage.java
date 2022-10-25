package com.stocks.service.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_storages")
public class Storage {
    @Id
    @GeneratedValue
    @Column(name = "storage_id", nullable = false)
    private Long storageId;

    @Column(name = "storage_name", nullable = false)
    private String storageName;

    @Column(name = "storage_address", nullable = false)
    private String storageAddress;

    @OneToMany(mappedBy = "storage")
    private Set<Stock> stocks;

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

}
