package model;

import java.util.ArrayList;
import java.util.Objects;

public class thangModel {
private int thang;

public thangModel(int thang) {
	this.thang = thang;
}

public int getThang() {
	return thang;
}

public void setThang(int thang) {
	this.thang = thang;
}

@Override
public int hashCode() {
	return Objects.hash(thang);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	thangModel other = (thangModel) obj;
	return thang == other.thang;
}

@Override
public String toString() {
	return thang+"";
}

public static ArrayList<thangModel> getDanhSachThang(){
	int[] arr_thang = {
	1,2,3,4,5,6,7,8,9,10,11,12};
	ArrayList<thangModel> listThang = new ArrayList<thangModel>();
	
	for ( int i : arr_thang) {
		thangModel thangModel = new thangModel(i);
		listThang.add(thangModel);
	}
	return listThang;
	
	
}
}