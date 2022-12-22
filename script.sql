CREATE TABLE Patients(
      id serial primary key,
      name varchar(255),
      male boolean,
      age integer
);

INSERT INTO Patients (name, male, age) values ('Pavel', true, 30);
UPDATE Patients set age = 40;
DELETE FROM Patients;