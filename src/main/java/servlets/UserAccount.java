package servlets;

import Entity.Account;
import Entity.User;
import ado.AccountAdo;
import ado.UserAdo;
import adoImp.AccountImpl;
import adoImp.UserImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="addUserAccount")
public class UserAccount extends HttpServlet {
    AccountAdo adoAc = new AccountImpl();
    UserAdo adoUs = new UserImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addAccount.jsp");
        dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=utf-8");

        PrintWriter pw = response.getWriter();

      String pib = request.getParameter("pib");
      String phone = request.getParameter("phone");
      String mail = request.getParameter("mail");
      String card = request.getParameter("card");

      String s="";

        if(pib!="" || phone!="" || mail!="" || card!="") {
            Account account = new Account(card, 0, 0, 0);
            User user = new User(pib, phone, mail, account);

            adoAc.addAccount(account);
            adoUs.addUser(user);
            s="Користувач доданий";
request.setAttribute("s",s);

        }else {
            s="Ви ввели не всі дані!!!Попробуйте ще раз!!!";
            request.setAttribute("s",s);
        }




        RequestDispatcher dispatcher = request.getRequestDispatcher("addAccount.jsp");
        dispatcher.forward(request, response);


    }


}

