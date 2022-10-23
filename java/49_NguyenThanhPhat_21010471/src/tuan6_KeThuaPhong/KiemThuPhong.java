package tuan6_KeThuaPhong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import tuan6_KeThuaBook.Sach;

public class KiemThuPhong {
	public static void main(String[] args) throws Exception {
		Scanner sc =  new Scanner(System.in);
		DanhSachPhong ds = new DanhSachPhong();
		int chon = -1;
		
		do {
			menu();
			System.out.println("Mời bạn nhập lựa chọn: ");
			chon = sc.nextInt();
			sc.nextLine();
			
			switch (chon) {  
				case 1:
					nhapCung(ds);
					break;
				case 2:
					// Thêm
					PhongHoc phongThem = nhapMem(ds);
					if(phongThem != null)
						ds.them(phongThem);
					else
						System.out.println("Thêm phòng không thành công!");
					break;
				case 3:
					// Xoá
					xoa(ds);
					break;
				case 4:
					// Sửa
					sua(ds);
					break;
				case 5:
					// Tìm kiếm phòng
					System.out.println("Nhập mã phòng cần tìm: ");
					String maPhong = sc.nextLine();
					
					PhongHoc phongTim = ds.timKiemObj(maPhong);
					if(phongTim != null)
						System.out.println("Thông tin phòng này là: " + phongTim);
					else
						System.out.println("Không tìm thấy mã phòng này!");
					break;
				case 6:
					tieuDe();
					xuat(ds);
					break;
				case 7:
					inTieuDeCot(chon);
					xuatDSPhong60May(ds);
					break;
				case 8:
					tieuDe();
					xuatDSPhongDatChuan(ds);
					break;
				case 9:
					System.out.println("\t\t========= Sắp xếp tăng dần theo [Dãy nhà] =========");
					ds.sortTangDanTheoDayNha();
					break;
				case 10:
					System.out.println("\t\t========= Sắp xếp giảm dần theo [Diện tích] =========");
					ds.sortGiamDienTich();
					break;
				case 11:
					System.out.println("\t\t========= Sắp xếp tăng dần theo [Số bóng đèn] =========");
					ds.sortTangSoBongDen();                                                                
					break;
				case 12:
					System.out.println("Tổng số phòng học: " + ds.soLuongPhong() +" phòng");
					break;
				case 13:
					System.out.println("=>Thoát. Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!");
					break;
			} 	
		} while (chon != 13);	
	}
	static void nhapCung(DanhSachPhong ds) throws Exception {
		PhongHoc p1 = new PhongLyThuyet("LT1", "B", 100, 20, true);
		PhongHoc p2 = new PhongMayTinh("MT1", "X", 200, 70, 100);
		PhongHoc p3 = new PhongLyThuyet("LT2", "S", 80, 35, false);
		PhongHoc p4 = new PhongThiNghiem("TN1", "A", 75, 25, "CNTT", 120, true);
		PhongHoc p5 = new PhongMayTinh("MT2", "C", 500, 370, 300);
		PhongHoc p6 = new PhongThiNghiem("TN2", "F", 150, 60, "Marketing", 130, false);
		
		ds.them(p1);
		ds.them(p2);
		ds.them(p3);
		ds.them(p4);
		ds.them(p5);
		ds.them(p6);
	}
	
