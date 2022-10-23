package tuan8_HangHoa;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class HangHoa {
	protected String maHang, tenHang;
	protected int slTon;
	protected double donGia;
	public HangHoa(String maHang, String tenHang, int slTon, double donGia) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.slTon = slTon;
		this.donGia = donGia;
	}
	public HangHoa() {
		super();
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) throws Exception {
		if(tenHang.isEmpty() == false)
			this.tenHang = tenHang;
		throw new Exception("Tên hành không được rỗng");
	}
	public int getSlTon() {
		return slTon;
	}
	public void setSlTon(int slTon) throws Exception {
		if(slTon >= 0)
			this.slTon = slTon;
		throw new Exception("Số lượng tồn >= 0");
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) throws Exception {
		if(donGia >= 0)
			this.donGia = donGia;
		throw new Exception("Đơn giá >= 0");
	}
	
	public abstract void vat();
	
	@Override
	public String toString() {
		DecimalFormat dcf = new DecimalFormat("#,##0.00VNĐ");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return "HangHoa [maHang=" + maHang + ", tenHang=" + tenHang + ", slTon=" + slTon + ", donGia=" + donGia + "]";
	}
	
	
}
















