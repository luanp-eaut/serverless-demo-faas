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

        writer.write("<!DOCTYPE html>");
        writer.write("<html lang=\"en\">");
        writer.write("<head>");
        writer.write("    <meta charset=\"UTF-8\">");
        writer.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        writer.write("    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        writer.write("    <title>Hello User</title>");
        writer.write("</head>");
        writer.write("<body class=\"d-flex justify-content-center align-items-center vh-100\">");
        writer.write("    <div class=\"container\">");

        if ("POST".equalsIgnoreCase(method)) {
             String username = request.getFirstQueryParameter("username").orElse("Guest");
            writer.write("        <div class=\"alert alert-primary\" role=\"alert\">");
            writer.write("            <h1>Xin chào " + username + "</h1>");
            writer.write("        </div>");
        } else {
            writer.write("        <form method=\"POST\" action=\"/serverless-demo\" class=\"form-inline\">");
            writer.write("            <div class=\"form-group mb-2\">");
            writer.write("                <label for=\"username\" class=\"sr-only\">Tên người dùng:</label>");
            writer.write("                <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\" placeholder=\"Tên người dùng\">");
            writer.write("            </div>");
            writer.write("            <button type=\"submit\" class=\"btn btn-primary mb-2\">Submit</button>");
            writer.write("        </form>");
        }
    }
  }
