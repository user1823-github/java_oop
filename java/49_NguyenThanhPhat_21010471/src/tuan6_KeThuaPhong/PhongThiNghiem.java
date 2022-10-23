package tuan6_KeThuaPhong;

public class PhongThiNghiem extends PhongHoc {
	private String chuyenNganh; 
	private int sucChua;
	private boolean coBonRua;
	
	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh,
			int sucChua, boolean coBonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.coBonRua = coBonRua;
	}

	public PhongThiNghiem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isCoBonRua() {
		return coBonRua;
	}

	public void setCoBonRua(boolean coBonRua) {
		this.coBonRua = coBonRua;
	}

	@Override
	boolean datChuan() {
		return isCoBonRua() && duAnhSang() ? true : false;
	}

//	@Override
//	public String toString() {
//		return "PhongThiNghiem [chuyenNganh=" + chuyenNganh + ", sucChua=" + sucChua + ", coBonRua=" + coBonRua
//				+ ", maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich=" + dienTich + ", soBongDen=" + soBongDen
//				+ "]";
//	}
	@Override
	public String toString() {
		String str = "";
		str += String.format("%-20s%10d  %-10b", "      "+chuyenNganh, sucChua, coBonRua);
		return super.toString() + str;
	}
	
}



