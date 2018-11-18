package me.lovegao.rpc.dynamicproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory3 {
	private Class targetClass;
	
	public ProxyFactory3(Class targetClass) {
		this.targetClass = targetClass;
	}
	
	public Object getProxyInstance() {
		Object obj = Proxy.newProxyInstance(
				targetClass.getClassLoader(), 
				targetClass.getInterfaces(), 
				new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("开始");
//				Object returnValue = method.invoke(target, args);
				Object returnValue = null;
				System.out.println("提交");
				return returnValue;
			}
		});
		return obj;
	}
}
