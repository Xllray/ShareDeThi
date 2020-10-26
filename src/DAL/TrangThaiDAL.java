
package DAL;

import DTO.TrangThaiDTO;
import Funct.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrangThaiDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    String querry;
    /*  
    getAllTrangThai()
    insertTrangThai(TrangThaiDTO trangthaiDTO)
    updateTrangThai(TrangThaiDTO trangthaiDTO)
    */
    
    public ArrayList<TrangThaiDTO> getAllTrangThai()
    {
        con = connect.getConn();
        ArrayList<TrangThaiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s", "*", "trangthai");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                TrangThaiDTO trangthaiDTO = new TrangThaiDTO();
                trangthaiDTO.setMaTT(resultSet.getInt("matt"));
                trangthaiDTO.setMoTa(resultSet.getString("mota"));
                result.add(trangthaiDTO);
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
    
    public int insertTrangThai(TrangThaiDTO trangthaiDTO)
    {
        int result = 0;
        querry = "insert into trangthai(mota) "
                + "values(?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,trangthaiDTO.getMoTa());            
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
    
    public int updateTrangThai(TrangThaiDTO trangthaiDTO)
    {
        int result = 0;
        querry = "update trangthai set mota = ? where matt = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(2,trangthaiDTO.getMoTa());
            preparedStmt.setInt(3, trangthaiDTO.getMaTT());
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
