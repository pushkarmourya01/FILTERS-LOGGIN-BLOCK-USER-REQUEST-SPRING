package com.example.demo.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpRequest;

//yehi se suru hai pahla yehi banaye hai
@Component // lagana hai jisse esko spring ka IOC container handle kre
//abb kaise batayenge ki yeh filter hai uske liye implement filter jakarta.servlet wala
// abb default jo bhi request ayega woh yaha se jayega student controller ke pass

//FILTER LIFECYCLE:- init(), doFilter() , destroy() lekin hum second wala jyada use krenge

public class LoggingFilter implements Filter {
// yeh aya hai implement method se doFilter wala bss
    @Override
    public void doFilter(ServletRequest request, // yeh simple request hai client ka
                         ServletResponse response,//client ko response dengey jo
                         FilterChain chain) //filter ke chain
            throws IOException, ServletException {

        //YEH SAB DUMMY THA ABB REAL WALA ES COMMENT KE NICHE HAI
  //     System.out.println("Request Entered in Filters");
//
//// yaha object unlogo ka call krenge
   //   chain.doFilter(request, response);//yeh filter chain ko call krte rhega next to next that's it yeh jyega toh request client se repository tak
//        //abb wapis client tak response ja rha hai toh call krenge
   //     System.out.println("Request exiting in logging filter");

        //REAL WALA PAHLE TYPE CAST KKRN HAI HTTP MEIN

       HttpServletRequest httpServletRequest = (HttpServletRequest) request;
       HttpServletResponse httpServletResponse= (HttpServletResponse) response;


        System.out.println("Incoming request: "+
                httpServletRequest.getMethod()+ " " // yeh btata hai kis trah ka http request hai get post etc.....
                +httpServletRequest.getRequestURI() ); //yeh bta rha hai ki kis endpoints ko call kiya hai jaise api/students

        chain.doFilter(request, response);// yeh krega filter main toh

        //yeh krega response phale wala request yeh response
        System.out.println("Response status" + httpServletResponse.getStatus());
    }
}
//output
//Incoming request: POST /api/student
//        Student created
//        Pushki
//25
//        Response status200


//abb banega authentication ke liye kaise krenge new pakage
