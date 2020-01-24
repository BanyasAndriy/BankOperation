package servlets;

import adoImp.AccountImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(name = "convertMoney")
public class ConvertMoneyServlet extends javax.servlet.http.HttpServlet {

    AccountImpl account = new AccountImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");

       String card = request.getParameter("card");
       double  amount = Double.parseDouble(request.getParameter("amount"));
       String from = request.getParameter("from");
       String to = request.getParameter("to");

       if(account.isEnoughMoneyToSend(card,amount,from)) {



        if(  account.convertCurrency(from, to, amount, card)){
            request.setAttribute("s","Конвертація валюти пройшла успішно!!");
        }else{
            request.setAttribute("s","Помилка при конвертації валюти,попробуйте ще раз!!");

        }


       }else {
           RequestDispatcher dispatcher=request.getRequestDispatcher("convertMoney.jsp");
           dispatcher.forward(request,response);
       }


            RequestDispatcher dispatcher=request.getRequestDispatcher("convertMoney.jsp");
            dispatcher.forward(request,response);




    }




}

