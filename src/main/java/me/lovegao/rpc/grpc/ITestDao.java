package me.lovegao.rpc.grpc;

public interface ITestDao {
	void sayHello();
	void sayHello(String s);
	String packSay(String name);
}
