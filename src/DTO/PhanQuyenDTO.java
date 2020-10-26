package DTO;

public class PhanQuyenDTO {
    public int MaPhanQuyen;
    public String TenPhanQuyen;
    public String Mota;
    
    public PhanQuyenDTO()
    {
        this.MaPhanQuyen=0;
        this.TenPhanQuyen=null;
        this.Mota=null;
    }
    
    public PhanQuyenDTO(int maphanquyen,String tenphanquyen,String mota)
    {
        this.MaPhanQuyen=maphanquyen;
        this.TenPhanQuyen=tenphanquyen;
        this.Mota=mota;
    }
    
    public int getMaPhanQuyen(){return this.MaPhanQuyen;}
    public void setMaPhanQuyen(int maphanquyen){this.MaPhanQuyen=maphanquyen;}
    
    public String getTenPhanQuyen(){return this.TenPhanQuyen;}
    public void setTenPhanQuyen(String tenphanquyen){this.TenPhanQuyen=tenphanquyen;}
    
    public String getMota(){return this.Mota;}
    public void setMoTa(String mota){this.Mota=mota;}
}
