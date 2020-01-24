package ado;

import Entity.ExchangeRate;
import utils.JsonReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExchangeRateAdoImpl implements  ExchangeRateAdo {

   private JsonReader js = new JsonReader();
    public ExchangeRateAdoImpl() {


    }

    @Override
    public boolean addDataToBD(List<ExchangeRate> list) {

       EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
       EntityManager entityManager = emf.createEntityManager();
       EntityTransaction tr = entityManager.getTransaction();


        try {


            for (int i = 0; i < list.size(); i++) {
                tr.begin();
                entityManager.persist(list.get(i));

                tr.commit();
            }
        }catch (Exception ex ){
            tr.rollback();
            System.out.println(ex.getCause());
            return false;
        }finally {
            if(entityManager!=null)
                entityManager.close();
            if(emf!=null)
                emf.close();
        }
        return true;
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
    public List<ExchangeRate> getAllDate() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
        EntityManager entityManager = emf.createEntityManager();
        List<ExchangeRate> res = new ArrayList<>();
        try {
              res = entityManager.createQuery("Select e From ExchangeRate e order by e.idRate asc ").getResultList();
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
        List<ExchangeRate> oldList = getAllDate();
        String lastDate = oldList.get(oldList.size()-1).getDate();
        System.out.println(lastDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.YYYY");
                Date date = new Date();
        String dateNow = sdf.format(date);

        if (lastDate.equals(dateNow)){
            return true;
        }else {
            List<ExchangeRate> list = null;
            try {
                list = js.parseJson(lastDate);

            } catch (IOException e) {
                e.printStackTrace();
            }

            EntityTransaction tr = entity.getTransaction();

            try {
                for (int i = 0; i < list.size(); i++) {
                    tr.begin();
                    entity.merge(list.get(i));

                    tr.commit();
                }
            } catch (Exception ex) {
                tr.rollback();
                System.out.println(ex.getCause());
                return false;
            }

            return true;
        }


    }

    @Override
    public double avgExchangeRate(String startDate, String endDate) {

        List<ExchangeRate> allData = getAllDate();

        int idStartDate=0;
        int idEndDate=0;

            for (int i = 0 ;i< allData.size();i++){
               if (allData.get(i).getDate().equals(startDate.trim())){
                   idStartDate=i;
            }
               if (allData.get(i).getDate().equals(endDate.trim())){
                   idEndDate=i;
               }
        }

            int count=0;
            double sum = 0;
            double avg;
        for (int i=idStartDate ; i<idEndDate; i++){

            sum = sum+ allData.get(i).getPurchaseRate();

        ++count;
        }

        avg=sum/count;

        return avg;
    }


}
