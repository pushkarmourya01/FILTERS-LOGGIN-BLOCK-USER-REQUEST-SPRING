package com.example.demo.filters;

// ek special type ke value aayehi token value for authentication

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, // yeh simple request hai client ka
                         ServletResponse response,//client ko response dengey jo
                         FilterChain chain) //filter ke chain
            throws IOException, ServletException {// filter ke chain

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;

        String token = httpServletRequest.getHeader("token");
        //error response
         String apikey = httpServletRequest.getHeader("X-API-KEY");

        if (token == null || !token.equals("12345")) {
            httpServletResponse.setStatus(httpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //yeh servlet wala video ka tha smjhne mein dikkat aa skti hai
        if(apikey==null|| !apikey.equals("Pushkar2425")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write("\n" + //copy and paste in double ""
                    "{\n" +
                    "    \"message\": \"Invalid Request\"\n" +
                    "}"
            );
            return;
        }

        chain.doFilter(request, response);
    }
}
//token and also x-api-key dono dena hoga
// yeh ho gya yeh token value 12345 dalenge postman pr toh hi hoga otherwise no abb krenge request id se fir se jayenge login filter wale mein aur hatayenge ccomponent ko