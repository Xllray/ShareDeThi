
package DAL;

import DTO.DeThiDTO;
import Funct.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeThiDAL {
    private Connection con = null;
    private final ConnectSQL connect = new ConnectSQL();
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;
    String querry;
    /*  
    getAllDeThi()
    getDeThiByMaDe(int id)
    getDeThiByMaMonHoc(int id)
    getDeThiByMaNguoiTao(int id)
    getDeThiBySoLuongCau(int id)
    getDeThiByTongThoiGianThi(int id)
    getDeThiByMaCap(int id)
    insertDeThi(DeThiDTO dethiDTO)
    updateDeThi(DeThiDTO dethiDTO)
    deleteDeThiByMaDe(int id)
    deleteDeThiByMaMonHoc(int id)
    deleteDeThiByMaNguoiTao(int id)
    */
    
    public ArrayList<DeThiDTO> getAllDeThi()
    {
        con = connect.getConn();
        ArrayList<DeThiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s", "*","dethi");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DeThiDTO dethiDTO = new DeThiDTO();
                dethiDTO.setMaDe(resultSet.getInt("made"));
                dethiDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                dethiDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                dethiDTO.setSoLuong(resultSet.getInt("soluongcau"));
                dethiDTO.setTongDiem(resultSet.getInt("tongdiem"));
                dethiDTO.setTongTG(resultSet.getInt("tongthoigianthi"));
                dethiDTO.setMaCap(resultSet.getInt("macap"));
                result.add(dethiDTO);
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
    
    public ArrayList<DeThiDTO> getDeThiByMaDe(int id)
    {
        con = connect.getConn();
        ArrayList<DeThiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "dethi", "made");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DeThiDTO dethiDTO = new DeThiDTO();
                dethiDTO.setMaDe(resultSet.getInt("made"));
                dethiDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                dethiDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                dethiDTO.setSoLuong(resultSet.getInt("soluongcau"));
                dethiDTO.setTongDiem(resultSet.getInt("tongdiem"));
                dethiDTO.setTongTG(resultSet.getInt("tongthoigianthi"));
                dethiDTO.setMaCap(resultSet.getInt("macap"));
                result.add(dethiDTO);
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
    
    public ArrayList<DeThiDTO> getDeThiByMaMonHoc(int id)
    {
        con = connect.getConn();
        ArrayList<DeThiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "dethi", "mamonhoc");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DeThiDTO dethiDTO = new DeThiDTO();
                dethiDTO.setMaDe(resultSet.getInt("made"));
                dethiDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                dethiDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                dethiDTO.setSoLuong(resultSet.getInt("soluongcau"));
                dethiDTO.setTongDiem(resultSet.getInt("tongdiem"));
                dethiDTO.setTongTG(resultSet.getInt("tongthoigianthi"));
                dethiDTO.setMaCap(resultSet.getInt("macap"));
                result.add(dethiDTO);
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
    
    public ArrayList<DeThiDTO> getDeThiByMaNguoiTao(int id)
    {
        con = connect.getConn();
        ArrayList<DeThiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "dethi", "manguoitao");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DeThiDTO dethiDTO = new DeThiDTO();
                dethiDTO.setMaDe(resultSet.getInt("made"));
                dethiDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                dethiDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                dethiDTO.setSoLuong(resultSet.getInt("soluongcau"));
                dethiDTO.setTongDiem(resultSet.getInt("tongdiem"));
                dethiDTO.setTongTG(resultSet.getInt("tongthoigianthi"));
                dethiDTO.setMaCap(resultSet.getInt("macap"));
                result.add(dethiDTO);
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
    
    public ArrayList<DeThiDTO> getDeThiBySoLuongCau(int id)
    {
        con = connect.getConn();
        ArrayList<DeThiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "dethi", "soluongcau");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DeThiDTO dethiDTO = new DeThiDTO();
                dethiDTO.setMaDe(resultSet.getInt("made"));
                dethiDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                dethiDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                dethiDTO.setSoLuong(resultSet.getInt("soluongcau"));
                dethiDTO.setTongDiem(resultSet.getInt("tongdiem"));
                dethiDTO.setTongTG(resultSet.getInt("tongthoigianthi"));
                dethiDTO.setMaCap(resultSet.getInt("macap"));
                result.add(dethiDTO);
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
    
    public ArrayList<DeThiDTO> getDeThiByTongThoiGianThi(int id)
    {
        con = connect.getConn();
        ArrayList<DeThiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "dethi", "tongthoigianthi");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DeThiDTO dethiDTO = new DeThiDTO();
                dethiDTO.setMaDe(resultSet.getInt("made"));
                dethiDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                dethiDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                dethiDTO.setSoLuong(resultSet.getInt("soluongcau"));
                dethiDTO.setTongDiem(resultSet.getInt("tongdiem"));
                dethiDTO.setTongTG(resultSet.getInt("tongthoigianthi"));
                dethiDTO.setMaCap(resultSet.getInt("macap"));
                result.add(dethiDTO);
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
    
    public ArrayList<DeThiDTO> getDeThiByMaCap(int id)
    {
        con = connect.getConn();
        ArrayList<DeThiDTO> result = new ArrayList<>();
        querry = String.format("select %s from %s where %s = ?", "*", "dethi", "macap");
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while(resultSet.next())
            {
                DeThiDTO dethiDTO = new DeThiDTO();
                dethiDTO.setMaDe(resultSet.getInt("made"));
                dethiDTO.setMaMonHoc(resultSet.getInt("mamonhoc"));
                dethiDTO.setMaNguoiTao(resultSet.getInt("manguoitao"));
                dethiDTO.setSoLuong(resultSet.getInt("soluongcau"));
                dethiDTO.setTongDiem(resultSet.getInt("tongdiem"));
                dethiDTO.setTongTG(resultSet.getInt("tongthoigianthi"));
                dethiDTO.setMaCap(resultSet.getInt("macap"));
                result.add(dethiDTO);
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
    
    public int insertDeThi(DeThiDTO dethiDTO)
    {
        int result = 0;
        querry = "insert into dethi(made,mamonhoc,manguoitao,soluongcau,tongdiem,tongthoigianthi,macap) "
                + "values(?,?,?,?,?,?,?)";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1, dethiDTO.getMaDe());
            preparedStmt.setInt(2,dethiDTO.getMaMonHoc());
            preparedStmt.setInt(3,dethiDTO.getMaNguoiTao());
            preparedStmt.setInt(4,dethiDTO.getSoLuong());
            preparedStmt.setInt(5,dethiDTO.getTongDiem());
            preparedStmt.setInt(6,dethiDTO.getTongTG());
            preparedStmt.setInt(7, dethiDTO.getMaCap());
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
    
    public int updateDeThi(DeThiDTO dethiDTO)
    {
        int result = 0;
        querry = "update dethi set soluongcau = ? and tongthoigianthi = ? where made = ?";
        try 
        {
            preparedStmt = con.prepareStatement(querry);
            preparedStmt.setInt(1,dethiDTO.getSoLuong());
            preparedStmt.setInt(2,dethiDTO.getTongTG());
            preparedStmt.setInt(3,dethiDTO.getMaDe());
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
    
    public int deleteDeThiByMaDe(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "dethi", "made");
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
    
    public int deleteDeThiByMaMonHoc(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "dethi", "mamonhoc");
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
    
    public int deleteDeThiByMaNguoiTao(int id)
    {
        int result = 0;
        querry = String.format("delete from %s where %s = ?", "dethi", "manguoitao");
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
