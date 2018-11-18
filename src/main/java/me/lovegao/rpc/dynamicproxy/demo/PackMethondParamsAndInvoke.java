package me.lovegao.rpc.dynamicproxy.demo;

import me.lovegao.rpc.grpc.ProxyMethodDesc;

public interface PackMethondParamsAndInvoke {
	/**
	 * 组装代理的方法
	 * @param clazzAndMethondName
	 * @param args
	 * @return
	 */
	ProxyMethodDesc packMethodParams(String clazzName, String methondName, Object[] args);
	/**
	 * 执行代理的方法
	 * @param methodDesc
	 * @return
	 */
	<T> T invokeMethod(ProxyMethodDesc methodDesc);
}
