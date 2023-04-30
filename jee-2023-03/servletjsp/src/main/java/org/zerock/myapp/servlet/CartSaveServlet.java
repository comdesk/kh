package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/CartSave")
public class CartSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			//Step.1 장바구니에 저장할 상품항목을 전송파라미터로 획득
			String product = req.getParameter("product");
			log.info("\t+ product: {}", product);
			
			//Step.2 장바구니 생성 및 수신된 상품을 장바구니에 추가
			HttpSession sess = req.getSession();
			log.info("\t+ session id: {}", sess.getId());
			
			@SuppressWarnings("unchecked")
			List<String> list = (List<String>) sess.getAttribute("basket");
			
			if(list == null) {	//Session Scope에서 장바구니가 없으면
				list = new ArrayList<>();		//장바구니 새롭게 만들고

				sess.setAttribute("basket", list); //Session Scope에 올려놓고				
			} //if
			
			list.add(product);
			log.info("\t+ list: {}", list);
			
//			=======
			
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<html><body>");
			out.print("Product 추가");
			out.print("<h1>장바구니 담기 성공</h1>");
			out.println("</body></html>");
			
			out.flush();
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class







