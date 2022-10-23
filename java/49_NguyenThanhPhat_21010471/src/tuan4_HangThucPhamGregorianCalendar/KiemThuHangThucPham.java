package tuan4_HangThucPhamGregorianCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
			
			switch (chon) {
			case 1:
				System.out.println("\t============Nhập cứng danh sách thực phẩm=========");
				nhapCung(ds);
				break;
			case 2:
				System.out.println("\t============Nhập mềm danh sách thực phẩm=========");
				HangThucPham hangTPMem = nhapMem(ds);
				
				if(hangTPMem != null)
					ds.themHang(hangTPMem);
				else 
					System.out.println("Thêm không thành công!");
				break;
			case 3:
				boolean checkHetHan;
				System.out.println("Nhập số ngày cần kiểm tra còn hạn hay không: ");
				long soNgayHH = sc.nextLong();
				inTieuDeCot();
				for (HangThucPham htp : ds.getDSHangThucPham()) {
					if(htp != null)
					{
						long kcNgay = checkKhoangCachHaiNgay(htp);
						checkHetHan = kiemTraHetHan(htp, soNgayHH);
						if(checkHetHan == true)
							System.out.println(htp.toString() + "\t"+ "Còn hạn: " + kcNgay +" ngày");
						else
							System.out.println(htp.toString() + "\t"+ "Hàng hết hạn");
					}
				}
				break;
			case 4:
				System.out.println("=> Bạn đã thoát chương trình!");
				break;
			default:
				break;
			}
		}while(chon != 6);
		
	}
	// Nhập cứng
	static void nhapCung(DanhSachHangThucPham ds) throws Exception {
		GregorianCalendar date1 = new GregorianCalendar(2018, Calendar.SEPTEMBER, 10);
		GregorianCalendar date2 = new GregorianCalendar(2018, Calendar.OCTOBER, 18);
		GregorianCalendar date3 = new GregorianCalendar(2018, Calendar.OCTOBER, 5);
		
		GregorianCalendar date4 = new GregorianCalendar(2019, Calendar.NOVEMBER, 10);
		GregorianCalendar date5 = new GregorianCalendar(2019, Calendar.DECEMBER, 20);
		
		HangThucPham htp1 = new HangThucPham("001", "Gạo", 100000, date1, date2);
		HangThucPham htp2 = new HangThucPham("002", "Mì", 35000, date3, date2);
		HangThucPham htp3 = new HangThucPham("003", "Kem", 55000, date4, date5);
		HangThucPham htp4 = new HangThucPham("004", "Chuối", 15000, date3, date2);
		
		ds.themHang(htp1);
		ds.themHang(htp2);
		ds.themHang(htp3);
		ds.themHang(htp4);
	}
	// Nhập mềm
	static HangThucPham nhapMem(DanhSachHangThucPham ds) throws ParseException {
		Scanner sc = new Scanner(System.in);
		HangThucPham htp3 = null;

		String maHang, tenHang;
		double donGia;
		String ngaySanXuat, ngayHetHan;
		
		System.out.println("Nhập mã hàng: ");
		maHang = sc.nextLine();
		System.out.println("Nhập tên hàng: ");
		tenHang = sc.nextLine();
		System.out.println("Nhập đơn giá: ");
		donGia = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Nhập ngày sản xuất (dd/MM/yyyy): ");
		ngaySanXuat = sc.nextLine();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar ngaySX = new GregorianCalendar();
		ngaySX.setTime(sdf1.parse(ngaySanXuat));
		
		System.out.println("Nhập ngày hết hạn (dd/MM/yyyy): ");
		ngayHetHan = sc.nextLine();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar ngayHH = new GregorianCalendar();
		ngayHH.setTime(sdf2.parse(ngayHetHan));
		
		
		htp3 = new HangThucPham(maHang, tenHang, donGia, ngaySX, ngayHH);
		return htp3;
	}
	
	// Kiểm tra hạng sử dụng của các mặt hàng
	static boolean kiemTraHetHan(HangThucPham htp, long soNgayHetHan) throws Exception {
		long kcNgay = (htp.getNgayHHan().getTime().getTime() - htp.getNgaySXuat().getTime().getTime()) / (24*3600*1000);
//		System.out.println(kcNgay);
		
		// so sánh xem ngày nào lớn hơn
		if(htp.getNgayHHan().getTime().getTime() > htp.getNgaySXuat().getTime().getTime())
		{
			if(soNgayHetHan <= kcNgay)
				return true;
		}
		return false;
	}
	
	static long checkKhoangCachHaiNgay(HangThucPham htp) {
		long kcNgay = (htp.getNgayHHan().getTime().getTime() - htp.getNgaySXuat().getTime().getTime()) / (24*3600*1000);
		return kcNgay; 
	}
	
	static void xuatDSHang(DanhSachHangThucPham ds) {
		for (int i = 0; i < ds.soLuongThuc; i++) {
			System.out.println(ds.getDSHangThucPham()[i]);
		}
	}
	
	static void menu() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ HÀNG THỰC PHẨM          **");
		System.out.println("*1. Nhập cứng                                       *");
		System.out.println("*2. Nhập mềm                                        *");
		System.out.println("*3. Xuất danh sách và kiểm tra hạng sử dụng         *");
		System.out.println("*4. Thoát                                           *");
		System.out.println("*****************************************************");
	}
	
	static void inTieuDeCot() {
		String str = "";
		str += String.format("%10s%-15s%25s%-15s%-15s%-15s", "Mã hàng", " Tên Hàng", 
				"          Đơn giá", "    Ngày sản xuất", "    Ngày hết hạn", "     Ghi chú");
		System.out.println(str);
	}
}
