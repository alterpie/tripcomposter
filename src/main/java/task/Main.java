package task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:app-context.xml");

        ApplicationRun run = ctx.getBean(ApplicationRun.class);

        run.doTestTask("http://tripcomposer.net/rest/test/countries/get");
    }
}
