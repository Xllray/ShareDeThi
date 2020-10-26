
package BLL;

import DAL.NguoiDungDAL;

public class NguoiDungBLL {
    NguoiDungDAL nguoidungDAL = new NguoiDungDAL();
    
    public boolean checkUniqueEmail(String email)
    {
        return nguoidungDAL.checkUniqueEmail(email);
    }
}
