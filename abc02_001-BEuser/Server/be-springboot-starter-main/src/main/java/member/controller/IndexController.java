package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //view를 리턴
public class IndexController {

    //localhost:8080/
    //localhost:8080
    @GetMapping({"","/"})
    public String index() {
        //mustache spring이 권장함. 기본폴더 src/main/resources/
        //view resolver설정시 templates(prefix), .mustache(sufix)
        return "index"; //view
    }

}
