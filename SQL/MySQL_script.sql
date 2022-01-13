create database juegosdb;
use juegosdb;

CREATE TABLE `juego` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha` int(5) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `editor` varchar(45) NOT NULL,
  `eu_sales` decimal(4,2) NOT NULL,
  `plataforma` varchar(45) NOT NULL,
  `fabricante` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1