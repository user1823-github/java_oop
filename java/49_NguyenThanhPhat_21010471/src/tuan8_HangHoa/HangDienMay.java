package tuan8_HangHoa;

public class HangDienMay extends HangHoa {
	private int tgBaoHanh, congSuat;

	public HangDienMay(String maHang, String tenHang, int slTon, double donGia, int tgBaoHanh, int congSuat) {
		super(maHang, tenHang, slTon, donGia);
		this.tgBaoHanh = tgBaoHanh;
		this.congSuat = congSuat;
	}

	public HangDienMay(String maHang, String tenHang, int slTon, double donGia) {
		super(maHang, tenHang, slTon, donGia);
	}

	public int getTgBaoHanh() {
		return tgBaoHanh;
	}

	public void setTgBaoHanh(int tgBaoHanh) throws Exception {
		if(tgBaoHanh >= 0)
			this.tgBaoHanh = tgBaoHanh;
		else throw new Exception("Thời gian bảo hành > 0");
	}

	public int getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(int congSuat) throws Exception {
		if(congSuat>=0)
			this.congSuat = congSuat;
		else throw new Exception("Công suất phải > 0");
	}

	@Override
	public String toString() {
		return super.toString() + "HangDienMay [tgBaoHanh=" + tgBaoHanh + ", congSuat=" + congSuat + "]";
	}

	@Override
	public void vat() {
		this.donGia += this.donGia * (10.0/100);
	}
	
	
}
