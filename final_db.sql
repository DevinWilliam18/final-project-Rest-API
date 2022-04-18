-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.27 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for db_toko
CREATE DATABASE `db_toko`;

-- Dumping structure for table db_toko.barang
CREATE TABLE IF NOT EXISTS `barang` (
  `idbarang` int NOT NULL AUTO_INCREMENT,
  `harga` float DEFAULT NULL,
  `jumlahbarang` int DEFAULT NULL,
  `namabarang` varchar(255) DEFAULT NULL,
  `id_user_fk` int DEFAULT NULL,
  PRIMARY KEY (`idbarang`),
  FOREIGN KEY (`id_user_fk`) REFERENCES `user` (`iduser`)
)
-- Dumping data for table db_toko.barang: ~10 rows (approximately)
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
REPLACE INTO `barang` (`idbarang`, `harga`, `jumlahbarang`, `namabarang`, `id_user_fk`) VALUES
	(1, 12000, 18, 'Molto Pewangi Pink', 1),
	(2, 10000, 22, 'Max Tea Oreo Mini Vanila', 1),
	(3, 8000, 100, 'Biskuat Energi Banana Choco 27 Gr', 1),
	(4, 6500, 111, 'Ultra Milk Low Fat 200ml', 1),
	(5, 8000, 96, 'Buavita 250 ml SIrsak', 1),
	(6, 22000, 125, 'Nuvo Family 250ml merah', 2),
	(7, 23000, 113, 'Sampoerna Mild 16', 2),
	(8, 6000, 116, 'Sunlight 210ml', 2),
	(11, 6600, 100, 'AQUA 1,5 L', 2),
	(12, 10000, 133, 'CHACHA MILK CHOCOLATE 50 g', 1),
	(15, 0, 0, NULL, NULL);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;

-- Dumping structure for table db_toko.detail_transaksi
CREATE TABLE `detail_transaksi` (
  `id_detail_transaksi` int NOT NULL AUTO_INCREMENT,
  `jumlah_barang` int DEFAULT NULL,
  `tot_harga` int DEFAULT NULL,
  `id_transaksi` int DEFAULT NULL,
  `idbarang` int DEFAULT NULL,
  PRIMARY KEY (`id_detail_transaksi`),
  FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`),
  FOREIGN KEY (`idbarang`) REFERENCES `barang` (`idbarang`)
)

CREATE TABLE `transaksi` (
  `id_transaksi` int NOT NULL AUTO_INCREMENT,
  `total` bigint DEFAULT NULL,
  `tanggal_transaksi` date DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`)
)


-- Dumping structure for table db_toko.user
CREATE TABLE `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
)

INSERT INTO `user` (`iduser`, `password`, `username`) VALUES
	(1, '1sampai8', 'MajuJaya'),
	(2, '1sampai8', 'MakmurYa');
