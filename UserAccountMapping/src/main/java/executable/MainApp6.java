package executable;

import Domain.Account;
import Domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;
//WRITE PROGRAM TO DISPLAY USERNAME ACCOUNT NO , ACCOUNT TYPE WHOSE AGE IS GREATER THAN 30
public class MainApp6
{
    public static void main(String[] args)
    {
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
        crt.add(Restrictions.gt("userAge",30));
        List<User> userList = crt.list();

        for (User u1 : userList)    //for getting username
        {

            List<Account> accountList = u1.getAccountList();  //Accounts are multiple so we use List of Account Class to store account info

                System.out.println("USERNAME: " + u1.getUserName());
            System.out.println("----------------");
                for (Account a1 : accountList)   //for getting accounts info
                {

                    System.out.println("ACCOUNT NO: " + a1.getAccNo());
                    System.out.println("ACCOUNT TYPE: " + a1.getAccType());

                    System.out.println("-----------------------------");
                }

                System.out.println("==========================================");
            }
        }

    }

