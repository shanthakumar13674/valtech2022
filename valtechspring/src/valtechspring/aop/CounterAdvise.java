package valtechspring.aop;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvise implements MethodBeforeAdvice {
	
	private Map<String, Integer> counters = new HashMap<>();
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String name = method.getName();
		if(counters.containsKey(name))	{
			counters.put(name, counters.get(name)+1);
		}	else		{
			counters.put(name, 1);
		}
		System.out.println(counters);
	}

}
