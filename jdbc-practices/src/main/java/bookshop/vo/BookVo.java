package bookshop.vo;

public class BookVo {

	int no;
	String title;
	String rent;
	int author_no;
	
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", rent=" + rent + ", author_no=" + author_no + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String isRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public int getAuthor_no() {
		return author_no;
	}
	public void setAuthor_no(int author_no) {
		this.author_no = author_no;
	}
	
}
