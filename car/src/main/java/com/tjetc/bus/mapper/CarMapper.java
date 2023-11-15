package com.tjetc.bus.mapper;

import com.tjetc.bus.doman.Car;
import com.tjetc.bus.vo.CarVo;

import java.util.List;

public interface CarMapper {
    List<Car> queryAllCar(CarVo carVo);
    void insertSelective(CarVo carVo);

    Car selectByPrimaryKey(String carNumber);
    void deleteByPrimaryKey(String carNumber);

    void updateByPrimaryKeySelective(CarVo carVo);
}
