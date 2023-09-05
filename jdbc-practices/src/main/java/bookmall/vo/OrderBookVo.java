package bookmall.vo;

public class OrderBookVo {
	private int orders_no;
	private int book_no;
	private int quantity;
	public OrderBookVo(int orders_no, int book_no, int quantity) {
		this.orders_no = orders_no;
		this.book_no = book_no;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderBookVo [orders_no=" + orders_no + ", book_no=" + book_no + ", quantity=" + quantity + "]";
	}
	public int getOrders_no() {
		return orders_no;
	}
	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
