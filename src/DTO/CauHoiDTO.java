package DTO;

public class CauHoiDTO {
    public int MaCauHoi;
    public int MaDe;
    public int TongDapAn;
    public String NoiDung;
    
    public CauHoiDTO()
    {
        this.MaCauHoi=0;
        this.MaDe=0;
        this.TongDapAn=0;
        this.NoiDung=null;
    }
    
    public CauHoiDTO(int macauhoi,int made,int tongdapan,String noidung)
    {
        this.MaCauHoi=macauhoi;
        this.MaDe=made;
        this.TongDapAn=tongdapan;
        this.NoiDung=noidung;
    }
    
    public int getMaCauHoi(){return this.MaCauHoi;}
    public void setMaCauHoi(int macauhoi){this.MaCauHoi=macauhoi;}
    
    public int getMaDe(){return this.MaDe;}
    public void setMaDe(int made){this.MaDe=made;}
    
    public int getTongDapAn(){return this.TongDapAn;}
    public void setTongDapAn(int tong){this.TongDapAn=tong;}
    
    public String getNoiDung(){return this.NoiDung;}
    public void setNoiDung(String noidung){this.NoiDung=noidung;}
    
    
}
