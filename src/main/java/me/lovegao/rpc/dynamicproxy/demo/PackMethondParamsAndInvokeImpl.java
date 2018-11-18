package me.lovegao.rpc.dynamicproxy.demo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import me.lovegao.rpc.grpc.ProxyMethodDesc;

public class PackMethondParamsAndInvokeImpl implements PackMethondParamsAndInvoke {
	private Map<String, Class> NAME_CLASS_MAP = new HashMap(); 

	@Override
	public ProxyMethodDesc packMethodParams(String clazzName, String methondName, Object[] args) {
		ProxyMethodDesc methodDesc = new ProxyMethodDesc();
		Class targetClass = NAME_CLASS_MAP.get(clazzName);
		Class[] parameterTypes = new Class[args.length];
		for(int i=0; i<args.length; i++) {
			parameterTypes[i] = args[i].getClass();
		}
		try {
			Method targetMethod = targetClass.getDeclaredMethod(methondName, parameterTypes);
			methodDesc.setMethod(targetMethod);
			methodDesc.setArgs(args);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return methodDesc;
	}

	@Override
	public <T> T invokeMethod(ProxyMethodDesc methodDesc) {
		// TODO Auto-generated method stub
		return null;
	}

}
