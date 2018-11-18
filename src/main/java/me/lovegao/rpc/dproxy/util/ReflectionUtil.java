package me.lovegao.rpc.dproxy.util;

import java.util.Set;

import org.reflections.Reflections;

import me.lovegao.rpc.dproxy.annotations.DemoAnnotation;

public class ReflectionUtil {
	public void scan() {
		Reflections reflections = new Reflections("com.dao");
		Set<Class<?>> annotationClasses = reflections.getTypesAnnotatedWith(DemoAnnotation.class);
		
	}
}
