CREATE TABLE aluguel_fita (
    aluguel_id UUID,
    fita_id UUID,
    FOREIGN KEY (aluguel_id) REFERENCES aluguel(id),
    FOREIGN KEY (fita_id) REFERENCES fita(id)
)