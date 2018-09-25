//////////////////////////////////////
// Web part of an application       //
//                                  //
//////////////////////////////////////
package prykhodko.learnSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import prykhodko.learnSpring.util.ViewNames;

/**
 * WebMvcConfigurer interface Defines callback methods to customize the Java-based configuration for
 * Spring MVC enabled via @EnableWebMvc.
 * @EnableWebMvc-annotated configuration classes may implement this interface to be called back and
 * given a chance to customize the default configuration.
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "prykhodko.learnSpring")
public class WebConfig implements WebMvcConfigurer  {

    // == constants ==
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX =".jsp";

    // == bean methods
    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }

    /**
     * Used to configure simple automated controllers that are preconfigured with a
     * response status code or a view to render the response body.
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName(ViewNames.HOME);
    }
}
