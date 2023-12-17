<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
<h1> 회원 목록 </h1>
<table>
<thead>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>포인트</th>
		<th>관리</th>
	</tr>
</thead>
<tbody>
	<tr>
		<c:forEach var="vo" items="${memberList}">	
			<td>
				<a href='${pageContext.request.contextPath}/member/edit.do?memId=<c:out value="${vo.memId}"/>'><c:out value="${vo.memId}"/> :</a>
			</td>
			<td>
				<c:out value="${vo.memPass}"/>
			</td>
			<td>
				<c:out value="${vo.memName}"/>
			</td>
			<td>
				${vo.memPoint}	
			</td>
		</c:forEach>	
		<td>
			<c:url value="/member/del.do" var="delUrl">
				<c:param name="memId">${vo.memId}</c:param>
			</c:url>
			<a href="${delUrl}"><button type='button'> 삭제 </button></a>
	
			<c:url value="/member/edit.do" var="editUrl">
				<c:param name="memId">${vo.memId}</c:param>
			</c:url>
			<a href="${editUrl}"><button type='button'> 수정 </button></a>
		</td>
	</tr>
</tbody>
</table>
</div>



