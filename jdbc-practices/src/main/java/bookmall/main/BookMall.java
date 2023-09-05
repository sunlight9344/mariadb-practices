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
		
		// generate Category data
		new CategoryDao().insert(new CategoryVo("수필"));
		new CategoryDao().insert(new CategoryVo("액션"));
		new CategoryDao().insert(new CategoryVo("SF"));
		// print category list
		System.out.println("## 카테고리");
		new CategoryDao().findAll();
		System.out.println();
		
		// generate Book data
		new BookDao().insert(new BookVo(1,"뿡뿡이의모험",20000));
		new BookDao().insert(new BookVo(2,"임가영의하루",31000));
		new BookDao().insert(new BookVo(3,"도라에몽의습격",99999));
		// print Book list
		System.out.println("## 상품");
		new BookDao().findAll();
		System.out.println();

		// generate Member data
		new MemberDao().insert(new MemberVo("전예준","010-9609-9344","1111","sunlight@naver.com"));
		new MemberDao().insert(new MemberVo("임가영","010-2877-6320","2222","rkdudrhdwn@gmail.com"));
		// print member list
		System.out.println("## 회원리스트");
		new MemberDao().findAll();
		System.out.println();
		
		// generate Cart data
		new CartDao().insert(new CartVo(1,1,2));
		new CartDao().insert(new CartVo(2,2,1));
		// print Cart list
		System.out.println("## 카트");
		new CartDao().findAll();
		System.out.println();
		
		// generate Order data
		new OrderDao().insertOrder(new OrderVo(1,"202301010001",20000,"서울시 이촌동"));
		// print Order list
		System.out.println("## 주문");
		new OrderDao().findAllOrder();
		System.out.println();
		
		// generate order_book data
		new OrderDao().insertOrderBook(new OrderBookVo(1,2,3));
		new OrderDao().insertOrderBook(new OrderBookVo(1,1,4));
		// print order_book list
		System.out.println("## 주문 도서");
		new OrderDao().findAllOrderBook();
		
	}
}