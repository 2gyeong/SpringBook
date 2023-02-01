package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.board.BoardDAO;
import com.spring.board.BoardDTO;
import com.spring.users.UserDAO;
import com.spring.users.UserDTO;
import com.spring.users.UserService;
import com.spring.users.UserServiceImpl;

/**
 * Servlet implementation class DispatcherServlet
 */
//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DispatcherServlet() {
        super();
     
    }

    //doGet으로 넘어오는 요청을 process () 메소드에서 처리 하도록 넘김
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		process(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Post 방식으로 변수의 값을 넘길때 한글 깨어짐 방지 처리 
		request.setCharacterEncoding("UTF-8");
		process(request, response); 

	}
	
	// doGet, doPost 의 모든 요청을 처리 하는 메소드 
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URL : http://localhost:8080/boardweb/getBoardList.do 
		// URI : /boardweb/getBoardList.do
		// URI는 URL의 '서버 : 포트'를 제외한 경로 
		
		
		//1. 클라이언트의 요청 path 정보를 추출 한다. 
		String url = request.getRequestURL().toString();
		//StringBuffer url = request.getRequestURL();
			System.out.println("url : "+url);
		
		String uri = request.getRequestURI(); 		///boardweb/getBoardList.do
			System.out.println("uri : " + uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));  //getBoardList.do
			System.out.println("path : "+ path);
		
		
		//2. 클라이언트의 요청 정보에 따라서 적절하게 분기 처리함. 
		
		if (path.equals("/login.do")) {
			
			// 클라이언트 요청에 대해서 : /login.do 요청
			// 1. Model : Service(비즈니스 로직 처리), ( DTO, DAO )	
			// 2. View 페이지로 전달 : *.jsp 파일
			
			System.out.println("사용자 정보 처리");
			System.out.println("/login.do 요청을 보냈습니다.");
			
		// A. 클라이언트에서 보내는 변수 값을 받아서 변수에 저장
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			System.out.println("폼에서 넘긴 변수 id 값 출력 : "+ id);
			System.out.println("폼에서 넘긴 변수 password 값 출력 : "+ password);
			
		// B. 클라이언트에서 넘긴 변수값을 받아서 저장된 변수를 DTO에  Setter 주입
			UserDTO dto = new UserDTO();
			
			dto.setId(id);
			dto.setPassword(password);
		// C. 비즈니스 로직을 처리하는 인터페이스에 dto를 주입해서 비즈니스 로직을 처리
			
			//UserService user = new UserServiceImpl() ;
			UserDAO user = new UserDAO();
			UserDTO userD = user.getUser(dto);
			
			
			// DB의 클라이언트에서 넘긴 ID와 Password를 select 해서 그 값을 DTO에 담아서 리턴
			System.out.println(userD); // 출력 test
			
		// D. 백엔드의 로직을 모두 처리 후 View 페이지로 이동
			if(userD != null) { // 클라이언트에게 전송한 ID와 Pass가 DB의 값과 일치할때
				response.sendRedirect("getBoardList.do");
				System.out.println("아이디와 패스워드 일치");
			}else { // client에게 전송한 ID와 Password 중 일치하지 않을 때 null
				response.sendRedirect("login.jsp"); 
				System.out.println("아이디와 패스워드 불일치");
			}
			
		}else if (path.equals("/getBoardList.do")) {
			
			System.out.println("게시판 정보 출력 ");
			
			// 1. Client 로 부터 /getBoardList.do 요청을 받음. (게시판 정보를 출력해 달라고 요청)
			
			// 2. 비즈니스 로직 처리
			BoardDTO dto = new BoardDTO();
			BoardDAO dao = new BoardDAO();
			
			//boardList 에는 DB에서 쿼리한 레코드를 담은 DTO객체가 내장
			List<BoardDTO> boardList = dao.getBoardList(dto);
			
			
			// 3. 클라이언트에게 boardList를 전달해야 한다.
			//(세션 객체에 boardList 객체를 담아서 전송)
			// 세션은 서버의 RAM에 저장됨.
			// 쿠키 : 클라이언트 시스템의 HDD에 정보를 저장함.
			HttpSession session = request.getSession();
			//session 객체에 값을 저장, setAttribute("변수명", 객체);
			//session 객체에 값을 가지고 올 때, getAttribute("변수명");
			session.setAttribute("boardList", boardList);
			
			// 4. 뷰 페이지로 이동
			response.sendRedirect("getBoardList.jsp");
			
		}else if (path.equals("/logout.do")) {
			
			System.out.println("사용자 로그 아웃 처리");
		}
		
		
	}
	
	

}