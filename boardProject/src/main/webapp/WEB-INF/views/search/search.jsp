<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 검색 결과</title>
</head>
<body>

	<main>
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		
		<section class="search-page">
			<h1>'${param.query}'로 검색한 결과</h1>
			
			<c:choose>
				<%-- c:choose 안에는 이 주석태그만 가능!!!! --%>
				
				<%-- memberList가 비어있을때 --%>
				<c:when test="${empty requestScope.memberList}">
					<p>검색된 회원이 없습니다.</p>
				</c:when>
				
				<%-- memberList가 비어있지 않을 때 --%>
				<c:otherwise>
					
					<c:forEach var="member" items="${memberList}">
						
						<div class="search-div">
							<%-- var.필드명 --%>
							<p>닉네임 : ${member.memberNickname}</p>
							<p>이메일 : ${member.memberEmail}</p>
							<p>전화번호 : ${member.memberTel}</p>
						</div>
						
					</c:forEach>
					
				</c:otherwise>
			</c:choose>
		</section>
	
	</main>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
</body>
</html>