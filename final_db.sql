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
CREATE DATABASE IF NOT EXISTS `db_toko` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_toko`;

-- Dumping structure for table db_toko.barang
CREATE TABLE IF NOT EXISTS `barang` (
  `idbarang` int NOT NULL AUTO_INCREMENT,
  `harga` float DEFAULT NULL,
  `jumlahbarang` int DEFAULT NULL,
  `namabarang` varchar(255) DEFAULT NULL,
  `id_user_fk` int DEFAULT NULL,
  PRIMARY KEY (`idbarang`),
  KEY `FKqpbtrrosjlx0cy740lp862nq3` (`id_user_fk`),
  CONSTRAINT `FKqpbtrrosjlx0cy740lp862nq3` FOREIGN KEY (`id_user_fk`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
CREATE TABLE IF NOT EXISTS `detail_transaksi` (
  `id_detail_transaksi` int NOT NULL AUTO_INCREMENT,
  `jumlah_barang` int DEFAULT NULL,
  `tot_harga` int DEFAULT NULL,
  `id_transaksi` int DEFAULT NULL,
  `idbarang` int DEFAULT NULL,
  PRIMARY KEY (`id_detail_transaksi`),
  KEY `FKb75o6ojbg0fiwps16mqsvhueh` (`id_transaksi`),
  KEY `FKlitrlx2ygrav0luse9kccne5v` (`idbarang`),
  CONSTRAINT `FKb75o6ojbg0fiwps16mqsvhueh` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`),
  CONSTRAINT `FKlitrlx2ygrav0luse9kccne5v` FOREIGN KEY (`idbarang`) REFERENCES `barang` (`idbarang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_toko.detail_transaksi: ~0 rows (approximately)
/*!40000 ALTER TABLE `detail_transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_transaksi` ENABLE KEYS */;

-- Dumping structure for table db_toko.transaksi
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int NOT NULL AUTO_INCREMENT,
  `total` bigint DEFAULT NULL,
  `tanggal_transaksi` date DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_toko.transaksi: ~0 rows (approximately)
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;

-- Dumping structure for table db_toko.user
CREATE TABLE IF NOT EXISTS `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_toko.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`iduser`, `password`, `username`) VALUES
	(1, '1sampai8', 'MajuJaya'),
	(2, '1sampai8', 'MakmurYa');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
