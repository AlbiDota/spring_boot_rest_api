-- First, clean up existing data (if any) in reverse order of dependencies
DELETE FROM User;

-- Sample data for Product entity
INSERT INTO product ( email, password, firstname, lastname) VALUES
    ('albert@oblig2.no', 'PepsiMax123!', 'Albert', 'Dota'),
    ('ikkealbert@oblig2.no', 'CocaCola123!', 'Ikke', 'Albert');