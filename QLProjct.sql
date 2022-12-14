USE [master]
GO
/****** Object:  Database [QLProject]    Script Date: 12/21/2021 2:28:55 PM ******/
CREATE DATABASE [QLProject]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLProject', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLProject.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLProject_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLProject_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QLProject] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLProject].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLProject] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLProject] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLProject] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLProject] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLProject] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLProject] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLProject] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLProject] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLProject] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLProject] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLProject] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLProject] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLProject] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLProject] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLProject] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLProject] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLProject] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLProject] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLProject] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLProject] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLProject] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLProject] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLProject] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLProject] SET  MULTI_USER 
GO
ALTER DATABASE [QLProject] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLProject] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLProject] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLProject] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLProject] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLProject] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLProject] SET QUERY_STORE = OFF
GO
USE [QLProject]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/21/2021 2:28:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maChiTietHD] [bigint] IDENTITY(1,1) NOT NULL,
	[maSanPham] [nvarchar](50) NOT NULL,
	[soLuongMua] [int] NOT NULL,
	[maHoaDon] [bigint] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maChiTietHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/21/2021 2:28:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [bigint] IDENTITY(1,1) NOT NULL,
	[maKhachHang] [bigint] NULL,
	[ngayMua] [datetime] NOT NULL,
	[daMua] [bit] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/21/2021 2:28:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [bigint] IDENTITY(1,1) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[soDienThoai] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[tenDangNhap] [nvarchar](50) NULL,
	[pass] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Loai]    Script Date: 12/21/2021 2:28:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Loai](
	[maLoai] [nvarchar](50) NOT NULL,
	[tenLoai] [nvarchar](50) NULL,
 CONSTRAINT [PK_Loai] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/21/2021 2:28:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nvarchar](50) NOT NULL,
	[tenSanPham] [nvarchar](100) NULL,
	[soLuong] [bigint] NULL,
	[gia] [bigint] NULL,
	[maLoai] [nvarchar](50) NULL,
	[anh] [nvarchar](50) NULL,
	[ngayNhap] [datetime] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (1, N'a1', 1, 1)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (15, N'a1', 1, 8)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (16, N'a2', 1, 8)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (17, N'a3', 1, 8)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (18, N'a1', 1, 9)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (19, N'a2', 1, 9)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (20, N'd1', 1, 9)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (21, N'a1', 1, 10)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (22, N'c3', 1, 10)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (23, N'b3', 1, 10)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (24, N'a1', 1, 11)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (25, N'a4', 1, 11)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (26, N'c3', 1, 11)
