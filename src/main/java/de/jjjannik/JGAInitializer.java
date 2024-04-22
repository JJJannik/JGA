package de.jjjannik;

import com.google.gson.Gson;
import de.jjjannik.api.JGA;
import de.jjjannik.api.impl.JGAImpl;
import lombok.Getter;
import org.apache.log4j.PropertyConfigurator;

/**
 * Entry point for JGA
 */
public class JGAInitializer {
    @Getter private static final Gson gson = new Gson();
    private static JGA jga;

    private JGAInitializer() throws IllegalAccessException {
        throw new IllegalAccessException("Initializer class");
    }

    /**
     * Initialized the API and the logger
     */
    public static void init() {
        PropertyConfigurator.configure(JGAInitializer.class.getClassLoader().getResourceAsStream("log4j2.properties"));

        jga = new JGAImpl();
    }

    /**
     * <b>Must call init() before calling this method</b>
     * @throws IllegalStateException if not initialized
     * @return JGA Wrapper object
     */
    public static JGA getJGA() {
        if (jga == null) {
            throw new IllegalStateException("API not initialized");
        }
        return jga;
    }
}