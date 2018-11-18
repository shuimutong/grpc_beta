package me.lovegao.rpc.grpc;

import java.lang.reflect.Method;

import com.alibaba.fastjson.JSONObject;

public class ProxyFactoryImpl extends ProxyFactory {

	public ProxyFactoryImpl(Class clazz) {
		super(clazz);
	}

	@Override
	public Object invokeOther(Method method, Object[] args) {
		Object resultObj = null;
		System.out.println(method.getName());
		System.out.println(method.getDeclaringClass());
		System.out.println(JSONObject.toJSONString(method));
		System.out.println(JSONObject.toJSONString(args));
		
		ProxyMethodDesc proxyMethod = new ProxyMethodDesc();
		proxyMethod.setMethod(method);
		proxyMethod.setArgs(args);
		System.out.println("---------start----------");
		resultObj = RpcServer.invokeProxyMethod(proxyMethod);
		System.out.println("------resultObj:" + resultObj);
		System.out.println("---------end----------");
		return resultObj;
	}

}
