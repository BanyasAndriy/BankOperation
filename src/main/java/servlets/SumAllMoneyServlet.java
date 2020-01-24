package servlets;

import ado.AccountAdo;
import adoImp.AccountImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="sumAllMoney")
public class SumAllMoneyServlet extends HttpServlet {

AccountAdo ado = new AccountImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String card = request.getParameter("card");
        double sum = ado.getAllMoneyInUan(card);

        request.setAttribute("sum", sum);




        RequestDispatcher dispatcher = request.getRequestDispatcher("sumAllMoney.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=utf-8");




        RequestDispatcher dispatcher = request.getRequestDispatcher("sumAllMoney.jsp");
        dispatcher.forward(request, response);


    }


}

