package tuan5_HangThucPhamDate;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import tuan3_CDArray.CD;

public class HangThucPham implements Comparable<HangThucPham> {
	private String maHang;
	private String tenHang;
	private double donGia;
	private Date ngaySXuat, ngayHHan;
	
	public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySXuat, Date ngayHHan) {
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

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if( !(tenHang.isEmpty()) )
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

	public Date getNgaySXuat() {
		return ngaySXuat;
	}

	public void setNgaySXuat(Date ngaySXuat) {
		this.ngaySXuat = ngaySXuat;
	}

	public Date getNgayHHan() {
		return ngayHHan;
	}

	public void setNgayHHan(Date ngayHHan) {
		this.ngayHHan = ngayHHan;
	}
	
	public int dateDifference() {
		return checkKhoangCachDays(ngaySXuat, ngayHHan);
	}
	
	public int checkKhoangCachDays(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 3600 * 24));
	}
	
	@Override
	public int compareTo(HangThucPham obj) {
		if(this.getTenHang().equalsIgnoreCase(obj.getTenHang()))
		{
			Double obj1 = this.getDonGia();
			Double obj2 = obj.getDonGia();
			return obj2.compareTo(obj1);
		}else
			return this.getTenHang().compareToIgnoreCase(obj.getTenHang());
	}
	
	@Override
	public String toString() {
		String str = "";
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String strDonGia = df.format(donGia);
		
		str += String.format("%10s%-15s%25s    %-15s%-15s", getMaHang(), " "+getTenHang(), strDonGia, 
				sdf.format(ngaySXuat), "  "+sdf.format(ngayHHan));
		return str;
	}



}









