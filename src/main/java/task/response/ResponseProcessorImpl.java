package task.response;

import org.springframework.stereotype.Component;
import task.exception.ApplicationException;
import task.model.City;
import task.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import task.service.CityService;
import task.service.CountryService;

import java.util.List;

@Component
public class ResponseProcessorImpl implements ResponseProcessor {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    public ResponseProcessorImpl() {
    }


    @Override
    public void saveToDataBase(ResponseDataObject dataObject) {
        ResponseDataObject updatedData = updateData(dataObject);

        List<Country> countries = updatedData.getCountries();

        for (Country country : countries) {
            List<City> cities = country.getCities();
            for (City city : cities) {
                cityService.add(city);
            }
        }
    }

    //support method that saves country in database, creates new instance of Country
    // with value that was taken from database and sets it in each instance of City class in array
    public ResponseDataObject updateData(ResponseDataObject dataObject) {
        ResponseDataObject updatedData = null;

        List<Country> countries = dataObject.getCountries();
        if (countries != null) {
            for (Country country : countries) {
                Country countryToSave = new Country();
                countryToSave.setCountryName(country.getCountryName());
                countryToSave.setCountryISOCode(country.getCountryISOCode());
                countryService.add(countryToSave);

                List<City> cities = country.getCities();

                Country savedCountry = null;
                try {
                    savedCountry = countryService.find(country.getCountryName());

                    for (City city : cities) {
                        city.setCountry(savedCountry);
                    }
                } catch (ApplicationException e) {
                    e.printStackTrace();
                }

                updatedData = new ResponseDataObject();
                updatedData.setCountries(countries);
                updatedData.setTime(dataObject.getTime());
                updatedData.setEcho(dataObject.getEcho());

            }
        }
        return updatedData;
    }

    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }
}
