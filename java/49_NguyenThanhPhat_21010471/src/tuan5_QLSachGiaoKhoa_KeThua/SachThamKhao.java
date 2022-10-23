package tuan5_QLSachGiaoKhoa_KeThua;

import java.util.Date;

public class SachThamKhao extends Sach {
	private double thue;

	// Constructor
	public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		str += String.format("", null);
		return super.toString() + str;
	}

	
	
}
