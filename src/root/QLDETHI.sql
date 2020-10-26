use master
drop database QLDETHI

create database QLDETHI
use QLDETHI
/*--------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------------------*/
create table Cap(
	MaCap int primary key IDENTITY(1,1),
	TenCap nvarchar(30) not null unique,
	MoTa nvarchar(100) not null,
)

create table DeThi(
	MaDe int primary key IDENTITY(1,1),
	MaMonHoc int not null,
	MaNguoiTao int not null,
	SoLuongCau int not null check (SoLuongCau >= 10 or SoLuongCau <=100),
	TongDiem int not null check (TongDiem = 10),
	TongThoiGianThi int not null,
	MaCap int not null
)

create table CauHoi(
	MaCauHoi int primary key IDENTITY(1,1),
	MaDe int not null,
	TongDapAn int not null check (TongDapAn = 4),
	NoiDung nvarchar(1000) not null,
)

create table DapAn(
	MaDapAn int primary key IDENTITY(1,1),
	MaCauHoi int not null,
	NoiDung nvarchar(1000) not null,
	IsDapAnDung bit not null check (IsDapAnDung = 1 or  IsDapAnDung = 0)
)

create table MonHoc(
	MaMonHoc int primary key IDENTITY(1,1),
	TenMonHoc nvarchar(30) not null unique,
	MoTa nvarchar(100) not null,
	MaNguoiTao int not null,
)

create table NguoiDung(
	MaNguoiDung int primary key IDENTITY(1,1),
	HoTen nvarchar(25) not null,
	GioiTinh nvarchar(4) not null check (GioiTinh = 'Nam' or GioiTinh = 'Nữ'),
	Email varchar(30) unique not null,
	PasswordHash nvarchar(20) not null,
	MaPhanQuyen int not null,
	MaTT int not null,
	MaCap int not null
)

create table TrangThai(
	MaTT int primary key IDENTITY(1,1),
	MoTa nvarchar(25) not null,
)

create table PhanQuyen(
	MaPhanQuyen int primary key IDENTITY(1,1),
	TenPhanQuyen nvarchar(10) unique not null,
	MoTa nvarchar(25) not null
)

create table BangDiem(
	MaDe int not null,
	MaNguoiDung int not null,
	Diem int not null,
	SoLuongCauDung int not null,
	NgayGioiHoanThanh datetime not null,
	ThoiGianHoanThanh int not null,
	constraint PriKey_BangDiem primary key (MaDe,MaNguoiDung)
)
/*--------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------------------*/
ALter table DeThi add constraint DeThi_FK_MonHoc foreign key (MaMonHoc) references MonHoc(MaMonHoc)
ALter table DeThi add constraint DeThi_FK_MaNguoiTao foreign key (MaNguoiTao) references NguoiDung(MaNguoiDung)
Alter table DeThi add constraint DeThi_FK_MaCap foreign key (MaCap) references Cap(MaCap)

ALter table CauHoi add constraint CauHoi_FK_MaDe foreign key (MaDe) references DeThi(MaDe)

ALter table DapAn add constraint DapAn_FK_MaCauHoi foreign key (MaCauHoi) references CauHoi(MaCauHoi)

ALter table MonHoc add constraint MonHoc_FK_MaNguoiTao foreign key (MaNguoiTao) references NguoiDung(MaNguoiDung)

ALter table BangDiem add constraint BangDiem_FK_MaNguoiDung foreign key (MaNguoiDung) references NguoiDung(MaNguoiDung)
ALter table BangDiem add constraint BangDiem_FK_MaDe foreign key (MaDe) references DeThi(MaDe)

ALter table NguoiDung add constraint NguoiDung_FK_MaPhanQuyen foreign key (MaPhanQuyen) references PhanQuyen(MaPhanQuyen)
ALter table NguoiDung add constraint NguoiDung_FK_MaTT foreign key (MaTT) references TrangThai(MaTT)
Alter table NguoiDung add constraint NguoiDung_FK_MaCap foreign key (MaCap) references Cap(MaCap)
/*--------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------------------*/
insert into Cap(TenCap,MoTa)
values (N'Cấp 1',N'Từ lớp 1 đến 5'),
        (N'Cấp 2',N'Từ lớp 6 đến 9'),
        (N'Cấp 3',N'Từ lớp 10 đến 12')

insert into PhanQuyen(TenPhanQuyen,MoTa)
values ('Admin',N'Administrator all rights')

insert into TrangThai(MoTa)
values (N'Chưa xác thực tài khoản')

insert into NguoiDung (HoTen,GioiTinh,Email,PasswordHash,MaPhanQuyen,MaTT,MaCap)
values (N'Vũ Minh Nhật','Nam','minhnhatvu@gmail.com','123456Nhat',1,1,3)

insert into MonHoc(TenMonHoc,MoTa,MaNguoiTao)
values (N'TOAN HOC',N'TOAN HOC CO BAN',1)

INSERT INTO DeThi(MaMonHoc,MaNguoiTao,SoLuongCau,TongDiem,TongThoiGianThi,MaCap)
VALUES (1,1,2,10,150,1)

INSERT INTO CauHoi(MaDe,TongDapAn,NoiDung)
VALUES (1,4,N'1 + 1 = ?'),
	   (1,4,N'1 + 2 = ?')

INSERT INTO DapAn(MaCauHoi,NoiDung,IsDapAnDung)
VALUES (1,N'2',1),
		(1,N'3',0),
		(1,N'5',0),
		(1,N'7',0),
		(2,N'3',1),
		(2,N'6',0),
		(2,N'9',0),
		(2,N'10',0)
/*--------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------------------*/
create procedure CheckUnique_Email (@email varchar(30),@result varchar(5) output)
as
begin
	if exists(select email from NguoiDung where email=@email) set @result = 'true'
	else set @result = 'false'
end

declare @out varchar(5);
exec CheckUnique_Email 'minhnhatvu@gmail.com',@out output
select  @out
/*--------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------------------*/
select * from NguoiDung
select * from MonHoc
select * from DeThi
select * from CauHoi c join DapAn d on c.MaCauHoi=d.MaCauHoi

