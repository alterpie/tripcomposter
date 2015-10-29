package task;

import task.model.Country;

import java.util.List;

public class ResponseDataObject {
    private long time;
    private List<Country> countries;
    private String echo;

    public ResponseDataObject(long time, List<Country> countries, String echo) {
        this.time = time;
        this.countries = countries;
        this.echo = echo;
    }

    public ResponseDataObject() {
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    @Override
    public String toString() {
        return "ResponseDataObject{" +
                "time=" + time +
                ", countries=" + countries +
                ", echo='" + echo + '\'' +
                '}';
    }
}
