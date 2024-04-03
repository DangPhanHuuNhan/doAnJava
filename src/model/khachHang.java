package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import database.JDBCUtil;

public class khachHang {
private int maKhachHang;
private String tenKhachHang;
private String canCuocCongDan;
private tinhModel tinh;
private Boolean gioiTinh;
private String soDienThoai;
private String ngaySinh;
private String loaiDienSuDung;


public khachHang(String tenKhachHang) {
	this.tenKhachHang = tenKhachHang;
}
public khachHang() {
}


public khachHang(int maKhachHang, String tenKhachHang, String canCuocCongDan, tinhModel tinh, Boolean gioiTinh,
		String soDienThoai, String ngaySinh, String loaiDienSuDung) {
	this.maKhachHang = maKhachHang;
	this.tenKhachHang = tenKhachHang;
	this.canCuocCongDan = canCuocCongDan;
	this.tinh = tinh;
	this.gioiTinh = gioiTinh;
	this.soDienThoai = soDienThoai;
	this.ngaySinh = ngaySinh;
	this.loaiDienSuDung = loaiDienSuDung;
}


public int getMaKhachHang() {
	return maKhachHang;
}


public void setMaKhachHang(int maKhachHang) {
	this.maKhachHang = maKhachHang;
}


public String getTenKhachHang() {
	return tenKhachHang;
}


public void setTenKhachHang(String tenKhachHang) {
	this.tenKhachHang = tenKhachHang;
}


public String getCanCuocCongDan() {
	return canCuocCongDan;
}


public void setCanCuocCongDan(String canCuocCongDan) {
	this.canCuocCongDan = canCuocCongDan;
}


public tinhModel getTinh() {
	return tinh;
}


public void setTinh(tinhModel tinh) {
	this.tinh = tinh;
}


public Boolean getGioiTinh() {
	return gioiTinh;
}


public void setGioiTinh(Boolean gioiTinh) {
	this.gioiTinh = gioiTinh;
}


public String getSoDienThoai() {
	return soDienThoai;
}


public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}


public String getNgaySinh() {
	return ngaySinh;
}


public void setNgaySinh(String ngaySinh) {
	this.ngaySinh = ngaySinh;
}


public String getLoaiDienSuDung() {
	return loaiDienSuDung;
}


public void setLoaiDienSuDung(String loaiDienSuDung) {
	this.loaiDienSuDung = loaiDienSuDung;
}




@Override
public int hashCode() {
	return Objects.hash(canCuocCongDan, gioiTinh, loaiDienSuDung, maKhachHang, ngaySinh, soDienThoai, tenKhachHang,
			tinh);
}



@Override
public String toString() {
	return "khachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", canCuocCongDan="
			+ canCuocCongDan + ", tinh=" + tinh + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai
			+ ", ngaySinh=" + ngaySinh + ", loaiDienSuDung=" + loaiDienSuDung + "]";
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	khachHang other = (khachHang) obj;
	return canCuocCongDan == other.canCuocCongDan && Objects.equals(gioiTinh, other.gioiTinh)
			&& Objects.equals(loaiDienSuDung, other.loaiDienSuDung) && Objects.equals(maKhachHang, other.maKhachHang)
			&& Objects.equals(ngaySinh, other.ngaySinh) && soDienThoai == other.soDienThoai
			&& Objects.equals(tenKhachHang, other.tenKhachHang) && Objects.equals(tinh, other.tinh);
}
}
