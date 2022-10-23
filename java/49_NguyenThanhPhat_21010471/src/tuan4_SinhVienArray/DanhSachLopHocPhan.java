package tuan4_SinhVienArray;


public class DanhSachLopHocPhan {
	private LopHocPhan dsLHP[];
	public int soLuongThuc = 0;
	
	
	public DanhSachLopHocPhan(int soLuong) {
		dsLHP = new LopHocPhan[soLuong];
	}
	
	public int timKiem(String maLHP) {
		for (int i = 0; i < soLuongThuc; i++) {
			if(dsLHP[i].getMaLHP().equals(maLHP))
				return i;
		}
		return -1;
	}
	
	public void tangKichThuoc() {
		LopHocPhan temp[] = new LopHocPhan[dsLHP.length * 2];
		for (int i = 0; i < dsLHP.length; i++) 
		{
			temp[i] = dsLHP[i];
		}
		dsLHP = temp;
	}
	
	public void themLHP(LopHocPhan lhpThem) throws Exception {
		if(dsLHP.length == soLuongThuc)
			tangKichThuoc();
		
		int vt = timKiem(lhpThem.getMaLHP());
		if(vt == -1)
		{
			dsLHP[soLuongThuc] = lhpThem;
			soLuongThuc++;
		}else
			throw new Exception("Trùng mã lớp học phần!");
	}
	
	public void suaLHP(LopHocPhan lhpSua) throws Exception {
		int vt = timKiem(lhpSua.getMaLHP());
		if(vt != -1)
			dsLHP[vt] = lhpSua;
		else
			throw new Exception("Không tìm thấy lớp học phần để sửa!");;
	}
	
	public void xoaLHP(LopHocPhan lhpXoa) {
		int vt = timKiem(lhpXoa.getMaLHP());
		for (int i = vt; i < soLuongThuc; i++) {
			dsLHP[i] = dsLHP[i+1];
		}
		soLuongThuc--;
	}
	
	public String getDSToStringLHP() {
		String str = "";
		for (LopHocPhan lhp : dsLHP) {
			if(lhp != null)
				str += lhp + "\n" + "=> Danh sách sinh viên:\n" +lhp.getDSSV() + "\n";
		}
		
		return str;
	}
	
	public LopHocPhan[] getDanhSachLHP() {
		return dsLHP;
	}

}















