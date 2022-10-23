package tuan8_HangHoa;

import java.time.LocalDate;

public class HangThucPham extends HangHoa {
	private LocalDate ngaySX, ngayHH;
	private String nhaCC;
	public HangThucPham(String maHang, String tenHang, int slTon, double donGia, LocalDate ngaySX, LocalDate ngayHH,
			String nhaCC) {
		super(maHang, tenHang, slTon, donGia);
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
		this.nhaCC = nhaCC;
	}
	public HangThucPham(String maHang, String tenHang, int slTon, double donGia) {
		super(maHang, tenHang, slTon, donGia);
	}
	public LocalDate getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(LocalDate ngaySX) {
		this.ngaySX = ngaySX;
	}
	public LocalDate getNgayHH() {
		return ngayHH;
	}
	public void setNgayHH(LocalDate ngayHH) throws Exception {
		if(ngayHH.isAfter(ngaySX))
			this.ngayHH = ngayHH;
		throw new Exception("Ngày hết hạn phải sau ngày sản xuất!");
	}
	public String getNhaCC() {
		return nhaCC;
	}
	public void setNhaCC(String nhaCC) {
		this.nhaCC = nhaCC;
	}
	@Override
	public String toString() {
		return super.toString() + "HangThucPham [ngaySX=" + ngaySX + ", ngayHH=" + ngayHH + ", nhaCC=" + nhaCC + "]";
	}
	@Override
	public void vat() {
		this.donGia += this.donGia * (5.0/100);
	}


	
	
	
}
