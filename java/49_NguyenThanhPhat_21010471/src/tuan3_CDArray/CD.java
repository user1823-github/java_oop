package tuan3_CDArray;

import java.text.NumberFormat;
import java.util.Locale;

public class CD implements Comparable<CD>{
	private int maCD;
	private String tuaCD;
	private int soBH;
	private double giaThanh;
	
	// Constructor
	public CD(int maCD, String tuaCD, int soBH, double giaThanh) {
		super();
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.soBH = soBH;
		this.giaThanh = giaThanh;
	}
	
	public CD() {
		super();
	}
	
	// Getter, setter
	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		if(maCD > 0)
			this.maCD = maCD;
		else
			this.maCD = 999999;
	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		if(!tuaCD.equals(""))
			this.tuaCD = tuaCD;
		else
			this.tuaCD = "chưa xác định";
	}

	public int getSoBH() {
		return soBH;
	}

	public void setSoBH(int soBH) throws Exception {
		if(soBH > 0)
			this.soBH = soBH;
		else
			throw new Exception("Số bài hát không được bé hơn 0!");
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) throws Exception {
		if(giaThanh > 0)
			this.giaThanh = giaThanh;
		else
			throw new Exception("Giá thành không được bé hơn 0!");
	}

	@Override
	public int compareTo(CD obj) {
		// TODO Auto-generated method stub
		
		if(this.getTuaCD().equalsIgnoreCase(obj.getTuaCD()))
		{
			Double obj1 = this.getGiaThanh();
			Double obj2 = obj.getGiaThanh();
			
			return obj2.compareTo(obj1);
		}else
			return this.getTuaCD().compareToIgnoreCase(obj.getTuaCD());
	}

	@Override
	public String toString() {
		String giaTri;
		Locale myLocale = new Locale("vi", "VN");
		NumberFormat myNumber = NumberFormat.getCurrencyInstance(myLocale);
		String str = myNumber.format(getGiaThanh());
		giaTri = String.format("%15d%-35s%15d%15s", getMaCD(), " "+getTuaCD(), getSoBH(), str);
		return giaTri;
	}
	
	
}






















