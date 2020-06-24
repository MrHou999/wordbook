package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

/**
 * Servlet implementation class SelectWordsServlet
 */
@WebServlet(name = "SelectWordsServlet", urlPatterns = {"/SelectWordsServlet"})

public class SelectWordsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet # HttpServlet()
     */
    public SelectWordsServlet() {
    	
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
		
		List<Map<String, Object>> list = null;
		
		// ��ȡ��������
		String act = request.getParameter("act");
		
		// ������ѯ
		if ("condition".equals(act)) {
			
			String keyword = request.getParameter("keyword");
			list = ms.searchWord(keyword);
			
		} else {
			
			list = ms.selectWords();
			
		}
		
		
		request.setAttribute("AllWords", list);
		RequestDispatcher rds = null;
		
		// ��ѯҳ��
		if ("select".equals(act) || "condition".equals(act)) {
			
			rds = request.getRequestDispatcher("Manager/SelectWord.jsp");
			
		}
		
		// �޸Ĳ�ѯҳ��
		else if ("updateSelect".equals(act)) {
			
			rds = request.getRequestDispatcher("Manager/UpdateWord.jsp");
			
		}
		
		// ɾ����ѯҳ��
		else if ("deleteSelect".equals(act)) {
			
			rds = request.getRequestDispatcher("Manager/DeleteWord.jsp");
			
		}

		assert rds != null;
		rds.forward(request, response);
		
	}

}
