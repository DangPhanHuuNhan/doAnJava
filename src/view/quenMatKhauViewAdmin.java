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
import java.awt.Color;

public class quenMatKhauViewAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_ten_dang_nhap;
	private JTextField textField_mat_khau_dang_nhap;
	private JTextField textField_ma_dang_nhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quenMatKhauViewAdmin frame = new quenMatKhauViewAdmin();
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
	public quenMatKhauViewAdmin() {
		setTitle("Quên mật khẩu Admin");
		setIconImage(Toolkit.getDefaultToolkit().createImage(quenMatKhauViewAdmin.class.getResource("icon_doAn.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 382);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_ten_dang_nhap_can_doi_mat_khau = new JLabel("Nhập tên đăng nhập cần đổi mật khẩu :");
		jLabel_ten_dang_nhap_can_doi_mat_khau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_ten_dang_nhap_can_doi_mat_khau.setBounds(10, 52, 292, 27);
		contentPane.add(jLabel_ten_dang_nhap_can_doi_mat_khau);
		
		textField_ten_dang_nhap = new JTextField();
		textField_ten_dang_nhap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_ten_dang_nhap.setColumns(10);
		textField_ten_dang_nhap.setBounds(117, 89, 214, 27);
		contentPane.add(textField_ten_dang_nhap);
		
		JLabel jLabel_matKhau = new JLabel("Mật Khẩu Mới");
		jLabel_matKhau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_matKhau.setBounds(10, 127, 156, 27);
		contentPane.add(jLabel_matKhau);
		
		textField_mat_khau_dang_nhap = new JTextField();
		textField_mat_khau_dang_nhap.setColumns(10);
		textField_mat_khau_dang_nhap.setBounds(117, 164, 214, 24);
		contentPane.add(textField_mat_khau_dang_nhap);
		
		JLabel jLabel_ma_dang_nhap = new JLabel("Nhập mã đăng nhập");
		jLabel_ma_dang_nhap.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_ma_dang_nhap.setBounds(10, 208, 292, 27);
		contentPane.add(jLabel_ma_dang_nhap);
		
		textField_ma_dang_nhap = new JTextField();
		textField_ma_dang_nhap.setColumns(10);
		textField_ma_dang_nhap.setBounds(117, 245, 214, 24);
		contentPane.add(textField_ma_dang_nhap);
		
		JButton jButton_doi = new JButton("Hoàn Tất");
		jButton_doi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jButton_doi.setBounds(111, 297, 104, 27);
		contentPane.add(jButton_doi);
		
		jButton_doi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				try {
					String tenDangNhap = textField_ten_dang_nhap.getText();
					String matKhauMoi = textField_mat_khau_dang_nhap.getText();
					
					
					if(!kiemTraMatKhauMoi(matKhauMoi)) {
						JOptionPane.showMessageDialog(null, "vui lòng nhập lại mật khẩu mới ! \n *mật khẩu phải gồm: \n ●Ít nhất một chữ cái thường \n ●Ít nhất một chữ cái hoa \n ●Ít nhất một chữ số \n ●Ít nhất 1 kí tự đặc biệt \n ●Ít nhất 8 ký tự","LỖI",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					dangNhapDAO doiMatKhau = dangNhapDAO.getInstance();
					boolean kq = doiMatKhau.doiMatKhauAdmin(tenDangNhap , matKhauMoi);
					
					
					if("1006".equals(textField_ma_dang_nhap.getText())) {
						if(kq) {
							JOptionPane.showMessageDialog(jButton_doi, "Đổi mật khẩu thành công!");
							dangNhapView dangNhapView = new dangNhapView();
							dispose();
							dangNhapView.setVisible(true);
							dangNhapView.setLocationRelativeTo(null);
							
						}else {
							return;
						}
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
	}

	private boolean kiemTraMatKhauMoi(String matKhau) {
		return matKhau.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}|:<>?])[a-zA-Z\\d!@#$%^&*()_+{}|:<>?]{8,}$");
	}
}
