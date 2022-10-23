package tuan7_NhaDat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KiemThuNhaDat {
	public static void main(String[] args) throws Exception {
		DanhSachGiaoDich ds = new DanhSachGiaoDich();
		Scanner sc = new Scanner(System.in);
		
		int chon = -1;
		do {
			menuChinh();
			System.out.println("Mời bạn nhập lựa chọn: ");
			chon = sc.nextInt();
			sc.nextLine();
			
			switch (chon) {
			case 1:
				nhapCung(ds);
				break;
			case 2:
				GiaoDich gdMem = nhapMem(ds);
				if(gdMem != null)
					ds.them(gdMem);
				else
					System.out.println("Thêm không thành công!");
				break;
			case 3:
				xoa(ds);
				break;
			case 4:
				sua(ds);
				break;
			case 5:
				xuat(ds);
				break;
			case 6:
				xuatDat(ds);
				break;
			case 7:
				xuatNha(ds);
				break;
			case 8:
				System.out.println("Sort theo giá tiền giảm dần: ");
				ds.sortTheoGiaTien();
				break;
			case 9:
				System.out.println("Trung bình thành tiền của giao dịch [Đất] là: " + trungBinhTienGDDat(ds));
				break;
			case 10:
				System.out.println("Trung bình thành tiền của giao dịch [Nhà] là: " + trungBinhTienGDNha(ds));
				break;
			case 11:
				System.out.println("Tổng số lượng giao dịch [Đất] là: " + ds.soLuongGDDat());
				break;
			case 12:
				System.out.println("Tổng số lượng giao dịch [Nhà] là: " + ds.soLuongGDNha());
				break;
			case 13:
				System.out.println("Nhập mã giao dịch cần tìm vị trí: ");
				String maVT = sc.nextLine();
				System.out.println("Giao dịch cần tìm nằm vị trí thứ: " + (ds.viTri(maVT) + 1));
				break;
			case 14:
				System.out.println("Nhập mã giao dịch cần tìm thông tin: ");
				String maObj = sc.nextLine();
				System.out.println("Thông tin của giao dịch bạn tìm là: " + ds.timKiemObj(maObj));
				break;
			case 15:
				System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
				break;
			default:
				break;
			}
		}while(chon != 15);
		
	}
	
	static void nhapCung(DanhSachGiaoDich ds) throws Exception {
		LocalDate lc = null;
		
		GiaoDich gd1 = new GiaoDichNha("GDNha_01", lc.of(2022, 3, 18), 200, 600, "thường", "Gò Vấp");
		GiaoDich gd2 = new GiaoDichNha("GDNha_02", lc.of(2021, 12, 30), 9500, 1000, "cao cấp", "Thủ Thiêm");
		GiaoDich gd3 = new GiaoDichDat("GDDat_01", lc.of(2019, 7, 28), 1500, 250, "C");
		GiaoDich gd4 = new GiaoDichDat("GDDat_02", lc.of(2018, 5, 7), 5000, 700, "A");
		
		ds.them(gd1);
		ds.them(gd2);
		ds.them(gd3);
		ds.them(gd4);
		
	}
	
	static GiaoDich nhapMem(DanhSachGiaoDich ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		GiaoDich gd = null;
		
		LocalDate lc = null;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		int chon = -1;
		
		System.out.println("Nhập mã giao dịch cần thêm: ");
		String maGD = sc.nextLine();
		
		gd = ds.timKiemObj(maGD);
		if(gd == null)
		{
			System.out.println("Nhập loại giao dịch [1: Giao dịch đất], [2: Giao dịch nhà]: ");
			chon = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Ngày giao dịch (dd/MM/yyyy): ");
			String ngayGD = sc.nextLine();
			System.out.println("Đơn giá: ");
			double donGia = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Diện tích: ");
			double dienTich = sc.nextDouble();
			sc.nextLine();
			
			if(chon == 1)
			{
				System.out.println("Loại đất (\"A\", \"B\", \"C\"): ");
				String loaiDat = sc.nextLine();
				gd = new GiaoDichDat(maGD, lc.parse(ngayGD, df), donGia, dienTich, loaiDat);
			} else
			{
				System.out.println("Loại nhà (\"cao cấp\", \"thường\"): ");
				String loaiNha = sc.nextLine();
				System.out.println("Địa chỉ: ");
				String diaChi = sc.nextLine();
				gd = new GiaoDichNha(maGD, lc.parse(ngayGD, df), donGia, dienTich, loaiNha, diaChi);
			}
		}
		return gd;
	}
	
	static void xoa(DanhSachGiaoDich ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		GiaoDich gd = null;
		
		System.out.println("Nhập mã giao dịch cần xoá: ");
		String maGD = sc.nextLine();
		gd = ds.timKiemObj(maGD);
		
		if(gd != null)
		{
			System.out.println("Bạn có chắn chắn muốn xoá [Y/N]: ");
 			String acp = sc.nextLine();
 			if(acp.equalsIgnoreCase("y"))
 			{
 				ds.xoa(gd);
 				System.out.println("Đã xoá thành công!");
 			}
 			else
 				System.out.println("Bạn đã huỷ thao tác xoá!");
		}else
			System.out.println("Mã giao dịch không tồn tại!");
	}
	
	static void sua(DanhSachGiaoDich ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		GiaoDich gd = null;
		
		int chon = -1;
		
		System.out.println("Nhập mã giao dịch cần sửa: ");
		String maGD = sc.nextLine();
		
		gd = ds.timKiemObj(maGD);
		
		// Tìm thấy
		if(gd != null)
		{
			System.out.println("Thông tin giao dịch trước khi sửa: " + gd);
			
			if(gd instanceof GiaoDichDat)
			{
				do {
					menuSuaDat();
					System.out.println("--> Chọn chức năng sửa đất: ");
					chon = sc.nextInt();
					sc.nextLine();
					
					menuThucHienSua(chon, gd);
				} while (chon != 6);				
			} 
			else if(gd instanceof GiaoDichNha)
			{
				do {
					menuSuaNha();
					System.out.println("--> Chọn chức năng sửa nhà: ");
					chon = sc.nextInt();
					sc.nextLine();
					
					menuThucHienSua(chon, gd);
				}while(chon != 7);
			}
		}else 
			System.out.println("Mã giao dịch này không tồn tại! \n=> Sửa không thành công!");
	}
	
	static void menuThucHienSua(int chon, GiaoDich gd) throws Exception {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate lc = null;
		
		switch (chon) {
		case 1:
			System.out.println("Mã giao dịch: ");
			gd.setMaGiaoDich(sc.nextLine());
			break;
		case 2:
			System.out.println("Ngày giao dịch [dd/MM/yyyy]: ");
			gd.setNgayGiaoDich(lc.parse(sc.nextLine(), df));
			break;
		case 3:
			System.out.println("Đơn giá: ");
			gd.setDonGia(sc.nextDouble());
			sc.nextLine();
			break;
		case 4:
			System.out.println("Diện tích: ");
			gd.setDienTich(sc.nextDouble());
			sc.nextLine();
			break;
		case 5: 
			if(gd instanceof GiaoDichDat)
			{
				System.out.println("Loại đất [A, B, C]: ");
				((GiaoDichDat) gd).setLoaiDat(sc.nextLine());
			} else if(gd instanceof GiaoDichNha)
			{
				System.out.println("Loại nhà [cao cấp || thường]: ");
				((GiaoDichNha) gd).setLoaiNha(sc.nextLine());
			}
			break;
		case 6:
			if(gd instanceof GiaoDichDat)
			{
				System.out.println("Thoát menu sửa giao địch [Đất]!");
				break;
			}
			if(gd instanceof GiaoDichNha)
			{
				System.out.println("Địa chỉ: ");
				((GiaoDichNha) gd).setDiaChi(sc.nextLine());
			}
			break;
		case 7:
			System.out.println("Thoát menu sửa giao dịch [Nhà]!");
			break;
		}
	}
	
	// Danh sách giao dịch
	static void xuat(DanhSachGiaoDich ds) {
		for (GiaoDich gd : ds.getDSCacGiaoDich()) {
			System.out.println(gd);
		}
	}
	
	static void xuatDat(DanhSachGiaoDich ds) {
		for (GiaoDich gdDat : ds.getDSDat()) {
			System.out.println(gdDat);
		}
	}
	
	static void xuatNha(DanhSachGiaoDich ds) {
		for (GiaoDich gdNha : ds.getDSNha()) {
			System.out.println(gdNha);
		}
	}
	
	// Trung bình thành tiền GD Nhà và Đất
	static double trungBinhTienGDDat(DanhSachGiaoDich ds) {
		double trungBinhTienDat = ds.getTotalTienGDDat() / ds.soLuongGDDat();
		return trungBinhTienDat;
	}
	
	static double trungBinhTienGDNha(DanhSachGiaoDich ds) {
		double trungBinhTienNha = ds.getTotalTienGDNha() / ds.soLuongGDNha();
		return trungBinhTienNha;
	}
	
	
	// Các Menu
	static void menuChinh() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ GIAO DỊCH [NHÀ] VÀ [ĐẤT]             **");
		System.out.println("*1. Nhập cứng                                       *");
		System.out.println("*2. Thêm 1 giao dịch                                *");
		System.out.println("*3. Xoá                                             *");
		System.out.println("*4. Cập nhật thông tin giao dịch                    *");
		System.out.println("*5. Xuất                                            *");
		System.out.println("*6. Xuất danh giao dịch [Đất]                       *");
		System.out.println("*7. Xuất danh giao dịch [Nhà]                       *");
		System.out.println("*8. Sort theo tiền các giao dịch giảm dần           *");
		System.out.println("*9. Trung bình thành tiền của giao dịch [Đất]       *");
		System.out.println("*10. Trung bình thành tiền của giao dịch [Nhà]      *");
		System.out.println("*11. Tổng số lượng giao dịch [Đất]                  *");
		System.out.println("*12. Tổng số lượng giao dịch [Nhà]                  *");
		System.out.println("*13. Tìm kiếm vị trí của giao dịch                  *");
		System.out.println("*14. Tìm kiếm thông tin giao dịch                   *");
		System.out.println("*15. Thoát!                                         *");
		System.out.println("*****************************************************");
	}
	
	static void menuSuaDat() {
		System.out.println("\n\n\t************************************************");
		System.out.println("\t** Sửa thông tin giao dịch [Đất]                  **");
		System.out.println("\t*1. Mã giao dịch                                   *");
		System.out.println("\t*2. Ngày giao dịch                                 *");
		System.out.println("\t*3. Đơn giá                                        *");
		System.out.println("\t*4. Diện tích                                      *");
		System.out.println("\t*5. Loại đất [A, B, C]                             *");
		System.out.println("\t*6. Thoát!                                         *"); 
		System.out.println("\t****************************************************");
	}
	
	static void menuSuaNha() {
		System.out.println("\n\n\t************************************************");
		System.out.println("\t** Sửa thông tin giao dịch [Nhà]                  **");
		System.out.println("\t*1. Mã giao dịch                                   *");
		System.out.println("\t*2. Ngày giao dịch                                 *");
		System.out.println("\t*3. Đơn giá                                        *");
		System.out.println("\t*4. Diện tích                                      *");
		System.out.println("\t*5. Loại nhà [cao cấp / thường]                    *");
		System.out.println("\t*6. Địa chỉ                                        *");
		System.out.println("\t*7. Thoát!                                         *"); 
		System.out.println("\t****************************************************");
	}
}



















