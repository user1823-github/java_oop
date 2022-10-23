package tuan8_HangHoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachHangHoa {
	private ArrayList<HangHoa> ds;
	
	public DanhSachHangHoa() {
		ds = new ArrayList<HangHoa>();
	}
	
	public HangHoa timKiemObj(String maHang) {
		for (HangHoa hh : ds) {
			if(hh.getMaHang().equalsIgnoreCase(maHang))
				return hh;
		}
		return null;
	}
	
	public int viTri(String maHang) {
		HangHoa hh = timKiemObj(maHang);

		if(hh != null)
			return ds.indexOf(hh);
		else
			return -1;
	}
	
	public void them(HangHoa hh) throws Exception {
		if(ds.contains(hh) == false)
			ds.add(hh);
		else
			throw new Exception("Mã hàng tồn tại!");
	}
	
	public void sua(HangHoa hh) throws Exception {
		int vt = ds.indexOf(hh);
		if(vt != -1)
			ds.set(vt, hh);
		else
			throw new Exception("Mã hàng không tồn tại để sửa!");
	}
	
	public void xoa(HangHoa hh) throws Exception {
		int vt = ds.indexOf(hh);
		if(vt != -1)
			ds.remove(vt);
		else
			throw new Exception("Mã hàng không tồn tại!");
	}
	
	
	
	public ArrayList<HangHoa> getDS() {
		return ds;
	}
	
	public ArrayList<HangHoa> getDSHangTP() {
		ArrayList<HangHoa> dsHTP = new ArrayList<HangHoa>();
		
		for (HangHoa hh : ds) {
			if(hh instanceof HangThucPham)
				dsHTP.add(hh);
		}
		return dsHTP;
	}
	
	public ArrayList<HangHoa> getDSHangDM() {
		ArrayList<HangHoa> dsHDM = new ArrayList<HangHoa>();
		
		for (HangHoa hh : ds) {
			if(hh instanceof HangDienMay)
				dsHDM.add(hh);
		}
		return dsHDM;
	}
	
	public ArrayList<HangHoa> getDSHangSS() {
		ArrayList<HangHoa> dsHSS = new ArrayList<HangHoa>();
		
		for (HangHoa hh : ds) {
			if(hh instanceof HangSanhSu)
				dsHSS.add(hh);
		}
		return dsHSS;
	}
	
	public void sort() {
		Collections.sort(ds, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				Double d1 = o1.getDonGia();
				double d2 = o2.getDonGia();
				return d1.compareTo(d2);
			}
		});
	}
	
}




















