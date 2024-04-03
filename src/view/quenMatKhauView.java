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

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class quenMatKhauView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_ten_dang_nhap_can_doi_mk;
	private JTextField textField_nguoi_ban_yeu_thich;
	private JTextField textField_mat_khau_moi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quenMatKhauView frame = new quenMatKhauView();
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
	public quenMatKhauView() {
		
		setTitle("Quên mật khẩu");
		setIconImage(Toolkit.getDefaultToolkit().createImage(quenMatKhauView.class.getResource("icon_doAn.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_ten_dang_nhap_can_doi_mat_khau = new JLabel("Nhập tên đăng nhập cần đổi mật khẩu :");
		jLabel_ten_dang_nhap_can_doi_mat_khau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_ten_dang_nhap_can_doi_mat_khau.setBounds(10, 66, 292, 27);
		contentPane.add(jLabel_ten_dang_nhap_can_doi_mat_khau);
		
		textField_ten_dang_nhap_can_doi_mk = new JTextField();
		textField_ten_dang_nhap_can_doi_mk.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_ten_dang_nhap_can_doi_mk.setBounds(128, 103, 214, 27);
		contentPane.add(textField_ten_dang_nhap_can_doi_mk);
		textField_ten_dang_nhap_can_doi_mk.setColumns(10);
		
		JLabel jLabel_ten_nguoi_ban_quy = new JLabel("Nhập tên người bạn yêu thích:");
		jLabel_ten_nguoi_ban_quy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_ten_nguoi_ban_quy.setBounds(10, 192, 292, 27);
		contentPane.add(jLabel_ten_nguoi_ban_quy);
		
		textField_nguoi_ban_yeu_thich = new JTextField();
		textField_nguoi_ban_yeu_thich.setColumns(10);
		textField_nguoi_ban_yeu_thich.setBounds(128, 229, 214, 24);
		contentPane.add(textField_nguoi_ban_yeu_thich);
		
		JButton jButton_doi = new JButton("Hoàn Tất");
		jButton_doi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jButton_doi.setBounds(129, 287, 104, 27);
		contentPane.add(jButton_doi);
		
		JLabel jLabel_matKhau = new JLabel("Mật Khẩu Mới");
		jLabel_matKhau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_matKhau.setBounds(10, 140, 156, 27);
		contentPane.add(jLabel_matKhau);
		
		textField_mat_khau_moi = new JTextField();
		textField_mat_khau_moi.setColumns(10);
		textField_mat_khau_moi.setBounds(128, 161, 214, 24);
		contentPane.add(textField_mat_khau_moi);
		
		jButton_doi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String tenDangNhap = textField_ten_dang_nhap_can_doi_mk.getText();
					String matKhauMoi = textField_mat_khau_moi.getText();
					String tenNguoiBanYeuThich = textField_nguoi_ban_yeu_thich.getText();
					
					
					if(kiemTraMatKhauMoi(matKhauMoi)) {
						JOptionPane.showMessageDialog(null, "vui lòng nhập lại mật khẩu mới ! \n *mật khẩu phải gồm: \n ●Ít nhất một chữ cái thường \n ●Ít nhất một chữ cái hoa \n ●Ít nhất một chữ số \n ●Ít nhất 1 kí tự đặc biệt \n ●Ít nhất 8 ký tự","LỖI",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
					dangNhapDAO doiMatKhau = dangNhapDAO.getInstance();
					boolean kq = doiMatKhau.doiMatKhau(tenDangNhap, matKhauMoi, tenNguoiBanYeuThich);
					
					if(kq) {
						JOptionPane.showMessageDialog(jLabel_matKhau, "Đổi mật khẩu thành công!");
					}else {
						return;
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
