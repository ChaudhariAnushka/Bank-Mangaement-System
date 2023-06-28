package executable;

import Domain.Account;
import Domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;
//WRITE PROGRAM TO DELETE ACCOUNT OF GIVEN ACCOUNT ID
//If we delete Account only Account will deleted USER are remains Same(User not deleted)
public class MainApp7
{
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(User.class);
        cfg=cfg.addAnnotatedClass(Account.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER ACCOUNT ID");
        int id = sc.nextInt();

        Account a1 = ses.get(Account.class,id);
        if (a1!=null)
        {
            tx = ses.beginTransaction();
            ses.delete(a1);
            tx.commit();
            System.out.println("ACCOUNT DELETED!!");
        }
        else
        {
            System.out.println("INVALID ACCOUNT ID");
        }


    }
}