INSERT [dbo].[ChiTietHoaDon] ([maChiTietHD], [maSanPham], [soLuongMua], [maHoaDon]) VALUES (27, N'b6', 1, 11)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [ngayMua], [daMua]) VALUES (1, 1, CAST(N'2021-11-17T10:43:53.637' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [ngayMua], [daMua]) VALUES (8, 1, CAST(N'2021-12-17T13:24:26.293' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [ngayMua], [daMua]) VALUES (9, 1, CAST(N'2021-12-17T13:36:54.813' AS DateTime), 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [ngayMua], [daMua]) VALUES (10, 1, CAST(N'2021-12-19T07:05:03.890' AS DateTime), 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [maKhachHang], [ngayMua], [daMua]) VALUES (11, 1, CAST(N'2021-12-21T14:13:53.503' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [diaChi], [soDienThoai], [email], [tenDangNhap], [pass]) VALUES (1, N'Lê Văn Hiếu', N'Huế', N'0367891000', N'levanhieu2307@gmail.com', N'hieu', N'123')
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [diaChi], [soDienThoai], [email], [tenDangNhap], [pass]) VALUES (2, N'Hồ Quốc Hưng', N'Hồ Chí Minh', N'0312345678', N'nguyenkhachung@gmail.com', N'hung', N'123')
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [diaChi], [soDienThoai], [email], [tenDangNhap], [pass]) VALUES (3, N'Dương Đào Cát', N'Cần Thơ', N'0234567890', N'duongdaocat@gmail.com', N'cat', N'123')
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [diaChi], [soDienThoai], [email], [tenDangNhap], [pass]) VALUES (4, N'hieuưe', N'étfgty', N'32424', N'l3hi3ux2@gmail.com', N'hieee', N'123')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
INSERT [dbo].[Loai] ([maLoai], [tenLoai]) VALUES (N'Phong An', N'Nội Thất Phòng Ăn')
INSERT [dbo].[Loai] ([maLoai], [tenLoai]) VALUES (N'Phong Khach', N'Nội Thất Phòng Khách')
INSERT [dbo].[Loai] ([maLoai], [tenLoai]) VALUES (N'Phong Ngu', N'Nội Thất Phòng Ngủ')
INSERT [dbo].[Loai] ([maLoai], [tenLoai]) VALUES (N'Phong Tho', N'Nội Thất Phòng Thờ')
INSERT [dbo].[Loai] ([maLoai], [tenLoai]) VALUES (N'Tuong My Nghe', N'Tượng Mỹ Nghệ')
INSERT [dbo].[Loai] ([maLoai], [tenLoai]) VALUES (N'Van Phong', N'Nội Thất Văn Phòng')
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a1', N'Bộ bàn ghế chạm đào vai cong tay 10, 6 món – BBG257', 23, 37800000, N'Phong Khach', N'image_sach/a1.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a2', N'Bộ bàn ghế nghê đỉnh cẩm lai cột 14, 6 món – BBG208D', 43, 12345000, N'Phong Khach', N'image_sach/a2.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a3', N'Bộ sofa kiểu Nhật gõ đỏ 6 món BBG431', 23, 11234000, N'Phong Khach', N'image_sach/a3.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a4', N'Minh quốc Triện Gỗ Nu Nghiến Phiên Bản Giới Hạn cột 12,10 món – BBG535', 34, 12341000, N'Phong Khach', N'image_sach/a4.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a5', N'Bộ bàn ghế chạm đào gỗ nu nghiến Mặt liên Dày 3cm. tay 12, 10 món – BBG532', 32, 23124000, N'Phong Khach', N'image_sach/a5.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a6', N'Bộ bàn ghế tần thủy hoàng tay hộp cá chép hương đá – BBG775', 23, 23412000, N'Phong Khach', N'image_sach/a6.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a7', N'Sofa Hoàng gia lusso bọc vải dát vàng 6 món BBG861', 24, 25223000, N'Phong Khach', N'image_sach/a7.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a8', N'Bộ Sofa tân cổ điển 3 món hoàng gia Luxury Diamond BBG20', 31, 13123000, N'Phong Khach', N'image_sach/a8.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'a9', N'Bộ bàn ghế trống triện gỗ trắc tròn 7 món BBG1118', 12, 12314000, N'Phong Khach', N'image_sach/a9.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b1', N'Bàn ăn tròn hoàng gia gõ đỏ Louis Fidia Cẩn veneer – BAT789A', 32, 12312000, N'Phong An', N'image_sach/b1.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b2', N'Bàn ăn hoàng gia Fidia gỗ cẩm lai Việt cẩn nu veneer 1.27m – BA401', 21, 12213000, N'Phong An', N'image_sach/b2.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b3', N'Bộ bàn ăn Luois Cẩm Lai VIP 8 ghế – BBA431', 23, 10213000, N'Phong An', N'image_sach/b3.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b4', N'Bộ bàn ăn cabin hiện đại 4 ghế bàn vuông FUBBA6114V', 21, 10123000, N'Phong An', N'image_sach/b4.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b5', N'Bộ bàn ăn Hoàng Gia nguyên tấm Louis FIDIA 10 ghế', 23, 12324000, N'Phong An', N'image_sach/b5.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b6', N'Bộ bàn ăn gõ đỏ 8 ghế bọc nệm cổ điển BBA2348T', 41, 10013000, N'Phong An', N'image_sach/b6.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b7', N'Bộ bàn ăn căm xe 6 ghế hoa lá tây bàn vuông BBA1166V', 32, 21203000, N'Phong An', N'image_sach/b7.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b8', N'Bộ bàn ăn gỗ sồi nga 8 ghế chữ thọ bàn vuông BBA5538V', 21, 20129000, N'Phong An', N'image_sach/b8.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'b9', N'Bàn ăn gỗ sồi oval lớn 6 ghế – LCMBBA06', 20, 10012000, N'Phong An', N'image_sach/b9.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c1', N'Combo phòng ngủ Beauty queen', 32, 23412000, N'Phong Ngu', N'image_sach/c1.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c2', N'Combo phòng ngủ độc thân FA – CBPN02', 21, 21001000, N'Phong Ngu', N'image_sach/c2.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c3', N'Combo phòng ngủ cơ bản CBPN03', 12, 31012000, N'Phong Ngu', N'image_sach/c3.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c4', N'Combo phòng ngủ cổ điển dát vàng Noble', 14, 10213000, N'Phong Ngu', N'image_sach/c4.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c5', N'Combo phòng ngủ cá tính – SDXK231', 31, 12001000, N'Phong Ngu', N'image_sach/c5.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c6', N'Combo phòng ngủ cho trẻ em – SDXK30', 32, 12031000, N'Phong Ngu', N'image_sach/c6.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c7', N'Combo phòng ngủ tiện nghi cho cặp đôi – SDXK27', 12, 12323000, N'Phong Ngu', N'image_sach/c7.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c8', N'Combo phòng ngủ cho diện tích nhỏ – SDXK25', 13, 12030000, N'Phong Ngu', N'image_sach/c8.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'c9', N'Combo phòng ngủ nhỏ gọn – SDXK24', 41, 12312000, N'Phong Ngu', N'image_sach/c9.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'd1', N'Combo Phòng Thờ Đại Phú Quý – VIP', 23, 23122000, N'Phong Tho', N'image_sach/d1.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'd2', N'Combo phòng thờ tứ linh truyền thống đẹp', 21, 41231000, N'Phong Tho', N'image_sach/d2.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'd3', N'Mẫu phòng thờ không gian rộng MPT017', 32, 21312000, N'Phong Tho', N'image_sach/d3.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'd4', N'Mẫu phòng thờ nhà thờ họ đẹp MPT013', 41, 32123000, N'Phong Tho', N'image_sach/d4.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'd5', N'Mẫu phòng thờ hợp phong thuỷ MPT008', 23, 12312000, N'Phong Tho', N'image_sach/d5.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'e1', N'Tượng quan công gỗ hương cao 1m2 – QC12', 21, 12213000, N'Tuong My Nghe', N'image_sach/e1.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'e2', N'Tượng song mã phi thiên gốc tùng gỗ hương – TN102', 42, 32123000, N'Tuong My Nghe', N'image_sach/e2.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'e3', N'Phay cẩm lai trang trí – LT042', 31, 21233000, N'Tuong My Nghe', N'image_sach/e3.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'e4', N'Tượng trâu nằm phú quý gỗ trắc 30 – LVT10', 12, 12311000, N'Tuong My Nghe', N'image_sach/e4.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'e5', N'Nhất mã phi thiên gốc tùng gỗ hương 30 – TNM03', 32, 12312000, N'Tuong My Nghe', N'image_sach/e5.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'f1', N'Mẫu Bàn làm việc-BGD02', 32, 12321000, N'Van Phong', N'image_sach/f1.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'f2', N'Tủ sách hoàng gia gõ đỏ CEO Luxury – TSSD02
', 32, 32121000, N'Van Phong', N'image_sach/f2.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [soLuong], [gia], [maLoai], [anh], [ngayNhap]) VALUES (N'f3', N'Combo phòng làm việc CEO luxuxy', 34, 12312000, N'Van Phong', N'image_sach/f3.jpg', CAST(N'2017-09-15T19:25:58.897' AS DateTime))
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_Loai] FOREIGN KEY([maLoai])
REFERENCES [dbo].[Loai] ([maLoai])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_Loai]
GO
USE [master]
GO
ALTER DATABASE [QLProject] SET  READ_WRITE 
GO
