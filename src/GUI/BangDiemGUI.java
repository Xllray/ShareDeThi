
package GUI;

import BLL.BangDiemBLL;
import DTO.BangDiemDTO;
import java.util.ArrayList;

public class BangDiemGUI {
    public static void main(String[] args)
    {
        BangDiemBLL bangdiemBLL = new BangDiemBLL();
        ArrayList<BangDiemDTO> ListDTO = bangdiemBLL.getAllBangDiem();

        for(BangDiemDTO o:ListDTO) System.out.println("Ma nguoi dung: "+o.getMaNguoiDung() +" --Diem: "+ o.getDiem());
    }
}
