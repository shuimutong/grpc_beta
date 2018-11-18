package me.lovegao.rpc.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import junit.framework.Assert;
import me.lovegao.rpc.grpc.ClassUtil;

public class ClassUtilTest {
	@Test
	public void getClassInterfacesTest() {
		Class[] inters = ClassUtil.getClassInterfaces(ClassUtil.class, false);
		System.out.println(JSONObject.toJSONString(inters));
		Assert.assertTrue(inters.length == 0);
		inters = ClassUtil.getClassInterfaces(ClassUtil.class, true);
		System.out.println(JSONObject.toJSONString(inters));
		Assert.assertTrue(inters.length == 0);
	
		inters = ClassUtil.getClassInterfaces(ArrayList.class, true);
		System.out.println(JSONObject.toJSONString(inters));
		Assert.assertTrue(inters.length == 4);
		
		inters = ClassUtil.getClassInterfaces(ArrayList.class, false);
		System.out.println(JSONObject.toJSONString(inters));
		Assert.assertTrue(inters.length == 4);
		
		inters = ClassUtil.getClassInterfaces(List.class, false);
		System.out.println(JSONObject.toJSONString(inters));
		Assert.assertTrue(inters.length == 1);
		
		inters = ClassUtil.getClassInterfaces(List.class, true);
		System.out.println(JSONObject.toJSONString(inters));
		Assert.assertTrue(inters.length == 2);
		
	}
}
