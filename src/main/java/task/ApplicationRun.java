package task;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.request.RequestDataObject;
import task.request.RequestExecutor;
import task.response.ResponseDataObject;
import task.response.ResponseProcessor;

import java.io.IOException;

@Component
public class ApplicationRun {

    @Autowired
    private ResponseProcessor responseProcessor;

    public ApplicationRun() {
    }

    public void doTestTask(String url, String keyAPI) throws IOException {

        RequestDataObject data = new RequestDataObject(keyAPI, "test");

        RequestExecutor executorClass = new RequestExecutor(url, data);

        String string = executorClass.sendRequestPost();

        Gson gson = new Gson();
        ResponseDataObject response = gson.fromJson(string, ResponseDataObject.class);
        responseProcessor.saveToDataBase(response);
    }

    public void setResponseProcessor(ResponseProcessor responseProcessor) {
        this.responseProcessor = responseProcessor;
    }
}
