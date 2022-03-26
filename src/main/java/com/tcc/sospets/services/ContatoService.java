package com.tcc.sospets.services;

import com.tcc.sospets.business.models.Contato;
import com.tcc.sospets.business.models.Usuario;
import com.tcc.sospets.business.repositories.IContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService implements  IContatoService{

    @Autowired
    IContatoRepositorio contatoRepositorio;

    @Override
    public List<Contato> getContatos() {return contatoRepositorio.findAll();
    }

    @Override
    public Contato pegaContato(String id_contato) {
        Contato contato = contatoRepositorio.findById(id_contato).orElse(null);
        return contato;
    }

    @Override
    public void saveContato(Contato contato) {
        contatoRepositorio.save(contato);
    }

    @Override
    public void atualizaContato(Contato contato, String id_contato) {
        Contato contatoAnterior = contatoRepositorio.findById(id_contato).orElse(null);
        contatoAnterior.setId_contato(contato.getId_usuario());
        contatoRepositorio.save(contatoAnterior);
    }

    @Override
    public void deletaContato(String id_contato) {
        contatoRepositorio.deleteById(id_contato);
    }
}
