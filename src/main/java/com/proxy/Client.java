package com.proxy;

public class Client {

	public static void main(String[] args) {
		//Same Proxy instance (ProxyInstance) Foo Implementation
	    Foo foo = (Foo) ProxyInstance.newInstance(new FooImpl());
		//Same Proxy instance (ProxyInstance) IAuto Implementation
	    IAuto auto = (IAuto) ProxyInstance.newInstance(new AutoImpl());
		//Same Proxy instance (ProxyInstance) Foo Implementation
	    IApr apr = (IApr) ProxyInstance.newInstance(new AprImpl());

	    try {
			System.out.println(foo.bar(null));
			System.out.println(auto.getAutoDetail("1"));
			System.out.println(apr.getApr(new Integer(800)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
