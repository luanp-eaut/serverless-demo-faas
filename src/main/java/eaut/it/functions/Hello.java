package eaut.it.functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import java.io.BufferedWriter;
import java.io.IOException;

public class Hello implements HttpFunction {
    @Override
    public void service(HttpRequest request, HttpResponse response)
        throws IOException {
      response.setContentType("text/html");

        BufferedWriter writer = response.getWriter();
        String method = request.getMethod();
        if ("POST".equalsIgnoreCase(method)) {
            String username = request.getFirstQueryParameter("username").orElse("Guest");
            writer.write("<h1>Xin chào " + username + "</h1>");
        } else {
            writer.write("<form method=\"POST\" action=\"/\">");
            writer.write("  <label for=\"username\">Hãy nhập tên của bạn:</label>");
            writer.write("  <input type=\"text\" id=\"username\" name=\"username\">");
            writer.write("  <input type=\"submit\" value=\"Submit\">");
            writer.write("</form>");
        }
    }
  }
