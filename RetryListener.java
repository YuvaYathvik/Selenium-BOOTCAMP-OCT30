package Selenium.Started.Nov;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.ITest;

public class RetryListener implements IAnnotationTransformer{

	 public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		 annotation.setRetryAnalyzer(RetryFailed.class);
		 
		 
	}

	}


