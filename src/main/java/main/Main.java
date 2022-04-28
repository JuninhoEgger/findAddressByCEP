package main;

import address.Address;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static service.CepService.findAddressByCep;

public class Main {
    public static void main(String[] args) throws Exception {

        String cep = showInputDialog("Informe seu CEP");
        Address address = findAddressByCep(cep);

        showMessageDialog(
                null,
                "LOGRADOURO: " + address.getLogradouro() + "\n" +
                        "BAIRRO: " + address.getBairro() + "\n" +
                        "LOCALIDADE: " + address.getLocalidade());

    }
}
