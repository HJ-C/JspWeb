package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import productDto.DetailProdRespDto;
import productDto.IndexDto;
import productDto.InsertReqDto;
import productDto.DetailQnaRespDto;
import productDto.DetailReviewRespDto;
import user.UserDTO;
import com.shop.shop.service.CartService;
import com.shop.shop.service.FavorService;
import product.ProductService;
import com.shop.shop.service.QnaService;
import com.shop.shop.service.ReviewService;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    public ProductController() {
        super();
        this.productService = new ProductService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		RequestDispatcher dis; 

		if (cmd.equals("main")) {
			List<IndexDto> productList30 = productService.��ǰ��ü����(30);
			request.setAttribute("productList30", productList30);
			dis = request.getRequestDispatcher("/main.jsp");
			dis.forward(request, response);

		} else if (cmd.equals("detail")) {
			int prodNo = Integer.parseInt(request.getParameter("prodNo"));
			// ��ǰ ���� �޾ƿ��� ����
			DetailProdRespDto prodDto = productService.��ǰ�󼼺���(prodNo);
			request.setAttribute("prodDto", prodDto);
			// ��ǰ ���� �޾ƿ��� ��
			
			// �� ����, īƮ ���� �޾ƿ��� ����
			HttpSession session = request.getSession();
			User principal = (User) session.getAttribute("principal");
			if (principal != null) {
				int userId = principal.getId();
				
				FavorService favorService = new FavorService();
				boolean isFavor = favorService.�򿩺�(userId, prodNo);
				request.setAttribute("isFavor", isFavor);
				
				CartService cartService = new CartService();
				boolean isCart = cartService.��ٱ��Ͽ���(userId, prodNo);
				request.setAttribute("isCart", isCart);
			}
			// �� ����, īƮ ���� �޾ƿ��� ��
			
			// ���� ����, ����Ʈ �޾ƿ��� ����
			ReviewService reviewService = new ReviewService();
			int countReview = reviewService.�۰���(prodNo);
			List<DetailReviewRespDto> reviewList = reviewService.���������۸��(prodNo);
			request.setAttribute("countReview", countReview);
			request.setAttribute("reviewList", reviewList);
			// ���� ����, ����Ʈ �޾ƿ��� ��
			
			// Q&A ����, ����Ʈ �޾ƿ��� ����
			QnaService qnaService = new QnaService();
			int countQna = qnaService.�۰���(prodNo);
			List<DetailQnaRespDto> qnaList = qnaService.���������۸��(prodNo);
			request.setAttribute("countQna", countQna);
			request.setAttribute("qnaList", qnaList);
			// Q&A ����, ����Ʈ �޾ƿ��� ��

			dis = request.getRequestDispatcher("/product/product-page.jsp");
			dis.forward(request, response);

		} else if (cmd.equals("insertPage")) {
			dis = request.getRequestDispatcher("/product/newproduct.jsp");
			dis.forward(request, response);

		} else if (cmd.equals("insert")) {
			BufferedReader br = request.getReader();
			String data = br.readLine();
			Gson gson = new Gson();
			PrintWriter out = response.getWriter();
			
			InsertReqDto reqDto = gson.fromJson(data, InsertReqDto.class);
			int result = productService.��ǰ���(reqDto);
			
			if (result == 1) {
				out.print("200");
			} else {
				out.print("500");
			}
			out.flush();
			
		} else if (cmd.equals("search")) {
			List<IndexDto> searchedProductList = new ArrayList<>();
			String keyword = request.getParameter("keyword");
			String compNo = request.getParameter("compNo");
			if (keyword != null) {
				searchedProductList = productService.��ǰŰ����ã��(keyword);
				request.setAttribute("searchedProductList", searchedProductList);
			}
			if (compNo != null) {
				searchedProductList = productService.��ǰȸ���ڵ�ã��(Integer.parseInt(compNo));
				request.setAttribute("searchedProductList", searchedProductList);
			}
			if (searchedProductList.size() == 0) {
				List<IndexDto> productList30 = productService.��ǰ��ü����(30);
				request.setAttribute("productList30", productList30);
			}
			
			dis = request.getRequestDispatcher("/product/search.jsp");
			dis.forward(request, response);
			
		} else if (cmd.equals("rank")) {
			List<IndexDto> rankedProductList = productService.��ǰ����();
			request.setAttribute("rankedProductList", rankedProductList);
			
			dis = request.getRequestDispatcher("/product/rank.jsp");
			dis.forward(request, response);
			
		} else if (cmd.equals("category")) {
			List<IndexDto> allProductList = productService.��ǰ��ü����();
			request.setAttribute("allProductList", allProductList);
			
			dis = request.getRequestDispatcher("/product/categories.jsp");
			dis.forward(request, response);
			
		} else if (cmd.equals("cateListDefault")) {
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			
			List<IndexDto> allProductList = productService.��ǰ��ü����();
			String data = gson.toJson(allProductList);
			out.print(data);
			out.flush();
			
		} else if (cmd.equals("cateSort")) {
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			
			int compId = Integer.parseInt(request.getParameter("compId"));
			List<IndexDto> sortedProductList = productService.��ǰȸ���ڵ�ã��(compId);
			String data = gson.toJson(sortedProductList);
			out.print(data);
			out.flush();
			
		} else if (cmd.equals("soldCountUpdate")) {
			int prodId = Integer.parseInt(request.getParameter("prodId"));
			productService.���ż�����(prodId);
			
		}

	}
}