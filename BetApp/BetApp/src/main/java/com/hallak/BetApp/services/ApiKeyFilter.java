package com.hallak.BetApp.services;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY_HEADER = "X-API-KEY";
    private static final String EXPECTED_API_KEY = "settlementapp-secret-key";

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        String method = request.getMethod();

        if ("GET".equalsIgnoreCase(method) && path.matches("^/\\d+$")) {
            return false;
        }

        return true;
    }


    /*@Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        String method = request.getMethod();

        // APLICA o filtro se for GET e o path for apenas "/" ou "/{id}" (ex: /123)
        if ("GET".equalsIgnoreCase(method) && (path.equals("/") || path.matches("^/\\d+$"))) {
            return false; // aplica o filtro
        }

        return true; // ignora o filtro
    } */

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String apiKey = request.getHeader(API_KEY_HEADER);

        if (EXPECTED_API_KEY.equals(apiKey)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("API Key missing or invalid");
        }
    }
}

