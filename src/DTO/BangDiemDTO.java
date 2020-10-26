package DTO;

public class BangDiemDTO {
    public int MaDe;
    public int MaNguoiDung;
    public int Diem;
    public int SoLuongCauDung;
    public String NgayGioiHoanThanh;
    public int ThoiGianHoanThanh;
    
    public BangDiemDTO()
    {
        this.MaDe=0;
        this.MaNguoiDung=0;
        this.Diem=0;
        this.SoLuongCauDung=0;
        this.NgayGioiHoanThanh=null;
        this.ThoiGianHoanThanh=0;
    }
    
    public BangDiemDTO(int made,int manguoidung,int diem,int soluong,String ngaygio,int thoigian)
    {
        this.MaDe=made;
        this.MaNguoiDung=manguoidung;
        this.Diem=diem;
        this.SoLuongCauDung=soluong;
        this.NgayGioiHoanThanh=ngaygio;
        this.ThoiGianHoanThanh=thoigian;
    }
    
    public int getMaDe(){return this.MaDe;}
    public void setMaDe(int made){this.MaDe=made;}
    
    public int getMaNguoiDung(){return this.MaNguoiDung;}
    public void setMaNguoiDung(int manguoidung){this.MaNguoiDung=manguoidung;}
    
    public int getDiem(){return this.Diem;}
    public void setDiem(int diem){this.Diem=diem;}

    public int getSoLuong(){return this.SoLuongCauDung;}
    public void setSoLuong(int sl){this.SoLuongCauDung=sl;}
    
    public String getNgay(){return this.NgayGioiHoanThanh;}
    public void setNgayGio(String ngaygio){this.NgayGioiHoanThanh=ngaygio;}
    
    public int getThoiGian(){return this.ThoiGianHoanThanh;}
    public void setThoiGian(int thoigian){this.ThoiGianHoanThanh=thoigian;}
}
