package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    private List<Car> carList;
    public CarServiceImpl() {
        carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Black", 2010));
        carList.add(new Car("Peugeot", "Blue", 2008));
        carList.add(new Car("BMW", "Green", 2012));
        carList.add(new Car("Honda", "Red", 2016));
        carList.add(new Car("Mercedes", "White", 2006));
    }
    @Override
    public List<Car> getCars(int count) {
        if (count >= carList.size() || count <= 0) {
            return carList;
        } else {
            return carList.subList(0, count);
        }
    }
}