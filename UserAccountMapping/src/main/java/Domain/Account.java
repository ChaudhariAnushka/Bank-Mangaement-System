package Domain;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id")
    private int accId;
    @Column(name = "acc_no")
    private int accNo;
    @Column(name = "acc_type")
    private String accType;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_ref")  //we use joinColum when there foreign key is peresent

    private User userRef;

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public User getUserRef()
    {
        return userRef;
    }

    public void setUserRef(User userRef)
    {
        this.userRef = userRef;
    }
}