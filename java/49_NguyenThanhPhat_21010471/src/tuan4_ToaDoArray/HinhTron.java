package tuan4_ToaDoArray;

public class HinhTron {
	private double banKinh;
	private DanhSachToaDo ds;
	public HinhTron(double banKinh, DanhSachToaDo ds) {
		super();
		this.banKinh = banKinh;
		this.ds = ds;
	}
	
	public HinhTron() {
		super();
	}

	public double getBanKinh() {
		return banKinh;
	}
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	
	public double chuVi() {
		double cv;
		cv = 2 * Math.PI * getBanKinh();
		return cv;
	}
	
	public double dienTich() {
		double dt;
		dt = Math.PI * (Math.pow(getBanKinh(), 2));
		return dt;
	}
	
	public String dsToaDoForEach() {
		String str = "";
		
		for (ToaDo td : ds.getDSToaDo()) {
			if(td != null)
				System.out.print("\n" + td.toString());
		}
		
		return str;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += String.format("%10.2f%10.2f%10.2f", getBanKinh(), dienTich(), chuVi());
		return str;
	}
	
}

















