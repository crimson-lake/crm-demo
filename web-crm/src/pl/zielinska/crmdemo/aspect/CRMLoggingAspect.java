package pl.zielinska.crmdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* pl.zielinska.crmdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* pl.zielinska.crmdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* pl.zielinska.crmdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("*** @Before: calling method: " + theMethod + " ***");
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object arg : args) {
			myLogger.info("*** argument: " + arg + " ***");
		}
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("*** @AfterReturning: from method: " + theMethod + " ***");
		
		myLogger.info("*** result: " + theResult + " ***");
	}
	
}
