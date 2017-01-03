package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Class is analogue web.xml
 */
@Configuration
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext servletAppContext =
                new AnnotationConfigWebApplicationContext();
        servletAppContext.register(MVCConfig.class, ApplicationConfig.class,
                HibernateConfig.class, SecurityConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        FilterRegistration.Dynamic
                encodingFilter =
                servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "");

    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]
                {/*HibernateConfig.class, SecurityConfig.class*/};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                /*MVCConfig.class*/
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
