package com.testepic.transaction;

import com.testepic.Entity.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "sender_Id")
    private Usuario sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Usuario receiver;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Usuario getSender() {
        return sender;
    }

    public void setSender(Usuario sender) {
        this.sender = sender;
    }

    public Usuario getReceiver() {
        return receiver;
    }

    public void setReceiver(Usuario receiver) {
        this.receiver = receiver;
    }
}
