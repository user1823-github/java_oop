package tuan6_KeThuaPhong;

import java.util.Objects;

public abstract class PhongHoc {
	protected String maPhong, dayNha;
	protected double dienTich;
	protected int soBongDen;
	
	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}
	
	public PhongHoc() {
		super();
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public int getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}
	
	public boolean duAnhSang() {
		return dienTich / soBongDen <= 10 ? true : false;
	}
	
	abstract boolean datChuan();
	
	// Trùng mã Phòng
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
//	@Override
//	public String toString() {
//		return "PhongHoc [maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich=" + dienTich + ", soBongDen="
//				+ soBongDen + "]";
//	}
	@Override
	public String toString() {
		String str = "";
		str += String.format("%-10s%-15s%10f%15d", "  " +maPhong, "  "+dayNha, dienTich, soBongDen);
		return str;
	}
	
}
