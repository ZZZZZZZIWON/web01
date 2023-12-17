<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>회원추가</h1>

<!-- form 내부에서 사용할 모델의 이름을 modelAttribute 속성값으로 지정  -->
<form:form modelAttribute="memberVo" action='${pageContext.request.contextPath}/member/add.do' method='post'>
		아이디 : 	<form:input path="memId" /> <form:errors path="memId" /> <br>
		비밀번호 : <form:password path="memPass" /> <form:errors path="memPass" /><br>
		이름 : <form:input path="memName" /> <form:errors path="memName" />	 <br>
 		뽀인트 : 	 <form:input path="memPoint"/> <form:errors path="memPoint" /><br>
		<input type='submit'/>
</form:form>
	<h2>=================================================================</h2> 
	<h2>회원목록으로 가기</h2>
<a href='${pageContext.request.contextPath}/member/list.do' >
		<button type='button'> 회원 목록 </button>
</a>
               	