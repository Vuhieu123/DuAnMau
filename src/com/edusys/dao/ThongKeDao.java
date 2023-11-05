/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.NhanVien;
import com.edusys.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Vu Hieu
 */
public class ThongKeDao {

    ResultSet rs = null;
    String sql = null;
    Connection con = null;
    CallableStatement cs = null;

    public List<Object[]> getBangDiem(Integer makh) {
        sql = "EXEC sp_BangDiem ?";
        List<Object[]> list = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, makh);
            rs = cs.executeQuery();
            String[] cols = {"MaNH", "HoTen", "Diem"};
            while (rs.next()) {
                Object[] row = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    row[i] = rs.getObject(cols[i]);
                }
                list.add(row);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Object[]> getLuongNguoiHoc() {
        sql = "exec sp_LuongNguoiHoc";
        List<Object[]> list = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            cs = con.prepareCall(sql);

            rs = cs.executeQuery();
            String[] cols = {"nam", "SoLuong", "DauTien", "CuoiCung"};
            while (rs.next()) {
                Object[] row = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    row[i] = rs.getObject(cols[i]);
                }
                list.add(row);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Object[]> getDiemChuyenDe() {
//        String sql = "{Call sp_DiemChuyenDe}";
//        String[] cols = {"ChuyenDe", "SoHV", "ThapNhat", "CaoNhat", "TrungBinh"};
//        return this.getListOfArray(sql, cols);

        sql = "exec sp_DiemChuyenDe";
        List<Object[]> list = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            cs = con.prepareCall(sql);

            rs = cs.executeQuery();
            String[] cols = {"ChuyenDe", "SoHV", "ThapNhat", "CaoNhat", "TrungBinh"};
            while (rs.next()) {
                Object[] row = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    row[i] = rs.getObject(cols[i]);
                }
                list.add(row);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Object[]> getDoanhThu(int nam) {

        sql = "exec sp_DoanhThu ?";
        List<Object[]> list = new ArrayList<>();

        try {
            con = JdbcHelper.getConnection();
            cs = con.prepareCall(sql);
            cs.setObject(1, nam);
            rs = cs.executeQuery();
            String[] cols = {"ChuyenDe", "soKH","SoHV","doanhthu", "ThapNhat", "CaoNhat", "TrungBinh"};
            while (rs.next()) {
                Object[] row = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    row[i] = rs.getObject(cols[i]);
                }
                list.add(row);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
