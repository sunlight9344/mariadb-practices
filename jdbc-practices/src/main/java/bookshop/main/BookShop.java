package bookshop.main;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDao;
import bookshop.example.Book;
import bookshop.vo.BookVo;

public class BookShop {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		int no = scanner.nextInt();
		scanner.close();
		
		BookVo vo = new BookVo();
		vo.setNo(no);
		vo.setRent("Y");
		
		new BookDao().updateRent(no);
		
		displayBookInfo();
	}
	
	private static void displayBookInfo() {
		System.out.println("*****도서 정보 출력하기*****");

		List<BookVo> list = new BookDao().findAll();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
		
	}

}
