CREATE TABLE aluguel (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    total NUMERIC(5,2)
)