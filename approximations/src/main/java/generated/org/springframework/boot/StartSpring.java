package generated.org.springframework.boot;

import org.springframework.test.context.TestContextManager;
import stub.spring.SpringDatabases;

import java.lang.reflect.Method;

public class StartSpring {

    public static void startSpring() throws Exception {
        TestContextManager testContextManager = new TestContextManager(SpringBootTestClass.class);
        SpringBootTestClass testClass = new SpringBootTestClass();
        testContextManager.prepareTestInstance(testClass);
        testContextManager.beforeTestClass();
        Method testMethod = SpringBootTestClass.class.getDeclaredMethod("fakeTest");
        testContextManager.beforeTestMethod(testClass, testMethod);
        SpringDatabases.entityManager = testClass.entityManager;
        SpringMvcPerformer.perform(testClass.mockMvc);
    }
}
