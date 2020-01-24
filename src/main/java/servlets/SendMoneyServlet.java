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

@WebServlet(name ="sendMoneyToAnotherCard")
public class SendMoneyServlet extends HttpServlet {

AccountAdo ado = new AccountImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("sendMoney.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=utf-8");

 String yourCard = request.getParameter("yourCard");
 String anotherCard=request.getParameter("anotherCard");
 double amount =Double.parseDouble( request.getParameter("amount"));
 String currency = request.getParameter("currency");

if (ado.sendMoneyToAnotherCard(yourCard,anotherCard,currency,amount)){
    request.setAttribute("s","Операція пройшла успішно!!!");
}else {
    request.setAttribute("s","Помилка при виконанні операці!!!Повторіть операцію!!!");

}



        RequestDispatcher dispatcher = request.getRequestDispatcher("sendMoney.jsp");
        dispatcher.forward(request, response);


    }


}

