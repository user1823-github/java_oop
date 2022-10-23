package tuan4_SinhVienArray;

import java.util.Iterator;
import java.util.Scanner;

public class KiemThuSinhVienLopHocPhan {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		DanhSachLopHocPhan ds = new DanhSachLopHocPhan(3);
		
		int chon = -1;
		try {
			do {
				menu();
				System.out.println("Nhập vào lựa chọn:");
				chon = sc.nextInt();
				
				switch (chon) {
				case 1:
					System.out.println("\t\t\t============Nhập cứng lớp học phần=========");
					nhapCung(ds);
					break;
				case 2:
					System.out.println("\t\t\t============Nhập mềm lớp học phần=========");
					LopHocPhan lopHPMem = nhapMem();
					if(lopHPMem != null)
					{
						ds.themLHP(lopHPMem);
					}else
						System.out.println("Thêm không thành công!");
					break;
				case 3:
					sua(ds);
					break;
				case 4:
					xoa(ds);
					break;
				case 5:
					xuatDanhSachLHP(ds);
					break;
				case 6:
					timKiem(ds);
					break;
				case 7:
					System.out.println("\t\t======== Sắp xếp tăng dần theo tên sinh viên: ========");
					sortTenSVTheoLHP(ds);
					break;
				case 8:
					System.out.println("\t\t======== Đếm số lượng sinh viên trong 1 LHP ========");
					getSoLuongSV(ds);
					break;
				case 9:
					System.out.println("=> Bạn đã thoát chương trình!");
					break;
				default:
					break;
				}
			}while(chon != 9);
		} catch (Exception e) {
			System.out.println("Lỗi không xác định!");
		}
		
		
	}
	
	static void nhapCung(DanhSachLopHocPhan ds) throws Exception {
		SinhVien dssv1[] = new SinhVien[2];
		SinhVien dssv2[] = new SinhVien[3];
		
		dssv1[0] = new SinhVien("1", "C Nguyễn Thành Phát");
		dssv1[1] = new SinhVien("2", "B Đặng Quanh Học");
		
		dssv2[0] = new SinhVien("3", "Trịnh Thanh Bình");
		dssv2[1] = new SinhVien("4", "Bùi Đức Công");
		dssv2[2] = new SinhVien("5", "Hà Anh Tuấn");
		
		LopHocPhan lhp1 = new LopHocPhan("LHP1", "17A", "Cô Bình", "Thứ 6, tiết 1-2, Phòng A2.1", dssv1);
		LopHocPhan lhp2 = new LopHocPhan("LHP2", "17C", "Thầy Linh", "Thứ 2, tiết 4-5, Phòng B2.1", dssv2);
		ds.themLHP(lhp1);
		ds.themLHP(lhp2);
	}
	
	static LopHocPhan nhapMem() throws Exception {
		Scanner sc = new Scanner(System.in);
		LopHocPhan lopHPMem = null;
		SinhVien svMem = null;
		
		int sl = 0;
		System.out.println("Nhập số lượng sinh viên cần thêm vào lớp học phần: ");
		sl = sc.nextInt();
		sc.nextLine();
		SinhVien dssv[] = new SinhVien[sl];
		
		String maSV, hoTen;
		String maLHP, tenLHP, tenGV, thongTinLopHoc;
		
		System.out.println("Nhập mã lớp học phần: ");
		maLHP = sc.nextLine();
		System.out.println("Nhập tên lớp học phần: ");
		tenLHP = sc.nextLine();
		System.out.println("Nhập tên giáo viên: ");
		tenGV = sc.nextLine();
		System.out.println("Nhập thông tin lớp học: ");
		thongTinLopHoc = sc.nextLine();
		
		for (int i = 0; i < sl; i++) {
			System.out.println("Nhập mã sinh viên cần thêm thứ " + (i+1) + ": " );
			maSV = sc.nextLine();
			System.out.println("Họ tên sinh viên: ");
			hoTen = sc.nextLine();
			dssv[i] = new SinhVien(maSV, hoTen);
		}
		
		lopHPMem = new LopHocPhan(maLHP, tenLHP, tenGV, thongTinLopHoc, dssv);
		return lopHPMem;
	}
	
	static void sua(DanhSachLopHocPhan ds) {
		Scanner sc = new Scanner(System.in);
		LopHocPhan lhpSua = null;
		System.out.println("Nhập mã lớp học phần cần sửa: ");
		String str = sc.nextLine();
		int chon = 0;
		
		int vt = ds.timKiem(str);
		if(vt != - 1)
		{
			lhpSua = ds.getDanhSachLHP()[vt];
			do {
				menuSuaLHP();
				System.out.println("\t\t======= THÔNG TIN TRƯỚC KHI SỬA LHP =========");
				System.out.println(lhpSua);
				System.out.println(lhpSua.getDSSV());
				
				System.out.println("--> Nhập lựa chọn: ");
				chon = sc.nextInt();
				sc.nextLine();
				switch (chon) {
				case 1:
					System.out.println("Nhập tên LHP: ");
					lhpSua.setMaLHP(sc.nextLine());
					break;
				case 2:
					System.out.println("Tên giáo viên: ");
					lhpSua.setTenGV(sc.nextLine());
					break;
				case 3:
					System.out.println("Thông tin lớp học: ");
					lhpSua.setThongTinLopHoc(sc.nextLine());
					break;
				default:
					System.out.println("Quay về menu chính");
					System.out.println("Sửa lớp học phần thành công!");
					break;
				}
			} while (chon != 4);
		}else
			System.out.println("Sửa lớp học phần không thành công!");
	}
	
	static void xoa(DanhSachLopHocPhan ds) {
		Scanner sc = new Scanner(System.in);
		LopHocPhan lhpXoa = null;
		
		System.out.println("Nhập mã LHP cần xoá: ");
		String maLHP = sc.nextLine();
		
		int vt = ds.timKiem(maLHP);
		if(vt != -1) 
		{
			lhpXoa =  ds.getDanhSachLHP()[vt];
			System.out.println("Bạn có chắc chắn muốn xoá [Y/N]: ");
			String acp = sc.nextLine();
			
			if(acp.equalsIgnoreCase("y"))
			{
				ds.xoaLHP(lhpXoa);
				System.out.println("Đã xoá thành công!");
			}else
				System.out.println("Bạn đã huỷ thao tác xoá!");
		}else
			System.out.println("Xoá không thành công!");
	}
	
	static void timKiem(DanhSachLopHocPhan ds) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tìm kiếm vị trí của LHP: ");
		int vt = ds.timKiem(sc.nextLine());
		System.out.println("Lớp học phần nằm vị trí số: " + (vt+1));
	}
	
	// Danh sách LHP
	static void xuatDanhSachLHP(DanhSachLopHocPhan ds) {
		inTieuDeCotLHP();
		System.out.println(ds.getDSToStringLHP());
	}
	
	// Số lượng sv
	static void getSoLuongSV(DanhSachLopHocPhan ds) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã LHP cần tìm: ");
		int vt = ds.timKiem(sc.nextLine());
		LopHocPhan lhpTim = ds.getDanhSachLHP()[vt];
		System.out.println("Số lượng sinh viên của LHP này là: " + lhpTim.getSoLuongSV() + " sinh viên");
	}
	
	// Sort tên sinh viên theo lớp học phần
	static void sortTenSVTheoLHP(DanhSachLopHocPhan ds) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên LHP cần sắp xếp danh sách sinh viên: ");
		int vt = ds.timKiem(sc.nextLine());
		LopHocPhan lhpSort = ds.getDanhSachLHP()[vt];
		lhpSort.sortTheoTenSV();
	}
	
	static void menu() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t QUẢN LÝ LỚP HỌC PHẦN              **");
		System.out.println("*1. Nhập cứng LHP                                   *");
		System.out.println("*2. Thêm LHP                                        *");
		System.out.println("*3. Sửa                                             *");
		System.out.println("*4. Xoá                                             *");
		System.out.println("*5. Xuất danh sách LHP                              *");
		System.out.println("*6. Tìm kiếm LHP                                    *");
		System.out.println("*7. Sắp xếp                                         *");
		System.out.println("*8. Số lượng sinh viên trong 1 lớp học phần         *");
		System.out.println("*9. Thoát!                                          *");
		System.out.println("*****************************************************");
	} 
	
	static void menuSuaLHP() {
		System.out.println("\n\n*****************************************************");
		System.out.println("**\t\t SỬA LỚP HỌC PHẦN                   **");
		System.out.println("*1. Nhập tên LHP                                    *");
		System.out.println("*2. Tên giáo viên                                   *");
		System.out.println("*3. Thông tin lớp học                               *");
		System.out.println("*4. Thoát!                                          *");
		System.out.println("*****************************************************");
	}
	
	static void inTieuDeCotLHP() {
		String str;
		str = String.format("%-20s%-25s%-30s%-35s", "        Mã LHP", "Tên LHP", "GV giảng dạy", "Thông tin buổi học");
		
		System.out.println(str);
	}
	
	static void inTieuDeCotDSSinhVien() {
		String str;
		System.out.println("=> Danh sách sinh viên");
		str = String.format("%12s%-25s", "Mã SV", " | " + "Họ tên SV");
		
		System.out.print(str);
	}
}
