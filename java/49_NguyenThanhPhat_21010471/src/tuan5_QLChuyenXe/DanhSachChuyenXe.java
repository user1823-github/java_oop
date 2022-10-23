package tuan5_QLChuyenXe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import tuan5_QLSachGiaoKhoa_KeThua.Sach;

public class DanhSachChuyenXe {
	private ArrayList<ChuyenXe> dsChuyenXe;
	
	public DanhSachChuyenXe() {
		dsChuyenXe = new ArrayList<ChuyenXe>();
	}
	
	// Thêm
	public void themChuyenXe(ChuyenXe chuyenThem) throws Exception {
		if(dsChuyenXe.contains(chuyenThem) == false)
			dsChuyenXe.add(chuyenThem);
		else
			throw new Exception("Mã chuyến xe bị trùng!");
	}
	
	// Sửa
	public void suaChuyenXe(ChuyenXe chuyenSua) throws Exception {
		int vt = dsChuyenXe.indexOf(chuyenSua);
		if(vt != -1)
			dsChuyenXe.set(vt, chuyenSua);
		throw new Exception("Không tìm thấy chuyến để sửa!");
	}
	
	// Xoá
	public void xoaChuyenXe(ChuyenXe chuyenXoa) throws Exception {
		int vt = dsChuyenXe.indexOf(chuyenXoa);
		
		if(vt != -1)
			dsChuyenXe.remove(vt);
		throw new Exception("Không tìm thấy chuyến để xoá");
	}
	
	
	public ChuyenXe timKiemObj(String maChuyen) {
		for (ChuyenXe cx : dsChuyenXe) {
			if(cx.getMaChuyen().equalsIgnoreCase(maChuyen))
				return cx;
		}
		return null;
	}
	
	public int timKiemViTri(String maChuyen) {
		ChuyenXe chuyenTim = timKiemObj(maChuyen);
		if(chuyenTim != null)
			return dsChuyenXe.indexOf(chuyenTim);
		return -1;
	}
	
	// Tổng doanh thu các chuyến xe
	public double tongDoanhThu() {
		double total = 0;
		for (ChuyenXe chuyen : dsChuyenXe) {
			total += chuyen.getDoanhThu();
		}
		return total;
	}
	
//  ==========          Doanh thu    ===========
	// Tổng doanh thu Nội Thành
	public double doanhThuNoiThanh() {
		double totalNoiThanh = 0;
		for (ChuyenXe chuyen : dsChuyenXe) {
			if(chuyen instanceof NoiThanh)
				totalNoiThanh += chuyen.getDoanhThu();
		}
		return totalNoiThanh;
	}
	
	// Tổng doanh thu Ngoại Thành
	public double doanhThuNgoaiThanh() {
		double totalNgoaiThanh = 0;
		for (ChuyenXe chuyen : dsChuyenXe) {
			if(chuyen instanceof NgoaiThanh)
				totalNgoaiThanh += chuyen.getDoanhThu();
		}
		return totalNgoaiThanh;
	}
	
	//  ==========          Sắp xếp    ===========
	// Sắp xếp theo doanh thu
	public void sortTheoDoanhThu() {
		Collections.sort(dsChuyenXe, new Comparator<ChuyenXe>() {

			@Override
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				// TODO Auto-generated method stub
				Double gia1 = o1.getDoanhThu();
				Double gia2 = o2.getDoanhThu();
				return gia1.compareTo(gia2);
			}
		});
	}
	
	// Sắp xếp theo tên tài xế
	public void sortTheoTen() {
		Collections.sort(dsChuyenXe, new Comparator<ChuyenXe>() {

			@Override
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				return o1.getTenTaiXe().compareToIgnoreCase(o2.getTenTaiXe());
			}
		});
	}
	
	// Sắp xếp theo 2 thuộc tính
	public void sortTheo2Field() {
		Collections.sort(dsChuyenXe, new Comparator<ChuyenXe>() {

			@Override
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				String x1 = o1.getTenTaiXe();
				String x2 = o2.getTenTaiXe();
				int Comp = x1.compareTo(x2);
				
				if(Comp != 0)
					return Comp;
				else
				{
					Double dt1 = o1.getDoanhThu();
					Double dt2 = o2.getDoanhThu();
					return dt1.compareTo(dt2);
				}
			}
		});
	}
	
	
	//   ==========          Lấy danh sách    ===========
	// Danh sách chuyến xe Nội Thành
	public ArrayList<ChuyenXe> getDSNoiThanh() {
		ArrayList<ChuyenXe> dsNoiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe chuyen : dsChuyenXe) {
			if(chuyen instanceof NoiThanh)
				dsNoiThanh.add(chuyen);
		}
		return dsNoiThanh;
	}
	
	// Danh sách chuyến xe Ngoại Thành
	public ArrayList<ChuyenXe> getDSNgoaiThanh() {
		ArrayList<ChuyenXe> dsNgoaiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe chuyen : dsChuyenXe) {
			if(chuyen instanceof NgoaiThanh)
				dsNgoaiThanh.add(chuyen);
		}
		return dsNgoaiThanh;
	}
	
	
	// Danh sách các chuyến xe
	public ArrayList<ChuyenXe> getDSChuyenXe() {
		return dsChuyenXe;
	}
	
}































