import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    Model model = new Model();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("solostudent" , model.getStudent(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("/UpdateJsp.jsp").forward(req,resp);
            }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String newName = req.getParameter("newName");
        model.updateStudent(Integer.parseInt(id), newName);
        resp.sendRedirect(req.getContextPath()+"/controller");
    }
}
