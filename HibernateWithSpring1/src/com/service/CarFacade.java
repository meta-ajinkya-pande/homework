package com.service;

import java.util.List;

import com.Dao.CarDao;
import com.Dao.CarVO;


@Service
public class CarFacade {

	@Autowired
	CarDao carDaoObj;
	
	
	public boolean save(CarVO car) {
		return carDaoObj.insertCar(car);
	}
	
	public boolean update(CarVO car) {
		
		return carDaoObj.updateCar(car);
	}


	public List<CarVO> list() {
		// TODO Auto-generated method stub
		return carDaoObj.listOfCars();
	}

	public boolean delete(CarVO car) {
		// TODO Auto-generated method stub
		return carDaoObj.deleteCar(car);
	}	
	
	
	
	
	
	
}
