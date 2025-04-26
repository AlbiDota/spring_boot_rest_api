-- First, clean up existing data (if any) in reverse order of dependencies
DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users(
    userid SERIAL PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    birthday DATE
);

-- Sample data for User entity
SELECT * FROM users ORDER BY userid;


TRUNCATE TABLE users;
INSERT INTO users ( username, email, birthday) VALUES
    ('testing', 'testing@test.com', '1990-01-01'),
    ('malinator', 'malin@mail.com', '1985-02-12'),
    ('oscarinho', 'oscar@mail.com', '1992-03-23'),
    ('sarasaurus', 'sara@mail.com', '1995-04-15'),
    ('bertimusprime', 'albert@mail.com', '1988-07-20');

SELECT * FROM users ORDER BY userid;