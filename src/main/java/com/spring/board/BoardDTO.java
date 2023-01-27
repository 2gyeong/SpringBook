package com.spring.board;

import java.sql.Date;

public class BoardDTO {
	
	// DTO (VO) : DB�� ���̺��� �� �÷��̸��� ����
		// �����͸� �޾Ƽ� �������ִ� �߰��� ����
		// ��� ������ private �� ����
		// getter/setter�� ����ؼ� ������ ���� �Ҵ�, ������ ��
		// �⺻ �����ڸ� �ݵ�� ������, BoardDTO(){}
		// toString �޼ҵ带 ������ : ��ü ��ü�� ������� �� �� ��ü�� �������� Ȯ��
		// lombok �� ����ϸ�, ������̼��� ����ؼ� getter/setter, toString, �⺻ �����ڸ� �ڵ����� ������ش�.
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate; // java.sql.Date
	private int cnt;
	
	// �⺻ �����ڸ� �߰�
	public BoardDTO() {}

	//getter/setter	<== ��� ������ private�̹Ƿ� �ܺο��� ���� ������. getter/setter�� ���ؼ� �� �Ҵ�.
	//art+shift+s
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	//toStirng() : ��ü ��ü�� ����� �� ��ü �޸��� ���� ����ϵ��� ������
	// �⺻�����δ� ��ü�� �������� ��� (hash �ڵ�)
	
	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + "]";
	}
	

	
	
	
	
}