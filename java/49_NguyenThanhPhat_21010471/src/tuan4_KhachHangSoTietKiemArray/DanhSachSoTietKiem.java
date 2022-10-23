package tuan4_KhachHangSoTietKiemArray;

import tuan4_SinhVienArray.SinhVien;

public class DanhSachSoTietKiem {
	private SoTietKiem[] ds;
	public int soLuongThuc;
	
	public DanhSachSoTietKiem(int soLuongThuc) {
		ds = new SoTietKiem[soLuongThuc];
	}

	
	public int timKiem(String maSV) {
		for (int i = 0; i < soLuongThuc - 1; i++) {
			if(ds[i].getMaSo().equals(maSV))
				return i;
		}
		return -1;
	}
	
	public void tangSize() {
		SoTietKiem[] temp = new SoTietKiem[ds.length * 2];
		for (int i = 0; i < ds.length; i++) 
		{
			temp[i] = ds[i];
		}
		ds = temp;
	}
	
	public void themSoTietKiem(SoTietKiem soThem) throws Exception {
		if(ds.length == soLuongThuc)
			tangSize();
		
		int vt = timKiem(soThem.getMaSo());
		if(vt == -1)
		{
			ds[soLuongThuc] = soThem;
			soLuongThuc++;
		}else
			throw new Exception("Trùng mã số của sổ tiết kiệm!");
	}
	
	public SoTietKiem[] getDSSoTietKiem() {
		return ds;
	}
	

	
}
























