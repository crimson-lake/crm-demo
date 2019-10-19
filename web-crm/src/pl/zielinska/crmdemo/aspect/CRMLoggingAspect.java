package pl.zielinska.crmdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* pl.zielinska.crmdemo.controller.*.*.(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* pl.zielinska.crmdemo.service.*.*.(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* pl.zielinska.crmdemo.dao.*.*.(..))")
	private void forDAOPackage() {}
	
	

}
