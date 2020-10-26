
package BLL;

import DAL.DeThiDAL;
import DTO.DeThiDTO;
import java.util.ArrayList;

public class DeThiBLL {
    DeThiDAL dethiDAL = new DeThiDAL();
    
    public ArrayList<DeThiDTO> getAllDeThi() 
    {
        return dethiDAL.getAllDeThi();
    }
}
