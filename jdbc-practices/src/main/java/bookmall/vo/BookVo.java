package bookmall.vo;

public class BookVo {
	private int no;
	private int category_no;
	private String title;
	private int price;
	
	public BookVo(int category_no, String title, int price) {
		this.category_no = category_no;
		this.title = title;
		this.price = price;		
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", category_no=" + category_no + ", title=" + title + ", price=" + price + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
