package adoImp;

import Entity.User;
import ado.UserAdo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserImpl implements UserAdo {


    private EntityManagerFactory enf = Persistence.createEntityManagerFactory("bank");
    private EntityManager en = enf.createEntityManager();
    private EntityTransaction tr = en.getTransaction();


    @Override
    public void addUser(User user) {

       try{
        tr.begin();
        en.persist(user);
        tr.commit();
       }catch (Exception e){
           e.getStackTrace();
           tr.rollback();

       }finally {
           if (enf!=null)
               enf.close();
           if(en!=null)
               en.close();
       }
    }
}
