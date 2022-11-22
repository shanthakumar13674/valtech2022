package bookrecord.client;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import bookrecord.orm.AuthorAddress;
import bookrecord.orm.Article;
import bookrecord.orm.Author;
import bookrecord.orm.Blog;
import bookrecord.orm.Book;
import bookrecord.orm.HardBind;
import bookrecord.orm.Publisher;

public class HibernateClient {
	public static void main(String[] args) {
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(AuthorAddress.class).addAnnotatedClass(Article.class).addAnnotatedClass(Author.class).addAnnotatedClass(Blog.class).addAnnotatedClass(HardBind.class).addAnnotatedClass(Publisher.class).buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		
//	Book b=new Book("book3","2A",100,new Date(74,8,15));
//	ses.save(b);
//	Publisher p =  new Publisher(1,"ritesh", "bangalore", 7300422656L);
//	
//	ses.save(p);
//	b.setPublisher(p);
//	ses.save(b);
	
	Article a1= new Article("abc.exam.com","nuthansml");
	ses.save(a1);
	Author a=new Author("divya",85555656656L);
	ses.save(a);
	AuthorAddress a2=new AuthorAddress(50,"jp nagar", "ka", 560078L);
	ses.save(a2);
	a.setAuthoraddress(a2);
	a2.setAuthor(a);
	Blog b1=new Blog("boom", "nhibataunga@getlost.com", 2L);
	ses.save(b1);
	HardBind hb1=new HardBind(1, 200, "2022", 1);
	ses.save(hb1);
	
	tx.commit();
	ses.close();
	sf.close();
	}

}
