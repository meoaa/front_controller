package frontcontroller.v3;

import frontcontroller.ModelView;

import java.util.HashMap;
import java.util.Map;

public class AddControllerV3 implements ControllerV3{
    @Override
    public ModelView process(Map<String, String> paramMap) {
        HashMap<String, Object> model = new HashMap<>();
        return new ModelView(model , "add");
    }
}
