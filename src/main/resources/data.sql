
CREATE TABLE vehicle(
	vehicleId INT NOT NULL,  
  	make VARCHAR(64),
  	model VARCHAR(128),
  	derivative VARCHAR(255),
  	PRIMARY KEY(vehicleId)
);


INSERT INTO vehicle VALUES(1000,'Volkswagen','Golf','1.5 TSI EVO Match Edition 5dr');