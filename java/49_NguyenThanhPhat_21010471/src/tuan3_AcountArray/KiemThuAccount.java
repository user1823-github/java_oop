package tuan3_AcountArray;

import java.util.Arrays;
import java.util.Scanner;

public class KiemThuAccount {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		DSListAccount ds = new DSListAccount(5);

		int chon = 0;
		try {
			do {
				menuChuongTrinh();
				System.out.println("--> Mời bạn nhập lựa chọn: ");
				chon = sc.nextInt();
				switch (chon) {
				case 1: {
					taoCungAccount(ds);
					break;
				}
				case 2: {
					Account accMem = taoMemAccount(ds);
					if(accMem != null)
						ds.themAccount(accMem);
					else
						System.out.println("Thêm không thành công!");
					break;
				}
				case 3: {
					napTienAccount(ds);
					break;
				}
				case 4: {
					rutTienAccount(ds);
					break;
				}
				case 5: {
					chuyenTienAccount(ds);
					break;
				}
				case 6: {
					daoHanAccount(ds);
					break;
				}
				case 7: {
					inTieuDeCot();
					inDanhSach(ds);
					break;
				}
				case 8: {
					Account accDeSua = sua(ds);
					if(accDeSua != null)
						ds.suaAccount(accDeSua);
					else
						System.out.println("Sửa không thành công!");
					break;
				}
				case 9: {
					xoa(ds);
					break;
				}
				case 10: {
					timKiem(ds);
					break;
				}
				case 11: {
					// Sắp xếp tiền Acc tăng dần
					System.out.println("Sắp xếp tăng dần tiền Account!");
					ds.sortTienAccount();
					break;
				}
				case 12: {
//					 Sắp xếp tên Acc theo A, B, C
					System.out.println("Sắp xếp tăng dần tựa Account!");
					ds.sortTenAccount();
					break;
				}
				case 13: {
					// Sắp xếp theo Comparable
					int soPTThuc = ds.slHienTai;
					Account[] toanMang = null;
					Account[] mangChuaPTThuc = null;
					toanMang = ds.getDSAcc();
					mangChuaPTThuc = new Account[soPTThuc];
					for (int i = 0; i < soPTThuc; i++) {
						mangChuaPTThuc[i] = toanMang[i];
					}
					Arrays.sort(mangChuaPTThuc);
					System.out.println("Mảng sau khi sắp xếp: ");
					inTieuDeCot();
					xuatMangDaSapXep(mangChuaPTThuc, soPTThuc);
					break;
				}
				case 14: {
					System.out.println("==> Bạn đã thoát chương trình!");
					break;
				}
				default:
					System.out.println("--> Bạn nhập lựa chọn sai! Nhập lại: ");
					break;
				}
			}while(chon != 14);
		} catch (ArithmeticException e) {
			System.out.println("Không được chia cho không: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Lỗi mảng quá size array: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Lỗi không xác định: " + e.getMessage());
		}
}	

	// Tạo cứng 
	static void taoCungAccount(DSListAccount ds) throws Exception {
		Account acc1 = new Account(1, "Account C", 2000000);
		ds.themAccount(acc1);
		Account acc2 = new Account(2, "Account A", 1000000);
		ds.themAccount(acc2);
		Account acc3 = new Account(3, "Tài khoản D", 50000);
		ds.themAccount(acc3);
		Account acc4 = new Account(4, "Tài khoản a", 3000000);
		ds.themAccount(acc4);
		Account acc5 = new Account(5, "Tài khoản B", 100000);
		ds.themAccount(acc5);
		
	}
	// Tạo mềm, thêm
	static Account taoMemAccount(DSListAccount ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		Account taoMem = null;
		long soTK;
		String tenTK;
		double tienTK;
		
		System.out.println("==> Tạo mềm Account ===");
		System.out.println("Nhập số tài khoản cần thêm: ");
		soTK = sc.nextLong();
		sc.nextLine();
		
		int vt = ds.timKiemAcc(soTK);
		if(vt == -1)
		{
			System.out.println("Nhập tên chủ thẻ: ");
			tenTK = sc.nextLine();
			System.out.println("Nhập số tiền cho tài khoản: ");
			tienTK = sc.nextDouble();
			
			taoMem = new Account(soTK, tenTK, tienTK);
			System.out.println("=> Thêm tài khoản vào danh sách thành công!");
		}else
			System.out.println("Số tài khoản đã tồn tại!");
		
		return taoMem;
	}
	
	// Menu
	static void menuChuongTrinh() {
		System.out.println("\n\t***************************************************************************");
		System.out.println("\t**        \tCHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN \t\t\t\t **");
		System.out.println("\t* 1. Tạo cứng                                    \t\t\t  *");
		System.out.println("\t* 2. Tạo mềm (Thêm)                              \t\t\t  *");
		System.out.println("\t* 3. Nạp tiền                                    \t\t\t  *");
		System.out.println("\t* 4. Rút tiền                                    \t\t\t  *");
		System.out.println("\t* 5. Chuyển tiển (Tạo Account mềm/cứng trước khi chọn)  \t\t  *");
		System.out.println("\t* 6. Đáo hạn                                    \t\t\t  *");
		System.out.println("\t* 7. Xuất danh sách các Account                 \t\t\t  *");
		System.out.println("\t* 8. Sửa                                         \t\t\t  *");
		System.out.println("\t* 9. Xoá                                         \t\t\t  *");
		System.out.println("\t* 10. Tìm kiếm                                   \t\t\t  *");
		System.out.println("\t* 11. Sắp xếp tiền Account tăng dần              \t\t\t  *");
		System.out.println("\t* 12. Sắp xếp tên Account tăng dần theo chữ cái A, B, C  \t\t  *");
		System.out.println("\t* 13. Sắp xếp danh sách Account theo 2 thuộc tính \t\t\t  *");
		System.out.println("\t* 14. Thoát!                                      \t\t\t  *");
		System.out.println("\t***************************************************************************\n");
	}
	
	// Nạp tiền
	static void napTienAccount(DSListAccount ds) {
		Scanner sc = new Scanner(System.in);
		Account accNap = null;
		long soTK;
		double tienNap;
		
		System.out.println("Nhập số tài khoản cần nạp: ");
		soTK = sc.nextLong();
		int vt = ds.timKiemAcc(soTK);
		if(vt != -1)
		{
			System.out.println("--> Bạn muốn nạp bao nhiêu tiền: ");
			tienNap = sc.nextDouble();

			// Kiểm tra
			if(tienNap > 0)
			{
				accNap = ds.getDSAcc()[vt];
				if(ds.napTienAccount(accNap, tienNap))
					System.out.println("\t\t==============Nạp tiền thành công!==============");
				else
					System.out.println("\t\t============Nạp tiền không thành công!==========");
			}else
				System.out.println("Tiền nạp phải > 0");
		}else
			System.out.println("Số tài khoản không tồn tại!");
	}
	
	// Rút tiền
	static void rutTienAccount(DSListAccount ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		Account accRut = null;
		double tienRut;
		long soTK;
		
		System.out.println("Nhập số tài khoản muốn rút: ");
		soTK = sc.nextLong();
		int vt = ds.timKiemAcc(soTK);
		
		if(vt != -1)
		{
			System.out.println("--> Bạn muốn rút bao nhiêu tiền: ");
			tienRut = sc.nextDouble();
			
			// Kiểm tra
			if(tienRut > 0)
			{
				accRut = ds.getDSAcc()[vt];
				ds.rutTienAccount(accRut, tienRut);
				System.out.println("\t\t==============Rút tiền thành công!==============");	
			}else
			{
				System.out.println("\t\t===========Rút tiền không thành công, Số tiền rút ra phải > 0!===========");
			}
		}else
			System.out.println("Số tài khoản không tồn tại!");
	}
	
	// Chuyển tiền
	static void chuyenTienAccount(DSListAccount ds) {
		Scanner sc = new Scanner(System.in);
		long soTKChuyen, soTKNhan;
		int vtTKChuyen, vtTKNhan;
		double tienChuyen;
		Account accChuyen = null, accNhan = null;
		System.out.println("Nhập số tài khoản chuyển: ");
		soTKChuyen = sc.nextLong();
		vtTKChuyen = ds.timKiemAcc(soTKChuyen);
		System.out.println("Nhập số tài khoản nhận: ");
		soTKNhan = sc.nextLong();
		vtTKNhan = ds.timKiemAcc(soTKNhan);
		
		if(vtTKChuyen != -1)
		{
			if(vtTKNhan != -1)
			{
				System.out.println("Nhập số tiền muốn chuyển: ");
				tienChuyen = sc.nextDouble();
				if(tienChuyen > 0)
				{
					accChuyen = ds.getDSAcc()[vtTKChuyen];
					accNhan = ds.getDSAcc()[vtTKNhan];
					if(ds.chuyenTienAccount(accChuyen, accNhan, tienChuyen))
					{
						System.out.println("Chuyển tiền thành công!");
						System.out.println("==Số tiền sau khi chuyển của 2 Account là: \n");
						System.out.println("\t\t================Tài khoản chuyển=============");
						inTieuDeCot();
						System.out.println(accChuyen);
						System.out.println("\t\t================Tài khoản nhận===============");
						inTieuDeCot();
						System.out.println(accNhan);
					}else
						System.out.println("Chuyển tiền không thành công!");
				}else
					System.out.println("Số tiền chuyển phải > 0");
			}else
				System.out.println("Số tài khoản nhận không tồn tại!");
		}else if(vtTKChuyen == -1 && vtTKNhan != -1)
			System.out.println("Số tài khoản chuyển không tồn tại!");
		else
			System.out.println("Số tài khoản chuyển và nhận không tồn tại!");
	}
	
	// Đáo hạn
	static void daoHanAccount(DSListAccount ds) {
		Scanner sc = new Scanner(System.in);
		Account accDaoHan = null;
		
		long soTKDao;
		int vt;
		
		System.out.println("Nhập số tài khoản đáo hạn: ");
		soTKDao = sc.nextLong();
		vt = ds.timKiemAcc(soTKDao);
		
		if(vt != -1)
		{
			accDaoHan = ds.getDSAcc()[vt];
			if(ds.daoHanAccount(accDaoHan))
			{
				System.out.println("\t\t============Đáo hạn thành công!=============");
			}else
				System.out.println("\t\t============Đáo hạn không thành công, số tiền trong Account phải > 0!=============");
		}else
			System.out.println("Số tài khoản không tồn tại!");
	}
	
	// Sửa
	static Account sua(DSListAccount ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		Account accSua = null;
		long soTK;
		String tenTK = null;
		double tienTK = 0;
		int chon= -1;
		
		System.out.println("Nhập số tài khoản cần sửa: ");
		soTK = sc.nextLong();
		
		int vt = ds.timKiemAcc(soTK);
		// Tìm thấy
		if(vt != -1)
		{
			accSua = ds.getDSAcc()[vt];
			System.out.println("Thông tin về Account chưa sửa của bạn: ");
			inTieuDeCot();
			System.out.println(accSua);
			do {
				menuSua();
				System.out.println("Nhập lựa chọn: ");
				chon = sc.nextInt();
				sc.nextLine();
				
				switch (chon) {
					case 1:
						System.out.println("Nhập số tài khoản mới: ");
						soTK = sc.nextLong();
						accSua.setSoTaiKhoan(soTK);
						break;
					case 2:
						System.out.println("Nhập tên chủ thẻ mới: ");
						tenTK = sc.nextLine();
						accSua.setTenTK(tenTK);
						break;
					case 3:
						System.out.println("Nhập số tiền mới: ");
						tienTK = sc.nextDouble();
						accSua.setTienTK(tienTK);
						break;
					case 4:
						ds.suaAccount(accSua);
						System.out.println("Đã sửa thành công!\n=> Đã thoát menu sửa");
						break;
					default:
						System.out.println("--> Nhập lựa chọn sai! Nhập lại:");
						break;
				}
			}while(chon < 4);
		}else
			System.out.println("Không tìm thấy Account để sửa");
		return accSua;
	}
	
	// Xoá
	static void xoa(DSListAccount ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		Account accXoa = null;
		long soTK = 0;
		System.out.println("Nhập số tài khoản cần xoá: ");
		soTK = sc.nextLong();
		sc.nextLine();
		
		int vt = ds.timKiemAcc(soTK);
		if(vt != -1)
		{
			String acp;
			System.out.println("\nBạn có chắc chắn muốn xoá Account này khỏi danh sách [y/n]: ");
			acp = sc.nextLine();
			
			// Kiểm tra đồng ý / không đồng ý
			if(acp.equals("y") || acp.equals("Y"))
			{
				accXoa = ds.getDSAcc()[vt];
				ds.xoaAccount(accXoa);
				System.out.println("Xoá thành công!");
			}else {
				System.out.println("Xoá không thành công!");
			}
		}else
			System.out.println("Không tìm thấy Account để xoá!");
	}
	
	static void menuSua() {
		System.out.println("********************************************");
		System.out.println("** \t\t MENU SỬA ACCOUNT \t\t **");
		System.out.println("* 1. Sửa số tài khoản \t*");
		System.out.println("* 2. Sửa tên chủ thể \t*");
		System.out.println("* 3. Sửa tiền tài khoản \t*");
		System.out.println("* 4. Cập nhật và thoát Menu sửa\t*");
		System.out.println("********************************************");
	}
	
	// Tìm kiếm
	static void timKiem(DSListAccount ds) {
		Scanner sc = new Scanner(System.in);
		long soTK;
		System.out.println("Nhập số tài khoản cần tìm: ");
		soTK = sc.nextLong();
		int vt = ds.timKiemAcc(soTK);
		if(vt != -1)
		{
			System.out.println("Account của bạn nằm ở vị trí thứ: " + (ds.timKiemAcc(soTK) + 1));
		}else
			System.out.println("Số tài khoản không tồn tài!");
	}
	
	static void inDanhSach(DSListAccount ds) {
		for (int i = 0; i < ds.slHienTai; i++) {
			System.out.println(ds.getDSAcc()[i]);
		}
	}
	
	static void xuatMangDaSapXep(Account[] ds, int soPTThuc) {
		for (int i = 0; i < soPTThuc; i++) {
			System.out.println(ds[i]);
		}
	}
	
	
	// Tiêu đề cột
	static void inTieuDeCot() {
		String str;
		str = String.format("%15s%-35s%15s", "Số tài khoản", " Tên tài khoản", "Tiền tài khoản");
		System.out.println(str);
	}
	
}
























