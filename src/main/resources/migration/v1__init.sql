CREATE TABLE categories (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            created_at DATETIME(6),
                            is_deleted BIT NOT NULL,
                            last_updated_at DATETIME(6),
                            name VARCHAR(255),
                            PRIMARY KEY (id)
);
CREATE TABLE product (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         created_at DATETIME(6),
                         is_deleted BIT NOT NULL,
                         last_updated_at DATETIME(6),
                         description VARCHAR(255),
                         image VARCHAR(255),
                         price FLOAT(53) NOT NULL,
                         title VARCHAR(255),
                         category_id BIGINT,
                         PRIMARY KEY (id)
);