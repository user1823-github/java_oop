package tuan7_NhaDat;

import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich{
	private String loaiDat;

	public GiaoDichDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, String loaiDat) throws Exception {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiDat = loaiDat;
	}

	public GiaoDichDat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		// TODO Auto-generated constructor stub
	}

	public String getLoaiDat() {
		return loaiDat;
	}

	public void setLoaiDat(String loaiDat) throws Exception {
		if(loaiDat.equalsIgnoreCase("A") || loaiDat.equalsIgnoreCase("B") || loaiDat.equalsIgnoreCase("C")) 
			this.loaiDat = loaiDat;
		else
			throw new Exception("Loại đất phải là loại A hoặc B hoặc C");
	}

	@Override
	public String toString() {
		return "GiaoDichDat [loaiDat=" + loaiDat + ", toString()=" + super.toString() + "]";
	}

	@Override
	double thanhTien() {
		if(this.loaiDat.equalsIgnoreCase("B") || this.loaiDat.equalsIgnoreCase("C") )
			return this.dienTich * this.donGia;
		return this.dienTich * this.donGia * 1.5;
	}

	
	
	
}
