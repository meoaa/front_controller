package frontcontroller.v1;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name ="frontControllerV1", urlPatterns = "/v1/*")
public class FrontControllerV1 extends HttpServlet {

    HashMap<String, ControllerV1> handlerMap = new HashMap<>();

    public FrontControllerV1() {
        handlerMap.put("/v1/list", new ListControllerV1());
        handlerMap.put("/v1/add", new AddControllerV1());
        handlerMap.put("/v1/save", new SaveControllerV1());
    }

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ControllerV1 controller = handlerMapping(request);

        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);
    }

    private ControllerV1 handlerMapping(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return handlerMap.get(uri);
    }
}
