package ru.kata.springbooot.springboot.Service;

import org.springframework.stereotype.Service;
import ru.kata.springbooot.springboot.model.Car;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {
    private List<Car> carsList;

    public CarServiceImpl() {
        carsList = new ArrayList<>();
        carsList.add(new Car("BMW", "green", 2019));
        carsList.add(new Car("Audi", "black", 2020));
        carsList.add(new Car("Opel", "whiter", 2018));
        carsList.add(new Car("Volkswagen", "yellow", 2017));
        carsList.add(new Car("Skoda", "grey", 2016));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count >= carsList.size()) {
            return carsList;
        }
        return carsList.subList(0, count);
    }

}
