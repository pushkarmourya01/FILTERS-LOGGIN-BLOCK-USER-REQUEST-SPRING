package com.example.demo.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.UUID;

//yehi se suru hai pahla yehi banaye hai
@Component // lagana hai jisse esko spring ka IOC container handle kre
@Order(2)
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

        //last mein time wala hai video ka
        long startTime = System.currentTimeMillis(); // yaha se lega and niche khi complete end of time after compleete request

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


// yeh wala 3rd process kr rhe hai End of the Video ka hai
        String requestId = UUID.randomUUID().toString();//yeh random id generate krega done
        // aur yeh detail user ko wapise se bejega
        httpServletResponse.setHeader("X-Request-ID", requestId);//gp postman and check the body in output last mein hai request timing



        System.out.println("Incoming request: "+
                httpServletRequest.getMethod()+ " " // yeh btata hai kis trah ka http request hai get post etc.....
                +httpServletRequest.getRequestURI() ); //yeh bta rha hai ki kis endpoints ko call kiya hai jaise api/students

      // eski jagah hum try ctach use krenge   chain.doFilter(request, response);// yeh krega filter main toh

        try {
            chain.doFilter(request, response);
        }
      finally {
            // yeh tak ayega toh timing wapis
            long duration = System.currentTimeMillis()- startTime;

            //yeh krega response phale wala request yeh response
            System.out.println("Response status" + httpServletResponse.getStatus());
            System.out.println("API Response Time"+ duration);
        }
    }
//output
//Incoming request: POST /api/student
//        Student created
//        Pushki
//25
//        Response status200


//abb banega authentication ke liye kaise krenge new pakage


}





