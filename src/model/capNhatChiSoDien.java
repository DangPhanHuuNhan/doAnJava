package model;

import java.util.Objects;

public class capNhatChiSoDien {

	private int maKhachHang;
	private double chiSocu;
	private double chiSoMoi;
	private thangModel thang;
	private double chiSoDienCu;
	private double chiSoDienMoi;
	private double luongDienSuDung;
	private double tienDien;
	private String tinhTrangThanhToan;
	
	public capNhatChiSoDien(double luongDienSuDung , double tienDien , String tinhTrangThanhToan) {
		this.luongDienSuDung = luongDienSuDung;
		this.tienDien = tienDien;
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}

	
	
	public String getTinhTrangThanhToan() {
		return tinhTrangThanhToan;
	}





	public void setTinhTrangThanhToan(String tinhTrangThanhToan) {
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}





	public double getLuongDienSuDung() {
		return luongDienSuDung;
	}


	public void setLuongDienSuDung(double luongDienSuDung) {
		this.luongDienSuDung = luongDienSuDung;
	}


	public double getTienDien() {
		return tienDien;
	}


	public void setTienDien(double tienDien) {
		this.tienDien = tienDien;
	}


	public capNhatChiSoDien() {
	
	}
	

	


	public double getChiSoDienCu() {
		return chiSoDienCu;
	}


	public void setChiSoDienCu(double chiSoDienCu) {
		this.chiSoDienCu = chiSoDienCu;
	}


	public double getChiSoDienMoi() {
		return chiSoDienMoi;
	}


	public void setChiSoDienMoi(double chiSoDienMoi) {
		this.chiSoDienMoi = chiSoDienMoi;
	}


	public capNhatChiSoDien(int maKhachHang, thangModel thang, double chiSocu, double chiSoMoi) {
		this.maKhachHang = maKhachHang;
		this.chiSocu = chiSocu;
		this.chiSoMoi = chiSoMoi;
		this.thang = thang;
	}


	public int getMaKhachHang() {
		return maKhachHang;
	}


	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}


	public double getChiSocu() {
		return chiSocu;
	}


	public void setChiSocu(double chiSocu) {
		this.chiSocu = chiSocu;
	}


	public double getChiSoMoi() {
		return chiSoMoi;
	}


	public void setChiSoMoi(double chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}


	public thangModel getThang() {
		return thang;
	}


	public void setThang(thangModel thang) {
		this.thang = thang;
	}


	@Override
	public int hashCode() {
		return Objects.hash(chiSoMoi, chiSocu, maKhachHang, thang);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		capNhatChiSoDien other = (capNhatChiSoDien) obj;
		return Double.doubleToLongBits(chiSoMoi) == Double.doubleToLongBits(other.chiSoMoi)
				&& Double.doubleToLongBits(chiSocu) == Double.doubleToLongBits(other.chiSocu)
				&& maKhachHang == other.maKhachHang && Objects.equals(thang, other.thang);
	}


	@Override
	public String toString() {
		return "capNhatChiSoDien [maKhachHang=" + maKhachHang + ", chiSocu=" + chiSocu + ", chiSoMoi=" + chiSoMoi
				+ ", thang=" + thang + "]";
	}
	
	
	
	
}
