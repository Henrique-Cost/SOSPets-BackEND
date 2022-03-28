package com.tcc.sospets.services;

import com.tcc.sospets.business.models.Contato;
import com.tcc.sospets.business.models.Usuario;
import com.tcc.sospets.business.repositories.IContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContatoService implements  IContatoService{

    @Autowired
    IContatoRepositorio contatoRepositorio;

    @Override
    public List<Contato> getContato() {return contatoRepositorio.findAll();
    }

    @Override
    public Contato pegaContato(String id_contato) {
        Contato contato = contatoRepositorio.findById(id_contato).orElse(null);
        return contato;
    }

    @Override
    public void saveContato(Contato contato) { contatoRepositorio.save(contato);}

    @Override
    public void atualizaContato(Contato contato, String id_contato) {
        Contato contatoAnterior = contatoRepositorio.findById(id_contato).orElse(null);
        contatoAnterior.setTelefone(contato.getTelefone());
        contatoRepositorio.save(contatoAnterior);
    }

    @Override
    public void deletaContato(Contato id_contato) {
        contatoRepositorio.deleteById(String.valueOf(id_contato));
    }
}
