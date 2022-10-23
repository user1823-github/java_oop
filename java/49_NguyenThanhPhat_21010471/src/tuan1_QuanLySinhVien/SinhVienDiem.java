package tuan1_QuanLySinhVien;

public class SinhVienDiem {
	private int maSinhVien;
	private String hoTen;
	private float diemLT, diemTH;
	public SinhVienDiem(int maSinhVien, String hoTen, float diemLT, float diemTH) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	public SinhVienDiem() {
		super();
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	
	float diemTrungBinh() {
		float dtb;
		dtb = (getDiemLT() + getDiemTH()) / 2;
		return dtb;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += String.format("%15d %-34s%15.2f%15.2f%15.2f", getMaSinhVien(), getHoTen(), getDiemLT(), getDiemTH(), diemTrungBinh());
		return str;
	}
}






















