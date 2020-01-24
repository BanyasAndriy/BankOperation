package servlets;

import ado.ExchangeRateAdo;
import adoImp.ExchangeRateAdoImpl;
import Entity.ExchangeRate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="/exchangeRateByDate")
public class DateServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("exchangeRateByDate.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=utf-8");

        PrintWriter pw = response.getWriter();
        String date;

        date = request.getParameter("date");


        if (date==null){
            date="15.01.2020";
        }



        ExchangeRateAdo ado = new ExchangeRateAdoImpl();
        ExchangeRate exchangeRate = ado.getRateByDate(date);
        List<ExchangeRate> list = new ArrayList<>();
        list.add(exchangeRate);

        request.setAttribute("list", list);






        RequestDispatcher dispatcher = request.getRequestDispatcher("exchangeRateByDate.jsp");
        dispatcher.forward(request, response);


    }


}

