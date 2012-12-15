/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dr.ml.view.facade;

import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.dr.ml.service.IUsuarioService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.vo.Empresa;
import mx.test.vo.Usuario;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author JLMR
 */
public class UsuarioFacade {



    public void saveNewEmpresa(GenericDtoIN dto) throws Exception {
        IUsuarioService service = (IUsuarioService) WebServiceLocator.getBean(IUsuarioService.class, Executions.getCurrent().getDesktop());
        service.saveNewEmpresa(dto);
    }


    public void updateEmpresa(GenericDtoIN dto) throws Exception {
        IUsuarioService service = (IUsuarioService) WebServiceLocator.getBean(IUsuarioService.class, Executions.getCurrent().getDesktop());
        service.updateEmpresa(dto);
    }

    public Empresa empresaById(GenericDtoOneIN dto) throws Exception {
        IUsuarioService service = (IUsuarioService) WebServiceLocator.getBean(IUsuarioService.class, Executions.getCurrent().getDesktop());
        return service.empresaById(dto);
    }


    public boolean usuarioByClave(String clave) throws Exception {
        IUsuarioService service = (IUsuarioService) WebServiceLocator.getBean(IUsuarioService.class, Executions.getCurrent().getDesktop());
        return service.usuarioByClave(clave)==null;
    }

}
