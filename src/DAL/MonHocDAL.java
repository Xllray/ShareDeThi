
package DAL;

import DTO.MonHocDTO;
import Funct.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonHocDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    String querry;
    /*
    getAllMonHoc()
    getChuDeByMaMonHoc(int id)
    getMonHocByMaNguoiTao(int id)
    insertMonHoc(MonHocDTO monhocDTO)
    updateMonHoc(ChuDeDTO chudeDTO)
    deleteMonHocByMaMonHoc(int id)
    deleteMonHocByMaNguoiTao(int id)
    */
    
    public ArrayList<MonHocDTO> getAllMonHoc()
    {
        con = connect.getConn();
        ArrayList<MonHocDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s", "*", "monhoc");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                MonHocDTO monhocDTO = new MonHocDTO();
                monhocDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                monhocDTO.setTenMonHoc(resultSet.getString("tenmonhoc"));
                monhocDTO.setMoTa(resultSet.getString("mota"));
                monhocDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                result.add(monhocDTO);
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
    
    public ArrayList<MonHocDTO> getChuDeByMaMonHoc(int id)
    {
        con = connect.getConn();
        ArrayList<MonHocDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "monhoc", "mamonhoc");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                MonHocDTO monhocDTO = new MonHocDTO();
                monhocDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                monhocDTO.setTenMonHoc(resultSet.getString("tenmonhoc"));
                monhocDTO.setMoTa(resultSet.getString("mota"));
                monhocDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                result.add(monhocDTO);
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
    
    public ArrayList<MonHocDTO> getMonHocByMaNguoiTao(int id)
    {
        con = connect.getConn();
        ArrayList<MonHocDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "monhoc", "manguoitao");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                MonHocDTO monhocDTO = new MonHocDTO();
                monhocDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                monhocDTO.setTenMonHoc(resultSet.getString("tenmonhoc"));
                monhocDTO.setMoTa(resultSet.getString("mota"));
                monhocDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                result.add(monhocDTO);
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
    
    public int insertMonHoc(MonHocDTO monhocDTO)
    {
        int result = 0;
        querry = "insert into monhoc(tenmonhoc,mota,manguoitao) "
                + "values(?,?,?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1, monhocDTO.getTenMonHoc());
            preparedStmt.setString(2, monhocDTO.getMoTa());
            preparedStmt.setInt(3, monhocDTO.getMaNguoiTao());
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
    
    public int updateMonHoc(MonHocDTO monhocDTO)
    {
        int result = 0;
        querry = "update chude set tenmonhoc = ? and mota = ? and manguoitao = ? where mamonhoc = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setString(1,monhocDTO.getTenMonHoc());
            preparedStmt.setString(2,monhocDTO.getMoTa());
            preparedStmt.setInt(3,monhocDTO.getMaNguoiTao());
            preparedStmt.setInt(4,monhocDTO.getMaMonHoc());
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
    
    public int deleteMonHocMaMonHoc(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "monhoc", "mamonhoc");
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
    
    public int deleteMonHocByMaNguoiTao(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "monhoc", "manguoitao");
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
