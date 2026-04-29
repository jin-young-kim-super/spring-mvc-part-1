package hello.servlet.basic;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter    // JACKSON 라이브러리(스프링의 기본 json 라이브러리) : JSON으로의 변환 시 setter 필요(JAVA Property Bean 접근법)
public class HelloData {

    private String username;
    private int age;

}
