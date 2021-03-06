package play;

import java.io.*;
import java.util.*;

/**
 * A Play application.
 * <p>
 * Application creation is handled by the framework engine.
 */
public class Application {
    
    private final play.api.Application application;
    
    /**
     * Creates an application from a Scala Application value.
     */
    public Application(play.api.Application application) {
        this.application = application;
    }
    
    /**
     * Retrieves the application path.
     * <p>
     * @return the application path
     */
    public File path() {
        return application.path();
    }
    
    /**
     * Retrieves the application classloader.
     * <p>
     * @return the application classloader
     */
    public ClassLoader classloader() {
        return application.classloader();
    }
    
    /**
     * Retrieves a file relative to the application root path.
     *
     * @param relativePath relative path of the file to fetch
     * @return a file instance - it is not guaranteed that the file exists
     */
    public File getFile(String relativePath) {
        return application.getFile(relativePath);
    }
    
    /**
     * Scans the application classloader to retrieve all types annotated with a specific annotation.
     * <p>
     * This method is useful for some plug-ins, for example the EBean plugin will automatically detect all types
     * annotated with <code>@javax.persistance.Entity</code>.
     * <p>
     * Note that it is better to specify a very specific package to avoid expensive searches.
     *
     * @param packageName the root package to scan
     * @param annotation annotation class
     * @return a set of types names statifying the condition
     */
    public Set<String> getTypesAnnotatedWith(String packageName, Class<? extends java.lang.annotation.Annotation> annotation) {
        return scala.collection.JavaConverters.setAsJavaSetConverter(
            application.getTypesAnnotatedWith(packageName, annotation)
        ).asJava();
    }
    
}