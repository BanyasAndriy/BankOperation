package servlets;

import adoImp.AccountImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;



@WebServlet(name = "addMoneyToCard")
public class AddMoneyServlet extends javax.servlet.http.HttpServlet {

    AccountImpl account = new AccountImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String card = request.getParameter("card");
        double  amount = Double.parseDouble(request.getParameter("amount"));
        String currency = request.getParameter("currency");

        if(card!="" || amount!=0.0 || currency!="") {

            if (account.addMoneyToTheCard(card, currency, amount)) {
                request.setAttribute("s", "Рахунок успішно поповнено");
            } else {
                request.setAttribute("s", "Помилка,попробуйте ще раз");
            }
        }else {
            request.setAttribute("s", "Помилка,попробуйте ще раз");
        }


        RequestDispatcher dispatcher=request.getRequestDispatcher("addMoneyToCard.jsp");
        dispatcher.forward(request,response);

    }

    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {




            RequestDispatcher dispatcher=request.getRequestDispatcher("addMoneyToCard.jsp");
            dispatcher.forward(request,response);




    }




}

