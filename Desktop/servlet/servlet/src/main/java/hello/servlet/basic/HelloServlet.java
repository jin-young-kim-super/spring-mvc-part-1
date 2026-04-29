package hello.servlet.basic;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 순수 Servlet 환경 : Tomcat이 직접 @WebServlet을 스캔하여 Servlet Container에 등록
// Spring Boot 환경 : @ServletComponentScan에 의해 톰캣이 아닌 스프링 부트가 Servlet Container에 등록
// → Servlet Container의 관리는 전적으로 Tomcat의 역할이므로, Servlet 객체를 꺼내올 때에는 Tomcat이 한다.
@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // 실행 흐름 : 애플리케이션 시작 -> @WebServlet을 보고 서블릿 컨테이너에 등록 -> 요청 발생 -> url을 보고 서블릿 컨테이너에서 서블릿 객체 들고 옴 -> 해당 서블릿 객체의 service() 메서드
    // 호출 -> 개발자가 오버라이딩한 service 실행
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello.servlet.service");
        System.out.println("request = " + request); // Tomcat이 요청이 들어 오면 Request 객체를 HTTP 표준 스펙에 맞춰 생성해서 던져 준다
        System.out.println("response = " + response); // Tomcat이 요청이 들어 오면 Response 객체를 HTTP 표준 스펙에 맞춰 생성해서 던져 준다

        // HTTP Request 데이터
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // HTTP Response 데이터
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("Hello " + username); // response.getWriter() : HTTP Response의 Representation Body
    }
}
