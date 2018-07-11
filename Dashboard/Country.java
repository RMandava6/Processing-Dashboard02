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
    private String expectancy;
    private String dish;
    private String symbol;
    private Float density;
    private Integer population;
    private String location;
    private Float area;
    private Float temperature;
    private String measurement;


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

    public String getExpectancy() {
        return expectancy;
    }

    public void setExpectancy(String expectancy) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country1 = (Country) o;

        if (name != null ? !name.equals(country1.name) : country1.name != null) return false;
        if (abbreviation != null ? !abbreviation.equals(country1.abbreviation) : country1.abbreviation != null)
            return false;
        if (height != null ? !height.equals(country1.height) : country1.height != null) return false;
        if (barCode != null ? !barCode.equals(country1.barCode) : country1.barCode != null) return false;
        if (calling_code != null ? !calling_code.equals(country1.calling_code) : country1.calling_code != null)
            return false;
        if (city != null ? !city.equals(country1.city) : country1.city != null) return false;
        if (continent != null ? !continent.equals(country1.continent) : country1.continent != null) return false;
        if (costline != null ? !costline.equals(country1.costline) : country1.costline != null) return false;
        if (currency_code != null ? !currency_code.equals(country1.currency_code) : country1.currency_code != null)
            return false;
        if (currency_name != null ? !currency_name.equals(country1.currency_name) : country1.currency_name != null)
            return false;
        if (tld != null ? !tld.equals(country1.tld) : country1.tld != null) return false;
        if (elevation != null ? !elevation.equals(country1.elevation) : country1.elevation != null) return false;
        if (flag_base64 != null ? !flag_base64.equals(country1.flag_base64) : country1.flag_base64 != null)
            return false;
        if (north != null ? !north.equals(country1.north) : country1.north != null) return false;
        if (south != null ? !south.equals(country1.south) : country1.south != null) return false;
        if (east != null ? !east.equals(country1.east) : country1.east != null) return false;
        if (west != null ? !west.equals(country1.west) : country1.west != null) return false;
        if (government != null ? !government.equals(country1.government) : country1.government != null) return false;
        if (independence != null ? !independence.equals(country1.independence) : country1.independence != null)
            return false;
        if (iso != null ? !iso.equals(country1.iso) : country1.iso != null) return false;
        if (landlocked != null ? !landlocked.equals(country1.landlocked) : country1.landlocked != null) return false;
        if (language != null ? !language.equals(country1.language) : country1.language != null) return false;
        if (expectancy != null ? !expectancy.equals(country1.expectancy) : country1.expectancy != null) return false;
        if (dish != null ? !dish.equals(country1.dish) : country1.dish != null) return false;
        if (symbol != null ? !symbol.equals(country1.symbol) : country1.symbol != null) return false;
        if (density != null ? !density.equals(country1.density) : country1.density != null) return false;
        if (population != null ? !population.equals(country1.population) : country1.population != null) return false;
        if (location != null ? !location.equals(country1.location) : country1.location != null) return false;
        if (area != null ? !area.equals(country1.area) : country1.area != null) return false;
        if (temperature != null ? !temperature.equals(country1.temperature) : country1.temperature != null)
            return false;
        return measurement != null ? measurement.equals(country1.measurement) : country1.measurement == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        result = 31 * result + (calling_code != null ? calling_code.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (costline != null ? costline.hashCode() : 0);
        result = 31 * result + (currency_code != null ? currency_code.hashCode() : 0);
        result = 31 * result + (currency_name != null ? currency_name.hashCode() : 0);
        result = 31 * result + (tld != null ? tld.hashCode() : 0);
        result = 31 * result + (elevation != null ? elevation.hashCode() : 0);
        result = 31 * result + (flag_base64 != null ? flag_base64.hashCode() : 0);
        result = 31 * result + (north != null ? north.hashCode() : 0);
        result = 31 * result + (south != null ? south.hashCode() : 0);
        result = 31 * result + (east != null ? east.hashCode() : 0);
        result = 31 * result + (west != null ? west.hashCode() : 0);
        result = 31 * result + (government != null ? government.hashCode() : 0);
        result = 31 * result + (independence != null ? independence.hashCode() : 0);
        result = 31 * result + (iso != null ? iso.hashCode() : 0);
        result = 31 * result + (landlocked != null ? landlocked.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (expectancy != null ? expectancy.hashCode() : 0);
        result = 31 * result + (dish != null ? dish.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (density != null ? density.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (measurement != null ? measurement.hashCode() : 0);
        return result;
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
                ", expectancy='" + expectancy + '\'' +
                ", dish='" + dish + '\'' +
                ", symbol='" + symbol + '\'' +
                ", density=" + density +
                ", population=" + population +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", temperature=" + temperature +
                ", measurement='" + measurement + '\'' +
                '}';
    }
}
