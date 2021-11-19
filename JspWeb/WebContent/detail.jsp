<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="product.ProductDAO" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>중고마켓</title>
	<!-- 부트스트랩 CSS 추가하기 -->
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<!-- 커스텀 CSS 추가하기 -->
	<link rel="stylesheet" href="./css/Detail.css" type="text/css">
</head>
<body>
<c:set var ="pdPrice" value="${product.getPrice }"/>
<c:set var ="pdId" value="${product.getProductId }"/>
<c:set var ="pdName" value="${product.getProductName }"/>
<c:set var ="pdDetail" value="${product.getProductDetail }"/>
<!-- Header -->
    <header id="header">
        <div class="search">
            <span class="search__logo">
                <a href="./index.jsp">Market</a>
            </span>            
            <span class="search__input">
                <input type="text" name="word" id="word">
                <button type="button" id="button"><i class="fas fa-search"></i></button>
            </span>
        </div>
    </header>   
    
  <!-- Section -->  
    <section id="goodsdeatil">
        <!-- 상품정보 -->
        <div id="title">
            <!-- 상품이미지 -->
            <div id="goodsImg" class="goodsinfo">
                <img id="goodsImg__img" src="./images/소주한잔.jpg">
            </div>
            <!--상품개요  -->
            <div id="goodsSummary" class="goodsinfo">
                <!-- 상품명 -->
                <div id="goods-name">
                	<fmt:formatNumber value="${product.getProductName }" type="string" />
                </div>
                <!-- 상품가격 -->
                <div id="goods-price">
                	<fmt:formatNumber value="${product.getPrice }" type="number" />
                	<span>원</span>
                </div>
                <!-- 상품수량선택 -->
                <div id="option">
                    <div class="option__label">수량</div>
                    <div class="option__select">
                        <input type="text" name="opt" id="opt"  class="opt" value="1" readonly>
                        <input type="button" value="+" class="opt">
                        <input type="button" value="-" class="opt">
                    </div>
                </div>
                
                <!-- 상품옵션선택 -->
                <div id="option">
                    <div class="option__label"><label for="opt">옵션선택</label></div>
                    <div class="option__select">
                        <select name="opt" id="opt">
                            <option value="opt-name">옵션명</option>
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>                            
                        </select>                       
                    </div>                                                                                                                        
                </div> 
                
   				<!-- 장바구니 | 구매하기 -->
                <div id="order">
                    <!-- 서버 -->
                    <span class="order__Btn"><input class="order__input c1" type="button" value="장바구니"></span> 
                    <span class="order__Btn"><input class="order__input c2" type="button" value="구매하기"></span> 
                </div>
            </div>    
        </div>      

        <!-- Taps -->
        <ul class="nav nav-tabs">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">제품설명
              	<fmt:formatNumber value="${product.getProductDetail }" type="string" />
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">QnA</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">기타등등</a>
              </li>
          </ul>
          
    </section>  


	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가하기 -->
	<script src="./js/popper.js"></script>
	<!-- 부트스트랩 자바스크립트 추가하기 -->
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>