CREATE TABLE IF NOT EXISTS saloon_seq (next_val BIGINT) ENGINE=InnoDB;
INSERT INTO saloon_seq VALUES (1);

CREATE TABLE IF NOT EXISTS saloon (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    owner_id BIGINT NOT NULL,
    opening_time TIME(6) NOT NULL,
    closing_time TIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS saloon_images (
    saloon_id BIGINT NOT NULL,
    images VARCHAR(255),
    CONSTRAINT FKjs2hqbsqi3n3oymdflbrme9j7 FOREIGN KEY (saloon_id) REFERENCES saloon (id)
) ENGINE=InnoDB;
