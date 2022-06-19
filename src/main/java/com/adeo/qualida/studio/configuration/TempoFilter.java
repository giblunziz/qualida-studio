package com.adeo.qualida.studio.configuration;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class TempoFilter implements Filter {
    private static final long T_MIN = 100;
    private static final long T_MAX = 1000;

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        TimeUnit.MILLISECONDS.sleep(new Random().nextLong(T_MAX-T_MIN)+T_MIN);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
