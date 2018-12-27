package prykhodko.learnSpring.config;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

/**
 * Starts embedded Jetty webserver to handle JSP pages in Spring MVC project.
 */
public class EmbeddedJetty{

    private static final int PORT = 9092;
    private static final String CONTEXT_PATH = "/shopping";
    private static final String WEBAPP_DIRECTORY = "webapp";
    private static final String CONFIG_LOCATION = "prykhodko.learnSpring.config";
    private static final String MAPPING_URL = "/";

    public static void main(String[] args) throws Exception {
        new EmbeddedJetty().startJetty(PORT);
    }

    /**
     * Starts Jetty server on provided port.
     *
     * GOOD read: https://www.eclipse.org/jetty/documentation/9.4.x/embedded-examples.html
     * --Web Application with JSP-- section
     *
     * @param port
     * @throws Exception
     */
    private void startJetty(int port) throws Exception {
        Server server = new Server(PORT);

        /***** JSP SUPPORT ADD TO JETTY ***/
        org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList
                .setServerDefault(server);
        classlist.addBefore(
                "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration");
        /*********************************/

        server.setHandler(getServletContextHandler(getContext()));

        try {
            server.start();
            server.join();
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles servlet context for Jetty.
     *
     * @param context
     * @return
     */
    private WebAppContext getServletContextHandler(WebApplicationContext context) {

        final WebAppContext webAppContext = new WebAppContext();

        /***** JSP SUPPORT ADD TO JETTY ***/
        webAppContext.setAttribute(
                "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$");
        /*********************************/

        webAppContext.setErrorHandler(null);
        webAppContext.setContextPath(CONTEXT_PATH);

        webAppContext.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        webAppContext.addEventListener(new ContextLoaderListener(context));

        try {
            webAppContext.setResourceBase(new ClassPathResource(WEBAPP_DIRECTORY).getURI().toString());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        return webAppContext;
    }

    /**
     * Set's up application context with config classes from config package.
     * @return
     */
    private WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);

        return context;
    }
}