package frontcontroller.v4;

import frontcontroller.MyView;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV4", urlPatterns = "/v4/*")
public class FrontControllerV4 extends HttpServlet {

    HashMap<String, ControllerV4> handlerMap = new HashMap<>();

    public FrontControllerV4() {
        handlerMap.put("/v4/list", new ListControllerV4());
        handlerMap.put("/v4/add", new AddControllerV4());
        handlerMap.put("/v4/save", new SaveControllerV4());
    }

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontControllerV4.service");

        ControllerV4 controller = handlerMapping(request);

        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        HashMap<String, Object> model = new HashMap<>();
        Map<String, String> paramMap = createParamMap(request);

        String viewName = controller.process(paramMap, model);
        String viewPath = viewResolver(viewName);

        MyView myView = new MyView(viewPath);
        myView.render(request,response,model);
    }

    private static String viewResolver(String viewName) {
        String prefix = "/controller/";
        String suffix = ".jsp";
        return prefix + viewName + suffix;
    }

    private Map<String,String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));
        return paramMap;
    }

    private ControllerV4 handlerMapping(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return handlerMap.get(uri);
    }
}
