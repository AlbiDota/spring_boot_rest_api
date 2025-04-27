-- First, clean up existing data (if any) in reverse order of dependencies
DROP TABLE IF EXISTS workouts CASCADE;
DROP TABLE IF EXISTS exercises CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users(
    userid SERIAL PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    birthday DATE
);

CREATE TABLE exercises (
    exerciseid SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT
);

CREATE TABLE workouts (
    workout_id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    workout_date TIMESTAMP,
    users_id BIGINT,
    exercises_id BIGINT, -- foreign key IDer navngir vi med (tablenavn + understrek + id) for ordens skyld ye
    CONSTRAINT fk_user FOREIGN KEY (users_id) REFERENCES users(userid) ON DELETE CASCADE,
    CONSTRAINT fk_exercise FOREIGN KEY (exercises_id) REFERENCES exercises(exerciseid) ON DELETE CASCADE
);

--TRUNCATE TABLE workouts;
--TRUNCATE TABLE exercises;
--TRUNCATE TABLE users;

-- users
INSERT INTO users ( username, email, birthday) VALUES
    ('testing', 'testing@test.com', '1990-01-01'),
    ('malinator', 'malin@mail.com', '1985-02-12'),
    ('oscarinho', 'oscar@mail.com', '1992-03-23'),
    ('sarasaurus', 'sara@mail.com', '1995-04-15'),
    ('bertimusprime', 'albert@mail.com', '1988-07-20');

-- exercises
INSERT INTO exercises (name, description) VALUES
    ('Running', 'Outdoor or indoor running'),
    ('Running incline', 'Running with incline'),
    ('Cycling', 'Spinning or Biking'),
    ('Benchpress', 'Barbell bench'),
    ('Benchpress', 'Dumbbell bench');

-- workouts
INSERT INTO workouts (title, content, workout_date, users_id, exercises_id) VALUES
    ('CHEST DAY', 'YEAAH BUDDEYYEA', now(), 5, 4),
    ('Løper litt da hehe', 'rolig tur på bana', now(), 3, 1),
    ('Løper mye!!', 'Marathon før frokost', now(), 3, 2);




SELECT * FROM exercises ORDER BY exerciseid;
SELECT * FROM workouts ORDER BY users_id, workout_date;
SELECT * FROM users ORDER BY userid;