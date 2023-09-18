package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.dto.Pizza;

@WebServlet("/pizzaOrder")
public class PizzaController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		
		pizzaList.add( new Pizza("치즈 피자", 8000) );
		pizzaList.add( new Pizza("콤비네이션 피자", 9000) );
		pizzaList.add( new Pizza("핫치킨 피자", 10000) );
		
		
		req.setCharacterEncoding("UTF-8");
		
		String pizza = req.getParameter("pizza"); // 1,2,3 중 하나
		
		String size = req.getParameter("size"); // R, L 중 하나
		
		String amount = req.getParameter("amount"); // 수량 (0 이상)
		
		
		// L 사이즈는 2천원 추가
		
		// 피자 종류 : 핫치킨 피자(L)
		// 수량 : 2
		// 총 가격 : 24000원
		
		
		
		// 피자 종류 파악
		// -> pizza는 "1" 처럼 문자열 -> 정수로 형변환(parsing) 필요
		Pizza p = pizzaList.get( Integer.parseInt(pizza) - 1 );
				
		String pizzaName = p.getName();
		int price = p.getPrice();
		
		// L 사이즈면 2천원 추가
		if(size.equals("L")) price += 2000;
		
		// price에 amount 값 곱하기
		price *= Integer.parseInt(amount);
		
		
		
		// req에 pizzaName, price를 속성으로 추가(세팅)
		req.setAttribute("pizzaName", pizzaName);
		req.setAttribute("price", price);
		
		
		// JSP로 요청 위임
		// JSP 경로 작성 기준 폴더 : webapp
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/pizzaResult.jsp");
		
		
		// 요청 위임
		dispatcher.forward(req, resp);
				
	}

}
