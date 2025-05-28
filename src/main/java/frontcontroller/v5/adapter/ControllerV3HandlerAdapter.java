package frontcontroller.v5.adapter;

import frontcontroller.ModelView;
import frontcontroller.v3.ControllerV3;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;

public class ControllerV3HandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return handler instanceof ControllerV3;
    }

    @Override
    public ModelView handle(HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler) {
        ControllerV3 controller = (ControllerV3) handler;

        HashMap<String, String> paramMap = createParamMap(request);
        return controller.process(paramMap);
    }

    private static HashMap<String,String> createParamMap(HttpServletRequest request) {
        HashMap<String, String> paramMap = new HashMap<>();
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));

        return paramMap;
    }
}
