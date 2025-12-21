CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        code VARCHAR(255),
                        created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE items (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       description VARCHAR(255),
                       price INT NOT NULL,
                       code VARCHAR(255),
                       category_id INT,
                       CONSTRAINT fk_item_category
                           FOREIGN KEY (category_id)
                               REFERENCES categories(id)
                               ON DELETE SET NULL
);

CREATE TABLE items_orders (
                              item_id INT NOT NULL,
                              order_id INT NOT NULL,
                              PRIMARY KEY (item_id, order_id),
                              CONSTRAINT fk_item
                                  FOREIGN KEY (item_id)
                                      REFERENCES items(id)
                                      ON DELETE CASCADE,
                              CONSTRAINT fk_order
                                  FOREIGN KEY (order_id)
                                      REFERENCES orders(id)
                                      ON DELETE CASCADE
);
