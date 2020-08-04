<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${basePath }js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }js/jquery/jquery.backstretch.min.js"></script>
</head>
<body>
	当前的SessionId：${sessionScope.loginSessionId}
	<hr />
	<button onclick="test()">请求测试</button>
	<script>
		function test() {
			$.ajax({
				type : "get",
				url : "http://localhost:8899/travel/test",
				//在发送请求前设置请求头
				/*beforeSend:function (request) {
					request.setRequestHeader("xydLoginToke","c895826d-2a74-4cd6-b0c4-0718541ef0a5");
				}*/
				headers : {
					"xydLoginToke" : "6f207780-17ff-41ea-886e-0a4c7f6b259d"
				},
				success : function() {
					alert("请求成功！");
				},
				error : function() {
					alert("请求失败！");
				}
			});
		}
	</script>

</body>
</html>