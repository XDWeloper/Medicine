/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AccessCheckerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;        
        HttpServletResponse res = (HttpServletResponse) response;        
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        
        if((session!=null) && (session.getAttribute("login")!=null)) {
            chain.doFilter(request, response);    
        } else {    
            if(req.getRequestURI().equals(contextPath+"/faces/Pages/loginPage.xhtml") 
                    || req.getRequestURI().equals(contextPath+"/faces/ADMIN.xhtml") ) {                
                chain.doFilter(request, response);            // страницы доступные без авторизации
            } else {    
                res.sendRedirect(contextPath + "/faces/Pages/loginPage.xhtml");    // для остальных редиректим на логин
            }    
        }    
    }

    @Override
    public void destroy() {
        
    }
    
}
