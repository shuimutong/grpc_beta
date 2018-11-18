package me.lovegao.rpc.grpc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.alibaba.fastjson.JSONObject;

public class RpcServer {
	

	public static void main(String[] args) {
		Map<String, Class> implClassMap =  scanGService();
		System.out.println(JSONObject.toJSONString(implClassMap));
		Map<String, Object> entityMap = instanceImplClass(implClassMap);
		
	}
	
	public static Object invokeProxyMethod(ProxyMethodDesc proxyMethodDesc) {
		Object resultObj = null;
		Map<String, Class> implClassMap =  scanGService();
		System.out.println(JSONObject.toJSONString(implClassMap));
		Map<String, Object> entityMap = instanceImplClass(implClassMap);
		
		Method proxyMethod = proxyMethodDesc.getMethod();
		String interfaceName = proxyMethod.getDeclaringClass().getName();
		if(entityMap.containsKey(interfaceName)) {
			Object targetObj = entityMap.get(interfaceName);
			try {
				System.out.println("-------RpcServerStart--------");
				resultObj = proxyMethod.invoke(targetObj, proxyMethodDesc.getArgs());
				System.out.println("-------RpcServerEnd--------");
				System.out.println(JSONObject.toJSONString(resultObj));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("notFound");
		}
		return resultObj;
	}
	
	public static Map<String, Object> instanceImplClass(Map<String, Class> implClassMap) {
		Map<String, Object> entityMap = new HashMap();
		for(String interfaceName : implClassMap.keySet()) {
			try {
				Object t = implClassMap.get(interfaceName).getConstructor().newInstance();
				entityMap.put(interfaceName, t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return entityMap;
	}

	public static Map<String, Class> scanGService() {
		Map<String, Class> map = new HashMap();
		Reflections reflections = new Reflections("me.lovegao.rpc");
		Set<Class<?>> annotationClasses = reflections.getTypesAnnotatedWith(GServiceAnnotation.class);
		for(Class clazz : annotationClasses) {
			GServiceAnnotation[] annotations = (GServiceAnnotation[]) clazz.getAnnotationsByType(GServiceAnnotation.class);
			String implInterfaceName = annotations[0].value().getName();
			map.put(implInterfaceName, clazz);
		}
		return map;
	}
}
