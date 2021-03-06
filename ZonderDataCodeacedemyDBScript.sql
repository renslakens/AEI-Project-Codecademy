USE [master]
GO
/****** Object:  Database [CodecademyDB]    Script Date: 16/01/2022 15:16:24 ******/
CREATE DATABASE [CodecademyDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CodecademyDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\CodecademyDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CodecademyDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\CodecademyDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [CodecademyDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CodecademyDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CodecademyDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CodecademyDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CodecademyDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CodecademyDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CodecademyDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [CodecademyDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [CodecademyDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CodecademyDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CodecademyDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CodecademyDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CodecademyDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CodecademyDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CodecademyDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CodecademyDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CodecademyDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [CodecademyDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CodecademyDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CodecademyDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CodecademyDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CodecademyDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CodecademyDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CodecademyDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CodecademyDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CodecademyDB] SET  MULTI_USER 
GO
ALTER DATABASE [CodecademyDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CodecademyDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CodecademyDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CodecademyDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [CodecademyDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [CodecademyDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [CodecademyDB] SET QUERY_STORE = OFF
GO
USE [CodecademyDB]
GO
/****** Object:  Table [dbo].[Certificate]    Script Date: 16/01/2022 15:16:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Certificate](
	[CertificaatID] [int] IDENTITY(1,1) NOT NULL,
	[Beoordeling] [int] NULL,
	[Ondertekenaar] [nvarchar](50) NULL,
	[Cursist] [nvarchar](50) NULL,
	[Cursus] [nvarchar](50) NULL,
	[GeslachtCursist] [nvarchar](50) NULL,
 CONSTRAINT [PK_Certificate] PRIMARY KEY CLUSTERED 
(
	[CertificaatID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContentItem]    Script Date: 16/01/2022 15:16:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContentItem](
	[ContentItemID] [int] NOT NULL,
	[Descriptie] [nvarchar](50) NULL,
	[Status] [nvarchar](50) NULL,
 CONSTRAINT [PK_ContentItem] PRIMARY KEY CLUSTERED 
(
	[ContentItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cursist]    Script Date: 16/01/2022 15:16:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cursist](
	[CursistID] [int] IDENTITY(1,1) NOT NULL,
	[CursistEmail] [nvarchar](50) NOT NULL,
	[Geboortedatum] [date] NULL,
	[Geslacht] [nvarchar](50) NULL,
	[Adres] [nvarchar](50) NULL,
	[Stad] [nvarchar](50) NULL,
	[Land] [nvarchar](50) NULL,
	[postcode] [nvarchar](50) NULL,
	[Naam] [nvarchar](50) NULL,
 CONSTRAINT [PK_Cursist] PRIMARY KEY CLUSTERED 
(
	[CursistID] ASC,
	[CursistEmail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cursussen]    Script Date: 16/01/2022 15:16:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cursussen](
	[VolgNummer] [int] IDENTITY(1,1) NOT NULL,
	[CursusNaam] [nvarchar](50) NOT NULL,
	[IntroductieTekst] [nvarchar](50) NULL,
	[Niveau] [nvarchar](50) NULL,
	[WebcastTitel] [nvarchar](50) NULL,
	[ModuleTitel] [nvarchar](50) NULL,
	[Onderwerp] [nvarchar](50) NULL,
 CONSTRAINT [PK_Cursussen_1] PRIMARY KEY CLUSTERED 
(
	[CursusNaam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Inschrijvingen]    Script Date: 16/01/2022 15:16:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inschrijvingen](
	[InschrijvingID] [int] IDENTITY(1,1) NOT NULL,
	[CursistEmail] [nvarchar](50) NULL,
	[CursusNaam] [nvarchar](50) NULL,
	[RegistratieDatum] [date] NULL,
 CONSTRAINT [PK_Inschrijvingen] PRIMARY KEY CLUSTERED 
(
	[InschrijvingID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[InterestingCursus]    Script Date: 16/01/2022 15:16:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InterestingCursus](
	[CursusNaam] [nvarchar](50) NOT NULL,
	[InterestingCursus] [nvarchar](50) NOT NULL,
	[CursusID] [int] NULL,
 CONSTRAINT [PK_InterestingCursus] PRIMARY KEY CLUSTERED 
(
	[CursusNaam] ASC,
	[InterestingCursus] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Modules]    Script Date: 16/01/2022 15:16:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Modules](
	[ContentItemID] [int] IDENTITY(1,1) NOT NULL,
	[Titel] [nvarchar](50) NULL,
	[Versie] [nvarchar](50) NULL,
	[Beschrijving] [nvarchar](50) NULL,
	[ContactNaam] [nvarchar](50) NULL,
	[ContactEmail] [nvarchar](50) NULL,
 CONSTRAINT [PK_Modules] PRIMARY KEY CLUSTERED 
(
	[ContentItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Webcasts]    Script Date: 16/01/2022 15:16:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Webcasts](
	[ContentItemID] [int] IDENTITY(1,1) NOT NULL,
	[Tijdsduur] [int] NULL,
	[Url] [nvarchar](50) NULL,
	[Spreker] [nvarchar](50) NULL,
	[Organisatie] [nvarchar](50) NULL,
	[Titel] [nvarchar](50) NULL,
	[DatumPublicatie] [date] NULL,
	[Beschrijving] [nvarchar](500) NULL,
 CONSTRAINT [PK_Webcasts] PRIMARY KEY CLUSTERED 
(
	[ContentItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[InterestingCursus]  WITH CHECK ADD  CONSTRAINT [FK_InterestingCursus_Cursussen] FOREIGN KEY([CursusNaam])
REFERENCES [dbo].[Cursussen] ([CursusNaam])
GO
ALTER TABLE [dbo].[InterestingCursus] CHECK CONSTRAINT [FK_InterestingCursus_Cursussen]
GO
USE [master]
GO
ALTER DATABASE [CodecademyDB] SET  READ_WRITE 
GO
