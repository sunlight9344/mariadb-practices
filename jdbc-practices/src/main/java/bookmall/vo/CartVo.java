package bookmall.vo;

public class CartVo {
	private int no;
	private int bookNo;
	private int memberNo;
	private int quantity;
	private int price;
	
	public CartVo(int bookNo, int memberNo, int quantity) {
		this.bookNo = bookNo;
		this.memberNo = memberNo;
		this.quantity = quantity;		
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", bookNo=" + bookNo + ", memberNo=" + memberNo + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setbookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
