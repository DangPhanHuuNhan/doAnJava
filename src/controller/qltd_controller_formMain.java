package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;


import model.khachHang;
import model.tinhModel;
import view.FormMain;

public class qltd_controller_formMain implements ActionListener{
private FormMain formMain;
private Object textField_ngay_sinh;

public qltd_controller_formMain(FormMain formMain) {
	this.formMain = formMain;
}

@Override
public void actionPerformed(ActionEvent e) {
	String cm = e.getActionCommand();
//	JOptionPane.showMessageDialog(formMain, "bạn đã nhấn nút "+cm);

	if(cm.equals("Thêm")) {
		this.formMain.xoaForm();
		
	}else if(cm.equals("Lưu")) {
		
//	try {
//	// lấy dữ liệu		
//	int maKhachHang = Integer.valueOf(this.formMain.textField_ma_khach_hang.getText()+"");
//	String tenKhachHang = this.formMain.textField_ten_khach_hang.getText();
//	int canCuocCongDan = Integer.valueOf(this.formMain.textField_cccd.getText()+"");
//	int Tinh = this.formMain.JCB_dia_chi.getSelectedIndex();
//	tinhModel tinh = tinhModel.getTinhById(Tinh);
//	
//	boolean gioiTinh  = true;
////	String chonGioiTinh = this.formMain.buttonGroup_gioi_tinh.getSelection()+"";
//	if(this.formMain.JBR_nam.isSelected()) {
//		gioiTinh = true;
//	}else if(this.formMain.JBR_nu.isSelected()){
//		gioiTinh = false;
//	}
//	int soDienThoai = Integer.valueOf(this.formMain.textField_sdt.getText()+"");
//	Date ngaySinh = new Date(this.formMain.textField_ngay_sinh.getText());
//	String loaiDienSuDung = this.formMain.JCB_loai_dien_sd.getSelectedItem()+"";
//	
//	khachHang kh = new khachHang(maKhachHang, tenKhachHang, canCuocCongDan, tinh, gioiTinh, soDienThoai, ngaySinh, loaiDienSuDung);
//	
//
//	this.formMain.themHoacCapNhatKhachHang(kh);
		
		
		
//} catch (Exception e2) {
//	e2.printStackTrace();
//			
//}
	}else if(cm.equals("Sửa")) {
//		this.formMain.hienThiThongTinKhachHangDaChon();
	}else if(cm.equals("Xóa")) {
//		this.formMain.thucHienXoa();
	}
}
}
