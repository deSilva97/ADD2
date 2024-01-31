package dao;

import model.Car;

public interface CarDAO {

	public Car create(Car car);
	public Car update(int id, Car car);
	public Car read(int id);
	public Car delete(int id);
	
}
