package tuan3_CDArray;

public class CDList {
	private CD ds[];
	public int soLuongThuc = 0 ;
	
	public CDList (int soLuongThuc) {
		this.ds = new CD[soLuongThuc];
	}

	public void tangKichThuoc() {
		CD temp[] = new CD[ds.length * 2];
		
		for (int i = 0; i < ds.length; i++) {
			temp[i] = ds[i];
		}
		
		ds = temp;
	}
	
	public void themCD(CD cdThem) throws Exception {
		if(ds.length == soLuongThuc)
			tangKichThuoc();
		
		// Không tìm thấy
		if(timKiemCD(cdThem.getMaCD()) == -1)
		{
			ds[soLuongThuc] = cdThem;
			soLuongThuc++;
		}else
		{
			throw new Exception("Trùng mã CD!");
		}
	}
	
	public void suaCD(CD cdSua) throws Exception {
		int vt = timKiemCD(cdSua.getMaCD());
		if(vt != -1)
			ds[vt] = cdSua;
		else
			throw new Exception("Không tìm thấy CD để sửa!");
	}
	
	public void xoaCD(CD cdXoa) {
		int vt = timKiemCD(cdXoa.getMaCD());
		for (int i = vt; i < soLuongThuc; i++) {
			ds[i] = ds[i+1];
		}
		soLuongThuc--;
	}
	
	public double getMonney() {
		double tien = 0;
		for (int i = 0; i < soLuongThuc; i++) {
			tien += ds[i].getGiaThanh();
		}
		return tien;
	}

	// Tìm kiếm CD
	public int timKiemCD(int maCDCanTim) {
		for (int i = 0; i < soLuongThuc; i++) {
			if(maCDCanTim == ds[i].getMaCD())
				return i;
		}
		
		return -1;
	}
	
	// Số lượng CD trong List
	public int soLuongCDTrongList() {
		int countCD = 0;
		for (int i = 0; i < soLuongThuc; i++) {
			if(timKiemCD(ds[i].getMaCD()) != 1)
				countCD++;
		}
		return countCD;
	}
	
	public void swapCD(CD ds[], int i, int j, CD temp) {
		temp = ds[i];
		ds[i] = ds[j];
		ds[j] = temp;
	}
	
	// sort giá CD: giảm dần
	public void sortTheoGiaCD() {
		CD temp = null;
		for (int i = 0; i < soLuongThuc - 1; i++) {
			for (int j = i + 1; j < soLuongThuc; j++) {
				if(ds[i].getGiaThanh() < ds[j].getGiaThanh())
					swapCD(ds, i, j, temp);
			}
		}
	}
	
	// sort tựa CD: tăng dần
	public void sortTheoTuaCD() {
		CD temp = null;
		for (int i = 0; i < soLuongThuc - 1; i++) {
			for (int j = i + 1; j < soLuongThuc; j++) {
				if(ds[i].getTuaCD().compareTo(ds[j].getTuaCD()) > 0)
					swapCD(ds, i, j, temp);
			}
		}
	}
	
	
	public CD[] getDsCD() {
		return ds;
	}
	
}

















