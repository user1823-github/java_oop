package tuan3_CDArray;
import java.util.Arrays;
import java.util.Scanner;

public class KiemThuCD {
	public static void main(String[] args) throws Exception {
		CDList ds = new CDList(3);
		Scanner sc = new Scanner(System.in);
		int chon = -1;
		
		try {
			do {
				menu();
				System.out.println("Mời bạn nhập lựa chọn: ");
				chon = sc.nextInt();

				switch (chon) {
					case 1:
						nhapCung(ds);
						break;
					case 2:
						CD cdMem = nhapMem(ds);
						if(cdMem != null)
							ds.themCD(cdMem);
						else 
							System.out.println("Thêm không thành công!");
						break;
					case 3:
						CD cdSua = sua(ds);
						if(cdSua != null)
							ds.suaCD(cdSua);
						else
							System.out.println("Sửa không thành công!");
						break;
					case 4:
						xoa(ds);
						break;
					case 5:
						timKiem(ds);
						break;
					case 6:
						inTieuDeCot();
						xuat(ds);
						break;
					case 7:
						System.out.println("Số lượng CD có trong danh sách: " + ds.soLuongCDTrongList());
						break;
					case 8:
						System.out.println("Tổng của giá thành là:" + ds.getMonney());
						break;
					case 9:
						ds.sortTheoGiaCD();
						System.out.println("Đã sắp xếp theo giá CD giảm thành công!");
						break;
					case 10:
						ds.sortTheoTuaCD();
						System.out.println("Đã sắp xếp theo tựa CD tăng thành công!");
						break;
					case 11:
						int soPhanTuThuc = ds.soLuongThuc;
						CD[] toanMang;
						toanMang = ds.getDsCD();
						CD [] mangChuaCacPTThuc;
						mangChuaCacPTThuc = new CD[soPhanTuThuc];
						for (int i = 0; i < soPhanTuThuc; i++) {
							mangChuaCacPTThuc[i] = toanMang[i];
						}					
						Arrays.sort(mangChuaCacPTThuc);
						System.out.println("Mảng sau khi đã sắp xếp: ");
						inTieuDeCot();
						xuatMangDaSapXep(mangChuaCacPTThuc, soPhanTuThuc);
						break;
					case 12:
						System.out.println("--> Bạn đã thoát chương trình!");
						break;
					default:
						break;
					}
			}while(chon != 12);
		} catch (ArithmeticException e) {
			System.out.println("Không dược chia cho không" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Lỗi mảng quá size array: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Lỗi không xác định: " + e.getMessage());
		}
	}
	
	static void nhapCung(CDList ds) throws Exception {
		CD cd1 = new CD(1, "Nàng thơ C", 3, 1000000);
		ds.themCD(cd1);
		CD cd2 = new CD(2, "Nàng thơ", 5, 2000000);
		ds.themCD(cd2);
		CD cd3 = new CD(3, "Nàng thơ", 3, 3000000);
		ds.themCD(cd3);
		CD cd4 = new CD(4, "Album A", 2, 40000);
		ds.themCD(cd4);
		CD cd5 = new CD(5, "Album B", 2, 70000);
		ds.themCD(cd5);
		CD cd6 = new CD(6, "Album B", 2, 3000);
		ds.themCD(cd6);
		CD cd7 = new CD(7, "Nhạc trung thu", 2, 150000);
		ds.themCD(cd7);
		CD cd8 = new CD(8, "Nhạc trung thu", 2, 10000);
		ds.themCD(cd8);
	}
	
	// Nhập mềm, thêm
	static CD nhapMem(CDList ds) {
		Scanner sc = new Scanner(System.in);
		CD cdMem = null;
		int maCD, soBH;
		String tuaCD;
		double giaThanh = 0;
		
		System.out.println("==> Tạo mềm CD ===");
		System.out.println("Bạn nhập mã CD cần thêm: ");
		maCD = sc.nextInt();
		sc.nextLine();
		
		int vt = ds.timKiemCD(maCD);
		if(vt == -1)
		{
			System.out.println("Tựa CD: ");
			tuaCD = sc.nextLine();
			System.out.println("Số bài hát: ");
			soBH = sc.nextInt();
			sc.nextLine();
			System.out.println("Giá thành: ");
			giaThanh = sc.nextDouble();
			cdMem = new CD(maCD, tuaCD, soBH, giaThanh);
		}else {
			System.out.println("Mã CD đã tồn tại!");
		}
		
		return cdMem;
	}
	
	// Sửa
	static CD sua(CDList ds) throws Exception {
		Scanner sc = new Scanner(System.in);
		CD cdSua = null;
		int maCD, soBH = 0, chon;
		String tuaCD = null;
		double giaThanh = 0;
		
		System.out.println("Bạn nhập mã CD cần sửa: ");
		maCD = sc.nextInt();
//		sc.nextLine();
		
		int vt = ds.timKiemCD(maCD);
		// Tìm thấy
		if(vt != -1)
		{
			cdSua = ds.getDsCD()[vt];
			System.out.println("=> Thông tin về CD chưa sửa của bạn: \n" + cdSua);
			do {
				menuSua();
				System.out.println("Nhập lựa chọn: ");
				chon = sc.nextInt();
				sc.nextLine();
				
				switch (chon) {
					case 1:
						System.out.println("Nhập mã CD mới: ");
						maCD = sc.nextInt();
						cdSua.setMaCD(maCD);
						break;
					case 2:
						System.out.println("Nhập tựa CD mới: ");
						tuaCD = sc.nextLine();
						cdSua.setTuaCD(tuaCD);
						break;
					case 3:
						System.out.println("Nhập số bài hát mới: ");
						soBH = sc.nextInt();
						cdSua.setSoBH(soBH);
						break;
					case 4:
						System.out.println("Nhập giá thành mới: ");
						giaThanh = sc.nextDouble();
						cdSua.setGiaThanh(giaThanh);
						break;
					default:
						ds.suaCD(cdSua);
						System.out.println("Đã sửa thành công!");
						break;
				}
			}while(chon < 5);
		}else {
			System.out.println("Mã CD đã tồn tại!");
		}
		return cdSua;
	}
	
	// Xoá
	static void xoa(CDList ds) {
		Scanner sc = new Scanner(System.in);
		CD cdXoa = null;
		int maCD;
		System.out.println("Nhập mã CD cần xoá: ");
		maCD = sc.nextInt();
		sc.nextLine();
		int vt = ds.timKiemCD(maCD);
		
		if(vt != -1)
		{
			String acp;
			System.out.println("\nBạn có chắc chắn muốn xoá CD này không [y/n]: ");
			acp = sc.nextLine();
			
			if(acp.equals("y") || acp.equals("Y"))
			{
				cdXoa = ds.getDsCD()[vt];
				ds.xoaCD(cdXoa);
				System.out.println("Đã xoá CD này thành công!");
			}else if(acp.equals("n") || acp.equals("N"))
			{
				System.out.println("Bạn đã huỷ thao tác xoá!");
			}
		}else
		{
			System.out.println("Mã CD không tồn tại!");
		}
	}
	
	// Tìm kiếm vị trí của CD
	static void timKiem(CDList ds) {
		Scanner sc = new Scanner(System.in);
		int maCD;
		System.out.println("Nhập mã CD cần tìm: ");
		maCD = sc.nextInt();
		if(ds.timKiemCD(maCD) != -1)
			System.out.println("CD của bạn nằm ở vị trí thứ: " + ds.timKiemCD(maCD));
		else 
			System.out.println("Mã CD không tồn tại!");
	}
	
	// Xuất Danh sách CD
	static void xuat(CDList ds) {
		
		for (int i = 0; i < ds.soLuongThuc; i++) {
			System.out.println(ds.getDsCD()[i]);
		}
	}
	
	static void xuatMangDaSapXep(CD[] ds, int soPTThuc) {
		for (int i = 0; i < soPTThuc; i++) {
			System.out.println(ds[i]);
		}
	}
	
	static void menu() {
		System.out.println("\n\n\t\t*****************************************************");
		System.out.println("\t\t** \t\t Chương trình quản lý CD \t   **");
		System.out.println("\t\t* 1. Nhập cứng                                      *");
		System.out.println("\t\t* 2. Nhập mềm (Thêm)                                *");
		System.out.println("\t\t* 3. Sửa                                            *"); 
		System.out.println("\t\t* 4. Xoá                                            *");
		System.out.println("\t\t* 5. Tìm kiếm CD                                    *");
		System.out.println("\t\t* 6. Xuất danh sách CD                              *");
		System.out.println("\t\t* 7. Số lượng CD có trong danh sách                 *");
		System.out.println("\t\t* 8. Tổng giá thành của các CD                      *");
		System.out.println("\t\t* 9. Sắp xếp danh sách giảm dần theo giá thành      *");
		System.out.println("\t\t* 10.Sắp xếp danh sách tăng dần theo tựa CD         *");
		System.out.println("\t\t* 11.Sắp theo 2 thuộc tính tựa CD và giá thành      *");
		System.out.println("\t\t* 12.Thoát! \t\t\t                    *");
		System.out.println("\t\t*****************************************************");
	}
	
	static void menuSua() {
		System.out.println("******************************************");
		System.out.println("**\t\t SỬA THÔNG TIN CD \t\t**");
		System.out.println("* 1. Sửa mã CD                     **");
		System.out.println("* 2. Sửa tựa CD                    **");
		System.out.println("* 3. Sửa số bài hát                **");
		System.out.println("* 4. Sửa giá thành                 **");
		System.out.println("* 5. Thoát!                        **");
		System.out.println("******************************************");
	}
	
	static void inTieuDeCot() {
		String str;
		str = String.format("%15s%-35s%15s%15s", "Mã CD", " Tựa CD", "Số bài hát", "Giá thành");
		System.out.println(str);
	}
}

















