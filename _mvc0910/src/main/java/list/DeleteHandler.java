package list;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardService;
import command.CommandHandler;

// CommandHandler 인터페이스 구현하는 핸들러 "hello" 커맨드에 대한 처리 담당
public class DeleteHandler implements CommandHandler {

	@Override
	// CommandHandler 인터페이스의 process 메서드를 구현
	public String process(HttpServletRequest request, HttpServletResponse res) {
		
		int num = Integer.parseInt(request.getParameter("num"));

        new BoardService().deleteMsg(num);
        
        String tmp = request.getParameter("page");
        int pageNo = (tmp != null && tmp.length() > 0)
                ? Integer.parseInt(tmp) : 1;

        request.setAttribute("msgList",
                new BoardService().getMsgList(pageNo));
        request.setAttribute("pgnList",
                new BoardService().getPagination(pageNo));
		
		// 뷰 페이지로 "/WEB-INF/view/hello.jsp"를 반환
		return "/WEB-INF/view/list.jsp";//각 핸들러에서 결과값을 만들어 다시 controller에 결과값을 전달하고, controller에서 핸들러가 지정한 뷰로 forwarding 해준다.
	}
	/*
	   http://localhost:8080/chap18/controllerUsingFile?cmd=hello --> 결과값: 안녕하세요!
	   cmd는 ControllerUsingFile.java에서 String command = request.getParameter("cmd"); 해당 부분
	   HaspMap에서 hello 핸들러 찾기 --> CommandHandler handler = commandHandlerMap.get(command);
	   
	*/
}
