package task.model;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City extends Model {

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public City(long id) {
        super(id);
    }

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (!cityName.equals(city.cityName)) return false;
        return country.equals(city.country);

    }

    @Override
    public int hashCode() {
        int result = cityName.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", country=" + country.getCountryName() +
                '}';
    }
}
