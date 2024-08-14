package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.db.LoginDao;
import com.board.db.LoginDto;


@WebServlet("/")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String view = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		if (com.equals("/index") || com.equals("/")) {
			view = "index.jsp";
		}
		
		else if(com.equals("/login")) {
			view = "L_login.jsp";
		}

		else if (com.equals("/loginProcess")) {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("username");
			String pw = request.getParameter("password");


			LoginDto dto = new LoginDto(id, pw,"dummy");
			LoginDao dao = new LoginDao();
			session.setAttribute("id", id);

			if (dao.checkUser(dto) == 1) {
				LoginDto name = dao.selectOne(id);
				session.setAttribute("uname", name.getName());
			}
			
			view = "index.jsp";
		}
		else if(com.equals("/update")) {
			view ="L_update.jsp";
		}
		else if(com.equals("/updateProcess")) {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("password");
			String name = request.getParameter("name");
			
			LoginDao dao = new LoginDao();
			LoginDto dto = new LoginDto(id,pw,name);
			dao.updateUser(dto);
			
			view = "redirect:logoutProcess";
			
		}
		else if(com.equals("/register")) {
			view = "L_join.jsp";
		}
		else if(com.equals("/registerProcess")) {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("username");
			String pw = request.getParameter("password");
			String name = request.getParameter("name");
			
			LoginDto dto = new LoginDto(id,pw,name);
			LoginDao dao = new LoginDao();
			try{
				dao.insertUser(dto);
				view="redirect:index";
			}catch(Exception e){
				request.setAttribute("errorMessage", e.getMessage());
                view = "errorBack.jsp";
			}
		}
		
		else if(com.equals("/logoutProcess")) {
			session.invalidate();
			view="redirect:index";
		}
		else if(com.equals("/delete")) {
			String id = (String)session.getAttribute("id");
			new LoginDao().deleteUser(id);
			session.invalidate();
			
			view = "redirect:index";
		}

		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
