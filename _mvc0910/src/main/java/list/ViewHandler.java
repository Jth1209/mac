package list;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardService;
import command.CommandHandler;

// CommandHandler 인터페이스 구현하는 핸들러 "hello" 커맨드에 대한 처리 담당
public class ViewHandler implements CommandHandler {

	@Override
	// CommandHandler 인터페이스의 process 메서드를 구현
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		// 기존 com.board.controller의 view 실행 코드를 가져와 일부분 수정함
		int num = Integer.parseInt(req.getParameter("num"));

        req.setAttribute("msg", new BoardService().getMsg(num));
		
		// 뷰 페이지로 "/WEB-INF/view/hello.jsp"를 반환
		return "/WEB-INF/view/view.jsp";
	}
	/*
	   http://localhost:8080/chap18/controllerUsingFile?cmd=hello --> 결과값: 안녕하세요!
	   cmd는 ControllerUsingFile.java에서 String command = request.getParameter("cmd"); 해당 부분
	   HaspMap에서 hello 핸들러 찾기 --> CommandHandler handler = commandHandlerMap.get(command);
	   
	*/
}