	// Thêm
	static PhongHoc nhapMem(DanhSachPhong ds) {
		Scanner sc = new Scanner(System.in);
		PhongHoc phong = null;
		int chon = -1;
		
		String maPhong, dayNha, chuyenNganh;
		int soBongDen, soLuongMayTinh, sucChua;
		double dienTich;
		boolean coMayChieu, coBonRua;
		
		System.out.println("Nhập mã phòng cần thêm: ");
		maPhong = sc.nextLine();
		
		int vt = ds.viTri(maPhong);
		if(vt == -1)
		{
			System.out.println("Nhập loại phòng [1: Phòng LT] [2: Phòng MT] [3: Phòng TN]: ");
			chon = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Dãy nhà: ");
			dayNha = sc.nextLine();
			System.out.println("Diện tích: ");
			dienTich = sc.nextDouble();
			System.out.println("Số bóng đèn: ");
			soBongDen = sc.nextInt();
			sc.nextLine();
			
			if(chon == 1)
			{
				System.out.println("Máy chiếu [True/False]: ");
				coMayChieu = sc.nextBoolean();
				phong = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
			}
			else if(chon == 2)
			{
				System.out.println("Số lượng máy tính: ");
				soLuongMayTinh = sc.nextInt();
				phong = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soLuongMayTinh);       
			}
			else
			{
				System.out.println("Chuyên ngành: ");
				chuyenNganh = sc.nextLine();
				System.out.println("Sức chứa: ");
				sucChua = sc.nextInt();
				System.out.println("Bồn rửa [True/False]: ");
				coBonRua = sc.nextBoolean();
				phong = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);   	
			}
		}else
			System.out.println("Trùng mã phòng!");
		return phong;
	}
	
	// Xoá 
	static void xoa(DanhSachPhong ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		PhongHoc phongXoa = null;
		
		System.out.println("Nhập mã phòng cần xoá: ");
		String maPhong = sc.nextLine();
		phongXoa = ds.timKiemObj(maPhong);
		if(phongXoa != null)
		{
			System.out.println("Bạn có chắn chắn muốn xoá [y/n]: ");
			String acp = sc.nextLine();
			if(acp.equalsIgnoreCase("y"))
			{
				ds.xoa(phongXoa);
				System.out.println("Xoá thành công!");
			}else
				System.out.println("Bạn đã huỷ thao tác xoá!");
		}else
		 System.out.println("Phòng hiện không tồn tại!");
	}
	
	// Sửa 
	static void sua(DanhSachPhong ds) {
		Scanner sc = new Scanner(System.in);
		PhongHoc phongSua = null;
		int chon = -1;
		
		System.out.println("Nhập mã phòng cần sửa: ");
		String maPhong = sc.nextLine();
		
		phongSua = ds.timKiemObj(maPhong);
		if(phongSua != null)
		{
			System.out.println("Thông tin trước khi sửa: " + phongSua);
			
			if(phongSua instanceof PhongThiNghiem)
			{
				PhongThiNghiem ptn = (PhongThiNghiem) phongSua;
				do {
					menuSuaPTN();
					System.out.println("--> Chọn chức năng: ");
					chon = sc.nextInt();
					
					thucHienMenuSua(chon, ptn);
				} while (chon != 7);
			} 
			else if(phongSua instanceof PhongLyThuyet)
			{
				PhongLyThuyet plt = (PhongLyThuyet) phongSua;
				do {
					menuSuaPLT();
					System.out.println("--> Chọn chức năng: ");
					chon = sc.nextInt();
					
					thucHienMenuSua(chon, plt);
				} while (chon != 5);
			}
			else
			{
				PhongMayTinh pmt = (PhongMayTinh) phongSua;
				do {
					menuSuaPMT();
					System.out.println("--> Chọn chức năng: ");
					chon = sc.nextInt();
					
					thucHienMenuSua(chon, pmt);
				} while (chon != 5);
			}
		}else
			System.out.println("Không tồn tại mã phòng này!");
	}
	
	// Thực hiện sửa PMT và PLT
	static void thucHienMenuSua(int chon, PhongHoc p) {
		Scanner sc = new Scanner(System.in);
		
		switch (chon) {
		case 1:
			System.out.println("Dãy nhà: ");
			p.setDayNha(sc.nextLine());
			break;
		case 2:
			System.out.println("Diện tích: ");
			p.setDienTich(sc.nextDouble());
			sc.nextLine();
			break;
		case 3:
			System.out.println("Số bóng đèn: ");
			p.setSoBongDen(sc.nextInt());
			sc.nextLine();
			break;
		}
		
		if(p instanceof PhongMayTinh)
		{
			switch (chon) {
			case 4:
				System.out.println("Số lượng máy tính: ");
				((PhongMayTinh) p).setSoLuongMayTinh(sc.nextInt());
				sc.nextLine();
				break;
			case 5:
				System.out.println("Thoát! Quay trở về menu chính.");
				break;
			}
		} 
		else if(p instanceof PhongLyThuyet)
		{
			switch (chon) {
			case 4:
				System.out.println("Có máy chiếu [true/false]: ");
				((PhongLyThuyet) p).setCoMayChieu(sc.nextBoolean());
				break;
			case 5:
				System.out.println("Thoát! Quay trở về menu chính.");
				break;
			}
		} 
		else if(p instanceof PhongThiNghiem)
		{
			switch (chon) {
			case 4:
				System.out.println("Chuyên ngành: ");
				((PhongThiNghiem) p).setChuyenNganh(sc.nextLine());
				break;
			case 5:
				System.out.println("Sức chứa: ");
				((PhongThiNghiem) p).setSucChua(sc.nextInt());
				sc.nextLine();
				break;
			case 6:
				System.out.println("Có bồn rửa [true/false]: ");
				((PhongThiNghiem) p).setCoBonRua(sc.nextBoolean());
				break;
			case 7:
				System.out.println("Thoát! Quay trở về menu chính.");
				break;
			}
		}
	}
		
	
	// Danh sách all phòng
	static void xuat(DanhSachPhong ds) {
		for (PhongHoc p : ds.getDSPhongHoc()) {
			System.out.println(p);
		}
	}
	// Danh sách phòng có 60 máy của phòng MT
	static void xuatDSPhong60May(DanhSachPhong ds) {
		for (PhongHoc pmt : ds.getDSPhongCo60May()) {
			System.out.println(pmt);
		}
	}
	// Danh sách phòng đạt chuẩn
	static void xuatDSPhongDatChuan(DanhSachPhong ds) {
		for (PhongHoc pdc : ds.getDSPhongDatChuan()) {
			System.out.println(pdc);
		}
	}
	
	// Menu PTN
		static void menuSuaPTN() {
			System.out.println("\n\n\t************************************************");
			System.out.println("\t** Sửa thông tin [Phòng thí nghiệm]               **");
			System.out.println("\t*1. Dãy nhà                                        *");
			System.out.println("\t*2. Diện tích                                      *");
			System.out.println("\t*3. Số bóng đèn                                    *");
			System.out.println("\t*4. Chuyên ngành                                   *");
			System.out.println("\t*5. Sức chứa                                       *");
			System.out.println("\t*6. Có bồn rửa                                     *"); 
			System.out.println("\t*7. Thoát!                                         *"); 
			System.out.println("\t****************************************************");
		}
		
		// Menu PMT
		static void menuSuaPMT() {
			System.out.println("\n\n\t************************************************");
			System.out.println("\t** Sửa thông tin [Phòng máy tính]                 **");
			System.out.println("\t*1. Dãy nhà                                        *");
			System.out.println("\t*2. Diện tích                                      *");
			System.out.println("\t*3. Số bóng đèn                                    *");
			System.out.println("\t*4. Số lượng máy tính                              *");
			System.out.println("\t*5. Thoát!                                         *"); 
			System.out.println("\t****************************************************");
		}	
		
		// Menu PLT
		static void menuSuaPLT() {
			System.out.println("\n\n\t************************************************");
			System.out.println("\t** Sửa thông tin [Phòng lý thuyết]                **");
			System.out.println("\t*1. Dãy nhà                                        *");
			System.out.println("\t*2. Diện tích                                      *");
			System.out.println("\t*3. Số bóng đèn                                    *");
			System.out.println("\t*4. Có máy chiếu                                   *");
			System.out.println("\t*5. Thoát!                                         *"); 
			System.out.println("\t****************************************************");
		}
	
	// Menu
	static void menu() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ PHÒNG HỌC                 **");
		System.out.println("*1. Nhập cứng                                       *");
		System.out.println("*2. Thêm 1 phòng                                    *");
		System.out.println("*3. Xoá                                             *");
		System.out.println("*4. Cập nhật thông tin phòng                        *");
		System.out.println("*5. Tìm kiếm phòng                                  *");
		System.out.println("*6. Xuất                                            *");
		System.out.println("*7. Xuất danh sách phòng có 60 máy của [phòng MT]   *");
		System.out.println("*8. Xuất danh sách phòng đạt chuẩn                  *");
		System.out.println("*9. Sắp xếp tăng dần theo [dãy nhà]                 *");
		System.out.println("*10. Sắp xếp giảm dần theo [diện tích]              *");
		System.out.println("*11. Sắp xếp tăng dần theo [số bóng đèn]            *");
		System.out.println("*12. Tổng số phòng học có trong danh sách           *");
		System.out.println("*13. Thoát!                                         *");
		System.out.println("*****************************************************");
	}

	static void tieuDe() {
		String str = "";
		str += String.format("%10s%-15s%10s%15s", "Mã phòng", "  Dãy nhà", "Diện tích", "Số bóng đèn");
		System.out.println(str);
	}
	
	static void inTieuDeCot(int chon) {
		String str = "";
		
		if(chon == 7)
		{
			str += String.format("%10s%-15s%10s%15s", "Mã phòng", "  Dãy nhà", "Diện tích", "Số bóng đèn");             
			str += String.format("%10s", "       Số máy tính");
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





















