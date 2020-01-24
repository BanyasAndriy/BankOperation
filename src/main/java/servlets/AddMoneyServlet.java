package servlets;

import ado.ExchangeRateAdo;
import adoImp.ExchangeRateAdoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "/table")
public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");

            ExchangeRateAdo ado = new ExchangeRateAdoImpl();





            RequestDispatcher dispatcher=request.getRequestDispatcher("exchangeData.jsp");
            dispatcher.forward(request,response);




    }




}

