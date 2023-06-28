package Domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age")
    private int userAge;
    @Column(name="user_contact")
    private int userContact;

    @OneToMany(mappedBy = "userRef", cascade = CascadeType.ALL)
    private List<Account> accountList;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserContact() {
        return userContact;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void setUserContact(int userContact) {
        this.userContact = userContact;
    }

    public void addAccounts(Account accountRef)
    {
        if (accountList== null)
        {
            accountList = new LinkedList<>();
        }
        accountList.add(accountRef);
        accountRef.setUserRef(this);
    }
}
