CREATE SCHEMA IF NOT EXISTS "CXR";

CREATE TABLE IF NOT EXISTS "CXR".nota
(
    "ID" integer NOT NULL AUTO_INCREMENT primary key,
    "VALOR_NOTA" integer NOT NULL,
    "QT_DISPONIVEL" integer NOT NULL DEFAULT 0
    );