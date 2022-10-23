package tuan6_KeThuaBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSach {
	private ArrayList<Sach> ds = new ArrayList<Sach>();
	private int count;
	
	public boolean themSach(Sach s) {
		if(ds.contains(s))
			return false;
		else
		{	
			ds.add(s);
			return true;
		}
	}
	
	public void suaSach(Sach s) throws Exception {
		int vt = ds.indexOf(s);
		if(vt != -1)
			ds.set(vt, s);
		throw new Exception("Không tìm thấy sách để sửa!");
	}
	
	public boolean xoaSach(Sach s) {
		int vt = ds.indexOf(s);
		if(vt != -1)
		{
			ds.remove(vt);
			return true;
		}
		return false;
	}
	
	// Tìm kiểm sách -------
	public Sach timKiemObjSach(String maSach) {
		for (Sach s : ds) {
			if(s.getMaSach().equalsIgnoreCase(maSach))
				return s;
		}
		return null;
	}
	
	public int timKiemIndex(String maSach) {
		Sach sachTim = timKiemObjSach(maSach);
		
		if(sachTim != null)
			return ds.indexOf(sachTim);
		return -1;
	}
	
	// Total tiền tất cả các loại sách
	public double getTongTienCacSach() {
		return getTongTienSGK() + getTongTienSTK();
	}
	
	// Total tiền STK
	public double getTongTienSTK() {
		double tienSTK = 0;
		for (Sach s : ds) {
			if(s instanceof SachThamKhao)
				tienSTK += s.getThanhTien();
		}
		return tienSTK;
	}
	
	// Total tiền SGK
	public double getTongTienSGK() {
		double tienSGK = 0;
		for (Sach s : ds) 
			if(s instanceof SachGiaoKhoa)
				tienSGK += s.getThanhTien();
		return tienSGK;
	}

	// Tổng thành tiền cao nhất
	public double tienMax() {
		if(getTongTienSGK() > getTongTienSTK())
			return getTongTienSGK();
		else 
			return getTongTienSTK();
	}
	
	// sort 
	public void sortGiaTien() {
		Collections.sort(ds, new Comparator<Sach>() {

			@Override
			public int compare(Sach o1, Sach o2) {
				Double gia1 = o1.getDonGia();
				Double gia2 = o2.getDonGia();
				return gia2.compareTo(gia1);
			}
		});
	}
	
	public void sortNgayNhap() {
		Collections.sort(ds, new Comparator<Sach>() {

			@Override
			public int compare(Sach o1, Sach o2) {
				LocalDate date1 = o1.ngayNhap;
				LocalDate date2 = o2.ngayNhap;
				return date1.compareTo(date2);
			}
		});
	}
	
	// get danh sách -------
	public ArrayList<Sach> getDSSachThamKhao() {
		ArrayList<Sach> dsSachThamKhao = new ArrayList<Sach>();
		
		for (Sach s : ds) 
			if(s instanceof SachThamKhao)
				dsSachThamKhao.add(s);
		return dsSachThamKhao;
	}

	public ArrayList<Sach> getDSSachGiaoKhoa() {
		ArrayList<Sach> dsSachGiaoKhao = new ArrayList<Sach>();
		for (Sach s : ds) 
			if(s instanceof SachGiaoKhoa)
				dsSachGiaoKhao.add(s);
		return dsSachGiaoKhao;
	}
	
	public ArrayList<Sach> getDSSach() {
		return ds;
	}
	
	
}




