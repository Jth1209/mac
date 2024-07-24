package Iterator;

import java.util.Iterator;

public class BookShelf implements Iterable<Book>{
	
	private Book[] books;
	private int last;
	
	@Override
	public Iterator<Book> iterator() {//iterator 실행 메소드 오버라이딩
		return new BookShelfIterator(this);
	}
	
	public BookShelf(int maxindex) {//constructer
		this.books = new Book[maxindex];
		this.last = 0;
	}
	public Book getBook(int last) {
		Book book = books[last];
		return book;
	}
	public void appendBook(Book book) {//책 추가
		books[last] = book;
		last++;
	}
	public int getLength() {//index length
		return last;
	}
}
