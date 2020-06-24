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
		
		  // ��ö������ͣ�����ͨ�������ύ�����Կ���ͨ��request��ȡ
		String act = request.getParameter("act");
		RequestDispatcher rds = null;
		
		try {

			String word = request.getParameter("word");
			String meaning = request.getParameter("meaning");

			wd.setWord(word);
			wd.setMeaning(meaning);
			
		} catch (Exception e) {
			
			// ������������
			rds = request.getRequestDispatcher("Manager/Fixed.jsp");
			rds.forward(request, response);
			return;
			
		}

		ManagerService ms = new ManagerService();
		
		if ("add".equals(act)) {
			
			if (ms.addWord(wd)) {  // �ɹ�
				
				rds = request.getRequestDispatcher("SelectWordsServlet?act=select");
				
			} else {
				
				rds = request.getRequestDispatcher("Manager/Fixed.jsp");
				
			}
			
		} else if ("updateSelect".equals(act)) {

			// ����ʱ�ޱ�ţ��ʲ���Ҫ; �޸�ʱ��Ҫ���
			Integer wordId = Integer.parseInt(request.getParameter("wordId"));
			wd.setWordId(wordId);
			
			// �ɹ�
			if (ms.updateWord(wd)) {
				
				// ��ת����̨������
				rds = request.getRequestDispatcher("SelectWordsServlet?act=select");
				
			} else {
				
				// ʧ����ת���޸�ҳ��
				rds = request.getRequestDispatcher("Manager/Fixed.jsp");
				
			}
			
		}

		assert rds != null;
		rds.forward(request, response);
		
	}

}
