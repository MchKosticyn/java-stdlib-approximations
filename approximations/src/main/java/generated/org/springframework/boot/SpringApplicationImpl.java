package generated.org.springframework.boot;

import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.pinnedValues.PinnedValueStorage;
import jakarta.servlet.Filter;
import jakarta.servlet.http.Cookie;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpMethod;
// TODO: Security #AA
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.usvm.api.Engine;

import static generated.org.springframework.boot.pinnedValues.PinnedValueSource.RESPONSE_EXCEPTION;
import static generated.org.springframework.boot.pinnedValues.PinnedValueStorage.writePinnedValue;
// TODO: Security #AA
// import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import java.io.UnsupportedEncodingException;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Approximate(org.springframework.boot.SpringApplication.class)
public class SpringApplicationImpl {

    private List<ApplicationListener<?>> listeners;

    private ApplicationContextFactory applicationContextFactory = ApplicationContextFactory.DEFAULT;

    private boolean registerShutdownHook = false;

    private List<List<Object>> _allControllerPaths() {
        return new ArrayList<>();
    }

    public static void _println(String message) { }

    public static void _internalLog(String... message) {
        for (String str : message) {
            _println(str);
        }
    }

    private static void _initValueFieldsSymbolic(Object obj) { }

    private static List<Class<?>> _classesWithFieldsValueAnnotation() {
        return new ArrayList<>();
    }

    private static void _writeResponse(MockHttpServletResponse response) {
        writePinnedValue(PinnedValueSource.RESPONSE_STATUS, response.getStatus());
        try {
            writePinnedValue(PinnedValueSource.RESPONSE_CONTENT, response.getContentAsString());
        } catch (UnsupportedEncodingException e) {
            _internalLog("[ERROR] Writing response content failed because of unsupported encoding: %s".formatted(e.getMessage()));
        }
        for (String headerName : response.getHeaderNames()) {
            writePinnedValue(PinnedValueSource.RESPONSE_HEADER, headerName, response.getHeaders(headerName));
        }
        for (Cookie cookie : response.getCookies()) {
            writePinnedValue(PinnedValueSource.REQUEST_COOKIE, cookie.getName(), cookie);
        }
    }

    private static void _fillSecurityHeaders() {
        writePinnedValue(PinnedValueSource.REQUEST_HEADER, "AUTHORIZATION", null);
    }

// TODO: Security #AA
//    private static UserDetails _createSymbolicUser() {
//        String username = getPinnedValue(PinnedValueSource.REQUEST_USER_NAME, String.class);
//        String password = getPinnedValue(PinnedValueSource.REQUEST_USER_PASSWORD, String.class);
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        Engine.assume(username != null && !username.isEmpty());
//        Engine.assume(password != null && !password.isEmpty());
//        return new User(username, password, authorities);
//    }

    protected void afterRefresh(ConfigurableApplicationContext context, ApplicationArguments args) {
        // TODO: care about conditional beans
        _startAnalysis();
        // TODO: enable filters!
//        Object[] beans = context.getBeansOfType(Filter.class).values().toArray();
//        Filter[] filters = Arrays.copyOf(beans, beans.length, Filter[].class);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup((WebApplicationContext) context);
//        builder.addFilters(filters);
        MockMvc mockMvc = builder.build();
        List<List<Object>> allPaths = _allControllerPaths();
        for (List<Object> pathData : allPaths) {
            boolean pathFound = Engine.makeSymbolicBoolean();
            if (!pathFound)
                continue;

            String controllerName = (String) pathData.get(0);
            String path = (String) pathData.get(2);
            Integer paramCount = (Integer) pathData.get(3);
            String methodName = (String) pathData.get(4);

            _internalLog("[USVM] starting to analyze path ", path, " of controller ", controllerName);
            writePinnedValue(PinnedValueSource.REQUEST_PATH, path);
            writePinnedValue(PinnedValueSource.REQUEST_METHOD, methodName);

            Object[] pathArgs = new Object[paramCount];
            Arrays.fill(pathArgs, 0);
            // TODO: Security #AA
            // UserDetails userDetails = _createSymbolicUser();
            // _fillSecurityHeaders();
            try {
                HttpMethod method = HttpMethod.valueOf(methodName);
                // TODO: Security #AA
                // .with(user(userDetails))
                ResultActions result = mockMvc.perform(request(method, path, pathArgs));
                _writeResponse(result.andReturn().getResponse());
                _internalLog("[USVM] end of path analysis", path);
            } catch (Throwable e) {
                writePinnedValue(RESPONSE_EXCEPTION, e);
                _internalLog("[USVM] analysis finished with exception", path);
            } finally {
                PinnedValueStorage.preparePinnedValues();
                _endAnalysis();
            }
            return;
        }
    }

    private void _startAnalysis() { }

    private void _endAnalysis() { }

    public void setListeners(Collection<? extends ApplicationListener<?>> listeners) {
        registerShutdownHook = false;
        listeners.removeIf(it -> it instanceof LoggingApplicationListener);
        this.listeners = new ArrayList<>(listeners);
    }
}
