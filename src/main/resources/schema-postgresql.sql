/* Serial = inteiro e autoincrement */
CREATE TABLE IF NOT EXISTS computador (
    id serial PRIMARY KEY, 
    modelo varchar(50) NOT NULL,
    defeito varchar(120) NOT NULL
);
        -- comando magico: ( drop schema public; )

