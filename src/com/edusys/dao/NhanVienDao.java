/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.NhanVien;
import java.util.List;
import com.edusys.utils.JdbcHelper;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Vu Hieu
 */
public class NhanVienDao {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    String INSERT_SQL = "insert into NhanVien( MaNV,MatKhau, HoTen, VaiTro) values (?,?,?,?)";
    String UPDATE_SQL = "Update NhanVien set MatKhau = ? , HoTen = ?, VaiTro = ? where MaNV = ?";
    String DELETE_SQL = "Delete from NhanVien where MaNV = ?";
    String SELECT_BY_ID_SQL = "select * from NhanVien where MaNV = ?";


    public int insert(NhanVien nv) {

        sql = "insert into NhanVien( MaNV,HoTen,MatKhau, VaiTro) values (?,?,?,?)";
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.getMatKhau());
            ps.setObject(4, nv.isVaiTro());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }


    public int update(NhanVien nv) {

        sql = "Update NhanVien set MatKhau = ? , HoTen = ?, VaiTro = ? where MaNV = ?";
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, nv.getMatKhau());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.isVaiTro());
            ps.setObject(4, nv.getMaNV());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }


    public int delete(String id) {

        sql = "Delete from NhanVien where MaNV = ?";

        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    public List<NhanVien> selectAll() {


        sql = "select MaNV,MatKhau,HoTen,VaiTro from NhanVien";
        List<NhanVien> listNV = new ArrayList<>();

        try {

            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                listNV.add(nv);

            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public NhanVien selectById(String id) {


        String sql = "select MaNV,MatKhau, HoTen, VaiTro from NhanVien where MaNV = ?";
        NhanVien nv = null;
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
