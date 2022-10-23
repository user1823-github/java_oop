package tuan8_HangHoa;

import java.time.LocalDate;

public class HangSanhSu extends HangHoa {
	private LocalDate ngaySX, ngayNhapKho;

	public HangSanhSu(String maHang, String tenHang, int slTon, double donGia, LocalDate ngaySX,
			LocalDate ngayNhapKho) {
		super(maHang, tenHang, slTon, donGia);
		this.ngaySX = ngaySX;
		this.ngayNhapKho = ngayNhapKho;
	}

	public HangSanhSu(String maHang, String tenHang, int slTon, double donGia) {
		super(maHang, tenHang, slTon, donGia);
	}

	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) {
		this.ngaySX = ngaySX;
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}

	@Override
	public String toString() {
		return super.toString() + "HangSanhSu [ngaySX=" + ngaySX + ", ngayNhapKho=" + ngayNhapKho + "]";
	}

	@Override
	public void vat() {
		this.donGia += this.donGia * (10.0/100);
	}
	
	
}
