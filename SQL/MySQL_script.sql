create database juegosdb;
use juegosdb;

CREATE TABLE `juego` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `plataforma` varchar(45) NOT NULL,
  `fabricante` varchar(45),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1