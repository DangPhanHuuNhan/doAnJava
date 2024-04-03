package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.dangNhapDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class dangKiViewAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField_dangKi;
	public static JTextField textField_matKhau;
	private JTextField textField_maDangNhap;
	private JButton jButton_dangKi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangKiViewAdmin frame = new dangKiViewAdmin();
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
	public dangKiViewAdmin() {
		setTitle("Đăng kí Admin");
		setIconImage(Toolkit.getDefaultToolkit().createImage(dangKiView.class.getResource("icon_doAn.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_tenDangKi = new JLabel("TÊN ĐĂNG NHẬP");
		jLabel_tenDangKi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_tenDangKi.setBounds(10, 51, 156, 27);
		contentPane.add(jLabel_tenDangKi);
		
		textField_dangKi = new JTextField();
		textField_dangKi.setColumns(10);
		textField_dangKi.setBounds(152, 54, 177, 24);
		contentPane.add(textField_dangKi);
		
		JLabel jLabel_matKhau = new JLabel("Mật Khẩu");
		jLabel_matKhau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_matKhau.setBounds(10, 111, 156, 27);
		contentPane.add(jLabel_matKhau);
		
		textField_matKhau = new JTextField();
		textField_matKhau.setColumns(10);
		textField_matKhau.setBounds(152, 114, 177, 24);
		contentPane.add(textField_matKhau);
		
		JLabel jLabel_matDangNhap = new JLabel("Mã Đăng Kí");
		jLabel_matDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_matDangNhap.setBounds(10, 180, 156, 27);
		contentPane.add(jLabel_matDangNhap);
		
		textField_maDangNhap = new JTextField();
		textField_maDangNhap.setColumns(10);
		textField_maDangNhap.setBounds(152, 183, 80, 24);
		contentPane.add(textField_maDangNhap);
		
		jButton_dangKi = new JButton("Đăng Kí");
		jButton_dangKi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jButton_dangKi.setBounds(126, 260, 92, 35);
		contentPane.add(jButton_dangKi);
		
		jButton_dangKi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhapDAO dangKi = dangNhapDAO.getInstance();
				
			boolean kq = dangKi.dangKiAdmin();
		
			
			if("1006".equals(textField_maDangNhap.getText())) {
				if(kq) {
					JOptionPane.showMessageDialog(jLabel_matDangNhap, "Bạn đã đăng kí thành công !");
					dangNhapView dangNhapView = new dangNhapView();
					dispose();
					dangNhapView.setVisible(true);
					dangNhapView.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(jLabel_matDangNhap, "Đăng kí thất bại !");
				}
					
					xoaForm();
					
				}else {
					JOptionPane.showMessageDialog(jLabel_matDangNhap, "sai mã đăng kí vui lòng nhập lại !");
				}
			}
			
		});
		
	}
	
	
	public void xoaForm() {
		textField_dangKi.setText("");
		textField_maDangNhap.setText("");
		textField_matKhau.setText("");
	}
}
