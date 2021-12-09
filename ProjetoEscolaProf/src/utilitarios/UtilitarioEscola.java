/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import modelos.entidades.Escola;

/**
 *
 * @author M
 */
public class UtilitarioEscola {

    public static boolean getCheckDados(Escola objeto) {

        if (!"".equals(objeto.getNome())
                && !"".equals(objeto.getTelefone())
                && !"(##) #####-####".equals(objeto.getTelefone())
                && !"".equals(objeto.getEmail())
                && !"".equals(objeto.getEndereco())) {
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", null, WIDTH);
            return false;
        }
        return true;
    }

}
