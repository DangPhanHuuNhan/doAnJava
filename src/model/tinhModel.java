package model;

import java.util.ArrayList;
import java.util.Objects;

public class tinhModel {
private String Tinh;
private int maTinh;



public tinhModel(String tinh, int maTinh) {
	Tinh = tinh;
	this.maTinh = maTinh;
}



public String getTinh() {
	return Tinh;
}



public void setTinh(String tinh) {
	Tinh = tinh;
}



public int getMaTinh() {
	return maTinh;
}



public void setMaTinh(int maTinh) {
	this.maTinh = maTinh;
}



@Override
public String toString() {
	return "tinhModel [Tinh=" + Tinh + ", maTinh=" + maTinh + "]";
}



@Override
public int hashCode() {
	return Objects.hash(Tinh, maTinh);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	tinhModel other = (tinhModel) obj;
	return Objects.equals(Tinh, other.Tinh) && maTinh == other.maTinh;
}

public static ArrayList<tinhModel> getDanhSachTinh(){
	String[] arrTinh = {"An Giang",
			"Bà Rịa – Vũng Tàu",
			"Bạc Liêu",
			"Bắc Giang",
			"Bắc Kạn",
			"Bắc Ninh",
			"Bến Tre",
			"Bình Dương",
			"Bình Định",
			"Bình Phước",
			"Bình Thuận",
			"Cà Mau",
			"Cao Bằng",
			"Cần Thơ",
			"Đà Nẵng",
			"Đắk Lắk",
			"Đắk Nông",
			"Điện Biên",
			"Đồng Nai",
			"Đồng Tháp",
			"Gia Lai",
			"Hà Giang",
			"Hà Nam",
			"Hà Nội",
			"Hà Tĩnh",
			"Hải Dương",
			"Hải Phòng",
			"Hậu Giang",
			"Hòa Bình",
			"Thành phố Hồ Chí Minh",
			"Hưng Yên",
			"Khánh Hòa",
			"Kiên Giang",
			"Kon Tum",
			"Lai Châu",
			"Lạng Sơn",
			"Lào Cai",
			"Lâm Đồng",
			"Long An",
			"Nam Định",
			"Nghệ An",
			"Ninh Bình",
			"Ninh Thuận",
			"Phú Thọ",
			"Phú Yên",
			"Quảng Bình",
			"Quảng Nam",
			"Quảng Ngãi",
			"Quảng Ninh",
			"Quảng Trị",
			"Sóc Trăng",
			"Sơn La",
			"Tây Ninh",
			"Thái Bình",
			"Thái Nguyên",
			"Thanh Hóa",
			"Thừa Thiên Huế",
			"Tiền Giang",
			"Trà Vinh",
			"Tuyên Quang",
			"Vĩnh Long",
			"Vĩnh Phúc",
			"Yên Bái"};
	ArrayList<tinhModel> listTinh = new ArrayList<tinhModel>();
	
	int i =0;
	for (String tinh : arrTinh) {
		tinhModel Tinh = new tinhModel(tinh, i);
		listTinh.add(Tinh);
	}
	return listTinh;
}



public static tinhModel getTinhById(int tinhById) {
	return tinhModel.getDanhSachTinh().get(tinhById);
	}



public static tinhModel getTinhByTen(String tenTinh) {
	ArrayList<tinhModel> listTinh = tinhModel.getDanhSachTinh();
	for (tinhModel tinh : listTinh) {
		if(tinh.Tinh.equals(tenTinh)) 
			return tinh;
		}
	return null;
	}
}


