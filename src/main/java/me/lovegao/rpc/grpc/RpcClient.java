package me.lovegao.rpc.grpc;

public class RpcClient {
	public static void main(String[] args) {
		ITestDao target = (ITestDao) new ProxyFactoryImpl(ITestDao.class).getProxyInstance();
//		target.sayHello();
//		target.sayHello("Jack");
		String result = target.packSay("Jam");
		System.out.println("RpcClient,theResultFromServer,result:" + result);
	}
}
