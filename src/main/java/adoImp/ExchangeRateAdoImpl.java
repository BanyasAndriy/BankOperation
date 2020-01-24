package adoImp;

import Entity.ExchangeRate;
import ado.ExchangeRateAdo;
import utils.JsonReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExchangeRateAdoImpl implements ExchangeRateAdo {

   private JsonReader js = new JsonReader();
    public ExchangeRateAdoImpl() {


    }


    @Override
    public ExchangeRate getRateByDate(String data) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
        EntityManager entityManager = emf.createEntityManager();

        ExchangeRate ex = new ExchangeRate();
try {


    ex = (ExchangeRate) entityManager.createQuery("Select e From ExchangeRate e where e.date='" + data + "'").getSingleResult();

}finally {
    if(entityManager!=null)
        entityManager.close();
    if(emf!=null)
        emf.close();
}
        return ex;

    }



    @Override
    public ExchangeRate getAllDate() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
        EntityManager entityManager = emf.createEntityManager();
        ExchangeRate res ;
        try {
              res = (ExchangeRate) entityManager.createQuery("Select e From ExchangeRate e order by e.idRate asc ").getSingleResult();
        }finally {

            if(entityManager!=null)
                entityManager.close();
            if(emf!=null)
                emf.close();

        }
        return res;
    }

    @Override
    public boolean updateData() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
       EntityManager entity = emf.createEntityManager();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
                Date date = new Date();
        String dateNow = sdf.format(date);


            ExchangeRate exchangeRate = null;
            try {
                exchangeRate = js.parseJson(dateNow);

            } catch (IOException e) {
                e.printStackTrace();
            }

            EntityTransaction tr = entity.getTransaction();

            try {

                    tr.begin();
                    entity.createQuery("Delete from ExchangeRate e ").executeUpdate();
                    tr.commit();
                    tr.begin();
                    entity.merge(exchangeRate);
                    tr.commit();

            } catch (Exception ex) {
                tr.rollback();
                System.out.println(ex.getCause());
                return false;
            }

            return true;
        }


    }





