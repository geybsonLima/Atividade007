package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FaturaDao;

@WebServlet("/removerFatura")
public class RemoverContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 8720553500987085526L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		
		FaturaDao dao = new FaturaDao();
		dao.remover(Integer.parseInt(id));
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Fatura removida com sucesso!");
		out.println("</body>");
		out.println("</html>");
	}

}
