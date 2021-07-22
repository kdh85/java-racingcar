package study.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(int count) {
        for(int i = 0; i < count; i++){
            cars.add(readyToCar());
        }
    }

    private Car readyToCar() {
        return Car.createCar();
    }

    public List<Car> getCars() {
        return cars;
    }
}
