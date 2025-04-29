-- First, clean up existing data (if any) in reverse order of dependencies
DROP TABLE IF EXISTS workouts CASCADE;
DROP TABLE IF EXISTS exercises CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users(
    userid VARCHAR(255) PRIMARY KEY,
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
    workoutid SERIAL PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    workoutdate DATE, -- YYYY-MM-DD
    userfk VARCHAR(255),
    exercisefk BIGINT, -- foreign key IDer navngir vi med (tablenavn + understrek + id) for ordens skyld ye
    CONSTRAINT fk_user FOREIGN KEY (userfk) REFERENCES users(userid) ON DELETE CASCADE,
CONSTRAINT fk_exercise FOREIGN KEY (exercisefk) REFERENCES exercises(exerciseid) ON DELETE CASCADE
);

--TRUNCATE TABLE workouts;
--TRUNCATE TABLE exercises;
--TRUNCATE TABLE users;

-- users
INSERT INTO users ( userid, username, email, birthday) VALUES
    ('abc123','testing', 'testing@test.com', '1990-01-01'),
    ('1234a', 'malinator', 'malin@mail.com', '1985-02-12'),
    ('bbbb', 'oscarinho', 'oscar@mail.com', '1992-03-23'),
    ('ccccc', 'sarasaurus', 'sara@mail.com', '1995-04-15'),
    ('dddd', 'bertimusprime', 'albert@mail.com', '1988-07-20');

-- exercises
INSERT INTO exercises (name, description) VALUES
    ('Running', 'Outdoor or indoor running'),
    ('Running incline', 'Running with incline'),
    ('Cycling', 'Spinning or Biking'),
    ('Benchpress', 'Barbell bench'),
    ('Benchpress', 'Dumbbell bench');

-- workouts
INSERT INTO workouts (title, content, workoutdate, userfk, exercisefk) VALUES
    ('CHEST DAY', 'YEAAH BUDDEYYEA', now(), 'dddd', 4),
    ('Løper litt da hehe', 'rolig tur på bana', now(), 'bbbb', 1),
    ('Løper mye!!', 'Marathon før frokost', now(), 'bbbb', 2);




SELECT * FROM exercises ORDER BY exerciseid;
SELECT * FROM workouts ORDER BY workoutdate, userfk, workoutid;
SELECT * FROM users ORDER BY userid;