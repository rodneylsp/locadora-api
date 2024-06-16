CREATE TABLE fita (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    filme_id UUID,
    FOREIGN KEY (filme_id) REFERENCES filme(id)
);