package Iterator;

import java.util.Iterator;

public class BookShelfIterator implements Iterator<Book>{
	private BookShelf bookshelf;
	private int index;
	public BookShelfIterator(BookShelf bookshelf) {
		super();
		this.bookshelf = bookshelf;
		this.index = 0;
	}
	@Override
	public boolean hasNext() {
		if(index < bookshelf.getLength()) {
			return true;
		
		}else {
			return false;
		}
	}
	
	@Override
	public Book next() {//0번쨰 인덱스부터 책의 정보를 출력하는 메소드
		Book book = bookshelf.getBook(index);
		index++;
		return book;
	}
	
	
}
