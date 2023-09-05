package bookmall.main;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class BookMall {
	public static void main(String[] args) {
		
		// generate Category data (name)
		new CategoryDao().insert(new CategoryVo("수필"));
		new CategoryDao().insert(new CategoryVo("액션"));
		new CategoryDao().insert(new CategoryVo("SF"));
		// print category list
		System.out.println("## 카테고리");
		new CategoryDao().findAll();
		System.out.println();
		
		// generate Book data (category_no, title, price)
		new BookDao().insert(new BookVo(1,"뿡뿡이의모험",10000));
		new BookDao().insert(new BookVo(2,"임가영의하루",20000));
		new BookDao().insert(new BookVo(3,"도라에몽의습격",30000));
		// print Book list
		System.out.println("## 상품");
		new BookDao().findAll();
		System.out.println();

		// generate Member data (name, phone, pw, email)
		new MemberDao().insert(new MemberVo("전예준","010-9609-9344","1111","sunlight@naver.com"));
		new MemberDao().insert(new MemberVo("임가영","010-2877-6320","2222","rkdudrhdwn@gmail.com"));
		// print member list
		System.out.println("## 회원리스트");
		new MemberDao().findAll();
		System.out.println();
		
		// generate Cart data (book_no, member_no, quantity)
		new CartDao().insert(new CartVo(1,1,1));
		new CartDao().insert(new CartVo(2,1,2));
		// print Cart list
		System.out.println("## 카트");
		new CartDao().findAll();
		System.out.println();
		
		// generate Order data (member_no, order_no, order_price, address)
		new OrderDao().insertOrder(new OrderVo(1,"202301010001",50000,"서울시 이촌동"));
		// print Order list
		System.out.println("## 주문");
		new OrderDao().findAllOrder();
		System.out.println();
		
		// generate order_book data (orders_no, book_no, quantity)
		new OrderDao().insertOrderBook(new OrderBookVo(1,1,1));
		new OrderDao().insertOrderBook(new OrderBookVo(1,2,2));
		// print order_book list
		System.out.println("## 주문 도서");
		new OrderDao().findAllOrderBook();
		
	}
}