<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="article">
			<div class="active-content">
				<h1>首页>>个人中心>>我的建议</h1>
			</div>
			<div class="companyProfile">
				
				<jsp:include page="/page/user/user_left.jsp"></jsp:include>
				
					<div class="recommend-text">
						<textarea cols="60" rows="5"></textarea>
					</div>
					<div class="yijian">
						<a href="#">发表意见</a>
					</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
	</body>

</html>