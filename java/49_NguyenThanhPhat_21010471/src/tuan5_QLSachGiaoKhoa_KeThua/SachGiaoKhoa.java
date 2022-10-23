package tuan5_QLSachGiaoKhoa_KeThua;

import java.util.Date;

public class SachGiaoKhoa extends Sach {
	private boolean tinhTrang;
	
	// Constructor
	public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan,
			boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	public SachGiaoKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
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
		// TODO Auto-generated method stub
		String str = "";
		str = String.format("", null);
		return super.toString() + str;
	}
	
	
	
}










