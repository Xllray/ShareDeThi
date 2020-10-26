package DTO;

public class DapAnDTO {
    public int MaDapAn;
    public int MaCauHoi;
    public String NoiDung;
    public int IsDapAnDung;
    
    public DapAnDTO()
    {
        this.MaDapAn=0;
        this.MaCauHoi=0;
        this.NoiDung=null;
        this.IsDapAnDung=0;
    }
    
    public DapAnDTO(int madapan,int macauhoi,String noidung,int isDapandung)
    {
        this.MaDapAn=madapan;
        this.MaCauHoi=macauhoi;
        this.NoiDung=noidung;
        this.IsDapAnDung=isDapandung;
    }
    
    public int getMaDapAn(){return this.MaDapAn;}
    public void setMaDapAn(int madapan){this.MaDapAn=madapan;}
    
    public int getMaCauHoi(){return this.MaCauHoi;}
    public void setMaCauHoi(int macauhoi){this.MaCauHoi=macauhoi;}
    
    public String getNoiDung(){return this.NoiDung;}
    public void setNoiDung(String noidung){this.NoiDung=noidung;}
    
    public boolean IsDapAnDung(){return this.IsDapAnDung==1;}
    public int getIsDapAnDung(){return this.IsDapAnDung;}
    public void setDapAnDung(int dapandung){this.IsDapAnDung=dapandung;}
}
