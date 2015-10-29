package task;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApplicationRun {

    @Autowired
    private ResponseProcessor responseProcessor;

    public ApplicationRun() {
    }

    public void doTestTask(String url) throws IOException {

        Gson gson = new Gson();
        RequestDataObject data = new RequestDataObject("$1$12309856$euBrWcjT767K2sP9MHcVS/", "test");

        RequestExecutor executorClass = new RequestExecutor(url, data);

        String string = executorClass.sendRequestPost();
        ResponseDataObject response = gson.fromJson(string, ResponseDataObject.class);

        responseProcessor.saveInfo(response);
    }

    public void setResponseProcessor(ResponseProcessor responseProcessor) {
        this.responseProcessor = responseProcessor;
    }
}
