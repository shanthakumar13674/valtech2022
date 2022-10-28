package valtechspring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimerAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		long time = System.nanoTime();
		if(mi.getMethod().getName().equals("div"))	{
			int j = (Integer) mi.getArguments()[1];
			if(j == 0) return 0;
		}
		Object[] args = mi.getArguments();
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof Integer) {
				int j = (Integer) args[i];
				args[i] = j < 0 ? -j : j;
			}
		}
		Object obj = mi.proceed();
		int j = (Integer)obj;
		j = j < 0 ? -j : j;
		long diff = System.nanoTime() - time;
		System.out.println(mi.getMethod().getName() + " took " + diff + " nano secs.");
		return j;
	}

}








