package task;

public class RequestDataObject {

    private String key;
    private String echo;

    public RequestDataObject(String key, String echo) {
        this.key = key;
        this.echo = echo;
    }

    public RequestDataObject() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    @Override
    public String toString() {
        return "RequestDataObject{" +
                "key='" + key + '\'' +
                ", echo='" + echo + '\'' +
                '}';
    }
}
