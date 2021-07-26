CREATE TABLE PARTICIPANT (
	id INTEGER PRIMARY KEY, 
	firstName VARCHAR(255),
	lastName VARCHAR(255),
	exp VARCHAR(255),
	selectionCount INTEGER,
	lastSelectionDate DATE
);

INSERT INTO PARTICIPANT (id, firstName, exp) VALUES(1, 'Arthur', 'senior');
INSERT INTO PARTICIPANT (id, firstName, exp) VALUES(2, 'Thomas', 'senior');
INSERT INTO PARTICIPANT (id, firstName, exp) VALUES(4, 'Christelle', '');

INSERT INTO PARTICIPANT (id, firstName, exp) VALUES(3, 'Wara', 'junior');
