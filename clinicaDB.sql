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

-- Dumping structure for table clinica.cita
DROP TABLE IF EXISTS `cita`;
CREATE TABLE IF NOT EXISTS `cita` (
  `IDCITA` int(11) NOT NULL AUTO_INCREMENT,
  `IDHORARIO` int(11) DEFAULT NULL,
  `IDPERSONA` int(11) DEFAULT NULL,
  `FECHAHORACITAINI` datetime DEFAULT NULL,
  `FECHAHORACITAFIN` datetime DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDCITA`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.cita: ~5 rows (approximately)
DELETE FROM `cita`;
INSERT INTO `cita` (`IDCITA`, `IDHORARIO`, `IDPERSONA`, `FECHAHORACITAINI`, `FECHAHORACITAFIN`, `FECHA`, `ESTADO`) VALUES
	(1, 2, 3, '2022-05-21 11:53:29', '2022-05-21 11:53:29', '2022-05-21', 1),
	(3, 4, 24, '2022-05-21 08:19:02', '2022-05-21 08:19:02', '2022-05-21', 1),
	(4, 4, 7, '2022-05-21 08:20:52', '2022-05-21 08:20:52', '2022-05-21', 1),
	(5, 3, 7, '2022-05-21 08:21:57', '2022-05-21 08:21:57', '2022-05-21', 1),
	(6, 4, 3, '2022-05-21 16:42:49', '2022-05-21 16:42:49', '2022-05-21', 1);

-- Dumping structure for table clinica.especialidad
DROP TABLE IF EXISTS `especialidad`;
CREATE TABLE IF NOT EXISTS `especialidad` (
  `IDESPECIALIDAD` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(15) DEFAULT NULL,
  `DESCRIPCION` varchar(50) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDESPECIALIDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.especialidad: ~6 rows (approximately)
DELETE FROM `especialidad`;
INSERT INTO `especialidad` (`IDESPECIALIDAD`, `CODIGO`, `DESCRIPCION`, `FECHA`, `ESTADO`) VALUES
	(2, '00002', 'Psiquiatría', '2022-05-21', 1),
	(3, '00003', 'Radiología', '2022-05-01', 1),
	(4, '00004', 'Medicina General', '2022-05-01', 0),
	(7, '00006', 'Pediatría', '2022-05-03', 1),
	(8, '00003', 'Psicología', '2022-05-03', 1),
	(10, '00006', 'Neurología', '2022-05-03', 1);

-- Dumping structure for table clinica.horario
DROP TABLE IF EXISTS `horario`;
CREATE TABLE IF NOT EXISTS `horario` (
  `IDHORARIO` int(11) NOT NULL AUTO_INCREMENT,
  `IDPERSONA` int(11) DEFAULT NULL,
  `IDESPECIALIDAD` int(11) DEFAULT NULL,
  `FECHAHORAINICIO` datetime DEFAULT NULL,
  `FECHAHORAFIN` datetime DEFAULT NULL,
  `TIPOHORARIO` varchar(15) DEFAULT NULL,
  `COMENTARIOS` varchar(30) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDHORARIO`),
  KEY `FK_REFERENCE_4` (`IDPERSONA`,`IDESPECIALIDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.horario: ~3 rows (approximately)
DELETE FROM `horario`;
INSERT INTO `horario` (`IDHORARIO`, `IDPERSONA`, `IDESPECIALIDAD`, `FECHAHORAINICIO`, `FECHAHORAFIN`, `TIPOHORARIO`, `COMENTARIOS`, `FECHA`, `ESTADO`) VALUES
	(1, 4, 5, '2022-05-01 23:29:51', '2022-05-01 23:29:51', '4', 'comentario1', '2022-05-01', 1),
	(3, 7, 5, '2022-05-01 23:40:46', '2022-05-01 23:40:46', '8', 'horario2', '2022-05-01', 0),
	(4, 4, 4, '2022-05-21 08:17:59', '2022-05-21 08:17:59', '2', 'ss', '2022-05-21', 1);

-- Dumping structure for table clinica.log
DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `IDLOG` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(50) DEFAULT NULL,
  `REMOTEADDR` varchar(50) DEFAULT NULL,
  `REMOTEHOST` varchar(50) DEFAULT NULL,
  `X-FORWARDED-FOR` varchar(50) DEFAULT NULL,
  `ACCION` varchar(50) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `FECHAREG` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`IDLOG`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.log: ~0 rows (approximately)
DELETE FROM `log`;

-- Dumping structure for table clinica.medico
DROP TABLE IF EXISTS `medico`;
CREATE TABLE IF NOT EXISTS `medico` (
  `IDPERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `IDESPECIALIDAD` int(11) DEFAULT NULL,
  `TIPOPERSONA` varchar(15) DEFAULT NULL,
  `CODIGOMEDICO` varchar(15) DEFAULT NULL,
  `FECHAINGRESO` date DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPERSONA`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.medico: ~3 rows (approximately)
DELETE FROM `medico`;
INSERT INTO `medico` (`IDPERSONA`, `IDESPECIALIDAD`, `TIPOPERSONA`, `CODIGOMEDICO`, `FECHAINGRESO`, `FECHA`, `ESTADO`) VALUES
	(2, 2, '21543534245', '2022-04-30', '2022-04-30', '2022-04-30', 1),
	(4, 1, '2', '12345678', '2022-05-19', '2022-05-19', 1),
	(6, 7, '34', 'Pediatría', '2022-05-19', '2022-05-19', 0);

-- Dumping structure for table clinica.persona
DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `IDPERSONA` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.persona: ~3 rows (approximately)
DELETE FROM `persona`;
INSERT INTO `persona` (`IDPERSONA`, `TIPODOCUMENTO`, `DOCUMENTO`, `APELLIDOSPATERNO`, `APELLIDOSMATERNO`, `NOMBRES`, `NOMBRECOMPLETO`, `FECHANACIMIENTO`, `SEXO`, `EMAIL`, `ESPACIENTE`, `ESPERSONA`, `ESMEDICO`, `FECHA`, `ESTADO`) VALUES
	(6, '1', '234343242', 'Musk', 'Axión', 'Elon', '  ', '2022-05-01', 'M', 'elon@twitter.com', 1, 0, 1, '2022-05-03', 1),
	(7, '2', '10297892', 'Gates', 'Windows', 'Bill', 'Bill Gates Windows', '2022-05-01', 'F', 'bill@microsoft.com', 1, 0, 1, '2022-05-19', 1),
	(8, 'DNI', '40405555', 'Farfan', 'Maldonado', 'Luciana', 'Luciana Farfan Maldonado', '2022-05-21', 'F', 'luciana.farfan@gmail.com', 1, 1, 1, '2022-05-21', 1);

-- Dumping structure for table clinica.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `IDPERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIO` varchar(15) DEFAULT NULL,
  `PASSWORD` varchar(25) DEFAULT NULL,
  `TIPOUSUARIO` varchar(20) DEFAULT NULL,
  `FECHA` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPERSONA`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table clinica.usuario: ~5 rows (approximately)
DELETE FROM `usuario`;
INSERT INTO `usuario` (`IDPERSONA`, `USUARIO`, `PASSWORD`, `TIPOUSUARIO`, `FECHA`, `ESTADO`) VALUES
	(1, 'administrador', '5ertye5ytyr', 'admin', '2022-04-30 20:30:59', 0),
	(23, 'tcayo', '1234', 'admin', '2022-04-30 19:55:18', 1),
	(26, 'prueba1', '111111', 'visitante', '2022-04-30 21:19:39', 1),
	(27, 'admin', '1234', 'soporte', '2022-05-20 00:23:25', 1),
	(33, 'pamela', '12345', 'paciente', '2022-05-21 07:37:54', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
