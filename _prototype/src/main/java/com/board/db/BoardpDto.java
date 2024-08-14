package com.board.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class BoardpDto {
	private int    rownum  = 0;
    private int    num     = 0;
    private String writer  = "";
    private String title   = "";
    private String content = "";
    private String regtime = "";
    private int    hits    = 0;
	
    public BoardpDto(int rownum,int num, String writer, String title, String content, String regtime, int hits) {
		super();
		this.rownum = rownum;
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
	}

	public BoardpDto() {
		super();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	@Override
	public String toString() {
		return "BoardpDto [rownum=" + rownum + ", num=" + num + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", regtime=" + regtime + ", hits=" + hits + "]";
	}
	
    
}