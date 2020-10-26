
package DAL;

import DTO.NguoiDungDTO;
import Funct.ConnectSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NguoiDungDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    private CallableStatement cstmt;
    String querry;
    /*  
    getAllNguoiDung()
    getNguoiDungByMaNguoiDung(int id)
    insertNguoiDung(NguoiDungDTO nguoidungDTO)
    
    updateThongTinNguoiDung(NguoiDungDTO nguoidungDTO)
    updateEmailNguoiDung(NguoiDungDTO nguoidungDTO)
    updatePasswWordNguoiDung(NguoiDungDTO nguoidungDTO)
    deleteNguoiDungByMaNguoiDung(int id)
    */
    
    public ArrayList<NguoiDungDTO> getAllNguoiDung()
    {
        con = connect.getConn();
        ArrayList<NguoiDungDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s", "*", "nguoidung");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                NguoiDungDTO nguoidungDTO = new NguoiDungDTO();
                nguoidungDTO.setMaNguoiDung(resultSet.getInt("manguoidung"));
                nguoidungDTO.setHoTen(resultSet.getString("hoten"));
                nguoidungDTO.setGioiTinh(resultSet.getString("gioitinh"));
                nguoidungDTO.setEmail(resultSet.getString("email"));
                nguoidungDTO.setPass(resultSet.getString("passwordhash"));
                nguoidungDTO.setMaPhanQuyen(resultSet.getInt("maphanquyen"));
                nguoidungDTO.setMaTT(resultSet.getInt("matt"));
                nguoidungDTO.setMaCap(resultSet.getInt("macap"));
                result.add(nguoidungDTO);
            }
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                preparedStmt.close();
                resultSet.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
    
    public ArrayList<NguoiDungDTO> getNguoiDungByMaNguoiDung(int id)
    {
        con = connect.getConn();
        ArrayList<NguoiDungDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "nguoidung", "manguoidung");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                NguoiDungDTO nguoidungDTO = new NguoiDungDTO();
                nguoidungDTO.setMaNguoiDung(resultSet.getInt("manguoidung"));
                nguoidungDTO.setHoTen(resultSet.getString("hoten"));
                nguoidungDTO.setGioiTinh(resultSet.getString("gioitinh"));
                nguoidungDTO.setEmail(resultSet.getString("email"));
                nguoidungDTO.setPass(resultSet.getString("passwordhash"));
                nguoidungDTO.setMaPhanQuyen(resultSet.getInt("maphanquyen"));
                nguoidungDTO.setMaTT(resultSet.getInt("matt"));
                nguoidungDTO.setMaCap(resultSet.getInt("macap"));
                result.add(nguoidungDTO);
            }
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                preparedStmt.close();
                resultSet.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
    
    public ArrayList<NguoiDungDTO> getNguoiDungByMaCap(int id)
    {
        con = connect.getConn();
        ArrayList<NguoiDungDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "nguoidung", "macap");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                NguoiDungDTO nguoidungDTO = new NguoiDungDTO();
                nguoidungDTO.setMaNguoiDung(resultSet.getInt("manguoidung"));
                nguoidungDTO.setHoTen(resultSet.getString("hoten"));
                nguoidungDTO.setGioiTinh(resultSet.getString("gioitinh"));
                nguoidungDTO.setEmail(resultSet.getString("email"));
                nguoidungDTO.setPass(resultSet.getString("passwordhash"));
                nguoidungDTO.setMaPhanQuyen(resultSet.getInt("maphanquyen"));
                nguoidungDTO.setMaTT(resultSet.getInt("matt"));
                nguoidungDTO.setMaCap(resultSet.getInt("macap"));
                result.add(nguoidungDTO);
            }
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                preparedStmt.close();
                resultSet.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
    
    public int insertNguoiDung(NguoiDungDTO nguoidungDTO)
    {
        int result = 0;
        querry = "insert into nguoidung(manguoidung,hoten,gioitinh,email,passwordhash,maphanquyen,matt,macap) "
                + "values(?,?,?,?,?,?,?,?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, nguoidungDTO.getMaNguoiDung());
            preparedStmt.setString(2, nguoidungDTO.getHoTen());
            preparedStmt.setString(3, nguoidungDTO.getGioiTinh());
            preparedStmt.setString(4, nguoidungDTO.getEmail());
            preparedStmt.setString(5, nguoidungDTO.getPass());
            preparedStmt.setInt(6, nguoidungDTO.getMaPhanQuyen());
            preparedStmt.setInt(7, nguoidungDTO.getMaTT());
            preparedStmt.setInt(8, nguoidungDTO.getMaCap());
            result = preparedStmt.executeUpdate();
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                preparedStmt.close();
                resultSet.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
    
    public boolean checkUniqueEmail(String email)
    {
        con = connect.getConn();
        boolean result = false;
        querry = "{call CheckUnique_Email (?,?)}";
        try 
        {
            cstmt = con.prepareCall(querry);
            cstmt.setString(1, email);
            cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            cstmt.execute();
            result = Boolean.parseBoolean(cstmt.getString(2));
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                cstmt.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
    
    public int updateThongTinNguoiDung(NguoiDungDTO nguoidungDTO)
    {
        int result = 0;
        querry = "update nguoidung set hoten = ? and gioitinh = ? where manguoidung = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,nguoidungDTO.getHoTen());
            preparedStmt.setString(2,nguoidungDTO.getGioiTinh());
            preparedStmt.setInt(3,nguoidungDTO.getMaNguoiDung());
            result = preparedStmt.executeUpdate();
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                preparedStmt.close();
                resultSet.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
    
    public int updateEmailNguoiDung(NguoiDungDTO nguoidungDTO)
    {
        int result = 0;
        querry = "update nguoidung set email = ? where manguoidung = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,nguoidungDTO.getEmail());
            preparedStmt.setInt(2,nguoidungDTO.getMaNguoiDung());
            result = preparedStmt.executeUpdate();
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                preparedStmt.close();
                resultSet.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
    
    public int updatePasswWordNguoiDung(NguoiDungDTO nguoidungDTO)
    {
        int result = 0;
        querry = "update nguoidung set passwordhash = ? where manguoidung = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,nguoidungDTO.getPass());
            preparedStmt.setInt(2,nguoidungDTO.getMaNguoiDung());
            result = preparedStmt.executeUpdate();
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                preparedStmt.close();
                resultSet.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
    
    public int deleteNguoiDungByMaNguoiDung(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "nguoidung", "manguoidung");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            result = preparedStmt.executeUpdate();
        } 
        catch (SQLException i) 
        {
            System.out.println(i);
        }
        finally
        {
            try 
            {
                con.close();
                preparedStmt.close();
                resultSet.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
            return result;
    }
}
