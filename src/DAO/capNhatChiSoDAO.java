package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import database.JDBCUtil;
import model.capNhatChiSoDien;
import model.khachHang;

import model.thangModel;
import model.tinhModel;
import view.FormMain;

public class capNhatChiSoDAO implements interfaceDAO{
	public static capNhatChiSoDAO getInstance() {
		return new capNhatChiSoDAO();
	}
	@Override
	public int them() {
		
		// lay du lieu 
		int maKhachHang = Integer.valueOf(FormMain.textField_makh.getText()+"");
		
		// kiem tra xem ma khach hang da ton tai hay chua 
		if(kiemTraTonTaiCncsd(maKhachHang)) {
			
			
			
			

			double chiSoDiencu = 0;
			double chiSoDienMoi = 0;
			
			
			try {
				 chiSoDiencu = Double.valueOf(FormMain.textField_chi_so_dien_cu.getText()+"");
					// kiem tra chi so dien cu
					
					if(!kiemTraTienDienCu(chiSoDiencu)) {
	
						throw new IllegalArgumentException();
						
					}
					
					 chiSoDienMoi = Double.valueOf(FormMain.textField_chi_so_dien_moi.getText()+"");
					// kiem tra chi so dien moi
					
					if(!kiemTraTienDienMoi(chiSoDienMoi)) {
	
						throw new IllegalArgumentException();
						
					}
					
					
				 
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null,"vui lòng nhập lại chỉ số điện!" , "LỖI",JOptionPane.ERROR_MESSAGE);
				return 0;

			}
			
			
			
			
			int thang = Integer.valueOf(FormMain.textField_thang.getText()+"");
			
			
			// kiem tra thang 
			if(!kiemTraThang(thang)) {
				JOptionPane.showMessageDialog(null, "vui lòng nhập lại tháng!", "LỖI",JOptionPane.ERROR_MESSAGE);
				return 0;
			}
			
			try {
				
				// tinh tien dien su dung
				double luongDienSuDung = chiSoDienMoi - chiSoDiencu;
				
				//tinh tien dien 
				double tienDien = tinhTienDien(maKhachHang , luongDienSuDung);
			
				// lấy dữ liệu tình trạng thanh toán
				String tinhTrangThanhToan = FormMain.jLabel_tinh_trang_thanh_toan.getText();
				
			// tao ket noi
	        Connection connection = JDBCUtil.getConnection();
	        
	        //tao prepared statemant 
	        String sql = "INSERT INTO capnhatchisodien (maKhachHang, thang ,chiSoDiencu, chiSoDienMoi , luongDienSuDung , tienDien , tinhTrangThanhToan) VALUES (?, ?, ?, ? ,? ,? ,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			
			st.setInt(1, maKhachHang);
			 st.setInt(2, thang);
			st.setDouble(3, chiSoDiencu);
			st.setDouble(4, chiSoDienMoi);
			st.setDouble(5, luongDienSuDung);
			st.setDouble(6, tienDien);
		   st.setString(7, tinhTrangThanhToan);
		 
	        // thuc thi cau lenh
	        int kq = st.executeUpdate();
	        System.out.println(" ban da thuc thi "+kq);
	        // ngat ket noi 
	        JDBCUtil.closeConnection(connection);
		    
		 } catch (NumberFormatException | SQLException  e) {
		        e.printStackTrace();
		    }		
		}else {
			JOptionPane.showMessageDialog(null, "Mã Khách hàng không tồn tại");
		}
		
		
		
		
		  return 0;
		}
	 
	// kiem tra thang 
		private boolean kiemTraThang(int thang) {
			return String.valueOf(thang).matches("^(1[0-2]|[1-9])$");
		}
	// kiem tra tien dien cu
		private boolean kiemTraTienDienCu(double chiSoDienCu) {
			
			 boolean tienDienCu = String.valueOf(chiSoDienCu).matches("^\\d+(\\.\\d+)?$");
			 
			 // kiem tra xem so tien dien nhap vao co phai so hay khong
			 if(!tienDienCu) {
				 return false;
			 }
			 
			 // so tien khong duoc am
			 if(chiSoDienCu < 0) {
				 return false;
			 }
			 
			 
			 return true;
		}
	
		// kiem tra tien dien moi
		private boolean kiemTraTienDienMoi(double chiSoDienMoi) {
			
			 boolean tienDienMoi = String.valueOf(chiSoDienMoi).matches("^\\d+(\\.\\d+)?$");
			 
			 // kiem tra xem so tien dien nhap vao co phai so hay khong
			 if(!tienDienMoi) {
				 return false;
			 }
			 
			 // so tien khong duoc am
			 if(chiSoDienMoi < 0) {
				 return false;
			 }
			 
			 
			 return true;
		}

		
