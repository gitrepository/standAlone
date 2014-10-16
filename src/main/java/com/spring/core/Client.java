package com.spring.core;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	private static Logger log = Logger.getLogger(Client.class.getName());

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SingleTon s1 = (SingleTon) ctx.getBean("s1");
		SingleTon s2 = (SingleTon) ctx.getBean("s1");
		SingleTon s3 = (SingleTon) ctx.getBean("s2");

		ProtoType p1 = (ProtoType) ctx.getBean("p1");
		ProtoType p2 = (ProtoType) ctx.getBean("p1");

		s1.setCount(s1.getCount()+1);
		s1.getSc().setCount(s1.getSc().getCount()+1);
		s1.getPc().setCount(s1.getPc().getCount()+1);
		log.info("Singleton Bean1 Count "+s1.getCount()+" * "+s1.getSc().getCount()+" * "+s1.getPc().getCount());
		s2.setCount(s2.getCount()+1);
		s2.getSc().setCount(s2.getSc().getCount()+1);
		s2.getPc().setCount(s2.getPc().getCount()+1);
		log.info("Singleton Bean1 Count "+s2.getCount()+" * "+s2.getSc().getCount()+" * "+s2.getPc().getCount());
		//Another NEW instance of the SINGLETON bean "SingleTon"
		s3.setCount(s3.getCount()+1);
		log.info("Singleton Bean2 Count "+s3.getCount());

		log.info("####");
		p1.setCount(p1.getCount()+1);
		p1.setCreateCount(p1.getCreateCount()+1);
		log.info("Prototype Bean1 Count "+p1.getCount()+" Static Count "+p1.getCreateCount());
		p2.setCount(p2.getCount()+1);
		p2.setCreateCount(p2.getCreateCount()+1);
		log.info("Prototype Bean1 Count "+p2.getCount()+" Static Count "+p2.getCreateCount());
	}
}
