package com.testepic.services;

import com.testepic.DTO.TransactionDTO;
import com.testepic.Entity.Usuario;
import com.testepic.repositorios.TransactionRepository;
import com.testepic.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    public Transaction criaTransacao( TransactionDTO transactionDTO) throws Exception{
        if (transactionDTO.senderId() == null || transactionDTO.receiverId() == null) {
            throw new Exception("Sender ID and Receiver ID must not be null");
        }

        Usuario sender = this.usuarioService.findUsuarioById(transactionDTO.senderId());
        Usuario receiver = this.usuarioService.findUsuarioById(transactionDTO.receiverId());

        if (sender == null || receiver == null) {
            throw new Exception("Sender or Receiver not found");
        }

        usuarioService.validarTransacao(sender, transactionDTO.total());

        Transaction newTransaction = new Transaction();
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTotal(transactionDTO.total());

        sender.setSaldo(sender.getSaldo().subtract(transactionDTO.total()));
        receiver.setSaldo(receiver.getSaldo().add(transactionDTO.total()));

        this.repository.save(newTransaction);
        this.usuarioService.saveUsuario(sender);
        this.usuarioService.saveUsuario(receiver);
        return newTransaction;
    }
}