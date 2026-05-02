package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV3 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // paramMap
        HashMap<String, String> paramMap = createParamMap(request);

        ModelView mv = controller.process(paramMap);
        String viewPath = mv.getViewPath();
        MyView myView = viewResolver(viewPath);
        myView.render(mv.getModel(),request,response);
    }

    private static @NonNull MyView viewResolver(String viewPath) {
        MyView myView = new MyView("/WEB-INFO/views/" + viewPath + ".jsp");
        return myView;
    }

    private static @NonNull HashMap<String, String> createParamMap(HttpServletRequest request) {
        HashMap<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
