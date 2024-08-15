package com.board.service;

import java.util.ArrayList;
import java.util.List;

import com.board.db.BoardDao;
import com.board.db.BoardDto;
import com.board.db.BoardpDto;
import com.board.db.Pagination;
import com.board.db.productDao;
import com.board.db.productDto;
import com.board.db.productpDto;

public class ProductService {
	private static final int listSize = 10;
    private static final int paginationSize = 5;

    public List<productpDto> getPList(int pageNo) {
       return new productDao().getAllProducts((pageNo - 1) * listSize+1);
    }

    public ArrayList<Pagination> getPagination(int pageNo) {

        ArrayList<Pagination> pgnList = new ArrayList<Pagination>();

        int numRecords = new productDao().Count();//글의 수 반환
        int numPages = (int)Math.ceil((double)numRecords / listSize);//한 페이지에 나타날 글의 수로 전체 수로 나눈 값을 올림으로 구함

        int firstLink = ((pageNo - 1) / paginationSize)
                        * paginationSize + 1;
        int lastLink = firstLink + paginationSize - 1;
        if (lastLink > numPages) {
            lastLink = numPages;
        }

        if (firstLink > 1) {
            pgnList.add(
                   new Pagination("이전", pageNo - paginationSize, false));
        }

        for (int i = firstLink; i <= lastLink; i++) {
            pgnList.add(new Pagination("" + i, i, i == pageNo));
        }

        if (lastLink < numPages) {
            int tmpPageNo = pageNo + paginationSize;
            if (tmpPageNo > numPages) {
                tmpPageNo = numPages;
            }
            pgnList.add(new Pagination("다음", tmpPageNo, false));
        }

        return pgnList;
    }
    
    public void updatePro(
            String name, String description, int price, int stock, int id)
                    throws Exception {

        if (name  == null || name.length()  == 0 ||
            description   == null || description.length() == 0 ) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        productDto dto = new productDto();
        dto.setId    (id    );
        dto.setName (name );
        dto.setDescription  (description  );
        dto.setPrice(price);
        dto.setStock(stock);

        new productDao().updateProduct(dto);
    }
    
    public productDto getProForWrite(int id) {
        return new productDao().selectOne(id);
    }
    
    public void writePro(String name, String description, int price, int stock)
            throws Exception {

        if (name  == null || name.length()  == 0 ||
            description   == null || description.length() == 0 ) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        productDto dto = new productDto();
        dto.setName (name );
        dto.setDescription  (description  );
        dto.setPrice(price);
        dto.setStock(stock);

        new productDao().addProduct(dto);
    }
}
