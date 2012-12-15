/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service;

import java.util.List;
import mx.test.vo.Estado;

/**
 *
 * @author JLMR
 */
public interface IEstadoService {
    public List<Estado> findMXEstados() throws Exception;
}
