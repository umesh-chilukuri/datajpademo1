package in.ashokit;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import in.ashokit.repositories.*;
import in.ashokit.entities.*;
@SpringBootApplication
public class Springbootdatajpa1Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctxt=	SpringApplication.run(Springbootdatajpa1Application.class, args);
	
	ContactsMasterRepo bean =ctxt.getBean(ContactsMasterRepo.class);
	
	ContactsMasterEntity entity=new ContactsMasterEntity();
	
	/*
	entity.setContactId(101);
	entity.setContactName("Umesh");
	entity.setContactNumber(7894561230L); // Long literal
	bean.save(entity);
	
	
	//saving multiple records by converting into list
    ContactsMasterEntity entity2=new ContactsMasterEntity();
	entity2.setContactId(102);
	entity2.setContactName("kiran");
	entity2.setContactNumber(789456L);
	
	
    ContactsMasterEntity entity3=new ContactsMasterEntity();	
	entity3.setContactId(103);
	entity3.setContactName("hero");
	entity3.setContactNumber(789456696969L);
	
    List<ContactsMasterEntity> asList = Arrays.asList(entity2,entity3); 
    bean.saveAll(asList);
    */
	
	Optional<ContactsMasterEntity> byId = bean.findById(101);
	
	System.out.println("reslut is "+byId);
	if(byId.isPresent()) {
		System.out.println(byId.get());
	}
    
 
    ctxt.close();
	
	}

}
