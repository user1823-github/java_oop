package tuan6_KeThuaPhong;

public class PhongMayTinh extends PhongHoc {
	private int soLuongMayTinh;
	
	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soLuongMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soLuongMayTinh = soLuongMayTinh;
	}
	
	public PhongMayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}
	
	public int getSoLuongMayTinh() {
		return soLuongMayTinh;
	}
	public void setSoLuongMayTinh(int soLuongMayTinh) {
		this.soLuongMayTinh = soLuongMayTinh;
	}
	
	// trung bình 1.5 m^2 đặt 1 máy
	public boolean datChuanPhongMayTinh() {
		return getDienTich() / soLuongMayTinh <= 1.5 ? true : false;
	}

	@Override
	boolean datChuan() {
		return datChuanPhongMayTinh() && duAnhSang() ? true : false;
	}

//	@Override
//	public String toString() {
//		return "PhongMayTinh [soLuongMayTinh=" + soLuongMayTinh + ", maPhong=" + maPhong + ", dayNha=" + dayNha
//				+ ", dienTich=" + dienTich + ", soBongDen=" + soBongDen + "]";
//	}
	
	@Override
	public String toString() {
		String str = "";
		str += String.format("%10d", soLuongMayTinh);
		return super.toString() + str;
	}
	
}
