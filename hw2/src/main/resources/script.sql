CREATE SCHEMA ListExpenses;
USE ListExpenses;

CREATE TABLE expenses(
id INT PRIMARY KEY,
paydate DATE NOT NULL,
receiver_id INT NOT NULL references receiver(id),
value DECIMAL(6, 2) NOT NULL);

CREATE TABLE receiver(
id INT PRIMARY KEY,
name VARCHAR(180) NOT NULL
);
INSERT INTO expenses VALUES(1,'2023-10-12', 1, 28.83),
(2,'2023-10-14', 2, 50.00), (3,'2023-10-15', 3, 74.80),
(4,'2023-10-16', 1, 16.34), (5,'2023-10-17', 4, 155.12),
(6,'2023-10-20', 4, 284.99);

INSERT INTO receiver VALUES(1, 'Гипермаркет "Евроопт"'),
(2, 'Оператор связи "А1"'),
 (3, 'Магазин "Санта"'),
 (4, 'Строительный магазин "Мамонт"'),
 (5, 'Розы.бел');