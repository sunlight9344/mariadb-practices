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

public class BookMall {
	public static void main(String[] args) {
		
		MemberDao memberdao = new MemberDao();
		memberdao.insert(new MemberVo("전예준","010-9609-9344","1111","sunlight@naver.com"));
		memberdao.insert(new MemberVo("임가영","010-2877-6320","2222","rkdudrhdwn@gmail.com"));
		
		CategoryDao categorydao = new CategoryDao();
		categorydao.insert(new CategoryVo("수필"));
		categorydao.insert(new CategoryVo("액션"));
		categorydao.insert(new CategoryVo("SF"));
		
		BookDao bookdao = new BookDao();
		bookdao.insert(new BookVo(1,"뿡뿡이의모험",20000));
		bookdao.insert(new BookVo(2,"임가영의하루",31000));
		bookdao.insert(new BookVo(3,"도라에몽의습격",99999));
		
		CartDao cartdao = new CartDao();
		cartdao.insert(new CartVo(1,1,2));
		cartdao.insert(new CartVo(2,2,1));
		
		OrderDao orderdao = new OrderDao();
		
		
		System.out.println("## 회원리스트");
		memberdao.findAll();
		System.out.println();
		
		System.out.println("## 카테고리");
		categorydao.findAll();
		System.out.println();
		
		System.out.println("## 상품");
		bookdao.findAll();
		System.out.println();
		
		System.out.println("## 카트");
		cartdao.findAll();
		System.out.println();
		
		System.out.println("## 주문");

		System.out.println("## 주문 도서");
	}
}