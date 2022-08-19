import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

    public class GetParameter extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String firstName = request.getParameter("firstname");
            String middleName = request.getParameter("middlename");
            String lastName = request.getParameter("lastname");
            out.println("<b><font color='blue'>Your FirstName is :</font></b>"
                    + "<b>"+ firstName +"</b>" + "<br>");
            out.println("<b><font color='blue'>Your Middle Name is :</font></b>"
                    + "<b>"+ middleName +"</b>" + "<br>");
            out.println("<b><font color='blue'>Your Last Name is :</font></b>"
                    + "<b>"+ lastName +"</b>");
        }
    }

