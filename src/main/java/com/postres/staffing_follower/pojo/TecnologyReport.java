package com.postres.staffing_follower.pojo;

public class TecnologyReport {
    private String tecnologyName;
    private double avarage;
    private double max;
    private double min;

    public TecnologyReport() {
    }

    public TecnologyReport(String tecnologyName, double avarage, double max, double min) {
        this.tecnologyName = tecnologyName;
        this.avarage = avarage;
        this.max = max;
        this.min = min;
    }

    public String getTecnologyName() {
        return tecnologyName;
    }

    public void setTecnologyName(String tecnologyName) {
        this.tecnologyName = tecnologyName;
    }

    public double getAvarage() {
        return avarage;
    }

    public void setAvarage(double avarage) {
        this.avarage = avarage;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "TecnologyReport{" +
                "tecnologyName='" + tecnologyName + '\'' +
                ", avarage=" + avarage +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
