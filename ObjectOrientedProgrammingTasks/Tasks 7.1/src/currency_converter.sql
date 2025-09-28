DROP DATABASE IF EXISTS currency_converter;

CREATE DATABASE currency_converter;

USE currency_converter;

DROP TABLE IF EXISTS CURRENCY;

CREATE TABLE CURRENCY (
                          id INT NOT NULL AUTO_INCREMENT,
                          abbreviation VARCHAR(10) NOT NULL UNIQUE,
                          name VARCHAR(100) NOT NULL,
                          rate_to_usd DECIMAL(12,6) NOT NULL,
                          PRIMARY KEY (id)
);

INSERT INTO CURRENCY (abbreviation, name, rate_to_usd) VALUES
                                                           ('USD', 'United States Dollar', 1.000000),
                                                           ('EUR', 'Euro', 0.950000),
                                                           ('GBP', 'British Pound Sterling', 0.820000),
                                                           ('JPY', 'Japanese Yen', 149.000000),
                                                           ('CNY', 'Chinese Yuan', 7.300000),
                                                           ('AUD', 'Australian Dollar', 1.560000),
                                                           ('CAD', 'Canadian Dollar', 1.370000),
                                                           ('CHF', 'Swiss Franc', 0.920000);

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT ON currency_converter.* TO 'appuser'@'localhost';
