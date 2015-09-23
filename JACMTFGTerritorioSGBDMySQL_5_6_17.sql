# --------------------------------------------------------
# Host:                         localhost
# Server version:               5.6.17
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2015-09-22 21:36:31
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for territorio
CREATE DATABASE IF NOT EXISTS `territorio` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `territorio`;


# Dumping structure for table territorio.calle
CREATE TABLE IF NOT EXISTS `calle` (
  `idCalle` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `codCatastro` int(11) DEFAULT NULL,
  `codHacienda` int(11) DEFAULT NULL,
  `codINE` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `fAltaSistema` datetime DEFAULT NULL,
  `fAprobacion` datetime DEFAULT NULL,
  `nombre` varchar(25) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombreLargo` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `particula` varchar(6) COLLATE latin1_spanish_ci DEFAULT NULL,
  `refTipoVia` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCalle`),
  KEY `FK5A0D1C7A235A5CD` (`refTipoVia`),
  CONSTRAINT `FK5A0D1C7A235A5CD` FOREIGN KEY (`refTipoVia`) REFERENCES `tipovia` (`idTipoVia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.calle: ~1 rows (approximately)
DELETE FROM `calle`;
/*!40000 ALTER TABLE `calle` DISABLE KEYS */;
INSERT INTO `calle` (`idCalle`, `fechaModificacion`, `numMunicipio`, `uControl`, `codCatastro`, `codHacienda`, `codINE`, `estado`, `fAltaSistema`, `fAprobacion`, `nombre`, `nombreLargo`, `particula`, `refTipoVia`) VALUES
	(31, '2015-09-22 20:34:19', 1, 'prueba', NULL, NULL, NULL, 0, '2015-09-22 00:00:00', NULL, 'Hungria', 'CL  Hungria', '', 18);
/*!40000 ALTER TABLE `calle` ENABLE KEYS */;


# Dumping structure for table territorio.capaelemterri
CREATE TABLE IF NOT EXISTS `capaelemterri` (
  `idCapa` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(80) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCapa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.capaelemterri: ~0 rows (approximately)
DELETE FROM `capaelemterri`;
/*!40000 ALTER TABLE `capaelemterri` DISABLE KEYS */;
INSERT INTO `capaelemterri` (`idCapa`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `estado`, `nivel`) VALUES
	(1, NULL, NULL, NULL, 'Parcela', 0, 1),
	(2, '2015-09-04 20:54:24', 1, 'admin', 'Inmueble', 0, 3),
	(3, '2015-09-04 20:54:01', 1, 'admin', 'Municipio', 0, 0),
	(4, '2015-09-04 20:54:42', 1, 'admin', 'Viales', 0, 1),
	(5, '2015-09-04 20:55:20', 1, 'admin', 'Construcción', 0, 2),
	(6, '2015-09-04 21:12:50', 1, 'admin', 'Mobiliario Urbano', 0, 2),
	(7, '2015-09-04 21:14:55', 1, 'admin', 'Árboleda', 0, 2);
/*!40000 ALTER TABLE `capaelemterri` ENABLE KEYS */;


# Dumping structure for table territorio.direccion
CREATE TABLE IF NOT EXISTS `direccion` (
  `idDireccion` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `bloque` varchar(5) COLLATE latin1_spanish_ci DEFAULT NULL,
  `codPostal` varchar(5) COLLATE latin1_spanish_ci DEFAULT NULL,
  `direcLarga` varchar(90) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `fAltaSistema` datetime DEFAULT NULL,
  `letra` varchar(3) COLLATE latin1_spanish_ci DEFAULT NULL,
  `letraAnterior` varchar(3) COLLATE latin1_spanish_ci DEFAULT NULL,
  `numAnterior` int(11) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `puntokm` int(11) DEFAULT NULL,
  `refCalle` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDireccion`),
  KEY `FKC6984D3084874B07` (`refCalle`),
  CONSTRAINT `FKC6984D3084874B07` FOREIGN KEY (`refCalle`) REFERENCES `calle` (`idCalle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.direccion: ~0 rows (approximately)
DELETE FROM `direccion`;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` (`idDireccion`, `fechaModificacion`, `numMunicipio`, `uControl`, `bloque`, `codPostal`, `direcLarga`, `estado`, `fAltaSistema`, `letra`, `letraAnterior`, `numAnterior`, `numero`, `puntokm`, `refCalle`) VALUES
	(20, '2015-09-22 20:37:43', 1, 'prueba', '', '28956', 'CL  Hungria  1 ', 0, '2015-09-22 00:00:00', '', '', NULL, 1, NULL, 31);
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;


# Dumping structure for table territorio.domicilio
CREATE TABLE IF NOT EXISTS `domicilio` (
  `idDomicilio` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `domicLargo` varchar(200) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `numGaraje` int(11) DEFAULT NULL,
  `numTrastero` int(11) DEFAULT NULL,
  `refCalle` int(11) DEFAULT NULL,
  `refDireccion` int(11) DEFAULT NULL,
  `refEscalera` int(11) DEFAULT NULL,
  `refLocal` int(11) DEFAULT NULL,
  `refPlanta` int(11) DEFAULT NULL,
  `refPortal` int(11) DEFAULT NULL,
  `refPuerta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDomicilio`),
  KEY `FK34365965CB46CA7` (`refPlanta`),
  KEY `FK34365965DB5D4B9` (`refPuerta`),
  KEY `FK343659658C5E0D7B` (`refLocal`),
  KEY `FK3436596513F3DD59` (`refDireccion`),
  KEY `FK34365965ADE73523` (`refEscalera`),
  KEY `FK34365965D1896D3` (`refPortal`),
  CONSTRAINT `FK3436596513F3DD59` FOREIGN KEY (`refDireccion`) REFERENCES `direccion` (`idDireccion`),
  CONSTRAINT `FK343659658C5E0D7B` FOREIGN KEY (`refLocal`) REFERENCES `tipolocal` (`idLocal`),
  CONSTRAINT `FK34365965ADE73523` FOREIGN KEY (`refEscalera`) REFERENCES `tipoescalera` (`idEscalera`),
  CONSTRAINT `FK34365965CB46CA7` FOREIGN KEY (`refPlanta`) REFERENCES `tipoplanta` (`idPlanta`),
  CONSTRAINT `FK34365965D1896D3` FOREIGN KEY (`refPortal`) REFERENCES `tipoportal` (`idPortal`),
  CONSTRAINT `FK34365965DB5D4B9` FOREIGN KEY (`refPuerta`) REFERENCES `tipopuerta` (`idPuerta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.domicilio: ~0 rows (approximately)
DELETE FROM `domicilio`;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` (`idDomicilio`, `fechaModificacion`, `numMunicipio`, `uControl`, `domicLargo`, `estado`, `numGaraje`, `numTrastero`, `refCalle`, `refDireccion`, `refEscalera`, `refLocal`, `refPlanta`, `refPortal`, `refPuerta`) VALUES
	(54, '2015-09-22 20:52:42', 1, 'prueba', 'CL  Hungria  1   Portal: A', 0, NULL, NULL, NULL, 20, NULL, NULL, NULL, 8, NULL);
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;


# Dumping structure for table territorio.elemterri
CREATE TABLE IF NOT EXISTS `elemterri` (
  `idElemterri` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `coordenadax` bigint(20) DEFAULT NULL,
  `coordenaday` bigint(20) DEFAULT NULL,
  `descripcion` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `domicilioPostal` longtext COLLATE latin1_spanish_ci,
  `estado` int(11) DEFAULT NULL,
  `inscripRegistral` varchar(80) COLLATE latin1_spanish_ci DEFAULT NULL,
  `localizacion` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `observaciones` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `refCalle` int(11) DEFAULT NULL,
  `refDireccion` int(11) DEFAULT NULL,
  `refDomicilio` int(11) DEFAULT NULL,
  `refElemenComun` int(11) DEFAULT NULL,
  `refElemenPadre` int(11) DEFAULT NULL,
  `refTipoElemTerri` int(11) DEFAULT NULL,
  PRIMARY KEY (`idElemterri`),
  KEY `FK6715CFA9DC52C1E4` (`refElemenComun`),
  KEY `FK6715CFA9DD037410` (`refElemenPadre`),
  KEY `FK6715CFA9BC79CA3` (`refTipoElemTerri`),
  KEY `FK6715CFA9EF2FF5C3` (`refDomicilio`),
  KEY `FK6715CFA913F3DD59` (`refDireccion`),
  KEY `FK6715CFA984874B07` (`refCalle`),
  CONSTRAINT `FK6715CFA913F3DD59` FOREIGN KEY (`refDireccion`) REFERENCES `direccion` (`idDireccion`),
  CONSTRAINT `FK6715CFA984874B07` FOREIGN KEY (`refCalle`) REFERENCES `calle` (`idCalle`),
  CONSTRAINT `FK6715CFA9BC79CA3` FOREIGN KEY (`refTipoElemTerri`) REFERENCES `tipoelemterri` (`idTipoElemTerri`),
  CONSTRAINT `FK6715CFA9DC52C1E4` FOREIGN KEY (`refElemenComun`) REFERENCES `elemterri` (`idElemterri`),
  CONSTRAINT `FK6715CFA9DD037410` FOREIGN KEY (`refElemenPadre`) REFERENCES `elemterri` (`idElemterri`),
  CONSTRAINT `FK6715CFA9EF2FF5C3` FOREIGN KEY (`refDomicilio`) REFERENCES `domicilio` (`idDomicilio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.elemterri: ~1 rows (approximately)
DELETE FROM `elemterri`;
/*!40000 ALTER TABLE `elemterri` DISABLE KEYS */;
/*!40000 ALTER TABLE `elemterri` ENABLE KEYS */;


# Dumping structure for table territorio.images
CREATE TABLE IF NOT EXISTS `images` (
  `ID` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `GALLERY` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `IMAGE` tinyblob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.images: ~0 rows (approximately)
DELETE FROM `images`;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
/*!40000 ALTER TABLE `images` ENABLE KEYS */;


# Dumping structure for table territorio.municipio
CREATE TABLE IF NOT EXISTS `municipio` (
  `idMunicipio` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `codMunicipio` int(11) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `domicilio` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre` varchar(25) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombreLargo` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `provincia` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono` varchar(10) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idMunicipio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.municipio: ~2 rows (approximately)
DELETE FROM `municipio`;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` (`idMunicipio`, `fechaModificacion`, `numMunicipio`, `uControl`, `codMunicipio`, `codPostal`, `domicilio`, `nombre`, `nombreLargo`, `provincia`, `telefono`) VALUES
	(1, '2015-09-22 00:55:35', 1, '123456789', 28940, 28584, 'C/ Hungria, nº 1', 'Prueba', 'Prueba', 'Madrid', '912458713');
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;


# Dumping structure for table territorio.secuencias
CREATE TABLE IF NOT EXISTS `secuencias` (
  `secuencia` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `valor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.secuencias: ~17 rows (approximately)
DELETE FROM `secuencias`;
/*!40000 ALTER TABLE `secuencias` DISABLE KEYS */;
INSERT INTO `secuencias` (`secuencia`, `valor`) VALUES
	('idMunicipio', 6),
	('idUsuario', 16),
	('idMenu', 4),
	('idPerfil', 4),
	('idMenuItem', 22),
	('idTipoVia', 20),
	('idCalle', 32),
	('idDireccion', 21),
	('idPortal', 9),
	('idEscalera', 11),
	('idPlanta', 8),
	('idPuerta', 8),
	('idLocal', 11),
	('idDomicilio', 55),
	('idCapa', 8),
	('idTipoElemTerri', 14),
	('idElemterri', 27);
/*!40000 ALTER TABLE `secuencias` ENABLE KEYS */;


# Dumping structure for table territorio.seg_menu
CREATE TABLE IF NOT EXISTS `seg_menu` (
  `idMenu` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.seg_menu: ~1 rows (approximately)
DELETE FROM `seg_menu`;
/*!40000 ALTER TABLE `seg_menu` DISABLE KEYS */;
INSERT INTO `seg_menu` (`idMenu`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`) VALUES
	(1, NULL, NULL, 'admin', 'Administrador'),
	(2, NULL, NULL, 'admin', 'Gestor'),
	(3, NULL, NULL, 'admin', 'Consulta');
/*!40000 ALTER TABLE `seg_menu` ENABLE KEYS */;


# Dumping structure for table territorio.seg_menuitem
CREATE TABLE IF NOT EXISTS `seg_menuitem` (
  `idMenuItem` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `etiqueta` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `path` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `url` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idMenu` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMenuItem`),
  KEY `FK5E064D9C42B200AD` (`idMenu`),
  CONSTRAINT `FK5E064D9C42B200AD` FOREIGN KEY (`idMenu`) REFERENCES `seg_menu` (`idMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.seg_menuitem: ~21 rows (approximately)
DELETE FROM `seg_menuitem`;
/*!40000 ALTER TABLE `seg_menuitem` DISABLE KEYS */;
INSERT INTO `seg_menuitem` (`idMenuItem`, `fechaModificacion`, `numMunicipio`, `uControl`, `etiqueta`, `orden`, `path`, `url`, `idMenu`) VALUES
	(1, '2015-08-22 19:41:34', NULL, NULL, 'Municipios', 290, NULL, 'modules/Municipio', 1),
	(2, '2015-07-29 13:23:57', NULL, 'admin', 'Vias', 200, NULL, NULL, 1),
	(3, '2015-07-29 13:24:49', NULL, 'admin', 'Usuarios', 300, NULL, 'modules/Usuario', 1),
	(4, '2015-08-23 11:43:16', NULL, NULL, 'Privilegios de Acceso', 400, NULL, NULL, 1),
	(5, '2015-08-23 11:46:20', NULL, NULL, 'Menu', 40, '/4', 'modules/Menu', 1),
	(6, '2015-08-23 11:46:03', NULL, NULL, 'Opciones', 20, '/4', 'modules/MenuItem', 1),
	(7, '2015-07-29 13:29:43', NULL, 'admin', 'Perfil', 30, '/4', 'modules/Perfil', 1),
	(8, '2015-08-21 21:06:03', NULL, NULL, 'Tipo Vía', 50, '/2', 'modules/TipoVia', 1),
	(9, '2015-08-21 21:08:22', NULL, NULL, 'Vías', 20, '/2', 'modules/Calle', 1),
	(10, '2015-08-21 22:18:19', NULL, NULL, 'Direcciones', 210, NULL, 'modules/Direccion', 1),
	(12, '2015-08-22 19:46:35', NULL, NULL, 'Domicilios', 250, NULL, NULL, 1),
	(13, '2015-08-22 19:52:25', NULL, NULL, 'Domicillios', 10, '/12', 'modules/Domicilio', 1),
	(14, '2015-08-22 22:14:43', NULL, NULL, 'Portales', 30, '/12', 'modules/TipoPortal', 1),
	(15, '2015-08-22 22:10:06', NULL, NULL, 'Escaleras', 40, '/12', 'modules/TipoEscalera', 1),
	(16, '2015-08-22 22:11:18', NULL, NULL, 'Plantas', 50, '/12', 'modules/TipoPlanta', 1),
	(17, '2015-08-22 22:13:31', NULL, NULL, 'Puertas', 60, '/12', 'modules/TipoPuerta', 1),
	(18, '2015-08-22 22:14:33', NULL, NULL, 'Locales', 70, '/12', 'modules/TipoLocal', 1),
	(19, '2015-08-23 11:12:15', NULL, NULL, 'Elementos del Territorio', 270, NULL, NULL, 1),
	(20, '2015-08-23 11:17:24', NULL, NULL, 'Elementos del Territorio', 10, '/19', 'modules/ElemTerri', 1),
	(21, '2015-08-23 11:19:48', NULL, NULL, 'Tipos de Elementos del Territorio', 20, '/19', 'modules/TipoElemTerri', 1),
	(22, '2015-08-23 11:23:13', NULL, NULL, 'Capas de Elementos del Territorio', 30, '/19', 'modules/CapaElemTerri', 1),
	(23, '2015-09-18 00:25:06', 1, NULL, 'Elemento del Territorio', 10, NULL, 'modules/ElemTerri', 3),
	(24, NULL, 1, NULL, 'Vias', 100, NULL, 'modules/Calle', 2),
	(25, NULL, 1, NULL, 'Direcciones', 200, NULL, 'modules/Direccion', 2),
	(26, NULL, 1, NULL, 'Domicilios', 300, NULL, 'modules/Domicilio', 2),
	(27, '2015-09-18 00:43:45', 1, NULL, 'Elemento del Territorio', 400, NULL, 'modules/ElemTerri', 2);
/*!40000 ALTER TABLE `seg_menuitem` ENABLE KEYS */;


# Dumping structure for table territorio.seg_perfil
CREATE TABLE IF NOT EXISTS `seg_perfil` (
  `idPerfil` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idMenu` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPerfil`),
  KEY `FK6DEA10F642B200AD` (`idMenu`),
  CONSTRAINT `FK6DEA10F642B200AD` FOREIGN KEY (`idMenu`) REFERENCES `seg_menu` (`idMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.seg_perfil: ~1 rows (approximately)
DELETE FROM `seg_perfil`;
/*!40000 ALTER TABLE `seg_perfil` DISABLE KEYS */;
INSERT INTO `seg_perfil` (`idPerfil`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `idMenu`) VALUES
	(11, NULL, NULL, 'admin', 'Administrador', 1),
	(12, NULL, NULL, 'admin', 'Gestor', 2),
	(14, NULL, NULL, 'admin', 'Consulta', 3);
/*!40000 ALTER TABLE `seg_perfil` ENABLE KEYS */;


# Dumping structure for table territorio.tipoelemterri
CREATE TABLE IF NOT EXISTS `tipoelemterri` (
  `idTipoElemTerri` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `observaciones` varchar(80) COLLATE latin1_spanish_ci DEFAULT NULL,
  `refCapaElemTerri` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTipoElemTerri`),
  KEY `FKE1D706D52B3E0A2D` (`refCapaElemTerri`),
  CONSTRAINT `FKE1D706D52B3E0A2D` FOREIGN KEY (`refCapaElemTerri`) REFERENCES `capaelemterri` (`idCapa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.tipoelemterri: ~0 rows (approximately)
DELETE FROM `tipoelemterri`;
/*!40000 ALTER TABLE `tipoelemterri` DISABLE KEYS */;
INSERT INTO `tipoelemterri` (`idTipoElemTerri`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `estado`, `observaciones`, `refCapaElemTerri`) VALUES
	(1, '2015-09-17 22:33:22', 1, 'admin', 'Parcela Urbana', 0, 'Parcela sin uso', 1),
	(2, '2015-09-05 14:11:57', 1, 'admin', 'Bloque de Viviendas', 0, 'Viviendas Unifamiliares', 5),
	(3, '2015-09-04 21:00:30', 1, 'admin', 'Municipio', 0, '', 3),
	(4, '2015-09-04 21:01:08', 1, 'admin', 'Vias', 0, '', 4),
	(5, '2015-09-04 21:02:32', 1, 'admin', 'Vivienda Unifamiliar', 0, '', 2),
	(6, '2015-09-04 21:02:45', 1, 'admin', 'Oficina', 0, '', 2),
	(7, '2015-09-04 21:02:55', 1, 'admin', 'Trastero', 0, '', 2),
	(8, '2015-09-04 21:03:06', 1, 'admin', 'Garaje', 0, '', 2),
	(9, '2015-09-04 21:13:30', 1, 'admin', 'Semáforo', 0, '', 6),
	(10, '2015-09-04 21:14:17', 1, 'admin', 'Columpio', 0, '', 6),
	(11, '2015-09-04 21:15:28', 1, 'admin', 'Árboles', 0, '', 7);
/*!40000 ALTER TABLE `tipoelemterri` ENABLE KEYS */;


# Dumping structure for table territorio.tipoescalera
CREATE TABLE IF NOT EXISTS `tipoescalera` (
  `idEscalera` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `escalera` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `escaleraCatastro` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `escaleraHacienda` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `escaleraINE` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEscalera`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.tipoescalera: ~0 rows (approximately)
DELETE FROM `tipoescalera`;
/*!40000 ALTER TABLE `tipoescalera` DISABLE KEYS */;
INSERT INTO `tipoescalera` (`idEscalera`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `escalera`, `escaleraCatastro`, `escaleraHacienda`, `escaleraINE`, `estado`) VALUES
	(10, '2015-09-22 21:19:45', 1, 'prueba', 'Escalera A', 'A', '', '', '', 0);
/*!40000 ALTER TABLE `tipoescalera` ENABLE KEYS */;


# Dumping structure for table territorio.tipolocal
CREATE TABLE IF NOT EXISTS `tipolocal` (
  `idLocal` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `local` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `localCatastro` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `localHacienda` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `localINE` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.tipolocal: ~0 rows (approximately)
DELETE FROM `tipolocal`;
/*!40000 ALTER TABLE `tipolocal` DISABLE KEYS */;
INSERT INTO `tipolocal` (`idLocal`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `estado`, `local`, `localCatastro`, `localHacienda`, `localINE`) VALUES
	(10, '2015-09-22 21:20:31', 1, 'prueba', 'Local A', 0, 'A', '', '', '');
/*!40000 ALTER TABLE `tipolocal` ENABLE KEYS */;


# Dumping structure for table territorio.tipoplanta
CREATE TABLE IF NOT EXISTS `tipoplanta` (
  `idPlanta` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `planta` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `plantaCatastro` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `plantaHacienda` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `plantaINE` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idPlanta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.tipoplanta: ~0 rows (approximately)
DELETE FROM `tipoplanta`;
/*!40000 ALTER TABLE `tipoplanta` DISABLE KEYS */;
INSERT INTO `tipoplanta` (`idPlanta`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `estado`, `planta`, `plantaCatastro`, `plantaHacienda`, `plantaINE`) VALUES
	(7, '2015-09-22 21:19:58', 1, 'prueba', 'Planta 1', 0, '1', '', '', '');
/*!40000 ALTER TABLE `tipoplanta` ENABLE KEYS */;


# Dumping structure for table territorio.tipoportal
CREATE TABLE IF NOT EXISTS `tipoportal` (
  `idPortal` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `portal` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `portalCatastro` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `portalHacienda` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `portalINE` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idPortal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.tipoportal: ~1 rows (approximately)
DELETE FROM `tipoportal`;
/*!40000 ALTER TABLE `tipoportal` DISABLE KEYS */;
INSERT INTO `tipoportal` (`idPortal`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `estado`, `portal`, `portalCatastro`, `portalHacienda`, `portalINE`) VALUES
	(8, '2015-09-22 20:52:30', 1, 'prueba', 'Portal A', 0, 'A', '', '', '');
/*!40000 ALTER TABLE `tipoportal` ENABLE KEYS */;


# Dumping structure for table territorio.tipopuerta
CREATE TABLE IF NOT EXISTS `tipopuerta` (
  `idPuerta` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(60) COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `puerta` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `puertaCatastro` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `puertaHacienda` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `puertaINE` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idPuerta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.tipopuerta: ~0 rows (approximately)
DELETE FROM `tipopuerta`;
/*!40000 ALTER TABLE `tipopuerta` DISABLE KEYS */;
INSERT INTO `tipopuerta` (`idPuerta`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `estado`, `puerta`, `puertaCatastro`, `puertaHacienda`, `puertaINE`) VALUES
	(7, '2015-09-22 21:20:13', 1, 'prueba', 'Puerta A', 0, 'A', '', '', '');
/*!40000 ALTER TABLE `tipopuerta` ENABLE KEYS */;


# Dumping structure for table territorio.tipovia
CREATE TABLE IF NOT EXISTS `tipovia` (
  `idTipoVia` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(25) COLLATE latin1_spanish_ci DEFAULT NULL,
  `sigla` varchar(2) COLLATE latin1_spanish_ci DEFAULT NULL,
  `siglaCatastro` varchar(5) COLLATE latin1_spanish_ci DEFAULT NULL,
  `siglaHacienda` varchar(5) COLLATE latin1_spanish_ci DEFAULT NULL,
  `siglaINE` varchar(5) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idTipoVia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.tipovia: ~0 rows (approximately)
DELETE FROM `tipovia`;
/*!40000 ALTER TABLE `tipovia` DISABLE KEYS */;
INSERT INTO `tipovia` (`idTipoVia`, `fechaModificacion`, `numMunicipio`, `uControl`, `descripcion`, `sigla`, `siglaCatastro`, `siglaHacienda`, `siglaINE`) VALUES
	(18, '2015-09-22 20:33:48', 1, 'prueba', 'Calle', 'CL', '', '', ''),
	(19, '2015-09-22 21:31:11', 1, 'admin', 'Plaza', 'PZ', '', '', '');
/*!40000 ALTER TABLE `tipovia` ENABLE KEYS */;


# Dumping structure for table territorio.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL,
  `fechaModificacion` datetime DEFAULT NULL,
  `numMunicipio` int(11) DEFAULT NULL,
  `uControl` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellido1` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellido2` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `clave` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `codUsuario` varchar(9) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL,
  `refMunicipio` int(11) DEFAULT NULL,
  `idPerfil` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `FKF814F32EA45A72D3` (`refMunicipio`),
  KEY `FKF814F32E6874E9C7` (`idPerfil`),
  CONSTRAINT `FKF814F32E6874E9C7` FOREIGN KEY (`idPerfil`) REFERENCES `seg_perfil` (`idPerfil`),
  CONSTRAINT `FKF814F32EA45A72D3` FOREIGN KEY (`refMunicipio`) REFERENCES `municipio` (`idMunicipio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

# Dumping data for table territorio.usuario: ~2 rows (approximately)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`, `fechaModificacion`, `numMunicipio`, `uControl`, `apellido1`, `apellido2`, `clave`, `codUsuario`, `nombre`, `refMunicipio`, `idPerfil`) VALUES
	(10, '2015-09-22 21:16:47', 1, 'prueba', 'Apellido 1 Admin', 'Apellido 2 Admin', '11111', 'admin', 'NombreAdministrador', 1, 11),
	(14, '2015-09-22 21:18:29', 1, 'prueba', 'Apellido1 Gestor', 'Apellido2 Gestor', '11111', 'gestor', 'Nombre Gestor', 1, 12),
	(15, '2015-09-22 21:19:17', 1, 'prueba', 'Apellido1 Consulta', 'apellido2 Consulta', '11111', 'consulta', 'Nombre Consulta', 1, 14);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
