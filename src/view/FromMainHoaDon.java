package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class FromMainHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JLabel jLabel_so_tien_thanh_toan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromMainHoaDon frame = new FromMainHoaDon();
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
	public FromMainHoaDon() {
		setTitle("Hóa Đơn");
		setIconImage(Toolkit.getDefaultToolkit().createImage(FromMainHoaDon.class.getResource("icon_doAn.png")));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 573);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabelMaQR = new JLabel("");
		jLabelMaQR.setBounds(33, 91, 421, 365);
//		jButton_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FormMain.class.getResource("icon_insert.png"))));
		jLabelMaQR.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FromMainHoaDon.class.getResource("maQR.jpg"))));
		contentPane.add(jLabelMaQR);
		
		JLabel jLabel_ten_ngan_hang = new JLabel("Điện lực Việt Nam");
		jLabel_ten_ngan_hang.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_ten_ngan_hang.setBounds(186, 21, 132, 28);
		contentPane.add(jLabel_ten_ngan_hang);
		
		JLabel jLabel_so_tai_khoan = new JLabel("STK : 1907 1343 8800 11");
		jLabel_so_tai_khoan.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		jLabel_so_tai_khoan.setBounds(182, 59, 136, 13);
		contentPane.add(jLabel_so_tai_khoan);
		
		jLabel_so_tien_thanh_toan = new JLabel("");
		jLabel_so_tien_thanh_toan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_so_tien_thanh_toan.setBounds(195, 453, 117, 28);
		contentPane.add(jLabel_so_tien_thanh_toan);
		
		JButton jButton_hoan_tat = new JButton("Hoàn Tất");
		jButton_hoan_tat.setBounds(195, 495, 97, 31);
		contentPane.add(jButton_hoan_tat);
		
		jButton_hoan_tat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FormMainKhachHang formMainKhachHang = new FormMainKhachHang();
				dispose();
				formMainKhachHang.setVisible(true);
				formMainKhachHang.setLocationRelativeTo(null);
				
			}
		});
		

	}
}
