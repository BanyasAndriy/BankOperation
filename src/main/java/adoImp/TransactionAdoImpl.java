package adoImp;

import Entity.Transaction;
import ado.TransactionAdo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TransactionAdoImpl implements TransactionAdo {
   private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
   private EntityManager entityManager = emf.createEntityManager();
   private EntityTransaction tr = entityManager.getTransaction();


    @Override
    public List<Transaction> getTransactionsByCard(String card) {



      List<Transaction> list ;

      try {
          tr.begin();


          list=entityManager.createQuery("Select t From Transaction t where t.from='"+card+"'"+" OR t.to= '"+card+"'").getResultList();


          tr.commit();

      }finally {
          if (emf!=null)
          emf.close();
          if (entityManager!=null)
              entityManager.close();
      }

        return list;
    }
}
