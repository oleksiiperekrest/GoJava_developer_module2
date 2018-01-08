USE homework1;
INSERT INTO skills (description)
VALUES
  ('Java'),
  ('C++'),
  ('Swift'),
  ('Ruby'),
  ('JavaScript');

INSERT INTO developers (first_name, last_name, salary)
VALUES
  ('Ivan', 'Ivashov', 3010),
  ('Vasiliy', 'Velikiy', 3520),
  ('Sergey', 'Sergonian', 4030),
  ('Anatoliy', 'Arbuzov', 2340),
  ('Petr', 'Potomushto', 1550),
  ('Zinaida', 'Zimonina', 1860),
  ('Gavrila', 'Gruzdev', 2970),
  ('Ruben', 'Radzinskiy', 3180),
  ('Evgeniy', 'Ermolov', 3490),
  ('Fedor', 'Filinchuk', 2200);

INSERT INTO developers_skills ()
VALUES
  (1, 1),
  (1, 5),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 3),
  (5, 4),
  (5, 5),
  (6, 1),
  (7, 2),
  (8, 3),
  (9, 4),
  (10, 5);

INSERT INTO customers (first_name, last_name, info)
VALUES
  ('Grigoriy', 'Gronov', 'Customer one'),
  ('Katerina', 'Klenova', 'Customer two'),
  ('Boris', 'Burda', 'Customer three'),
  ('Marina', 'Morozova', 'Customer four'),
  ('Roman', 'Romanesku', 'Customer five');

INSERT INTO companies (name, country, description)
VALUES
  ('Yippi', 'Ukraine', 'Company one'),
  ('Q-tech', 'Moldova', 'Company two'),
  ('Dodecahedron', 'Ukraine', 'Company three');

INSERT INTO developers_companies ()
VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,3),
  (5,3),
  (6,3),
  (7,2),
  (8,1),
  (9,2),
  (10,2);

INSERT INTO projects (name, description, cost)
VALUES
  ('Mercury', 'Account page for internet service users', 10420),
  ('Venus', 'Online shop', 15360),
  ('Mars', 'Warehouse managing application', 8870),
  ('Jupiter', 'Article database', 18510),
  ('Saturn', 'Transport logistics application', 12110),
  ('Uranus', 'Clothing catalogue', 4540),
  ('Neptune', 'Accessories catalogue', 2200),
  ('Kuiper belt', 'Internet traffic compression', 14050),
  ('Comet', 'Astronomic simulator', 8530);
  
INSERT INTO projects_developers ()
VALUES
  (1,1),
  (1,2),
  (1,4),
  (1,5),
  (2,2),
  (2,7),
  (2,8),
  (2,9),
  (2,10),
  (3,8),
  (3,9),
  (3,10),
  (4,2),
  (4,1),
  (4,4),
  (4,7),
  (4,8),
  (4,9),
  (5,1),
  (5,2),
  (5,3),
  (5,5),
  (6,4),
  (6,10),
  (7,10),
  (8,1),
  (8,2),
  (8,3),
  (8,9),
  (9,4),
  (9,1),
  (9,8);

INSERT INTO customers_projects ()
VALUES
  (1,1),
  (1,8),
  (1,9),
  (2,2),
  (2,7),
  (3,5),
  (4,3),
  (5,4),
  (5,6);