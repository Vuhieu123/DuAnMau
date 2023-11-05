/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.KhoaHoc;
import com.edusys.entity.NguoiHoc;
import com.edusys.utils.JdbcHelper;
import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vu Hieu
 */
public class KhoaHocDao {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public int insert(KhoaHoc kh) {
        sql = "INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV,NgayTao) VALUES (?, ?, ?, ?, ?, ?,?)";
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMaCD());
            ps.setObject(2, kh.getHocPhi());
            ps.setObject(3, kh.getThoiLuong());
            ps.setObject(4, kh.getNgayKG());
            ps.setObject(5, kh.getGhiChu());
            ps.setObject(6, kh.getMaNV());
            ps.setObject(7, kh.getNgayTao());
            

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(KhoaHoc kh) {
        sql = "UPDATE KhoaHoc SET MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=?,NgayTao = ?  WHERE MaKH=?";
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMaCD());
            ps.setObject(2, kh.getHocPhi());
            ps.setObject(3, kh.getThoiLuong());
            ps.setObject(4, kh.getNgayKG());
            ps.setObject(5, kh.getGhiChu());
            ps.setObject(6, kh.getMaNV());
            ps.setObject(7, kh.getNgayTao());
            ps.setObject(8, kh.getMaKH());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Integer id) {
        sql = "DELETE FROM KhoaHoc WHERE MaKH=?";
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

    public List<KhoaHoc> selectAll() {
        sql = "select nh.MaNH,nh.HoTen,nh.NgaySinh,nh.GioiTinh,nh.DienThoai,nh.Email,nh.GhiChu,nv.HoTen,nh.NgayDK from NguoiHoc nh join NhanVien nv on nh.MaNV = nv.MaNV";
        List<KhoaHoc> listKH = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHoc kh = new KhoaHoc(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getDate(8));
                listKH.add(kh);

            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhoaHoc selectById(Integer id) {
        sql = " select MaKH,MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao from KhoaHoc where MaKH =  ?";
        KhoaHoc kh = null;

        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhoaHoc(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getDate(8));

            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhoaHoc> selectByChuyenDe(String maCD) {
        sql = "select MaKH,MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao from KhoaHoc where MaCD = ?";
        List<KhoaHoc> listKH = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, maCD);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHoc kh = new KhoaHoc(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getDate(8));
                listKH.add(kh);

            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Integer> selectYear() {

        sql = "SELECT DISTINCT year(NgayKG) Year  FROM KhoaHoc order by Year desc";
        List<Integer> list = new ArrayList<>();
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);

            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(rs.getInt(1));

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
