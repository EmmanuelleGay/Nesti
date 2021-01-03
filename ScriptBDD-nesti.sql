-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 03 jan. 2021 à 15:01
-- Version du serveur :  8.0.18
-- Version de PHP :  7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `nesti`
--

-- --------------------------------------------------------

--
-- Structure de la table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `id_member` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(150) DEFAULT NULL,
  `first_name` varchar(150) DEFAULT NULL,
  `alias` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `town` varchar(150) DEFAULT NULL,
  `password` varchar(535) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_member`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `alias` (`alias`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `member`
--

INSERT INTO `member` (`id_member`, `last_name`, `first_name`, `alias`, `email`, `town`, `password`, `creation_date`, `update_date`) VALUES
(1, 'Jeanne', 'Valjeanne', 'Jeannine', 'jean1@gmail.fr', 'Marseille', '1000:a37428689027d0d0e09e71f8b7b74697:9ae054feff84dd46d9fabdadebb2772f2ac0d68dbe81a30da0d6009a1493ef6f57ada1a259f7d88fc1e96e29ecf601bf708783c3b2ec76322ccc98558e98af32', '0000-00-00 00:00:00', '2020-12-12 15:55:14'),
(8, 'Pierre', 'Henry', 'pierrot', 'jean2@gmail.fr', 'Marseille', '1000:a37428689027d0d0e09e71f8b7b74697:9ae054feff84dd46d9fabdadebb2772f2ac0d68dbe81a30da0d6009a1493ef6f57ada1a259f7d88fc1e96e29ecf601bf708783c3b2ec76322ccc98558e98af32', '2020-12-05 00:34:44', '2020-12-12 15:55:14'),
(9, 'Paul', '', 'Polo', 'jean3@gmail.fr', 'Paris', '1000:a37428689027d0d0e09e71f8b7b74697:9ae054feff84dd46d9fabdadebb2772f2ac0d68dbe81a30da0d6009a1493ef6f57ada1a259f7d88fc1e96e29ecf601bf708783c3b2ec76322ccc98558e98af32', '2020-12-05 14:09:21', '2020-12-12 15:55:14'),
(10, 'James', 'Bond', '007', 'james@bond.com', 'Londres', '1000:a37428689027d0d0e09e71f8b7b74697:9ae054feff84dd46d9fabdadebb2772f2ac0d68dbe81a30da0d6009a1493ef6f57ada1a259f7d88fc1e96e29ecf601bf708783c3b2ec76322ccc98558e98af32', '2020-12-05 14:11:31', '2020-12-12 15:55:14'),
(11, 'Batman', '', 'batman', 'batman@gmail.com', '', '1000:a37428689027d0d0e09e71f8b7b74697:9ae054feff84dd46d9fabdadebb2772f2ac0d68dbe81a30da0d6009a1493ef6f57ada1a259f7d88fc1e96e29ecf601bf708783c3b2ec76322ccc98558e98af32', '2020-12-05 14:31:10', '2020-12-12 15:55:14'),
(12, 'Lareine', 'desNeiges', 'Lareine', 'lareine@desneiges.fr', 'cité des glaces', '1000:a37428689027d0d0e09e71f8b7b74697:9ae054feff84dd46d9fabdadebb2772f2ac0d68dbe81a30da0d6009a1493ef6f57ada1a259f7d88fc1e96e29ecf601bf708783c3b2ec76322ccc98558e98af32', '2020-12-06 12:51:40', '2020-12-12 15:55:14'),
(17, 'Leroi', 'Lion', 'simba', 'leroilion@gmail.com', 'Savane', '1000:a37428689027d0d0e09e71f8b7b74697:9ae054feff84dd46d9fabdadebb2772f2ac0d68dbe81a30da0d6009a1493ef6f57ada1a259f7d88fc1e96e29ecf601bf708783c3b2ec76322ccc98558e98af32', '2020-12-12 14:54:09', '2020-12-12 15:55:14'),
(19, 'Donald', 'Duck', 'donald', 'donald@duck.fr', 'Marseille', '1000:c3b3aa97ba023f306d9d7c4d1932d204:bf43f3cd9b8a7948ca0f6c9c6251bba1c81b557c1bf13117a1f6ab734b36a66d8c7b973db040f8cb8ff6b42fd155ff5d1753b1e6a933a2532ba9cbcc35015d63', '2020-12-12 15:07:09', '2020-12-12 15:55:14'),
(20, 'Charles', 'Henry', 'charlot', 'charles@henry.com', 'Los Angeles', '1000:b7b44abb995a282347d01137751ce6b8:11a4711ae21f7c175347a231d46cb51283b4aec612c2b571ff139672ad11dc68fc0dbbe8c3821e73eaedf5288645764b5de22c2e8a0ed91b18ace3d2244a6e06', '2020-12-12 15:36:07', '2020-12-12 15:55:14'),
(21, 'Daisy', 'Duck', 'dayday', 'daisy@gmail.com', 'Disneyland', '1000:4334cc160a8bb19596dea768312b18d2:8537d617f9d23fdadef43214943dd3e6f9274612653d8411d57a913885f1ac694c3a340b10ef2dff2f986e099a8647cca9ee355bb142f08baf934156ae04e211', '2020-12-12 15:40:49', '2020-12-12 15:55:14'),
(22, 'Dion', 'Celine', 'celine', 'celine@dion.fr', 'Las vegas', '1000:b6f904b0c736d5874b762ffb9a2822d8:61141d90da6b7399cbceda3f9569991ad791c8fc1bb2816667eeba33cbf45610e81ca83ac0e9944117af243845f65c8ca7c3dbe832cf2d184313a8c6734199bf', '2020-12-12 15:44:06', '2020-12-12 15:55:14'),
(23, 'Maitre', 'Gims', 'Gims', 'gims@maitre.com', 'Paris', '1000:baf85d1efaf7dd821cf30e7a6f8109e0:102d06564b9474ca8ed41eed08c29d0c9536d5163e03a866843702092dc2a46a4342f92594ef15cacdb745c5f685c12aca19530d949712f6a80ca0d030cf8f98', '2020-12-12 15:46:39', '2020-12-14 18:37:17'),
(24, 'Loulou', '', 'loulou la peste', 'loulou@lapeste.fr', 'Saitn Denis', '1000:372d5217dfecd53f6b6f214b9b99a2a6:6362b9b4bc7f4e4aa36ddbd56112ba2e61d0747b3992aa84bf5023adc086e2c5edceec482f3b9678ce58af9e171c59781b4fbf2a48d3f59bee1694ca4156a596', '2020-12-12 15:48:57', '2020-12-12 15:55:14'),
(25, 'Dean', 'James', 'james', 'james@dean.fr', 'Harlem', '1000:21b35fd976946c12681428dc431f1e0b:01c7a8e29c46ffb893d1be0183f7c7005b5f7250db9a5292860904dc27c4859e59343f3a6ebaef02cd171ce6926f89a89a44276e7757bb6a3ded3dc8f68c6c36', '2020-12-12 16:03:28', '2020-12-12 15:03:56'),
(26, 'Bon', 'Jean', 'jeanbon', 'jeanbon@gmail.fr', 'Nice', '1000:f9855177b8207ede009748dcf27c2e4a:5d16cab8a843497ae4861c8cb8c00af797e9706e14c93d8816dfa7575845820f6aae22cca3f69ed75a61a16e7279599586d67a7293a5abf7572d32b58024bda4', '2020-12-12 16:07:37', '2020-12-13 14:35:49'),
(27, 'jean', 'paul', 'belmondo', 'belmondo@hotmail.com', '', '1000:186ef4e38e2da518088eeb25ac7c94a6:db6f77fdc3ddf8ba6866f81ba682232e7838244ff3976267c90236dcb8f4f2668709abff8324d7a457aa2878cd7bbd54526307e247bbc1b1836d7dcd2d16830a', '2020-12-13 10:02:50', '2020-12-13 10:02:50'),
(28, 'leroi', 'Arthur', 'Arthur', 'leroiarthur@gmail.com', 'Marseille', '1000:3e4120a90f4d6c496dedb43b8a68d0f7:d6b2d29b56fa32c57c0a3366ebcb24f07ce4c9780f5caf5cc855609f56268d171b2b88e9b7a41a9efa26381dda20e80cf9cf2a60a661f48a3abcdabc11d4e050', '2020-12-13 10:26:22', '2020-12-13 14:28:08'),
(30, 'Clark', 'Kent', 'Superman', 'superman@gmail.com', '', '1000:e445a6a4bae548954c7b65ed8826ce64:b04d0cdb257a34ca189de1cd50f70fd4c42d007dc1ab8a8dd348158c255f107ff8e474c899cb3a53e5cb0f8ac3d3586e166eed64ef850567f3f20f9559404bf4', '2020-12-13 11:06:59', '2020-12-13 14:24:31'),
(32, 'Timsit', 'Patrick', 'patoch', 'patrick@timsit.fr', '', '1000:b7652b8debce062e884b4e5b223f13d0:ebf18e551ac07ba9fec56b0238e1dce571cf5c794eaf1c5e98a95ed92c5619f0e4e78bef531bf88d2482d65660058a91908ebc5f8b96ba3e3aef07c06afe7452', '2020-12-13 16:15:05', '2020-12-13 16:15:05'),
(34, '', '', 'Tarzan', 'tarzan@lajungkle.de', 'La Jungle', '1000:f31c9c64253c6e70003101f4c1e1ff65:066d19c285d36d6636814cf9cc995e0392b9525751747008ed455af5a075e84fd8223c0a5424edb2d0a9eb6e7cbd3d22db2bff8b1686144a066920c5ba55af21', '2020-12-13 16:37:47', '2020-12-14 20:29:34'),
(36, '', '', 'Tony', 'tony@hawks.fr', '', '1000:0e411d6516c43c62dae32899ecebc5a2:62a78c2987c89eea8e00b8a748c2aef6fbb43309105bcc09060350d0899960b80e46b2c575ad47168c3d8136c333ccf6e561eebb8c2eb714773900a1e32b24f1', '2020-12-13 17:41:54', '2020-12-13 17:41:54'),
(37, '', '', 'Vianney', 'vianney@gmail.com', '', '1000:bca90b0e37d3bde0ec4210508c9ab476:f73f70af12b88b99158c4759bd39e2a8acba907c5485777675e0cb2b6204300655cd2f1c0f3d649ea09901830bdefe78d453d985cf9e7a96a59231d122333834', '2020-12-13 17:47:00', '2020-12-13 17:47:00'),
(39, '', '', 'tomi', 'tomi@gmail.com', '', '1000:e3da1531fa476c125e33cb7c08a801c8:5ed57eb567c5873b2a0f14810abc9a9409c3b85f38f9399213342c99d2c093bc287ae0ca3f3404b2288b3f57fe9aa956a08ccad522d450f1680c96d5119e2373', '2020-12-13 18:15:32', '2020-12-13 17:22:48'),
(41, 'Louis', 'Quatorze', 'leroisoleil', 'leroisoleil@versaille.fr', 'Versailles', '1000:9592f2eb725acfed1ea4116b3d519055:4a8a279cce727ce054c6e2a94425a1399f25528635401811b9b229a834dd049559edf988d8767b3dc6ca13e5f9eddbc92ce52e353e844783c9301bca6583a575', '2020-12-13 18:24:52', '2020-12-13 17:57:25'),
(42, 'Jean', 'Jacques', 'goldman', 'golsman@gmail.fr', 'Marseille', '1000:a41efbff0512b84266433f52bbaa82e9:acbd02110c95ff907c8a0ce08fb4e3b280d952d2f9d44668dd099245e968ee3bf5b1eebd47b8333bd983fcea486e0875582bda0ef1e0323b22db732bfa9fbd5a', '2020-12-13 18:32:42', '2020-12-13 17:56:38'),
(43, '', '', 'Elisabeth', 'lareine@gmail.fr', '', '1000:314e09cc2a23e907c9d76cd2d5cd5e13:8ef7aca314dd0f9c8d74e15c5399abdd18e1e604439298df70df84f587038b4d0cce95dbaeca750cf61be4a0508ee42da5311eb71a617d6a8bb1f936b11dd2c4', '2020-12-13 22:27:21', '2020-12-14 20:27:49'),
(44, '', '', 'regex', 'jetestemonregex@super.com', '', '1000:955d470c335deaa5a858e4bf9196661d:d8b413917c285ff44f8efae064e443920384a5cfb4ca16a57d952e97058e6b92c9cf0f98e7dee86acb8899e25994935a29ec079ef1a84e150ef84ff6f9eec759', '2020-12-13 22:38:51', '2020-12-13 22:38:51'),
(45, 'bruel', 'Patrick', 'patriiiick', 'patrick@bruel.com', 'Cité des Anges', '1000:b496a70a09d25be0c2eac04c14d2eaa5:528cc40761dcdbc380529154dd47851600d6a4606681b5be134e61e4a4cc0e81afcdb9904a7c8d30abd9d0e1040cb698b35087616e0ae179205c46253d449c8f', '2020-12-14 20:03:46', '2020-12-14 21:20:35'),
(46, 'Robert', 'Redford', 'roro', 'robert@redford.com', 'nyc', '1000:a2d25ae58404324f44e9aca691002c9a:74ba13c3ec4bd16f209f17e4f04cfce2a8b656509cc5f4843ef4dd95354d4a703794c8fc66d4a50e6b6a647fbd4a1d9f2c5819c012c1ad72f9d3ecc709ca143a', '2020-12-27 17:29:50', '2020-12-27 19:51:57'),
(47, 'Combal', 'Camille', 'Cams', 'camille@gmail.com', '', '1000:db57f9c870ebcd39ccd8d9c5e4486036:f3429eec15a6a42f2f84d9fbeac03573ea934754a592a424482e01e1a8f21d2741c09263c3e039277f79be2814a4e780f2e8baca4c82ff7657d151f5043208c3', '2020-12-27 17:57:06', '2020-12-27 17:57:06'),
(48, 'Jean', 'Paul', 'Louis', 'a@a.fr', 'Gap', '1000:8dbaec7ee51c775a2592bbe4b5d3d931:bc89fbf9a4e8f89d7cdb95f11590985400e5a53b0e2949ec814e3810e118d90d3ffa9dc7001ddec1d791f57d9adae277162e11ab40803f141efa74296cef691c', '2020-12-27 20:03:24', '2021-01-03 15:11:13'),
(49, 'Jean', 'Charles', 'paulo', 'charlot@gmail.com', '', '1000:b11d45cddaa294710e50a14abba81b78:46f9bdf08540d8d6578e5f520d4bc9206c44b604f95b72c97c162707edfc9b91baadb3c3889d1ae404bb710206c44a562f83241746232279621ded5a96408632', '2020-12-27 20:29:26', '2020-12-27 20:29:26'),
(50, 'Henry', 'Quatre', 'leroi', 'henry@quatre.fr', 'Versailles', '1000:de407117f4ebaf7fdfc66148c7642815:dc178a5b1ef53d98461b27d2ba40649f5e81f9836cad4a080b65ca4941361243bf3d9880c5497604f469ce63f125f1f1def694ae7091626bd332af247b80f03f', '2021-01-03 15:53:15', '2021-01-03 15:55:08');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
