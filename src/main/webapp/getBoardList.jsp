<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="com.spring.board.BoardDTO" %>

<!--  세션에 저장된 boardList를 끄집어 낸다. -->

<%

//session은 내장 객체이므로 별도로 import 없이 사용 가능

List<BoardDTO> boardList = (List) session.getAttribute("boardList");



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1> 게시판 목록 출력 페이지 </h1>
<hr>

<h3> 환영합니다. <a href="logout.do">Log-Out</a></h3>
<!-- 검색 기능 추가 -->

<form action="getboardList.jsp" method="post">
	<Table border ="1" cellspacing="0" cellpadding ="0" width="700px">
		<tr>
			<td><select name="searchCondition">
				<option value="TITLE">제목</option>
				<option value="TITLE">내용</option>
				
			</select>
			<input type="text" name ="searchKeword">
			<input type="submit" name ="검색">
			</td>
		
		</tr>
	
	</Table>
	
	<!--  서버에서 담은 List에 저장된 DTO를 끄집어 내서 출력 -->
	<table border ="1" cellspacing="0" cellpadding ="0" width="700px"> 
		<tr>
			<th bgcolor="orange" width="100px"> 번호 </th>
			<th bgcolor="orange" width="100px"> 제목 </th>
			<th bgcolor="orange" width="100px"> 작성자 </th>
			<th bgcolor="orange" width="100px"> 등록일 </th>
			<th bgcolor="orange" width="100px"> 조회수 </th>
		
		</tr>
		
		<!--  tr을 for문으로 루프를 돌리면서 List의 DTO 값을 가져와서 출력 -->
		<% for(BoardDTO dto : boardList){
			
		%>
		
		<tr>
			<td> <%= dto.getSeq() %> </td>
			<td> <%= dto.getTitle() %></td>
			<td> <%= dto.getWriter()%> </td>
			<td> <%= dto.getRegDate() %></td>
			<td> <%= dto.getCnt() %></td>
		</tr>
		
		<%
			}		// for문 끝
		%>

	
	</table>
		
		<p/>
		<a href="insertBoard.jsp"> 새 글 등록</a>

</form>
</center>

</body>
</html>