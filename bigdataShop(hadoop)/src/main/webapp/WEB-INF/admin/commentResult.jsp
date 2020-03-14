<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bigdataShop/common/css/jqcloud.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="/bigdataShop/common/js/jqcloud-1.0.4.js"></script>
	
<script type="text/javascript">
	$(document).ready(function() {
		var word_array = [];
		size=${commentResult.size()}

		<c:forEach var="commentResult" items="${commentResult}">
			word_array.push({
				text : "${commentResult.word}",
				weight : "${commentResult.count}"
			})
		</c:forEach>
		$(function() {
			$("#jQCloud").jQCloud(word_array);
		});
	});
	</script>

</head>
<body>
	<h1>상품댓글분석</h1>
	<div style="float: left; width: 30%;">
		<table class="table" style="border-collapse: collapse;">
				<tr>
					<td>키워드</td>
					<td>반복횟수</td>
				</tr>
				<c:forEach var="commentResult" items="${commentResult}">
				<tr>
					<td>${commentResult.word}</td>
					<td>${commentResult.count}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="jQCloud" style="float: left; width: 500px; height: 348px;">
	</div>

</body>
</html>