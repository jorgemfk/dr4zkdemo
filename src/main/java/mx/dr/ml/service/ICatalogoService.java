/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service;

import java.util.List;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;

/**
 *
 * @author JLMR
 */
public interface ICatalogoService {
    public void save(GenericDtoIN dto) throws Exception;
    public void save(Object o) throws Exception;
    public Object boById(GenericDtoOneIN dto) throws Exception;
    public Object boById(Class clazz, Object id) throws Exception;
    public List findByExampleDTO(GenericDtoIN  dto) throws Exception;
  
}
