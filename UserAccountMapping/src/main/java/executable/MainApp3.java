package executable;

import Domain.Account;
import Domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.Scanner;
//WRITE PROGRAM TO DISPLAY USER AND ACCOUNT INFO OF GIVEN ID
public class MainApp3
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
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER USER ID: ");
        int id = sc.nextInt();

        User obj = ses.get(User.class,id);
        System.out.println("USERNAME:"+obj.getUserName());
        System.out.println("-----------------------------");
        List<Account> data = obj.getAccountList();
        for (Account a: data)
        {
            System.out.println("ACCOUNT NO: "+a.getAccNo());
            System.out.println("ACCOUNT TYPE: :"+a.getAccType());
            System.out.println("==========================================");
        }
    }
}
