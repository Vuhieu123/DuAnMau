/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.edusys.ui;

import com.edusys.dao.ThongKeDao;
import com.edusys.utils.XImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import com.edusys.utils.Auth;
import com.edusys.utils.MsgBox;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.UIManager;

/**
 *
 * @author Vu Hieu
 */
public class EduSysJFrame extends javax.swing.JFrame {

    /**
     * Creates new form EduSysJFrame
     */
    public EduSysJFrame() {
        initComponents();
        init();

    }

    void init() {
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getAppIcon());
        new ChaoJDialog(this, true).setVisible(true);
        new DangNhapJDialog(this, true).setVisible(true);
        new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss a");
                String text = formater.format(now);
                lblDongHo.setText(text);

            }
        }).start();
    }

    void openDoiMatKhau() {
        if (Auth.isLogin()) {
            new DoiMatKhauJDialog(this, true).setVisible(true);

        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");

        }
    }

    void dangXuat() {
        Auth.clear();
        new DangNhapJDialog(this, true).setVisible(true);
        MsgBox.alert(this, "Đăng nhập thành công");
    }

    void ketThuc() {
        if (MsgBox.comfirm(this, "bạn có muốn kết thúc làm việc")) {
            System.exit(0);
        }
    }

    void openNhanVien() {
        if (Auth.isLogin()) {
            QuanLyNhanVienJFrame qlnv = new QuanLyNhanVienJFrame();
            qlnv.setDefaultCloseOperation(EduSysJFrame.DISPOSE_ON_CLOSE);
            qlnv.setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openKhoaHoc() {
        if (Auth.isLogin()) {
            QuanLyKhoaHocJFrame qlkh = new QuanLyKhoaHocJFrame();
            qlkh.setDefaultCloseOperation(EduSysJFrame.DISPOSE_ON_CLOSE);
            qlkh.setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openChuyenDe() {
        if (Auth.isLogin()) {
            QuanLyChuyenDeJFrame qlcd = new QuanLyChuyenDeJFrame();
            qlcd.setDefaultCloseOperation(EduSysJFrame.DISPOSE_ON_CLOSE);
            qlcd.setVisible(true);

        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openNguoiHoc() {
        if (Auth.isLogin()) {
            QuanLyNguoiHocJFrame qlnh = new QuanLyNguoiHocJFrame();
            qlnh.setDefaultCloseOperation(EduSysJFrame.DISPOSE_ON_CLOSE);
            qlnh.setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openHocVien() {
        if (Auth.isLogin()) {
            QuanLyHocVienJFrame qlhv = new QuanLyHocVienJFrame();
            qlhv.setDefaultCloseOperation(EduSysJFrame.DISPOSE_ON_CLOSE);
            qlhv.setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    void openThongKe(int index) {
        if (Auth.isLogin()) {
            if (index == 3 && !Auth.isManager()) {
                MsgBox.alert(this, "Bạn không có quyền xem doanh thu");
                return;
            }
            TongHopThongKeJFrame tkwin = new TongHopThongKeJFrame();
            tkwin.setDefaultCloseOperation(EduSysJFrame.DISPOSE_ON_CLOSE);
            tkwin.setVisible(true);
            tkwin.selectTab(index);

        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }

    }

    void openGioiThieu() {
        new GioiThieuJDialog(this, true).setVisible(true);
    }

    void openHuongDan() {
        try {
            Desktop.getDesktop().browse(new File("help/index.html").toURI());

        } catch (IOException ex) {
            MsgBox.alert(this, "Không tìm thấy file hướng dẫn");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbaCongCu = new javax.swing.JToolBar();
        btnDangXuat = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnChuyenDe = new javax.swing.JButton();
        btnNguoiHoc = new javax.swing.JButton();
        btnKhoaHoc = new javax.swing.JButton();
        btnHocVien = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnHuongDan = new javax.swing.JButton();
        pnlTrangThai = new javax.swing.JPanel();
        lblTrangThai = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuHeThong = new javax.swing.JMenu();
        mniDangNhap = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniKetThuc = new javax.swing.JMenuItem();
        mnuQuanLy = new javax.swing.JMenu();
        mniChuyenDe = new javax.swing.JMenuItem();
        mniKhoaHoc = new javax.swing.JMenuItem();
        mniNguoiHoc = new javax.swing.JMenuItem();
        mniHocVien = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniNhanVien = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        mniBangDiem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniLuongNguoiHoc = new javax.swing.JMenuItem();
        mniDiemChuyenDe = new javax.swing.JMenuItem();
        mniDoanhThu = new javax.swing.JMenuItem();
        mnuTroGiup = new javax.swing.JMenu();
        mniHDSD = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniGTSP = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO ");

        tbaCongCu.setRollover(true);

        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Logout.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setFocusable(false);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        tbaCongCu.add(btnDangXuat);

        btnKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/stop_8_11zon.png"))); // NOI18N
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.setFocusable(false);
        btnKetThuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKetThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });
        tbaCongCu.add(btnKetThuc);
        tbaCongCu.add(jSeparator7);

        btnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/document_13_11zon.png"))); // NOI18N
        btnChuyenDe.setText("Chuyên đề ");
        btnChuyenDe.setFocusable(false);
        btnChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDeActionPerformed(evt);
            }
        });
        tbaCongCu.add(btnChuyenDe);

        btnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/learner_7_11zon.png"))); // NOI18N
        btnNguoiHoc.setText("Người học");
        btnNguoiHoc.setFocusable(false);
        btnNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNguoiHocActionPerformed(evt);
            }
        });
        tbaCongCu.add(btnNguoiHoc);

        btnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/online-course_4_11zon.png"))); // NOI18N
        btnKhoaHoc.setText("Khóa học");
        btnKhoaHoc.setFocusable(false);
        btnKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaHocActionPerformed(evt);
            }
        });
        tbaCongCu.add(btnKhoaHoc);

        btnHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/graduated_12_11zon.png"))); // NOI18N
        btnHocVien.setText("Học viên ");
        btnHocVien.setFocusable(false);
        btnHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHocVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHocVienActionPerformed(evt);
            }
        });
        tbaCongCu.add(btnHocVien);
        tbaCongCu.add(jSeparator6);

        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/introduction_3_11zon.png"))); // NOI18N
        btnHuongDan.setText("Hướng dẫn ");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDanActionPerformed(evt);
            }
        });
        tbaCongCu.add(btnHuongDan);

        lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/letter-i_11zon.png"))); // NOI18N
        lblTrangThai.setText("Hệ quản lý đào tạo");

        lblDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/chronometer_1_11zon.png"))); // NOI18N
        lblDongHo.setText("jLabel3");

        javax.swing.GroupLayout pnlTrangThaiLayout = new javax.swing.GroupLayout(pnlTrangThai);
        pnlTrangThai.setLayout(pnlTrangThaiLayout);
        pnlTrangThaiLayout.setHorizontalGroup(
            pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangThaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrangThai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDongHo)
                .addGap(23, 23, 23))
        );
        pnlTrangThaiLayout.setVerticalGroup(
            pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangThaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrangThai)
                    .addComponent(lblDongHo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/logo_11zon (3).png"))); // NOI18N
        jLabel1.setOpaque(true);

        mnuHeThong.setText("Hệ thống ");

        mniDangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/login_11zon.png"))); // NOI18N
        mniDangNhap.setText("Đăng nhập ");
        mniDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangNhapActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDangNhap);

        mniDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Logout.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDangXuat);
        mnuHeThong.add(jSeparator2);

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/change_10_11zon.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi mật khẩu ");
        mniDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiMatKhauActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDoiMatKhau);
        mnuHeThong.add(jSeparator1);

        mniKetThuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mniKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/stop_8_11zon.png"))); // NOI18N
        mniKetThuc.setText("Kết thúc");
        mniKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKetThucActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniKetThuc);

        jMenuBar1.add(mnuHeThong);

        mnuQuanLy.setText("Quản Lý");

        mniChuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/document_13_11zon.png"))); // NOI18N
        mniChuyenDe.setText("Chuyên đề ");
        mniChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChuyenDeActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniChuyenDe);

        mniKhoaHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/online-course_4_11zon.png"))); // NOI18N
        mniKhoaHoc.setText("Khóa học ");
        mniKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKhoaHocActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniKhoaHoc);

        mniNguoiHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/learner_7_11zon.png"))); // NOI18N
        mniNguoiHoc.setText("Người học");
        mniNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNguoiHocActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniNguoiHoc);

        mniHocVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/graduated_12_11zon.png"))); // NOI18N
        mniHocVien.setText("Học viên");
        mniHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHocVienActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniHocVien);
        mnuQuanLy.add(jSeparator3);

        mniNhanVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/team_11_11zon.png"))); // NOI18N
        mniNhanVien.setText("Nhân viên ");
        mniNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNhanVienActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniNhanVien);

        jMenuBar1.add(mnuQuanLy);

        mnuThongKe.setText("Thống kê");

        mniBangDiem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mniBangDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/11zon_resized (2).png"))); // NOI18N
        mniBangDiem.setText("Bảng điểm");
        mniBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBangDiemActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniBangDiem);
        mnuThongKe.add(jSeparator4);

        mniLuongNguoiHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mniLuongNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/11zon_resized (5).png"))); // NOI18N
        mniLuongNguoiHoc.setText("Lượng người học");
        mniLuongNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLuongNguoiHocActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniLuongNguoiHoc);

        mniDiemChuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mniDiemChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/bars_5_11zon.png"))); // NOI18N
        mniDiemChuyenDe.setText("Điểm chuyên đề ");
        mniDiemChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDiemChuyenDeActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniDiemChuyenDe);

        mniDoanhThu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mniDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/dollar_2_11zon.png"))); // NOI18N
        mniDoanhThu.setText("Doanh thu");
        mniDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoanhThuActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniDoanhThu);

        jMenuBar1.add(mnuThongKe);

        mnuTroGiup.setText("Trợ giúp");

        mniHDSD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniHDSD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/introduction_3_11zon.png"))); // NOI18N
        mniHDSD.setText("Hướng dẫn sử dụng");
        mniHDSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHDSDActionPerformed(evt);
            }
        });
        mnuTroGiup.add(mniHDSD);
        mnuTroGiup.add(jSeparator5);

        mniGTSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/11zon_resized (3).png"))); // NOI18N
        mniGTSP.setText("Giới thiệu sản phẩm");
        mniGTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGTSPActionPerformed(evt);
            }
        });
        mnuTroGiup.add(mniGTSP);

        jMenuBar1.add(mnuTroGiup);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tbaCongCu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbaCongCu, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangNhapActionPerformed

    }//GEN-LAST:event_mniDangNhapActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        this.dangXuat();
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void mniHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHocVienActionPerformed
        this.openHocVien();
    }//GEN-LAST:event_mniHocVienActionPerformed

    private void mniNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNguoiHocActionPerformed
        this.openNguoiHoc();
    }//GEN-LAST:event_mniNguoiHocActionPerformed

    private void mniDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiMatKhauActionPerformed
        this.openDoiMatKhau();

    }//GEN-LAST:event_mniDoiMatKhauActionPerformed

    private void mniKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKetThucActionPerformed
        this.ketThuc();
    }//GEN-LAST:event_mniKetThucActionPerformed

    private void mniChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChuyenDeActionPerformed
        this.openChuyenDe();
    }//GEN-LAST:event_mniChuyenDeActionPerformed

    private void mniKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKhoaHocActionPerformed
        this.openKhoaHoc();
    }//GEN-LAST:event_mniKhoaHocActionPerformed

    private void mniNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNhanVienActionPerformed
        this.openNhanVien();
    }//GEN-LAST:event_mniNhanVienActionPerformed

    private void mniGTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGTSPActionPerformed
        this.openGioiThieu();
    }//GEN-LAST:event_mniGTSPActionPerformed

    private void mniBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBangDiemActionPerformed
        this.openThongKe(0);
    }//GEN-LAST:event_mniBangDiemActionPerformed

    private void mniLuongNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLuongNguoiHocActionPerformed
        this.openThongKe(1);
    }//GEN-LAST:event_mniLuongNguoiHocActionPerformed

    private void mniDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoanhThuActionPerformed
        this.openThongKe(3);
    }//GEN-LAST:event_mniDoanhThuActionPerformed

    private void mniDiemChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDiemChuyenDeActionPerformed
        this.openThongKe(2);
    }//GEN-LAST:event_mniDiemChuyenDeActionPerformed

    private void mniHDSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHDSDActionPerformed
        this.openHuongDan();
    }//GEN-LAST:event_mniHDSDActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
       this.dangXuat();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        this.ketThuc();
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDeActionPerformed
        this.openChuyenDe();
    }//GEN-LAST:event_btnChuyenDeActionPerformed

    private void btnNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNguoiHocActionPerformed
       this.openNguoiHoc();
    }//GEN-LAST:event_btnNguoiHocActionPerformed

    private void btnKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaHocActionPerformed
        this.openKhoaHoc();
    }//GEN-LAST:event_btnKhoaHocActionPerformed

    private void btnHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHocVienActionPerformed
        this.openHocVien();
    }//GEN-LAST:event_btnHocVienActionPerformed

    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
        this.openHuongDan();
    }//GEN-LAST:event_btnHuongDanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EduSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EduSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EduSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EduSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EduSysJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDe;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHocVien;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhoaHoc;
    private javax.swing.JButton btnNguoiHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JMenuItem mniBangDiem;
    private javax.swing.JMenuItem mniChuyenDe;
    private javax.swing.JMenuItem mniDangNhap;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDiemChuyenDe;
    private javax.swing.JMenuItem mniDoanhThu;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniGTSP;
    private javax.swing.JMenuItem mniHDSD;
    private javax.swing.JMenuItem mniHocVien;
    private javax.swing.JMenuItem mniKetThuc;
    private javax.swing.JMenuItem mniKhoaHoc;
    private javax.swing.JMenuItem mniLuongNguoiHoc;
    private javax.swing.JMenuItem mniNguoiHoc;
    private javax.swing.JMenuItem mniNhanVien;
    private javax.swing.JMenu mnuHeThong;
    private javax.swing.JMenu mnuQuanLy;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenu mnuTroGiup;
    private javax.swing.JPanel pnlTrangThai;
    private javax.swing.JToolBar tbaCongCu;
    // End of variables declaration//GEN-END:variables

}