//	@Override
//	public int xoa(int maKhachHang) {
//		try {
//			// tao ket noi
//	        Connection connection = JDBCUtil.getConnection();
//	        
//	        //tao prepared statemant 
//	        String sql = "DELETE FROM capnhatchisodien WHERE maKhachHang = "+ "?";
//			PreparedStatement st = connection.prepareStatement(sql);
//			
//			st.setInt(1, maKhachHang);
//			
//		   
//		 
//	        // thuc thi cau lenh
//	        int kq = st.executeUpdate();
//	        System.out.println(" ban da thuc thi lenh xoa "+kq);
//	        // ngat ket noi 
//	        JDBCUtil.closeConnection(connection);
//		    
//		 } catch (NumberFormatException | SQLException  e) {
//		        e.printStackTrace();
//		    }		
//			
//			  return 0;
//			}
	
	

	@Override
	public int capNhat() {
		// lay du lieu 
				int maKhachHang = Integer.valueOf(FormMain.textField_makh.getText()+"");
				int thang = Integer.valueOf(FormMain.textField_thang.getText()+"");
				double chiSoDiencu = Double.valueOf(FormMain.textField_chi_so_dien_cu.getText()+"");
				double chiSoDienMoi = Double.valueOf(FormMain.textField_chi_so_dien_moi.getText()+"");
				
				
				int check = 0;
				
				
				//tao ket noi 
				Connection con = JDBCUtil.getConnection();
				
				// tao cau lenh sql 
				String sql ="UPDATE capnhatchisodien "+
				"SET thang = ?, "+
						"chiSoDienCu = ?, "+
				"chiSoDienMoi = ? "+
						"WHERE maKhachHang = ?";
				
				
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					// dat cac tham so vào cau lenh sql 
					pst.setInt(1, thang);
					pst.setDouble(2, chiSoDiencu );
					pst.setDouble(3, chiSoDienMoi);
					
					pst.setInt(4, maKhachHang);
					
					// thuc thi cau lenh 
					check = pst.executeUpdate();
					
					if(check >0) {
						JOptionPane.showMessageDialog(null, "bạn đã sửa thành công! ");
					}else {
						JOptionPane.showMessageDialog(null, "sửa thất bại ! ");
					}
					
					// dong ket noi
					JDBCUtil.closeConnection(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return check;
	}
	
	
	public int capNhatTinhTrang() {
		// lấy dữ liệu
		int maKhachHang = Integer.valueOf(FormMain.textField_dien_ma_kh.getText()+"");
		String tinhTrangThanhToan = FormMain.jLabel_tinh_trang_thanh_toan.getText();
		
		
		int check =0;
		
		// tạo kết nối 
		Connection con = JDBCUtil.getConnection();
		
		// tạo câu lệnh sql 
		String sql = "UPDATE capnhatchisodien "+
				"SET tinhTrangThanhToan = ? "+
				"WHERE maKhachHang = ?";
		
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tinhTrangThanhToan);
			pst.setInt(2, maKhachHang);
			
			
			// thực thi câu lệnh
			check = pst.executeUpdate();
			
			// đóng kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	@Override
	public ArrayList hienThiTatCa() {
		ArrayList<capNhatChiSoDien> ketQua = new ArrayList<capNhatChiSoDien>();
		
		
		try {

			// tao ket noi 
			Connection con = JDBCUtil.getConnection();
			
			// tao statement
			Statement st = con.createStatement();
			
			// thuc thi cau lenh
			String sql = "SELECT * FROM capnhatchisodien";
			
			ResultSet rs = st.executeQuery(sql);
			
			// buoc 4 thuc thi cau lenh 
			while(rs.next()) {
				int maKhachHang = rs.getInt("maKhachHang");
				String thangString = rs.getString("thang");
				int thang = Integer.parseInt(thangString);
				thangModel thangModel = new thangModel(thang);
				double chiSoDienCu = rs.getDouble("chiSoDienCu");
				double chiSoDienMoi = rs.getDouble("chiSoDienMoi");
				
				
				
				capNhatChiSoDien capNhatChiSoDien = new capNhatChiSoDien(maKhachHang, thangModel ,chiSoDienCu, chiSoDienMoi);
				ketQua.add(capNhatChiSoDien);
				
			
			}
			// ngat ket noi
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public khachHang selectById(int maKhachHang) {
		khachHang ketQua = null;
		
	
		
		try {
			
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			
			String sql = "SELECT * FROM khachhang Where maKhachHang = '"+maKhachHang+"'";
			
			System.out.println(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String tenKhachHang = rs.getString("tenKhachHang");
				
				ketQua = new khachHang(tenKhachHang);
				
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ketQua;
	}
	public capNhatChiSoDien selectedById_tien(int maKhachHang) {
		capNhatChiSoDien ketQua = null;
		
				
		try {
			Connection con = JDBCUtil.getConnection();

			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM capnhatchisodien Where maKhachHang = '"+maKhachHang+"'";
			
			System.out.println(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				double luongDienSuDung = rs.getDouble("luongDienSuDung");
				double tienDien = rs.getDouble("tienDien");
				String tinhTrangThanhToan = rs.getString("tinhTrangThanhToan");
				ketQua = new capNhatChiSoDien(luongDienSuDung, tienDien , tinhTrangThanhToan);
			
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
public double luongDienSuDung(int maKhachHang) {
	
	double luongDienSuDung =0;
	
	
	
	try {
		Connection con = JDBCUtil.getConnection();
		
		// tao cau lenh sql 
		String sql = "SELECT chiSoDienCu , chiSoDienMoi From capnhatchisodien Where maKhachHang = ? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, maKhachHang);
		
		// thuc thi cau lenh 
		ResultSet rs = pst.executeQuery();
		
		// xu li cau lenh 
		if(rs.next()) {
			double chiSoDienCu = rs.getDouble("chiSoDienCu");
			double chiSoDienMoi = rs.getDouble("chiSoDienMoi");
			
			// tính lượng điện sử dụng 
			luongDienSuDung = chiSoDienMoi - chiSoDienCu;
		}
		
		JDBCUtil.closeConnection(con);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return luongDienSuDung;
	
}
	
public double tinhTienDien(int maKhachHang , double luongDienSuDung) {
	


	double tienDien =0;

	
		double[] giaBac = {1.728, 1.786, 2.074, 2.612, 2.919, 3.015};
		
		  for (int i = 0; i < giaBac.length; i++) {
		        if (luongDienSuDung <= 0) {
		            break;
		        }
		        
		        if (luongDienSuDung <= 50) {
		            tienDien += luongDienSuDung * giaBac[i];
		            break;
		        } else {
		            tienDien += 50 * giaBac[i];
		            luongDienSuDung -= 50;
		        }
		        for (int j = 0; j < giaBac.length; j++) {
			        if (luongDienSuDung <= 0) {
			            break;
			        }
			        
			        if (luongDienSuDung <= 50) {
			            tienDien += luongDienSuDung * giaBac[i];
			            break;
			        } else {
			            tienDien += 50 * giaBac[i];
			            luongDienSuDung -= 50;
			        }
			    }
		    }
return tienDien;
}


public boolean kiemTraTonTaiCncsd(int maKhachHang) {
	boolean tonTai = false;
	
	
	
	try {
		// tao ket noi 
		Connection con = JDBCUtil.getConnection();
		
		// tao lenh sql 
		String sql = "SELECT COUNT(*) FROM khachhang WHERE maKhachHang = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setInt(1, maKhachHang);
		
		// thuc thi lenh 
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

@Override
public int xoa(int maKhachHang) {
	try {
		// tao ket noi
        Connection connection = JDBCUtil.getConnection();
        
        //tao prepared statemant 
        String sql = "DELETE FROM capnhatchisodien WHERE maKhachHang = "+ "?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, maKhachHang);
		
	   
	 
        // thuc thi cau lenh
        int kq = st.executeUpdate();
        System.out.println(" ban da thuc thi lenh xoa "+kq);
        // ngat ket noi 
        JDBCUtil.closeConnection(connection);
	    
	 } catch (NumberFormatException | SQLException  e) {
	        e.printStackTrace();
	    }		
		
		  return 0;
		}

	
	
//	try {
//		//dang ki MYSQL Driver với Driver Manager
//		DriverManager.registerDriver(new Driver());
//		
//		// các thông số
//		String url ="jdbc:mySQL://localhost:3306/qlkh";
//		String username = "root";
//		String password = "";
//
//		
//		
//		Connection c = DriverManager.getConnection(url, username, password);
//		
//		
//		 String sql = "DELETE FROM capnhatchisodien WHERE maKhachHang = "+ "?";
//       
//		 
//		 PreparedStatement pst = c.prepareStatement(sql);
//		 
//		 pst.setInt(1, maKhachHang);
//		 
//		 // thuc thi lenh 
//		 int kq = pst.executeUpdate();
//		 
//		 // ngat ket noi
//		 
//		 if(c != null) {
//			c.close();
//		 }
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	
//	
//}

}
	
	
	
	
	


