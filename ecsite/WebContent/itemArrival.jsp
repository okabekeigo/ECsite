<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>ItemArrival画面</title>


<style type="text/css">
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}

#top {
	width: 100%;
	margin: 30px auto;
	border: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}

#left {
	float:left;
	width: 55%;
}

table{
	float:right;
}

#right {
	float:left;
	width: 45%;
}

.buy{
	float:left;
	margin-left:5px;
	text-align:right;
}

.blank{
	line-height:28px
}

.in {
	display: inline;
}

.back{
	clear:both;
/* 	margin-top:140px; */
}

</style>
</head>
<body>

	<div id="header">
		<div id="pr"></div>
	</div>

	<div id="main">
		<div id="top">
			<p>ItemArrival</p>
		</div>

		<h3>在庫追加する商品を選んでください。</h3>

		<div id="left">
			<table border=1>
				<tr>
					<th>商品名</th>
					<th>値段</th>
					<th>在庫数</th>
				</tr>
				<s:iterator value="itemArrivalDTOList">
					<tr>
						<td><s:property value="itemName" /></td>
						<td><s:property value="itemPrice" /><span>円</span></td>
						<td><s:property value="itemStock" /><span>個</span></td>
					</tr>
				</s:iterator>
			</table>
		</div>

		<div id="right">
			<div class="buy">
				<br class="blank">
				<s:iterator value="ItemArrivalDTOList">
					<s:form action="ItemArrivalNumberAction" cssStyle="margin-top:2px">
						<input type="hidden" name="choice"
							value="<s:property value='count' />" />
						<div class="in">
							<s:property value='itemName' />
						</div>を<input type="submit" value="追加" />
					</s:form>
				</s:iterator>
			</div>
		</div>

		<div class="back">
		<br>
		<a href='<s:url action="AdminAction" />'>管理者トップへ</a>
		</div>
	</div>
</body>
</html>