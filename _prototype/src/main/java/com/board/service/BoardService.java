package com.board.service;

import java.util.ArrayList;
import java.util.List;

import com.board.db.*;

public class BoardService {

    private static final int listSize = 5;
    private static final int paginationSize = 5;

    public List<BoardpDto> getMsgList(int pageNo) {
       return new BoardDao().selectList((pageNo - 1) * listSize+1);
    }

    public ArrayList<Pagination> getPagination(int pageNo) {

        ArrayList<Pagination> pgnList = new ArrayList<Pagination>();

        int numRecords = new BoardDao().getNumRecords();//글의 수 반환
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


    public BoardDto getMsg(int num) {
        BoardDto dto = new BoardDao().selectOne(num);

        dto.setTitle(dto.getTitle().replace (" ",  "&nbsp;"));
        dto.setContent(dto.getContent().replace(" ",  "&nbsp;")
                                       .replace("\n", "<br>"));

        return dto;
    }

    public BoardDto getMsgForWrite(int num) {
        return new BoardDao().selectOne(num);
    }

    public void writeMsg(String writer, String title, String content, String regtime)
            throws Exception {

        if (writer  == null || writer.length()  == 0 ||
            title   == null || title.length()   == 0 ||
            content == null || content.length() == 0) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        BoardDto dto = new BoardDto();
        dto.setWriter (writer );
        dto.setTitle  (title  );
        dto.setContent(content);
        dto.setRegtime(regtime);

        new BoardDao().insertOne(dto);
    }

    public void updateMsg(
            String writer, String title, String content, int num,String regtime)
                    throws Exception {

        if (writer  == null || writer.length()  == 0 ||
            title   == null || title.length()   == 0 ||
            content == null || content.length() == 0 ) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        BoardDto dto = new BoardDto();
        dto.setNum    (num    );
        dto.setWriter (writer );
        dto.setTitle  (title  );
        dto.setContent(content);
        dto.setRegtime(regtime);

        new BoardDao().updateOne(dto);
    }

    public void deleteMsg(int num) {
        new BoardDao().deleteOne(num);
    }
}