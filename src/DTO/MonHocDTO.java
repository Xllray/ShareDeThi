package DTO;

import java.io.Serializable;

public class MonHocDTO implements Serializable {
    public int MaMonHoc;
    public String TenMonHoc;
    public String MoTa;
    public int MaNguoiTao;
    
    public MonHocDTO(int mamonhoc,String tenmonhoc,String mota,int manguoitao)
    {
        this.MaMonHoc=mamonhoc;
        this.TenMonHoc=tenmonhoc;
        this.MoTa=mota;
        this.MaNguoiTao=manguoitao;
    }    

    public MonHocDTO() 
    {
        this.MaMonHoc=0;
        this.TenMonHoc=null;
        this.MoTa=null;
        this.MaNguoiTao=0;
    }
    
    public int getMaMonHoc(){return this.MaMonHoc;}
    public void setMaMonHoc(int mamonhoc){this.MaMonHoc=mamonhoc;}
    
    public String getTenMonHoc(){return this.TenMonHoc;}
    public void setTenMonHoc(String tenmonhoc){this.TenMonHoc = tenmonhoc;}
    
    public String getMoTa(){return this.MoTa;}
    public void setMoTa(String mota){this.MoTa = mota;}
    
    public int getMaNguoiTao(){return this.MaNguoiTao;}
    public void setMaNguoiTao(int manguoitao){this.MaNguoiTao=manguoitao;}
    
    
}
