CREATE DATABASE  IF NOT EXISTS `spacecraft`;

USE `spacecraft`;

CREATE TABLE `location` (
  `locationId` int(5) NOT NULL,
  `locationName` varchar(100) DEFAULT NULL,
  `inUse` varchar(1) DEFAULT 'N',
  `thumbnail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`locationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `route` (
  `routeId` varchar(50) NOT NULL,
  `departure` int(5) NOT NULL,
  `destination` int(5) NOT NULL,
  `departingDay` varchar(25) NOT NULL,
  `leg1` int(5) DEFAULT NULL,
  `leg2` int(5) DEFAULT NULL,
  `leg3` int(5) DEFAULT NULL,
  `leg4` int(5) DEFAULT NULL,
  `entertainmentProvider` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`routeId`),
  KEY `fk_departure_idx` (`departure`),
  KEY `fk_destination_idx` (`destination`),
  CONSTRAINT `fk_departure` FOREIGN KEY (`departure`) REFERENCES `location` (`locationId`),
  CONSTRAINT `fk_destination` FOREIGN KEY (`destination`) REFERENCES `location` (`locationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `leg` (
  `legId` int(11) NOT NULL AUTO_INCREMENT,
  `departureId` int(5) NOT NULL,
  `destinationId` int(5) NOT NULL,
  PRIMARY KEY (`legId`),
  KEY `fk_leg_idx` (`departureId`),
  KEY `fk_destination_idx` (`destinationId`),
  KEY `fk_departure_idx` (`departureId`),
  KEY `fk_dest_idx` (`destinationId`),
  CONSTRAINT `fk_leg_dept` FOREIGN KEY (`departureId`) REFERENCES `location` (`locationId`),
  CONSTRAINT `fk_leg_dest` FOREIGN KEY (`destinationId`) REFERENCES `location` (`locationId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `location` VALUES (1,'Mercury','Y','mercury.png'),(2,'Venus','Y','venus.png'),(3,'Earth','Y','earth.png'),(4,'Luna','Y','luna.png'),(5,'Mars','Y','mars.png'),(6,'Phobos','N','phobes.png');

INSERT INTO `route` VALUES ('NXinS1',1,3,'Monday',1,2,NULL,NULL,''),('NXinS10',3,5,'Friday',3,10,11,NULL,''),('NXinS11',1,5,'Saturday',8,9,NULL,NULL,''),('NXinS12',2,1,'Saturday',14,NULL,NULL,NULL,'LastFm'),('NXinS13',3,2,'Saturday',3,15,NULL,NULL,''),('NXinS14',5,1,'Saturday',12,13,NULL,NULL,'LastFm'),('NXinS15',1,5,'Sunday',8,9,NULL,NULL,''),('NXinS16',2,3,'Sunday',2,NULL,NULL,NULL,''),('NXinS17',3,2,'Sunday',3,15,NULL,NULL,''),('NXinS18',5,2,'Sunday',5,16,NULL,NULL,''),('NXinS19',3,1,'Sunday',17,14,NULL,NULL,'LastFm'),('NXinS2',2,3,'Monday',2,NULL,NULL,NULL,''),('NXinS20',5,1,'Sunday',5,7,15,14,'LastFm'),('NXinS3',3,5,'Tuesday',3,4,NULL,NULL,''),('NXinS4',5,3,'Tuesday',5,7,6,NULL,''),('NXinS5',1,5,'Wednesday',8,9,NULL,NULL,''),('NXinS6',2,5,'Wednesday',2,3,4,NULL,''),('NXinS7',3,5,'Thursday',3,10,11,NULL,''),('NXinS8',5,1,'Thursday',12,13,NULL,NULL,'LastFm'),('NXinS9',3,5,'Friday',3,4,NULL,NULL,'');

INSERT INTO `leg` VALUES (1,1,2),(2,2,3),(3,3,4),(4,4,5),(5,5,6),(6,6,3),(7,6,4),(8,1,3),(9,3,5),(10,4,6),(11,6,5),(12,5,3),(13,3,1),(14,2,1),(15,4,2),(16,6,2),(17,3,2);



