package eaut.it.functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import java.io.BufferedWriter;
import java.io.IOException;

public class HelloWorld implements HttpFunction {
    @Override
    public void service(HttpRequest request, HttpResponse response)
        throws IOException {
      //     var queryParams = request.getQueryParameters();
      //     var names = queryParams.get("name");
      //     var name = names!=null? names.get(0):"World";
      // BufferedWriter writer = response.getWriter();
      // writer.write(String.format("<h1>Hello %s!</h1>",name));
      response.setContentType("text/html");

        BufferedWriter writer = response.getWriter();
        String method = request.getMethod();
        if ("POST".equalsIgnoreCase(method)) {
            String username = request.getFirstQueryParameter("username").orElse("Guest");
            writer.write("<h1>Xin chào " + username + "</h1>");
        } else {
            writer.write("<form method=\"POST\" action=\"/\">");
            writer.write("  <label for=\"username\">Tên người dùng:</label>");
            writer.write("  <input type=\"text\" id=\"username\" name=\"username\">");
            writer.write("  <input type=\"submit\" value=\"Submit\">");
            writer.write("</form>");
        }
    }
  }
