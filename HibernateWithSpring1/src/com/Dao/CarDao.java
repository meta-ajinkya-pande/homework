package com.Dao;

import java.util.List;


@Repository
@Transactional
public class CarDao {
	
	
	@Autowired
	SessionFactory session;
	
	
	public boolean insertCar(CarVO car){
		
		Session newSession=session.openSession();
		newSession.persist(car);
		newSession.close();
		
	}
	
	public List<CarVO>listOfCars(){
		Session newSession=session.openSession();
		List<CarVO>carList=newSession.createQuery("from car").list();
		
		return carList;	
		newSession.close();
		
	}
	
	public boolean updateCar(CarVO car){
		Session newSession=session.openSession();
		newSession.update(car);
		return true;
		newSession.close();
		
	}
	
	
	public boolean deleteCar(CarVO car){
		Session newSession=session.openSession();
		newSession.delete(car);
		try{
			session.getCurrentSession().delete(car);
			
		}catch(Exception ex){
			return false;
		}
		newSession.close();
		return true;

		
	}
	
	
	
	

}
