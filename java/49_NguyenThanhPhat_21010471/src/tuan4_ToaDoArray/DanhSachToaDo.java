package tuan4_ToaDoArray;

import java.util.Iterator;

public class DanhSachToaDo {
	private ToaDo[] dsToaDo;
	public int soLuongThuc;
	
	public DanhSachToaDo(int soLuongThuc) {
		dsToaDo = new ToaDo[soLuongThuc];
	}
	
	public int timKiem(String ten) {
		for (int i = 0; i < soLuongThuc - 1; i++) {
			if(dsToaDo[i].getTen().equals(ten))
				return i;
		}
		return -1;
	}
	
	public void tangSize() {
		ToaDo[] temp = new ToaDo[dsToaDo.length * 2];
		
		for (int i = 0; i < dsToaDo.length; i++) {
			temp[i] = dsToaDo[i];
		}
		
		dsToaDo = temp;
	}
	
	public void themToaDo(ToaDo toaDoThem) {
		if(dsToaDo.length == soLuongThuc)
			tangSize();
		if(timKiem(toaDoThem.getTen()) == -1)
		{
			dsToaDo[soLuongThuc] = toaDoThem;
		}
		soLuongThuc++;
	}
	
	public void suaToaDo(ToaDo toaDoSua) throws Exception {
		int vt = timKiem(toaDoSua.getTen());
		if(vt != -1)
			dsToaDo[vt] = toaDoSua;
		throw new Exception("Không tìm thấy toạ độ để sửa");
	}
	
	public void xoaToaDo(ToaDo toaDoXoa) {
		int vt = timKiem(toaDoXoa.getTen());
		for (int i = vt; i < soLuongThuc; i++) {
			dsToaDo[i] = dsToaDo[i+1];
		}
		soLuongThuc--;
	}
	
	public void swapToaDo(ToaDo ds[], int i, int j, ToaDo temp) {
		temp = ds[i];
		ds[i] = ds[j];
		ds[j] = temp;
	}
	
	// Sort tên tăng dần
	public void sortTheoTenToaDo() {
		ToaDo temp = null;
		for (int i = 0; i < soLuongThuc - 1; i++) {
			for (int j = i +1; j < soLuongThuc; j++) {
				if(dsToaDo[i].getTen().compareTo(dsToaDo[j].getTen()) > 0)
					swapToaDo(dsToaDo, i, j, temp);
			}
		}
	}
	
	public ToaDo[] getDSToaDo() {
		return dsToaDo;
	}
	
}















