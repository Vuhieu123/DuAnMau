/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.HocVien;
import com.edusys.entity.KhoaHoc;
import com.edusys.utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vu Hieu
 */
public class HocVienDao {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public int insert(HocVien hv) {
        sql = "INSERT INTO HocVien(MaKH ,MaNH,Diem) values (?,?,?)";
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hv.getMaKH());
            ps.setObject(2, hv.getMaNH());
            ps.setObject(3, hv.getDiem());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(HocVien hv) {
        String sql = "UPDATE HocVien SET MaKH =? ,MaNH=?, Diem = ? WHERE MaHV = ?";
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, hv.getMaKH());
            ps.setString(2, hv.getMaNH());
            ps.setDouble(3, hv.getDiem());
            ps.setInt(4, hv.getMaHV());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int id) {
        sql = "Delete from HocVien where MaHV = ?";
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

    public List<HocVien> selectAll() {
        sql = "select MaHV,MaKH,MaNH,Diem from HocVien";
        List<HocVien> listHV = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HocVien hv = new HocVien(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
                listHV.add(hv);

            }
            return listHV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public HocVien selectById(int id) {

        String sql = "SELECT MaHV, MaKH, MaNH, Diem FROM HocVien WHERE MaHV = ?";
        HocVien hv = null;
        List<HocVien> list = new ArrayList<>();
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                hv = new HocVien(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
                list.add(hv);
            }

            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HocVien> selectByKhoaHoc(int id) {
        sql = " select MaHV,MaKH,MaNH,Diem from HocVien where MaKH = ?";

        List<HocVien> listHV = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                HocVien hv = new HocVien(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
                listHV.add(hv);

            }
            return listHV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
