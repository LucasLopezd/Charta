package com.wallet.wallet.Security.jwt;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@AllArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) {

        var authorizationHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        String username= null;
        String jwt = null;

        try {

            if(authorizationHeader != null &&  authorizationHeader.startsWith("Bearer")) {
                jwt = authorizationHeader.substring(7);
                username = jwtUtil.extractSubject(jwt);
            }

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                var userDetails  = userDetailsService.loadUserByUsername(username);

                if(jwtUtil.validateToken(jwt, userDetails)) {

                    var  authenticationToken  = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);

        } catch (Exception e) {
            throw new BadCredentialsException(e.getLocalizedMessage());
        }
    }
}
