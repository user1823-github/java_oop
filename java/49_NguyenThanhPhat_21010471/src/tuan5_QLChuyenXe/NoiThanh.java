package tuan5_QLChuyenXe;

import java.text.DecimalFormat;

public class NoiThanh extends ChuyenXe{
	private int soTuyen;
	private int soKmDiDuoc;
	
	public NoiThanh(String maChuyen, String tenTaiXe, int soXe, double doanhThu, int soTuyen, int soKmDiDuoc) {
		super(maChuyen, tenTaiXe, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKmDiDuoc = soKmDiDuoc;
	}
	
	public NoiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoiThanh(String maChuyen, String tenTaiXe, int soXe, double doanhThu) {
		super(maChuyen, tenTaiXe, soXe, doanhThu);
		// TODO Auto-generated constructor stub
	}

	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public int getSoKmDiDuoc() {
		return soKmDiDuoc;
	}

	public void setSoKmDiDuoc(int soKmDiDuoc) {
		this.soKmDiDuoc = soKmDiDuoc;
	}

	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.km");
		String strNoiThanh = "", kmDiDuoc = "";
		
		kmDiDuoc += df.format(soKmDiDuoc);
		strNoiThanh += String.format("%15d%18s", soTuyen, kmDiDuoc);
		return super.toString() + strNoiThanh;
	}
	
	
}
















