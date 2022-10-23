package tuan5_QLSachGiaoKhoa_KeThua;

import java.util.Date;
import java.util.Objects;

public class Sach {
	protected String maSach;
	protected Date ngayNhap;
	protected double donGia;
	protected int soLuong;
	protected String nhaXuatBan;
	
	// Constructor
	public Sach(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super();
		this.maSach = maSach;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	public Sach() {
		super();
	}

	public String getMaSach() {
		return maSach;
	}
	
	// Mã sách không được rỗng
	public void setMaSach(String maSach) throws Exception {
		if(maSach == "")
			throw new Exception("Mã sách không được rỗng");
		else
			this.maSach = maSach;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	
	// Hasd Code: Kiểm tra có trùng obj
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		str += String.format("", null);
		return super.toString();
	}
	
	
	
}























