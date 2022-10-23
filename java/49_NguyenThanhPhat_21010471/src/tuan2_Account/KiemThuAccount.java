package tuan2_Account;

import java.util.Scanner;

public class KiemThuAccount {
	static Account acc1;
	static Account acc2;
	static Account acc3;
	static Account accMem;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chon = 0;
		do {
			menuChuongTrinh();
			System.out.println("--> Mời bạn nhập lựa chọn: ");
			chon = sc.nextInt();
			
			switch (chon) {
			case 1: {
				inTieuDeCot();
				taoCungAccount();
				break;
			}
			case 2: {
				accMem = taoMemAccount();
				inTieuDeCot();
				System.out.println(accMem);
				break;
			}
			case 3: {
				napTienAccount(accMem);
				break;
			}
			case 4: {
				rutTienAccount(accMem);
				break;
			}
			case 5: {
				chuyenTienAccount(accMem);
				break;
			}
			case 6: {
				daoHanAccount(accMem);
				break;
			}
			case 7: {
				System.out.println("==> Bạn đã thoát chương trình!");
				break;
			}
			default:
				System.out.println("--> Bạn nhập lựa chọn sai!");
				break;
			}
		}while(chon != 7);
}	
	
	// Tạo cứng 
	static void taoCungAccount() {
		acc1 = new Account(1001, "Nguyễn Thành Phát", 1000000);
		acc2 = new Account(1002, "Đàm Anh Khoa", 2000000);
		acc3 = new Account(1002, "Lê Thị Ánh Minh", 3000000);
		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println(acc3);
	}
	// Tạo mềm
	static Account taoMemAccount() {
		Scanner sc = new Scanner(System.in);
		Account taoMem;
		long soTK;
		String tenTK, s;
		double tienTK;
		System.out.println("==> Tạo mềm Account ===");
		s = "- Mời bạn nhập số tài khoản: ";
		System.out.println(s);
		soTK = sc.nextLong();
		sc.nextLine();
		s = "- Tên tài khoản: ";
		System.out.println(s);
		tenTK = sc.nextLine();
		s = "- Tiền tài khoản: ";
		System.out.println(s);
		tienTK = sc.nextDouble();
		
		taoMem = new Account(soTK, tenTK, tienTK);
		return taoMem;
	}
	// Menu
	static void menuChuongTrinh() {
		System.out.println("\n\t***********************************************************");
		System.out.println("\t**        CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN \t\t **");
		System.out.println("\t* 1. Tạo cứng                          \t\t\t  *");
		System.out.println("\t* 2. Tạo mềm                           \t\t\t  *");
		System.out.println("\t* 3. Nạp tiền                          \t\t\t  *");
		System.out.println("\t* 4. Rút tiền                          \t\t\t  *");
		System.out.println("\t* 5. Chuyển tiển (Tạo Account mềm/cứng trước khi chọn)    *");
		System.out.println("\t* 6. Đáo hạn                           \t\t\t  *");
		System.out.println("\t* 7. Thoát!                            \t\t\t  *");
		System.out.println("\t***********************************************************\n");
	}
	// Nạp tiền
	static void napTienAccount(Account accMem) {
		Account accNap = null;
		Scanner sc = new Scanner(System.in);
		int chon = 0;
		long tienNap;
		menuChonAccount();
		System.out.println("Chọn loại tài khoản nạp: ");
		chon = sc.nextInt();
		if(chon == 1)
			accNap = acc1;
		else if(chon == 2)
			accNap = acc2;
		else if(chon == 3)
			accNap = acc3;
		else
			accNap = accMem;

		System.out.println("--> Bạn muốn nạp bao nhiêu tiền: ");
		tienNap = sc.nextLong();
		// Kiểm tra
		if(tienNap > 0)
		{
			if(accNap.napTien(tienNap) != false)
			{
				System.out.println("\t\t==============Nạp tiền thành công!==============");
				inTieuDeCot();
				System.out.println(accNap);
			}else {
				System.out.println("\t\t============Nạp tiền không thành công!==========");
			}
		}else 
			System.out.println("Số tiền nạp phải > 0");
	}
	
	static void rutTienAccount(Account accMem) {
		Scanner sc = new Scanner(System.in);
		Account accRut = null;
		int chon = 0;
		long tienRut;
		menuChonAccount();
		System.out.println("Chọn loại tài khoản rút: ");
		chon = sc.nextInt();
		
		if(chon == 1)
			accRut = acc1;
		else if(chon == 2)
			accRut = acc2;
		else if(chon == 3)
			accRut = acc3;
		else
			accRut = accMem;
		
		System.out.println("--> Bạn muốn rút bao nhiêu tiền: ");
		tienRut = sc.nextLong();
		// Kiểm tra
		if(tienRut > 0)
		{
			if(accRut.rutTien(tienRut) != false)
			{
				System.out.println("\t\t==============Rút tiền thành công!==============");
				inTieuDeCot();
				System.out.println(accRut);
			}else
				System.out.println("\t\t===========Rút tiền không thành công!===========");
		}else
			System.out.println("Số tiền rút phải > 0");
	}
	
	static void chuyenTienAccount(Account accMem) {
		Account accChuyen = null, accNhan = null;
		Scanner sc = new Scanner(System.in);
		int chonAccChuyen = 0, chonAccNhan = 0;
		long tienChuyen;
		// Chọn Account chuyển
		menuChonAccount();
		System.out.println("Chọn loại tài khoản chuyển: ");
		chonAccChuyen = sc.nextInt();
		
		if(chonAccChuyen == 1)
			accChuyen = acc1;
		else if(chonAccChuyen == 2)
			accChuyen = acc2;
		else if(chonAccChuyen == 3)
			accChuyen = acc3;
		else 
			accChuyen = accMem;
			
		// Chọn Account nhận
		menuChonAccount();
		System.out.println("Chọn loại tài khoản nhận: ");
		chonAccNhan = sc.nextInt();
		
		if(chonAccNhan == 1)
			accNhan = acc1;
		else if(chonAccNhan == 2)
			accNhan = acc2;
		else if(chonAccNhan == 3)
			accNhan = acc3;
		else 
			accNhan = accMem;
			
		System.out.println("--> Bạn muốn chuyển bao nhiêu tiền: ");
		tienChuyen = sc.nextLong();
		if(tienChuyen > 0)
		{
			if(accChuyen.chuyenTien(accNhan, tienChuyen) != false)
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
			System.out.println("Tiền chuyển phải > 0");
	}
	// Đáo hạn
	static void daoHanAccount(Account accMem) {
		Account accDaoHan = null;
		Scanner sc = new Scanner(System.in);
		int chon = 0;
		System.out.println("--> Chọn loại tài khoản đáo hạn: ");
		menuChonAccount();
		chon = sc.nextInt();
		if(chon == 1)
			accDaoHan = acc1;
		else if(chon == 2)
			accDaoHan = acc2;
		else if(chon == 3)
			accDaoHan = acc3;
		else 
			accDaoHan = accMem;
		// Kiểm tra
		if(accDaoHan.getTienTK() > 0)
		{
			if(accDaoHan.daoHan())
			{
				System.out.println("\t\t============Đáo hạn thành công!=============");
				inTieuDeCot();
				System.out.println(accDaoHan);
			}
			else 
				System.out.println("\t\t============Đáo hạn không công!=============");
		}
		else
			System.out.println("Tiền trong tài khoản phải > 0");
	}
	
	static void menuChonAccount() {
		System.out.println("\t**********CHỌN TÀI KHOẢN****************");
		System.out.println("\t* 1. Chọn tài khoản cứng 1             *");
		System.out.println("\t* 2. Chọn tài khoản cứng 2             *");
		System.out.println("\t* 3. Chọn tài khoản cứng 3             *");
		System.out.println("\t* 4. Chọn tài khoản mềm                *");
		System.out.println("\t****************************************");
	}
	
	// Tiêu đề cột
	static void inTieuDeCot() {
		String str;
		str = String.format("%15s%-35s%15s", "Số tài khoản", " Tên tài khoản", "Tiền tài khoản");
		System.out.println(str);
	}
	
}
























