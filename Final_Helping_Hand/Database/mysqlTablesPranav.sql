CREATE TABLE `pinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `itemName` varchar(45) NOT NULL,
  `itemType` varchar(45) NOT NULL,
  `cityName` varchar(45) NOT NULL,
  `pic` longblob NOT NULL,
  `info` varchar(255) NOT NULL,
  `received` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT 'null',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `userName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contact_no` varchar(10) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `address` varchar(255) DEFAULT 'Not Inserted',
  `profile_photo` longblob,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci