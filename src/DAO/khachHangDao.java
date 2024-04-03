package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import database.JDBCUtil;
import model.khachHang;
import model.tinhModel;
import view.FormMain;

public class khachHangDao implements interfaceDAO {
	public static khachHangDao getInstance() {
		return new khachHangDao();
	}
	@Override
	public int them() {
	// lay du lieu 
		
		int maKhachHang = 0;
		try {
	
			maKhachHang = Integer.valueOf(FormMain.textField_ma_khach_hang.getText()+"");
			
			// kiem tra ton tai 
			if(kiemTraTonTai(maKhachHang)) {
				JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại !");
				return 0;
			}
			
			// kiem tra maKhachHang 
			if(!kiemTraMaKhachHang(maKhachHang)) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null,"vui lòng nhập lại mã khách hàng *mã khách hàng phải là số","Lỗi",JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
	
		String tenKhachHang = FormMain.textField_ten_khach_hang.getText();
        String canCuocCongDan = FormMain.textField_cccd.getText() + "";
        int Tinh = FormMain.JCB_dia_chi.getSelectedIndex();
        tinhModel tinh = tinhModel.getTinhById(Tinh);
        boolean gioiTinh = true;
        if (FormMain.JBR_nam.isSelected()) {
            gioiTinh = true;
        } else if (FormMain.JBR_nu.isSelected()) {
            gioiTinh = false;
        }
        String gioiTinhString = gioiTinh ? "Nam" : "Nữ";
        String soDienThoai = FormMain.textField_sdt.getText();
        
        
        
        
        
        String ngaySinh = "0";
        
        try {
        	 ngaySinh = FormMain.textField_ngay_sinh.getText();
        	 
        	 
        	 // kiem tra ngay sinh 
        	 if(!kiemTraNgaySinh(ngaySinh)) {
        		 throw new IllegalArgumentException();
        	 }
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "vui lòng nhập lại ngày sinh * phải có định dạng nam-thang-ngay","Lỗi",JOptionPane.ERROR_MESSAGE);
			return 0;
		}
       
        
   
        
        String loaiDienSuDung = FormMain.JCB_loai_dien_sd.getSelectedItem() + "";

       // kiem tra so dien thoai neu xay ra loi thi thong bao 
        if(!kiemTraSoDienThoai(soDienThoai)) {
        	JOptionPane.showMessageDialog(null, "vui lòng nhập lại số điện thoại!","Lỗi",JOptionPane.ERROR_MESSAGE);
        	return 0;
        }
        
        // kiem tra so cccd
        if(!kiemTraSoCCCD(canCuocCongDan)) {
        	JOptionPane.showMessageDialog(null, "vui lòng nhập lại số căn cước công dân!" ,"Lỗi",JOptionPane.ERROR_MESSAGE);
        	return 0;
        }
       	try {
			// tao ket noi
	        Connection connection = JDBCUtil.getConnection();
	        
	        //tao prepared statemant 
	        String sql = "INSERT INTO khachhang (maKhachHang, tenKhachHang, cccd, tinh, gioiTinh, soDienThoai, ngaySinh, loaiDienSuDung) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = connection.prepareStatement(sql);
			
			st.setInt(1, maKhachHang);
			st.setString(2, tenKhachHang);
			st.setString(3, canCuocCongDan);
		    st.setString(4, tinh.getTinh());
		    st.setString(5, gioiTinhString);
		    st.setString(6, soDienThoai);
		    // chuyen doi chuoi ngay sinh thanh java.sql.date
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date pqDateNgaySinh = sdf.parse(ngaySinh);
		    java.sql.Date sqlNgaySinh = new java.sql.Date(pqDateNgaySinh.getTime());
		    st.setDate(7, sqlNgaySinh);
	        st.setString(8, loaiDienSuDung);
		    
	        // thuc thi cau lenh
	        int kq = st.executeUpdate();
	        System.out.println(" ban da thuc thi "+kq);
	        // ngat ket noi 
	        JDBCUtil.closeConnection(connection);
		    
		 } catch (NumberFormatException | SQLException | ParseException e) {
		        e.printStackTrace();
		    }		
	  return 0;
	}

	
	
