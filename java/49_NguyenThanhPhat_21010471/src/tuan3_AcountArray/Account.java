package tuan3_AcountArray;

import java.text.NumberFormat;
import java.util.Locale;

public class Account implements Comparable<Account>{
	private long soTaiKhoan;
	private String tenTK;
	private double tienTK;
	// hằng số viết hoa
	final double LAISUAT = 0.035;
	final double PHIRUT = 1000;
	
	// Constructor
	public Account(long soTaiKhoan, String tenTK, double tienTK) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.tenTK = tenTK;
		this.tienTK = tienTK;
	}
	
	public Account() {
		super();
		this.soTaiKhoan = 999999;
		this.tenTK = "chưa xác định";
		this.tienTK = 50000;
	}
	
	public Account(long soTaiKhoan, double tienTK) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.tienTK = tienTK;
	}
	
	// Getter, Setter
	public long getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(long soTaiKhoan) {
		if(soTaiKhoan > 0)
			this.soTaiKhoan = soTaiKhoan;
		else
			this.soTaiKhoan = 111;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		if(tenTK != "")
			this.tenTK = tenTK;
		else
			this.tenTK = "chưa xác định";
	}

	public double getTienTK() {
		return tienTK;
	}

	public void setTienTK(double tienTK) {
		if(tienTK > 0)
			this.tienTK = tienTK;
		else
			this.tienTK = 50000;
	}
	
	// Nạp
	public boolean napTien(double tienNapVao) {
		if(tienNapVao > 0)
		{
			this.tienTK += tienNapVao;
			return true;
		}
		else
			return false;
	}
	
	// Rút
	public boolean rutTien(double tienRutRa) {
		if(this.tienTK > 50000 && tienRutRa > 0)
		{
			if(this.tienTK - tienRutRa - PHIRUT >= 50000)
			{
				this.tienTK -=  (tienRutRa + PHIRUT);
				return true;
			}
		}
		return false;
	}
	
	// Chuyển tiền
	public boolean chuyenTien(Account taiKhoanNhan, double soTienChuyen) {
		if(soTienChuyen > 0)
		{
			if(this.tienTK - soTienChuyen - PHIRUT >= 50000)
			{
				this.rutTien(soTienChuyen);
				taiKhoanNhan.napTien(soTienChuyen);
				return true;
			}
		}
		return false;
	}
	
	// Đáo hạn
	public boolean daoHan() {
		if(this.tienTK > 0)
		{
			this.tienTK += this.getTienTK() * LAISUAT;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		Locale myLocale = new Locale("vi", "VN");
		NumberFormat myNumber = NumberFormat.getCurrencyInstance(myLocale);
		String str = myNumber.format(getTienTK());
		String strGiaTri = String.format("%15d%-35s%15s", getSoTaiKhoan(), " "+getTenTK(), str);
		return strGiaTri;
	}

	@Override
	public int compareTo(Account obj) {
		// TODO Auto-generated method stub
		if(tenTK.equalsIgnoreCase(obj.tenTK))
		{
			
			// Cách thầy Thắng
			/*
			 * 	
			 * 	Double obj1 = null, obj2 = null;
				obj1 = this.getTienTK();
				obj2 = obj.getTienTK();
				return obj1.compareTo(obj2);
			 * */
			// Cách thầy Đồng
			if(tienTK > obj.tienTK)
				return 1;
			else
				if(tienTK < obj.tienTK)
						return -1;
				else
					return 0;
				
		}else
			return tenTK.compareToIgnoreCase(obj.tenTK);
	}

}













