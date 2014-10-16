package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInstance implements InvocationHandler{

	private Object obj;
	
	public ProxyInstance(Object obj) {
		this.obj = obj;
	}

	public static Object newInstance(Object obj){
		Class[] interfaces = new Class[] { Foo.class, IAuto.class, IApr.class };
		return Proxy.newProxyInstance( obj.getClass().getClassLoader(), 
									   interfaces, 
									   new ProxyInstance(obj));
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		Object result;
		System.out.println("before method " + method.getName());
		result = method.invoke(obj, args);
		return result;
	}
}
