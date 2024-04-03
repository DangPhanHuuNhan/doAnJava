package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.JDBCUtil;
import view.dangKiView;
import view.dangKiViewAdmin;


public class dangNhapDAO {
public static dangNhapDAO getInstance() {
	return new dangNhapDAO();
}
public boolean dangNhap() {
	
	
	try {
		String tenDangKi = dangKiView.textField_tenDangNhap.getText();
		String matKhau = dangKiView.textField_matKhau.getText();
		String tenNguoiYeuThich = dangKiView.textField_nguoi_ban_quy.getText();
		
		if(!kiemTraTenDangNhap(tenDangKi)) {
			JOptionPane.showMessageDialog(null, "vui lòng nhập lại tên đăng kí! \n * tên đăng kí phải theo dạng : ten@gmail.com","LỖI",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!kiemTraMatKhauDangKi(matKhau)) {
			JOptionPane.showMessageDialog(null, "vui lòng nhập lại mật khẩu ! \n *mật khẩu phải gồm: \n ●Ít nhất một chữ cái thường \n ●Ít nhất một chữ cái hoa \n ●Ít nhất một chữ số \n ●Ít nhất 1 kí tự đặc biệt \n ●Ít nhất 8 ký tự","LỖI",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// tao ket noi 
		Connection con = JDBCUtil.getConnection();
		
		// tao cau lenh sql
		String sql = "INSERT INTO dangnhap(tenDangNhap , matKhau , tenNguoiBanYeuThich) VALUES (? , ? , ?)";
		
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, tenDangKi);
		pst.setString(2, matKhau);
		pst.setString(3, tenNguoiYeuThich);
		// thuc hien lenh 
		int kq = pst.executeUpdate();
		
		
		// ngat ket noi
		JDBCUtil.closeConnection(con);
		
		return kq > 0;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}


//kiem tra tai khoan nhap dung khong
private boolean kiemTraTenDangNhap(String tenDangNhap) {
	return tenDangNhap.matches("^[a-zA-Z0-9_]+@[a-zA-Z0-9_]+\\.[a-zA-Z]{2,}$");
}
private boolean kiemTraMatKhauDangKi(String matKhau) {
	return matKhau.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}|:<>?])[a-zA-Z\\d!@#$%^&*()_+{}|:<>?]{8,}$");
}

public boolean dangKiAdmin() {
	
	
	try {

		
		String tenDangKi = dangKiViewAdmin.textField_dangKi.getText();
		String matKhau = dangKiViewAdmin.textField_matKhau.getText();
		
		
		//kiểm tra tên đăng kí 
		if(!kiemTraTenDangNhap(tenDangKi)) {
			JOptionPane.showMessageDialog(null, "vui lòng nhập lại tên đăng kí! \n * tên đăng kí phải theo dạng : ten@gmail.com","LỖI",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// kiểm tra mật khẩu đăng kí 
		if(!kiemTraMatKhauDangKi(matKhau)) {
			JOptionPane.showMessageDialog(null, "vui lòng nhập lại mật khẩu ! \n *mật khẩu phải gồm: \n ●Ít nhất một chữ cái thường \n ●Ít nhất một chữ cái hoa \n ●Ít nhất một chữ số \n ●Ít nhất 1 kí tự đặc biệt \n ●Ít nhất 8 ký tự","LỖI",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// tao ket noi 
		Connection con = JDBCUtil.getConnection();
		
		// tao cau lenh sql
		String sql = "INSERT INTO dangnhapadmin (tenDangNhap , matKhau) VALUES (? , ?)";
		
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, tenDangKi);
		pst.setString(2, matKhau);
		
		// thuc hien lenh 
		int kq = pst.executeUpdate();
		
		
		// ngat ket noi
		JDBCUtil.closeConnection(con);
		
		return kq > 0;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}





public boolean kiemTraDangNhap(String tenDangNhap , String matKhau) {
	
	
	
	try {
		// tao ket noi
		Connection con = JDBCUtil.getConnection();
		
		// tao cau lenh sql
		String sql = " SELECT * FROM dangnhap WHERE tenDangNhap = ? AND matKhau = ?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, tenDangNhap);
		pst.setString(2, matKhau);
		
		
		// thuc hien truy van csdl
		ResultSet rs = pst.executeQuery();
		// kiem tra 
		boolean kiemTra = rs.next();
		
//		System.out.println(kiemTra);
		rs.close();
		
		
		// ngat ket noi
		JDBCUtil.closeConnection(con);
		
		return kiemTra;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}

public boolean kiemTraDoiMatKhau(String tenDangNhap , String tenNguoiBanYeuQuy) {
	
	
	try {
		// tạo kết nối 
		Connection con = JDBCUtil.getConnection();
		
		// tạo câu lệnh sql
		String sql = " SELECT * FROM dangnhap WHERE tenDangNhap = ? AND tenNguoiBanYeuThich = ?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, tenDangNhap);
		pst.setString(2, tenNguoiBanYeuQuy);
		
		// thực hiện truy vấn Sql
		ResultSet rs = pst.executeQuery();
		
		// kiểm tra 
		boolean kiemTra = rs.next();
		
		rs.close();
		
		// ngắt kết nối
		JDBCUtil.closeConnection(con);
		
		return kiemTra;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}


public boolean doiMatKhau(String tenDangNhap , String matKhauMoi , String tenNguoiBanYeuQuy) {
	
		try {
			if(kiemTraDoiMatKhau(tenDangNhap, tenNguoiBanYeuQuy)) {
				// tạo kết nối 
				Connection con = JDBCUtil.getConnection();
				
				// tạo câu lệnh sql để cập nhật
				String sql = "UPDATE dangnhap SET matKhau = ? WHERE tenDangNhap = ?";
				
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, matKhauMoi);
				pst.setString(2, tenDangNhap);
				
				// thực hiện câu lệnh 
				int kq = pst.executeUpdate();
				
				// ngắt kết nối 
				JDBCUtil.closeConnection(con);
				
				return kq >0;
						
			}else {
//				JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công!","LỖI",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	
}
public boolean kiemTraDangNhapAdmin(String tenDangNhap , String matKhau) {
	
	
	
	try {
		// tao ket noi
		Connection con = JDBCUtil.getConnection();
		
		// tao cau lenh sql
		String sql = " SELECT * FROM dangnhapadmin WHERE tenDangNhap = ? AND matKhau = ?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, tenDangNhap);
		pst.setString(2, matKhau);
		
		
		// thuc hien truy van csdl
		ResultSet rs = pst.executeQuery();
		// kiem tra 
		boolean kiemTra = rs.next();
		
		System.out.println(kiemTra);
		rs.close();
		
		
		// ngat ket noi
		JDBCUtil.closeConnection(con);
		
		return kiemTra;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}
public boolean kiemTraDoiMatKhauAdmin(String tenDangNhap ) {
	
		
		
		try {
		
			// tạo kết nối 
			Connection con = JDBCUtil.getConnection();
			// tạo lệnh sql 
			String sql = " SELECT * FROM dangnhapadmin WHERE tenDangNhap = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tenDangNhap);
			ResultSet rs = pst.executeQuery();
			
			// kiểm tra 
			boolean kt = rs.next();
			
			rs.close();
			
			JDBCUtil.closeConnection(con);
			
			return kt;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
}

public boolean doiMatKhauAdmin(String tenDangNhap, String matKhauMoi ) {
	
	if(kiemTraDoiMatKhauAdmin(tenDangNhap)) {
		
		try {
			// tạo kết nối
			Connection con = JDBCUtil.getConnection();
			
			// lệnh sql 
			String sql = "UPDATE dangnhapadmin SET matKhau = ? WHERE tenDangNhap = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, matKhauMoi);
			pst.setString(2 , tenDangNhap);
			
			// thực hiện lệnh 
			int kq = pst.executeUpdate();
			
			// ngắt kết nối
			JDBCUtil.closeConnection(con);
			
			return kq>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	return false;
}
}
