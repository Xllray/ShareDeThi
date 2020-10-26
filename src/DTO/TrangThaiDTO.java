package DTO;

public class TrangThaiDTO {
    public int MaTT;
    public String Mota;
    
    public TrangThaiDTO()
    {
        this.MaTT=0;
        this.Mota=null;
    }
    
    public TrangThaiDTO(int matt,String mota)
    {
        this.MaTT=matt;
        this.Mota=mota;
    }

    public int getMaTT(){return this.MaTT;}
    public void setMaTT(int matt){this.MaTT=matt;}
    
    public String getMoTa(){return this.Mota;}
    public void setMoTa(String mota){this.Mota=mota;}
}
