package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    // 각 컨트롤러에서 new ModelView를 선언하지 않고 이제는 FrontController에서 Model 클래스를 넘겨 줄 것이다.
    // -> 프로그램은 마법이 아니기 때문에 어디에선가에서는 new Model을 해줘야 한다.

    /**
     *
     * @param paramMap
     * @param model
     * @return viewPath
     */
    public String process(Map<String,String> paramMap, Map<String,Object> model);
}
