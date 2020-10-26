
package DAL;

import DTO.BangDiemDTO;
import Funct.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BangDiemDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    String querry;
    /*  
    getAllBangDiem()
    getBangDiemByMaDe(int id)
    getBangDiemByMaNguoiDung(int id)
    insertBangDiem(BangDiemDTO bangdiemDTO)
    deleteBangDiemByMaDe(BangDiemDTO bangdiemDTO)
    deleteBangDiemByMaNguoiDung(BangDiemDTO bangdiemDTO)
    */
    
    public ArrayList<BangDiemDTO> getAllBangDiem()
    {
        con = connect.getConn();
        ArrayList<BangDiemDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s", "*","bangdiem");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                BangDiemDTO bangdiemDTO = new BangDiemDTO();
                bangdiemDTO.setMaDe(resultSet.getInt("made"));
                bangdiemDTO.setMaNguoiDung(resultSet.getInt("manguoidung"));
                bangdiemDTO.setDiem(resultSet.getInt("diem"));
                bangdiemDTO.setSoLuong(resultSet.getInt("soluongcaudung"));
                bangdiemDTO.setNgayGio(resultSet.getString("ngaygiohoanthanh"));
                bangdiemDTO.setThoiGian(resultSet.getInt("thoigianhoanthanh"));
                result.add(bangdiemDTO);
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
    
    public ArrayList<BangDiemDTO> getBangDiemByMaDe(int id)
    {
        con = connect.getConn();
        ArrayList<BangDiemDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "bangdiem", "made");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                BangDiemDTO bangdiemDTO = new BangDiemDTO();
                bangdiemDTO.setMaDe(resultSet.getInt("made"));
                bangdiemDTO.setMaNguoiDung(resultSet.getInt("manguoidung"));
                bangdiemDTO.setDiem(resultSet.getInt("diem"));
                bangdiemDTO.setSoLuong(resultSet.getInt("soluongcaudung"));
                bangdiemDTO.setNgayGio(resultSet.getString("ngaygiohoanthanh"));
                bangdiemDTO.setThoiGian(resultSet.getInt("thoigianhoanthanh"));
                result.add(bangdiemDTO);
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
    
    public ArrayList<BangDiemDTO> getBangDiemByMaNguoiDung(int id)
    {
        con = connect.getConn();
        ArrayList<BangDiemDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "bangdiem", "manguoidung");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                BangDiemDTO bangdiemDTO = new BangDiemDTO();
                bangdiemDTO.setMaDe(resultSet.getInt("made"));
                bangdiemDTO.setMaNguoiDung(resultSet.getInt("manguoidung"));
                bangdiemDTO.setDiem(resultSet.getInt("diem"));
                bangdiemDTO.setSoLuong(resultSet.getInt("soluongcaudung"));
                bangdiemDTO.setNgayGio(resultSet.getString("ngaygiohoanthanh"));
                bangdiemDTO.setThoiGian(resultSet.getInt("thoigianhoanthanh"));
                result.add(bangdiemDTO);
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
    
    public int insertBangDiem(BangDiemDTO bangdiemDTO)
    {
        int result = 0;
        querry = "insert into bangdiem(made,manguoidung,diem,soluongcaudung,ngaygiohoanthanh,thoigianhoanthanh) "
                + "values(?,?,?,?,?,?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, bangdiemDTO.getMaDe());
            preparedStmt.setInt(2,bangdiemDTO.getMaNguoiDung());
            preparedStmt.setInt(3,bangdiemDTO.getDiem());
            preparedStmt.setInt(4, bangdiemDTO.getSoLuong());
            preparedStmt.setString(5, bangdiemDTO.getNgay());
            preparedStmt.setInt(6, bangdiemDTO.getThoiGian());
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
    
    public int deleteBangDiemByMaDe(BangDiemDTO bangdiemDTO)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "bangdiem", "made");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, bangdiemDTO.getMaDe());
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
    
    public int deleteBangDiemByMaNguoiDung(BangDiemDTO bangdiemDTO)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "bangdiem", "manguoidung");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, bangdiemDTO.getMaNguoiDung());
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
