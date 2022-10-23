package tuan5_QLChuyenXe;

import java.text.DecimalFormat;

public class NgoaiThanh extends ChuyenXe{
	private String noiDen;
	private int soNgayDiDuoc;
	public NgoaiThanh(String maChuyen, String tenTaiXe, int soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
		super(maChuyen, tenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	public NgoaiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NgoaiThanh(String maChuyen, String tenTaiXe, int soXe, double doanhThu) {
		super(maChuyen, tenTaiXe, soXe, doanhThu);
		// TODO Auto-generated constructor stub
	}
	public String getNoiDen() {
		return noiDen;
	}
	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}
	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}
	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	@Override
	public String toString() {
		String strNgoaiThanh = "";
		
		strNgoaiThanh += String.format("%-30s%8d", "       "+noiDen, soNgayDiDuoc);
		return super.toString() + strNgoaiThanh;
	}
}





















