package frontcontroller.v5;

import frontcontroller.ModelView;
import frontcontroller.MyView;
import frontcontroller.v3.AddControllerV3;
import frontcontroller.v3.ListControllerV3;
import frontcontroller.v3.SaveControllerV3;
import frontcontroller.v4.AddControllerV4;
import frontcontroller.v4.ListControllerV4;
import frontcontroller.v4.SaveControllerV4;
import frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import frontcontroller.v5.adapter.HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerV5", urlPatterns = "/v5/*")
public class FrontControllerV5 extends HttpServlet {
    private final Map<String, Object> handlerMap = new HashMap<>();
    private final List<HandlerAdapter> handlerAdapters = new ArrayList<>();


    public FrontControllerV5() {
        initHandlerMap();
        initHandlerAdapterList();
    }

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("FrontControllerV5.service");

        Object handler = handlerMapping(request);
        if(handler == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        HandlerAdapter adapter = getHandlerAdapter(handler);
        ModelView modelView = adapter.handle(request, response, handler);

        String viewPath = viewResolver(modelView.getViewName());
        MyView myView = new MyView(viewPath);

        myView.render(request,response,modelView.getModel());
    }

    private Object handlerMapping(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return handlerMap.get(uri);
    }

    private HandlerAdapter getHandlerAdapter(Object handler) {
        for(HandlerAdapter adapter : handlerAdapters){
            if(adapter.supports(handler)){
                return adapter;
            };
        }
        throw new IllegalArgumentException("지원하지 않는 핸들러: " + handler);
    }
    private static String viewResolver(String viewName) {
        return "/controller/"+ viewName + ".jsp";
    }

    private void initHandlerAdapterList() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    private void initHandlerMap() {
        handlerMap.put("/v5/v3/list", new ListControllerV3());
        handlerMap.put("/v5/v3/save", new SaveControllerV3());
        handlerMap.put("/v5/v3/add", new AddControllerV3());

        handlerMap.put("/v5/v4/list", new ListControllerV4());
        handlerMap.put("/v5/v4/save", new SaveControllerV4());
        handlerMap.put("/v5/v4/add", new AddControllerV4());
    }
}
