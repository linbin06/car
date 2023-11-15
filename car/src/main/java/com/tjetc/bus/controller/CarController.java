package com.tjetc.bus.controller;

import com.tjetc.bus.doman.Car;
import com.tjetc.bus.service.ICarService;
import com.tjetc.bus.vo.CarVo;
import com.tjetc.sys.constants.SysConstant;
import com.tjetc.sys.utils.AppFileUtils;
import com.tjetc.sys.utils.DataGridView;
import com.tjetc.sys.utils.ResultObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("car")
public class CarController {
    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    /**
     * 加载⻋辆列表 返回的是DataGridView
     */
    @RequestMapping("loadAllCar")
    public DataGridView loadAllCar(CarVo carVo) {
        return carService.queryAllCar(carVo);
    }

    /**
     * 添加⻋辆的⽅法
     */
    @RequestMapping("addCar")
    public ResultObj addCar(CarVo carVo) {
        try {
            carVo.setCreateTime(new Date());
            //如果不是默认图⽚就去掉图⽚的_temp的后缀
            if (!carVo.getCarImg().equals(SysConstant.DEFAULT_CAR_IMG)) {
                String filePath = AppFileUtils.updateFileName(carVo.getCarImg(), SysConstant.FILE_UPLOAD_TEMP);
                carVo.setCarImg(filePath);
            }
            carService.addCar(carVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 删除⻋辆
     */
    @RequestMapping("deleteCar")
    public ResultObj deleteCar(String carNumber) {
        try {
            carService.deleteCar(carNumber);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 更新⻋辆信息
     */
    @RequestMapping("updateCar")
    public ResultObj updateCar(CarVo carVo) {
        try {
            String carimg = carVo.getCarImg();
            if (carimg.endsWith(SysConstant.FILE_UPLOAD_TEMP)) {
                String filePath = AppFileUtils.updateFileName(carVo.getCarImg
                        (), SysConstant.FILE_UPLOAD_TEMP);
                carVo.setCarImg(filePath);
                //删除原来的图⽚
                Car car = carService.queryCarByCarNumber(carVo.getCarNumber());
                AppFileUtils.removeFileByPath(car.getCarImg());
            }
            //更新操作
            carService.updateCar(carVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    /**
     * 批量删除⻋辆
     */
    @PostMapping("deleteBatchCar")
    public ResultObj deleteBatchCar(CarVo carVo){
        try {
            carService.deleteBatchCar(carVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}