package tuan5_HangThucPhamDate;

public class DanhSachHangThucPham {
	public int soLuongThuc;
	public int soLuongThucCuaTemp = 0;
	private HangThucPham ds[];
	
	public DanhSachHangThucPham(int soLuongThuc) {
		ds = new HangThucPham[soLuongThuc];
	}
	
	public void tangSize() {
		HangThucPham temp[] = new HangThucPham[ds.length * 2];
		for (int i = 0; i < ds.length; i++) {
			temp[i] = ds[i];
		}
		ds = temp;
	}
	
	public void themHang(HangThucPham htpThem) throws Exception {
		if(soLuongThuc == ds.length)
			tangSize();
		
		int vt = timKiem(htpThem.getMaHang());
		
		if(vt == -1)
		{
			ds[soLuongThuc] = htpThem;
			soLuongThuc++;
		}
		else
			throw new Exception("Trùng mã hàng!");
	}
	
	public void xoaHang(HangThucPham htpXoa) {
		int vt = timKiem(htpXoa.getMaHang());
		for (int i = vt; i < soLuongThuc; i++) {
			if(vt != -1)
				ds[i] = ds[i+1];
		}
		soLuongThuc--;
	}
	
	public void suaHang(HangThucPham htpSua) throws Exception {
		int vt = timKiem(htpSua.getMaHang());
		
		if(vt != -1)
			ds[vt] = htpSua;
		else
			throw new Exception("Không tìm thấy hàng để sửa");
	}
	
	public int timKiem(String htpTim) {
		for (int i = 0; i < soLuongThuc; i++) {
			if(ds[i].getMaHang().equals(htpTim))
				return i;
		}
		return -1;
	}
	// Danh sách sắp hết hạn
	public HangThucPham[] getDSSapHetHan(int soNgay) {
		HangThucPham temp[] = new HangThucPham[soLuongThuc];
		
		for (int i = 0; i < soLuongThuc; i++) {
			if(ds[i].dateDifference() <= soNgay)
			{
				temp[soLuongThucCuaTemp] = ds[i];
				soLuongThucCuaTemp++;				
			}
		}
		return temp;
	}
	// swap hàng thực phẩm
	public void swapHangTP(HangThucPham ds[], int i, int j, HangThucPham temp) {
		temp = ds[i];
		ds[i] = ds[j];
		ds[j] = temp;
	}
	// sort tiền giảm dần
	public void sortTienGiamDan() {
		HangThucPham temp = null;
		for (int i = 0; i < soLuongThuc - 1; i++) {
			for (int j = i+1; j < soLuongThuc; j++) {
				if(ds[i].getDonGia() < ds[j].getDonGia())
					swapHangTP(ds, i, j, temp); 
			}
		}
	}
	// sort tên tăng dần
	public void sortTenTangDan() {
		HangThucPham temp = null;
		for (int i = 0; i < soLuongThuc - 1; i++) {
			for (int j = i+1; j < soLuongThuc; j++) {
				if(ds[i].getTenHang().compareTo(ds[j].getTenHang()) > 0)
					swapHangTP(ds, i, j, temp);
			}
		}
	}
	
	public HangThucPham[] getDSHangTP() {
		return ds;
	}
	
}













