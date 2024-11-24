package prog2.holdingweb;

import javax.servlet.ServletContext; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRegistration; 
import org.springframework.web.servlet.DispatcherServlet; 
import org.springframework.web.WebApplicationInitializer; 
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext; 
 
public class AppInitializer implements WebApplicationInitializer { 
 
    @Override 
    public void onStartup(ServletContext servletContext) throws ServletException { 
        AnnotationConfigWebApplicationContext context = 
            new AnnotationConfigWebApplicationContext(); 
        context.register(AppConfig.class); 
        context.setServletContext(servletContext); 
         
        ServletRegistration.Dynamic servlet = 
            servletContext.addServlet("dispatcher", new DispatcherServlet(context)); 
        servlet.setLoadOnStartup(1); 
        servlet.addMapping("/"); 
    } 
} 
