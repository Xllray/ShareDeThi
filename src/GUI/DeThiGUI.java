
package GUI;

import BLL.DeThiBLL;
import DTO.DeThiDTO;
import java.util.ArrayList;

public class DeThiGUI {
    public static void main(String[] args)
    {
        DeThiBLL dethiBLL = new DeThiBLL();
        ArrayList<DeThiDTO> ListDeThiDTO = dethiBLL.getAllDeThi();
        for(DeThiDTO dethi:ListDeThiDTO) 
            System.out.println("Số lượng: "+dethi.getSoLuong()+ " (câu)" +" --Tổng thời gian làm bài: "+ dethi.getTongTG()+" (phút)");
    }
}
