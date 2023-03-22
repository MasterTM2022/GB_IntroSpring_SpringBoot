DROP TABLE IF EXISTS product;

CREATE TABLE product (id BIGSERIAL PRIMARY KEY, title varchar(255) NOT NULL, cost numeric (9, 2) NOT NULL);

INSERT INTO product (title, cost) VALUES ('bread', 200.0), ('milk', 21.5), ('eggs', 22.0), ('cheese', 22.5), ('butter', 23.0), ('cottage cheese', 23.5), ('sunflower oil', 24.0), ('flour', 24.5), ('salt', 25.0), ('sugar', 25.5);