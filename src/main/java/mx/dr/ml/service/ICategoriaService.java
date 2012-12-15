/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service;

import java.util.List;
import mx.test.vo.Categoria;

/**
 *
 * @author JLMR
 */
public interface ICategoriaService {
    public List findActive() throws Exception;
    public List findAll() throws Exception;
    public List findCategoriasPadre() throws Exception;
    public Categoria save(String value) throws Exception;
}
