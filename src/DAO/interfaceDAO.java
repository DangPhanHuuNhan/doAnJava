package DAO;

import java.util.ArrayList;

import model.khachHang;

public interface interfaceDAO {
public int them();
public int xoa(int maKhachHang);
public int capNhat();
public ArrayList hienThiTatCa();
public khachHang selectById(int maKhachHang);
}
