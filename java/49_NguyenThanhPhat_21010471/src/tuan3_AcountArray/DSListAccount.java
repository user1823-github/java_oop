package tuan3_AcountArray;

import tuan3_CDArray.CD;

public class DSListAccount {
	private Account ds[];
	public int slHienTai = 0;
	public int soLuongCuaDG;
	
	// khởi tạo mảng
	public DSListAccount(int soLuongThuc) {
		ds = new Account[soLuongThuc];
	}
	
	// tăng kích thước List
	public void tangKichThuoc() {
		Account temp[] = new Account[ds.length * 2];
		for(int i = 0; i < ds.length; i++)
		{
			temp[i] = ds[i];
		}
		
		ds = temp;
	}
	
	// thêm 1 Account
	public void themAccount(Account accThem) throws Exception {
		if(slHienTai == ds.length)
			tangKichThuoc();
		
		// Không tìm thấy
		if(timKiemAcc(accThem.getSoTaiKhoan()) == -1)
		{
			ds[slHienTai] = accThem;
			slHienTai++;
		}else
			throw new Exception("Trùng số tài khoản khi thêm!");
	}
	
	// Sửa 1 Account
	public void suaAccount(Account accSua) throws Exception {
		int viTri = timKiemAcc(accSua.getSoTaiKhoan());
		if(viTri != -1)
			ds[viTri] = accSua;
		else
			throw new Exception("Không tìm thấy Account để sửa!");
	}
	
	// Xoá 1 Account
	public void xoaAccount(Account accXoa) throws Exception {
		int vt = timKiemAcc(accXoa.getSoTaiKhoan());
		if(vt != -1)
		{
			for(int i = vt; i < slHienTai; i++)
			{
				ds[i] = ds[i+1];
			}
			slHienTai--;
		}else
			throw new Exception("Không tìm thấy Account để xoá!");
	}
	
	// Nạp tiền
	public boolean napTienAccount(Account accNap, double tienNap) {
		int vt = timKiemAcc(accNap.getSoTaiKhoan());
		if(vt != -1)
		{
			ds[vt].napTien(tienNap);
			return true;
		}
		return false;
	}
	
	// Rút tiền
	public void rutTienAccount(Account accRut, double tienRut) throws Exception {
		int vt = timKiemAcc(accRut.getSoTaiKhoan());
		if(vt != -1)
		{
			ds[vt].rutTien(tienRut);
		}else
			throw new Exception("Không tìm thấy Account để rút!");
	}
	
	// Chuyển tiền
	public boolean chuyenTienAccount(Account accChuyen, Account accNhan, double tienChuyen) {
		int vtAccChuyen = timKiemAcc(accChuyen.getSoTaiKhoan());
		int vtAccNhan = timKiemAcc(accNhan.getSoTaiKhoan());
		if(vtAccChuyen != -1)
		{
			if(vtAccNhan != -1)
			{
				accChuyen.chuyenTien(accNhan, tienChuyen);
				return true;
			}else
				return false;
		}else
			return false;
	}
	
	// Đáo hạn
	public boolean daoHanAccount(Account accDaoHan) {
		int vt = timKiemAcc(accDaoHan.getSoTaiKhoan());
		if(vt != -1 && accDaoHan.getTienTK() > 0)
		{
			ds[vt].daoHan();
			return true;
		}else
			return false;
	}
	
	// Tìm kiếm vị trị của mã số tài khoản
	public int timKiemAcc(long soTKTim) {
		for (int i = 0; i < slHienTai; i++) {
			if(soTKTim == ds[i].getSoTaiKhoan())
			{
				return i;
			}
		}
		return -1;
	}
	
	// Thay đổi index của Account để sắp xếp
	public void swapAccount(Account ds[], int i, int j, Account temp) {
		temp = ds[i];
		ds[i] = ds[j];
		ds[j] = temp;
		
	}
	
	// Hàm sắp xếp tăng dần theo tiền trong Account
	public void sortTienAccount() {
		Account temp = null;
		for (int i = 0; i < slHienTai - 1; i++) {
			for (int j = i + 1; j < slHienTai; j++) {
				if(ds[i].getTienTK() > ds[j].getTienTK())
					swapAccount(ds, i, j, temp);
			}
		}
	}
	
	// Hàm sắp xếp theo tên Account: chữ cái bé nhất VD: A, B, C
	public void sortTenAccount() {
		Account temp = null;
		for (int i = 0; i < slHienTai - 1; i++) {
			for (int j = i + 1; j < slHienTai; j++) {
				if(ds[i].getTenTK().compareTo(ds[j].getTenTK()) > 0)
					swapAccount(ds, i, j, temp);
			}
		}
	}
	
	// Hàm in danh sach Acc
	public Account[] getDSAcc() {
		return ds;
	}
	
	
}




















