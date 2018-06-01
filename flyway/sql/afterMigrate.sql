create table USERS (
    ID serial,
    USERNAME varchar(40),
    PASSWORD varchar(25) NOT NULL,
    FILTERS varchar(20) NOT NULL
);

INSERT INTO USERS
	(USERNAME, PASSWORD, FILTERS)
VALUES
	('userfromseeds', 'password1', '101010100010011'),
	('anotheruser', 'password2', '010101010101010'),
	('someone', 'password3', '101010101010101'),
	('someoneelse', 'password4', '101010110011001');