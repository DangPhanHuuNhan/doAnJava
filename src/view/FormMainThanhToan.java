package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.capNhatChiSoDAO;
import model.capNhatChiSoDien;
import model.khachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import java.awt.Color;

public class FormMainThanhToan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JButton jButton_thanhToan;
	public static JLabel jLabel_tinh_trang_thanh_toan_view_thanh_toan;
	
	public static JLabel jLabel_hoVaTenHienThi;
	public static JLabel jLabel_luongDienHienThi;
	public static JLabel jLabel_tongThanhTienHienThi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMainThanhToan frame = new FormMainThanhToan();
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
	public FormMainThanhToan() {
		setTitle("Khách hàng");
		setIconImage(Toolkit.getDefaultToolkit().createImage(FormMainThanhToan.class.getResource("icon_doAn.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 445);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 190, 207));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_hoVaTen = new JLabel("HỌ VÀ TÊN :");
		jLabel_hoVaTen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_hoVaTen.setBounds(10, 31, 107, 18);
		contentPane.add(jLabel_hoVaTen);
		
		jLabel_hoVaTenHienThi = new JLabel("");
		jLabel_hoVaTenHienThi.setBounds(184, 53, 161, 29);
		contentPane.add(jLabel_hoVaTenHienThi);
		
		JLabel jLabel_luongDienSuDung = new JLabel("LƯỢNG ĐIỆN SỬ DỤNG :");
		jLabel_luongDienSuDung.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_luongDienSuDung.setBounds(10, 92, 192, 18);
		contentPane.add(jLabel_luongDienSuDung);
		
		jLabel_luongDienHienThi = new JLabel("0.0");
		jLabel_luongDienHienThi.setBounds(222, 126, 139, 13);
		contentPane.add(jLabel_luongDienHienThi);
		
		JLabel jLabel_tienDien = new JLabel("TỔNG THÀNH TIỀN :");
		jLabel_tienDien.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_tienDien.setBounds(10, 155, 161, 26);
		contentPane.add(jLabel_tienDien);
		
		jLabel_tongThanhTienHienThi = new JLabel("0.0");
		jLabel_tongThanhTienHienThi.setBounds(222, 195, 123, 13);
		contentPane.add(jLabel_tongThanhTienHienThi);
		
		 jButton_thanhToan = new JButton("THANH TOÁN");
		jButton_thanhToan.setFont(new Font("Times New Roman", Font.BOLD, 10));
		jButton_thanhToan.setBounds(122, 317, 114, 34);
		contentPane.add(jButton_thanhToan);
		
		JLabel jLabel_tinh_trang_view_Thanh_toan = new JLabel("Tình trạng :");
		jLabel_tinh_trang_view_Thanh_toan.setForeground(Color.RED);
		jLabel_tinh_trang_view_Thanh_toan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_tinh_trang_view_Thanh_toan.setBounds(10, 242, 175, 18);
		contentPane.add(jLabel_tinh_trang_view_Thanh_toan);
		
		 jLabel_tinh_trang_thanh_toan_view_thanh_toan = new JLabel("Chưa thanh toán!");
		jLabel_tinh_trang_thanh_toan_view_thanh_toan.setForeground(Color.RED);
		jLabel_tinh_trang_thanh_toan_view_thanh_toan.setBounds(184, 246, 131, 13);
		contentPane.add(jLabel_tinh_trang_thanh_toan_view_thanh_toan);
		
		
		
		
//		// kiểm tra tình trạng thanh toán để vô hiệu hóa nút thanh toán 
//		
//		String tinhTrangThanhToan = jLabel_tinh_trang_view_Thanh_toan.getText();
//		
//		if(tinhTrangThanhToan.equalsIgnoreCase("Đã thanh toán")) {
//			jButton_thanhToan.setEnabled(false);
//			System.out.println("nút đã bị vô hiệu hóa");
//		
//		}
//		
		
		jButton_thanhToan.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
	
				FormMainKhachHang formMainKhachHang = new FormMainKhachHang();
				FromMainHoaDon fromMainHoaDon = new FromMainHoaDon();
				
				
				dispose();
				fromMainHoaDon.setLocationRelativeTo(null);
				fromMainHoaDon.setVisible(true);

			}
		});
		
		
		
	

	}	
}
