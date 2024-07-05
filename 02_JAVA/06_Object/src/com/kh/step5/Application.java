package com.kh.step5;

import com.kh.step5.model.Book;

public class Application {

	public static void main(String[] args) {
    Book book1 = new Book();
    Book book4 = new Book();
    Book book5 = new Book();
    Book book2 = new Book("The Money Book", 22000, 0.1, "Gong-Ja");
    
    Book book3 = new Book();
    System.out.println(book2);
    book2.setTitle("천태만상");
    System.out.println(book2);
    
    System.out.println(book2.getTitle());
    book2.setAuthor("김현호");
    book2.setDiscountRate(0.8);
    book2.setPrice(10000);
    
    System.out.println(book2.getAuthor());
    System.out.println(book3.getAuthor());
    book3.setPrice(18000);
    book1.setTitle("The Money Book");
    book4.setPrice(22000);
    book5.setPrice(19800);
    // 허송세월의 원래 가격은 18000원, 할인된 가격은 14400원
    // The Money Book의 원래 가격은 22000원, 할인된 가격은 19800원
    System.out.printf("%s의 원래 가격은 %d원, 인상된 가격은 %d원", book2.getTitle(), book2.getPrice(), book3.getPrice() );
    System.out.printf("\n%s의 원래 가격은 %d원, 할인된 가격은 %d원", book1.getTitle(), book4.getPrice(), book5.getPrice() );
	}
	
   

}
