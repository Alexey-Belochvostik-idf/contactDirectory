CREATE TABLE `attachments` (
                               `id` float NOT NULL AUTO_INCREMENT,
                               `fileName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                               `dateOfDownload` datetime DEFAULT NULL,
                               `commit` varchar(100) DEFAULT NULL,
                               `contact_id` int DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               KEY `attachments_FK` (`contact_id`),
                               CONSTRAINT `attachments_FK` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3