-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 01, 2023 lúc 02:48 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `medisure`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `authority`
--

CREATE TABLE `authority` (
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `authority`
--

INSERT INTO `authority` (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_DOCTOR'),
('ROLE_USER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog`
--

CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL,
  `content` mediumtext DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `description` mediumtext DEFAULT NULL,
  `image_banner` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `blog`
--

INSERT INTO `blog` (`id`, `content`, `created_date`, `description`, `image_banner`, `title`) VALUES
(2, '<h2><strong>1. Thời gian v&agrave; địa điểm ph&aacute;t h&agrave;nh hồ sơ y&ecirc;u cầu (HSYC):</strong></h2>\n<ul>\n<li style=\"font-weight: bold; font-style: italic;\"><em><strong>Thời gian bán HSYC: từ 9h00 ngày 05 tháng 01 năm 2017 đ&ecirc;́n 9h00 ngày 16 tháng 01 năm 2017</strong></em></li>\n<li>Địa điểm ph&aacute;t h&agrave;nh:<hr>Văn phòng đi&ecirc;̀u hành B&ecirc;̣nh Vi&ecirc;̣n Thu Cúc &ndash; 286 Thụy Khu&ecirc;, phường Bưởi, Ba Đình, Hà N&ocirc;̣i. (Li&ecirc;n h&ecirc;̣: Phùng Th&ecirc;́ Sơn &ndash; 0988091580)</li>\n<li>Nh&agrave; thầu khi đến mua hồ sơ cần c&oacute; giấy giới thiệu, h&ocirc;̀ sơ năng lực của c&ocirc;ng ty v&agrave; chi ph&iacute; mua hồ sơ l&agrave; 1.000.000đ/bộ.</li>\n</ul>\n<h2><strong>2. Thời gian v&agrave; địa điểm nộp hồ sơ đ&ecirc;̀ xu&acirc;́t (HSĐX):</strong></h2>\n<ul>\n<li>Thời gian nộp hồ sơ đề xuất: trước 9h00 ngày 16 tháng 01 năm 2017</li>\n<li>Địa điểm nộp hồ sơ đề xuất: t&acirc;̀ng 1, s&ocirc;́ 278 Thụy Khu&ecirc;, Ba Đình, Hà N&ocirc;̣i. (Li&ecirc;n h&ecirc;̣: Phùng Th&ecirc;́ Sơn &ndash; 0988091580)</li>\n</ul>\n<h2><strong>3. Nội dung mời ch&agrave;o gi&aacute;:</strong></h2>\n<ul>\n<li>T&ecirc;n g&oacute;i thầu: Thi c&ocirc;ng x&acirc;y dựng th&ocirc; v&agrave; ho&agrave;n thiện phần th&acirc;n đến m&aacute;i</li>\n<li>T&ecirc;n dự &aacute;n: Thu C&uacute;c Clinics kết hợp nh&agrave; h&agrave;ng.</li>\n<li>Địa điểm x&acirc;y dựng: 52 Lý Thường Ki&ecirc;̣t, Hoàn Ki&ecirc;́m, Hà N&ocirc;̣i.</li>\n<li>Chủ đầu tư: C&ocirc;ng ty CP Y Khoa &amp; Th&acirc;̉m Mỹ Thu Cúc.</li>\n<li>H&igrave;nh thức lựa chọn Nh&agrave; thầu: Ch&agrave;o hàng cạnh tranh x&acirc;y lắp.</li>\n<li>Phạm vi c&ocirc;ng việc của g&oacute;i thầu: thi c&ocirc;ng x&acirc;y dựng th&ocirc; và hoàn thi&ecirc;̣n đ&ecirc;́n mái.</li>\n</ul>\n<p><em>Chi tiết phạm vi c&ocirc;ng việc theo Ti&ecirc;n lượng đ&iacute;nh k&egrave;m h&ocirc;̀ sơ y&ecirc;u c&acirc;̀u.</em></p>\n<ul>\n<li>Thời gian thực hiện Hợp đồng: 150 ng&agrave;y.</li>\n<li>Hình thức lựa chọn nhà th&acirc;̀u : Chào hàng cạnh tranh x&acirc;y lắp</li>\n<li>Phương thức lựa chọn nhà th&acirc;̀u: M&ocirc;̣t giai đoạn hai túi h&ocirc;̀ sơ</li>\n<li>Bảo đảm dự th&acirc;̀u: 100.000.000 (m&ocirc;̣t trăm tri&ecirc;̣u đ&ocirc;̀ng) bằng bảo lãnh ng&acirc;n hàng hoặc ti&ecirc;̀n mặt</li>\n</ul>\n<h2><strong>4. Th&agrave;nh phần hồ sơ y&ecirc;u c&acirc;̀u và hình thức h&ocirc;̀ sơ đ&ecirc;̀ xu&acirc;́t:</strong></h2>\n<ul>\n<li>Thư mời ch&agrave;o hàng.</li>\n<li>Hồ sơ thiết kế bản vẽ thi c&ocirc;ng đ&atilde; được CĐT ph&ecirc; duyệt.</li>\n<li>H&ocirc;̀ sơ y&ecirc;u c&acirc;̀u chào hàng cạnh tranh x&acirc;y lắp</li>\n<li>Số lượng hồ sơ đề xuất: 01 bộ hồ sơ đề xuất bản g&ocirc;́c và 5 bản sao + 01 đĩa CD/USB lưu to&agrave;n bộ dữ liệu của hồ sơ đề xuất. Hồ sơ đề xuất phải được ni&ecirc;m phong trong phong b&igrave; k&iacute;n</li>\n<li>Hiệu lực của hồ sơ đề xuất: 70 ng&agrave;y kể từ thời đi&ecirc;̉m đóng th&acirc;̀u</li>\n</ul>\n<p><strong>&nbsp; Tr&acirc;n trọng kính mời Quý c&ocirc;ng ty tham dự th&acirc;̀u !</strong><br><strong>&nbsp; &nbsp;Xin cảm ơn!</strong></p>', '2023-03-03', 'Công ty cổ phần y khoa & thẩm mỹ Thu Cúc (sau đây gọi là Bên mời thầu) chuẩn bị tổ chức chào hàng cạnh tranh xây lắp gói thầu số 2 \" Thi công xây dựng thô và hoàn thiện phần...', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1677819675/at4tz3sdz3nfuwidydgf.png', 'Mời thầu dự án \"Thi công xây dựng thô và hoàn thiện1'),
(3, '<h2><strong>1. G&oacute;i thầu số 1:</strong>&nbsp;<strong>G&oacute;i thầu cung cấp thuốc theo t&ecirc;n biệt dược hoặc tương đương điều trị</strong></h2>\n<p>Gi&aacute; g&oacute;i thầu: 37.313.298.777 đ (Bằng chữ: Ba mươi bảy tỷ, ba trăm mười ba triệu, hai trăm ch&iacute;n mươi t&aacute;m ngh&igrave;n, bảy trăm bảy mươi bảy đồng chẵn./.)</p>\n<h2><span id=\"2-Goi-thau-so-2-Goi-thau-cung-cap-thuoc-theo-ten-Generic\" class=\"ez-toc-section\"></span><strong>2. G&oacute;i thầu số 2: G&oacute;i thầu cung cấp thuốc theo t&ecirc;n Generic</strong></h2>\n<p>Gi&aacute; g&oacute;i thầu: 17.189.282.881 đ (Bằng chữ: Mười bảy tỷ, một trăm t&aacute;m mươi ch&iacute;n triệu, hai trăm t&aacute;m mươi hai ngh&igrave;n, t&aacute;m trăm t&aacute;m mươi mốt đồng chẵn./.)</p>\n<h2><span id=\"3-Goi-thau-so-3-Thuoc-dong-y-va-thuoc-tu-duoc-lieu\" class=\"ez-toc-section\"></span><strong>3. G&oacute;i thầu số 3: Thuốc đ&ocirc;ng y v&agrave; thuốc từ dược liệu</strong></h2>\n<p>Gi&aacute; g&oacute;i thầu: 256.278.200 đ (Bằng chữ: Hai trăm năm mươi s&aacute;u triệu, hai trăm bảy mươi t&aacute;m ngh&igrave;n, hai trăm đồng chẵn./.)</p>\n<h2><span id=\"4-Goi-thau-so-5-Vat-tu-y-te-chat-lieu-tham-my\" class=\"ez-toc-section\"></span><strong>4. G&oacute;i thầu số 5: Vật tư y tế &amp; chất liệu thẩm mỹ</strong></h2>\n<p>Gi&aacute; g&oacute;i thầu: 8.786.564.125 đ (T&aacute;m tỷ, bảy trăm t&aacute;m mươi s&aacute;u triệu, năm trăm s&aacute;u mươi bốn ngh&igrave;n, một trăm hai mươi lăm đồng chẵn./.)</p>\n<h2><span id=\"5-Thoi-gian-phat-hanh-ho-so-moi-thau\" class=\"ez-toc-section\"></span><strong>5. Thời gian ph&aacute;t h&agrave;nh hồ sơ mời thầu:</strong></h2>\n<p><em>&ndash;</em><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</em><em>&nbsp;</em><em>G&oacute;i thầu số 1</em>: từ 09 giờ 00 ng&agrave;y 12 th&aacute;ng 01 năm 2017 đến trước 09 giờ 00 ng&agrave;y&nbsp; 08 th&aacute;ng 02 năm 2017.<br><em>&ndash;</em><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</em><em>&nbsp;</em><em>G&oacute;i thầu số 2:</em>&nbsp;từ 14 giờ 00 ng&agrave;y 12 th&aacute;ng 01 năm 2017 đến trước 14 giờ 00 ng&agrave;y 08 th&aacute;ng 02 năm 2017.<br><em>&ndash;</em><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</em><em>&nbsp;</em><em>G&oacute;i thầu số 3:</em>&nbsp;từ 09 giờ 00 ng&agrave;y 12 th&aacute;ng 01 năm 2017 đến trước 09 giờ 00 ng&agrave;y 23 th&aacute;ng 01 năm 2017.<br><em>&ndash;</em><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</em><em>&nbsp;</em><em>G&oacute;i thầu số 5:</em>&nbsp;từ 09 giờ 00 ng&agrave;y 12 th&aacute;ng 01 năm 2017 đến trước 09 giờ 00 ng&agrave;y 06 th&aacute;ng 02 năm 2017</p>', '2023-03-03', 'Bệnh viện Đa khoa Quốc tế Thu Cúc tổ chức mời thầu các gói thầu sau: 1. Gói thầu số 1: Gói thầu cung cấp thuốc theo tên biệt dược hoặc tương đương điều trị Giá gói thầu: 37.313.298.777 đ', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1677819750/wjyjxmwkfty23mfgtbya.png', 'Bệnh viện Thu Cúc tổ chức mời thầu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `detail_invoice`
--

CREATE TABLE `detail_invoice` (
  `id` bigint(20) NOT NULL,
  `invoice_id` bigint(20) DEFAULT NULL,
  `medical_process_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `detail_invoice`
--

INSERT INTO `detail_invoice` (`id`, `invoice_id`, `medical_process_id`) VALUES
(28, 13, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `doctors`
--

CREATE TABLE `doctors` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` mediumtext DEFAULT NULL,
  `fulll_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `specialist_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `doctors`
--

INSERT INTO `doctors` (`id`, `address`, `description`, `fulll_name`, `phone`, `specialist_id`, `user_id`) VALUES
(3, 'Bình Định', '<p>Người ta thường n&oacute;i b&aacute;c sĩ khoa nội l&agrave; &ldquo;b&aacute;c sĩ của c&aacute;c b&aacute;c sĩ&rdquo; v&agrave; thường được mời tư vấn cho c&aacute;c b&aacute;c sĩ chuy&ecirc;n khoa kh&aacute;c trong những trường hợp chẩn đo&aacute;n kh&oacute;.</p>\n<p>Nội khoa cung cấp c&aacute;c dịch vụ kh&aacute;m sức khỏe tổng qu&aacute;t cũng như chẩn đo&aacute;n v&agrave; điều trị c&aacute;c bệnh như: tim mạch, thần kinh, ti&ecirc;u h&oacute;a, h&ocirc; hấp&hellip;B&aacute;c sĩ khoa nội cũng l&agrave; người thực hiện kh&aacute;m l&acirc;m s&agrave;ng khi bạn c&oacute; những triệu chứng kh&oacute; chịu v&agrave; kh&ocirc;ng r&otilde; nguy&ecirc;n nh&acirc;n.</p>\n<p>Ngo&agrave;i ra b&aacute;c sĩ khoa nội tổng qu&aacute;t cũng sẽ kết hợp với c&aacute;c b&aacute;c sĩ chuy&ecirc;n khoa để đưa ra phương &aacute;n điều trị tốt nhất cho bạn.</p>\n<p>Kh&aacute;c với b&aacute;c sĩ chuy&ecirc;n khoa chỉ tập trung điều trị cho một cơ quan trong cơ thể chẳng hạn như tim mạch, da liễu&hellip;C&aacute;c b&aacute;c sĩ nội khoa tổng qu&aacute;t c&oacute; thể điều trị nhiều bệnh kh&aacute;c nhau hoặc c&oacute; thể ảnh hưởng c&ugrave;ng l&uacute;c đến nhiều cơ quan kh&aacute;c nhau như: c&aacute;c bệnh rối loạn miễn nhiễm như: luput ban đỏ, ph&ugrave; cứng b&igrave; c&oacute; thể ảnh hưởng đến thần kinh da, phổi, thận v&agrave; c&aacute;c bộ phận kh&aacute;c..</p>\n<p>C&aacute;c chuy&ecirc;n ng&agrave;nh thăm kh&aacute;m của khoa nội rất đa dạng chẳng hạn như:</p>\n<ul>\n<li>Dị ứng</li>\n<li>Nội tim mạch</li>\n<li>Nội tiết</li>\n<li>Nội ung bướu</li>\n<li>Khoa ti&ecirc;u h&oacute;a</li>\n<li>L&atilde;o Huyết học</li>\n<li>&nbsp;</li>\n<li>Bệnh l&acirc;y nhiễm</li>\n<li>Nội thận</li>\n<li>Khoa h&ocirc; hấp</li>\n<li>Phong thấp</li>\n</ul>\n<p>C&aacute;c b&aacute;c sĩ nội khoa c&ograve;n rất gi&agrave;u kinh nghiệm trong việc chẩn đo&aacute;n v&agrave; điều trị c&aacute;c bệnh l&yacute; li&ecirc;n quan truyền nhiễm, lao phổi, k&yacute; sinh tr&ugrave;ng, am hiểu c&aacute;c lĩnh vực chuy&ecirc;n khoa phụ về tim mạch, phổi, thận v&agrave; huyết học&hellip;</p>', 'Nguyễn Công Đạt', '0385976084', 12, 3),
(4, 'Hồ Chí Minh', '<p>Bệnh da liễu l&agrave; nh&oacute;m bệnh rất dễ gặp ở nhiều đối tượng kh&aacute;c nhau, điển h&igrave;nh trong đ&oacute; l&agrave; c&aacute;c bệnh phổ biến như: Vi&ecirc;m da, thủy đậu, dị ứng da, nổi mụn, nổi mề đay, ung thư da, vảy nến, chốc lở, bạch biến, mụn c&oacute;c,....</p>\n<p>Trong số những bệnh l&yacute; n&agrave;y c&oacute; những bệnh sẽ tự khỏi sau một thời gian nhất định, thế nhưng cũng c&oacute; một số bệnh nếu kh&ocirc;ng được b&aacute;c sĩ chuy&ecirc;n khoa thăm kh&aacute;m, điều trị đ&uacute;ng c&aacute;ch sẽ dễ d&agrave;ng biến chứng g&acirc;y ra c&aacute;c vấn đề sức khỏe c&oacute; li&ecirc;n quan.</p>\n<p>C&aacute;c b&aacute;c sĩ da liễu khuy&ecirc;n bệnh nh&acirc;n cần ch&uacute; &yacute; đến c&aacute;c bất thường về da, t&oacute;c, m&oacute;ng, l&ocirc;ng v&agrave; đặc biệt n&ecirc;n đi kh&aacute;m ngay khi xuất hiện c&aacute;c tổn thương tr&ecirc;n cơ thể k&eacute;o d&agrave;i kh&ocirc;ng thuy&ecirc;n giảm, c&aacute;c tổn thương như l&agrave;:</p>', 'Nguyễn Nhật Á Tiên', '0123456798', 2, 5),
(5, 'Quảng Bình', '<div class=\"box_right\">\n<div class=\"box04__main\">\n<div id=\"price02\" class=\"box_twoprice block block-price2 red active\">\n<div class=\"buyol\">\n<ul class=\"tm-list tm-list-style-icon\">\n<li>Trợ l&yacute; Gi&aacute;m đốc Bệnh viện Tai Mũi Họng S&agrave;i G&ograve;n &ndash; Ph&ograve;ng kh&aacute;m Đa khoa Quốc tế S&agrave;i G&ograve;n</li>\n<li>Ph&oacute; Trưởng Cơ sở 2 phụ tr&aacute;ch chuy&ecirc;n m&ocirc;n, Bệnh viện Đại học Y Dược &ndash; TP.HCM</li>\n<li>Ph&oacute; Khoa Điều dưỡng Kỹ thuật Y học &ndash; Đại học Y Dược &ndash; Tp.HCM</li>\n<li>Ph&oacute; Gi&aacute;m đốc Trung t&acirc;m đ&agrave;o tạo nh&acirc;n lực y tế theo nhu cầu x&atilde; hội đại học Y Dược TP. Hồ Ch&iacute; Minh</li>\n</ul>\n</div>\n</div>\n</div>\n</div>', 'Nguyễn Văn Quang', '0321654789', 4, 8),
(6, 'Bảo Lộc', '<p>Chuy&ecirc;n khoa Tim mạch l&agrave; một ng&agrave;nh quan trọng thuộc khối Y học l&acirc;m s&agrave;ng, giữ chức năng kh&aacute;m, chẩn đo&aacute;n, tư vấn v&agrave; điều trị c&aacute;c bệnh l&yacute; li&ecirc;n quan đến hệ thống tim mạch, cơ quan quan trọng gi&uacute;p duy tr&igrave; sự sống của con người.<br>Chuy&ecirc;n khoa Tim mạch được ph&acirc;n th&agrave;nh c&aacute;c lĩnh vực Nội Tim mạch, Can thiệp tim mạch v&agrave; Ngoại Tim mạch, chuy&ecirc;n s&acirc;u về điều trị c&aacute;c bệnh l&yacute;: mạch m&aacute;u; van tim; cơ tim; rối loạn nhịp tim; tim bẩm sinh; tim nhiễm khuẩn,&hellip;<br>C&aacute;c phương ph&aacute;p điều trị đang được &aacute;p dụng tại chuy&ecirc;n khoa Tim mạch:</p>\n<ul>\n<li>Kh&aacute;m l&acirc;m s&agrave;ng: Kiểm tra huyết &aacute;p, nghe tim, kh&aacute;m c&aacute;c dấu hiệu v&agrave; triệu chứng.</li>\n<li>X&eacute;t nghiệm m&aacute;u: Kiểm tra t&igrave;nh trạng thiếu m&aacute;u, nồng độ cholesterol, đ&aacute;i th&aacute;o đường, suy tim,&hellip;</li>\n</ul>', 'Nguyễn Vũ Đức Minh', '0912732132', 1, 11),
(7, 'Bảo Lộc Đà Lạt', '<p>Mắt là cơ quan nhỏ bé nhưng v&ocirc; cùng quan trọng trong đời s&ocirc;́ng con người. Mắt là cơ quan thị giác thực hi&ecirc;̣n chức năng nhìn, quan sát, thu nh&acirc;̣n lại hình ảnh của sự v&acirc;̣t, màu sắc đ&ecirc;̉ chuy&ecirc;̉n vào não xử lý và lưu trữ. C&ugrave;ng t&igrave;m hiểu cấu tạo v&agrave; cơ chế hoạt động của mắt.</p>', 'Nguyễn Minh Nhật', '1233211233', 9, 14),
(8, 'Tiền Giang', '<ul>\n<li class=\"\">C&agrave;ng ng&agrave;y đột quỵ, tai biến c&oacute; xu hướng trẻ h&oacute;a độ tuổi. V&igrave; lối sống ng&agrave;y nay của c&aacute;c bạn trẻ thay đổi: Hay thức khuya, ăn uống kh&ocirc;ng l&agrave;nh mạnh, nhiều đồ dầu mỡ, sử dụng chất k&iacute;ch th&iacute;ch như rượu, thuốc l&aacute;..., &iacute;t vận động.</li>\n</ul>', 'Võ Lê Nhựt Khang', '2020202020', 13, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `schedule_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `invoice`
--

INSERT INTO `invoice` (`id`, `created_date`, `note`, `total_amount`, `schedule_id`) VALUES
(13, '2023-04-01 19:40:01', 'Có sử dụng bảo hiểm ', NULL, 23);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `medical_process`
--

CREATE TABLE `medical_process` (
  `id` bigint(20) NOT NULL,
  `description` mediumtext DEFAULT NULL,
  `price` double DEFAULT NULL,
  `process_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `medical_process`
--

INSERT INTO `medical_process` (`id`, `description`, `price`, `process_name`) VALUES
(1, 'Đo điện tâm đồ', 200000, 'Điện tâm đồ'),
(2, 'Đo điện não', 200000, 'Điện điện não'),
(3, 'Xét nghiệm máu với 25 chỉ số', 500000, 'Xét nghiệm máu'),
(4, 'Chụp xquang theo yêu cầu bác sĩ', 1000000, 'Chụp X-Quang'),
(5, 'Băng bó vết thương theo vị trí', 300000, 'Băng bó'),
(6, 'Thuốc bác sĩ cấp', 100000, 'Thuốc điều trị');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `patient_record`
--

CREATE TABLE `patient_record` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `fulll_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `specialist_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `patient_record`
--

INSERT INTO `patient_record` (`id`, `address`, `description`, `fulll_name`, `phone`, `specialist_id`, `user_id`) VALUES
(6, 'Tây Tạnh', 'Đau lưng mỏi gối tê tay', 'Nguyễn Minh Trọng Nhân', '0987654321', 13, 16),
(7, '153 Ly Thuong Kiet Street, Ward 7, District 11, Ho Chi Minh City, VietNam', 'Dị ứng đỏ cả người', 'Nguyễn Thị Kim Ngân', '1239867421', 2, 17);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `requests`
--

CREATE TABLE `requests` (
  `id` bigint(20) NOT NULL,
  `active_date` datetime DEFAULT NULL,
  `actived` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `created_time` time DEFAULT NULL,
  `patient_record_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rooms`
--

CREATE TABLE `rooms` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedules_as`
--

CREATE TABLE `schedules_as` (
  `id` bigint(20) NOT NULL,
  `booking_date` date DEFAULT NULL,
  `booking_time` time DEFAULT NULL,
  `medicines` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `patient_record_id` bigint(20) DEFAULT NULL,
  `to_time` time DEFAULT NULL,
  `confirm` int(11) DEFAULT NULL,
  `paid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `schedules_as`
--

INSERT INTO `schedules_as` (`id`, `booking_date`, `booking_time`, `medicines`, `note`, `doctor_id`, `patient_record_id`, `to_time`, `confirm`, `paid`) VALUES
(23, '2023-04-02', '08:00:00', NULL, NULL, 8, 6, '09:00:00', 0, 1),
(24, '2023-04-01', '13:00:00', NULL, NULL, 4, 7, '14:00:00', 0, 0),
(25, '2023-04-03', '12:00:00', NULL, NULL, 3, 6, '13:00:00', 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `specialist`
--

CREATE TABLE `specialist` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `specialist`
--

INSERT INTO `specialist` (`id`, `name`) VALUES
(2, 'Khoa Da Liễu'),
(14, 'Khoa Mắt'),
(13, 'Khoa Ngoại'),
(12, 'Khoa Nội '),
(4, 'Khoa Tai Mũi Họng'),
(9, 'Khoa Tiêu Hóa'),
(1, 'Khoa Tim Mạch');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `activation_key` varchar(255) DEFAULT NULL,
  `actived` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remember_key` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `activation_key`, `actived`, `created_date`, `email`, `password`, `remember_key`, `sex`, `username`, `avatar`) VALUES
(1, NULL, 1, '2023-02-21 22:24:19', 'admin@gmail.com', '$2a$10$54Y5FJcv56/kA3Q9joFaAulVBFemfCz6FmfmnM/9Up1DwUgK5cmeO', NULL, NULL, 'admin', NULL),
(3, NULL, 1, '2023-02-21 22:32:41', 'congdat.hutech@gmail.com', '$2a$10$54Y5FJcv56/kA3Q9joFaAulVBFemfCz6FmfmnM/9Up1DwUgK5cmeO', NULL, 0, 'datbs', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1680351128/s4tascuhc0cthawgxvyj.jpg'),
(5, NULL, 1, '2023-02-21 23:02:55', 'atien130301@gmail.com', '$2a$10$54Y5FJcv56/kA3Q9joFaAulVBFemfCz6FmfmnM/9Up1DwUgK5cmeO', NULL, 1, 'tienbs', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1680351249/p6cqwl9bysgxwyqswo88.jpg'),
(8, NULL, 1, '2023-03-02 23:50:38', 'vanquang@gmail.com', '$2a$10$54Y5FJcv56/kA3Q9joFaAulVBFemfCz6FmfmnM/9Up1DwUgK5cmeO', NULL, 0, 'quangbs', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1680351453/logwvti026umbqng6jvn.jpg'),
(11, NULL, 1, '2023-03-05 19:46:43', 'nguyenvuducminh1001@gmail.com', '$2a$10$54Y5FJcv56/kA3Q9joFaAulVBFemfCz6FmfmnM/9Up1DwUgK5cmeO', NULL, 0, 'minhbs', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1680351510/vjshc8itmpurr1qymkfk.jpg'),
(14, NULL, 1, '2023-04-01 19:19:37', 'minhnhat@gmail.com', '$2a$10$54Y5FJcv56/kA3Q9joFaAulVBFemfCz6FmfmnM/9Up1DwUgK5cmeO', NULL, 0, 'nhatbs', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1680351578/nw9pnwbmoglrwkunx0nw.jpg'),
(15, NULL, 1, '2023-04-01 19:21:12', 'nhutkhang@gmail.com', '$2a$10$54Y5FJcv56/kA3Q9joFaAulVBFemfCz6FmfmnM/9Up1DwUgK5cmeO', NULL, 0, 'khangbs', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1680351672/i73621iol9lcfodanvm1.jpg'),
(16, NULL, 1, '2023-04-01 19:28:39', 'trongnhan@gmail.com', '$2a$10$drnucvtjWHlNPO6voBxBzOGP.XKJWix4RZuywS2JrQfz.lA6Rl0JW', NULL, 0, 'trongnhan', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1680352120/noukcg4pkpdbc6llrerb.jpg'),
(17, NULL, 1, '2023-04-01 19:41:30', 'nguyenngancontact@gmail.com', '$2a$10$tNun9o6muXG4KamIq2dI3u7lf/bg4bTp5eL9sI7pmB6x1v0wZoDzO', NULL, 1, 'ngan', 'http://res.cloudinary.com/dwfciuqmd/image/upload/v1680352890/ig9yt6o4xtszy6fjye6g.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_authority`
--

CREATE TABLE `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user_authority`
--

INSERT INTO `user_authority` (`user_id`, `authority_name`) VALUES
(1, 'ROLE_ADMIN'),
(3, 'ROLE_DOCTOR'),
(5, 'ROLE_DOCTOR'),
(8, 'ROLE_DOCTOR'),
(11, 'ROLE_DOCTOR'),
(14, 'ROLE_DOCTOR'),
(15, 'ROLE_DOCTOR'),
(16, 'ROLE_USER'),
(17, 'ROLE_USER');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `authority`
--
ALTER TABLE `authority`
  ADD PRIMARY KEY (`name`);

--
-- Chỉ mục cho bảng `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `detail_invoice`
--
ALTER TABLE `detail_invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmt3tg7l0sp2hj0hyrglrmlbxr` (`invoice_id`),
  ADD KEY `FK8kn0u5spisf6f9x17gnjuayqc` (`medical_process_id`);

--
-- Chỉ mục cho bảng `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpe805shixe4h39ty7mktc99l9` (`specialist_id`),
  ADD KEY `FK1kdokdbkomgra23x78ttur43p` (`user_id`);

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrn85j4orttpce4n7ltsarurhc` (`schedule_id`);

--
-- Chỉ mục cho bảng `medical_process`
--
ALTER TABLE `medical_process`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `patient_record`
--
ALTER TABLE `patient_record`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKet73j9jgpy8pseupwtaccxsb7` (`specialist_id`),
  ADD KEY `FK5biuumfh2h15hcw6cn0nqjxml` (`user_id`);

--
-- Chỉ mục cho bảng `requests`
--
ALTER TABLE `requests`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8uaas49do848tochg1oaiku7j` (`patient_record_id`);

--
-- Chỉ mục cho bảng `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `schedules_as`
--
ALTER TABLE `schedules_as`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6bh8wawg76kbtiar24klntwqf` (`doctor_id`),
  ADD KEY `FKe2i9rnm79u1ii8on4cmgd7bs1` (`patient_record_id`);

--
-- Chỉ mục cho bảng `specialist`
--
ALTER TABLE `specialist`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Chỉ mục cho bảng `user_authority`
--
ALTER TABLE `user_authority`
  ADD PRIMARY KEY (`user_id`,`authority_name`),
  ADD KEY `FK6ktglpl5mjosa283rvken2py5` (`authority_name`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `blog`
--
ALTER TABLE `blog`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `detail_invoice`
--
ALTER TABLE `detail_invoice`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `medical_process`
--
ALTER TABLE `medical_process`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `patient_record`
--
ALTER TABLE `patient_record`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `requests`
--
ALTER TABLE `requests`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `schedules_as`
--
ALTER TABLE `schedules_as`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT cho bảng `specialist`
--
ALTER TABLE `specialist`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `detail_invoice`
--
ALTER TABLE `detail_invoice`
  ADD CONSTRAINT `FK8kn0u5spisf6f9x17gnjuayqc` FOREIGN KEY (`medical_process_id`) REFERENCES `medical_process` (`id`),
  ADD CONSTRAINT `FKmt3tg7l0sp2hj0hyrglrmlbxr` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`);

--
-- Các ràng buộc cho bảng `doctors`
--
ALTER TABLE `doctors`
  ADD CONSTRAINT `FK1kdokdbkomgra23x78ttur43p` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKpe805shixe4h39ty7mktc99l9` FOREIGN KEY (`specialist_id`) REFERENCES `specialist` (`id`);

--
-- Các ràng buộc cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `FKrn85j4orttpce4n7ltsarurhc` FOREIGN KEY (`schedule_id`) REFERENCES `schedules_as` (`id`);

--
-- Các ràng buộc cho bảng `patient_record`
--
ALTER TABLE `patient_record`
  ADD CONSTRAINT `FK5biuumfh2h15hcw6cn0nqjxml` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKet73j9jgpy8pseupwtaccxsb7` FOREIGN KEY (`specialist_id`) REFERENCES `specialist` (`id`);

--
-- Các ràng buộc cho bảng `requests`
--
ALTER TABLE `requests`
  ADD CONSTRAINT `FK8uaas49do848tochg1oaiku7j` FOREIGN KEY (`patient_record_id`) REFERENCES `patient_record` (`id`);

--
-- Các ràng buộc cho bảng `schedules_as`
--
ALTER TABLE `schedules_as`
  ADD CONSTRAINT `FK6bh8wawg76kbtiar24klntwqf` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  ADD CONSTRAINT `FKe2i9rnm79u1ii8on4cmgd7bs1` FOREIGN KEY (`patient_record_id`) REFERENCES `patient_record` (`id`);

--
-- Các ràng buộc cho bảng `user_authority`
--
ALTER TABLE `user_authority`
  ADD CONSTRAINT `FK6ktglpl5mjosa283rvken2py5` FOREIGN KEY (`authority_name`) REFERENCES `authority` (`name`),
  ADD CONSTRAINT `FKpqlsjpkybgos9w2svcri7j8xy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
