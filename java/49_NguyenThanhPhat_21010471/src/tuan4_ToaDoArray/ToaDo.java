package tuan4_ToaDoArray;

public class ToaDo implements Comparable<ToaDo> {
	private String ten;
	private float x, y;
	
	public ToaDo(String ten, float x, float y) {
		super();
		this.ten = ten;
		this.x = x;
		this.y = y;
	}
	
	public ToaDo() {
		super();
	}
	
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += String.format("%-15s%8.2f%13.2f", "  "+getTen(), getX(), getY());
		return str;
	}

	@Override
	public int compareTo(ToaDo o) {
		return this.ten.compareToIgnoreCase(o.ten);
	}
}













