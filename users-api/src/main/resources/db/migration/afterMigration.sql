create table USERS (
  ID serial,
  EMAIL varchar(40) NOT NULL,
  PASSWORD varchar(25) NOT NULL,
  FILTERS varchar(20) NOT NULL
);

INSERT INTO USERS
(EMAIL, PASSWORD, FILTERS)
VALUES
('userfromseeds@xyz.com', 'password1', '101010100010011'),
('anotheruser@xyz.com', 'password2', '010101010101010'),
('someone@xyz.com', 'password3', '101010101010101'),
('someoneelse@xyz.com', 'password4', '101010110011001');