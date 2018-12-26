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
<title>Cart画面</title>


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

#space {
	float: right;
	width: 1px;
	height: 500px;
}

#main {
	width: 100%;
	text-align: center;
}

#left {
	float: left;
	width: 57%;
}

.table {
	float: right;
}

#right {
	float: left;
	margin-top: 30px;
	margin-bottom: 20px;
}

.cbox {
	float: left;
	margin-top: 2px;
}

.clear {
	clear: both;
}

.blank {
	margin-top: 50px;
}

.money {
	color: red;
}

#under {
	float: left;
	width: 99%;
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

	<div id="space"></div>

	<div id="main">
		<div id="top">
			<p>Cart</p>
		</div>

		<s:if test="cartDTOList.size() <= 0">
			<h3>カートに商品がありません。</h3>
			<br>
			買い物を続けるには<a href="<s:url action='HomeAction' />">こちら</a>
			<br>
			Homeへ戻る場合は<a href="<s:url action='GoHomeAction' />">こちら</a>
		</s:if>

		<s:if test="cartDTOList.size() > 0">
			<div id="left">
				<table class="table" border=1>
					<tr>
						<td>商品名</td>
						<td>合計金額</td>
						<td>購入個数</td>
					</tr>
					<s:iterator value="cartDTOList">
						<tr>
							<td><s:property value="itemName" /></td>
							<td><s:property value="totalPrice" /></td>
							<td><s:property value="totalCount" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>

			<s:form id="right" action="CartDeleteAction">
				<div class="cbox">
					<s:iterator value="cartDTOList">
						<s:checkbox name="check" fieldValue="%{cartRow}"
							cssStyle="margin-top:4px" />
					</s:iterator>
				</div>
				<s:submit value="カートから削除" cssStyle="margin-top:10px" />
			</s:form>

			<div id="under">
				<br class="clear"> 買い物を続けるには<a
					href='<s:url action="HomeAction" />'>こちら</a> <br>

				<div class="blank">
					カートの総計金額は<span class="money"><s:property value="allPrice" />円</span>です。
					<br>
					<s:form action="CartConfirmAction">
						<h3>お支払い方法を選択してください。</h3>
						<label><input type="radio" name="pay" value="1"
							checked="checked" />現金払い</label>
						<label><input type="radio" name="pay" value="2" />クレジットカード</label>
						<s:submit value="購入確定画面へ" />
					</s:form>
				</div>
			</div>
		</s:if>
	</div>


	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>