CREATE TABLE IF NOT EXISTS data(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR NOT NULL,
    age INTEGER NOT NULL,
    title VARCHAR,
    hometown VARCHAR
);

INSERT INTO data (name, age, title, hometown) VALUES ('Test', 18, null, null);
INSERT INTO data (name, age, title, hometown) VALUES ('Test2', 19, 'Mr', null);
INSERT INTO data (name, age, title, hometown) VALUES ('Test3', 20, 'Mrs', 'Neverland');