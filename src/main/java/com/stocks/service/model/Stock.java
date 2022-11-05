package com.stocks.service.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "tbl_stocks")
public class Stock {
    @EmbeddedId
    StockCompositeKey id = new StockCompositeKey();

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private Product product;

    @ManyToOne
    @MapsId("storageId")
    @JoinColumn(name = "storage_id", nullable = false, updatable = false)
    private Storage storage;

    private int quantity;

    public StockCompositeKey getId() {
        return id;
    }

    public void setId(StockCompositeKey id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock stock)) return false;
        return new EqualsBuilder().append(getProduct(), stock.getProduct()).append(getStorage(), stock.getStorage()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getProduct()).append(getStorage()).toHashCode();
    }
}
