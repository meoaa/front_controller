package frontcontroller.v3;

import frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
