/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service;

import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.test.vo.Empresa;
import mx.test.vo.Usuario;

/**
 *
 * @author JLMR
 */
public interface IUsuarioService {


        public Usuario usuarioByClave(String clave) throws Exception;
        public void saveNewEmpresa(GenericDtoIN dto) throws Exception;
        public void updateEmpresa(GenericDtoIN dto) throws Exception;
        public Empresa empresaById(GenericDtoOneIN dto) throws Exception;
}
