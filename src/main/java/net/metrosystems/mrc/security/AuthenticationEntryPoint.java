package net.metrosystems.mrc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationEntryPoint.class);
    /**
     * Used to make customizable error messages and codes when login fails
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) {
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        LOG.error("HTTP Status 401 - {}", request.getRequestURI(), authEx);
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName(SecurityConfig.REALM_NAME);
        super.afterPropertiesSet();
    }
}
