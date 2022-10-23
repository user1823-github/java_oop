package tuan7_NhaDat;

import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich {
	private String loaiNha, diaChi;

	public GiaoDichNha(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, String loaiNha,
			String diaChi) throws Exception {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}

	public GiaoDichNha() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichNha(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		// TODO Auto-generated constructor stub
	}
	
	public String getLoaiNha() {
		return loaiNha;
	}

	public void setLoaiNha(String loaiNha) throws Exception {
		if(loaiNha.equals("cao cấp" )|| loaiNha.equals("thường") )
			this.loaiNha = loaiNha;
		else
			throw new Exception("Loại nhà phải là loại: cao cấp || thường");
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "GiaoDichNha [loaiNha=" + loaiNha + ", diaChi=" + diaChi + ", toString()=" + super.toString() + "]";
	}

	@Override
	double thanhTien() {
		if(this.loaiNha.equalsIgnoreCase("cao cấp"))
			return this.dienTich * this.donGia;
		return this.dienTich * this.donGia * (90.0/100);
	}

	

	

	

	
	
}
