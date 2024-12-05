package testback.com.testback.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// import jakarta.persistence.Entity;
@Entity
@Table(name = "transaction")
public class Transaction {
    // id,description,amount,date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date date;

    // getters 
    public long getId() {
        return id;
        }
    public String getDescription() {
        return description;
        }
    public double getAmount() {
        return amount;
        }
    public Date getDate() {
        return date;
    }
    public String getType() {
        return type;
    }
    // setters  
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setType(String type) {
        this.type = type;
    }
}


