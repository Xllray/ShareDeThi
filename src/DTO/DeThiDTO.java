package DTO;

public class DeThiDTO {
    public int MaDe;
    public int MaMonHoc;
    public int MaNguoiTao;
    public int SoLuongCau;
    public int TongDiem;
    public int TongThoiGianThi;
    public int MaCap;
    
    public DeThiDTO()
    {
        this.MaDe=0;
        this.MaMonHoc=0;
        this.MaNguoiTao=0;
        this.SoLuongCau=0;
        this.TongDiem=0;
        this.TongThoiGianThi=0;
        this.MaCap=0;
    }
    
    public DeThiDTO(int made,int mamonhoc,int manguoitao,int soluongcau,int tongdiem,int tongthoigianthi,int macap)
    {
        this.MaDe=made;
        this.MaMonHoc=mamonhoc;
        this.MaNguoiTao=manguoitao;
        this.SoLuongCau=soluongcau;
        this.TongDiem=tongdiem;
        this.TongThoiGianThi=tongthoigianthi;
        this.MaCap=macap;
    }
    
    public int getMaDe(){return this.MaDe;}
    public void setMaDe(int made){this.MaDe=made;}
    
    public int getMaMonHoc(){return this.MaMonHoc;}
    public void setMaMonHoc(int machude){this.MaMonHoc=machude;}
    
    public int getMaNguoiTao(){return this.MaNguoiTao;}
    public void setMaNguoiTao(int manguoitao){this.MaNguoiTao=manguoitao;}
    
    public int getMaCap(){return this.MaCap;}
    public void setMaCap(int macap){this.MaCap=macap;}
    
    public int getSoLuong(){return this.SoLuongCau;}
    public void setSoLuong(int sl){this.SoLuongCau=sl;}
    
    public int getTongDiem(){return this.TongDiem;}
    public void setTongDiem(int tongd){this.TongDiem=tongd;}
    
    public int getTongTG(){return this.TongThoiGianThi;}
    public void setTongTG(int tongtg){this.TongThoiGianThi=tongtg;}
    
}
