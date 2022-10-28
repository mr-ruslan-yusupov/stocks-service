CREATE SEQUENCE hibernate_sequence START 1;

-- Table: store_stocks.tbl_storages
CREATE TABLE IF NOT EXISTS store_stocks.tbl_storages
(
    storage_id bigint NOT NULL,
    storage_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    storage_address character varying(150) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tbl_storages_pkey PRIMARY KEY (storage_id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS store_stocks.tbl_storages
    OWNER to postgres;

-- Table: store_stocks.tbl_categories
CREATE TABLE IF NOT EXISTS store_stocks.tbl_categories
(
    category_id bigint NOT NULL,
    category_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tbl_categories_pkey PRIMARY KEY (category_id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS store_stocks.tbl_categories
    OWNER to postgres;

-- Table: store_stocks.tbl_brands
CREATE TABLE IF NOT EXISTS store_stocks.tbl_brands
(
    brand_id bigint NOT NULL,
    brand_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tbl_brands_pkey PRIMARY KEY (brand_id)
)
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS store_stocks.tbl_brands
    OWNER to postgres;

-- Table: store_stocks.tbl_products
CREATE TABLE IF NOT EXISTS store_stocks.tbl_products
(
    product_id bigint NOT NULL,
    product_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    product_description character varying(150) COLLATE pg_catalog."default" NOT NULL,
    product_price money NOT NULL,
    category_id bigint NOT NULL DEFAULT (0),
    brand_id bigint NOT NULL DEFAULT (0),
    CONSTRAINT tbl_products_pkey PRIMARY KEY (product_id),
    CONSTRAINT tbl_products_category_id_fkey FOREIGN KEY (category_id)
        REFERENCES store_stocks.tbl_categories (category_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET DEFAULT,
    CONSTRAINT tbl_products_brand_id_fkey FOREIGN KEY (brand_id)
        REFERENCES store_stocks.tbl_brands (brand_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET DEFAULT
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS store_stocks.tbl_products
    OWNER to postgres;

-- Table: store_stocks.tbl_stocks
CREATE TABLE IF NOT EXISTS store_stocks.tbl_stocks
(
    product_id bigint,
    storage_id bigint,
    quantity bigint,
    CONSTRAINT tbl_stocks_product_id_fkey FOREIGN KEY (product_id)
        REFERENCES store_stocks.tbl_products (product_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT tbl_stocks_storage_id_fkey FOREIGN KEY (storage_id)
        REFERENCES store_stocks.tbl_storages (storage_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS store_stocks.tbl_stocks
    OWNER to postgres;
