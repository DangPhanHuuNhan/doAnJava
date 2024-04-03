package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.capNhatChiSoDAO;
import model.capNhatChiSoDien;
import model.khachHang;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JButton;

public class FormMainKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField_nhapMa;
	private JLabel jLabel_logo;
	private JLabel JLBhn;
	private JLabel JLBdlvn;
	private JButton jButton_tim_kiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMainKhachHang frame = new FormMainKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormMainKhachHang() {
		setTitle("Tra cứu");
		setIconImage(Toolkit.getDefaultToolkit().createImage(FormMainKhachHang.class.getResource("icon_doAn.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 382);
		
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabelMa = new JLabel("Nhập Mã Của Bạn :");
		jLabelMa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabelMa.setBackground(new Color(255, 255, 255));
		jLabelMa.setBounds(363, 76, 141, 18);
		contentPane.add(jLabelMa);
		
		textField_nhapMa = new JTextField();
		textField_nhapMa.setBounds(363, 104, 141, 30);
		contentPane.add(textField_nhapMa);
		textField_nhapMa.setColumns(10);
		
		jLabel_logo = new JLabel("");
		jLabel_logo.setBackground(new Color(240, 240, 240));
		jLabel_logo.setBounds(71, 56, 133, 139);
		jLabel_logo.setIcon(new ImageIcon("D:\\icon_doAn\\icon_doAn.png"));
		contentPane.add(jLabel_logo);
		
		JLBhn = new JLabel("HN");
		JLBhn.setForeground(new Color(0, 128, 0));
		JLBhn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		JLBhn.setBounds(212, 102, 53, 32);
		contentPane.add(JLBhn);
		
		JLBdlvn = new JLabel("Điện Lực Việt Nam");
		JLBdlvn.setForeground(new Color(0, 128, 0));
		JLBdlvn.setFont(new Font("Tahoma", Font.BOLD, 25));
		JLBdlvn.setBounds(48, 205, 230, 31);
		contentPane.add(JLBdlvn);
		
		jButton_tim_kiem = new JButton("Tìm Kiếm");
		jButton_tim_kiem.setFont(new Font("Times New Roman", Font.BOLD, 10));
		jButton_tim_kiem.setBounds(390, 144, 82, 31);
		contentPane.add(jButton_tim_kiem);
		
		jButton_tim_kiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				dispose();
//				
//				FormMainThanhToan formMainThanhToan = new FormMainThanhToan();
//				formMainThanhToan.setVisible(true);
				
				FormMainThanhToan formMainThanhToan = new FormMainThanhToan();
				FromMainHoaDon fromMainHoaDon = new FromMainHoaDon();
				
				
				int maKhachHangCanTim = khachHangCanTim();
				
				
				if(maKhachHangCanTim != -1) {
					khachHang kq = capNhatChiSoDAO.getInstance().selectById(maKhachHangCanTim);
					

					if(kq != null) {
						dispose();
						
						
						formMainThanhToan.jLabel_hoVaTenHienThi.setText(kq.getTenKhachHang());
						
						formMainThanhToan.setVisible(true);
						
						
					}else {
						JOptionPane.showMessageDialog(jLabelMa, "mã khách hàng cần tìm không có ");
					}
				}else {
					JOptionPane.showMessageDialog(jLabelMa, "vui lòng nhập mã khách hàng là 1 số nguyên");
				}
				
				
				capNhatChiSoDien ketQua = capNhatChiSoDAO.getInstance().selectedById_tien(maKhachHangCanTim);
				
				if(ketQua != null) {
					formMainThanhToan.jLabel_luongDienHienThi.setText(ketQua.getLuongDienSuDung()+"");
					formMainThanhToan.jLabel_tongThanhTienHienThi.setText(ketQua.getTienDien()+"");
					formMainThanhToan.jLabel_tinh_trang_thanh_toan_view_thanh_toan.setText(ketQua.getTinhTrangThanhToan());
//					fromMainHoaDon.jLabel_so_tien_thanh_toan.setText("Số tiền bạn cần phải trả : "+ketQua.getTienDien()+"");
					
					// kiem tra tinh trang vo hieu hoa de thanh toan
					if(ketQua.getTinhTrangThanhToan().equals("Đã thanh toán")) {
						formMainThanhToan.jButton_thanhToan.setEnabled(false);
					}
					
				}else {
					JOptionPane.showMessageDialog(formMainThanhToan, "bạn chưa sử dụng dịch vụ cung cấp điện");

				}
				
			}
		});
		
		
		
	}
	public int khachHangCanTim() {
		try {
			return Integer.parseInt(textField_nhapMa.getText());
		} catch (Exception e) {
			return -1;
		}
	}
}
