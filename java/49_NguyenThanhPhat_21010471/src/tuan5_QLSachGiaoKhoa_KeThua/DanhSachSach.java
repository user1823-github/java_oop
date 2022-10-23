package tuan5_QLSachGiaoKhoa_KeThua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSach {
	private ArrayList<Sach> dsSach;
	
	public DanhSachSach() {
		dsSach = new ArrayList<Sach>();
	}
	
	public void themSach(Sach sachThem) throws Exception {
		// Trùng mã ?? phải viết hasdCode  va Equal trên lớp sách
		if(dsSach.contains(sachThem)) 
			throw new Exception("Mã sách đã bị trùng!");
		dsSach.add(sachThem);
	}
	
	public void suaSach(Sach sachSua) throws Exception {
		int vt = dsSach.indexOf(sachSua);
		if(vt != -1)
			dsSach.set(vt, sachSua);
		throw new Exception("Không tìm thấy mã sách cần sửa!");
	}
	
	public void xoaSach(Sach sachXoa) throws Exception {
		int vt = dsSach.indexOf(sachXoa);
		if(vt != -1)
			dsSach.remove(vt);
		throw new Exception("Không tìm thấy mã sách cần xoá");
	}
	
	// Tìm kiếm đối tượng sách
	public Sach timKiemObjSach(String maSachTim) {
		for (Sach sachTim : dsSach) {
			if(sachTim.getMaSach().equalsIgnoreCase(maSachTim))
				return sachTim;
		}
		return null;
	}
	
	// Tìm kiếm vị trí sách
	public int timViTriSach(String maSachTim) {
		Sach sachTim = timKiemObjSach(maSachTim);
		
		// Tìm thầy
		if(sachTim != null)
			return dsSach.indexOf(sachTim);
		return -1;
	}
	
	// Tổng tiền SGK
	public double getTongTienSGK() {
		double tienSGK = 0;
		for (Sach sgk : dsSach) {
			if(sgk instanceof SachGiaoKhoa)
				tienSGK += sgk.getDonGia();
		}
		return tienSGK;
	}
	
	// Tổng tiền STK
	public double getTongTienSTK() {
		double tienSTK = 0;
		for (Sach stk : dsSach) {
			if(stk instanceof SachThamKhao)
				tienSTK += stk.getDonGia();
		}
		return tienSTK;
	}

	// Danh sách SGK
	public ArrayList<Sach> getDSSachGiaoKhoa() {
		ArrayList<Sach> dsSachGiaoKhoa = new ArrayList<Sach>();
		for (Sach sgk : dsSach) {
			if(sgk instanceof SachGiaoKhoa)
				dsSachGiaoKhoa.add(sgk);
		}
		return dsSachGiaoKhoa;
	}
	
	// Danh sách STK
	public ArrayList<Sach> getDSSachGThamKhao() {
		ArrayList<Sach> dsSachThamKhao = new ArrayList<Sach>();
		for (Sach stk : dsSach) {
			if(stk instanceof SachThamKhao)
				dsSachThamKhao.add(stk);
		}
		return dsSachThamKhao;
	}
	
	// Sắp xếp theo giá tiền
	public void sortGiaTien() {
		Collections.sort(dsSach, new Comparator<Sach>() {
			
			@Override
			public int compare(Sach o1, Sach o2) {
				// TODO Auto-generated method stub
				Double gia1 = o1.getDonGia();
				Double gia2 = o2.getDonGia();
				return gia1.compareTo(gia2);
			}
		});
	}
	
	// Danh sách các sach
	public ArrayList<Sach> getDSSach() {
		return dsSach;
	}

}






















