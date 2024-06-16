CREATE EXTENSION IF NOT EXISTS "pgcrypto";
-- pq esta usando o gen_random_uuid

CREATE TABLE filme (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    genero VARCHAR(30) NOT NULL,
    sinopse VARCHAR(400),
    lancamento TIMESTAMP NOT NULL,
    imagemURL VARCHAR(250)
)