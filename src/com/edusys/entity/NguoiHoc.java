/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

import java.util.Date;

/**
 *
 * @author Vu Hieu
 */
public class NguoiHoc {
   private String maNH;
   private String hoTen;
   private Date ngaySinh;
   private Boolean gioiTinh = false;
   private String dienThoai;
   private String email;
   private String ghiChu;
   private String maNV;
   private Date ngayDK = new Date();

    public NguoiHoc(String maNH, String hoTen, Date ngaySinh, Boolean gioiTinh, String dienThoai, String email, String ghiChu, String maNV, Date ngayDK) {
        this.maNH = maNH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.email = email;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.ngayDK = ngayDK;
    }

    public NguoiHoc() {
    }


    

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }
    public String hienThiGioiTinh(){
        if(gioiTinh){
            return "Nữ";
        }else{
            return "Nam";
        }
    }

    @Override
    public String toString() {
        return "NguoiHoc{" + "maNH=" + maNH + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", dienThoai=" + dienThoai + ", email=" + email + ", ghiChu=" + ghiChu + ", maNV=" + maNV + ", ngayDK=" + ngayDK + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{this.maNH,this.hoTen,this.hienThiGioiTinh(),this.ngaySinh,this.dienThoai,this.email,this.ghiChu,this.maNV,this.ngayDK};
    }
   
   
}
