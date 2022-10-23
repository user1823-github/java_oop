package tuan6_KeThuaPhong;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}

	public PhongLyThuyet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	public boolean isCoMayChieu() {
		return coMayChieu;
	}

	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}
	
	
	@Override
	boolean datChuan() {
		return isCoMayChieu() && duAnhSang() ? true : false;
	}
	
//	@Override
//	public String toString() {
//		return "PhongLyThuyet [coMayChieu=" + coMayChieu + ", maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich="
//				+ dienTich + ", soBongDen=" + soBongDen + "]";
//	}

	@Override
	public String toString() {
		String str = "";
		str += String.format("      %-10b", coMayChieu);
		return super.toString() + str;
	}
	
	
}
