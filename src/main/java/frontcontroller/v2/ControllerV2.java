package frontcontroller.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {

    String process(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException;
}
