package com.example.demo.filters;


import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//yehi se suru hai pahla yehi banaye hai
@Component // lagana hai jisse esko spring ka IOC container handle kre
//abb kaise batayenge ki yeh filter hai uske liye implement filter jakarta.servlet wala
// abb default jo bhi request ayega woh yaha se jayega student controller ke pass

//FILTER LIFECYCLE:- init(), doFilter() , destroy() lekin hum second wala jyada use krenge

public class LoggingFilter implements Filter {
// yeh aya hai implement method se doFilter wala bss
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

    }
}
