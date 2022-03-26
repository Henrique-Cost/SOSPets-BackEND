package com.tcc.sospets.services;

import com.tcc.sospets.business.models.Contato;

import java.util.List;

public interface IContatoService {

    List<Contato> getContatos();

    Contato pegaContato(String id_contato);

    void saveContato(Contato contato);

    void atualizaContato(Contato contato, String id_contato);

    void deletaContato(String id_contato);
}
