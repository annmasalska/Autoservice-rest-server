DROP KEYSPACE autoService;

CREATE KEYSPACE autoService WITH
REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor': 3};

USE autoService;

CREATE TABLE availableAuto (
        logo VARCHAR,
        carBrand  VARCHAR, 
        modelsAuction  map<VARCHAR, VARCHAR>, 
        modelsCatalog  map<VARCHAR, VARCHAR>,
        PRIMARY KEY(carBrand)
);


CREATE TABLE auction (
        carBrand VARCHAR,
        model VARCHAR ,
        lot VARCHAR,
        price VARCHAR ,
        status VARCHAR,
        exactCloseDate VARCHAR,
        details text,
        bids map<VARCHAR, varchar>, -- info about bids in json
        sorted VARCHAR,
 
        PRIMARY KEY((exactCloseDate, carBrand), model)
);
 
 
CREATE TABLE catalog (
        partType VARCHAR,       -- possible types: body part, engine, wheel & tire
        carBrand VARCHAR,
        model VARCHAR,
        title VARCHAR,          -- example: door, roof etc
        price VARCHAR ,
        status VARCHAR,
        details text,
        PRIMARY KEY((partType), carBrand, model)
);