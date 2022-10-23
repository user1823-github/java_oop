package tuan6_KeThuaBook;

import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
	private boolean tinhTrang;

	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB,
			boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXB);
		this.tinhTrang = tinhTrang;
	}

	public SachGiaoKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXB);
		// TODO Auto-generated constructor stub
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		String str = String.format("   %-10b", tinhTrang);
		return super.toString() + str;
	}

	@Override
	double getThanhTien() {
		// TODO Auto-generated method stub
		if(tinhTrang == true)
			return soLuong * donGia;
		return soLuong * donGia * (double) 50/100;
	}
	
	
}















