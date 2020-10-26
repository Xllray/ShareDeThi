
package DAL;

import DTO.CapDTO;
import Funct.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CapDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    String querry;
    /*  
    getAllCap()
    getCapByMaCap(int id)
    insertCap(CapDTO capDTO)
    deleteCap(CapDTO capDTO)
    */
    
    public ArrayList<CapDTO> getAllCap()
    {
        con = connect.getConn();
        ArrayList<CapDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s", "*","cap");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                CapDTO capDTO = new CapDTO();
                capDTO.setMaCap(resultSet.getInt("macap"));
                capDTO.setTenCap(resultSet.getString("tencap"));
                capDTO.setMoTa(resultSet.getString("mota"));
                result.add(capDTO);
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
    
    public ArrayList<CapDTO> getCapByMaCap(int id)
    {
        con = connect.getConn();
        ArrayList<CapDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*","cap","macap");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                CapDTO capDTO = new CapDTO();
                capDTO.setMaCap(resultSet.getInt("macap"));
                capDTO.setTenCap(resultSet.getString("tencap"));
                capDTO.setMoTa(resultSet.getString("mota"));
                result.add(capDTO);
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
    
    public int insertCap(CapDTO capDTO)
    {
        int result = 0;
        querry = "insert into cap(tencap,mota) "
                + "values(?,?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1, capDTO.getTenCap());
            preparedStmt.setString(2,capDTO.getMoTa());
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
    
    public int updateCap(CapDTO capDTO)
    {
        int result = 0;
        querry = "update cap set tencap = ? and mota = ? where macap = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,capDTO.getTenCap());
            preparedStmt.setString(2,capDTO.getMoTa());
            preparedStmt.setInt(3,capDTO.getMaCap());
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
    
    public int deleteCap(CapDTO capDTO)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "cap", "macap");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, capDTO.getMaCap());
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
