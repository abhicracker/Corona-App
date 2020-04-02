package com.example.jsonobjecttrying.POJO;

public class CountriesData {


    private String name;

    private String flag;

    private Integer reports;

    private Integer cases;

    private Integer deaths;

    private Integer recovered;

    private Integer lat;

    private Integer lng;

    private Integer deltaCases;

    private Integer deltaDeaths;


    public CountriesData(String name, String flag, Integer reports, Integer cases, Integer deaths, Integer recovered, Integer lat, Integer lng, Integer deltaCases, Integer deltaDeaths) {
        this.name = name;
        this.flag = flag;
        this.reports = reports;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.lat = lat;
        this.lng = lng;
        this.deltaCases = deltaCases;
        this.deltaDeaths = deltaDeaths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getReports() {
        return reports;
    }

    public void setReports(Integer reports) {
        this.reports = reports;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    public Integer getDeltaCases() {
        return deltaCases;
    }

    public void setDeltaCases(Integer deltaCases) {
        this.deltaCases = deltaCases;
    }

    public Integer getDeltaDeaths() {
        return deltaDeaths;
    }

    public void setDeltaDeaths(Integer deltaDeaths) {
        this.deltaDeaths = deltaDeaths;
    }

}