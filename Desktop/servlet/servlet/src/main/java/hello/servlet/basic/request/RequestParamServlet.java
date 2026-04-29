package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1.HTTP Request의 GET Parameter 조회
 * →　localhost:8080?usernmae=kim&age=32
 *
 * 2.HTTP Form Data 조회
 * → hello-form.html
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // HTTP Request url : localhost:8080?usernmae=kim&age=32
        System.out.println("[전체 파라미터 조회] - START ");
        request.getParameterNames().asIterator().forEachRemaining(
                requestParamName -> System.out.println(requestParamName + " = " + request.getParameter(requestParamName)));
        System.out.println("[전체 파라미터 조회] - END ");
        System.out.println();

        // HTTP Request url : localhost:8080?usernmae=kim&age=32
        System.out.println("[단일 파라미터 조회] - START ");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - END ");
        System.out.println();

        // HTTP Request url : localhost:8080?usernmae=kim&age=32&username=hwang
        System.out.println("[복수 파라미터 조회] - START "); // 중복 Parameter를 사용하는 경우는 거의 없다. 사용할 경우에는 List 형태의 Parameter를 보냄
        String[] usernames = request.getParameterValues("username");
        for(String userName : usernames) {
            System.out.println("username = " + userName); // GET Parameter username이 복수 개 있을 때에는 반드시 getParametervalues()를 사용하자.
        }                                                 // → 만일 getParamter("username")으로 단일 조회 시, 제일 첫번째에 있는 username이 반환된다.
        System.out.println("[복수 파라미터 조회] - END ");
        System.out.println();

        response.getWriter().write("OK");
    }
}
