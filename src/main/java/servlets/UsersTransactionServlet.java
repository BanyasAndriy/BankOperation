package servlets;

import Entity.Transaction;
import ado.AccountAdo;
import ado.TransactionAdo;
import adoImp.AccountImpl;
import adoImp.TransactionAdoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "transaction")
public class UsersTransactionServlet extends HttpServlet {

    AccountAdo ado = new AccountImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String card = request.getParameter("card");


        TransactionAdo ado = new TransactionAdoImpl();
        List<Transaction> list =  ado.getTransactionsByCard(card);


        request.setAttribute("list",list);


        RequestDispatcher dispatcher = request.getRequestDispatcher("transaction.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        RequestDispatcher dispatcher = request.getRequestDispatcher("transaction.jsp");
        dispatcher.forward(request, response);

    }
}
