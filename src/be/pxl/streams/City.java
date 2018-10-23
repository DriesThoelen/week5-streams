package be.pxl.streams;

public class City {
    private String name;
    private int numberOfCitizens;
    private double area;

    public City(String name, int numberOfCitizens, double area) {
        this.name = name;
        this.numberOfCitizens = numberOfCitizens;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfCitizens() {
        return numberOfCitizens;
    }

    public double getArea() {
        return area;
    }
}
