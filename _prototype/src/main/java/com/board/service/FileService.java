package com.board.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.board.db.BoardDao;
import com.board.db.BoardDto;
import com.board.db.Pagination;
import com.board.db.fileDAO;
import com.board.db.fileDTO;

public class FileService {
	private static final int listSize = 10;
    private static final int paginationSize = 5;

    public List<fileDTO> getPList(int pageNo) {
       return new fileDAO().showFiles((pageNo - 1) * listSize);
    }

    public ArrayList<Pagination> getPagination(int pageNo) {

        ArrayList<Pagination> pgnList = new ArrayList<Pagination>();

        int numRecords = new fileDAO().Count();//글의 수 반환
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
    
}