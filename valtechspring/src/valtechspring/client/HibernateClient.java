package valtechspring.client;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import valtechspring.orm.Account;
import valtechspring.orm.Address;
import valtechspring.orm.AtmTx;
import valtechspring.orm.BankAccount;
import valtechspring.orm.BankAccountId;
import valtechspring.orm.Car;
import valtechspring.orm.CarDetails;
import valtechspring.orm.ChequeTx;
import valtechspring.orm.Customer;
import valtechspring.orm.TellerTx;
import valtechspring.orm.Tx;
import valtechspring.orm.dao.CustomerDAO;
import valtechspring.orm.dao.CustomerDAOImpl;


public class HibernateClient {

	public static void main(String[] args) {
//		SessionFactory sf = new Configuration()
		SessionFactory sf = new AnnotationConfiguration()
				.configure()
//				.addClass(Car.class)
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(BankAccount.class)
				.addAnnotatedClass(Tx.class).addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class).addAnnotatedClass(ChequeTx.class)
				.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class)
				.addAnnotatedClass(Account.class)
				.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		
		CustomerDAO customerDAO = new CustomerDAOImpl();
//		for(Customer c : customerDAO.getByTxAmountGreaterThan(ses, 2000))	{
//			System.out.println(c);
//		}
		
		for(Customer c : customerDAO.getByAccountType(ses,"SB"))	{
			System.out.println(c);
		}
		
		System.out.println("Combined Bal for Customer 1 = "+customerDAO.getCombinedBalance(ses,1));
		System.out.println("Combined Bal for Customer 2 = "+customerDAO.getCombinedBalance(ses,2));
		System.out.println("Combined Bal for Customer 4 = "+customerDAO.getCombinedBalance(ses,4));
		System.out.println("Combined Bal for Customer 5 = "+customerDAO.getCombinedBalance(ses,5));
		
//		List objects = ses.createQuery("SELECT o FROM java.lang.Object o").list();
//		for(Object o:objects)	{
//			System.out.println(o);
//		}
		
		
//		Customer c = new Customer("Pqr",new Date(90, 5, 13),1);
//		Address a = new Address("JP Nagar","Blr","Kar",560078);
//		
//		ses.save(c);
//		ses.save(a);
//		c.setAddress(a);
//		
//		Customer c1 = new Customer("Abc",new Date(90, 5, 13),1);	// Check your DB for Valid Values
//		ses.save(c1);
//		
//		Account ac = new Account(1000,"SB");
//		Account ac1 = new Account(10000,"CA");
//		ses.save(ac);
//		ses.save(ac1);
//		
//		Account ac2 = new Account(2000,"SB");	// Check your DB for Valid Values
//		Account ac3 = new Account(3000,"SB");;	// Check your DB for Valid Values
//		ses.save(ac2);
//		ses.save(ac3);
//		
//		c.addAccount(ac);
//		c.addAccount(ac3);
//		c.addAccount(ac2);
//		
//		c1.addAccount(ac3);
//		c1.addAccount(ac1);
//		
		
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000,123456,false,2));
//		ses.save(new TellerTx(2500,"Teller1","JP Nagar"));
//		ses.save(new AtmTx(3000,123,"Jayanagar"));
		
//		List<Tx> txs = ses.createQuery("SELECT tx FROM Tx tx").list();
//		for(Tx t: txs)	{
////			Ternary Operator boolCOnd ? true : false
//			t.setAccount(t.getId() % 2 == 0 ? ac : ac1);
//		}
		
//		Customer c = new Customer("Abc",new Date(74, 5, 13),1);
//		Address a = new Address("JP Nagar","Blr","Kar",560078);
//		ses.save(c);
//		ses.save(a);
//		a.setCustomer(c);
//		c.setAddress(a);
		
		
//		
//		List<Tx> txs = ses.createQuery("SELECT t fro1974m Tx t").list();
//		for(Tx t : txs){
//			System.out.println(t);
//		}
		
//		BankAccount ba = (BankAccount) ses.load(BankAccount.class, new BankAccountId(1,"SB"));
//		System.out.println(ba);
		
//		ba.setAccountNo(2);
//		ba.setAccounType("SB");
//		ba.setActive(true);
//		ba.setBalance(2000);
//		ba.setOpeningDate(new Date());
//		ses.save(ba);
		
//		Car car = new Car("Honda", "City", 2019, 1100000, "Black",new CarDetails(25000,true,1));
//		ses.save(car);
//		Car car = (Car) ses.load(Car.class,1);
//		System.out.println("Car Loaded "+car.getClass().getName());
//		car.getMake();
//		car.setPrice(1250000);
//		ses.update(car);
		
		tx.commit();
		ses.close();
		sf.close();
	}

}





