
package BLL;

import DAL.BangDiemDAL;
import DTO.BangDiemDTO;
import java.util.ArrayList;

public class BangDiemBLL {
    BangDiemDAL chudeDAL = new BangDiemDAL();

    public ArrayList<BangDiemDTO> getAllBangDiem() 
    {
        return chudeDAL.getAllBangDiem();
    }
    
    public ArrayList<BangDiemDTO> getBangDiemByMaDe(int id) 
    {
        return chudeDAL.getBangDiemByMaDe(id);
    }
    
    public ArrayList<BangDiemDTO> getBangDiemByMaNguoiDung(int id) 
    {
        return chudeDAL.getBangDiemByMaNguoiDung(id);
    }
    
    public int insertBangDiem(BangDiemDTO bangdiemDTO) 
    {
        return chudeDAL.insertBangDiem(bangdiemDTO);
    }
    
    public int deleteBangDiemByMaDe(BangDiemDTO bangdiemDTO) 
    {
        return chudeDAL.deleteBangDiemByMaDe(bangdiemDTO);
    }
    
    public int deleteBangDiemByMaNguoiDung(BangDiemDTO bangdiemDTO) 
    {
        return chudeDAL.deleteBangDiemByMaNguoiDung(bangdiemDTO);
    }
    
}
