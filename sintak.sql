-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Jan 2023 pada 13.03
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sintak`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(20) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
('AD001', 'nama', 'nama');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `id_buku` varchar(20) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `ket_buku` varchar(300) NOT NULL,
  `stat_buku` varchar(100) NOT NULL,
  `id_kategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id_buku`, `judul`, `ket_buku`, `stat_buku`, `id_kategori`) VALUES
(' BK001', 'satu tembakan', 'karya : thomas', 'tersedia', ' KT003'),
(' BK002', 'pandangan mata tajam', 'sebuah kisah seroang remaja. karya : IK.Putri', 'tersedia', ' KT001'),
(' BK003', 'flora dan fauna', 'karya : ZEE nurwati', 'tidak tersedia', ' KT002'),
(' BK004', 'dentuman waktu', 'karya : nurul fitri', 'tersedia', ' KT004'),
(' BK005', 'majas', 'karya : nuwa litotes', 'tidak tersedia', ' KT005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` varchar(20) NOT NULL,
  `nama_kategori` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(' KT001', 'romantis'),
(' KT002', 'biologi'),
(' KT003', 'drama'),
(' KT004', 'sastra klassik'),
(' KT005', 'pengetahuan umum');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pinjam`
--

CREATE TABLE `pinjam` (
  `id_pinjam` varchar(20) NOT NULL,
  `id_admin` varchar(20) NOT NULL,
  `id_user` varchar(20) NOT NULL,
  `id_buku` varchar(20) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date NOT NULL,
  `det_pinjam` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pinjam`
--

INSERT INTO `pinjam` (`id_pinjam`, `id_admin`, `id_user`, `id_buku`, `tgl_pinjam`, `tgl_kembali`, `det_pinjam`) VALUES
(' PJ001', 'AD001', ' US005', ' BK004', '2023-01-01', '2023-01-07', 'tidak ada'),
(' PJ002', 'AD001', ' US004', ' BK002', '2023-01-03', '2023-01-10', 'buku sudah dikembalikan'),
(' PJ003', 'AD001', ' US001', ' BK001', '2023-01-02', '2023-01-06', 'buku belum dikembalikan'),
(' PJ004', 'AD001', ' US004', ' BK002', '2023-01-01', '2023-01-05', 'tidak ada'),
(' PJ005', 'AD001', ' US001', ' BK001', '2023-01-03', '2023-01-11', 'tidak ada');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` varchar(20) NOT NULL,
  `nama_user` varchar(100) NOT NULL,
  `telepon_user` varchar(15) NOT NULL,
  `alamat_user` varchar(200) NOT NULL,
  `ket_user` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama_user`, `telepon_user`, `alamat_user`, `ket_user`) VALUES
(' US001', 'adi purwa', '0812893988', 'batu liti', 'tidak ada'),
(' US002', 'asel numbra', '0812993988', 'denpasar', 'mahasiswa'),
(' US003', 'lilu patma', '0832893988', 'tabanan', 'siswa'),
(' US004', 'minawa liue', '0879893988', 'Saba', 'pengunjung'),
(' US005', 'fikri irmawan', '0862893988', 'upadesa', 'pengunjung');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`),
  ADD KEY `fk_kategori` (`id_kategori`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indeks untuk tabel `pinjam`
--
ALTER TABLE `pinjam`
  ADD PRIMARY KEY (`id_pinjam`),
  ADD KEY `fk_user` (`id_user`),
  ADD KEY `fk_buku` (`id_buku`),
  ADD KEY `fk_admin` (`id_admin`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `fk_kategori` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pinjam`
--
ALTER TABLE `pinjam`
  ADD CONSTRAINT `fk_admin` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_buku` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
