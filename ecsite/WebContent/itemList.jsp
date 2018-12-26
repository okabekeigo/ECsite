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
<title>ItemList画面</title>


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

.left {
	width: 55%;
	float: left;
}

table {
	float: right;
}

.right {
	width: 45%;
	float: left;
}

.button {
	float: left;
	text-align: right;
	margin-left: 5px;
}

.blank {
	line-height: 98px;
}

.in {
	display: inline;
}

.back{
	clear:both;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}
</style>
</head>


<body>

	<div id="header">
		<div id="pr"></div>
	</div>

	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>

		<s:if test="itemListList.size() <= 0">
			<h3>商品情報はありません。</h3>
			<br>
			<a href='<s:url action="AdminAction" />'>管理者トップへ</a>
		</s:if>

		<s:elseif test="itemListList.size() > 0">
			<h3>商品情報は以下になります。</h3>
			<div class="left">
				<table border=1>
					<tr>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫数</th>
						<th>登録日時</th>
					</tr>
					<s:iterator value="itemListList">
						<tr>
							<td><s:property value="itemName" /></td>
							<td><s:property value="itemPrice" /><span>円</span></td>
							<td><s:property value="itemStock" /><span>個</span></td>
							<td><s:property value="insert_date" /></td>
						</tr>
					</s:iterator>
				</table>
				<br class="blank">
				<s:form action="ItemListDeleteConfirmAction" cssStyle="clear:both">
					<s:submit value="全件削除" />
				</s:form>
			</div>

			<div class="right">
				<div class="button">
					<br>
					<s:iterator value="itemListList">
						<s:form action="ItemDeleteCompleteAction"
							cssStyle="margin-top:10px;margin-bottom:-8px">
							<input type="hidden" name="itemChoice"
								value="<s:property value='itemRow' />" />
							<div class="in">
								<s:property value="itemName" />
							</div>を<input type="submit" value="削除" />
						</s:form>
					</s:iterator>
				</div>
			</div>

		</s:elseif>

		<div class="back">
			<br> <a href='<s:url action="AdminAction" />'>管理者トップへ</a>
		</div>
	</div>

	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>