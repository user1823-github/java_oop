package tuan6_KeThuaBook;

import java.io.ObjectInputValidation;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class KiemThuBook {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chon = -1;
		DecimalFormat df = new DecimalFormat("#,##0.00VNĐ");
		DanhSachSach ds = new DanhSachSach();


		do {
			menu();
			System.out.println("--> Mời bạn nhập lựa chọn: ");
			chon = sc.nextInt();
			
			switch (chon) {
			case 1:
				nhapCung(ds);
				break;
			case 2:
				Sach sachMem = nhapMem(ds);
				if(sachMem != null)
				{
					ds.themSach(sachMem);
					System.out.println("Thêm thành công!");
				}
				else
					System.out.println("Thêm không thành công!");
				break;
			case 3:
				sua(ds);
				break;
			case 4:
				xoa(ds);
				break;
			case 5:
				inTieuDeCot(chon);
				getDSSach(ds);
				break;
			case 6:
				ds.sortGiaTien();
				break;
			case 7:
				inTieuDeCot(chon);
				getDSSachTK(ds);
				String tienSTK = df.format(ds.getTongTienSTK());
				System.out.println("Tổng tiền của các (sách tham khảo): " + tienSTK);
				break;
			case 8:
				inTieuDeCot(chon);
				getDSSachGK(ds);
				String tienSGK = df.format(ds.getTongTienSGK());
				System.out.println("Tổng tiền của các (sách giáo khoa): " + tienSGK);
				break;
			case 9:
				System.out.println("Tổng tiền của (tất cả các sách): " + ds.getTongTienCacSach());
				break;
			case 10:
				ds.sortNgayNhap();
				break;
			case 11:
				System.out.println("Tìm thành tiền cao nhất: " + ds.tienMax());
				break;
			case 12:
				System.out.println("=> Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!");
				break;
			default:
				break;
			}
		} while (chon != 12);
		
	}
	
	static void nhapCung(DanhSachSach ds) {
		Sach s1 = new SachGiaoKhoa("M01", LocalDate.of(2022, 3, 15), 60000, 2, "Phương Nam", true);
		Sach s2 = new SachGiaoKhoa("M02", LocalDate.of(2021, 2, 20), 35000, 3, "Minh Ngọc", true);

		Sach s3 = new SachThamKhao("M03", LocalDate.of(2019, 8, 12), 45000, 2, "Lan Anh", 2500);
		Sach s4 = new SachThamKhao("M04", LocalDate.of(2024, 6, 4), 55000, 4, "Lê Thị Riêng", 2000);
		
		ds.themSach(s1);
		ds.themSach(s2);
		ds.themSach(s3);
		ds.themSach(s4);
	}
	
	static Sach nhapMem(DanhSachSach ds) {
		Scanner sc = new Scanner(System.in);
		Sach sachMem = null;
		
		String ngayNhap, nhaXB, maSach;
		double donGia, thue;  
		int soLuong; 
		boolean tinhTrang;
		
		LocalDate lcd;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		int chon = -1;
		System.out.println("Nhập mã sách cần thêm: ");
		maSach = sc.nextLine();
		
		int vt = ds.timKiemIndex(maSach);
		if(vt == -1)
		{
			System.out.println("Chọn [1] (Sách tham khảo) / [2] (Sách giáo khoa): ");
			chon = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Ngày nhập (dd/MM/yyyy): ");
			ngayNhap = sc.nextLine();
			lcd = LocalDate.parse(ngayNhap, dtf);
			
			System.out.println("Đơn giá: ");
			donGia = sc.nextDouble();
			System.out.println("Số lượng: ");
			soLuong = sc.nextInt();
			sc.nextLine();
			System.out.println("Nhà xuất bản: ");
			nhaXB = sc.nextLine();
			if(chon == 1)
			{
				System.out.println("Thuế: ");
				thue = sc.nextDouble();
				sc.nextLine();
				sachMem = new SachThamKhao(maSach, lcd, donGia, soLuong, nhaXB, thue);
			}
			else 
			{
				System.out.println("Tình trạng [true/false]: ");
				tinhTrang = sc.nextBoolean();
				sachMem = new SachGiaoKhoa(maSach, lcd, donGia, soLuong, nhaXB, tinhTrang);
			}
		}else
			System.out.println("Trùng mã sách => Thêm không thành công");
		
		return sachMem;
	}
	
	// Xoá
	static void xoa(DanhSachSach ds) {
		Scanner sc = new Scanner(System.in);
		Sach sachXoa = null;
		
		String maSach;
		
		System.out.println("Nhập mã sách cần xoá: ");
		maSach = sc.nextLine();
		sachXoa = ds.timKiemObjSach(maSach);
		if(sachXoa != null)
		{
			System.out.println("Bạn có chắc chắn muốn xoá không [y/n]: ");
			String acp = sc.nextLine();
			if(acp.equalsIgnoreCase("y"))
			{
				ds.xoaSach(sachXoa);
				System.out.println("Xoá thành công!");
			}else 
				System.out.println("Bạn đã huỷ thao tác xoá!");
		}else
			System.out.println("Sách không tồn tại=> Xoá không thành công!");
	}
	
	// Sửa
	static void sua(DanhSachSach ds) {
		Scanner sc = new Scanner(System.in);
		Sach sachSua = null;
		int chon = -1;
		boolean status;
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate lc;
		
		System.out.println("Nhập mã sách cần sửa: ");
		String maSach = sc.nextLine();

		sachSua = ds.timKiemObjSach(maSach);
		if(sachSua != null)
		{
			System.out.println("Thông tin sách trước khi sửa: " + sachSua);
			if(sachSua instanceof SachThamKhao)
			{
				SachThamKhao stk = (SachThamKhao) sachSua;  
				do {
					menuSuaSTK();
					System.out.println("--> Chọn chức năng sửa: ");
					chon = sc.nextInt();
					sc.nextLine();
					
					thucHienMenuSua(chon, stk);
					if(chon == 5)
					{
						System.out.println("Thuế: ");
						stk.setThue(sc.nextDouble());
					}
				} while (chon != 6); 
			}else  	
			{
				SachGiaoKhoa sgk = (SachGiaoKhoa) sachSua;
				do {
					menuSuaSGK();
					System.out.println("--> Chọn chức năng sửa: ");
					chon = sc.nextInt();
					sc.nextLine();
					
					thucHienMenuSua(chon, sgk);
					if(chon == 5)
					{
						do {
							System.out.println("Tình trạng [true: mới/false: cũ]: ");
							status = sc.nextBoolean();
							
							if(status != true || status != false)
								System.out.println("Bạn phải nhập theo đúng yêu cầu: ");
						} while (status != true || status != false);
						sgk.setTinhTrang(status);
					}
				}while(chon != 6);
			}
		}else
			System.out.println("Không tồn tại mã sách này!");
	}
	
	// Menu
	static void thucHienMenuSua(int chon, Sach s) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate lc;
		
		switch (chon) {
		case 1:
			System.out.println("Ngày nhập (dd/MM/yyyy): ");
			lc = LocalDate.parse(sc.nextLine(), df);
			s.setNgayNhap(lc);
			break;
		case 2:
			System.out.println("Đơn giá: ");
			s.setDonGia(sc.nextDouble());
			break;
		case 3:
			System.out.println("Số lượng: ");
			s.setSoLuong(sc.nextInt());
			break;
		case 4:
			System.out.println("Nhà xuất bản: ");
			s.setNhaXB(sc.nextLine());
			break;
		case 6:
			System.out.println("Thoát! Quay trở về menu chính.");
			break;
		}
	}
	
	// Lấy danh sách 
	static void getDSSach(DanhSachSach ds) {
		for (Sach s : ds.getDSSach()) {
			System.out.println(s);
		}
	}
	
	static double tongTienSTK(DanhSachSach ds) {
		return ds.getTongTienSTK();
	}
	
	static double tongTienSGK(DanhSachSach ds) {
		return ds.getTongTienSGK();
	}
	
	static void getDSSachTK(DanhSachSach ds) {
		for (Sach stk : ds.getDSSachThamKhao()) {
			System.out.println(stk);
		}
	}
	
	static void getDSSachGK(DanhSachSach ds) {
		for (Sach sgk : ds.getDSSachGiaoKhoa()) {
			System.out.println(sgk);
		}
	}
	
	// Menu
	static void menu() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ SÁCH                 **");
		System.out.println("*1. Nhập cứng                                       *");
		System.out.println("*2. Thêm 1 sách                                     *");
		System.out.println("*3. Sửa                                             *");
		System.out.println("*4. Xoá                                             *");
		System.out.println("*5. Xuất                                            *");
		System.out.println("*6. Sắp xếp theo đơn giá giảm dần                   *");
		System.out.println("*7. Xuất danh sách STK và tổng tiển STK             *");
		System.out.println("*8. Xuất danh sách SGK và tổng tiển SGK             *");
		System.out.println("*9. Tổng tiền tất cả các sách                       *");
		System.out.println("*10.Sắp xếp theo ngày nhập                          *");
		System.out.println("*11.Tìm tổng tiền cao nhất trong 2 loại sách        *");
		System.out.println("*12. Thoát!                                         *");
		System.out.println("*****************************************************");
	}
	
	static void menuSuaSTK() {
		System.out.println("\n\n\t*****************************************************");
		System.out.println("\t** Sửa thông tin [Sách Giáo Khoa]                  **");
		System.out.println("\t*1. Ngày nhập                                       *");
		System.out.println("\t*2. Đơn giá                                         *");
		System.out.println("\t*3. Số lượng                                        *");
		System.out.println("\t*4. Nhà xuất bản                                    *");
		System.out.println("\t*5. Thuế                                            *");
		System.out.println("\t*6. Thoát                                           *");
		System.out.println("\t*****************************************************");
	}
	
	static void menuSuaSGK() {
		System.out.println("\n\n\t*****************************************************");
		System.out.println("\t** Sửa thông tin [Sách Giáo Khoa]                  **");
		System.out.println("\t*1. Ngày nhập                                       *");
		System.out.println("\t*2. Đơn giá                                         *");
		System.out.println("\t*3. Số lượng                                        *");
		System.out.println("\t*4. Nhà xuất bản                                    *");
		System.out.println("\t*5. Tình trạng [true/false]                         *");
		System.out.println("\t*6. Thoát                                           *");
		System.out.println("\t*****************************************************");
	}

	
	static void tieuDe() {
		String str = "";
		str += String.format("%-10s%-15s%-20s%10s%20s", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng", "Nhà xuất bản");                
		
		System.out.println(str);
	}
	

	
	static void inTieuDeCot(int chon) {
		String str = "";
		
		if(chon == 7)
		{
			str += String.format("%-10s%-15s%20s%10s%20s", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng", "Nhà xuất bản");                
			str += String.format("%10s", "Thuế");
			System.out.println(str);
		}else if(chon == 8)
		{
			str += String.format("%-10s%-15s%20s%10s%20s", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng", "Nhà xuất bản");                
			str += String.format("   %-8s", "Tình trạng");
			System.out.println(str);
		}else
		{
			str += String.format("%-10s%-15s%20s%10s%20s", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng", "Nhà xuất bản");                
			System.out.println(str);
		}
	}
	
}
