package tuan2_Account;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
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
	}

	public Account(long soTaiKhoan, String tenTK) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.tenTK = tenTK;
		this.tienTK = 50;
	}

	public long getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(long soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public double getTienTK() {
		return tienTK;
	}

	public void setTienTK(long tienTK) {
		this.tienTK = tienTK;
	}
	
	// Nạp
	public boolean napTien(long tienNapVao) {
		if(tienNapVao > 0)
		{
			this.tienTK += tienNapVao;
			return true;
		}
		else
			return false;
	}
	
	// Rút
	public boolean rutTien(long tienRutRa) {
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
	public boolean chuyenTien(Account taiKhoanNhan, long soTienChuyen) {
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

}













