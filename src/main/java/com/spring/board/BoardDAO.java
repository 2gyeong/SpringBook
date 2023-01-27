package com.spring.board;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;


@Repository("boardDAO") //Spring Framework에서 자동으로 객체가 생성되어서 RAM 로드
public class BoardDAO {
	// DAO : Data Access Object :
	// DataBase 에 CRUD하는 객체 : Select, Insert, Update, Delete
	
	// 1. JDBC 관련 변수를 선언 : Connection, Statement/PreparedStatement, ResultSet
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;	// 주로 사용
	private ResultSet rs = null;
	
	// 2. SQL 쿼리를 담는 상수에 담아서 처리 변수 생성 후 할당 : 상수명 : 전체 대문자(권장사항)
	private final String BOARD_INSERT = 
			"insert into board(seq, title, writer, content) values(select nvl(max(seq),0)+1 from board,?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=?, where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";	// DataBase 의 테이블에서 1개의 레코드만 출력 ( 상세보기)
	private final String BOARD_LIST = "select * from board order by seq desc";	// DataBase의 테이블의 여러 개의 레코드를 LIST (ArrayList() )
	
	
	// 3. 메소드 : 
			// insertBoard(), updateBoard, deleteBoard(),  <== 리턴 값이 없다. void
			// getBoard() : BoardDTO 에 담아서 전송, 가져온 레코드가 1개 
			// getboardList() : 각각의 레코드를 DTO(1개), ArrayList에 DTO 객체를 담아서 리턴
	
			
	
	
	// 3-1. 글 등록 처리 메소드 : insertBoard()
	public void insertBoard(BoardDTO dto) {
		System.out.println("==> JDBC로 insertBoard() 기능 처리 시작");
		//Connection 객체를 사용해서 PreparedStatement 객체 활성화
		
		try {
			// 오류가 발생 시 프로그램이 종료되지 않도록 try catch블락으로 처리
			conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(BOARD_INSERT);
		
		// pstmt에 ?의 변수값을 할당
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getWriter());
		pstmt.setString(3, dto.getContent());
		
		pstmt.executeUpdate();
		
		System.out.println("==> JDBC로 insertBoard() 기능 처리 완료");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("==> JDBC로 insertBoard() 기능 처리 실패");
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	
	// 3-2. 글 수정 처리 메소드 : updateBoard()
	public void updateBoard(BoardDTO dto) {
		System.out.println("==> JDBC로 updateBoard() 기능 처리");
		
		try {
			// 객체 생성
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			
			//pstmt의 ?에 dto에서 넘어오는 변수값 할당.
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getSeq());
			
			pstmt.executeUpdate();
			
			System.out.println("==> JDBC로 updateBoard() 기능 처리 - 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("==> JDBC로 updateBoard() 기능 처리 - 실패");
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	// 3-3. 글 삭제 처리 메소드 : deleteBoard()
	public void deleteBoard(BoardDTO dto) {
		System.out.println("==> JDBC로 deleteBoard() 기능 처리 - 시작");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			
			pstmt.setInt(1, dto.getSeq());
			
			pstmt.executeUpdate();
			
			System.out.println("==> JDBC로 deleteBoard() 기능 처리 - 완료");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("==> JDBC로 deleteBoard() 기능 처리 - 실패");
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	// 3-4. 글 조회 처리 메소드 : getBoard() : 레코드 1개를 DB에서 select해서 DTO 객체에 담아서 리턴
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("==> JDBC로 updateBoard() 기능 처리 - 시작");
		
		//리턴으로 돌려줄 변수 선언 : try 블락 밖에서 선언
		BoardDTO board = null;
		try {
			//객체 생성 : Connection, PrepareStatement
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, dto.getSeq());
			
			// DB를 select한 결과를 rs에 저장함.
			rs = pstmt.executeQuery();
			
			//rs에 담긴 값을 DTO에 저장해서 리턴으로 돌려줌.
			
			if(rs.next()) { //rs의 값이 존재한다면 rs의 값을 DTO에 담아서 리턴
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setTitle(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REFDATE"));
				board.setCnt(rs.getInt("CNT"));
				
			}else {
				System.out.println("레코드의 결과가 없습니다.");
			}
			System.out.println("==> JDBC로 updateBoard() 기능 처리 - 완료");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("==> JDBC로 updateBoard() 기능 처리 - 실패");
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return board;
	}
	
	// 3-5. 글 목록 처리 메소드 : getBoardList()
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		System.out.println("==> JDBC로 getBoardList() 기능 처리");
		
		try {
			
		}catch(Exception e){
			
		}finally {
			
		}

	}
}
