package main.org.example.server.server.Factores;

import main.org.example.models.Coordinates;

public class CoordinatesFactory {
    public Coordinates createCoordinates(String[] args) {
        double x = Double.parseDouble(args[0]);
        Integer y = Integer.parseInt(args[1]);
        Coordinates newCoordinates = new Coordinates(x , y);
        return newCoordinates;
    }
}
