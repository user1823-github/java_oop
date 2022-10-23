package tuan1_QuanLyDangKyXe;

public class Vehicle {
	private String tenChuXe;
	private String loaiXe;
	private int dungTich;
	private double triGia;
	
	// Constructor
	public Vehicle(String tenChuXe, String loaiXe, int dungTich, double triGia) {
		super();
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}
	
	public String getTenChuXe() {
		return tenChuXe;
	}
	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public int getDungTich() {
		return dungTich;
	}
	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}
	public double getTriGia() {
		return triGia;
	}
	public void setTriGia(double triGia) {
		this.triGia = triGia;
	}
	
	public double thuePhaiNop() {
		double thueNop = 1;
		thueNop *= triGia * (3.0/100);
		return thueNop;
	}

	@Override
	public String toString() {
		String str = "";
		if(getTenChuXe().length() < 9)
			str += String.format("%s\t\t\t\t%-25s%17d%22.2f%22.2f", getTenChuXe(), getLoaiXe(), getDungTich(), getTriGia(), thuePhaiNop());
		else if(getTenChuXe().length() < 17)
			str += String.format("%s\t\t\t%-25s%17d%22.2f%22.2f", getTenChuXe(), getLoaiXe(), getDungTich(), getTriGia(), thuePhaiNop());
		else 
			str += String.format("%s\t\t%-25s%17d%22.2f%22.2f", getTenChuXe(), getLoaiXe(), getDungTich(), getTriGia(), thuePhaiNop());	
		return str;
	}
	

}




