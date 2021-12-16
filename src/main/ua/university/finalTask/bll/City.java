package main.ua.university.finalTask.bll;

import main.ua.university.finalTask.pl.GettingValuesFromInput;

import java.io.Serializable;

public class City implements Serializable {
    private int id;
    private Country country;
    private String cityName;
    private int population;
    private boolean isCapital;

    public City(Country country, String cityName, int population, boolean isCapital, int id) {
        this.country = country;
        this.cityName = cityName;
        this.population = population;
        this.isCapital = isCapital;
        this.id = id;
    }

    public City() {}

    public City(Country country, String cityName, int population, int id) {
        this(country, cityName, population, false, id);
    }

    public Country getCountry() {
        return country;
    }

    public City (City oldCity, int id) {
        this(oldCity.getCountry(), oldCity.getCityName(), oldCity.getPopulation(), id);
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setId(int id) {
        if(GettingValuesFromInput.isThisId(id))
            this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }


    public String getCityInfoInFormat() {
        final StringBuilder sb = new StringBuilder("\t\t").append("cityName = '").append(cityName).append("'");
        sb.append('\t').append("ID = '").append(id).append('\'');
        if (isCapital)
            sb.append('\t').append("capital of ").append(country.getCountryName());
        else
            sb.append('\t').append("country = '").append(country.getCountryName()).append('\'');
        sb.append('\t').append("peopleAmount = '").append(population).append("'");
        return sb.toString();
    }
}
