package DTO;

public class NguoiDungDTO {
    public int MaNguoiDung;
    public String HoTen;
    public String GioiTinh;
    public String Email;
    public String PasswordHash;
    public int MaPhanQuyen;
    public int MaTT;
    public int MaCap;
    
    public NguoiDungDTO()
    {
        this.MaNguoiDung=0;
        this.HoTen=null;
        this.GioiTinh=null;
        this.Email=null;
        this.PasswordHash=null;
        this.MaPhanQuyen=0;
        this.MaTT=0;
        this.MaCap=0;
    }
    
    public NguoiDungDTO(int manguoidung,String hoten,String gioitinh,String email,String password,int maphanquyen,int matt,int macap)
    {
        this.MaNguoiDung=manguoidung;
        this.HoTen=hoten;
        this.GioiTinh=gioitinh;
        this.Email=email;
        this.PasswordHash=password;
        this.MaPhanQuyen=maphanquyen;
        this.MaTT=matt;
        this.MaCap=macap;
    }

    public int getMaNguoiDung(){return this.MaNguoiDung;}
    public void setMaNguoiDung(int manguoidung){this.MaNguoiDung=manguoidung;}
    
    public String getHoTen(){return this.HoTen;}
    public void setHoTen(String hoten){this.HoTen=hoten;}
    
    public String getGioiTinh(){return this.GioiTinh;}
    public void setGioiTinh(String gt){this.GioiTinh=gt;}
    
    public String getEmail(){return this.Email;}
    public void setEmail(String email){this.Email=email;}
    
    public String getPass(){return this.PasswordHash;}
    public void setPass(String pass){this.PasswordHash=pass;}
    
    public int getMaTT(){return this.MaTT;}
    public void setMaTT(int matt){this.MaTT=matt;}
    
    public int getMaCap(){return this.MaCap;}
    public void setMaCap(int macap){this.MaCap=macap;}
    
    public int getMaPhanQuyen(){return this.MaPhanQuyen;}
    public void setMaPhanQuyen(int maphanquyen){this.MaPhanQuyen=maphanquyen;}
}
