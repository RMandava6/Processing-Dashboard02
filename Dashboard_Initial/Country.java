import java.util.Objects;

public class Country {

    private String name;
    private String abbreviation;
    private Double height;
    private String barCode;
    private String calling_code;
    private String city;
    private String continent;
    private String costline;
    private String currency_code;
    private String currency_name;
    private String tld;
    private String elevation;
    private String flag_base64;
    private Float north;
    private Float south;
    private Float east;
    private Float west;
    private String government;
    private String independence;
    private String iso;
    private String landlocked;
    private String language;
    private Double expectancy;
    private String dish;
    private String symbol;
    private Float density;
    private Integer population;
    private String location;
    private Float area;
    private Float temperature;
    private String measurement;
    private Double longitude;
    private Double latitude;
    private Float x;
    private Float y;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCalling_code() {
        return calling_code;
    }

    public void setCalling_code(String calling_code) {
        this.calling_code = calling_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCostline() {
        return costline;
    }

    public void setCostline(String costline) {
        this.costline = costline;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getFlag_base64() {
        return flag_base64;
    }

    public void setFlag_base64(String flag_base64) {
        this.flag_base64 = flag_base64;
    }

    public Float getNorth() {
        return north;
    }

    public void setNorth(Float north) {
        this.north = north;
    }

    public Float getSouth() {
        return south;
    }

    public void setSouth(Float south) {
        this.south = south;
    }

    public Float getEast() {
        return east;
    }

    public void setEast(Float east) {
        this.east = east;
    }

    public Float getWest() {
        return west;
    }

    public void setWest(Float west) {
        this.west = west;
    }

    public String getGovernment() {
        return government;
    }

    public void setGovernment(String government) {
        this.government = government;
    }

    public String getIndependence() {
        return independence;
    }

    public void setIndependence(String independence) {
        this.independence = independence;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getLandlocked() {
        return landlocked;
    }

    public void setLandlocked(String landlocked) {
        this.landlocked = landlocked;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getExpectancy() {
        return expectancy;
    }

    public void setExpectancy(Double expectancy) {
        this.expectancy = expectancy;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Float getDensity() {
        return density;
    }

    public void setDensity(Float density) {
        this.density = density;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(abbreviation, country.abbreviation) &&
                Objects.equals(height, country.height) &&
                Objects.equals(barCode, country.barCode) &&
                Objects.equals(calling_code, country.calling_code) &&
                Objects.equals(city, country.city) &&
                Objects.equals(continent, country.continent) &&
                Objects.equals(costline, country.costline) &&
                Objects.equals(currency_code, country.currency_code) &&
                Objects.equals(currency_name, country.currency_name) &&
                Objects.equals(tld, country.tld) &&
                Objects.equals(elevation, country.elevation) &&
                Objects.equals(flag_base64, country.flag_base64) &&
                Objects.equals(north, country.north) &&
                Objects.equals(south, country.south) &&
                Objects.equals(east, country.east) &&
                Objects.equals(west, country.west) &&
                Objects.equals(government, country.government) &&
                Objects.equals(independence, country.independence) &&
                Objects.equals(iso, country.iso) &&
                Objects.equals(landlocked, country.landlocked) &&
                Objects.equals(language, country.language) &&
                Objects.equals(expectancy, country.expectancy) &&
                Objects.equals(dish, country.dish) &&
                Objects.equals(symbol, country.symbol) &&
                Objects.equals(density, country.density) &&
                Objects.equals(population, country.population) &&
                Objects.equals(location, country.location) &&
                Objects.equals(area, country.area) &&
                Objects.equals(temperature, country.temperature) &&
                Objects.equals(measurement, country.measurement) &&
                Objects.equals(longitude, country.longitude) &&
                Objects.equals(latitude, country.latitude) &&
                Objects.equals(x, country.x) &&
                Objects.equals(y, country.y);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, abbreviation, height, barCode, calling_code, city, continent, 
                costline, currency_code, currency_name, tld, elevation, flag_base64, north, 
                south, east, west, government, independence, iso, landlocked, language, 
                expectancy, dish, symbol, density, population, location, area, temperature,
                measurement, longitude, latitude, x, y);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", height=" + height +
                ", barCode='" + barCode + '\'' +
                ", calling_code='" + calling_code + '\'' +
                ", city='" + city + '\'' +
                ", continent='" + continent + '\'' +
                ", costline='" + costline + '\'' +
                ", currency_code='" + currency_code + '\'' +
                ", currency_name='" + currency_name + '\'' +
                ", tld='" + tld + '\'' +
                ", elevation='" + elevation + '\'' +
                ", flag_base64='" + flag_base64 + '\'' +
                ", north=" + north +
                ", south=" + south +
                ", east=" + east +
                ", west=" + west +
                ", government='" + government + '\'' +
                ", independence='" + independence + '\'' +
                ", iso='" + iso + '\'' +
                ", landlocked='" + landlocked + '\'' +
                ", language='" + language + '\'' +
                ", expectancy=" + expectancy +
                ", dish='" + dish + '\'' +
                ", symbol='" + symbol + '\'' +
                ", density=" + density +
                ", population=" + population +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", temperature=" + temperature +
                ", measurement='" + measurement + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
