CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    address VARCHAR(255),
    phone_number VARCHAR(14),
    CONSTRAINT valid_phone_number CHECK (phone_number ~* '[+].*'),
    CONSTRAINT valid_email CHECK (email ~* '^[a-zA-z._0-9]+@+[a-zA-z.].*'),
    CONSTRAINT birth_date_check CHECK (birthday < CURRENT_DATE)
);