-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.24-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for clinica
DROP DATABASE IF EXISTS `clinica`;
CREATE DATABASE IF NOT EXISTS `clinica` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `clinica`;

-- Dumping structure for table clinica.citas
DROP TABLE IF EXISTS `citas`;
CREATE TABLE IF NOT EXISTS `citas` (
  `IDCITAS` int(11) NOT NULL,
  `IDHORARIO` int(11) DEFAULT NULL,
  `IDPERSONA` int(11) DEFAULT NULL,
  `FECHACITA` date DEFAULT NULL,
  `FECHAHORACITAINI` datetime DEFAULT NULL,
  `FECHAHORACITAFIN` datetime DEFAULT NULL,
  `ESTADOCITA` int(11) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDCITAS`),
  KEY `FK_REFERENCE_5` (`IDHORARIO`),
  KEY `FK_REFERENCE_6` (`IDPERSONA`),
  CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`IDHORARIO`) REFERENCES `horario` (`IDHORARIO`),
  CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`IDPERSONA`) REFERENCES `persona` (`IDPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.citas: ~0 rows (approximately)
DELETE FROM `citas`;

-- Dumping structure for table clinica.especialidad
DROP TABLE IF EXISTS `especialidad`;
CREATE TABLE IF NOT EXISTS `especialidad` (
  `IDESPECIALIDAD` int(11) NOT NULL,
  `CODIGO` varchar(15) DEFAULT NULL,
  `DESCRIPCION` varchar(15) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDESPECIALIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.especialidad: ~0 rows (approximately)
DELETE FROM `especialidad`;

-- Dumping structure for table clinica.horario
DROP TABLE IF EXISTS `horario`;
CREATE TABLE IF NOT EXISTS `horario` (
  `IDHORARIO` int(11) NOT NULL,
  `IDPERSONA` int(11) DEFAULT NULL,
  `IDESPECIALIDAD` int(11) DEFAULT NULL,
  `FECHAHORARIO` date DEFAULT NULL,
  `FECHAHORAINICIO` datetime DEFAULT NULL,
  `FECHAHORAFIN` datetime DEFAULT NULL,
  `TIPOHORARIO` varchar(15) DEFAULT NULL,
  `COMENTARIOS` varchar(30) DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDHORARIO`),
  KEY `FK_REFERENCE_4` (`IDPERSONA`,`IDESPECIALIDAD`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`IDPERSONA`, `IDESPECIALIDAD`) REFERENCES `medico` (`IDPERSONA`, `IDESPECIALIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.horario: ~0 rows (approximately)
DELETE FROM `horario`;

-- Dumping structure for table clinica.medico
DROP TABLE IF EXISTS `medico`;
CREATE TABLE IF NOT EXISTS `medico` (
  `IDPERSONA` int(11) NOT NULL,
  `IDESPECIALIDAD` int(11) NOT NULL,
  `TIPOPERSONA` varchar(15) DEFAULT NULL,
  `CODIGOMEDICO` varchar(15) DEFAULT NULL,
  `FECHAINGRESO` date DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPERSONA`,`IDESPECIALIDAD`),
  KEY `FK_REFERENCE_3` (`IDESPECIALIDAD`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`IDPERSONA`) REFERENCES `persona` (`IDPERSONA`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`IDESPECIALIDAD`) REFERENCES `especialidad` (`IDESPECIALIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.medico: ~0 rows (approximately)
DELETE FROM `medico`;

-- Dumping structure for table clinica.persona
DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `IDPERSONA` int(11) NOT NULL,
  `TIPODOCUMENTO` varchar(15) DEFAULT NULL,
  `DOCUMENTO` varchar(15) DEFAULT NULL,
  `APELLIDOSPATERNO` varchar(50) DEFAULT NULL,
  `APELLIDOSMATERNO` varchar(50) DEFAULT NULL,
  `NOMBRES` varchar(50) DEFAULT NULL,
  `NOMBRECOMPLETO` varchar(150) DEFAULT NULL,
  `FECHANACIMIENTO` date DEFAULT NULL,
  `SEXO` varchar(1) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ESPACIENTE` int(11) DEFAULT NULL,
  `ESPERSONA` int(11) DEFAULT NULL,
  `ESMEDICO` int(11) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.persona: ~0 rows (approximately)
DELETE FROM `persona`;

-- Dumping structure for table clinica.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `IDPERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIO` varchar(15) NOT NULL,
  `PASSWORD` varchar(25) NOT NULL,
  `TIPOUSUARIO` varchar(20) NOT NULL,
  `FECHA` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ESTADO` int(11) NOT NULL,
  PRIMARY KEY (`IDPERSONA`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.usuario: ~18 rows (approximately)
DELETE FROM `usuario`;
INSERT INTO `usuario` (`IDPERSONA`, `USUARIO`, `PASSWORD`, `TIPOUSUARIO`, `FECHA`, `ESTADO`) VALUES
	(1, 'administrador', '123', 'admin', '2022-04-30 15:10:31', 0),
	(20, 'gladys', 'nuevopass', 'soporte', '2022-04-30 15:39:09', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
