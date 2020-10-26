
package GUI;

import BLL.NguoiDungBLL;

public class NguoiDungGUI {
    public static void main(String[] args)
    {
        NguoiDungBLL nguoidungBLL = new NguoiDungBLL();
        boolean result = nguoidungBLL.checkUniqueEmail("minhnhatvu@gmail.com");
        if(result) System.out.println("Email đã có người sử dụng!");
    }
}
