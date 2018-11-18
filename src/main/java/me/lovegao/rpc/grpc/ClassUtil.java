package me.lovegao.rpc.grpc;

import java.util.Arrays;

public class ClassUtil {
	/**
	 * 获取类的接口类
	 * @param clazz 待检查类
	 * @param checkSelf 是否检查自己
	 * @return
	 */
	public static Class[] getClassInterfaces(Class clazz, boolean checkSelf) {
		Class[] interfaces = null;
		if(clazz != null) {
			interfaces = clazz.getInterfaces();
			if(checkSelf && clazz.isInterface()) {
				interfaces = Arrays.copyOf(interfaces, interfaces.length + 1);
				interfaces[interfaces.length-1] = clazz;
			}
		}
		return interfaces;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
