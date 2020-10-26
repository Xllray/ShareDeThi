
package DTO;

public class CapDTO {
    public int MaCap;
    public String TenCap;
    public String MoTa;
    
    public CapDTO()
    {
        this.MaCap=0;
        this.TenCap=null;
        this.MoTa=null;
    }
    
    public CapDTO(int macap,String tencap,String mota)
    {
        this.MaCap=macap;
        this.TenCap=tencap;
        this.MoTa=mota;
    }
    
    public int getMaCap(){return this.MaCap;}
    public void setMaCap(int macap){this.MaCap = macap;}
    
    public String getTenCap(){return this.TenCap;}
    public void setTenCap(String tencap){this.TenCap = tencap;}
    
    public String getMoTa(){return this.MoTa;}
    public void setMoTa(String mota){this.MoTa = mota;}
}
