package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FaturaDao;
import entidades.Fatura;

@WebServlet("/listarFatura")
public class ListarFaturaServlet extends HttpServlet {

	private static final long serialVersionUID = -4481860843250088957L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String nome = req.getParameter("NOME");
		String COD_FATURA = req.getParameter("COD_FATURA");
		
		FaturaDao dao = new FaturaDao();
		List<Fatura> lista = dao.listar(NOME, COD_FATURA);

		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<form action='listarFatura'>");
		out.println("Nome: <input type='text' name='nome' /> <br />");
		out.println("COD_FATURA: <input type='text' name='COD_FATURA' /> <br />");
		out.println("<input type='submit' value='Filtrar' />");
		out.println("</form>");
		
		out.println("<table border='1' style='width: 100%;'>");
		out.println("<tr>");
		out.println("<td> ID </td>");
		out.println("<td> NOME </td>");
		out.println("<td> DATA_VENCIMENTO </td>");
		out.println("<td> VALOR_TOTAL </td>");
		out.println("</tr>");

		for (Fatura Fatura : lista) {

			out.println("<tr>");
			out.println("<td> " + contato.getId() + " </td>");
			out.println("<td> " + contato.getNome() + " </td>");
			out.println("<td> " + contato.getDATA_VENCIMENTO() + " </td>");
			out.println("<td> " + contato.getVALOR_TOTAL() + " </td>");
			out.println("<td> ");
			out.println("<a href='exibirAlterarFatura?id=" + Fatura.getId() + " '>Alterar</a> &nbsp;");
			out.println("<a href='removerFatura?id=" + Fatura.getId() + " '>Remover</a>");
			out.println("</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
