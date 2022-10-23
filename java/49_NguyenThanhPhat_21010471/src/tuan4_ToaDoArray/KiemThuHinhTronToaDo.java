package tuan4_ToaDoArray;

import java.sql.Time;
import java.util.Iterator;
import java.util.Scanner;

import tuan4_SinhVienArray.DanhSachLopHocPhan;

public class KiemThuHinhTronToaDo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachToaDo ds = new DanhSachToaDo(2);
		DanhSachToaDo ds2 = new DanhSachToaDo(4);
		int chon = -1;
		do {
			menu();
			System.out.println("--> Mời bạn nhập lựa chọn");
			chon = sc.nextInt();
			
			switch (chon) {
			case 1:
				System.out.println("\t============Nhập cứng danh sách toạ độ=========");
				nhapCung(ds);
				break;
			case 2:
				System.out.println("\t============Nhập mềm danh sách toạ độ=========");
				
				HinhTron htMem = null;
				System.out.println("Nhập bán kính hình tròn: ");
				double r = sc.nextDouble();
				sc.nextLine();
				
				ToaDo tdMem = nhapMem();
				if(tdMem != null)
				{
					ds2.themToaDo(tdMem);
					
					inTieuDeHinhTron();
					htMem = new HinhTron(r, ds2);
					System.out.println(htMem);
					inTieuDeToaDo();
					System.out.println(htMem.dsToaDoForEach());
				}else
					System.out.println("Tạo toạ độ và hình tròn không thành công");
				break;
			case 3:
				sua(ds);
				break;
			case 4:
				xoa(ds);
				break;
			case 5:
				xuatDSToaDo(ds);
				break;
			case 6:
				timKiemToaDo(ds);
				break;
			case 7:
				System.out.println("Sắp xếp theo tên toạ độ tăng dần: ");
				ds.sortTheoTenToaDo();
				break;
			case 8:
				System.out.println("=> Bạn đã thoát chương trình!");	
				break;
			default:
				break;
			}
		}while(chon != 8);
		
	}
	
	static void nhapCung(DanhSachToaDo ds) {
		Scanner sc = new Scanner(System.in);
		
		ToaDo td1 = new ToaDo("TD01", (float)3.5, (float)4.5);
		ToaDo td2 = new ToaDo("TD02", (float)2.5, 3);
		ToaDo td3 = new ToaDo("TD03", (float)6.5, (float)3.5);
		ToaDo td4 = new ToaDo("TD04", (float)2.5, (float)7.5);
		
		ds.themToaDo(td1);
		ds.themToaDo(td2);
		ds.themToaDo(td3);
		ds.themToaDo(td4);
		
		HinhTron ht1 = new HinhTron(5.8, ds);
		
		inTieuDeHinhTron();
		System.out.println(ht1);
		
		inTieuDeToaDo();
		System.out.println(ht1.dsToaDoForEach());

	}
	// Thêm
	static ToaDo nhapMem() {
		Scanner sc = new Scanner(System.in);
		ToaDo tdMem = null;
		String ten;
		float x = 0, y = 0;
		
		System.out.println("Nhập tên toạ độ: ");
		ten = sc.nextLine();
		System.out.println("Nhập toạ độ x: ");
		x = sc.nextFloat();
		System.out.println("Nhập toạ độ y: ");
		y = sc.nextFloat();
		
		tdMem = new ToaDo(ten, x, y);
		return tdMem;
	}
	// Sửa
	static void sua(DanhSachToaDo ds) {
		Scanner sc = new Scanner(System.in);
		ToaDo tdSua = null;
		int chon = -1;
		
		float x, y;
		System.out.println("Tên toạ độ cần sửa: ");
		String ten = sc.nextLine();
		
		int vt = ds.timKiem(ten);
		System.out.println(vt);
		if(vt != -1)
		{
			tdSua = ds.getDSToaDo()[vt];
			System.out.println("=== Toạ độ trước khi sửa ===");
			System.out.println(tdSua);
			
			do {
				menuSua();
				System.out.println("--> Nhập lựa chọn: ");
				chon = sc.nextInt();
				
				switch (chon) {
				case 1:
					System.out.println("Sửa toạ độ x: ");
					x = sc.nextFloat();
					tdSua.setX(x);
					break;
				case 2:
					System.out.println("Sửa toạ độ y");
					y = sc.nextFloat();
					tdSua.setY(y);
					break;
				default:
					System.out.println("Quay lại menu chính: ");
					System.out.println("=> Sửa thành công");
					break;
				}
			}while(chon != 3);
		}else
			System.out.println("=> Sửa không thành công");
	}
	// Xoá
	static void xoa(DanhSachToaDo ds) {
		Scanner sc = new Scanner(System.in);
		ToaDo tdXoa = null;
		
		System.out.println("Nhập tên toạ độ cần xoá: ");
		String ten = sc.nextLine();
		
		int vt = ds.timKiem(ten);
		if(vt != -1)
		{
			tdXoa = ds.getDSToaDo()[vt];
			System.out.println("Bạn có chắc chắn muốn xoá không [Y/N]: ");
			String acp = sc.nextLine();
			
			if(acp.equalsIgnoreCase("y"))
			{
				ds.xoaToaDo(tdXoa);
				System.out.println("Xoá thành công!");
			}else
				System.out.println("==> Bạn đã huỷ thao tác xoá!");
		}
		else
			System.out.println("Xoá không thành công!");
	}
	
	static void timKiemToaDo(DanhSachToaDo ds) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên toạ độ cần tìm: ");
		String ten = sc.nextLine();
		
		int vt = ds.timKiem(ten);
		if(vt != -1)
			System.out.println("Toạ độ nằm tại vị trí thứ: " + (vt+1));
		else
			System.out.println("=> Toạ độ không tồn tại!");
	}
	
	static void xuatDSToaDo(DanhSachToaDo ds) {
		for (int i = 0; i < ds.soLuongThuc; i++) {
			System.out.println(ds.getDSToaDo()[i]);
		}
	}
	
	static void menuSua() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t SỬA TOẠ ĐỘ                        **");
		System.out.println("*1. Toạ độ x                                        *");
		System.out.println("*2. Toạ độ y                                        *");
		System.out.println("*3. Thoát                                           *");
		System.out.println("*****************************************************");
	}
	
	static void menu() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ DANH SACH TOẠ ĐỘ          **");
		System.out.println("*1. Nhập cứng                                       *");
		System.out.println("*2. Thêm                                            *");
		System.out.println("*3. Sửa                                             *");
		System.out.println("*4. Xoá                                             *");
		System.out.println("*5. Xuất                                            *");
		System.out.println("*6. Tìm kiếm                                        *");
		System.out.println("*7. Sắp xếp theo tên toạ độ tăng dần:               *");
		System.out.println("*8. Thoát                                           *");
		System.out.println("*****************************************************");
	}
	
	static void inTieuDeHinhTron() {
		String str = "";
		str += String.format("%10s%10s%10s", "Bán kính", "Diện tích", "Chu vi");
		System.out.println(str);
	}
	
	static void inTieuDeToaDo() {
		String str = "";
		System.out.println("\n==> Danh sách toạ độ: ");
		str += String.format("%-15s%10s%10s", "  Tên toạ độ | ", "Toạ độ X | ", "Toạ độ Y");
		System.out.print(str);	
	}
}
