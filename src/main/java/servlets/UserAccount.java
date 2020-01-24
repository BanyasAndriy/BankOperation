package servlets;

import ado.ExchangeRateAdo;
import adoImp.ExchangeRateAdoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="/avg")
public class AvgServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("avgData.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=utf-8");

        PrintWriter pw = response.getWriter();
        String startDate="19.01.2019";
        String endDate = "18.01.2020";
        startDate = request.getParameter("startDate");
        endDate = request.getParameter("endDate");

        if (startDate==null){
            startDate="19.01.2019";
        }
        if (endDate==null){
            endDate="18.01.2020";
        }



        double avg=0.0;
ExchangeRateAdo ado= new ExchangeRateAdoImpl();
       //  avg = ado.avgExchangeRate(startDate,endDate);


        request.setAttribute("avg", avg);






        RequestDispatcher dispatcher = request.getRequestDispatcher("avgData.jsp");
        dispatcher.forward(request, response);


    }


}

