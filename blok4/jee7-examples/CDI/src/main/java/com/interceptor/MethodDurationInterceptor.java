package com.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Calendar;

// Also defined in the beans.xml
@MeasureMethodDuration
@Interceptor
public class MethodDurationInterceptor {

	@AroundInvoke
	public Object check(InvocationContext ic) throws Exception {
		long startTime = Calendar.getInstance().getTimeInMillis();
		try {
			return ic.proceed();
		} finally {
			long endTime = Calendar.getInstance().getTimeInMillis();
			long methodDuration = endTime - startTime;
			System.out.println(ic.getClass().getSimpleName() + " " + ic.getMethod().getName() + " method duration was " + methodDuration);
		}
	}
}
