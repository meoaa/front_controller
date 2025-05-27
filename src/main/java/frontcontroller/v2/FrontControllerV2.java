package frontcontroller.v2;

import frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "frontControllerV2", urlPatterns = "/v2/*")
public class FrontControllerV2 extends HttpServlet {

    HashMap<String, ControllerV2> handlerMap = new HashMap<>();

    public FrontControllerV2() {
        handlerMap.put("/v2/list", new ListControllerV2());
        handlerMap.put("/v2/add", new AddControllerV2());
        handlerMap.put("/v2/save", new SaveControllerV2());
    }

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("FrontControllerV2.service");

        ControllerV2 controller = handlerMapping(request);
        String viewName = viewResolver(request, response, controller);

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
        dispatcher.forward(request, response);

    }

    private static String viewResolver(HttpServletRequest request, HttpServletResponse response, ControllerV2 controller) throws ServletException, IOException {
        String viewName = controller.process(request, response);
        String prefix = "/controller/";
        String suffix = ".jsp";
        return prefix + viewName + suffix;
    }

    private ControllerV2 handlerMapping(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return handlerMap.get(uri);
    }
}
