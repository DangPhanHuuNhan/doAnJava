package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.capNhatChiSoDAO;
import DAO.khachHangDao;
import controller.qltd_controller_formMain;
import model.capNhatChiSoDien;
import model.khachHang;
import model.quanLiKhachHangModel;
import model.thangModel;
import model.tinhModel;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class FormMain extends JFrame {

	public static  khachHangDao khachHangDAO ;
	private quanLiKhachHangModel dskh;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField_ma_khach_hang;
	public static JTextField textField_ten_khach_hang;
	public static JTextField textField_cccd;
	public static JTextField textField_sdt;
	public static JTextField textField_ngay_sinh;
	public JTable table_qltt;
	public static JTextField textField_chi_so_dien_cu;
	public static JTextField textField_chi_so_dien_moi;
	public static JTable table_cncsd;
	public static JTextField textField_dien_ma_kh;
	
	public quanLiKhachHangModel quanLiKhachHangModel;
	private JLabel jLabel_hoVaTen;
	private JLabel jLabel_tong_thanh_tien;
	public static JLabel jLabel_tinh_trang_thanh_toan;
	public static JComboBox JCB_dia_chi;
	public static ButtonGroup buttonGroup_gioi_tinh;
	public static JComboBox<String> JCB_loai_dien_sd;
	public static JRadioButton JBR_nam;
	public static JRadioButton JBR_nu;
	public static JTextField textField_makh;
	public static JTextField textField_thang;
	
	private boolean congTac = false;
	private JButton jButton_xac_nhan_thanh_toan;
	private JButton jButton_huy_xac_nhan;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain();
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
	public FormMain() {
		this.quanLiKhachHangModel = new quanLiKhachHangModel();
		this.khachHangDAO = new khachHangDao();
		this.dskh = new quanLiKhachHangModel();
//		qltd_controller_formMain qltd_form_main = new qltd_controller_formMain(this);
		qltd_controller_formMain qltd_form_main = new qltd_controller_formMain(this);
		
		
		setTitle("Quản lí");
		setIconImage(Toolkit.getDefaultToolkit().createImage(FormMain.class.getResource("icon_doAn.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jPanel_menu = new JPanel();
		jPanel_menu.setBackground(new Color(128, 255, 255));
		jPanel_menu.setBounds(0, 0, 205, 640);
		contentPane.add(jPanel_menu);
		jPanel_menu.setLayout(null);
		
		JButton jButton_qltt = new JButton("Quản Lí Thông Tin");
		jButton_qltt.setBackground(new Color(0, 128, 192));
		jButton_qltt.setOpaque(true);
		jButton_qltt.setBounds(0, 132, 205, 93);
		jPanel_menu.add(jButton_qltt);
		
		JButton jButton_cncsd = new JButton("Cập Nhật Chỉ số điện");
		jButton_cncsd.setBackground(new Color(0, 128, 192));
		jButton_cncsd.setOpaque(true);
		jButton_cncsd.setBounds(0, 251, 210, 93);
		jPanel_menu.add(jButton_cncsd);
		
		JButton JButton_qlhd = new JButton("Quản Lí Hóa Đơn");
		JButton_qlhd.setBackground(new Color(0, 128, 192));
		JButton_qlhd.setOpaque(true);
		JButton_qlhd.setBounds(0, 370, 205, 93);
		jPanel_menu.add(JButton_qlhd);
		
		JLabel jLabel_quan_li_tien_dien = new JLabel("   Quản Lí Tiền Điện");
		jLabel_quan_li_tien_dien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jLabel_quan_li_tien_dien.setBackground(new Color(255, 255, 128));
		jLabel_quan_li_tien_dien.setOpaque(true);
		jLabel_quan_li_tien_dien.setBounds(0, 0, 205, 133);
		jPanel_menu.add(jLabel_quan_li_tien_dien);
		
		

		JPanel jPanel_cncsd = new JPanel();
		jPanel_cncsd.setBackground(new Color(0, 255, 0));
		jPanel_cncsd.setBounds(429, 153, 476, 341);

		JPanel jPanel_qltt = new JPanel();
		jPanel_qltt.setBackground(new Color(0, 255, 0));
		jPanel_qltt.setBounds(355, 74, 583, 469);

		JPanel jPanel_qlhd = new JPanel();
		jPanel_qlhd.setBackground(new Color(0, 255, 0));
		jPanel_qlhd.setBounds(508, 147, 403, 321);
		jPanel_qlhd.setLayout(null);
		
		
		
		CardLayout cardLayout = new CardLayout();
		JPanel jPanel_cardLayout = new JPanel(cardLayout);
		jPanel_cardLayout.add(jPanel_qltt,"jPanel_qltt");
		jPanel_qltt.setLayout(null);
		
		JLabel jLabel_hien_thi_thong_tin = new JLabel("                      Hiển Thị Thông Tin");
		jLabel_hien_thi_thong_tin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		jLabel_hien_thi_thong_tin.setBackground(new Color(255, 255, 0));
		jLabel_hien_thi_thong_tin.setOpaque(true);
		jLabel_hien_thi_thong_tin.setBounds(0, 0, 864, 131);
		jPanel_qltt.add(jLabel_hien_thi_thong_tin);
		
		JLabel jLabel_ma_khach_hang = new JLabel("Mã Khách Hàng");
		jLabel_ma_khach_hang.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_ma_khach_hang.setBounds(23, 146, 96, 13);
		jPanel_qltt.add(jLabel_ma_khach_hang);
		
		textField_ma_khach_hang = new JTextField();
		textField_ma_khach_hang.setBounds(129, 143, 122, 19);
		jPanel_qltt.add(textField_ma_khach_hang);
		textField_ma_khach_hang.setColumns(10);
		
		JLabel jLabel_ten_khach_hang_1 = new JLabel("Tên Khách Hàng");
		jLabel_ten_khach_hang_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_ten_khach_hang_1.setBounds(23, 169, 96, 13);
		jPanel_qltt.add(jLabel_ten_khach_hang_1);
		
		textField_ten_khach_hang = new JTextField();
		textField_ten_khach_hang.setColumns(10);
		textField_ten_khach_hang.setBounds(129, 166, 122, 19);
		jPanel_qltt.add(textField_ten_khach_hang);
		
		JLabel jLabel_cccd = new JLabel("CCCD/CMND");
		jLabel_cccd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_cccd.setBounds(23, 192, 96, 13);
		jPanel_qltt.add(jLabel_cccd);
		
		textField_cccd = new JTextField();
		textField_cccd.setColumns(10);
		textField_cccd.setBounds(129, 189, 122, 19);
		jPanel_qltt.add(textField_cccd);
		
		JLabel jLabel_dia_chi = new JLabel("Địa Chỉ");
		jLabel_dia_chi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_dia_chi.setBounds(23, 218, 96, 13);
		jPanel_qltt.add(jLabel_dia_chi);
		
		JLabel jLabel_gioi_tinh = new JLabel("Giới Tính");
		jLabel_gioi_tinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_gioi_tinh.setBounds(337, 146, 96, 13);
		jPanel_qltt.add(jLabel_gioi_tinh);
		
		 JBR_nam = new JRadioButton("Nam");
		JBR_nam.setBackground(new Color(0, 255, 0));
		JBR_nam.setFont(new Font("Times New Roman", Font.BOLD, 13));
		JBR_nam.setBounds(439, 142, 103, 21);
		jPanel_qltt.add(JBR_nam);
		
		JBR_nu = new JRadioButton("Nữ");
		JBR_nu.setFont(new Font("Times New Roman", Font.BOLD, 13));
		JBR_nu.setBackground(Color.GREEN);
		JBR_nu.setBounds(544, 142, 103, 21);
		jPanel_qltt.add(JBR_nu);
		
		
		
		buttonGroup_gioi_tinh  = new ButtonGroup();
		buttonGroup_gioi_tinh.add(JBR_nam);
		buttonGroup_gioi_tinh.add(JBR_nu);
		
	    JCB_dia_chi = new JComboBox();
		ArrayList<tinhModel> listTinh = tinhModel.getDanhSachTinh();
//		JCB_dia_chi.addItem("");
		for (tinhModel tinhModel : listTinh) {
			JCB_dia_chi.addItem(tinhModel.getTinh());
		}
		
		JCB_dia_chi.setBounds(129, 214, 122, 21);
		jPanel_qltt.add(JCB_dia_chi);
		
		JLabel jLabel_sdt = new JLabel("SDT");
		jLabel_sdt.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_sdt.setBounds(337, 169, 96, 13);
		jPanel_qltt.add(jLabel_sdt);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(420, 166, 122, 19);
		jPanel_qltt.add(textField_sdt);
		
		JLabel jLabel_ngay_sinh = new JLabel("Ngày Sinh");
		jLabel_ngay_sinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_ngay_sinh.setBounds(337, 192, 96, 13);
		jPanel_qltt.add(jLabel_ngay_sinh);
		
		textField_ngay_sinh = new JTextField();
		textField_ngay_sinh.setColumns(10);
		textField_ngay_sinh.setBounds(420, 189, 122, 19);
		jPanel_qltt.add(textField_ngay_sinh);
		
		JLabel jLabel_loai_dien_sd = new JLabel("Loại Điện SD");
		jLabel_loai_dien_sd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jLabel_loai_dien_sd.setBounds(337, 218, 96, 13);
		jPanel_qltt.add(jLabel_loai_dien_sd);
		
		
		String[] loaiDien = new String[]{" ","sinh hoạt" , "sản xuất"};
		 JCB_loai_dien_sd = new JComboBox<String>(loaiDien);
		JCB_loai_dien_sd.setBounds(420, 214, 122, 21);
		jPanel_qltt.add(JCB_loai_dien_sd);
		
		JSeparator separator_tren = new JSeparator();
		separator_tren.setBounds(0, 241, 864, 19);
		jPanel_qltt.add(separator_tren);
		
		table_qltt = new JTable();
		table_qltt.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "CMND/CCCD", "\u0110\u1ECBa Ch\u1EC9", "Gi\u1EDBi T\u00EDnh", "SDT", "Ng\u00E0y Sinh", "Lo\u1EA1i \u0110i\u1EC7n"
			}
		));
		
		
		// hien thi du lieu tu database len
		
		table_qltt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table_qltt.getSelectedRow();
				if(selectedRow != -1) {
					hienThiThongTinLenBang();
				}
			}
		});
		
	
		
		JScrollPane scrollPane = new JScrollPane(table_qltt , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 253, 845, 294);
		jPanel_qltt.add(scrollPane);
		
		JSeparator separator_duoi = new JSeparator();
		separator_duoi.setBounds(-10, 557, 874, 2);
		jPanel_qltt.add(separator_duoi);
		
		JButton jButton_them = new JButton("Thêm");
		jButton_them.addActionListener(qltd_form_main);
		jButton_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jButton_them.setBounds(127, 569, 143, 53);
		jButton_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FormMain.class.getResource("icon_insert.png"))));
		jPanel_qltt.add(jButton_them);
		
		jButton_them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				khachHangDao.getInstance().them();
				DefaultTableModel model = (DefaultTableModel) table_qltt.getModel();
				
				// lay du lieu moi tu co so du lieu 
				ArrayList<khachHang> danhSachKhachHangMoi = khachHangDao.getInstance().hienThiTatCa(); 	
				
				// xoa du lieu tu model
				
				model.setRowCount(0);
				
				// them du lieu moi 
				for (khachHang kh : danhSachKhachHangMoi) {
					Object[] rowData = {
							kh.getMaKhachHang(),
							kh.getTenKhachHang() , 
							kh.getCanCuocCongDan() ,
							kh.getTinh().getTinh() , 
							kh.getGioiTinh()?"Nam":"Nữ" ,
							kh.getSoDienThoai() ,
							kh.getNgaySinh() ,
							kh.getLoaiDienSuDung()
							
						
					};
				
					model.addRow(rowData);
					
				}
				

				
				
				
				
				// thong bao cho table ve su thay doi 
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						model.fireTableDataChanged();
						
					}
				});
			}
		});
		
		
		
		JButton jButton_sua = new JButton("Sửa");
		jButton_sua.addActionListener(qltd_form_main);
		jButton_sua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jButton_sua.setBounds(376, 569, 143, 53);
		jButton_sua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FormMain.class.getResource("icon_fix.png"))));
		jPanel_qltt.add(jButton_sua);
		
		jButton_sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				khachHangDao.getInstance().capNhat();
				
				xoaForm();
				DefaultTableModel model = (DefaultTableModel) table_qltt.getModel();
				
				// lay du lieu moi tu co so du lieu 
				ArrayList<khachHang> danhSachKhachHangMoi = khachHangDao.getInstance().hienThiTatCa(); 	
				
				// xoa du lieu tu model
				
				model.setRowCount(0);
				
				// them du lieu moi 
				for (khachHang kh : danhSachKhachHangMoi) {
					Object[] rowData = {
							kh.getMaKhachHang(),
							kh.getTenKhachHang() , 
							kh.getCanCuocCongDan() ,
							kh.getTinh().getTinh() , 
							kh.getGioiTinh()?"Nam":"Nữ" ,
							kh.getSoDienThoai() ,
							kh.getNgaySinh() ,
							kh.getLoaiDienSuDung()
							
						
					};
					model.addRow(rowData);
					
				}
				// thong bao cho table ve su thay doi 
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						model.fireTableDataChanged();
						
					}
				});
			}
		});
		
		
		
		JButton jButton_xoa = new JButton("Xóa");
		jButton_xoa.addActionListener(qltd_form_main);
		jButton_xoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jButton_xoa.setBounds(638, 569, 143, 53);
		jButton_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FormMain.class.getResource("icon_delete.png"))));
		jPanel_qltt.add(jButton_xoa);
		
		jButton_xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int maKhachHangCanXoa = Integer.valueOf(textField_ma_khach_hang.getText()+"");
	
				int luaChon = JOptionPane.showConfirmDialog(table_qltt  , "bạn có chắc chắn xóa không ?");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					khachHangDao.getInstance().xoa(maKhachHangCanXoa);
				}
				
				xoaForm();
				
	DefaultTableModel model = (DefaultTableModel) table_qltt.getModel();
				
				// lay du lieu moi tu co so du lieu 
				ArrayList<khachHang> danhSachKhachHangMoi = khachHangDao.getInstance().hienThiTatCa(); 	
				
				// xoa du lieu tu model
				
				model.setRowCount(0);
				
				// them du lieu moi 
				for (khachHang kh : danhSachKhachHangMoi) {
					Object[] rowData = {
							kh.getMaKhachHang(),
							kh.getTenKhachHang() , 
							kh.getCanCuocCongDan() ,
							kh.getTinh().getTinh() , 
							kh.getGioiTinh()?"Nam":"Nữ" ,
							kh.getSoDienThoai() ,
							kh.getNgaySinh() ,
							kh.getLoaiDienSuDung()
							
						
					};
					model.addRow(rowData);
					
				}
				// thong bao cho table ve su thay doi 
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						model.fireTableDataChanged();
						
					}
				});
				
			}
		});
	
		
		
		
		
		jPanel_cardLayout.add(jPanel_cncsd,"jPanel_cntt");
		jPanel_cncsd.setLayout(null);
		
		JLabel jLabel_cap_nhat_chi_so_dien = new JLabel("                     Cập Nhật Chỉ Số Điện");
		jLabel_cap_nhat_chi_so_dien.setOpaque(true);
		jLabel_cap_nhat_chi_so_dien.setFont(new Font("Times New Roman", Font.BOLD, 40));
		jLabel_cap_nhat_chi_so_dien.setBackground(Color.YELLOW);
		jLabel_cap_nhat_chi_so_dien.setBounds(0, 0, 864, 131);
		jPanel_cncsd.add(jLabel_cap_nhat_chi_so_dien);
		
		JLabel jLabel_ma_khach_hang2 = new JLabel("Mã Khách Hàng");
		jLabel_ma_khach_hang2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_ma_khach_hang2.setBounds(410, 191, 119, 25);
		jPanel_cncsd.add(jLabel_ma_khach_hang2);
		
		JLabel jLabel_thang = new JLabel("Tháng");
		jLabel_thang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_thang.setBounds(22, 191, 119, 25);
		jPanel_cncsd.add(jLabel_thang);

		
		JLabel jLabel_chi_so_cu = new JLabel("Chỉ Số Điện Cũ");
		jLabel_chi_so_cu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_chi_so_cu.setBounds(24, 153, 119, 25);
		jPanel_cncsd.add(jLabel_chi_so_cu);
		
		textField_chi_so_dien_cu = new JTextField();
		textField_chi_so_dien_cu.setColumns(10);
		textField_chi_so_dien_cu.setBounds(141, 157, 145, 19);
		jPanel_cncsd.add(textField_chi_so_dien_cu);
		
		JLabel jLabel_chi_so_moi = new JLabel("Chỉ Số Điện Mới");
		jLabel_chi_so_moi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_chi_so_moi.setBounds(410, 153, 119, 25);
		jPanel_cncsd.add(jLabel_chi_so_moi);
		
		textField_chi_so_dien_moi = new JTextField();
		textField_chi_so_dien_moi.setColumns(10);
		textField_chi_so_dien_moi.setBounds(551, 157, 145, 19);
		jPanel_cncsd.add(textField_chi_so_dien_moi);
		
		table_cncsd = new JTable();
		table_cncsd.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "Th\u00E1ng", "Ch\u1EC9 S\u1ED1 \u0110i\u1EC7n C\u0169", "Ch\u1EC9 S\u1ED1 \u0110i\u1EC7n M\u1EDBi "
			}
		));
		table_cncsd.getColumnModel().getColumn(0).setPreferredWidth(81);
		table_cncsd.getColumnModel().getColumn(1).setPreferredWidth(73);
		table_cncsd.getColumnModel().getColumn(2).setPreferredWidth(83);
		table_cncsd.getColumnModel().getColumn(3).setPreferredWidth(95);
		
	
		
		table_qltt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table_qltt.getSelectedRow();
				if(selectedRow != -1) {
					hienThiThongTinLenBang();
				}
			}
		});
		
		// hien thi du lieu tu database len
		table_cncsd.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table_cncsd.getSelectedRow();
				if(selectedRow != -1) {
					hienThiThongTinLenBangTableCncsd();
				}
			}
		});
		
		
		JScrollPane scrollPane_cncsd = new JScrollPane(table_cncsd);
		scrollPane_cncsd.setBounds(10, 248, 844, 402);
		jPanel_cncsd.add(scrollPane_cncsd);
		
		JSeparator separator_cncsd = new JSeparator();
		separator_cncsd.setBounds(0, 234, 864, 61);
		jPanel_cncsd.add(separator_cncsd);
		
		JButton jButton_luu_cncsd = new JButton("Lưu");
		jButton_luu_cncsd.setFont(new Font("Tahoma", Font.BOLD, 8));
		jButton_luu_cncsd.setBounds(769, 133, 51, 25);
		jPanel_cncsd.add(jButton_luu_cncsd);
		
		jButton_luu_cncsd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int maKhachHangCapNhatLuongDienSuDung = Integer.valueOf(textField_makh.getText()+"");
				capNhatChiSoDAO.getInstance().them();
			
				xoaFormCncsd();
				
				
				DefaultTableModel model = (DefaultTableModel) table_cncsd.getModel();
				
				// lay du lieu moi tu co so du lieu
				ArrayList<capNhatChiSoDien> listDanhSach = capNhatChiSoDAO.getInstance().hienThiTatCa();
				// xoa du lieu tu model 
				model.setRowCount(0);
				
				// them du lieu moi 
				for (capNhatChiSoDien cs : listDanhSach) {
					Object[] rowData = {
							cs.getMaKhachHang(),
							cs.getThang(),
							cs.getChiSocu(),
							cs.getChiSoMoi(),
							cs.getLuongDienSuDung(),
						    cs.getTienDien()
					};
					model.addRow(rowData);
				}
				// thong bao cho table ve su thay doi 
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						model.fireTableDataChanged();
						
					}
				});
				
			}
		});


		
		JButton jButton_sua_cncsd = new JButton("Sửa");
		jButton_sua_cncsd.setFont(new Font("Tahoma", Font.BOLD, 8));
		jButton_sua_cncsd.setBounds(769, 171, 51, 25);
		jPanel_cncsd.add(jButton_sua_cncsd);
		
		jButton_sua_cncsd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			capNhatChiSoDAO.getInstance().capNhat();
			xoaFormCncsd();
			DefaultTableModel model = (DefaultTableModel) table_cncsd.getModel();
			
			// lay du lieu moi tu co so du lieu
			ArrayList<capNhatChiSoDien> listDanhSach = capNhatChiSoDAO.getInstance().hienThiTatCa();
			// xoa du lieu tu model 
			model.setRowCount(0);
			
			// them du lieu moi 
			for (capNhatChiSoDien cs : listDanhSach) {
				Object[] rowData = {
						cs.getMaKhachHang(),
						cs.getThang(),
						cs.getChiSocu(),
						cs.getChiSoMoi()
						
				};
				model.addRow(rowData);
			}
			// thong bao cho table ve su thay doi 
			
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					model.fireTableDataChanged();
					
				}
			});
				
			}
		});
		
		
		
		JButton jButton_xoa_cncsd = new JButton("xóa");
		jButton_xoa_cncsd.setFont(new Font("Tahoma", Font.BOLD, 8));
		jButton_xoa_cncsd.setBounds(769, 206, 51, 25);
		jPanel_cncsd.add(jButton_xoa_cncsd);
		
		textField_makh = new JTextField();
		textField_makh.setColumns(10);
		textField_makh.setBounds(551, 195, 145, 19);
		jPanel_cncsd.add(textField_makh);
		
		textField_thang = new JTextField();
		textField_thang.setColumns(10);
		textField_thang.setBounds(141, 195, 145, 19);
		jPanel_cncsd.add(textField_thang);
		jPanel_cardLayout.add(jPanel_qlhd,"jPanel_qlhd");
		
		jButton_xoa_cncsd.addActionListener(new ActionListener() {

		

			
			@Override
			public void actionPerformed(ActionEvent e) {
				int maKhachHangCanXoa = Integer.valueOf(textField_makh.getText()+"");

				int luaChon = JOptionPane.showConfirmDialog(table_cncsd, "bạn có chắc chắn muốn xóa không ? ");
				if(luaChon == JOptionPane.YES_NO_OPTION) {
					capNhatChiSoDAO.getInstance().xoa(maKhachHangCanXoa);
				}
				xoaFormCncsd();
				DefaultTableModel model = (DefaultTableModel) table_cncsd.getModel();
				
				// lay du lieu moi tu co so du lieu
				ArrayList<capNhatChiSoDien> listDanhSach = capNhatChiSoDAO.getInstance().hienThiTatCa();
				// xoa du lieu tu model 
				model.setRowCount(0);
				
				// them du lieu moi 
				for (capNhatChiSoDien cs : listDanhSach) {
					Object[] rowData = {
							cs.getMaKhachHang(),
							cs.getThang(),
							cs.getChiSocu(),
							cs.getChiSoMoi()
							
					};
					model.addRow(rowData);
				}
				// thong bao cho table ve su thay doi 
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						model.fireTableDataChanged();
						
					}
				});


		
			}
		});
		
		
		JLabel jLabel_quan_li_hoa_don = new JLabel("                       Quản Lí Hóa Đơn");
		jLabel_quan_li_hoa_don.setOpaque(true);
		jLabel_quan_li_hoa_don.setFont(new Font("Times New Roman", Font.BOLD, 40));
		jLabel_quan_li_hoa_don.setBackground(Color.YELLOW);
		jLabel_quan_li_hoa_don.setBounds(0, 0, 864, 131);
		jPanel_qlhd.add(jLabel_quan_li_hoa_don);
		
		JPanel jPanel_thanh_toan = new JPanel();
		jPanel_thanh_toan.setBounds(42, 169, 404, 440);
		jPanel_qlhd.add(jPanel_thanh_toan);
		jPanel_thanh_toan.setLayout(null);
		
		JLabel jLabel_ho_ten_khach_hang = new JLabel("Họ Tên Khách Hàng");
		jLabel_ho_ten_khach_hang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_ho_ten_khach_hang.setBounds(10, 30, 140, 18);
		jPanel_thanh_toan.add(jLabel_ho_ten_khach_hang);
		
		jLabel_hoVaTen = new JLabel("..................................................");
		jLabel_hoVaTen.setBounds(206, 34, 131, 13);
		jPanel_thanh_toan.add(jLabel_hoVaTen);
		
		
		
		
		JLabel jLabel_so_luong_dien_tieu_thu = new JLabel("Số Lượng Điện Tiêu Thụ");
		jLabel_so_luong_dien_tieu_thu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_so_luong_dien_tieu_thu.setBounds(10, 108, 175, 18);
		jPanel_thanh_toan.add(jLabel_so_luong_dien_tieu_thu);
		
		JLabel jLabel_so_luong_dien_tieu_thu_dien = new JLabel("..............................................");
		jLabel_so_luong_dien_tieu_thu_dien.setBounds(206, 112, 131, 13);
		jPanel_thanh_toan.add(jLabel_so_luong_dien_tieu_thu_dien);
		
		JLabel jLabel_tong_tien = new JLabel("Tổng Thành Tiền");
		jLabel_tong_tien.setForeground(new Color(255, 0, 0));
		jLabel_tong_tien.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_tong_tien.setBounds(10, 185, 175, 18);
		jPanel_thanh_toan.add(jLabel_tong_tien);
		
		jLabel_tong_thanh_tien = new JLabel("..............................................");
		jLabel_tong_thanh_tien.setBounds(206, 256, 131, 13);
		jPanel_thanh_toan.add(jLabel_tong_thanh_tien);
		
		 jButton_xac_nhan_thanh_toan = new JButton("Xác nhận ");
		jButton_xac_nhan_thanh_toan.setBounds(239, 365, 118, 32);
		jPanel_thanh_toan.add(jButton_xac_nhan_thanh_toan);
		
		// tạo sự kiện chuyển nút 
		jButton_xac_nhan_thanh_toan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				congTac = !congTac; // chuyển đổi trạng thái
				capNhatNut();
				
				
				// tạo hiển thị 
				jLabel_tinh_trang_thanh_toan.setText("Đã thanh toán");
				
				capNhatChiSoDAO.getInstance().capNhatTinhTrang();
		
				
			}
		});
		
		
		 jButton_huy_xac_nhan = new JButton("Hủy xác nhận ");
		jButton_huy_xac_nhan.setBounds(99, 365, 118, 32);
		jPanel_thanh_toan.add(jButton_huy_xac_nhan);
		
		// tạo sự kiện chuyển nút 
		jButton_huy_xac_nhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				congTac = !congTac;// chuyển đổi trạng thái
				
				capNhatNut();
				// tạo hiện thị 
				
				jLabel_tinh_trang_thanh_toan.setText("Chưa thanh toán!");
				
				capNhatChiSoDAO.getInstance().capNhatTinhTrang();
				
		
				
			}
		});
		
	
		capNhatNut(); // khởi tạo giá trị ban đầu
		
		JLabel jLabel_tinh_trang = new JLabel("Tình trạng :");
		jLabel_tinh_trang.setForeground(Color.RED);
		jLabel_tinh_trang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabel_tinh_trang.setBounds(10, 291, 175, 18);
		jPanel_thanh_toan.add(jLabel_tinh_trang);
		
		jLabel_tinh_trang_thanh_toan = new JLabel("Chưa thanh toán!");
		jLabel_tinh_trang_thanh_toan.setForeground(new Color(255, 0, 0));
		jLabel_tinh_trang_thanh_toan.setBounds(206, 295, 131, 13);
		jPanel_thanh_toan.add(jLabel_tinh_trang_thanh_toan);
		
	
		
		textField_dien_ma_kh = new JTextField();
		textField_dien_ma_kh.setBounds(510, 229, 254, 19);
		jPanel_qlhd.add(textField_dien_ma_kh);
		textField_dien_ma_kh.setColumns(10);
		
		JLabel jLabel_mkh = new JLabel("Nhập Mã Khách Hàng");
		jLabel_mkh.setBounds(510, 206, 179, 13);
		jPanel_qlhd.add(jLabel_mkh);
		
			JButton jButton_timKiem = new JButton("Tìm Kiếm");
			jButton_timKiem.setBounds(578, 279, 142, 45);
			jButton_timKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(FormMain.class.getResource("icon_lookFor.png"))));
			
			
			jButton_timKiem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int maKhachHangCanTimKiem = Integer.valueOf(textField_dien_ma_kh.getText()+"");
					
					khachHang kq = capNhatChiSoDAO.getInstance().selectById(maKhachHangCanTimKiem);
					
					// hien thi ket qua len jLable_hoVaTen
					
					if(kq != null) {
						jLabel_hoVaTen.setText(kq.getTenKhachHang());
					}else {
						jLabel_hoVaTen.setText(" không tìm thấy khách hàng ");
					}
					
					capNhatChiSoDien ketQua = capNhatChiSoDAO.getInstance().selectedById_tien(maKhachHangCanTimKiem);
					
					if(ketQua != null) {
						jLabel_so_luong_dien_tieu_thu_dien.setText(ketQua.getLuongDienSuDung()+"");
						jLabel_tong_thanh_tien.setText(ketQua.getTienDien()+"");
						jLabel_tinh_trang_thanh_toan.setText(ketQua.getTinhTrangThanhToan()+"");
					}else {
						jLabel_so_luong_dien_tieu_thu_dien.setText(" khách hàng chưa sử dụng điện!");
						jLabel_tong_thanh_tien.setText("0");
					}
					
					