	 // kiem tra so dien thoai 
    private boolean kiemTraSoDienThoai(String soDienThoai) {
    	// kiem tra so dien thoai phai bat dau tu so 0 va phai du 10 so
    	return soDienThoai.matches("^0\\d{9}$");
    }
    
    // kiem tra cccd
    private boolean kiemTraSoCCCD(String cccd) {
    	// cccd phai co do dai la 12 chu so 
    	if(cccd.length() != 12) {
    		return false;
    	}
    	
    	// cccd ko duoc chua cac ki tu khac so 
    	if(!cccd.matches("\\d+")) {
    		return false;
    	}
    	
    	return true;
    }
    
    private boolean kiemTraMaKhachHang(int maKhachHang) {
    	// chuyen doi int sang String va kiem tra ma khach hang phai so hay khong
    	return String.valueOf(maKhachHang).matches("\\d+");
    }
    
    
    // kiem tra ngay sinh 
    private boolean kiemTraNgaySinh(String ngaySinh) {
    	// dinh dang lai ngay 
    	boolean ngaySinhDinhDang = ngaySinh.matches("\\d{4}-\\d{2}-\\d{2}");
    	
    	if(!ngaySinhDinhDang) {
    		return false;
    	}
    	
    	//tach ngay sinh thanh ngay - thang - nam 
    	
    	String[] phan = ngaySinh.split("-");
    	int ngay = Integer.parseInt(phan[2]);
    	int thang = Integer.parseInt(phan[1]);
    	int nam = Integer.parseInt(phan[0]);
    	
    	// kiem tra dieu kien cua ngay thang nam
    	if(ngay <= 0 || ngay >31 || thang <=0 || thang > 12) {
    		return false;
    	}
    	
    	if(nam < 0) {
    		return false;
    	}
    	
    	return true;
    	
    }
    
	
	@Override
	public int xoa(int maKhachHang) {
		
		try {
			// tao ket noi 
			Connection connection = JDBCUtil.getConnection();
			
			// tao prepared statemant
			String sql = "DELETE from khachhang WHERE maKhachHang = " + "?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, maKhachHang);	
			
			
			// thuc hien cau lenh
			int kq = st.executeUpdate();
			System.out.println(" bạn đã thực thi lệnh xóa"+kq);
			
			// ngắt kết nối 
			
			JDBCUtil.closeConnection(connection);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int capNhat() {
	    int maKhachHang = Integer.valueOf(FormMain.textField_ma_khach_hang.getText());
	    String tenKhachHang = FormMain.textField_ten_khach_hang.getText();
	    String canCuocCongDan = FormMain.textField_cccd.getText();
	    int tinhIndex = FormMain.JCB_dia_chi.getSelectedIndex();
	    tinhModel tinh = tinhModel.getTinhById(tinhIndex);
	    boolean gioiTinh = FormMain.JBR_nam.isSelected();
	    String gioiTinhString = gioiTinh ? "Nam" : "Nữ";
	    String soDienThoai = FormMain.textField_sdt.getText();
	    String ngaySinh = FormMain.textField_ngay_sinh.getText();
	    String loaiDienSuDung = FormMain.JCB_loai_dien_sd.getSelectedItem().toString();

	    int check = 0;

	    try {
	        // Tạo kết nối
	        Connection con = JDBCUtil.getConnection();

	        // Tạo câu lệnh SQL sử dụng PreparedStatement để tránh lỗi cú pháp và chống SQL injection
	        String sql = "UPDATE khachhang " +
	                "SET tenKhachHang = ?, " +
	                "cccd = ?, " +
	                "tinh = ?, " +
	                "gioiTinh = ?, " +
	                "soDienThoai = ?, " +
	                "ngaySinh = ?, " +
	                "loaiDienSuDung = ? " +
	                "WHERE maKhachHang = ?";

	        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            // Đặt các giá trị tham số vào lệnh SQL
	            preparedStatement.setString(1, tenKhachHang);
	            preparedStatement.setString(2, canCuocCongDan);
	            preparedStatement.setString(3, tinh.getTinh());
	            preparedStatement.setString(4, gioiTinhString);
	            preparedStatement.setString(5, soDienThoai);
	            preparedStatement.setString(6, ngaySinh);
	            preparedStatement.setString(7, loaiDienSuDung);
	            preparedStatement.setInt(8, maKhachHang);

	            // Thực hiện câu lệnh SQL
	            check = preparedStatement.executeUpdate();

	            if (check > 0) {
	                JOptionPane.showMessageDialog(null, "Bạn đã sửa thành công!");
	            } else {
	                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Đóng kết nối
	            JDBCUtil.closeConnection(con);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return check;
	}

	@Override
	public ArrayList hienThiTatCa() {
		ArrayList<khachHang> ketQua = new ArrayList<khachHang>();
		
		
		try {
			// tao ket noi 
			Connection connection = JDBCUtil.getConnection();
			
			// tao statement
			Statement st = connection.createStatement();
			// thuc thi lenh sql 
			String sql = "SELECT * FROM khachhang";
			
			ResultSet rs = st.executeQuery(sql);
			
			// buoc 4
			
			
			while(rs.next()) {
				int maKhachHang = rs.getInt("maKhachHang");
				String tenKhachHang = rs.getString("tenKhachHang");
				String canCuocCongDan = rs.getString("cccd");
				 String tinhStr = rs.getString("tinh");
				 tinhModel tinh = tinhModel.getTinhByTen(tinhStr);
				
				 boolean gioiTinh = rs.getString("gioiTinh").equals("Nam");

				String soDienThoai = rs.getString("soDienThoai");
				
				
				// lấy giá trị ngày sinh dưới dạng java.sql.Date
				
				java.sql.Date NgaySinhDate = rs.getDate("NgaySinh");
				
				// chuyển đổi java.sql.Date sang String với dạng yyyy-MM-dd
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ngaySinhFormat = sdf.format(NgaySinhDate);
				
				
			
				String loaiDienSuDung = rs.getString("loaiDienSuDung");
				
				
				khachHang khachHang = new khachHang(maKhachHang, tenKhachHang, canCuocCongDan, tinh, gioiTinh, soDienThoai, ngaySinhFormat, loaiDienSuDung);
				ketQua.add(khachHang);
			}
			
			
			// buoc 5 ngat ket noi
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ketQua;
	}

public String[] layMaKhachHang() {
	List<String> ketQua = new ArrayList<String>();
	
	
	try {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT maKhachHang FROM khachhang");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			ketQua.add(rs.getString("maKhachHang"));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return ketQua.toArray(new String[1]);
}
@Override
public khachHang selectById(int maKhachHang) {
	// TODO Auto-generated method stub
	return null;
}
public boolean kiemTraTonTai(int maKhachHang) {
	boolean tonTai = false;
	
	
	try {
		Connection con = JDBCUtil.getConnection();
		
		// tao cau lenh su dung sql 
		String sql = "SELECT COUNT(*) FROM khachhang WHERE maKhachHang = ?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setInt(1, maKhachHang);
		
		// thuc hien cau lenh sql 
		ResultSet rs = pst.executeQuery();
		
		// kiem tra co ban ghi nao ton tai hay khong 
		if(rs.next()) {
			int dem = rs.getInt(1);
			tonTai = dem > 0;
		}
		
		// ngat ket noi 
		JDBCUtil.closeConnection(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return tonTai;
}

}
