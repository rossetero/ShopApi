DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS images;

CREATE TABLE addresses (
    id UUID PRIMARY KEY,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    street VARCHAR(100) NOT NULL
);

CREATE TABLE clients (
    id UUID PRIMARY KEY,
    client_name VARCHAR(100) NOT NULL,
    client_surname VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    gender VARCHAR(10) CHECK (gender IN ('male', 'female')),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    address_id UUID,
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);



CREATE TABLE suppliers (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address_id UUID,
    phone_number VARCHAR(15),
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE images (
    id UUID PRIMARY KEY,
    image BYTEA
);

CREATE TABLE products (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(100),
    price DECIMAL(10, 2) NOT NULL,
    available_stock INT NOT NULL,
    last_update_date DATE NOT NULL,
    supplier_id UUID,
    image_id UUID,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id),
    FOREIGN KEY (image_id) REFERENCES images(id)
);

INSERT INTO addresses (id, country, city, street) VALUES
    (gen_random_uuid(), 'USA', 'New York', '5th Avenue'),
    (gen_random_uuid(), 'Germany', 'Berlin', 'Alexanderplatz'),
    (gen_random_uuid(), 'France', 'Paris', 'Champs-Élysées');

-- Вставка данных в таблицу suppliers
INSERT INTO suppliers (id, name, address_id, phone_number) VALUES
    (gen_random_uuid(), 'Supplier A', (SELECT id FROM addresses LIMIT 1), '123-456-7890');

-- Вставка данных в таблицу clients
INSERT INTO clients (id, client_name, client_surname, birthday, gender, address_id) VALUES
    (gen_random_uuid(), 'John', 'Doe', '1990-01-01', 'male', (SELECT id FROM addresses LIMIT 1));

-- Вставка данных в таблицу products
INSERT INTO products (id, name, category, price, available_stock, last_update_date, supplier_id) VALUES
    (gen_random_uuid(), 'Product 1', 'Category 1', 19.99, 100, CURRENT_DATE, (SELECT id FROM suppliers LIMIT 1));