package br.com.codecompany.rysys.fgl.test.annotation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)  
@SuiteClasses({TestFglAnnotatedPojo.class,
			   TestFglDateAnnotation.class,
			   TestFglFloatAnnotation.class,
	           TestFglIntegerAnnotation.class,
			   TestFglTextAnnotation.class})
public class TestFglAnnotations {

}
