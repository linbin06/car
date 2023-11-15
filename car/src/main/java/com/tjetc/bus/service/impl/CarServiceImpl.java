package com.tjetc.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjetc.bus.doman.Car;
import com.tjetc.bus.mapper.CarMapper;
import com.tjetc.bus.service.ICarService;
import com.tjetc.bus.vo.CarVo;
import com.tjetc.sys.constants.SysConstant;
import com.tjetc.sys.utils.AppFileUtils;
import com.tjetc.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {
    private final CarMapper carMapper;

    public CarServiceImpl(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @Override
    public DataGridView queryAllCar(CarVo carVo) {
        //使⽤PageHelper的分⻚查询
        Page<Car> page = PageHelper.startPage(carVo.getPage(), carVo.getLimit());
        List<Car> data = carMapper.queryAllCar(carVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addCar(CarVo carVo) {
        carMapper.insertSelective(carVo);
    }

    /**
     * 删除⻋辆的⽅法
     *
     * @param carNumber
     */
    @Override
    public void deleteCar(String carNumber) {
        //先删除图⽚
        Car car = carMapper.selectByPrimaryKey(carNumber);
        //如果不是默认图⽚,就进⾏删除
        if (!car.getCarImg().equals(SysConstant.DEFAULT_CAR_IMG)) {
            AppFileUtils.deleteFileUsePath(car.getCarImg());
        }
        //删除数据库数据
        carMapper.deleteByPrimaryKey(carNumber);
    }

    @Override
    public Car queryCarByCarNumber(String carNumber) {
        return carMapper.selectByPrimaryKey(carNumber);
    }
    @Override
    public void updateCar(CarVo carVo) {
        carMapper.updateByPrimaryKeySelective(carVo);
    }

    @Override
    public void deleteBatchCar(String[] carNumbers) {
        for (String carNumber : carNumbers) {
            this.deleteCar(carNumber);
        }
    }

}