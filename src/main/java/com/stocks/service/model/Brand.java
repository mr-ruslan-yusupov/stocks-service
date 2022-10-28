package com.stocks.service.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_brands")
public class Brand {
    @Id
    //@GeneratedValue
    @SequenceGenerator(name="seq-gen-brand",sequenceName="SEQ_GEN_BRAND",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen-brand")
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @OneToMany(targetEntity = Product.class, mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
