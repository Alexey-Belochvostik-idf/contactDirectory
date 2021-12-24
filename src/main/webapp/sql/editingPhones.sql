CREATE TABLE `editingPhones` (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `codeOfCountry` int DEFAULT NULL,
                                 `codeOperation` int DEFAULT NULL,
                                 `phoneNumber` int DEFAULT NULL,
                                 `typePhone` enum('MOBILE','HOME') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                 `commit` varchar(25) DEFAULT NULL,
                                 `contact_id` int DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `editing_phones_FK` (`contact_id`),
                                 CONSTRAINT `editing_phones_FK` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3