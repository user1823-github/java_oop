package tuan5_QLSachGiaoKhoa_KeThua;

import java.util.Date;

public class KiemThuSach {
	public static void main(String[] args) {
		DanhSachSach ds;
	}
	
	public void nhapCung(DanhSachSach ds) throws Exception {
		// Sách giáo khoa
		Date d = new Date(2022-1900, 2, 18);
		Sach s1 = new SachGiaoKhoa("001", d, 35000, 5, "Lê Thị Riêng", true);
		d = new Date(2022-1900, 12, 20);
		Sach s2 = new SachGiaoKhoa("002", d, 50000, 3, "Phương Nam", false);
		// Sách giáo khoa
		d = new Date(2021-1900, 7, 15);
		Sach s3 = new SachThamKhao("003", d, 20000, 7, "Đài Loan", 3000);
		d = new Date(2021-1900, 3, 19);
		Sach s4 = new SachThamKhao("004", d, 75000, 7, "Đài Loan", 3500);
		
		ds.themSach(s1);
		ds.themSach(s2);
		ds.themSach(s3);
		ds.themSach(s4);
		
	}
}
