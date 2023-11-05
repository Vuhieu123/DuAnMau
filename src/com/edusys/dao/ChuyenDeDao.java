/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.utils.JdbcHelper;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Vu Hieu
 */
public class ChuyenDeDao {

    String sql = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = null;

    public int insert(ChuyenDe cd) {
        sql = "insert into ChuyenDe( MaCD ,TenCD, HocPhi,ThoiLuong,Hinh,Mota) values (?,?,?,?,?,?)";
        try {
            conn = JdbcHelper.getConnection();
            ps = conn.prepareCall(sql);
            ps.setObject(1, cd.getMaCD());
            ps.setObject(2, cd.getTenCD());
            ps.setObject(3, cd.getHocPhi());
            ps.setObject(4, cd.getThoiLuong());
            ps.setObject(5, cd.getHinh());
            ps.setObject(6, cd.getMota());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int update(ChuyenDe cd) {
        sql = "Update ChuyenDe set TenCD = ? , HocPhi = ?, ThoiLuong = ? ,Hinh = ? ,Mota=? where MaCD = ?";
        try {
            conn = JdbcHelper.getConnection();
            ps = conn.prepareCall(sql);

            ps.setObject(1, cd.getTenCD());
            ps.setObject(2, cd.getHocPhi());
            ps.setObject(3, cd.getThoiLuong());
            ps.setObject(4, cd.getHinh());
            ps.setObject(5, cd.getMota());
            ps.setObject(6, cd.getMaCD());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String id) {
        sql = "Delete from ChuyenDe where MaCD = ?";
        try {
            conn = JdbcHelper.getConnection();
            ps = conn.prepareCall(sql);
            ps.setObject(1, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<ChuyenDe> selectAll() {
        sql = "select MaCD ,TenCD, HocPhi,ThoiLuong,Hinh,Mota from ChuyenDe";
        List<ChuyenDe> listCD = new ArrayList<>();
        try {
            conn = JdbcHelper.getConnection();
            ps = conn.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChuyenDe cd = new ChuyenDe(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                listCD.add(cd);
            }
            return listCD;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ChuyenDe selectById(String id) {
        sql = "select MaCD ,TenCD, HocPhi,ThoiLuong,Hinh,Mota from ChuyenDe where MaCD = ?";
        List<ChuyenDe> listCD = new ArrayList<>();
        ChuyenDe cd = null;
        try {
            conn = JdbcHelper.getConnection();
            ps = conn.prepareCall(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cd = new ChuyenDe(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6));

            }
            return cd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
