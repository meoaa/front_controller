package frontcontroller.v4;

import java.util.Map;

public class AddControllerV4 implements ControllerV4{
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        System.out.println("AddControllerV4.process");

        return "add";
    }
}
