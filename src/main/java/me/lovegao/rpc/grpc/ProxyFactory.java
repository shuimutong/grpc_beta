package me.lovegao.rpc.grpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class ProxyFactory {
	private Class proxyClazz;
	private ClassLoader classLoader;
	private Class[] interfaces;
	
	public ProxyFactory(ClassLoader classLoader, Class[] interfaces) {
		this.classLoader = classLoader;
		this.interfaces = interfaces;
	}
	
	public ProxyFactory(Class clazz) {
		this.proxyClazz = clazz;
		this.classLoader = clazz.getClassLoader();
		this.interfaces = ClassUtil.getClassInterfaces(clazz, true);
	}
	
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(
				classLoader, 
				interfaces, 
				new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("开始--");
				Object returnValue = invokeOther(method, args);
				System.out.println("提交--");
				return returnValue;
			}
		});
	}
	
	public abstract Object invokeOther(Method method, Object[] args);
	
}
