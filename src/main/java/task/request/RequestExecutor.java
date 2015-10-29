package task.request;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestExecutor {

    private String url;
    private RequestDataObject dataObject;
    private Gson gson;

    public RequestExecutor(String url, RequestDataObject dataObject) {
        this.url = url;
        this.dataObject = dataObject;
        gson = new Gson();
    }

    public String sendRequestPost() throws IOException {
        URL req = new URL(url);
        HttpURLConnection request = (HttpURLConnection) req.openConnection();
        request.setRequestMethod("POST");
        request.setDoOutput(true);
        request.setRequestProperty("Content-type", "application/json");
        request.setRequestProperty("Accept", "application/json");

        OutputStream outputStream = request.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        writer.write(gson.toJson(dataObject));
        writer.flush();

        StringBuilder builder = new StringBuilder();
        String income;
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        while ((income = reader.readLine()) != null) {
            builder.append(income);
        }
        request.disconnect();
        return builder.toString();

    }

}
