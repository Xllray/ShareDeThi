
package DAL;

import DTO.CauHoiDTO;
import Funct.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CauHoiDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    String querry;
    /*  
    getCauHoiByMaDe(int id)
    getCauHoiByMaCauHoi(int id)
    insertCauHoi(CauHoiDTO cauhoiDTO)
    updateCauHoi(CauHoiDTO cauhoiDTO)
    deleteCauHoiByMaCauHoi(int id)
    deleteCauHoiByMaDe(int id)
    */
    
    public ArrayList<CauHoiDTO> getCauHoiByMaDe(int id)
    {
        con = connect.getConn();
        ArrayList<CauHoiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "cauhoi", "made");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                CauHoiDTO cauhoiDTO = new CauHoiDTO();
                cauhoiDTO.setMaCauHoi(resultSet.getInt("macauhoi"));
                cauhoiDTO.setMaDe(resultSet.getInt("made"));
                cauhoiDTO.setTongDapAn(resultSet.getInt("tongdapan"));
                cauhoiDTO.setNoiDung(resultSet.getString("noidung"));
                result.add(cauhoiDTO);
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
    
    public ArrayList<CauHoiDTO> getCauHoiByMaCauHoi(int id)
    {
        con = connect.getConn();
        ArrayList<CauHoiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "cauhoi", "macauhoi");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                CauHoiDTO cauhoiDTO = new CauHoiDTO();
                cauhoiDTO.setMaCauHoi(resultSet.getInt("macauhoi"));
                cauhoiDTO.setMaDe(resultSet.getInt("made"));
                cauhoiDTO.setTongDapAn(resultSet.getInt("tongdapan"));
                cauhoiDTO.setNoiDung(resultSet.getString("noidung"));
                result.add(cauhoiDTO);
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
    
    public int insertCauHoi(CauHoiDTO cauhoiDTO)
    {
        int result = 0;
        querry = "insert into cauhoi(made,tongdapan,noidung) "
                + "values(?,?,?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, cauhoiDTO.getMaDe());
            preparedStmt.setInt(2,cauhoiDTO.getTongDapAn());
            preparedStmt.setString(3,cauhoiDTO.getNoiDung());
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
    
    public int updateCauHoi(CauHoiDTO cauhoiDTO)
    {
        int result = 0;
        querry = "update cauhoi set noidung = ? where macauhoi = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,cauhoiDTO.getNoiDung());
            preparedStmt.setInt(2,cauhoiDTO.getMaCauHoi());
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
    
    public int deleteCauHoiByMaCauHoi(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "cauhoi", "macauhoi");
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
    
    public int deleteCauHoiByMaDe(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "cauhoi", "made");
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
