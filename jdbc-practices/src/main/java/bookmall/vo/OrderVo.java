package bookmall.vo;

public class OrderVo {
	private int no;
	private int member_no;
	private String orders_no;
	private int orders_price;
	private String address;
	
	public OrderVo(int member_no, String orders_no, int orders_price, String address) {
		this.member_no = member_no;
		this.orders_no = orders_no;
		this.orders_price = orders_price;
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", member_no=" + member_no + ", orders_no=" + orders_no + ", orders_price="
				+ orders_price + ", address=" + address + "]";
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getOrders_no() {
		return orders_no;
	}
	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
	}
	public int getOrders_price() {
		return orders_price;
	}
	public void setOrders_price(int orders_price) {
		this.orders_price = orders_price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
