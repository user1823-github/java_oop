package tuan4_HangThucPhamGregorianCalendar;

import tuan3_AcountArray.Account;
import tuan4_SinhVienArray.SinhVien;

public class DanhSachHangThucPham {
	public int soLuongThuc;
	private HangThucPham[] ds;
	
	public DanhSachHangThucPham(int soLuongThuc) {
		this.ds = new HangThucPham[soLuongThuc];
	}
	
	public int timKiem(String maHang) {
		for (int i = 0; i < soLuongThuc; i++) {
			if(ds[i].getMaHang().equals(maHang))
				return i;
		}
		return -1;
	}
	
	public void tangKichThuoc() {
		HangThucPham temp[] = new HangThucPham[ds.length * 2];
		for (int i = 0; i < ds.length; i++) 
		{
			temp[i] = ds[i];
		}
		ds = temp;
	}
	
	public void themHang(HangThucPham hangTPThem) throws Exception {
		if(ds.length == soLuongThuc)
			tangKichThuoc();
		int vt = timKiem(hangTPThem.getMaHang());
		if(timKiem(hangTPThem.getMaHang()) == -1)
		{
			ds[soLuongThuc] = hangTPThem;
			soLuongThuc++;
		}else
			throw new Exception("Trùng mã hàng!");
	}
	
	public HangThucPham[] getDSHangThucPham() {
		return ds;
	}
}













