<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.spring.board.BoardDTO" %>
    
    <% 
    	// session에 저장된 값을 가지고 온다.
    		// board : DB의 select 한 레코드를 저장하고 있는 dto
    	BoardDTO board = (BoardDTO) session.getAttribute("board");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
	<h1> 글 상세 페이지 </h1>
	<a href="logout"> Log-out </a>
	
	<!--  Form의 value에 출력 -->
	<form action ="updateBoard.do" method ="post">
	
		<!--  updateBoard.do 페이지로 넘길 때 seq -->
		<input type="hidden" name="seq" value= "<%= board.getSeq() %>">
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="orange" width="70"> 글 제목 </td>
				<td><input type="text" name="title" value= "<%= board.getTitle() %>"></td>
			</tr>
			
			<tr>
				<td bgcolor="orange" width="70"> 작성자 </td>
				<td><%= board.getWriter() %></td>
			</tr>
			
			<tr>
				<td bgcolor="orange" width="70"> 내용 </td>
				<td><textarea name="content" cols="40" rows="10">
					<%= board.getContent() %>
					</textarea>
				</td>
			</tr>
			
			<tr>
				<td bgcolor="orange" width="70"> 등록일 </td>
				<td><%= board.getRegDate() %></td>
			</tr>
		
			<tr>
				<td bgcolor="orange" width="70"> 조회수 </td>
				<td><%= board.getCnt()%></td>
			</tr>
			
			<tr>
				<td colspan ="2" align="right"> <input type="submit" value="글 수정"></td>
				<td></td>
			</tr>
		</table>
	</form>
	
	<p>
	<a href="insertBoard.jsp"> 글 등록 </a> &nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=<%= board.getSeq() %>"> 글 삭제 </a> &nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글 목록</a>

</center>
</body>
</html>