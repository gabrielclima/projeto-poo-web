package controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

/**
 * Servlet implementation class ServletRegistrarUsuario
 */
@WebServlet("/salvarUsuario")
public class ServletRegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login 			= request.getParameter("login");
		String nome 			= request.getParameter("nome");
		String senha 			= request.getParameter("senha");
		String senhaConf 		= request.getParameter("senhaConf");
		String cpf 				= request.getParameter("cpf");
		String dataNascimento 	= request.getParameter("dataNascimento");

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date data;
		
		try {
			data = format.parse(dataNascimento);
		} catch (ParseException e) {
			data = null;
		}
		
		Usuario usuario = new Usuario(login, senha, nome, cpf, data);
		boolean dadosOK = true;
		String pagina = null;
		String mensagem = null;
		
//		// TESTAR VALIDAÇÕES
//		if (data == null)
//		{
//			dadosOK = false;
//			mensagem = "A data de nascimento é inválida.";
//		}
//		else
//		if ((email == null) || (email.length() < 7))
//		{
//			dadosOK = false;
//			mensagem = "O e-mail é inválido.";
//		}
		
		if (dadosOK)
		{
			pagina = "confirmar-registro.jsp";
			UsuarioDAO dao = new UsuarioDAO();
			
			// INCLUIR O CANDIDATO NO BANCO
			dao.alterar(usuario);
		}
		else
		{
			pagina = "registrar.jsp";
		}
		
		request.setAttribute("usuario", usuario);
		request.setAttribute("mensagem", mensagem);

		RequestDispatcher disp = request.getRequestDispatcher(pagina);

		disp.forward(request, response);
	}

}
