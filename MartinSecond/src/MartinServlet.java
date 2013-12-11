import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.belhard.utils.StringUtils;

@WebServlet(description = "Kinda capthca servlet", urlPatterns = { "/MartinServlet" })
public class MartinServlet extends HttpServlet {

	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String celsius;
		request.setCharacterEncoding("UTF-8");

		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("<title>Conv</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Converter</h1>");
		out.println("</center>");
		out.println("<form action='MartinServlet' method='post'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<input type='text' name='temperature' />");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='right'>");
		out.println("<input type='submit' value='Check' />");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		if(request.getParameter("temperature") != null){
			int temperature = Integer.parseInt(request.getParameter("temperature"));
			out.println("<p>You entered " + temperature + "C, that's " + 
										   (temperature * 1.8 + 32) + "F");
		}
		out.println("</body>");
		out.println("</html>");

		//int temperature = request.getParameter(Celsius);
		//out.println(temperature*1.8+32);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
