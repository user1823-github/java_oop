package tuan4_KhachHangSoTietKiemArray;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class SoTietKiem {
	private String maSo;
	private LocalDate ngayMbSo;
	private double soTienGoi;
	private int kyHan;
	private float laiSuat;
	
	public SoTietKiem(String maSo, LocalDate ngayMbSo, double soTienGoi, int kyHan, float laiSuat) {
		super();
		this.maSo = maSo;
		this.ngayMbSo = ngayMbSo;
		this.soTienGoi = soTienGoi;
		this.kyHan = kyHan;
		this.laiSuat = laiSuat;
	}
	
	public SoTietKiem() {
		super();
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public LocalDate getNgayMbSo() {
		return ngayMbSo;
	}

	public void setNgayMbSo(LocalDate ngayMbSo) {
		this.ngayMbSo = ngayMbSo;
	}

	public double getSoTienGoi() {
		return soTienGoi;
	}

	public void setSoTienGoi(double soTienGoi) {
		this.soTienGoi = soTienGoi;
	}

	public int getKyHan() {
		return kyHan;
	}

	public void setKyHan(int kyHan) {
		this.kyHan = kyHan;
	}

	public float getLaiSuat() {
		return laiSuat;
	}

	public void setLaiSuat(float laiSuat) {
		this.laiSuat = laiSuat;
	} 
	
	// Số tháng gởi
	public int soThangGoiThuc() {
		Period age   = Period.between(ngayMbSo, LocalDate.now());
		
		// số năm chênh lệch giữa 2 ngày
		int dt_nam   = age.getYears();
		// số tháng chênh lệch giữa 2 ngày
		int dt_thang = age.getMonths();
		
		int soThangGoi = dt_nam * 12 + dt_thang;
		if(soThangGoi % kyHan == 0)
			return soThangGoi;
		else
			return soThangGoi / kyHan * kyHan;
	}
	
	// Tiền lãi
	public double tienLai() {
		double tienLai;
		tienLai = soTienGoi * laiSuat / 12 * soThangGoiThuc();
		return tienLai;
	}
	
	@Override
	public String toString() {
		String strGiaTri = "";
		
		Locale myLocale = new Locale("vi", "VN");
		NumberFormat myNumber = NumberFormat.getCurrencyInstance(myLocale);
		
		String strTienGoi = myNumber.format(soTienGoi);
		String strTienLai = myNumber.format(tienLai());
//		str += String.format("%12s%-15s%27s%15s%15s%20s%25s", "Mã số", "\t Ngày mở bán", "Kỳ hạn", "ST tính lãi", "Lãi suất", "Số tiền", "Tiền lãi");
		
		strGiaTri += String.format("%12s%-15s%27d%15d%15.3f%20s%25s", maSo, "    "+ngayMbSo, kyHan, soThangGoiThuc(), laiSuat, strTienGoi, strTienLai);
		return strGiaTri;
	}
	
}












