package tuan1_XuLyHinhChuNhat;

import java.util.Scanner;

public class KiemThuHCN {
	public static void main(String[] args) {
		HinhChuNhat hcn1 = new HinhChuNhat(10, 5);
		System.out.println("\t\t\t==Đây là chương trình tính chu vi và diện tích của Hình Chữ Nhật==");

		System.out.println("- Chu vi HCN là: " + hcn1.chuVi());
		System.out.println("- Dien tich HCN là: " + hcn1.dienTich());
		
		HinhChuNhat hcn2 = new HinhChuNhat();
		hcn2.setChieuDai(8);
		hcn2.setChieuRong(6);
		System.out.println("- Chu vi HCN 2 là: " + hcn2.chuVi());
		System.out.println("- Dien tich HCN 2 là: " + hcn2.dienTich());

		System.out.println("==========================");
		System.out.println(hcn1 + "\n");
		System.out.println(hcn2);
		System.out.println("==========================");
		
		HinhChuNhat taoCN = taoHinhCNMem();
		System.out.println(taoCN);
	}
	
	static HinhChuNhat taoHinhCNMem() {
		int d, r;
		HinhChuNhat taoCN;
		Scanner sc = new Scanner(System.in);
		String s = "- Bạn nhập chiều dài: "; 
		d = nhapSoNguyen(s);
		r = nhapSoNguyen("- Bạn nhập chiều rộng: ");
		taoCN = new HinhChuNhat(d, r);
		return taoCN;
	}
	
	public static int nhapSoNguyen(String s) {
		int a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println(s);
		a = sc.nextInt();
		return a;
	}

}












