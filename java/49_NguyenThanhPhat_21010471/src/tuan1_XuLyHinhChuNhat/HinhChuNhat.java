package tuan1_XuLyHinhChuNhat;


public class HinhChuNhat {
	private int chieuDai, chieuRong;

// getter, setter
	public int getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}
	
// constructor
	public HinhChuNhat(int chieuDai, int chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	public HinhChuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int chuVi() {
		int dai, cv = 0;
		dai = getChieuDai();
		cv = (dai + getChieuRong())*2;
		return cv;
	}
	
	public long dienTich() {
		long dt = 1;
		dt = getChieuDai() * getChieuRong();
		return dt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "- Hinh cn có chiều dài: " + getChieuDai();
		str += "\n- Hinh cn có chiều rộng: "  + getChieuRong();
		str += "\n- Hinh cn có chu vi: "  + chuVi();
		str += "\n- Hinh cn có diện tích: "  + dienTich();
		return str;
	}
	
}

















