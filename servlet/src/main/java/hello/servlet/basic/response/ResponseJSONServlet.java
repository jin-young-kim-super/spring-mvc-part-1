package hello.servlet.basic.response;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseJSONServlet", urlPatterns = "/response-json")
public class ResponseJSONServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Content-Type
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        // messageBody
        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        // Object -> 문자열(JSON)
        String result = objectMapper.writeValueAsString(helloData);

        PrintWriter writer = response.getWriter();
        writer.println(result);

    }
}
