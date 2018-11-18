package me.lovegao.rpc.dynamicproxy.demo;

import java.util.Arrays;

import com.alibaba.fastjson.JSONObject;

import me.lovegao.rpc.grpc.ITestDao;
import me.lovegao.rpc.grpc.ProxyFactory;
import me.lovegao.rpc.grpc.TestDao;

public class Client {

	public static void main(String[] args) {
//		IUserDao target = new UserDao();
//		System.out.println(target.getClass());
//		IUserDao proxy = (IUserDao)new ProxyFactory(target).getProxyInstance();
//		System.out.println(proxy.getClass());
//		proxy.save();
		
		ITestDao target = new TestDao();
		
//		System.out.println(target.getClass());
//		ITestDao proxy = (ITestDao) new ProxyFactory(target).getProxyInstance();
//		System.out.println(proxy.getClass());
//		proxy.sayHello();
//		proxy.sayHello("Jack");
		
		
		System.out.println("2--------------------");
		ITestDao proxy2 = (ITestDao) new ProxyFactory1(target).getProxyInstance();
		System.out.println(proxy2.getClass());
		proxy2.sayHello();
		proxy2.sayHello("Jack");
		
//		System.out.println("--------------------");
//		ITestDao proxy3 = (ITestDao) new ProxyFactory(ITestDao.class).getProxyInstance();
//		System.out.println(proxy3.getClass());
//		proxy3.sayHello();
		

		System.out.println("3--------------------");
		ITestDao proxy3 = (ITestDao) new ProxyFactory3(ITestDao.class).getProxyInstance();
		System.out.println(proxy3.getClass());
		proxy3.sayHello();
		proxy3.sayHello("Jack");
	}

}
