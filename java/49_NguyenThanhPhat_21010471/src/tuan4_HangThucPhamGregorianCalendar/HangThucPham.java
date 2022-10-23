package tuan4_HangThucPhamGregorianCalendar;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Locale;

public class HangThucPham {
	private String maHang;
	private String tenHang;
	private double donGia;
	private GregorianCalendar ngaySXuat, ngayHHan;
	
	public HangThucPham(String maHang, String tenHang, double donGia, GregorianCalendar ngaySXuat,
			GregorianCalendar ngayHHan) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySXuat = ngaySXuat;
		this.ngayHHan = ngayHHan;
	}
	
	public HangThucPham() {
		super();
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) throws Exception {
		if(!maHang.trim().equals(""))
			this.maHang = maHang;
		else
			throw new Exception("Lỗi: Mã hàng rỗng");
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if(tenHang != null)
			this.tenHang = tenHang;
		else
			this.tenHang = "xxx";
	}
	
	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public GregorianCalendar getNgaySXuat() {
		return ngaySXuat;
	}

	public void setNgaySXuat(GregorianCalendar ngaySXuat) {
		this.ngaySXuat = ngaySXuat;
	}

	public GregorianCalendar getNgayHHan() {
		return ngayHHan;
	}

	public void setNgayHHan(GregorianCalendar ngayHHan) {
		this.ngayHHan = ngayHHan;
	}
	
	public boolean hetHan() {
		return ngayHHan.before(ngaySXuat) ? true : false;
	}
	
	
	@Override
	public String toString() {
		String str = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale myLocale = new Locale("vi", "VN");
		NumberFormat myFormat = NumberFormat.getCurrencyInstance(myLocale);
		
		String strDonGia = myFormat.format(donGia);
		
		str += String.format("%10s%-15s%25s    %-15s%-15s", getMaHang(), " "+getTenHang(), strDonGia, 
				sdf.format(ngaySXuat.getTime()), "  "+sdf.format(ngayHHan.getTime()));
		return str;
	}

	
//	ngaySXuat.getTime().getYear() + 1900
}
