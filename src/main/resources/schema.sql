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


