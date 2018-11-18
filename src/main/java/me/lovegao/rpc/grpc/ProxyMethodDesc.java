package me.lovegao.rpc.grpc;

import java.lang.reflect.Method;

/**
 * 代理的方法描述
 * @author simple
 *
 */
public class ProxyMethodDesc {
	//方法
	private Method method;
	//参数值
	private Object[] args;
	
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
}
