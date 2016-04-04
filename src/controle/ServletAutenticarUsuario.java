package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.FilmeDAO;
import modelo.dao.UsuarioDAO;
import modelo.dominio.Filme;
import modelo.dominio.Usuario;

/**
 * Servlet implementation class ServletAutenticar
 */
@WebServlet("/autenticar")
public class ServletAutenticarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutenticarUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403, "ACESSO NEGADO");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDAO daoUser = new UsuarioDAO();
		Usuario usuario = daoUser.obter(login);
		
		if (usuario.getSenha().equals(senha)){
			
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			
			FilmeDAO dao = new FilmeDAO();
			List<Filme> lista = dao.listar();
			
			request.setAttribute("lista", lista);
			
			if (usuario.isAdmin() || usuario.getLogin().equals("admin")) {
				request.getRequestDispatcher("painel-admin.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("catalogo.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("mensagem", "Login ou Senha inválida.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}











