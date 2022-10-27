package com.tibame.ball.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tibame.ball.common.LocalDateAdapter;
import com.tibame.ball.member.sevice.impl.MemberServiceImpl;
import com.tibame.ball.member.vo.MemberVO;

@WebServlet("/MemberGetAll")
public class MemberGetAll extends HttpServlet {
	
	public MemberServiceImpl service;
	private static final long serialVersionUID = 1L;
    private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(1111);
		
		List<MemberVO> list = service.getAll();
		System.out.println(list);
		
		
		
		response.setContentType("application/json");
		try (PrintWriter pw = response.getWriter()) {
			pw.print(gson.toJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setHeaders(response);
	}

	private void setHeaders(HttpServletResponse response) {

		response.setContentType("application/json;charset=UTF-8"); // 重要
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		response.addHeader("Access-Control-Allow-Origin", "*"); // 重要
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}
}
