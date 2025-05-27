package frontcontroller.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddControllerV2 implements ControllerV2{
    @Override
    public String process(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        return "add";
    }
}
