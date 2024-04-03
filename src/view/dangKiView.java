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

public class dangKiView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField_tenDangNhap;
	public static JTextField textField_matKhau;
	private JButton jButton_dangKi;
	public static JTextField textField_nguoi_ban_quy;
	public static JLabel jLabel_ten_nguoi_ban_quy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangKiView frame = new dangKiView();
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
	public dangKiView() {
		setTitle("Đăng kí");
//		setIconImage(Toolkit.getDefaultToolkit().createImage(FormMain.class.getResource("icon_doAn.png")));
		setIconImage(Toolkit.getDefaultToolkit().createImage(dangKiView.class.getResource("icon_doAn.png")));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_tenDangKi = new JLabel("TÊN ĐĂNG NHẬP");
		jLabel_tenDangKi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_tenDangKi.setBounds(10, 61, 156, 27);
		contentPane.add(jLabel_tenDangKi);
		
		textField_tenDangNhap = new JTextField();
		textField_tenDangNhap.setBounds(165, 64, 177, 24);
		contentPane.add(textField_tenDangNhap);
		textField_tenDangNhap.setColumns(10);
		
		JLabel jLabel_matKhau = new JLabel("Mật Khẩu");
		jLabel_matKhau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_matKhau.setBounds(10, 108, 156, 27);
		contentPane.add(jLabel_matKhau);
		
		textField_matKhau = new JTextField();
		textField_matKhau.setColumns(10);
		textField_matKhau.setBounds(165, 113, 177, 24);
		contentPane.add(textField_matKhau);
		
		jButton_dangKi = new JButton("ĐĂNG KÍ");
		jButton_dangKi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jButton_dangKi.setBounds(123, 263, 104, 27);
		contentPane.add(jButton_dangKi);
		
		jLabel_ten_nguoi_ban_quy = new JLabel("Nhập tên người bạn yêu thích:");
		jLabel_ten_nguoi_ban_quy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_ten_nguoi_ban_quy.setBounds(10, 171, 204, 27);
		contentPane.add(jLabel_ten_nguoi_ban_quy);
		
		textField_nguoi_ban_quy = new JTextField();
		textField_nguoi_ban_quy.setColumns(10);
		textField_nguoi_ban_quy.setBounds(165, 208, 177, 24);
		contentPane.add(textField_nguoi_ban_quy);
		jButton_dangKi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//			dangNhapDAO.getInstance().dangNhap();
			
		
			dangNhapDAO dangKi = dangNhapDAO.getInstance();
			boolean kq = dangKi.dangNhap();
			
			if(kq) {
				JOptionPane.showMessageDialog(contentPane, "bạn đã đăng kí thành công !");
				dangNhapView dangNhapView = new dangNhapView();
				dispose();
				dangNhapView.setVisible(true);
				dangNhapView.setLocationRelativeTo(null);
			}else {
				JOptionPane.showMessageDialog(contentPane, " đăng kí thất bại !");
			}
				
			xoaForm();
			}
		});
		
	}
	public void xoaForm() {
		textField_tenDangNhap.setText("");
		textField_matKhau.setText("");
	}
}
