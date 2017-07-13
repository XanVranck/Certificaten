package be.jasper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class CertificatenRestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CertificatenRestApplication.class, args);
		DispatcherServlet dispatcherServlet = (DispatcherServlet)ctx.getBean("dispatcherServlet");
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
	}
}
