package com.tjetc.bus.service;

import com.tjetc.bus.doman.Car;
import com.tjetc.bus.vo.CarVo;
import com.tjetc.sys.utils.DataGridView;

public interface ICarService {
    DataGridView queryAllCar(CarVo carVo);
    void addCar(CarVo carVo);
    void deleteCar(String carNumber);
    Car queryCarByCarNumber(String carNumber);
    void updateCar(CarVo carVo);

    void deleteBatchCar(String[] carNumbers);
}