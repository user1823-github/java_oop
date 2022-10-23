package tuan1_QuanLySinhVien;

import java.util.Scanner;

public class KiemThuSinhVien {
	public static void main(String[] args) {
		SinhVienDiem svm = taoSinhVienMem();
		inTieuDe();
		taoCung();
		System.out.println(svm);
		
	}
	
	static float nhapSoThuc(String s) {
		Scanner sc = new Scanner(System.in);
		float diem;
		System.out.println(s);
		diem = sc.nextFloat();
		return diem;
	}

	static void taoCung() {
		SinhVienDiem sv1 = new SinhVienDiem(21010471, "Nguyễn Thành Phát", 6.5f, 7.5f);
		SinhVienDiem sv2 = new SinhVienDiem(21010465, "Đàm Anh Khoa", 9f, 5.5f);
		System.out.println(sv1);
		System.out.println(sv2);
	}
	
	static SinhVienDiem taoSinhVienMem() {
		Scanner sc = new Scanner(System.in);
		SinhVienDiem svm;
		int maSV;
		String hoTen, s;
		float diemLT, diemTH;
		s = "- Mời bạn nhập mã sinh viên: ";
		System.out.println(s);
		maSV = sc.nextInt();
		sc.nextLine();
		s = "- Nhập họ và tên: ";
		System.out.println(s);
		hoTen = sc.nextLine();
		s = "- Nhập điểm lý thuyết: ";
		diemLT = nhapSoThuc(s);
		s = "- Nhập điểm thực hành: ";
		diemTH = nhapSoThuc(s);
		svm = new SinhVienDiem(maSV, hoTen, diemLT, diemTH);
		return svm;
	}
	
	
	static void inTieuDe() {
		System.out.println("\t\t\t==Đây là chương trình Quản Lý Sinh Viên==");
		String str = "";
		str += String.format("%15s%-35s%15s%15s%15s", "Mã SV", " Họ và tên", "Điểm LT", "Điểm TH", "Điểm TB");
		System.out.println(str);
	}

}