<%--
  Created by IntelliJ IDEA.
  User: 13957
  Date: 2021/6/10
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/pages/common/head.jsp"%>
    <Script type="text/javascript">
        $(function () {
            // 给加入购物车按钮绑定单击事件
            $(".addToCart2").click(function () {
                // return confirm("添加成功!");
                /**
                 * 在事件响应的function函数 中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
                 * @type {jQuery}
                 */
                var bookId = $(this).attr("bookId");
                // location.href = "http://localhost:8080/book/cartServlet?action=addItem&id=" + bookId;

                // 发ajax请求，添加商品到购物车
                $.getJSON("http://localhost:8080/book/cartServlet","action=ajaxAddItem&id=" + bookId,function (data) {
                    $("#cartTotalCount").text("您的购物车中有 " + data.totalCount + " 件商品");
                    $("#cartLastName").text(data.lastName);
                })
                alert("添加成功");

            });




        });
    </Script>
</head>
<body>
<div class="b_list2">
<div class="book_info2">
    <div class="img_div2">
        <%--					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>--%>
        <img class="book_img2" alt="" src="${book.imgPath}" />
        <%--					<img class="book_img" alt="" src="${book.imgPath}" />--%>
    </div>
    <div class="book_name2">
        						<span class="sp1"></span>
        						<span class="sp2">${book.name}</span>
    </div>
    <div class="book_author2">
        						<span class="sp1"></span>
        						<span class="sp2">${book.author}编著</span>
    </div>
    <div class="book_price2">
        						<span class="sp1"></span>
        <span class="jg2">￥${book.price}</span>
    </div>
    <div class="book_sales2">
        						<span class="xl">销量:${book.sales}</span>
<%--        <span class="xl2">${book.sales}人付款</span>--%>
    </div>
    <div class="book_amount2">
        						<span class="sp1">库存:</span>
        						<span class="sp2">${book.stock}</span>
    </div>
    <div class="book_add2">
<%--        						<a href="pages/cart/cart.jsp" bookId="${book.id}" class="addToCart">加入购物车</a>--%>
        						<span bookId="${book.id}" class="addToCart2">加入购物车</span>
<%--    ${book.id}--%>
    </div>
</div>
</div>
</body>
</html>
