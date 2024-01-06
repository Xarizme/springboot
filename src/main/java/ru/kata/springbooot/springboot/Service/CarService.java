package ru.kata.springbooot.springboot.Service;


import ru.kata.springbooot.springboot.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getCars(int count);
}
