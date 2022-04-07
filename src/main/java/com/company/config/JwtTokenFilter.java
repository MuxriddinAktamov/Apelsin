package com.company.config;

import com.company.dto.JwtDTO;
import com.company.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private CustomUserDetailServise customUserDetailServise;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String header = (String) request.getAttribute("Authorizarion");
        final String header = request.getHeader("Authorization");

        if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        final String token = header.split(" ")[1].trim();
        JwtDTO jwtDTO = JwtUtil.decodeJwt(token);

        if (jwtDTO == null) {
            filterChain.doFilter(request, response);
            return;
        }
        String userName = jwtDTO.getSurname();
        UserDetails userDetails = customUserDetailServise.loadUserByUsername(userName);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
