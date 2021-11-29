<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="cart.CartDAO" %>
<%@ page import="cart.CartDTO" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>중고마켓</title>
	<!-- 부트스트랩 CSS 추가하기 -->
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<!-- 커스텀 CSS 추가하기 -->
	<link rel="stylesheet" href="./css/cart.css" type="text/css">
	<!-- js 연동 -->
	<script type="text/javascript" src="js/cart.js"></script>
</head>

<body>
<%
	String userID = null;
	if(session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	 String cartName = null;
	 cartName = request.getParameter("cartName");
	 String cartId = null;
	 if(request.getParameter("cartId") != null) {
			cartId = request.getParameter("cartId");
	 } else {
		 System.out.println(cartId);
	 }
	 
	 
	 CartDTO cartData = new CartDAO().getCart(cartId);
%>

	
	<input type="hidden" name="cmd" value="order">
            <div class="basketdiv" id="basket">
                <div class="row head">
                    <div class="subdiv">
                        <div class="check">선택</div>
                        <div class="img">이미지</div>
                        <div class="pname">상품명</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice">가격</div>
                        <div class="num">수량</div>
                        <div class="sum">합계</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd">삭제</div>
                    </div>
                    <div class="split"></div>
                </div>

             <!-- 1번째 item -->
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="260" checked="" onclick="javascript:basket.checkItem();"></div>
                        <div class="img"><img src="./소주한잔.jpg" width="60"></div>
                        <div class="pname">
                            <span><%=cartName %></span>
                        </div>
                    </div>

                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="20000"><%--<%=cartData.getCartPrice() %>--%></div>
                        <div class="num"><%--<%=cartData.getCartCount() %>--%></div>
                        <div class="sum"><%--<%=cartData.getCartSum() %>--%></div>    
                    </div>

                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>



<!--                 2번째 item
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="261" checked="" onclick="javascript:basket.checkItem();">&nbsp;</div>
                        <div class="img"><img src="./소주한잔.jpg" width="60"></div>
                        <div class="pname">
                            <span>최현준</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price2" class="p_price" value="19000">19,000원</div>
                        <div class="num">1</div>
                        <div class="sum">19,000원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>
                
                3번째 item
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="262" checked="" onclick="javascript:basket.checkItem();">&nbsp;</div>
                        <div class="img"><img src="./소주한잔.jpg" width="60"></div>
                        <div class="pname">
                            <span>소훈석</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price3" class="p_price" value="15200">15,200원</div>
                        <div class="num">1</div>
                        <div class="sum">15,200원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div> -->
                
                
            </div>
    
    
            <div class="right-align basketrowcmd">
                <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delCheckedItem();">선택상품삭제</a>
                <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delAllItem();">장바구니비우기</a>
            </div>
            
            <!-- 선택 상품 -->
            <div id="goorder" class="">
                <div class="clear"></div>
                <div class="buttongroup center-align cmd">
                    <a href="javascript:void(0);">선택한 상품 주문</a>
                </div>
            </div>


	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가하기 -->
	<script src="./js/popper.js"></script>
	<!-- 부트스트랩 자바스크립트 추가하기 -->
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>