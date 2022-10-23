package tuan7_NhaDat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachGiaoDich {
	private ArrayList<GiaoDich> ds;
	
	public DanhSachGiaoDich() {
		ds = new ArrayList<GiaoDich>();
	}

	
	public GiaoDich timKiemObj(String maGD) {
		for (GiaoDich gd : ds) {
			if(gd.getMaGiaoDich().equalsIgnoreCase(maGD))
				return gd;
		}
		return null;
	}
	
	public int viTri(String maGD) {
		GiaoDich gd = timKiemObj(maGD);
		if(gd != null)
			return ds.indexOf(gd);
		return -1;
	}
	
	// Thêm, sửa, xóa
	public void them(GiaoDich gd) throws Exception {
		if(ds.contains(gd) == false)
			ds.add(gd);
		else
			throw new Exception("Mã giao dịch này đã tồn tại!");
	}
	
	public void sua(GiaoDich gd) throws Exception {
		int vt = ds.indexOf(gd);

		if(vt!=-1)
			ds.set(vt, gd);
		else
			throw new Exception("Không tìm thấy giao dịch để sửa!");
	}
	
	public void xoa(GiaoDich gd) throws Exception {
		int vt = ds.indexOf(gd);
		
		if(vt!=-1)
			ds.remove(vt);
		else
			throw new Exception("Không tìm thấy giao dịch để xóa!");
	}
	
	// Get tổng tiền giao dịch nhà và đất
	public double getTotalTienGDDat() {
		double totalTienDat = 0;
		for (GiaoDich gd : ds) {
			if(gd instanceof GiaoDichDat)
				totalTienDat += gd.thanhTien();
		}
		return totalTienDat;
	}
	
	public double getTotalTienGDNha() {
		double tienTotalNha = 0;
		for (GiaoDich gd : ds) {
			if(gd instanceof GiaoDichNha)
				tienTotalNha += gd.thanhTien();
		}
		return tienTotalNha;
	}
	
	// Danh sách giao dịch nhà và đất
	public ArrayList<GiaoDich> getDSDat() {
		ArrayList<GiaoDich> dsNha = new ArrayList<GiaoDich>();
		for (GiaoDich gd : ds) {
			if(gd instanceof GiaoDichNha)
				dsNha.add(gd);
		}
		return dsNha;
	}
	
	public ArrayList<GiaoDich> getDSNha() {
		ArrayList<GiaoDich> dsDat = new ArrayList<GiaoDich>();
		for (GiaoDich gd : ds) {
			if(gd instanceof GiaoDichDat)
				dsDat.add(gd);
		}
		return dsDat;
	}
	
	// Sắp xếp theo giá tiền giảm dần
	public void sortTheoGiaTien() {
		Collections.sort(ds, new Comparator<GiaoDich>() {

			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				Double gia1 = o1.getDonGia();
				Double gia2 = o2.getDonGia();
				return gia2.compareTo(gia1);
			}
		});
	}
	
	public ArrayList<GiaoDich> getDSCacGiaoDich() {
		return ds;
	}
	
	public int soLuongGDDat() {
		int countDat = 0;
		for (GiaoDich gd : ds) {
			if(gd instanceof GiaoDichDat)
				countDat++;
		}
		return countDat;
	}
	
	public int soLuongGDNha() {
		int countNha = 0;
		for (GiaoDich gd : ds) {
			if(gd instanceof GiaoDichNha)
				countNha++;
		}
		return countNha;
	}
}





