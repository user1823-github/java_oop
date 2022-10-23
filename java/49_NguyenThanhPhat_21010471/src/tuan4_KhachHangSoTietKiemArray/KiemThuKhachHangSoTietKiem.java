package tuan4_KhachHangSoTietKiemArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class KiemThuKhachHangSoTietKiem {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		DanhSachSoTietKiem ds = new DanhSachSoTietKiem(2);
		
		int chon = -1;
		
		do {
			menu();
			System.out.println("--> Mời bạn nhập lựa chọn: ");
			chon = sc.nextInt();
			
			switch (chon) {
			case 1:
				nhapCung();
				break;
			case 2:
				KhachHang khMem = nhapMem(ds);
				if(khMem != null)
				{
					inTieuDeCotKH();
					System.out.println(khMem);
					inTieuDeCotSoTK();
					System.out.println(khMem.getDSSoTK());
				}
				break;
			case 3:
				System.out.println("==> Cảm ơn bạn đã sử dụng dịch vụ!");
				break;
			default:
				break;
			}
		}while(chon != 3);
		
	}
	
	static void nhapCung() throws Exception {
		DateTimeFormatter dtf = null;
		DanhSachSoTietKiem ds1 = null;
		DanhSachSoTietKiem ds2 = null;
		
		SoTietKiem tk1 = new SoTietKiem("tk01", LocalDate.of(2021, 5, 13), 1000000, 6, (float)0.045);
		SoTietKiem tk2 = new SoTietKiem("tk02", LocalDate.of(2021, 4, 25), 2000000, 3, (float)0.026);

		ds1 = new DanhSachSoTietKiem(2);
		ds1.themSoTietKiem(tk1);
		ds1.themSoTietKiem(tk2);

		KhachHang kh1 = new KhachHang("KH01", "Nguyễn Văn B", ds1, 2);
		inTieuDeCotKH();
		System.out.println(kh1);
		inTieuDeCotSoTK();
		System.out.println(kh1.getDSSoTK());
		
		String repeatedStar = new String(new char[30]).replace('\0', '=');
		System.out.println(repeatedStar);
		
		SoTietKiem tk3 = new SoTietKiem("tk03", LocalDate.of(2021, 1, 3), 1500000, 3, (float)0.035);
		ds2 = new DanhSachSoTietKiem(3);
		ds2.themSoTietKiem(tk3);
		KhachHang kh3 = new KhachHang("KH03", "Nguyễn Văn C", ds2, 1);

		inTieuDeCotKH();
		System.out.println(kh3);
		inTieuDeCotSoTK();
		System.out.println(kh3.getDSSoTK());

	}
	
	static KhachHang nhapMem(DanhSachSoTietKiem ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		KhachHang khMem   = null;
		SoTietKiem stkMem = null;
		
		String maKH, hoTenKH;
		int slSoHienCo;		
		String maSo;
		String ngayMBSo;
		double soTienGoi;
		int kyHan = 0;
		float laiSuat;		
		
		System.out.println("====Nhập mềm khách hàng và sổ tiết kiệm");
		
		System.out.println("Nhập mã KH: ");
		maKH = sc.nextLine();
		System.out.println("Nhập tên KH: ");
		hoTenKH = sc.nextLine();
		System.out.println("Nhập số lượng sổ thực: ");
		slSoHienCo = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Nhập mã số của STK: ");
		maSo = sc.nextLine();
		
		// Convert String sang Localdate 
		System.out.println("Nhập ngày mở bán sổ (dd/MM/yyyy): ");
		ngayMBSo = sc.nextLine();
		LocalDate date1 = LocalDate.parse(ngayMBSo, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		// 03-01-2021
		
		System.out.println("Nhập số tiển gởi: ");
		soTienGoi = sc.nextDouble();
		System.out.println("Nhập kỳ hạn: ");
		kyHan = sc.nextInt();
		System.out.println("Nhập lãi suất: ");
		laiSuat = sc.nextFloat();
		
		stkMem = new SoTietKiem(maSo, date1, soTienGoi, kyHan, laiSuat);
		if(stkMem != null)
		{
			ds.themSoTietKiem(stkMem);
			khMem = new KhachHang(maKH, hoTenKH, ds, slSoHienCo);
		}else
			System.out.println("Tạo mềm khách hàng và sổ tiết kiệm không thành công!");
		
		return khMem;
	}
	
	
	
	static void menu() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ SỔ TIẾT KIỆM              **");
		System.out.println("*1. Nhập cứng                                       *");
		System.out.println("*2. Nhập mềm                                        *");
		System.out.println("*3. Thoát                                           *");
		System.out.println("*****************************************************");
	}
	
	
	static void inTieuDeCotKH() {
		String str = "";
		str += String.format("%20s%25s", "Mã khách hàng", "Tên khách hàng");
		System.out.println(str);
	}
	
	static void inTieuDeCotSoTK() {
		String str = "";
		System.out.println("\n==> Danh sách số tiết kiệm: ");
		str += String.format("%12s%15s%27s%15s%15s%20s%25s", "Mã số", "Ngày mở bán", "Kỳ hạn", "ST tính lãi", "Lãi suất", "Số tiền", "Tiền lãi");
		System.out.print(str);
	}
}