//					xoaFormHoaDonDien();
					
				}
			});
		
		
		jPanel_qlhd.add(jButton_timKiem);
		jPanel_cardLayout.setBounds(207, 0, 864, 650);
		
		jButton_qltt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_cardLayout,"jPanel_qltt");
				
			}
		});
		
		jButton_cncsd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_cardLayout,"jPanel_cntt");
				
			}
		});
		
		JButton_qlhd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(jPanel_cardLayout,"jPanel_qlhd");
				
			}
		});
		
		this.loadDataFromDatabase();
		this.loadDataFromDatabase_cncsd();

		contentPane.add(jPanel_cardLayout);
	}
	
	
	public void loadDataFromDatabase() {
	    // Xóa dữ liệu cũ từ JTable hoặc model (nếu cần)
	    DefaultTableModel model = (DefaultTableModel) table_qltt.getModel();
	    model.setRowCount(0);
	// hien thi tat ca du lieu len jtable
	ArrayList<khachHang> listKhachHang = khachHangDao.getInstance().hienThiTatCa();
	for (khachHang khachHang : listKhachHang) {
		themKhachHangVaoBang(khachHang);
	}
	}
	
	public void loadDataFromDatabase_cncsd() {
		// xoa du lieu cu tu Jtable 
		DefaultTableModel model = (DefaultTableModel) table_cncsd.getModel();
		model.setRowCount(0);
		
		// hien thi tat ca du lieu len jTable
		ArrayList<capNhatChiSoDien> listChiSoDien = capNhatChiSoDAO.getInstance().hienThiTatCa();
		for (capNhatChiSoDien capNhatChiSoDien : listChiSoDien) {
			themVaoBangTableCncsd(capNhatChiSoDien);
		}
	}
	
	
	public void xoaForm() {
		textField_ma_khach_hang.setText("");
		textField_ten_khach_hang.setText("");
		textField_cccd.setText("");
		JCB_dia_chi.setSelectedIndex(-1);
		buttonGroup_gioi_tinh.clearSelection();
		textField_sdt.setText("");
		textField_ngay_sinh.setText("");
		JCB_loai_dien_sd.setSelectedIndex(-1);
	}
	
	public void xoaFormCncsd() {
		textField_makh.setText("");
		textField_chi_so_dien_cu.setText("");
		textField_chi_so_dien_moi.setText("");
		textField_thang.setText("");
	}
	
	
	public void xoaFormHoaDonDien() {
		textField_dien_ma_kh.setText("");
	}
	
	
	
	
	public khachHang getKhachHangDaChon() {
		DefaultTableModel model_table = (DefaultTableModel) table_qltt.getModel();
    	int i_row = table_qltt.getSelectedRow();
    	
    	int maKhachHang = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
    	String tenKhachHang = model_table.getValueAt(i_row, 1) + "";
    	String canCuocCongDan = model_table.getValueAt(i_row, 2) + "";
    	tinhModel tinh = tinhModel.getTinhByTen(model_table.getValueAt(i_row, 3) + "");
    	String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
    	boolean gioiTinh = textGioiTinh.equals("Nam");
    	String soDienThoai = model_table.getValueAt(i_row, 5) + "";
    	String s_ngaySinh = model_table.getValueAt(i_row, 6)+"";
    	String ngaySinh = new String(s_ngaySinh);
    	String loaiKhachHang = model_table.getValueAt(i_row, 7)+"";
    	
    	
    	khachHang kh = new khachHang(maKhachHang, tenKhachHang, canCuocCongDan, tinh, gioiTinh, soDienThoai, ngaySinh, loaiKhachHang);
    	
    	return kh;
	}

	public void hienThiThongTinKhachHangDaChon() {
		
		khachHang kh = getKhachHangDaChon();
    	
    	 this.textField_ma_khach_hang.setText(kh.getMaKhachHang()+"");
	        this.textField_ten_khach_hang.setText(kh.getTenKhachHang()+"");
	        this.textField_cccd.setText(kh.getCanCuocCongDan()+"");
	        this.JCB_dia_chi.setSelectedItem(kh.getTinh().getTinh()+"");
	        if(kh.getGioiTinh()) {
	        	JBR_nam.setSelected(true);
	        }else {
	        	JBR_nu.setSelected(true);
	        }
	        this.textField_sdt.setText(kh.getSoDienThoai()+"");
	        this.textField_ngay_sinh.setText(kh.getNgaySinh()+"");
	        this.JCB_loai_dien_sd.setSelectedItem(kh.getLoaiDienSuDung());
		
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table_qltt.getModel();
    	int i_row = table_qltt.getSelectedRow();
    	int luaChon = JOptionPane.showConfirmDialog(this, "bạn có chắc chắn xóa không ? ");
    	if(luaChon == JOptionPane.YES_OPTION) {
    		khachHang kh = getKhachHangDaChon();
//    		this.quanLiKhachHangModel.xoa(kh);
    		model_table.removeRow(i_row);
    	}
	}
	
	public void hienThiThongTinLenBang() {
		int selectedRow = table_qltt.getSelectedRow();
		textField_ma_khach_hang.setText(table_qltt.getValueAt(selectedRow, 0)+"");
		textField_ten_khach_hang.setText(table_qltt.getValueAt(selectedRow, 1)+"");
		textField_cccd.setText(table_qltt.getValueAt(selectedRow, 2)+"");
		JCB_dia_chi.setSelectedItem(table_qltt.getValueAt(selectedRow, 3));
		String gioiTinh = table_qltt.getValueAt(selectedRow, 4)+"";
		if(gioiTinh.equals("Nam")) {
			JBR_nam.setSelected(true);
		}else {
			JBR_nu.setSelected(true);
		}
		textField_sdt.setText(table_qltt.getValueAt(selectedRow, 5)+"");
		textField_ngay_sinh.setText(table_qltt.getValueAt(selectedRow, 6)+"");
		JCB_loai_dien_sd.setSelectedItem(table_qltt.getValueAt(selectedRow, 7));
		
	}
	
	
	public void hienThiThongTinLenBangTableCncsd() {
		int selectedRow = table_cncsd.getSelectedRow();
		textField_makh.setText(table_cncsd.getValueAt(selectedRow, 0)+"");
		textField_thang.setText(table_cncsd.getValueAt(selectedRow, 1)+"");
		textField_chi_so_dien_cu.setText(table_cncsd.getValueAt(selectedRow, 2)+"");
		textField_chi_so_dien_moi.setText(table_cncsd.getValueAt(selectedRow, 3)+"");

		
		
		
		
		
	}
	
	public void themKhachHangVaoBang(khachHang kh) {
		DefaultTableModel model_table = (DefaultTableModel) table_qltt.getModel();
		model_table.addRow(new Object[] {kh.getMaKhachHang(), kh.getTenKhachHang() , kh.getCanCuocCongDan() , kh.getTinh().getTinh() , kh.getGioiTinh()?"Nam":"Nữ" , kh.getSoDienThoai() , kh.getNgaySinh() , kh.getLoaiDienSuDung()});
	}
	public void themVaoBangTableCncsd(capNhatChiSoDien cn) {
		DefaultTableModel model_table = (DefaultTableModel) table_cncsd.getModel();
		model_table.addRow(new Object[] {cn.getMaKhachHang() , cn.getThang() , cn.getChiSocu() ,cn.getChiSoMoi() , cn.getLuongDienSuDung(), cn.getTienDien()});
	}
	
	private void capNhatNut() {
		jButton_xac_nhan_thanh_toan.setEnabled(!congTac);
		jButton_huy_xac_nhan.setEnabled(congTac);
		
	}
	
	}

