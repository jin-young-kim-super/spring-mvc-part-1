package hello.servlet.web.springmvc.oldversion;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component("/springmvc/old-controller") // 결국엔, 스프링 빈의 이름 지정이다. 스프링 빈의 이름이 url형식으로 돼 있는 것 뿐
public class OldVersionController implements Controller {
    @Override
    public @Nullable ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldVersionController.handleRequest");
        return new ModelAndView("new-form");
    }
}
