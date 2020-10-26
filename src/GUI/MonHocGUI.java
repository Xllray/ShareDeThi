
package GUI;

import BLL.MonHocBLL;
import DTO.MonHocDTO;
import java.util.ArrayList;

public class MonHocGUI {
    public static void main(String[] args)
    {
        MonHocBLL monhocBLL = new MonHocBLL();
        ArrayList<MonHocDTO> ListchudeDTO = monhocBLL.getAllMonHoc();
        for(MonHocDTO monhoc:ListchudeDTO) 
            System.out.println("Tên môn học: "+monhoc.getTenMonHoc() +" --Mô tả: "+ monhoc.getMoTa());
    }
}
