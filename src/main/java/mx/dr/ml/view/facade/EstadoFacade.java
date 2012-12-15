/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.view.facade;

import java.util.List;
import mx.dr.forms.dto.GenericDtoParamsIN;
import mx.dr.forms.view.component.DRListBox;
import mx.dr.ml.service.IEstadoService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.vo.Estado;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author JLMR
 */
public class EstadoFacade  {

    public List<Estado> findMXEstados() throws Exception {
        Desktop desk = Executions.getCurrent().getDesktop();
        IEstadoService service = (IEstadoService) WebServiceLocator.getBean(IEstadoService.class, desk);
        return service.findMXEstados();
    }

}
