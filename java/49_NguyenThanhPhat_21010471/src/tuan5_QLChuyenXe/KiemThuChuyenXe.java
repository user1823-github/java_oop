package tuan5_QLChuyenXe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class KiemThuChuyenXe {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		DanhSachChuyenXe ds = new DanhSachChuyenXe();
		int chon = -1;
		
		do {
			menu();
			System.out.println("Mời bạn nhập lựa chọn: ");
			chon = sc.nextInt(); 
			
			switch (chon) {
				case 1:
					nhapCung(ds);
					break;
				case 2:
					ChuyenXe nhapMemCXe = nhapMem(ds);
					if(nhapMemCXe != null)
					{
						ds.themChuyenXe(nhapMemCXe);
					}else
						System.out.println("Thêm chuyến xe không thành công");
					break;
				case 3:
					sua(ds);
					break;
				case 4:
					xoa(ds);
					break;
				case 5:
					inTieuDeCot(chon);
					xuatDSChuyenXe(ds);
					break;
				case 6:
					inTieuDeCot(chon);
					xuatDSNoiThanh(ds);
					break;
				case 7:
					inTieuDeCot(chon);
					xuatDSNgoaiThanh(ds);
					break;
				default:
					break;
			}
		}while(chon != 10);
	}
	
	static void nhapCung(DanhSachChuyenXe ds) throws Exception {
		ChuyenXe c1 = new NoiThanh("001", "Nguyễn Thành Phát", 11, 7000000, 3, 5000);
		ChuyenXe c2 = new NoiThanh("002", "Trần Quốc Minh", 5, 5000000, 2, 3500);
		ds.themChuyenXe(c1);
		ds.themChuyenXe(c2);
		
		ChuyenXe c3 = new NgoaiThanh("003", "Đàm Anh Khoa", 4, 5000000, "TP.HCM", 3);
		ChuyenXe c4 = new NgoaiThanh("004", "Trần Quốc Minh", 6, 5000000, "Hà Nội", 4);
		ds.themChuyenXe(c3);
		ds.themChuyenXe(c4);
		
	}
	
	static ChuyenXe nhapMem(DanhSachChuyenXe ds) {
		Scanner sc = new Scanner(System.in);
		ChuyenXe cxe = null; 
		
		String maChuyen, tenTaiXe;
		int soXe;
		double doanhThu;
		
		System.out.println("Nhập mã chuyến xe: ");
		maChuyen = sc.nextLine();
		int vt = ds.timKiemViTri(maChuyen);
		
		if(vt == -1)
		{
			System.out.println("Nhập tên tài xế: ");
			tenTaiXe = sc.nextLine();
			System.out.println("Số xe: ");
			soXe = sc.nextInt();
			System.out.println("Doanh thu: ");
			doanhThu = sc.nextDouble();
			
			System.out.println("=> Chọn xe: Nội thành [1], Ngoại Thành [số bất kì] <=");
			int chon = sc.nextInt();
			
			if(chon == 1)
			{
				int soTuyen, soKmDiDuoc;
				System.out.println("=== Nhập cho xe Nội thành ===");

				System.out.println("Nhập số tuyến: ");
				soTuyen = sc.nextInt();
				System.out.println("Số km đi được: ");
				soKmDiDuoc = sc.nextInt();
				
				cxe = new NoiThanh(maChuyen, tenTaiXe, soXe, doanhThu, soTuyen, soKmDiDuoc);                 
				
			}else
			{
				String noiDen;
				int soNgayDiDuoc;
				sc.nextLine();
				
				System.out.println("=== Nhập cho xe Ngoại thành ===");
				System.out.println("Nhập nơi đến:");
				noiDen = sc.nextLine();
				System.out.println("Nhập số ngày đi được");
				soNgayDiDuoc = sc.nextInt();
				
				cxe = new NgoaiThanh(maChuyen, tenTaiXe, soXe, doanhThu, noiDen, soNgayDiDuoc);
			}
		}
		return cxe;
	}
	
	// Sửa
	static void sua(DanhSachChuyenXe ds) {
		Scanner sc = new Scanner(System.in);
		int chon = -1;
		System.out.println("Nhập mã chuyến xe cần sửa: ");
		String maCXe = sc.nextLine();
		
		ChuyenXe xe = ds.timKiemObj(maCXe);
		
		if(xe != null)
		{
			if(xe instanceof NoiThanh)
			{
				NoiThanh xeNoi = (NoiThanh) xe;
				System.out.println("Thông tin xe trước khi sửa: " + xeNoi);
				do {
					menuSuaNoiThanh();
					System.out.println("Nhập lựa chọn: ");
					chon = sc.nextInt();
					
					switch (chon) {
					case 1:
						System.out.println("Nhập họ tên: ");
						xeNoi.setTenTaiXe(sc.nextLine());
						break;
					case 2:
						System.out.println("Nhập số xe: ");
						xeNoi.setsoXe(sc.nextInt());
						break;						
					case 3:
						System.out.println("Doanh thu: ");
						xeNoi.setDoanhThu(sc.nextDouble());
						break;
					case 4:
						System.out.println("Số tuyến: ");
						xeNoi.setSoTuyen(sc.nextInt());
						break;
					case 5:
						System.out.println("Số km đi được: ");
						xeNoi.setSoKmDiDuoc(sc.nextInt());
						break;							
					default:
						System.out.println("Bạn đã thoát chương trình!");
						System.out.println("Quay trở lại menu chính");
						break;
					}
					
				} while (chon != 6);
			}
			else if(xe instanceof NgoaiThanh)
			{
				NgoaiThanh xeNgoai = (NgoaiThanh) xe;
				System.out.println("Thông tin xe trước khi sửa: " + xeNgoai);
				
				do {
					menuSuaNgoaiThanh();
					System.out.println("Nhập lựa chọn: ");
					chon = sc.nextInt();
					
					switch (chon) {
					case 1:
						System.out.println("Nhập họ tên: ");
						xeNgoai.setTenTaiXe(sc.nextLine());
						break;
					case 2:
						System.out.println("Nhập số xe: ");
						xeNgoai.setsoXe(sc.nextInt());
						break;						
					case 3:
						System.out.println("Doanh thu: ");
						xeNgoai.setDoanhThu(sc.nextDouble());
						break;
					case 4:
						System.out.println("Nơi đến: ");
						xeNgoai.setNoiDen(sc.nextLine());
						break;
					case 5:
						System.out.println("Số ngày đi được: ");
						xeNgoai.setSoNgayDiDuoc(sc.nextInt());
						break;							
					default:
						System.out.println("Bạn đã thoát chương trình!");
						System.out.println("Quay trở lại menu chính");
						break;
					}
					
				} while (chon != 6);
			}
		}else
			System.out.println("Sửa thông tin chuyến xe không thành công");
	}
	
	// Xoá
	static void xoa(DanhSachChuyenXe ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã chuyến xe cần xoá: ");
		ChuyenXe cxeXoa = ds.timKiemObj(sc.nextLine());


		if(cxeXoa != null)
		{
			System.out.println("Bạn có chắc chắn muốn xoá không [Y/N]: ");
			String acp = sc.nextLine();
			
			if(acp.equalsIgnoreCase("y"))
			{
				ds.xoaChuyenXe(cxeXoa);
				System.out.println("Đã xoá thành công!");
			}else
				System.out.println("Bạn đã huỷ thao tác xoá!");
		}else
			System.out.println("Xoá không thành công!");
	}
	// Xuất danh sách chuyến xe
	static void xuatDSChuyenXe(DanhSachChuyenXe ds) {
		for (ChuyenXe cxe : ds.getDSChuyenXe()) {
			System.out.println(cxe);
		}
	}
	// Xuất ds Nội thành
	static void xuatDSNoiThanh(DanhSachChuyenXe ds) {
		for (ChuyenXe cxe : ds.getDSNoiThanh()) {
			System.out.println(cxe);
		}
	}
	
	// Xuất ds Ngoại thành
	static void xuatDSNgoaiThanh(DanhSachChuyenXe ds) {
		for (ChuyenXe cxe : ds.getDSNgoaiThanh()) {
			System.out.println(cxe);
		}
	}
	
	static void menu() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ CHUYẾN XE                 **");
		System.out.println("*1. Nhập cứng                                       *");
		System.out.println("*2. Thêm                                            *");
		System.out.println("*3. Sửa                                             *");
		System.out.println("*4. Xoá                                             *");
		System.out.println("*5. Xuất                                            *");
		System.out.println("*6. Xuất chuyến xe nội thành                        *");
		System.out.println("*7. Xuất chuyến xe ngoại thành                      *");
		System.out.println("*8. Tìm kiếm                                        *");
		System.out.println("*9. Sắp xếp                                         *");
		System.out.println("*10. Thoát!                                         *");
		System.out.println("*****************************************************");
	}

	static void menuSuaNoiThanh() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t SỬA CHUYẾN XE NỘI THÀNH                 **");
		System.out.println("*1. Họ tên tài xế                                    *");
		System.out.println("*2. Số xe                                            *");
		System.out.println("*3. Doanh thu                                        *");
		System.out.println("*4. Số tuyến                                         *");
		System.out.println("*5. Số km đi được                                    *");
		System.out.println("*6. Thoát!                                           *");
		System.out.println("*****************************************************");
	}
	
	static void menuSuaNgoaiThanh() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t SỬA CHUYẾN XE NGOẠI THÀNH               **");
		System.out.println("*1. Họ tên tài xế                                    *");
		System.out.println("*2. Số xe                                            *");
		System.out.println("*3. Doanh thu                                        *");
		System.out.println("*4. Nơi đến                                          *");
		System.out.println("*5. Số ngày đi được                                  *");
		System.out.println("*6. Thoát!                                           *");
		System.out.println("*****************************************************");
	}
	
	static void inTieuDeCot(int chon) {
		String str = "";
		
		if(chon == 6)
		{
			str += String.format("%17s%-25s %8s %18s", "Mã số chuyến", " Họ tên", "Số xe", "Doanh Thu");
			str += String.format("%15s%18s", "Số tuyến", "Số km đi được");	
			System.out.println(str);
		}else if(chon == 7)
		{
			str += String.format("%17s%-25s %8s %18s", "Mã số chuyến", " Họ tên", "Số xe", "Doanh Thu");
			str += String.format("%14s%24s", "Nơi đến", "Số ngày đi được");	
			System.out.println(str);
		}else
		{
			str += String.format("%17s%-25s %8s %18s", "Mã số chuyến", " Họ tên", "Số xe", "Doanh Thu");
			System.out.println(str);
		}
	}
	
	static void inTieuDeNoiThanh() {
		String str = "";
		str += String.format("%8s%18s", "Số tuyến", "Số km đi được");
		System.out.println(str);
	}
	
	static void inTieuDeNgoaiThanh() {
		String str = "";
		str += String.format("%-30s%18s", "Nơi đến", "Số ngày đi được");
		System.out.println(str);
	}
	
}



















