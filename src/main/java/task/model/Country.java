package task.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Country")
public class Country extends Model {

    @Column(name = "country_name", unique = true)
    private String countryName;

    @Column(name = "country_iso_code", unique = true)
    private String countryISOCode;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;

    public Country() {
        cities = new ArrayList<>();
    }

    public Country(long id) {
        super(id);
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryISOCode() {
        return countryISOCode;
    }

    public void setCountryISOCode(String countryISOCode) {
        this.countryISOCode = countryISOCode;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!countryName.equals(country.countryName)) return false;
        return countryISOCode.equals(country.countryISOCode);

    }

    @Override
    public int hashCode() {
        int result = countryName.hashCode();
        result = 31 * result + countryISOCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryISOCode='" + countryISOCode + '\'' +
                ", cities=" + cities +
                '}';
    }
}
