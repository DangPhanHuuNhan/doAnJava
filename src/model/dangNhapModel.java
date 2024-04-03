package model;

public class dangNhapModel {
private String tenDangNhap;
private String maKhau;


public dangNhapModel(String tenDangNhap, String maKhau) {
	this.tenDangNhap = tenDangNhap;
	this.maKhau = maKhau;
}


public String getTenDangNhap() {
	return tenDangNhap;
}


public void setTenDangNhap(String tenDangNhap) {
	this.tenDangNhap = tenDangNhap;
}


public String getMaKhau() {
	return maKhau;
}


public void setMaKhau(String maKhau) {
	this.maKhau = maKhau;
}

}
