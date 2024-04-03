package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.dangNhapDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

public class dangNhapView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField TFMatKhau;
	private JTextField TFDangNhap;
	private ButtonGroup buttonGroup_dangNhap;
	private JRadioButton JRB_Admin;
	private JRadioButton JRB_User;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangNhapView frame = new dangNhapView();
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
	public dangNhapView() {

		setTitle("Đăng nhập");
		setIconImage(Toolkit.getDefaultToolkit().createImage(dangNhapView.class.getResource("icon_doAn.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5,5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lbPMQL = new JLabel("PHẦN MỀM QUẢN LÍ TIỀN ĐIỆN");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbPMQL, 41, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbPMQL, 486, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbPMQL, 0, SpringLayout.EAST, contentPane);
		lbPMQL.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbPMQL.setForeground(new Color(0, 0, 255));
		contentPane.add(lbPMQL);
		
		TFMatKhau = new JPasswordField();
	
		sl_contentPane.putConstraint(SpringLayout.SOUTH, TFMatKhau, -264, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, TFMatKhau, -73, SpringLayout.EAST, contentPane);
		contentPane.add(TFMatKhau);
		TFMatKhau.setColumns(10);
		
		TFDangNhap = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, TFMatKhau, 0, SpringLayout.WEST, TFDangNhap);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, TFDangNhap, -346, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, TFDangNhap, -68, SpringLayout.EAST, contentPane);
		TFDangNhap.setBackground(new Color(255, 255, 255));
		contentPane.add(TFDangNhap);
		TFDangNhap.setColumns(10);
		
		JSeparator separator = new JSeparator();
		sl_contentPane.putConstraint(SpringLayout.NORTH, separator, 15, SpringLayout.SOUTH, TFDangNhap);
		sl_contentPane.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, TFDangNhap);
		sl_contentPane.putConstraint(SpringLayout.EAST, separator, -22, SpringLayout.EAST, contentPane);
		contentPane.add(separator);
		
		JLabel lbDangNhap = new JLabel("Nhập tên đăng nhập ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, TFDangNhap, 6, SpringLayout.SOUTH, lbDangNhap);
		sl_contentPane.putConstraint(SpringLayout.WEST, TFDangNhap, 10, SpringLayout.WEST, lbDangNhap);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbDangNhap, 454, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbDangNhap, -215, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbDangNhap, 6, SpringLayout.SOUTH, lbPMQL);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbDangNhap, 89, SpringLayout.NORTH, contentPane);
		lbDangNhap.setBackground(new Color(0, 0, 0));
		lbDangNhap.setForeground(new Color(0, 0, 0));
		lbDangNhap.setFont(new Font("Tahoma", Font.ITALIC, 15));
		contentPane.add(lbDangNhap);
		
		JLabel lbMatKhau = new JLabel("Mật khẩu\r\n");
		sl_contentPane.putConstraint(SpringLayout.NORTH, TFMatKhau, 6, SpringLayout.SOUTH, lbMatKhau);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbMatKhau, 6, SpringLayout.SOUTH, separator);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbMatKhau, 466, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbMatKhau, -310, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbMatKhau, -73, SpringLayout.EAST, contentPane);
		lbMatKhau.setFont(new Font("Tahoma", Font.ITALIC, 15));
		contentPane.add(lbMatKhau);
		
		JButton JBTDangKi = new JButton("Đăng Kí");
		sl_contentPane.putConstraint(SpringLayout.WEST, JBTDangKi, 639, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, JBTDangKi, -30, SpringLayout.EAST, contentPane);
		JBTDangKi.setFont(new Font("Tahoma", Font.BOLD, 15));
		JBTDangKi.setIcon(new ImageIcon("D:\\icon_doAn\\icon_signup.png"));
		JBTDangKi.setPreferredSize(new Dimension(40, 40));
		contentPane.add(JBTDangKi);
		JBTDangKi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JRB_Admin.isSelected()) {
					dispose();
					dangKiViewAdmin dangKiViewAdmin = new dangKiViewAdmin();
					dangKiViewAdmin.setVisible(true);
					dangKiViewAdmin.setLocationRelativeTo(null);
					
				}else {
					dispose();
					dangKiView dangKiView = new dangKiView();
					dangKiView.setVisible(true);
					dangKiView.setLocationRelativeTo(null);
				}
				
			}
		});
		
		
		JLabel JLBQUENMATKHAU = new JLabel("Quên mật khẩu ?");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLBQUENMATKHAU, 35, SpringLayout.SOUTH, JBTDangKi);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLBQUENMATKHAU, -265, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLBQUENMATKHAU, -139, SpringLayout.EAST, contentPane);
		JLBQUENMATKHAU.setFont(new Font("Tahoma", Font.ITALIC, 15));
		contentPane.add(JLBQUENMATKHAU);
		
		// tao su kien kích chuột cho JLBQUENMATKHAU
		JLBQUENMATKHAU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JRB_Admin.isSelected()) {
					dispose();
					quenMatKhauViewAdmin quenMatKhauViewAdmin = new quenMatKhauViewAdmin();
					quenMatKhauViewAdmin.setVisible(true);
					quenMatKhauViewAdmin.setLocationRelativeTo(null);
				}else if(JRB_User.isSelected()) {
					dispose();
					quenMatKhauView quenMatKhauView = new quenMatKhauView();
					quenMatKhauView.setVisible(true);
					quenMatKhauView.setLocationRelativeTo(null);
				}
			
			}
		});
		
		
		
		JButton JBTDangNhap = new JButton("Đăng Nhập");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JBTDangNhap, 51, SpringLayout.SOUTH, TFMatKhau);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JBTDangKi, 0, SpringLayout.NORTH, JBTDangNhap);
		sl_contentPane.putConstraint(SpringLayout.WEST, JBTDangNhap, 0, SpringLayout.WEST, lbDangNhap);
		sl_contentPane.putConstraint(SpringLayout.EAST, JBTDangNhap, 0, SpringLayout.EAST, lbDangNhap);
		JBTDangNhap.setIcon(new ImageIcon("D:\\icon_doAn\\icon_signIn.png"));
		JBTDangNhap.setPreferredSize(new Dimension(40, 40));
		JBTDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JBTDangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			String tenDangNhap = TFDangNhap.getText().trim();
			String maKhau = TFMatKhau.getText().trim();
			
		
			boolean kiemTra = dangNhapDAO.getInstance().kiemTraDangNhap(tenDangNhap, maKhau);
			
			boolean kt = dangNhapDAO.getInstance().kiemTraDangNhapAdmin(tenDangNhap, maKhau);			
			if(JRB_Admin.isSelected()) {
				if(kt == true) {
					dispose();
					FormMain formMain = new FormMain();
					formMain.setLocationRelativeTo(null);
					formMain.setVisible(true);					
				}else {
					JOptionPane.showMessageDialog(JBTDangNhap, "Mật khẩu và tài khoản bạn vừa nhập không chính xác !");
				}
			}else if(JRB_User.isSelected()) {
				if(kiemTra == true) {
					dispose();
					FormMainKhachHang formMainKhachHang = new FormMainKhachHang();
					formMainKhachHang.setLocationRelativeTo(null);
					formMainKhachHang.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(JBTDangNhap, "Mật khẩu và tài khoản bạn vừa nhập không chính xác !");
				}
			}
			
			}
		});
		contentPane.add(JBTDangNhap);
		
		JLabel JLBLogo = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLBLogo, 0, SpringLayout.NORTH, lbDangNhap);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLBLogo, 89, SpringLayout.WEST, contentPane);
		JLBLogo.setIcon(new ImageIcon("D:\\icon_doAn\\icon_doAn.png"));
		contentPane.add(JLBLogo);
		
		JLabel JLBhn = new JLabel("HN");
		sl_contentPane.putConstraint(SpringLayout.WEST, JLBhn, 230, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLBhn, -181, SpringLayout.WEST, TFDangNhap);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLBLogo, -5, SpringLayout.WEST, JLBhn);
		JLBhn.setForeground(new Color(0, 128, 0));
		JLBhn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(JLBhn);
		
		JLabel JLBdlvn = new JLabel("Điện Lực Việt Nam");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLBhn, -81, SpringLayout.NORTH, JLBdlvn);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLBdlvn, 21, SpringLayout.SOUTH, JLBLogo);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLBdlvn, 76, SpringLayout.WEST, contentPane);
		JLBdlvn.setForeground(new Color(0, 128, 0));
		JLBdlvn.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(JLBdlvn);
		
		 JRB_Admin = new JRadioButton("Admin");
		JRB_Admin.setBackground(new Color(128, 255, 0));
		sl_contentPane.putConstraint(SpringLayout.WEST, JRB_Admin, 0, SpringLayout.WEST, lbDangNhap);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JRB_Admin, -7, SpringLayout.NORTH, JBTDangNhap);
		contentPane.add(JRB_Admin);
		
		 JRB_User = new JRadioButton("User");
		sl_contentPane.putConstraint(SpringLayout.WEST, JRB_User, 27, SpringLayout.EAST, JRB_Admin);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JRB_User, -6, SpringLayout.NORTH, JBTDangNhap);
		JRB_User.setBackground(new Color(128, 255, 0));
		contentPane.add(JRB_User);
		
		
		buttonGroup_dangNhap = new ButtonGroup();
		buttonGroup_dangNhap.add(JRB_Admin);
		buttonGroup_dangNhap.add(JRB_User);
		
		
		
		this.setVisible(true);
	}
}
