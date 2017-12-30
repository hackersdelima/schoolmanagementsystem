-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2017 at 08:43 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `schoolmanagementsystemdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `companydetailtbl`
--

CREATE TABLE IF NOT EXISTS `companydetailtbl` (
  `companyId` int(11) NOT NULL,
  `companyName` varchar(50) NOT NULL,
  `companyAddress` varchar(50) NOT NULL,
  `companyvatpan` varchar(25) NOT NULL,
  `companydb` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `companydetailtbl`
--

INSERT INTO `companydetailtbl` (`companyId`, `companyName`, `companyAddress`, `companyvatpan`, `companydb`) VALUES
(1, 'Araniko', 'Nepal', '123456', 'aranikodb');

-- --------------------------------------------------------

--
-- Table structure for table `disabledtype`
--

CREATE TABLE IF NOT EXISTS `disabledtype` (
  `id` varchar(3) NOT NULL,
  `typehead` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disabledtype`
--

INSERT INTO `disabledtype` (`id`, `typehead`) VALUES
('01', 'Disability Information'),
('02', 'Cognitive'),
('03', 'Hearing Loss and Deafness'),
('04', 'Invisible Disabilities'),
('05', 'Mobility Impairments'),
('06', 'Psychological Disorders'),
('07', 'Spinal Cord Injury'),
('08', 'Vision Disability');

-- --------------------------------------------------------

--
-- Table structure for table `districtcodes`
--

