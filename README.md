REATE DATABASE  IF NOT EXISTS customer_directory;
USE customer_directory;

--
-- Table structure for table employee
--

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (

  username varchar(45) NOT NULL,
  password varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (username)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table employee
--

INSERT INTO customer VALUES 
	('namhehe','thanhnam','nam@gmail.com')
