package me.lovegao.rpc.dynamicproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory2 {
	private Object target;
	
	public ProxyFactory2(Object target) {
		this.target = target;
	}
	
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
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
	}
}
