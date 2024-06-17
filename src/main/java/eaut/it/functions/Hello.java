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
            writer.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">");
            writer.write("    <title>Serverless Demo</title>");
            writer.write("</head>");
            writer.write("<body class=\"d-flex justify-content-center align-items-center vh-100\">");
            writer.write("    <div class=\"card\" style=\"width: 600px;\">");
            writer.write("        <div class=\"card-body\">");
    
            if ("POST".equalsIgnoreCase(method)) {
                String username = request.getFirstQueryParameter("username").orElse("Guest");
                writer.write("                <h1 class=\"text-center\">Xin chào " + username + "</h1>");
            } else {
                writer.write("            <form method=\"POST\" action=\"/serverless-demo\" class=\"form\">");
                writer.write("                <div class=\"mb-3\">");
                writer.write("                    <label for=\"username\" class=\"form-label fw-bold\">Hãy nhập tên của bạn:</label>");
                writer.write("                    <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\" placeholder=\"Guest\">");
                writer.write("                </div>");
                writer.write("                <button type=\"submit\" class=\"btn btn-primary\">Submit</button>");
                writer.write("            </form>");
            }
    
            writer.write("        </div>");
            writer.write("    </div>");
            writer.write("</body>");
            writer.write("</html>");
        }
    }
