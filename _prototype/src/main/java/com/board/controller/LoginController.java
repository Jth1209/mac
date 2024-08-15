package com.board.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.db.BoardDao;
import com.board.db.BoardDto;
import com.board.db.LoginDao;
import com.board.db.LoginDto;
import com.board.db.cartDAO;
import com.board.db.cartpDTO;
import com.board.db.productDao;
import com.board.db.productDto;
import com.board.service.BoardService;
import com.board.service.CartService;
import com.board.service.ProductService;


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
		
		//게시판 기능-------------------------------------------------------------------------
		else if (com.equals("/list")) {
            String tmp = request.getParameter("page");
            int pageNo = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 1;

            request.setAttribute("msgList",
                    new BoardService().getMsgList(pageNo));
            request.setAttribute("pgnList",
                    new BoardService().getPagination(pageNo));
            view = "list.jsp";

        } else if (com.equals("/view")){
            int num = Integer.parseInt(request.getParameter("num"));
            new BoardDao().updateHits(num);
            request.setAttribute("msg", new BoardService().getMsg(num));
            view = "view.jsp";

        } else if (com.equals("/write")){
            String tmp = request.getParameter("num");
            int num = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 0;

            BoardDto dto = new BoardDto();
            String action = "insert";

            if (num > 0) {
                dto = new BoardService().getMsgForWrite(num);
                action = "updateB?num=" + num;
            }

            request.setAttribute("msg", dto);
            request.setAttribute("action", action);
            view = "write.jsp";

        } else if (com.equals("/insert")){
            request.setCharacterEncoding("utf-8");
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");
            String regtime = LocalDate.now() + " " +
                    LocalTime.now().toString().substring(0, 8);

            try {
                new BoardService().writeMsg(writer, title, content, regtime);
                view = "redirect:list";

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "errorBack.jsp";
            }

        } else if (com.equals("/updateB")){
            request.setCharacterEncoding("utf-8");
            int num = Integer.parseInt(request.getParameter("num"));
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");
            String regtime = LocalDate.now() + " " +
                    LocalTime.now().toString().substring(0, 8);

            try {
                new BoardService().updateMsg(writer, title, content, num,regtime);
                view = "redirect:list";

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "errorBack.jsp";
            }

        } else if (com.equals("/deleteB")){
            int num = Integer.parseInt(request.getParameter("num"));

            new BoardService().deleteMsg(num);
            view = "redirect:list";
        }
		//쇼핑몰과 장바구니 기능----------------------------------------------------------------
		
        else if (com.equals("/shop")) {
            String tmp = request.getParameter("page");
            int pageNo = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 1;

            request.setAttribute("productList",
                    new ProductService().getPList(pageNo));
            request.setAttribute("pgnList",
                    new ProductService().getPagination(pageNo));
            view = "shop.jsp";
        }
        else if(com.equals("/deleteP")) {
        	String id = request.getParameter("id");
        	new productDao().deleteProduct(Integer.parseInt(id));
        	view = "redirect:shop";
        }
        else if(com.equals("/writeP")) {
        	 String tmp = request.getParameter("id");
             int id = (tmp != null && tmp.length() > 0)
                     ? Integer.parseInt(tmp) : 0;

             productDto dto = new productDto();
             String action = "insertP";

             if (id > 0) {
                 dto = new ProductService().getProForWrite(id);
                 action = "updateP?id=" + id;
             }

             request.setAttribute("msg", dto);
             request.setAttribute("action", action);
             view = "P_update.jsp";
        }
        else if(com.equals("/updateP")) {
        	request.setCharacterEncoding("UTF-8");
        	int id = Integer.parseInt(request.getParameter("id"));
        	String name = request.getParameter("name");
        	String description = request.getParameter("description");
        	int price = Integer.parseInt(request.getParameter("price"));
        	int stock = Integer.parseInt(request.getParameter("stock"));
        	
        	 try {
                 new ProductService().updatePro(name,description,price,stock,id);
                 view = "redirect:shop";

             } catch(Exception e) {
                 request.setAttribute("errorMessage", e.getMessage());
                 view = "errorBack.jsp";
             }
        }
        else if(com.equals("/insertP")) {
        	request.setCharacterEncoding("UTF-8");
        	String name = request.getParameter("name");
        	String description = request.getParameter("description");
        	int price = Integer.parseInt(request.getParameter("price"));
        	int stock = Integer.parseInt(request.getParameter("stock"));
        	
        	try {
                new ProductService().writePro(name,description,price,stock);
                view = "redirect:shop";

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "errorBack.jsp";
            }
        }
		//장바구니 기능----------------------------------------------------------------
		
        else if(com.equals("/cart")) {
        	int id = Integer.parseInt(request.getParameter("id"));
        	int check = new cartDAO().check(id);
        	if(check <= 1) {
        		List<cartpDTO> dto = new CartService().showCart();
        		request.setAttribute("cart", dto);
        	}else {
        		new CartService().insertCart(id);
        		List<cartpDTO> dto = new CartService().showCart();
        		request.setAttribute("cart", dto);
        	}
        	view = "cart.jsp";
        }
       
        else if(com.equals("/plus")) {
        	int id = Integer.parseInt(request.getParameter("id"));
        	int stock = new cartDAO().selectStock(id);
        	int quantity = new cartDAO().selectQuantity(id);
        	if(stock == quantity) {
        	}else {
        		new cartDAO().plusQuantity(id);
        	}
        	view="redirect:cart";
        }
        
        else if(com.equals("/minus")) {
        	int id = Integer.parseInt(request.getParameter("id"));
        	int quantity = new cartDAO().selectQuantity(id);
        	if(quantity == 0) {
        
        	}else {
        		new cartDAO().minusQuantity(id);
        	}
        	view="redirect:cart";
        }
        
        else if(com.equals("/deleteC")) { 
        	int id = Integer.parseInt(request.getParameter("id"));
        	new cartDAO().deleteCart(id);
        	view = "redirect:cart";
        }
		
		//redirect 와 forwarding	 구분 쿼리
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
