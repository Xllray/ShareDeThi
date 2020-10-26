
package BLL;

import DAL.MonHocDAL;
import DTO.MonHocDTO;
import java.util.ArrayList;

public class MonHocBLL {
    MonHocDAL monhocDAL = new MonHocDAL();

    public ArrayList<MonHocDTO> getAllMonHoc() 
    {
        return monhocDAL.getAllMonHoc();
    }
    
    
    
}
