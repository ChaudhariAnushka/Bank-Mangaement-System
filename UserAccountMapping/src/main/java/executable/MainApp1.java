package executable;

import Domain.Account;
import Domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//WRITE A PROGRAM FOR INSERT DATA INTO TABLE
public class MainApp1
{
    public static void main(String[] args) {
        org.hibernate.cfg.Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(User.class);
        cfg=cfg.addAnnotatedClass(Account.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //User Object
        User u1 = new User();
        u1.setUserName("SNEHAL");
        u1.setUserAge(33);
        u1.setUserContact(12333);
        //Account Object
        Account a1 = new Account();
        a1.setAccNo(4567);
        a1.setAccType("SAVINGS");
        Account a2 = new Account();
        a2.setAccNo(891077);
        a2.setAccType("LOAN");
        //ADD ACCOUNTS INTO ACCOUNT lIST
        u1.addAccounts(a1);
        u1.addAccounts(a2);

        tx= ses.beginTransaction();
        ses.save(u1);
        tx.commit();
        System.out.println("DATA INSERTED!!");
    }
}
