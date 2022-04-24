package com.ffideal.spring;

        import com.ffideal.spring.config.EmpConfig;
        import com.ffideal.spring.entity.Employee;
        import com.ffideal.spring.scope.ThreadScope;
        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.annotation.AnnotationConfigApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

        import java.util.concurrent.TimeUnit;

/**
 * @ClassName: EntityTest
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/16 21:34
 * @Version: v1.0
 */

public class EntityTest {

    @Test
    public void testIOC() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        //可以直接通过配置类实现
        //Employee emp = applicationContext.getBean(Employee.class);
        //getBean括弧中与spring配置文件中的id对应
        Employee emp = (Employee) applicationContext.getBean("employee");
        System.out.println(emp.toString());
        // Person这个类型的组件在IOC容器中的名字是什么呢？
        String[] namesForType = applicationContext.getBeanDefinitionNames();
        for (String name : namesForType) {
            System.out.println(name);
        }
    }
    @Test
    public void testAnnocationIOC() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmpConfig.class);
        //getBean括弧中与spring配置文件中的id对应
        Employee emp = applicationContext.getBean(Employee.class);
        System.out.println(emp.toString());
        // Person这个类型的组件在IOC容器中的名字是什么呢？
        String[] namesForType = applicationContext.getBeanNamesForType(Employee.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }
    @Test
    public void testXMLComponentScan() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        // IOC容器中的名字是什么呢？
        String[] namesForType = applicationContext.getBeanDefinitionNames();
        for (String name : namesForType) {
            System.out.println(name);
        }
    }

    @Test
    public void testAnnotationComponentScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmpConfig.class);
        // IOC容器中的名字是什么呢？
        String[] namesForType = applicationContext.getBeanDefinitionNames();
        for (String name : namesForType) {
            System.out.println(name);
        }
    }

    @Test
    public void testScope() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmpConfig.class);
        Employee emp1 = (Employee) applicationContext.getBean("emp");
        Employee emp2 = (Employee) applicationContext.getBean("emp");
        System.out.println(emp1==emp2);
    }

    @Test
    public void testCustomScope() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmpConfig.class);
        // 向容器中侧足自动以的Scope
        ((AnnotationConfigApplicationContext) applicationContext).getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());

        // 使用容器获取bean
        for (int i = 0; i < 2; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread()+","+applicationContext.getBean("emp"));
                System.out.println(Thread.currentThread()+","+applicationContext.getBean("emp"));
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLazy() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmpConfig.class);
        Employee emp1 = (Employee) applicationContext.getBean("emp");
        Employee emp2 = (Employee) applicationContext.getBean("emp");
        System.out.println(emp1==emp2);
    }

    @Test
    public void testConditional() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmpConfig.class);
        String[] names = applicationContext.getBeanNamesForType(Employee.class);
        for (String name : names) {
            System.out.println(name);
        }

    }
}
