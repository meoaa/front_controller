package frontcontroller;

import java.util.HashMap;

public class ModelView {
    private String viewName;
    private HashMap<String, Object> model;

    public ModelView(HashMap<String, Object> model, String viewName) {
        this.model = model;
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public HashMap<String, Object> getModel() {
        return model;
    }
}
