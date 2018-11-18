package me.lovegao.rpc.grpc;

@GServiceAnnotation(ITestDao.class)
public class TestDao implements ITestDao {

	@Override
	public void sayHello() {
		System.out.println("Hello----");
	}

	@Override
	public void sayHello(String s) {
		System.out.println("Hello,--" + s);
	}

	@Override
	public String packSay(String name) {
		return "Hello,--" + name;
	}

}
