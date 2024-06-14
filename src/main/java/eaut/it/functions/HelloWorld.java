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
          var query = request.getQueryParameters();
          var names = query.get("name");
          var name = names!=null? names.get(0):"World";
      BufferedWriter writer = response.getWriter();
      writer.write(String.format("Hello %s!",name));
    }
  }
