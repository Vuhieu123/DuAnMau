/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.NguoiHoc;
import com.edusys.entity.NhanVien;
import com.edusys.utils.JdbcHelper;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vu Hieu
 */
public class NguoiHocDao {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public int insert(NguoiHoc nh) {
        sql = "insert into NguoiHoc(MaNH, HoTen,NgaySinh,GioiTinh ,DienThoai ,Email ,GhiChu,MaNV ,NgayDK) values (?,?,?,?,?,?,?,?,?)";
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nh.getMaNH());
            ps.setObject(2, nh.getHoTen());
            ps.setObject(3, nh.getNgaySinh());
            ps.setObject(4, nh.getGioiTinh());
            ps.setObject(5, nh.getDienThoai());
            ps.setObject(6, nh.getEmail());
            ps.setObject(7, nh.getGhiChu());
            ps.setObject(8, nh.getMaNV());
            ps.setObject(9, nh.getNgayDK());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(NguoiHoc nh) {
        sql = "Update NguoiHoc set HoTen = ?,NgaySinh = ?,Email = ? ,DienThoai = ?,GhiChu = ? ,GioiTinh = ?,MaNV = ? , NgayDK = ? where  MaNH = ?";
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, nh.getHoTen());
            ps.setObject(2, nh.getNgaySinh());
            ps.setObject(3, nh.getEmail());
            ps.setObject(4, nh.getDienThoai());
            ps.setObject(5, nh.getGhiChu());
            ps.setObject(6, nh.getGioiTinh());
            ps.setObject(7, nh.getMaNV());
            ps.setObject(8, nh.getNgayDK());

            ps.setObject(9, nh.getMaNH());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String id) {
        sql = " Delete from NguoiHoc where MaNH = ? ";
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

    public List<NguoiHoc> selectAll() {
        sql = " select nh.MaNH,nh.HoTen,nh.NgaySinh,nh.GioiTinh,nh.DienThoai,nh.Email,nh.GhiChu,nv.HoTen,nh.NgayDK from NguoiHoc nh join NhanVien nv on nh.MaNV = nv.MaNV";
        List<NguoiHoc> listNH = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiHoc nh = new NguoiHoc(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
                listNH.add(nh);

            }
            return listNH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public NguoiHoc selectById(String id) {
        sql = "select MaNH, HoTen,NgaySinh,GioiTinh ,DienThoai ,Email ,GhiChu,MaNV ,NgayDK from NguoiHoc where  MaNH = ? ";
        NguoiHoc nh = null;

        try {

            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                nh = new NguoiHoc(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));

            }
            return nh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NguoiHoc> selectByKeyWord(String ten) {
        String sql = "select MaNH, HoTen,NgaySinh,GioiTinh ,DienThoai ,Email ,GhiChu,MaNV ,NgayDK  from NguoiHoc where Hoten Like ? ";
        List<NguoiHoc> listNH = new ArrayList<>();
        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, "%" + ten + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiHoc nh = new NguoiHoc(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
                listNH.add(nh);
            }
            return listNH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NguoiHoc> selectNotInCourse(int maKH, String ten) {


        String sql = "SELECT MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK FROM NguoiHoc WHERE HoTen LIKE ? AND MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH = ?)";

        List<NguoiHoc> listNH = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setInt(2, maKH);
            rs = ps.executeQuery(); // Thực thi truy vấn và nhận kết quả

            while (rs.next()) {
                NguoiHoc nh = new NguoiHoc(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
                listNH.add(nh);
            }
            return listNH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
