package tuan4_SinhVienArray;

public class LopHocPhan {
	private String maLHP, tenLHP, tenGV, thongTinLopHoc;
	private SinhVien[] dsSinhVien;
	
	public LopHocPhan(String maLHP, String tenLHP, String tenGV, String thongTinLopHoc, SinhVien[] dsSinhVien) {
		super();
		this.maLHP = maLHP;
		this.tenLHP = tenLHP;
		this.tenGV = tenGV;
		this.thongTinLopHoc = thongTinLopHoc;
		this.dsSinhVien = dsSinhVien;
	}
	
	public String getMaLHP() {
		return maLHP;
	}
	public void setMaLHP(String maLHP) {
		this.maLHP = maLHP;
	}
	public String getTenLHP() {
		return tenLHP;
	}
	public void setTenLHP(String tenLHP) {
		this.tenLHP = tenLHP;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public String getThongTinLopHoc() {
		return thongTinLopHoc;
	}
	public void setThongTinLopHoc(String thongTinLopHoc) {
		this.thongTinLopHoc = thongTinLopHoc;
	}
	
	public int getSoLuongSV() {
		int count = 0;
		for (SinhVien sv : dsSinhVien) {
			if(sv != null)
				count++;
		}
		return count;
	}
	
	public String getDSSV() {
		String str = "";
		
		for (SinhVien sv : dsSinhVien) {
			if(sv != null)
				str += sv + "\n";
		}
		return str;
	}
	
	public void swapSV(SinhVien ds[], int i, int j, SinhVien temp) {
		temp = ds[i];
		ds[i] = ds[j];
		ds[j] = temp;
	}
	
	public void sortTheoTenSV() {
		SinhVien temp = null;
		for (int i = 0; i < getSoLuongSV() - 1; i++) {
			for (int j = i + 1; j < getSoLuongSV(); j++) {
				if(dsSinhVien[i].getHoTen().compareTo(dsSinhVien[j].getHoTen()) > 0)
					swapSV(dsSinhVien, i, j, temp);
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str;
		str = String.format("%-20s%-25s%-30s%-35s\n", "        "+getMaLHP(), getTenLHP(), getTenGV(), getThongTinLopHoc());
		return str;
	}
	
}













