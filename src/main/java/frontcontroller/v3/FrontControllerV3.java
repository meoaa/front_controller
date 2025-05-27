package frontcontroller.v3;

import frontcontroller.ModelView;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "frontControllerV3", urlPatterns = "/v3/*")
public class FrontControllerV3 extends HttpServlet {

    private final HashMap<String, ControllerV3> handleMap = new HashMap<>();

    public FrontControllerV3() {
        handleMap.put("/v3/list", new ListControllerV3());
        handleMap.put("/v3/add", new AddControllerV3());
        handleMap.put("/v3/save", new SaveControllerV3());
    }

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("FrontControllerV3.service");

        ControllerV3 controller = handlerMapping(request);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        HashMap<String, String> paramMap = new HashMap<>();
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));

        ModelView modelView = controller.process(paramMap);
        modelView.getModel().forEach(request::setAttribute);

        String viewName = viewResolver(modelView);

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
        dispatcher.forward(request,response);

    }

    private static String viewResolver(ModelView modelView) {
        String viewName = modelView.getViewName();
        String prefix = "/controller/";
        String suffix = ".jsp";
        return prefix + viewName + suffix;
    }

    private ControllerV3 handlerMapping(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return handleMap.get(uri);
    }

}
