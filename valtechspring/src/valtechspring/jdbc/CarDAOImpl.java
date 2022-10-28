package valtechspring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import valtechspring.orm.Car;
import valtechspring.orm.CarDetails;

public class CarDAOImpl implements CarDAO {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Car car)	{
		JdbcTemplate temp= new JdbcTemplate(dataSource);
//		temp.queryForInt("Select max(id) from car"); 
//		Please add Id and additional Question mark
		temp.update("insert into car (kms,numOfOwners,validInsurance,color,make,model,price,yearManufactured,version) "
				+ "values(?,?,?,?,?,?,?,?,?)"
				, car.getCarDetails().getKms(),car.getCarDetails().getNumOfOwners(),car.getCarDetails().isValidInsurance()
				,car.getColor(),car.getMake(),car.getModel()
				,car.getPrice(),car.getYearManufactured(),car.getVersion());
	}
	
	@Override
	public void  update(Car car)	{
		JdbcTemplate temp= new JdbcTemplate(dataSource);
		temp.update("update car set kms = ?,numOfOwners = ?, validInsurance =? , color = ?"
				+ ", make = ? , model = ?, price = ? , yearManufactured = ? , version = ? where id = ?"
				, car.getCarDetails().getKms(),car.getCarDetails().getNumOfOwners(),car.getCarDetails().isValidInsurance()
				,car.getColor(),car.getMake(),car.getModel()
				,car.getPrice(),car.getYearManufactured(),car.getVersion()+1,car.getId());
	}
	
	@Override
	public void delete(Car car)		{
		JdbcTemplate temp= new JdbcTemplate(dataSource);
		temp.update("delete from car where id = ?",car.getId());
	}
	
	private static class CarRowMapper implements RowMapper<Car>	{
		@Override
		public Car mapRow(ResultSet rs, int row) throws SQLException {
//			kms,numOfOwners,validInsurance,color,make,model,price,yearManufactured,version,id
			int kms = rs.getInt(1);
			int numOfOwners = rs.getInt(2);
			boolean validInsurance = rs.getBoolean(3);
			CarDetails cd = new CarDetails(kms,validInsurance,numOfOwners);
			String color = rs.getString(4);
			String make = rs.getString(5);
			String model = rs.getString(6);
			float price = rs.getFloat(7);
			int yearMfg = rs.getInt(8);
			int version =rs.getInt(9);
			int id = rs.getInt(10);
			Car car = new Car(id,make,model,yearMfg,price,color,cd);
			car.setVersion(version);
			return car;
		}
	}
	
	@Override
	public Car get(int id)	{
		JdbcTemplate temp = new JdbcTemplate(dataSource);
		return temp.queryForObject
	("Select kms,numOfOwners,validInsurance,color,make,model,price,yearManufactured,version,id from car where id = ?"
			, new CarRowMapper(), id);
	}
	
	@Override
	public List<Car> getAll()	{
		JdbcTemplate temp = new JdbcTemplate(dataSource);
		return temp.query
	("Select kms,numOfOwners,validInsurance,color,make,model,price,yearManufactured,version,id from car"
			, new CarRowMapper());
	}

}







