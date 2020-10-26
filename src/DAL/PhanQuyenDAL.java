
package DAL;

import DTO.PhanQuyenDTO;
import Funct.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhanQuyenDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    String querry;
    /*  
    getAllPhanQuyen()
    insertPhanQuyen(PhanQuyenDTO phanquyenDTO)
    updatePhanQuyen(PhanQuyenDTO phanquyenDTO)
    */
    
    public ArrayList<PhanQuyenDTO> getAllPhanQuyen()
    {
        con = connect.getConn();
        ArrayList<PhanQuyenDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s", "*", "phanquyen");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                PhanQuyenDTO phanquyenDTO = new PhanQuyenDTO();
                phanquyenDTO.setMaPhanQuyen(resultSet.getInt("maphanquyen"));
                phanquyenDTO.setTenPhanQuyen(resultSet.getString("tenphanquyen"));
                phanquyenDTO.setMoTa(resultSet.getString("mota"));
                result.add(phanquyenDTO);
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
    
    public int insertPhanQuyen(PhanQuyenDTO phanquyenDTO)
    {
        int result = 0;
        querry = "insert into phanquyen(tenphanquyen,mota) "
                + "values(?,?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1, phanquyenDTO.getTenPhanQuyen());
            preparedStmt.setString(2,phanquyenDTO.getMota());            
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
    
    public int updatePhanQuyen(PhanQuyenDTO phanquyenDTO)
    {
        int result = 0;
        querry = "update phanquyen set tenphanquyen = ? and mota = ? where maphanquyen = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,phanquyenDTO.getTenPhanQuyen());
            preparedStmt.setString(2,phanquyenDTO.getMota());
            preparedStmt.setInt(3, phanquyenDTO.getMaPhanQuyen());
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
