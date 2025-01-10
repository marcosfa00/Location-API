CREATE TABLE Continent (
    name VARCHAR(50) NOT NULL,
    code CHAR(2) PRIMARY KEY NOT NULL
);

CREATE TABLE Country (
    name VARCHAR(50) NOT NULL,
    code CHAR(2) PRIMARY KEY NOT NULL,
    continentCode CHAR(2) NOT NULL,
    FOREIGN KEY (continentCode) REFERENCES Continent(code)
);

CREATE TABLE City (
    id IDENTITY PRIMARY KEY NOT NULL,
    countryCode CHAR(2) NOT NULL,
    name VARCHAR(150) NOT NULL,
    latitude BIGINT NOT NULL,
    longitude BIGINT NOT NULL,
    FOREIGN KEY (countryCode) REFERENCES Country(code)
);