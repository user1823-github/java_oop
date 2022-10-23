package tuan4_SinhVienArray;

public class SinhVien {
	private String maSV, hoTen;

	public SinhVien(String maSV, String hoTen) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
	}

	public SinhVien() {
		super();
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	

	
	@Override
	public String toString() {
		String str;
		str = String.format("%12s%-25s", getMaSV(), " | "+getHoTen());
		return str;
	}
}









