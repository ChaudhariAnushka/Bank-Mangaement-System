package executable;

import Domain.Account;
import Domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//WRITE PROGRAM TO INSERT NEW ACCOUNT OF EXISTING(OLD) USER
public class MainApp2
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

        //OLD USER WITH NEW ACCOUNT
        User s1= ses.get(User.class,1);

        Account a1 = new Account();
        a1.setAccNo(665566);
        a1.setAccType("LOAN");

        s1.addAccounts(a1);
        tx = ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("RECORD INSERTED!");

    }
}
