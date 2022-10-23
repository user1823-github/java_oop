package tuan5_HangThucPhamDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class KiemThuHangThucPham {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		DanhSachHangThucPham ds = new DanhSachHangThucPham(3);
		
		int chon = -1;
		do {
			menu();
			System.out.println("--> Mời bạn nhập lựa chọn");
			chon = sc.nextInt();
			sc.nextLine();
			
			switch (chon) {
			case 1:
				System.out.println("\t============Nhập cứng danh sách thực phẩm=========");
				nhapCung(ds);
				break;
			case 2:
				System.out.println("\t============Nhập mềm danh sách thực phẩm=========");
				HangThucPham hangTPMem = nhapMem();
				
				if(hangTPMem != null)
					ds.themHang(hangTPMem);
				else
					System.out.println("=> Thêm không thành công!");
				break;
			case 3:
				xoa(ds);
				break;
			case 4:
				sua(ds);
				break;
			case 5:
				timKiemHang(ds);
				break;
			case 6:
				System.out.println("\t============Sắp xếp giảm dần theo đơn giá=========");
				ds.sortTienGiamDan();
				break;
			case 7:
				System.out.println("\t============Sắp xếp tăng dần theo tên hàng=========");
				ds.sortTenTangDan();
				break;
			case 8:
				System.out.println("\t============Trả về danh sách sắp hết hạn=========");
				boolean checkHetHan;
				System.out.println("Nhập số ngày cần kiểm tra sắp hết hạn: ");
				int soNgayHH = sc.nextInt();
				
				inTieuDeCot();
				for (HangThucPham htp : ds.getDSSapHetHan(soNgayHH)) {
					if(htp != null)
					{
							System.out.println(htp.toString() + "\t"+ "Còn hạn: " +
						    htp.checkKhoangCachDays(htp.getNgaySXuat(), htp.getNgayHHan()) +" ngày");
					}
				}
				break;
			case 9:
				inTieuDeCot();
				xuatDSHang(ds);
				break; 
			case 10:
				int soPhanTuThuc = ds.soLuongThuc;
				HangThucPham[] toanMang;
				toanMang = ds.getDSHangTP();
				HangThucPham[] mangChuaPTThuc;
				mangChuaPTThuc = new HangThucPham[soPhanTuThuc];
				for (int i = 0; i < soPhanTuThuc; i++) {
					mangChuaPTThuc[i] = toanMang[i];
				}
				
				Arrays.sort(mangChuaPTThuc);
				System.out.println("Mảng sau khi đã sắp xếp: ");
				inTieuDeCot();
				xuatDSSapXepHaiThuocTinh(mangChuaPTThuc, soPhanTuThuc);
				break;
			case 11:
				System.out.println("=> Bạn đã thoát chương trình!");
				break;
			default:
				break;
			}
		}while(chon != 11);
		
	}
	// Nhập cứng
	@SuppressWarnings("deprecation")
	static void nhapCung(DanhSachHangThucPham ds) throws Exception {
		
		Date ngaySX = new Date(2022-1900, 7-1, 18);
		Date ngayHH = new Date(2022-1900, 8-1, 27);
		HangThucPham htp1 = new HangThucPham("001", "Gạo", 100000, ngaySX, ngayHH);
		ds.themHang(htp1);
		
		ngaySX = new Date(2022-1900, 3-1, 05);
		ngayHH = new Date(2022-1900, 4-1, 10);
		HangThucPham htp2 = new HangThucPham("002", "B Mì", 35000, ngaySX, ngayHH);
		ds.themHang(htp2);
		
		ngaySX = new Date(2022-1900, 9-1, 20);
		ngayHH = new Date(2022-1900, 10-1, 30);
		HangThucPham htp3 = new HangThucPham("003", "A Kem", 55000, ngaySX, ngayHH);
		ds.themHang(htp3);	
		
		ngaySX = new Date(2022-1900, 6-1, 20);
		ngayHH = new Date(2022-1900, 6-1, 25);
		HangThucPham htp4 = new HangThucPham("004", "D Chuối", 15000, ngaySX, ngayHH);
		ds.themHang(htp4);
	}
	// Nhập mềm
	static HangThucPham nhapMem() throws ParseException {
			Scanner sc = new Scanner(System.in); 
			HangThucPham htpThem = new HangThucPham();

			String maHang, tenHang, ngaySanXuat, ngayHetHan;
			double donGia;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out.println("Nhập mã hàng: ");
			maHang = sc.nextLine();
			System.out.println("Nhập tên hàng: ");
			tenHang = sc.nextLine();
			System.out.println("Nhập đơn giá: ");
			donGia = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Nhập ngày sản xuất (dd/MM/yyyy): ");
			ngaySanXuat = sc.nextLine();
			Date ngaySX = (Date) sdf.parse(ngaySanXuat);
			
			System.out.println("Nhập ngày hết hạn (dd/MM/yyyy): ");
			ngayHetHan = sc.nextLine();
			Date ngayHH = (Date) sdf.parse(ngayHetHan);
			
			
			htpThem = new HangThucPham(maHang, tenHang, donGia, ngaySX, ngayHH);
			
			return htpThem;
	}
	// Xoá
	static void xoa(DanhSachHangThucPham ds) {
		Scanner sc = new Scanner(System.in); 
		HangThucPham  htpXoa = null;
		
		String maHang = "", acp;
		System.out.println("Nhập mã hàng cần xóa: ");
		maHang = sc.nextLine();
		int vt = ds.timKiem(maHang);
		
		if(vt != -1)
		{
			htpXoa = ds.getDSHangTP()[vt];
			System.out.println("Bạn có chắc chắn muốn xoa [Y/N]: ");
			acp = sc.nextLine();
			if(acp.equals("Y") || acp.equals("y"))
			{
				ds.xoaHang(htpXoa);
				System.out.println("Đã xoá thành công!");
			}else
				System.out.println("=> Bạn đã hủy thao tác xóa!");
		}
		else
			System.out.println("Xóa không thành công!");
	
	}
	// Sửa
	static void sua(DanhSachHangThucPham ds) throws Exception {
			Scanner sc = new Scanner(System.in); 
			HangThucPham htpSua = null;
			String maHang = "", ngaySanXuat, ngayHetHan;
			int chon = -1;
			
			System.out.println("Nhập mã hàng cần sửa: ");
			maHang = sc.nextLine();
			
			int vt = ds.timKiem(maHang);
			if(vt != -1)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				htpSua = ds.getDSHangTP()[vt];
				System.out.println("\t============Thông tin sản phẩm trước khi sửa============");
				System.out.println(htpSua);
				
				do {
					menuSua();
					System.out.println("--> Nhập lựa chọn: ");
					chon = sc.nextInt();
					sc.nextLine();
					
					switch (chon) {
					case 1:
						System.out.println("Nhập tên hàng mới: ");
						htpSua.setTenHang(sc.nextLine());
						break;
					case 2:
						System.out.println("Đơn giá: ");
						htpSua.setDonGia(sc.nextDouble());
						break;
					case 3:
						System.out.println("Ngày sản xuất (dd/MM/yyyy): ");
						ngaySanXuat = sc.nextLine();
						Date ngaySX = sdf.parse(ngaySanXuat);
						htpSua.setNgaySXuat(ngaySX);
						break;
					case 4:
						System.out.println("Ngày hết hạn (dd/MM/yyyy): ");
						ngayHetHan = sc.nextLine();
						Date ngayHH = sdf.parse(ngayHetHan);
						htpSua.setNgayHHan(ngayHH);
						break;
					default:
						System.out.println("Quay lại menu chính: ");
						System.out.println("==> Sửa thành công");
						break;
					}
				} while (chon != 5);
			}else
				System.out.println("==> Sửa không thành công!");
	}
	
	static void menuSua() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t SỬA HÀNG THỰC PHẨM            **");
		System.out.println("*1. Tên hàng mới:                                   *");
		System.out.println("*2. Đơn giá:                                        *");
		System.out.println("*3. Ngày sản xuất (dd/MM/yyyy)                      *");
		System.out.println("*4. Ngày hết hạn (dd/MM/yyyy)                       *");
		System.out.println("*5. Thoát                                           *");
		System.out.println("*****************************************************");
	}
	
	// Kiểm tra hạng sử dụng của các mặt hàng
	static boolean kiemTraHetHan(HangThucPham htp, int soNgayHetHan) throws Exception {
		// so sánh xem ngày nào lớn hơn
		if(htp.getNgayHHan().getTime() > htp.getNgaySXuat().getTime())
		{
			if( htp.checkKhoangCachDays(htp.getNgaySXuat(), htp.getNgayHHan()) <= soNgayHetHan)
				return true;
		}
		return false;
	}
	
	
	// Tìm kiếm
	static void timKiemHang(DanhSachHangThucPham ds) {
			Scanner sc = new Scanner(System.in); 
			String maHang;
			System.out.println("Nhập mã hàng cần tìm: ");
			maHang = sc.nextLine();
			
			int vt = ds.timKiem(maHang);
			if(vt != -1)
				System.out.println("Sản phẩm này nằm tại vị trí thứ: " + (vt+1));
			else
				System.out.println("=> Mã sản phẩm không tồn tại!");
	}
	
	static void xuatDSHang(DanhSachHangThucPham ds) {
		for (int i = 0; i < ds.soLuongThuc; i++) {
			System.out.println(ds.getDSHangTP()[i]);
		}
	}	
	
	static void xuatDSSapXepHaiThuocTinh(HangThucPham ds[], int soPTThuc) {
		for (int i = 0; i < soPTThuc; i++) {
			System.out.println(ds[i]);
		}
	}
	 
	static void menu() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ HÀNG THỰC PHẨM            **");
		System.out.println("*1. Nhập cứng                                       *");
		System.out.println("*2. Thêm (Nhập mềm)                                 *");
		System.out.println("*3. Xóa                                             *");
		System.out.println("*4. Sửa                                             *");
		System.out.println("*5. Tìm kiếm                                        *");
		System.out.println("*6. Sắp xếp giảm dần theo đơn giá                   *");
		System.out.println("*7. Sắp xếp tăng dần theo tên hàng                  *");
		System.out.println("*8. Xuất danh sách và kiểm tra hạng sử dụng         *");
		System.out.println("*9. Xuất danh sách                                  *");
		System.out.println("*10.Sắp xếp theo tên tăng dần và giá giảm dần       *");
		System.out.println("*11. Thoát                                           *");
		System.out.println("*****************************************************");
	}
	
	static void inTieuDeCot() {
		String str = "";
		str += String.format("%10s%-15s%25s%-15s%-15s%-15s", "Mã hàng", " Tên Hàng", 
				"          Đơn giá", "    Ngày sản xuất", "    Ngày hết hạn", "     Ghi chú");
		System.out.println(str);
	}
}
