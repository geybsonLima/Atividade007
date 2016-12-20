package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FaturaDao;
import entidades.Fatura;

@WebServlet("/exibirAlterarFatura")
public class ExibirAlterarFaturaServlet extends HttpServlet {

	private static final long serialVersionUID = 7990124468286661040L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		
		FaturaDao dao = new FaturaDao();
		Fatura Fatura = dao.buscarPorId(Integer.parseInt(id));
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<form action='alterarFatura'>");
		out.println("<input type='hidden' name='id' value='"+Fatura.getId()+"'>");
		out.println("Nome: <input type='text' name='nome' value='"+Fatura.getNome()+"' /> <br />");
		out.println("DATA_VENCIMENTO: <input type='text' name='DATA_VENCIMENTO' value='"+contato.getDATA_VENCIMENTO()+"' /> <br />");
		out.println("VALOR_TOTAL: <input type='text' name='VALOR_TOTAL' value='"+Fatura.getVALOR_TOTAL()+"' /> <br />");
		out.println("<input type='submit' value='Alterar' />");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
