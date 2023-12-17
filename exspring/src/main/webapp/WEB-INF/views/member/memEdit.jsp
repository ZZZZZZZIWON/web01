<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>회원정보수정</h1>
<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>
		
		아이디 : 	 <input type="text" name='memId' value='<c:out value="${mbvo.memId}" />' readonly="readonly"/><br> 
		비밀번호 : <input type='password' name='memPass' value='<c:out value="${mbvo.memPass}" />' /><br>
		이름 : 	 <input type='text' name='memName' value='<c:out value="${mbvo.memName}" />' /><br>
 		뽀인트 : 	 <input type='number' name='memPoint' value='<c:out value="${mbvo.memPoint}" />' /><br>
		<input type='submit' value="저장"/>	
</form>

	<a href='${pageContext.request.contextPath}/member/del.do?memId=<c:out value="${mbvo.memId}"/>'><button type='button'> 삭제 </button></a>
	<c:url value="/member/del.do" var="delUrl">
		<c:param name="memId">${mbvo.memId}</c:param>
	</c:url>
		<a href="${delUrl}"><button type='button'> 삭제 </button></a>
	
	

	<h2>=================================================================</h2> 
	<h2>회원목록으로 가기</h2>
<a href='${pageContext.request.contextPath}/member/list.do'>
		<button type='button'> 회원 목록 </button>
</a>
		
