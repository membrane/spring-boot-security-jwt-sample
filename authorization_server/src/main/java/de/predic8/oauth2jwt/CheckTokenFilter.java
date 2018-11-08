package de.predic8.oauth2jwt;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

@Component
@Order(1)
public class CheckTokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // make "typical" userinfo endpoint calls work with check_token endpoint
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (!req.getRequestURI().equals("/oauth/check_token")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        req.getRequestDispatcher(appendTokenToUri(req)).forward(servletRequest, servletResponse);
    }

    private String appendTokenToUri(HttpServletRequest req) {
        return req.getRequestURI() + getTokenQuery(req);
    }

    private String getTokenQuery(HttpServletRequest req) {
        return "?token=" + getOAuth2TokenFromHeader(req);
    }

    private String getOAuth2TokenFromHeader(HttpServletRequest req) {
        return req.getHeader("Authorization").split(Pattern.quote(" "))[1];
    }
}
