package tuan4_KhachHangSoTietKiemArray;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class KhachHang {
	private String maKH, hoTenKH;
	private DanhSachSoTietKiem ds;
	private int slSoHienCo;
	
	public KhachHang(String maKH, String hoTenKH, DanhSachSoTietKiem ds, int slSoHienCo) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.ds = ds;
		this.slSoHienCo = slSoHienCo;
	}
	
	public String getMaKH() {
		return maKH;
	}

	//	public void setMaKH(String maKH) {
//		this.maKH = maKH;
//	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	
	// Setter hoTen;
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}

	public int getSlSoHienCo() {
		return slSoHienCo;
	}
	
	public void setSlSoHienCo(int slSoHienCo) {
		this.slSoHienCo = slSoHienCo;
	}
	
	public String getDSSoTK() {
		String str = "";
		
		Locale myLocale = new Locale("vi", "VN");
		NumberFormat myNumber = NumberFormat.getCurrencyInstance(myLocale);
		String strTienGoi = "", strTienLai = "";
		
		for (SoTietKiem stk : ds.getDSSoTietKiem()) {
			if(stk != null)
				System.out.print("\n" + stk.toString());
		}
		return str;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += String.format("%20s%25s", getMaKH(), getHoTenKH());
		return str;
	}
	
}


















