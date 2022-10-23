package tuan6_KeThuaPhong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachPhong {
	private ArrayList<PhongHoc> ds;

	public DanhSachPhong() {
		ds = new ArrayList<PhongHoc>();
	}

	public void them(PhongHoc p) throws Exception {
		if(ds.contains(p) == false)
			ds.add(p);
		else
			throw new Exception("Trùng mã phòng!");
	}
	
	public void xoa(PhongHoc p) throws Exception {
		int vt = ds.indexOf(p);
		
		if(vt != -1)
			ds.remove(vt);
		else
			throw new Exception("Không tìm thầy phòng để xoá!");
	}
	
	public void sua(PhongHoc p) throws Exception {
		int vt = ds.indexOf(p);
		
		if(vt != -1)
			ds.set(vt, p);
		else
			throw new Exception("Không tìm thấy phòng để sửa!");
	}
	
	
	// Tìm kiếm Object Phòng
	public PhongHoc timKiemObj(String maPhong) {
		for (PhongHoc p : ds) {
			if(p.getMaPhong().equalsIgnoreCase(maPhong))
				return p;
		}
		return null;
	}
	
	// Tìm kiếm vị trí phòng
	public int viTri(String maPhong) {
		PhongHoc phongTim = timKiemObj(maPhong);
		if(phongTim != null)
			return ds.indexOf(phongTim);
		return -1;
	}
	
	
	// Sort 
	public void sortTangDanTheoDayNha() {
		Collections.sort(ds, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				String nha1 = o1.getDayNha();
				String nha2 = o2.getDayNha();

				return nha1.compareTo(nha2);
			}
		});
	}
	
	public void sortGiamDienTich() {
		Collections.sort(ds, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Double dt1 = o1.getDienTich();
				Double dt2 = o2.getDienTich();
				return dt2.compareTo(dt1);
			}
		});
	}
	
	public void sortTangSoBongDen() {
		Collections.sort(ds, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Integer bong1 = o1.getSoBongDen();
				Integer bong2 = o2.getSoBongDen();
				return bong1.compareTo(bong2);
			}
		});
	}
	
	// Tổng số lượng các phòng
	public int soLuongPhong() {
		return ds.size();
	}
	
	// Danh sách
	public ArrayList<PhongHoc> getDSPhongCo60May() {
		ArrayList<PhongHoc> dsPhongCo60May = new ArrayList<PhongHoc>();
		for (PhongHoc p : ds) {
			if(p instanceof PhongMayTinh && ((PhongMayTinh) p).getSoLuongMayTinh() >= 60)
				dsPhongCo60May.add(p);
		}
		return dsPhongCo60May;
	}
	
	public ArrayList<PhongHoc> getDSPhongDatChuan() {
		ArrayList<PhongHoc> dsPhongChuan = new ArrayList<PhongHoc>();
		
		for (PhongHoc pc : ds) {
			if(pc.datChuan())
				dsPhongChuan.add(pc);
		}
		return dsPhongChuan;
	}
	
	public ArrayList<PhongHoc> getDSPhongHoc() {
		return ds;
	}
	
}	

































