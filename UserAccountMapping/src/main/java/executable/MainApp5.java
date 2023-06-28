package executable;

import Domain.Account;
import Domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
//WRITE PROGRAM TO DISPLAY USERNAME ACCOUNT NO , ACCOUNT TYPE WHOSE ACCOUNTS ARE GREATER THAN 2
public class MainApp5
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

        Criteria crt = ses.createCriteria(User.class);
        List<User> userList = crt.list();
        for (User u1 : userList)    //for getting username
        {
            System.out.println("USERNAME: " + u1.getUserName());
            System.out.println("----------------------------");
            List<Account> accountList = u1.getAccountList();  //Accounts are multiple so we use List of Account Class to store account info
            if (accountList.size() > 2)
            {
                System.out.println("USERNAME: " + u1.getUserName());
                for (Account a1 : accountList)   //for getting accounts info
                {

                    System.out.println("ACCOUNT NO: " + a1.getAccNo());
                    System.out.println("ACCOUNT TYPE: " + a1.getAccType());


                }

                System.out.println("==========================================");
            }
        }
    }
}
