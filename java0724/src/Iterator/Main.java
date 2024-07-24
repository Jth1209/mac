package Iterator;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		BookShelf bookshelf = new BookShelf(4);
		bookshelf.appendBook(new Book("백설공주와 일곱 난쟁이"));
		bookshelf.appendBook(new Book("신데렐라"));
		bookshelf.appendBook(new Book("병,균,쇠"));
		bookshelf.appendBook(new Book("인간의 본성이란 무엇인가"));
		
		Iterator<Book> it = bookshelf.iterator();
		while(it.hasNext()) {
			Book book = it.next();
			System.out.println(book.getName());
		}
		System.out.println();
		for(Book book: bookshelf) {
			System.out.println(book.getName());
		}
	}

}
