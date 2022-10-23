package tuan1_QuanLyDangKyXe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class KiemThuQuanLyXe {
	// Main
	public static void main(String[] args) {
		Vehicle[] vehicles = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t==Đây là chương trình quản lý đăng ký xe==\n");
		int chon = -1; 
		do {
			chon = menu();
			switch (chon) {
			case 1: {
				int n;
				System.out.println("::Vui lòng chọn số lượng xe muốn nhập: ");
				n = sc.nextInt();
				sc.nextLine();
				// Lưu đối tượng vào mảng
				vehicles = new Vehicle[n];
				for(int i = 0; i<vehicles.length; i++)
					vehicles[i] = taoMemXe();
				break;
			}
			case 2: {
				inTieuDe();
				System.out.println("======================================================================================================================");
				// Xuất đối tượng ra
				for (int i = 0; i < vehicles.length; i++) 
					System.out.println(vehicles[i]);
				System.out.println("---------------------------");
				break;
			}
			case 3: {
				System.out.println("=>Bạn đã thoát chương trình!");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + chon);
			}
		}while(chon != 3);		
		
	}
	
	// Function
	static int nhapSoNguyen(String s) {
		Scanner sc = new Scanner(System.in);
		int soNguyen;
		System.out.println(s);
		soNguyen = sc.nextInt();
		return soNguyen;
	}
	
	static double nhapSoThuc(String s) {
		Scanner sc = new Scanner(System.in);
		double soThuc;
		System.out.println(s);
		soThuc = sc.nextDouble();
		return soThuc;
	}
	
	static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*********************************************************");
		System.out.println("** 1. Nhập thông tin và tạo các đối tượng xe.           *");
		System.out.println("** 2. Xuất bảng kê khai tiền thuế trước bạ của các xe.	*");
		System.out.println("** 3. Thoát.                                            *");
		System.out.println("*********************************************************");
		System.out.println("-->Mời bạn lựa chọn chức năng: ");
		int chon = sc.nextInt();
		sc.nextLine();
		return chon;
	}
	
	static Vehicle taoMemXe() {
		Vehicle taoMem;
		Scanner sc = new Scanner(System.in);
		String tenChuXe, loaiXe, s;
		int dungTich;
		double triGia;
		
		s = "- Mời bạn nhập tên chủ xe: ";
		System.out.println(s);
		tenChuXe = sc.nextLine();
		
		s = "- Nhập loại xe: ";
		System.out.println(s);
		loaiXe = sc.nextLine();
		
		s = "- Nhập dung tích của xe: ";
		dungTich = nhapSoNguyen(s);
		s = "- Nhập trị giá của xe: ";
		triGia = nhapSoThuc(s);
		
		taoMem = new Vehicle(tenChuXe, loaiXe, dungTich, triGia);
		return taoMem;
	}
	
	static void inTieuDe() {
		String str = "";
		System.out.println("===> In thông tin của xe!");
		str += String.format("%s%29s%35s%22s%22s", "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
		System.out.println(str);
	}

}









