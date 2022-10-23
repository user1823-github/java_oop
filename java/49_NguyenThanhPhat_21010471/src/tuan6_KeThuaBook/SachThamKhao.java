package tuan6_KeThuaBook;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class SachThamKhao extends Sach {
	private double thue;

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXB);
		this.thue = thue;
	}

	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXB);
		// TODO Auto-generated constructor stub
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}
	
	@Override
	public String toString() {
		String str = "", thueStr = "";
		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(lc);
		
		thueStr += nf.format(thue);
		
		str = String.format("%10s", thueStr);
		return super.toString() + str;
	}

	@Override
	double getThanhTien() {
		return soLuong * donGia + thue;
	}
}






















