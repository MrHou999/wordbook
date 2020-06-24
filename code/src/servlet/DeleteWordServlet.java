package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

/**
 * Servlet implementation class DeleteWordServlet
 */
@WebServlet(name = "DeleteWordServlet", urlPatterns = {"/DeleteWordServlet"})
public class DeleteWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWordServlet() {
        
    	super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ManagerService ms = new ManagerService();
		PrintWriter out = response.getWriter();
		
		String act = request.getParameter("act");
		boolean rs = false;
		
		if (act.equals("link")) {
			
			Integer wordId = Integer.parseInt(request.getParameter("wordId"));
			
			rs = ms.deleteAWord(wordId);
			
		} else if (act.equals("button")) {

			String[] wordValues = request.getParameterValues("wordId");
			Integer[] wordIds = new Integer[wordValues.length];

			for (int i = 0; i < wordValues.length; i++) {

				wordIds[i] = Integer.parseInt(wordValues[i]);

			}
			
			rs = ms.deleteWords(wordIds);
			
		}
		
	
		if (rs) {
			
			// 返回查询页面
			out.println("删除成功, 3s后返回!");
			
		} else {
			
			out.println("删除失败! 3s后返回!");
			
		}
		
		response.setHeader("refresh", "3; url=SelectWordsServlet?act=deleteSelect");
		
	}

}
