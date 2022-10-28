package valtechspring.spring.orm;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import valtechspring.jdbc.CarDAO;
import valtechspring.orm.Car;

public class CarHibDAOImpl extends HibernateDaoSupport implements CarDAO {

	@Override
	public void save(Car car) {
		getHibernateTemplate().save(car);
	}

	@Override
	public void update(Car car) {
		getHibernateTemplate().update(car);
	}

	@Override
	public void delete(Car car) {
		getHibernateTemplate().delete(car);
	}

	@Override
	public Car get(int id) {
		return getHibernateTemplate().load(Car.class, id);
	}

	@Override
	public List<Car> getAll() {
		return getHibernateTemplate().find("SELECT c FROM Car c");
	}

}