CREATE TABLE IF NOT EXISTS `districtcodes` (
  `DistrictCode` int(11) NOT NULL DEFAULT '0',
  `DistrictName` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `districtcodes`
--

INSERT INTO `districtcodes` (`DistrictCode`, `DistrictName`) VALUES
(1, 'Taplejung'),
(2, 'Panchthar'),
(3, 'Ilam'),
(4, 'Jhapa'),
(5, 'Sankhuwasabha'),
(6, 'Terhathum'),
(7, 'Bhojpur'),
(8, 'Dhankuta'),
(9, 'Morang'),
(10, 'Sunsari'),
(11, 'Solukhumbu'),
(12, 'Khotang'),
(13, 'Okhaldhunga'),
(14, 'Udayapur'),
(15, 'Saptari'),
(16, 'Siraha'),
(17, 'Dolakha'),
(18, 'Ramechhap'),
(19, 'Sindhuli'),
(20, 'Dhanusha'),
(21, 'Mahottari'),
(22, 'Sarlahi'),
(23, 'Rasuwa'),
(24, 'Dhading'),
(25, 'Nuwakot'),
(26, 'Kathmandu'),
(27, 'Bhaktapur'),
(28, 'Lalitpur'),
(29, 'Kavrepalanchowk'),
(30, 'Sindhupalchowk'),
(31, 'Makwanpur'),
(32, 'Rautahat'),
(33, 'Bara'),
(34, 'Parsa'),
(35, 'Chitwan'),
(36, 'Gorkha'),
(37, 'Manang'),
(38, 'Lamjung'),
(39, 'Kaski'),
(40, 'Tanahun'),
(41, 'Syangja'),
(42, 'Gulmi'),
(43, 'Palpa'),
(44, 'Arghakhanchi'),
(45, 'Nawalparasi'),
(46, 'Rupandehi'),
(47, 'Kapilvastu'),
(48, 'Mustang'),
(49, 'Myagdi'),
(50, 'Baglung'),
(51, 'Parbat'),
(52, 'Rukum'),
(53, 'Rolpa'),
(54, 'Pyuthan'),
(55, 'Salyan'),
(56, 'Dang'),
(57, 'Dolpa'),
(58, 'Mugu'),
(59, 'Jumla'),
(60, 'Kalikot'),
(61, 'Humla'),
(62, 'Jajarkot'),
(63, 'Dailekh'),
(64, 'Surkhet'),
(65, 'Banke'),
(66, 'Bardiya'),
(67, 'Bajura'),
(68, 'Achham'),
(69, 'Bajhang'),
(70, 'Doti'),
(71, 'Kailali'),
(72, 'Darchula'),
(73, 'Baitadi'),
(74, 'Dadeldhura'),
(75, 'Kanchanpur');

-- --------------------------------------------------------

--
-- Table structure for table `mainusertbl`
--

CREATE TABLE IF NOT EXISTS `mainusertbl` (
  `mId` int(11) NOT NULL,
  `mainusername` varchar(50) NOT NULL,
  `mainpassword` varchar(50) NOT NULL,
  `companyId` int(11) NOT NULL,
  `userdetailId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mainusertbl`
--

INSERT INTO `mainusertbl` (`mId`, `mainusername`, `mainpassword`, `companyId`, `userdetailId`) VALUES
(1, 'araniko', 'araniko', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `userdetailtbl`
--

CREATE TABLE IF NOT EXISTS `userdetailtbl` (
  `uId` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `permanentAddress` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetailtbl`
--

INSERT INTO `userdetailtbl` (`uId`, `name`, `permanentAddress`) VALUES
(1, 'Araniko', 'Nepal');

-- --------------------------------------------------------

--
-- Table structure for table `usertbl`
--

CREATE TABLE IF NOT EXISTS `usertbl` (
  `id` int(11) NOT NULL,
  `mId` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(25) NOT NULL,
  `userdetailId` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertbl`
--

INSERT INTO `usertbl` (`id`, `mId`, `username`, `password`, `role`, `userdetailId`) VALUES
(1, 1, 'araniko', 'araniko', 'admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `vdccodes`
--

CREATE TABLE IF NOT EXISTS `vdccodes` (
  `VDCCode` varchar(5) NOT NULL,
  `VDCName` varchar(100) NOT NULL,
  `WardCount` int(11) NOT NULL,
  `DistrictCode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vdccodes`
--

INSERT INTO `vdccodes` (`VDCCode`, `VDCName`, `WardCount`, `DistrictCode`) VALUES
('10101', 'Fungling', 11, 1),
('10102', 'Athrai Tribeni', 5, 1),
('10103', 'Sidingwa', 7, 1),
('10104', 'Faktanglung', 7, 1),
('10105', 'Mikhwakhola', 5, 1),
('10106', 'Meringden', 6, 1),
('10107', 'Maiwakhola', 6, 1),
('10108', 'Yangwarak', 6, 1),
('10109', 'Sirijunga', 8, 1),
('10201', 'Fidim', 14, 2),
('10202', 'Falelung', 8, 2),
('10203', 'Falgunanda', 7, 2),
('10204', 'Hilihang', 7, 2),
('10205', 'Kummayek', 5, 2),
('10206', 'Miklajung', 8, 2),
('10207', 'Tumwewa', 5, 2),
('10208', 'Yangwarak', 6, 2),
('10301', 'Illam', 12, 3),
('10302', 'Deumai', 9, 3),
('10303', 'Mai', 10, 3),
('10304', 'Suryodaya', 14, 3),
('10305', 'Fakfokthum', 7, 3),
('10306', 'Chulachuli', 6, 3),
('10307', 'Maijogmai', 6, 3),
('10308', 'Mangsebung', 6, 3),
('10309', 'Rong', 6, 3),
('10310', 'Sandakpur', 5, 3),
('10401', 'Mechinagar', 15, 4),
('10402', 'Damak', 10, 4),
('10403', 'Kankai', 9, 4),
('10404', 'Bhadrapur', 10, 4),
('10405', 'Arjundhara', 11, 4),
('10406', 'Shivasatakshi', 11, 4),
('10407', 'Gauradaha', 9, 4),
('10408', 'Birtamod', 10, 4),
('10409', 'Kamal', 7, 4),
('10410', 'Gaurigunj', 6, 4),
('10411', 'Barhadashi', 7, 4),
('10412', 'Jhapa', 7, 4),
('10413', 'Buddhasanti', 7, 4),
('10414', 'Haldibari', 5, 4),
('10415', 'Kachankawal', 7, 4),
('10501', 'Chainpur', 11, 5),
('10502', 'Dharmadevi', 9, 5),
('10503', 'Khaadbaari', 11, 5),
('10504', 'Madi', 9, 5),
('10505', 'Paanchkhapan', 9, 5),
('10506', 'Bhotkhola', 5, 5),
('10507', 'Chichila', 5, 5),
('10508', 'Makalu', 6, 5),
('10509', 'Sabhapokhari', 6, 5),
('10510', 'Silichong', 5, 5),
('10601', 'Myanglung', 10, 6),
('10602', 'Laligurans', 9, 6),
('10603', 'Athrai ', 7, 6),
('10604', 'Chhathar', 6, 6),
('10605', 'Fedaap', 5, 6),
('10606', 'Menchhayayem', 6, 6),
('10701', 'Bhojpur', 12, 7),
('10702', 'Sadananda', 14, 7),
('10703', 'Tyamkemaiyum', 9, 7),
('10704', 'Ramprasadrai', 8, 7),
('10705', 'Arun', 7, 7),
('10706', 'Pauwadungma', 6, 7),
('10707', 'Salpasilichho', 6, 7),
('10708', 'Aamchowk', 10, 7),
('10709', 'Hatuwagadhi', 9, 7),
('10801', 'Pakhribaas', 10, 8),
('10802', 'Dhankuta', 10, 8),
('10803', 'Mahalaxmi', 9, 8),
('10804', 'Sagurigadhi', 10, 8),
('10805', 'Khalsa Chhintang Sahidbhumi', 7, 8),
('10806', 'Chhathar Jorpati', 6, 8),
('10807', 'Chaubise', 8, 8),
('10901', 'Biratnagar', 19, 9),
('10902', 'Belbaari', 11, 9),
('10903', 'Letang', 9, 9),
('10904', 'Pathari Sanischare', 10, 9),
('10905', 'Rangeli', 9, 9),
('10906', 'Ratuwamai', 10, 9),
('10907', 'Sunawarsi', 9, 9),
('10908', 'Urlabaari', 9, 9),
('10909', 'Sundarharaincha', 12, 9),
('10910', 'Budhiganga', 7, 9),
('10911', 'Dhanpalthan', 7, 9),
('10912', 'Gramthan', 7, 9),
('10913', 'Jahada', 7, 9),
('10914', 'Kanepokhari', 7, 9),
('10915', 'Katahari', 7, 9),
('10916', 'Kerabaari', 10, 9),
('10917', 'Miklajung', 9, 9),
('11001', 'Itahari', 20, 10),
('11002', 'Dharan', 20, 10),
('11003', 'Inaruwa', 10, 10),
('11004', 'Duhabi', 12, 10),
('11005', 'Ramdhuni', 9, 10),
('11006', 'Barah', 11, 10),
('11007', 'Dewangunj', 7, 10),
('11008', 'Koshi', 8, 10),
('11009', 'Gadhi', 6, 10),
('11010', 'Barju', 6, 10),
('11011', 'Bhokraha', 8, 10),
('11012', 'Harinagara', 7, 10),
('11101', 'Solududhkunda', 10, 11),
('11102', 'Dudhkoshi', 7, 11),
('11103', 'Khumbu Pasang Lhamu', 5, 11),
('11104', 'Dudhkausika', 9, 11),
('11105', 'Nechasalyan', 6, 11),
('11106', 'Mahakulung', 5, 11),
('11107', 'Likhu Pike', 5, 11),
('11108', 'Sotang', 5, 11),
('11201', 'Halesituwachung', 11, 12),
('11202', 'Rupakot Majhuwagadhi', 15, 12),
('11203', 'Aiselukharka', 7, 12),
('11204', 'Lamidada', 6, 12),
('11205', 'Jantedhunga', 6, 12),
('11206', 'Khotehang', 9, 12),
('11207', 'Kepilasgadhi', 7, 12),
('11208', 'Diprung', 7, 12),
('11209', 'Sakela', 5, 12),
('11210', 'Barahpokhari', 6, 12),
('11301', 'Siddhicharan', 12, 13),
('11302', 'Khijidemwa', 9, 13),
('11303', 'Champadevi', 10, 13),
('11304', 'Chisankhugadhi', 8, 13),
('11305', 'Manebhanjyang', 9, 13),
('11306', 'Molung', 8, 13),
('11307', 'Likhu', 9, 13),
('11308', 'Sunkoshi', 10, 13),
('11401', 'Katari', 14, 14),
('11402', 'Chaudandagadhi', 10, 14),
('11403', 'Triyuga', 16, 14),
('11404', 'Belaka', 9, 14),
('11405', 'Udaypurgadhi', 8, 14),
('11406', 'Tapli', 5, 14),
('11407', 'Rautamai', 8, 14),
('11408', 'Sunkoshi', 5, 14),
('23201', 'Chandrapur', 10, 32),
('23202', 'Garuda', 9, 32),
('23203', 'Gaur', 13, 32),
('23204', 'Baudhimai', 7, 32),
('23205', 'Brindaban', 8, 32),
('23206', 'Dewahi Gonahi', 7, 32),
('23207', 'Durga Bhagwati', 8, 32),
('23208', 'Gadhimai', 7, 32),
('23209', 'Gujara', 9, 32),
('23210', 'Katahariya', 9, 32),
('23211', 'Madhav Narayan', 9, 32),
('23212', 'Maulapur', 7, 32),
('23213', 'Fatuwa Bijayapur', 5, 32),
('23214', 'Ishanath', 9, 32),
('23215', 'Paroha', 8, 32),
('23216', 'Rajpur', 7, 32),
('23301', 'Kalaiya', 27, 33),
('23302', 'Jitpursimara', 23, 33),
('23303', 'Kolhawi', 11, 33),
('23304', 'Nijgadh', 13, 33),
('23305', 'Mahagadimai', 11, 33),
('23306', 'Simraungadh', 11, 33),
('23307', 'Adarsha Kotwal', 8, 33),
('23308', 'Karaiyamai', 8, 33),
('23309', 'Devtaal', 7, 33),
('23310', 'Pachrauta', 9, 33),
('23311', 'Parwanipur', 9, 33),
('23312', 'Prasauni', 7, 33),
('23313', 'Pheta', 8, 33),
('23314', 'Baragadhi', 6, 33),
('23315', 'Subarna', 8, 33),
('23401', 'Birgunj', 27, 34),
('23402', 'Pokhariya', 11, 34),
('23403', 'Subarnapur', 7, 34),
('23404', 'Jagarnathpur', 6, 34),
('23405', 'Dhobini', 5, 34),
('23406', 'Chhipaharmai', 5, 34),
('23407', 'Pakaha Mainapur', 5, 34),
('23408', 'Bindabasini', 5, 34),
('23409', 'Bahudarmai', 8, 34),
('23410', 'Belawa', 7, 34),
('23411', 'Parsagadhi', 6, 34),
('23412', 'Sakhuwa Prasauni', 6, 34),
('23413', 'Paterwa Sugauli', 7, 34),
('21501', 'rajbiraj nagarpalika', 15, 15),
('21502', 'Kanchanrup', 12, 15),
('21503', 'Dakneshwori ', 11, 15),
('21504', 'Bodebarsain', 16, 15),
('21505', 'Khadak', 11, 15),
('21506', 'Sambhunath', 11, 15),
('21507', 'Surunga', 11, 15),
('21508', 'hanumannagar kankalini', 14, 15),
('21509', 'Krishna sabaran', 5, 15),
('21510', 'Chhinnamasta', 8, 15),
('21511', 'Mahadeva', 6, 15),
('21512', 'Saptakosi', 11, 15),
('21513', 'Tirahut', 5, 15),
('21514', 'Tilathi Koiladi', 8, 15),
('21515', 'Rupani', 6, 15),
('21516', 'Belhi Chapena', 5, 15),
('21517', 'Bishnupur', 7, 15),
('22001', 'Janakpur', 24, 20),
('22002', 'Chhireshwor ', 11, 20),
('22003', 'Ganeshman Charnath', 11, 20),
('22004', 'Dhanusadham', 9, 20),
('22005', 'Nagarain', 10, 20),
('22006', 'Videha', 10, 20),
('22007', 'Mithila', 10, 20),
('22008', 'Sahidnagar', 9, 20),
('22009', 'Sabaila', 13, 20),
('22010', 'Siddidatri', 6, 20),
('22011', 'Janaknandini', 6, 20),
('22012', 'Bateshwor', 5, 20),
('22013', 'Mithila Bihari', 10, 20),
('22014', 'Mukhiyapatti musaharmiya', 6, 20),
('22015', 'Laxminiya', 7, 20),
('22016', 'Hansapur', 8, 20),
('22017', 'Aurahi', 8, 20),
('21601', 'Lahan', 24, 16),
('21602', 'Dhangadimai', 14, 16),
('21603', 'Siraha', 22, 16),
('21604', 'Golbazar', 13, 16),
('21605', 'Mirchaiya', 12, 16),
('21606', 'Kalyanpur', 12, 16),
('21607', 'Bhagawanpur', 5, 16),
('21608', 'Aurahi', 5, 16),
('21609', 'Bishnupur', 5, 16),
('21610', 'Sukhipur', 8, 16),
('21611', 'Karjanha', 7, 16),
('21612', 'Bariyarpatti', 5, 16),
('21613', 'Laxmipur Patari', 6, 16),
('21614', 'Naraha', 5, 16),
('21615', 'Sakhuwanankarkatti', 5, 16),
('21616', 'Arnama', 5, 16),
('21617', 'Nawarajpur', 5, 16),
('22101', 'Jaleshwor', 12, 21),
('22102', 'Bardibas', 13, 21),
('22103', 'Gausala', 12, 21),
('22104', 'Ekdara', 8, 21),
('22105', 'Somana', 8, 21),
('22106', 'Samsi', 7, 21),
('22107', 'Loharpatti', 8, 21),
('22108', 'Ramgopalpur', 6, 21),
('22109', 'Mahottari', 6, 21),
('22110', 'Manara', 8, 21),
('22111', 'Matihani', 6, 21),
('22112', 'Bhanggaha', 9, 21),
('22113', 'Balawa', 7, 21),
('22114', 'Pipara', 7, 21),
('22115', 'Aurahi', 7, 21),
('22201', 'Ishworpur', 15, 22),
('22202', 'Lalbandi', 17, 22),
('22203', 'Haripur', 10, 22),
('22204', 'Haripurba', 11, 22),
('22205', 'Hariban', 11, 22),
('22206', 'Barahathawa', 18, 22),
('22207', 'Balara', 12, 22),
('22208', 'Godaita', 11, 22),
('22209', 'Malangwa', 12, 22),
('22210', 'Bagmati', 10, 22),
('22211', 'Kabilasi', 8, 22),
('22212', 'Chakraghatta ', 13, 22),
('22213', 'Chandranagar', 7, 22),
('22214', 'Dhankaul', 9, 22),
('22215', 'Bramhapuri', 9, 22),
('22216', 'Ramnagar', 10, 22),
('22217', 'Bishnu', 12, 22),
('32301', 'Uttargaya ', 5, 23),
('32302', 'Kalika', 5, 23),
('32303', 'Gosainkunda', 6, 23),
('32304', 'Naukunda', 6, 23),
('32305', 'Parbatikunda', 5, 23),
('32501', 'Bidur', 13, 25),
('32502', 'Belkotgadhi', 13, 25),
('32503', 'Kakani', 8, 25),
('32504', 'Kispang', 5, 25),
('32505', 'Tadigaun', 6, 25),
('32506', 'Tarkeshwor', 6, 25),
('32507', 'Dupcheshwor', 7, 25),
('32508', 'Panchakanya', 5, 25),
('32509', 'Likhu', 6, 25),
('32510', 'Meghang', 6, 25),
('32511', 'Shivapuri', 8, 25),
('32512', 'Suryegadhi', 5, 25),
('32601', 'Kathmandu', 32, 26),
('32602', 'Kageshwori Manohara', 12, 26),
('32603', 'Kirtipur', 10, 26),
('32604', 'Gokarneshwor', 9, 26),
('32605', 'Chandragiri', 15, 26),
('32606', 'Tokha', 11, 26),
('32607', 'Tarkeshwor', 11, 26),
('32608', 'Dakchinkali', 9, 26),
('32609', 'Nagarjun', 10, 26),
('32610', 'Budhanilkantha', 13, 26),
('32611', 'Shankharapur', 9, 26),
('32701', 'Changu Narayan', 9, 27),
('32702', 'Bhaktapur', 10, 27),
('32703', 'Madhyepur Thimi', 9, 27),
('32704', 'Suryebinayak', 10, 27),
('33001', 'Chautara Sangachowkgadhi', 14, 30),
('33002', 'Barabise', 9, 30),
('33003', 'Melamchi', 13, 30),
('33004', 'Indrabati', 12, 30),
('33005', 'Jugal', 7, 30),
('33006', 'Panchpokhari Thanpal', 8, 30),
('33007', 'Balephi', 8, 30),
('33008', 'Botekoshi', 5, 30),
('33009', 'Lisankhu Pakhar', 7, 30),
('33010', 'Sunkoshi', 7, 30),
('33011', 'Helambhu', 7, 30),
('33012', 'Tripurasundari', 6, 30),
('31801', 'Manthali', 14, 18),
('31802', 'Ramechhap', 9, 18),
('31803', 'Umakunda', 7, 18),
('31804', 'Khandadevi', 9, 18),
('31805', 'Gokulganga', 6, 18),
('31806', 'Doramba', 7, 18),
('31807', 'Likhu', 7, 18),
('31808', 'Sunapati', 5, 18),
('31901', 'Kamalamaai', 14, 19),
('31902', 'Dudhauli', 14, 19),
('31903', 'Golanjor', 7, 19),
('31904', 'Ghyankhel', 5, 19),
('31905', 'Tinpatan', 11, 19),
('31906', 'Fikkal', 6, 19),
('31907', 'Marin', 8, 19),
('31908', 'Sunkoshi', 7, 19),
('31909', 'Hariharpurgadhi', 8, 19),
('32901', 'Dhulikhel', 12, 29),
('32902', 'Banepa', 14, 29),
('32903', 'Panauti', 12, 29),
('32904', 'Panchkhaal', 13, 29),
('32905', 'Namobuddha', 11, 29),
('32906', 'Khanikhola', 7, 29),
('32907', 'Chaurideurali', 9, 29),
('32908', 'Temaal', 9, 29),
('32909', 'Bethanchowk', 6, 29),
('32910', 'Bhumlu', 10, 29),
('32911', 'Mandandeupur', 12, 29),
('32912', 'Mahabharat', 8, 29),
('32913', 'Roshi', 12, 29),
('31701', 'Jiri', 9, 17),
('31702', 'Bhimeshwor', 9, 17),
('31703', 'Kalinchowk', 9, 17),
('31704', 'Gaurishankar', 9, 17),
('31705', 'Tamakoshi', 7, 17),
('31706', 'Melung', 7, 17),
('31707', 'Bigu', 8, 17),
('31708', 'Baiteshwor', 8, 17),
('31709', 'Shailung', 8, 17),
('32801', 'Lalitpur', 29, 28),
('32802', 'Godawari', 14, 28),
('32803', 'Mahalaxmi', 10, 28),
('32804', 'Konjyosom', 5, 28),
('32805', 'Bagmati', 7, 28),
('32806', 'Mahankaal', 6, 28),
('32401', 'Dhunibenshi', 9, 24),
('32402', 'Nilkantha', 14, 24),
('32403', 'Khaniyabash', 5, 24),
('32404', 'Gajuri', 8, 24),
('32405', 'Galchi', 8, 24),
('32406', 'Gangajamuna', 7, 24),
('32407', 'Jwalamukhi', 7, 24),
('32408', 'Thakre', 11, 24),
('32409', 'Netrabati', 5, 24),
('32410', 'Benighat Rorang', 10, 24),
('32411', 'Rubi Valley', 6, 24),
('32412', 'Sidhlake', 7, 24),
('32413', 'Tripurasundari', 7, 24),
('33101', 'Hetauda', 19, 31),
('33102', 'Thaha', 12, 31),
('33103', 'Indrasarobar', 5, 31),
('33104', 'Kailash', 10, 31),
('33105', 'Bakaiya', 12, 31),
('33106', 'Bagmati', 9, 31),
('33107', 'Bhimfedi', 9, 31),
('33108', 'Makwanpurgadhi', 8, 31),
('33109', 'Manhari', 9, 31),
('33110', 'Raksirang', 9, 31),
('33501', 'Bharatpur', 29, 35),
('33502', 'Kalika', 11, 35),
('33503', 'Khairhani', 13, 35),
('33504', 'Madi', 9, 35),
('33505', 'Ratnanagar', 16, 35),
('33506', 'Rapti', 13, 35),
('33507', 'Echyakamana', 7, 35),
('44101', 'Galyang', 11, 41),
('44102', 'Chapkot', 10, 41),
('44103', 'Putalibazar', 14, 41),
('44104', 'Virkot', 9, 41),
('44105', 'Waling', 14, 41),
('44106', 'Arjunchaupari', 6, 41),
('44107', 'Aadhikhola', 6, 41),
('44108', 'Kaligandaki', 7, 41),
('44109', 'Fedikhola', 5, 41),
('44110', 'Biruwa', 8, 41),
('44111', 'Harinas', 7, 41),
('43901', 'Pokhara Lekhanath', 33, 39),
('43902', 'Annapurna', 11, 39),
('43903', 'Machhapuchhre', 9, 39),
('43904', 'Madi', 12, 39),
('43905', 'Rupa', 7, 39),
('44801', 'Gharpajhong', 5, 48),
('44802', 'Thasang', 5, 48),
('44803', 'Dalome', 5, 48),
('44804', 'Lomanthang', 5, 48),
('44805', 'Barhagaun Muktichhetra', 5, 48),
('45101', 'Kushma', 14, 51),
('45102', 'Phalewas', 11, 51),
('45103', 'Jaljala', 9, 51),
('45104', 'paiyu', 7, 51),
('45105', 'Mahashila', 6, 51),
('45106', 'Modi', 8, 51),
('45107', 'Bihadi', 6, 51),
('43701', 'Narfu', 5, 37),
('43702', 'Nashon', 9, 37),
('43703', 'Neshyang', 9, 37),
('43704', 'Chame', 5, 37),
('44001', 'Bhanu', 13, 40),
('44002', 'Bhimad', 9, 40),
('44003', 'Byas', 14, 40),
('44004', 'Shuklagandaki', 12, 40),
('44005', 'Ambukhaireni', 6, 40),
('44006', 'Rhishing', 8, 40),
('44007', 'Ghiring', 5, 40),
('44008', 'Devghat', 5, 40),
('44009', 'Myagdi', 7, 40),
('44010', 'Bandipur', 6, 40),
('44901', 'Beni', 10, 49),
('44902', 'Annapurna', 8, 49),
('44903', 'Dhaulagiri', 7, 49),
('44904', 'Mangala', 5, 49),
('44905', 'Malika', 7, 49),
('44906', 'Raghuganga', 8, 49),
('45001', 'Baglung', 14, 50),
('45002', 'Galkot', 11, 50),
('45003', 'Jaimini', 10, 50),
('45004', 'Dhorpatan', 9, 50),
('45005', 'Bareng', 5, 50),
('45006', 'Kathekhola', 8, 50),
('45007', 'Tamankhola', 6, 50),
('45008', 'Tarakhola', 5, 50),
('45009', 'Nisikhola', 7, 50),
('45010', 'Badigad', 10, 50),
('43601', 'Gorkha', 14, 36),
('43602', 'Palungtar', 10, 36),
('43603', 'Sulikot', 8, 36),
('43604', 'Siranchok', 8, 36),
('43605', 'Ajirkot', 5, 36),
('43606', 'Aarughat', 10, 36),
('43607', 'Gandaki', 8, 36),
('43608', 'Chumnubri', 7, 36),
('43609', 'Dharche', 7, 36),
('43610', 'Bhimsen', 8, 36),
('43611', 'Sahid Lakhan', 9, 36),
('43801', 'Beshi Sahar', 11, 38),
('43802', 'Madhya Nepal', 10, 38),
('43803', 'Rainas', 10, 38),
('43804', 'Sundar Bajar', 11, 38),
('43805', 'Kobholasothar', 9, 38),
('43806', 'Dudhpokhari', 6, 38),
('43807', 'Dordi', 9, 38),
('43808', 'Marsyandi', 9, 38),
('54601', 'Butwal', 19, 46),
('54602', 'Lumbini Saskritik', 13, 46),
('54603', 'Sidharthanager', 13, 46),
('54604', 'Sammarimai', 7, 46),
('54605', 'Debdaha', 12, 46),
('54606', 'Sainamaina', 11, 46),
('54607', 'Tilottma', 17, 46),
('54608', 'Siyari', 7, 46),
('54609', 'Gaidahawa', 9, 46),
('54610', 'Kanchan', 5, 46),
('54611', 'Kotahimai', 7, 46),
('54612', 'Marchawari', 7, 46),
('54613', 'Mayadevi', 8, 46),
('54614', 'Omsatiya', 6, 46),
('54615', 'Rohindi', 7, 46),
('54616', 'Suddodhan', 7, 46),
('54401', 'Sandhikharka', 12, 44),
('54402', 'Sitganga', 14, 44),
('54403', 'Bhumikasthan', 10, 44),
('54404', 'Chhatradev', 8, 44),
('54405', 'Pandini', 8, 44),
('54406', 'Malarani', 9, 44),
('54501', 'Kawasoti', 17, 45),
('54502', 'Gaindakot', 18, 45),
('54503', 'Devchuli', 17, 45),
('54504', 'Bardghat', 16, 45),
('54505', 'Madhyabindu', 15, 45),
('54506', 'Ramgram', 18, 45),
('54507', 'Sunwal', 13, 45),
('54508', 'Tribenisusta', 7, 45),
('54509', 'Palhinandan', 6, 45),
('54510', 'Pratappur', 9, 45),
('54511', 'Bungdikali', 6, 45),
('54512', 'Bulingtar', 6, 45),
('54513', 'Binaie', 5, 45),
('54514', 'Sarawal', 7, 45),
('54515', 'Hupsekot', 6, 45),
('55601', 'Tulsipur', 19, 56),
('55602', 'Ghorahi', 19, 56),
('55603', 'Lamahi', 9, 56),
('55604', 'Bangalichuli', 8, 56),
('55605', 'Dangisaran', 7, 56),
('55606', 'Gadhawa', 8, 56),
('55607', 'Rajpur', 7, 56),
('55608', 'Rapti', 9, 56),
('55609', 'Santinagar', 7, 56),
('55610', 'Babai', 7, 56),
('55501', 'Sarada', 15, 55),
('55502', 'Bagchaur', 12, 55),
('55503', 'Bangad', 12, 55),
('55504', 'Kalimati', 7, 55),
('55505', 'Tribeni', 6, 55),
('55506', 'Kapurkot', 6, 55),
('55507', 'Chhatreswori', 7, 55),
('55508', 'Dhorchaur', 5, 55),
('55509', 'Kumakhamalika', 7, 55),
('55510', 'Darma', 6, 55),
('55201', 'Musikot', 14, 52),
('55202', 'Chaurjahari', 14, 52),
('55203', 'Aathabiskot', 14, 52),
('55204', 'Putha Uttarganga', 14, 52),
('55205', 'Bhume', 9, 52),
('55206', 'Sisne', 8, 52),
('55207', 'Baphikot', 10, 52),
('55208', 'Tribeni ', 10, 52),
('55209', 'Sanibheri', 11, 52),
('56501', 'Nepalgunj', 23, 65),
('56502', 'Koholpur', 15, 65),
('56503', 'Narainapur', 6, 65),
('56504', 'Raptisonari', 9, 65),
('56505', 'Baijanath', 8, 65),
('56506', 'Khajura', 8, 65),
('56507', 'Duduwa', 6, 65),
('56508', 'Janaki', 6, 65),
('55301', 'Rolpa', 10, 53),
('55302', 'Tribeni', 7, 53),
('55303', 'Duikholi', 6, 53),
('55304', 'Madi', 6, 53),
('55305', 'Runtigadhi', 9, 53),
('55306', 'Lungri', 7, 53),
('55307', 'Sukidaha', 7, 53),
('55308', 'Sunchhahari', 7, 53),
('55309', 'Subarnawoti', 8, 53),
('55310', 'Thabang', 5, 53),
('55401', 'Pyuthan', 10, 54),
('55402', 'Sworgadwari', 9, 54),
('55403', 'Gaumukhi', 7, 54),
('55404', 'Mandabi', 5, 54),
('55405', 'Sarumarani', 6, 54),
('55406', 'Mallarani', 5, 54),
('55407', 'Naubahini', 8, 54),
('55408', 'Jhimruk', 8, 54),
('55409', 'Arawoti', 6, 54),
('56601', 'Gulariya', 12, 66),
('56602', 'Madhuban', 9, 66),
('56603', 'Rajapur', 10, 66),
('56604', 'Thakurbaba', 9, 66),
('56605', 'Bansgadhi', 9, 66),
('56606', 'Barbardiya', 11, 66),
('56607', 'Badhaiyatal', 9, 66),
('56608', 'Geruwa', 6, 66),
('54201', 'Musikot', 9, 42),
('54202', 'Resunga', 14, 42),
('54203', 'Ishma', 6, 42),
('54204', 'Kaligandaki', 7, 42),
('54205', 'Gulmidarbar', 7, 42),
('54206', 'Satyawoti', 8, 42),
('54207', 'Chandrakot', 8, 42),
('54208', 'Ruru', 6, 42),
('54209', 'Chhatrakot', 6, 42),
('54210', 'Dhurkot', 7, 42),
('54211', 'Madane', 7, 42),
('54212', 'Malika', 8, 42),
('54301', 'Rampur', 10, 43),
('54302', 'Tansen', 14, 43),
('54303', 'Nisdi', 7, 43),
('54304', 'Purbakhola', 6, 43),
('54305', 'Rambha', 5, 43),
('54306', 'Mathagadi', 8, 43),
('54307', 'Tinau', 6, 43),
('54308', 'Baganaskali', 9, 43),
('54309', 'Ribdikot', 8, 43),
('54310', ' Rainadevi Chhahara', 8, 43),
('54701', 'Kapilvastu', 12, 47),
('54702', 'Buddhabhumi', 10, 47),
('54703', 'Shivaraj', 11, 47),
('54704', 'Maharajgang', 11, 47),
('54705', 'Krishnanagar', 12, 47),
('54706', 'Bandganga', 11, 47),
('54707', 'Mayadevi', 8, 47),
('54708', 'Yesodhara', 8, 47),
('54709', 'Bijayanagar', 7, 47),
('54710', 'Suddhodhan', 6, 47),
('66101', 'Simkot', 8, 61),
('66102', 'Namkha', 6, 61),
('66103', 'kharpunath', 5, 61),
('66104', 'Surkegad', 8, 61),
('66105', 'Chankheli', 6, 61),
('66106', 'Adanchuli', 6, 61),
('66107', 'Tajakot', 5, 61),
('65801', 'Chhayanath', 14, 58),
('65802', 'Mugumkarmarog', 9, 58),
('65803', 'Soru', 11, 58),
('65804', 'Khatyang', 11, 58),
('66001', 'Khadachakra', 11, 60),
('66002', 'Raskot', 9, 60),
('66003', 'Tilagupha', 11, 60),
('66004', 'Pachaljharana', 9, 60),
('66005', 'Sanni tribeni', 9, 60),
('66006', 'Naraharinath', 9, 60),
('66007', 'Kalika', 8, 60),
('66008', 'Mahabai', 7, 60),
('66009', 'Palata', 9, 60),
('65901', 'Chandannath', 10, 59),
('65902', 'Kankasundari', 8, 59),
('65903', 'Sinja', 6, 59),
('65904', 'Hima', 7, 59),
('65905', 'Tila', 9, 59),
('65906', 'Guthichaur', 5, 59),
('65907', 'Tatopani', 8, 59),
('65908', 'Patarasi', 7, 59),
('66401', 'Birendra', 16, 64),
('66402', 'Bheriganga', 13, 64),
('66403', 'Gurbhakot', 14, 64),
('66404', 'Pabchapuri', 11, 64),
('66405', 'Lekbesi', 10, 64),
('66406', 'Chaukune', 10, 64),
('66407', 'Barahatal', 10, 64),
('66408', 'Chingad', 6, 64),
('66409', 'Simta ', 9, 64),
('66301', 'Narayan', 11, 63),
('66302', 'Dullu', 13, 63),
('66303', 'Chamunda Bindrasaini', 9, 63),
('66304', 'Aathbis', 9, 63),
('66305', 'Bhagawatimai', 7, 63),
('66306', 'Gurash', 8, 63),
('66307', 'Dungeshwar', 6, 63),
('66308', 'Naumule', 8, 63),
('66309', 'Mahabu', 6, 63),
('66310', 'Bhairabi', 7, 63),
('66311', 'Thatikadh', 6, 63),
('65701', 'Thuli veri', 11, 57),
('65702', 'Tripurasundari', 11, 57),
('65703', 'Dolpa buddha', 6, 57),
('65704', 'She phoksundo', 9, 57),
('65705', 'Jagdulla', 6, 57),
('65706', 'Mudkechula', 9, 57),
('65707', 'Kaike', 7, 57),
('65708', 'Chharka tangsong', 6, 57),
('66201', 'veri', 13, 62),
('66202', 'Chhedagad', 13, 62),
('66203', 'Tribeni nalgad ', 13, 62),
('66204', 'Kuse ', 9, 62),
('66205', 'Junichande', 11, 62),
('66206', 'Barekot', 9, 62),
('66207', 'Shibalaya', 9, 62),
('77301', 'Dashrathachanda', 11, 73),
('77302', 'Patan ', 10, 73),
('77303', 'Melauli ', 9, 73),
('77304', 'Purchaudi ', 10, 73),
('77305', 'Surnaya', 8, 73),
('77306', 'Sisag', 9, 73),
('77307', 'Shivanath', 6, 73),
('77308', 'Pancheshwar', 6, 73),
('77309', 'Dogdakedar', 8, 73),
('77310', 'Dilasaini', 7, 73),
('77401', 'Amargadhi ', 11, 74),
('77402', 'Parsuram ', 12, 74),
('77403', 'Aalital', 8, 74),
('77404', 'Bhageshwar', 5, 74),
('77405', 'nabadurga', 5, 74),
('77406', 'Ajayameru ', 6, 74),
('77407', 'Ganyapdhura', 5, 74),
('77501', 'bhimdatta', 19, 75),
('77502', 'Punarbas', 11, 75),
('77503', 'Bedkot ', 10, 75),
('77504', 'Mahakali', 9, 75),
('77505', 'Shuklaphata', 12, 75),
('77506', 'Belauri', 10, 75),
('77507', 'Krishnapur', 9, 75),
('77508', 'Beldandi', 5, 75),
('77509', 'Laljhadi', 6, 75),
('77101', 'Dhangadhi', 19, 71),
('77102', 'Tikapur ', 9, 71),
('77103', 'Ghodaghodi ', 12, 71),
('77104', 'Lamkichuha', 10, 71),
('77105', 'bhajani ', 9, 71),
('77106', 'Godawari', 12, 71),
('77107', 'Gauriganga', 11, 71),
('77108', 'Janaki', 9, 71),
('77109', 'Bardagoriya', 6, 71),
('77110', 'Mohanyal', 7, 71),
('77111', 'Kailari', 9, 71),
('77112', 'Joshipur ', 7, 71),
('77113', 'Chure', 6, 71),
('77001', 'Dipayal siladhi ', 9, 70),
('77002', 'Shikhar', 11, 70),
('77003', 'Purbichauki', 7, 70),
('77004', 'Badikedar', 5, 70),
('77005', 'Jorayal', 6, 70),
('77006', 'Sayal', 6, 70),
('77007', 'Aadarsh', 7, 70),
('77008', 'K.I.C', 7, 70),
('77009', 'Bogatan', 7, 70),
('76801', 'Mangalsen', 14, 68),
('76802', 'Kamalbajar', 10, 68),
('76803', 'Sanphebagar', 14, 68),
('76804', 'Panchadewal Binayak', 9, 68),
('76805', 'Chaurpati ', 7, 68),
('76806', 'Mellekh', 8, 68),
('76807', 'Bannigadi Jayagadh', 6, 68),
('76808', 'Ramaroshan', 7, 68),
('76809', 'Dhakari', 8, 68),
('76810', 'Turmakhad', 8, 68),
('76901', 'jayaprithvi', 11, 69),
('76902', 'Bungal', 11, 69),
('76903', 'Talkot', 7, 69),
('76904', 'Masta', 7, 69),
('76905', 'Khaptadchhanna', 7, 69),
('76906', 'Thalara', 9, 69),
('76907', 'Bitthadchir', 9, 69),
('76908', 'Surma ', 5, 69),
('76909', 'Chhabispathibhera', 7, 69),
('76910', 'Durgathali', 7, 69),
('76911', 'Kedarsyun', 9, 69),
('76912', 'Kanda', 5, 69),
('76701', 'Badimalika', 9, 67),
('76702', 'Tribeni', 9, 67),
('76703', 'Budhiganga', 10, 67),
('76704', 'Budhinanda', 10, 67),
('76705', 'Gaumun ', 6, 67),
('76706', 'Pandav', 6, 67),
('76707', 'Swamikartik', 5, 67),
('76708', 'Chhededaha', 7, 67),
('76709', 'Himali', 7, 67),
('77201', 'Mahakali', 9, 72),
('77202', 'Shailyashikar', 9, 72),
('77203', 'Malikarjun', 8, 72),
('77204', 'Apihimal', 6, 72),
('77205', 'Duhu ', 5, 72),
('77206', 'Naugad', 6, 72),
('77207', 'Marma', 6, 72),
('77208', 'Lekam', 6, 72),
('77209', 'Byash', 6, 72);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `companydetailtbl`
--
ALTER TABLE `companydetailtbl`
  ADD PRIMARY KEY (`companyId`);

--
-- Indexes for table `disabledtype`
--
ALTER TABLE `disabledtype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mainusertbl`
--
ALTER TABLE `mainusertbl`
  ADD PRIMARY KEY (`mId`), ADD KEY `fk_mainusertbl_companyId` (`companyId`), ADD KEY `fk_mainusertbl_userdetailId` (`userdetailId`);

--
-- Indexes for table `userdetailtbl`
--
ALTER TABLE `userdetailtbl`
  ADD PRIMARY KEY (`uId`);

--
-- Indexes for table `usertbl`
--
ALTER TABLE `usertbl`
  ADD PRIMARY KEY (`id`), ADD KEY `fk_usertbl_mId` (`mId`), ADD KEY `fk_usertbl_userdetailId` (`userdetailId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `companydetailtbl`
--
ALTER TABLE `companydetailtbl`
  MODIFY `companyId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `mainusertbl`
--
ALTER TABLE `mainusertbl`
  MODIFY `mId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `userdetailtbl`
--
ALTER TABLE `userdetailtbl`
  MODIFY `uId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usertbl`
--
ALTER TABLE `usertbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `mainusertbl`
--
ALTER TABLE `mainusertbl`
ADD CONSTRAINT `fk_mainusertbl_companyId` FOREIGN KEY (`companyId`) REFERENCES `companydetailtbl` (`companyId`) ON UPDATE CASCADE,
ADD CONSTRAINT `fk_mainusertbl_userdetailId` FOREIGN KEY (`userdetailId`) REFERENCES `userdetailtbl` (`uId`) ON UPDATE CASCADE;

--
-- Constraints for table `usertbl`
--
ALTER TABLE `usertbl`
ADD CONSTRAINT `fk_usertbl_mId` FOREIGN KEY (`mId`) REFERENCES `mainusertbl` (`mId`) ON UPDATE CASCADE,
ADD CONSTRAINT `fk_usertbl_userdetailId` FOREIGN KEY (`userdetailId`) REFERENCES `userdetailtbl` (`uId`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
