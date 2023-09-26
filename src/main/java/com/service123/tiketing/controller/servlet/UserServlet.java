package com.service123.tiketing.controller.servlet;

import com.service123.tiketing.model.entity.User;
import com.service123.tiketing.model.entity.enums.ActionType;
import com.service123.tiketing.model.entity.enums.UserRoles;
import com.service123.tiketing.model.repository.LogDa;
import com.service123.tiketing.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user.do")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            request.getSession().setAttribute("userList",UserService.getService().findAll());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
            response.sendRedirect("/userindex.jsp");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ActionType action=null;
       String data=null;
        UserRoles userRoles;
        try {
            data= UserService.getService().save(User
                    .builder()
//                    .id()
                    .userRoles(UserRoles.valueOf(request.getParameter("userRoles")))
                    .name(request.getParameter("name"))
                    .family(request.getParameter("family"))
                    .userName(request.getParameter("username"))
                    .description(request.getParameter("description"))
                    .deleted(false)
                    .build()
            ).toString();
            action= ActionType.SAVE;
        }catch (Exception e){
            data=e.getMessage();
            action=ActionType.ERROR;
        }finally {
            try {LogDa.log(action,data,1);}catch (Exception e){
                System.out.println("ERROR CONNECTING LOG SERVER");
            }
        }
        response.sendRedirect("/userindex.jsp");
    }//:SAVE METHOD;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);//edit;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);//remove;
    }
}