/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.ceunes.poo.model.dao;

/**
 *
 * @author Diego
 */
// verifica as respectivas funções e retorna true ou false para ser valido.
public interface VerificacaoDao {
    public boolean isValidCpf(String cpf);
    public boolean verificaData(String Data);
    // Remove os caracteres invalidos para que seja reconhecido o cpf
    public String removeInvalidsCharacters(String cpf);
    public boolean isValidSize(String cpf);
    public boolean isValidDigits(String cpf);
    public String calculoComCpf(String cpf);
    
    
}
