package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.WordDTO;
import service.ManagerService;

/**
 * Servlet implementation class AddWordServlet
 */
@WebServlet(name = "AddWordServlet", urlPatterns = {"/AddWordServlet"})
public class AddWordServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWordServlet() {
    	
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
		
		WordDTO  wd = new WordDTO();
		
		  // 获得动作类型，不是通过表单域提交，所以可以通过request获取
		String act = request.getParameter("act");
		RequestDispatcher rds = null;
		
		try {

			String word = request.getParameter("word");
			String meaning = request.getParameter("meaning");

			wd.setWord(word);
			wd.setMeaning(meaning);
			
		} catch (Exception e) {
			
			// 数据输入有误
			rds = request.getRequestDispatcher("Manager/Fixed.jsp");
			rds.forward(request, response);
			return;
			
		}

		ManagerService ms = new ManagerService();
		
		if ("add".equals(act)) {
			
			if (ms.addWord(wd)) {  // 成功
				
				rds = request.getRequestDispatcher("SelectWordsServlet?act=select");
				
			} else {
				
				rds = request.getRequestDispatcher("Manager/Fixed.jsp");
				
			}
			
		} else if ("updateSelect".equals(act)) {

			// 插入时无编号，故不需要; 修改时需要编号
			Integer wordId = Integer.parseInt(request.getParameter("wordId"));
			wd.setWordId(wordId);
			
			// 成功
			if (ms.updateWord(wd)) {
				
				// 跳转到后台主界面
				rds = request.getRequestDispatcher("SelectWordsServlet?act=select");
				
			} else {
				
				// 失败跳转到修改页面
				rds = request.getRequestDispatcher("Manager/Fixed.jsp");
				
			}
			
		}

		assert rds != null;
		rds.forward(request, response);
		
	}

}
