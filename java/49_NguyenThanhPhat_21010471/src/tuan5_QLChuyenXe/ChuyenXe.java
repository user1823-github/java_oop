package tuan5_QLChuyenXe;

import java.text.DecimalFormat;
import java.util.Objects;

public class ChuyenXe {
	protected String maChuyen, tenTaiXe;
	protected int soXe;
	protected double doanhThu;
	
	public ChuyenXe(String maChuyen, String tenTaiXe, int soXe, double doanhThu) {
		super();
		this.maChuyen = maChuyen;
		this.tenTaiXe = tenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}
	public ChuyenXe() {
		super();
	}

	public String getMaChuyen() {
		return maChuyen;
	}

	public void setMaChuyen(String maChuyen) {
		this.maChuyen = maChuyen;
	}

	public String getTenTaiXe() {
		return tenTaiXe;
	}

	public void setTenTaiXe(String tenTaiXe) {
		this.tenTaiXe = tenTaiXe;
	}

	public int getsoXe() {
		return soXe;
	}

	public void setsoXe(int soXe) {
		this.soXe = soXe;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
	
	// Hash Code, Equal
	@Override
	public int hashCode() {
		return Objects.hash(maChuyen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return Objects.equals(maChuyen, other.maChuyen);
	}

	@Override
	public String toString() {
		String str = "", doanhThuStr = "";
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		
		doanhThuStr += df.format(doanhThu);
		str += String.format("%17s %-25s%8d %18s", maChuyen, tenTaiXe, 
			   soXe, doanhThuStr);
		return str;
	}
	
}
















