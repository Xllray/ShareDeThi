
package DAL;

import DTO.DapAnDTO;
import Funct.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DapAnDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    String querry;
    /*
    getDapAnByMaDapAn(int id)
    getDapAnByMaCauHoi(int id)
    insertDapAn(ChuDeDTO chudeDTO)
    updateDapAn(ChuDeDTO chudeDTO)
    deleteCauHoiByMaCauHoi(int id)
    deleteCauHoiByMaDapAn(int id)
    */
    
    public ArrayList<DapAnDTO> getDapAnByMaDapAn(int id)
    {
        con = connect.getConn();
        ArrayList<DapAnDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "dapan", "madapan");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DapAnDTO dapanDTO = new DapAnDTO();
                dapanDTO.setMaDapAn(resultSet.getInt("madapan"));
                dapanDTO.setMaCauHoi(resultSet.getInt("macauhoi"));
                dapanDTO.setNoiDung(resultSet.getString("noidung"));
                dapanDTO.setDapAnDung(resultSet.getInt("isdapandung"));
                result.add(dapanDTO);
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
    
    public ArrayList<DapAnDTO> getDapAnByMaCauHoi(int id)
    {
        con = connect.getConn();
        ArrayList<DapAnDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "dapan", "macauhoi");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DapAnDTO dapanDTO = new DapAnDTO();
                dapanDTO.setMaDapAn(resultSet.getInt("madapan"));
                dapanDTO.setMaCauHoi(resultSet.getInt("macauhoi"));
                dapanDTO.setNoiDung(resultSet.getString("noidung"));
                dapanDTO.setDapAnDung(resultSet.getInt("isdapandung"));
                result.add(dapanDTO);
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
    
    public int insertDapAn(DapAnDTO dapanDTO)
    {
        int result = 0;
        querry = "insert into dapan(macauhoi,noidung,isdapandung) "
                + "values(?,?,?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, dapanDTO.getMaCauHoi());
            preparedStmt.setString(2,dapanDTO.getNoiDung());
            preparedStmt.setInt(3,dapanDTO.getIsDapAnDung());
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
    
    public int updateDapAn(DapAnDTO dapanDTO)
    {
        int result = 0;
        querry = "update dapan set noidung = ? and isdapandung = ? where madapan = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,dapanDTO.getNoiDung());
            preparedStmt.setInt(2,dapanDTO.getIsDapAnDung());
            preparedStmt.setInt(3,dapanDTO.getMaDapAn());
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
    
    public int deleteDapAnByMaDapAn(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "dapan", "madapan");
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

    public int deleteDapAnByMaCauHoi(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "dapan", "macauhoi");
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
