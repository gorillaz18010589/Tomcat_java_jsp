<!-- 寫標籤也可以引用 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="x" required="true"%>
<%@ attribute name="y" required="true"%>


<!-- 讓app被宣告成全域變數 -->
<%@ variable name-given="add" %>
<%@ variable name-given="sub" %>
<%@ variable name-given="mulitiply" %>
<%@ variable name-given="divide" %>
<!-- 設置一個x+y的方法,因為這是區域變數其他看不到所以上面要加 -->
<c:set var="add" value='${x + y }'/>
<c:set var="sub" value='${x - y }'/>
<c:set var="mulitiply" value='${x * y }'/>
<c:set var="divide" value='${x / y }'/>

<!-- 代表add執行在裡面 -->
<jsp:doBody/>