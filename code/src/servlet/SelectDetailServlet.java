package servlet;

import java.io.IOException;
import java.util.Iterator;
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
 * Servlet implementation class DetailServlet
 */
@WebServlet(name = "SelectDetailServlet", urlPatterns = {"/SelectDetailServlet"})
public class SelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
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
		// ��ȡ��Ʒ���
		Integer wordId = Integer.parseInt(request.getParameter("wordId"));
		
		String act = request.getParameter("act");
		
		ManagerService ms = new ManagerService();
		List<Map<String, Object>> list = ms.selectAWord(wordId);
		
		
		// ��һ����Ʒ��ϸ����Ϣ�洢��request��
		request.setAttribute("AWord", list.get(0));
		RequestDispatcher rds = null;
		
		// �޸�һ����Ʒҳ��
		if (act.equals("updateAWord")) {
			
			rds = request.getRequestDispatcher("Manager/UpdateWordDetail.jsp");
			
		}

		assert rds != null;
		rds.forward(request, response);
		
	}

}
