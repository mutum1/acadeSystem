/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Diego
 */
public interface Cpf {
    
    public boolean isValidCpf(String cpf);
    public String removeInvalidsCharacters(String cpf);
    public boolean isValidSize(String cpf);
    public boolean isValidDigits(String cpf);
    public String calculoComCpf(String cpf);

    
    
}
