/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service;

import mx.test.vo.Contrato;

/**
 *
 * @author JLMR
 */
public interface IContratoService {
    public Contrato findLastContract(String tipo) throws Exception;
}
