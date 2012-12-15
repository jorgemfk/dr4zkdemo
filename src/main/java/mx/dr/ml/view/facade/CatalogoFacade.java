/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.view.facade;

import java.util.ArrayList;
import java.util.List;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.test.vo.CatalogStatus;
import mx.dr.ml.service.ICatalogoService;
import mx.dr.ml.service.util.WebServiceLocator;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author jorge
 */
public class CatalogoFacade {
    public void save(GenericDtoIN dto) throws Exception{
        ICatalogoService service = (ICatalogoService) WebServiceLocator.getBean(ICatalogoService.class, Executions.getCurrent().getDesktop());
        service.save(dto);
    }

    public void save(Object o) throws Exception{
        ICatalogoService service = (ICatalogoService) WebServiceLocator.getBean(ICatalogoService.class, Executions.getCurrent().getDesktop());
        service.save(o);
    }
    public Object boById(GenericDtoOneIN dto) throws Exception{
        ICatalogoService service = (ICatalogoService) WebServiceLocator.getBean(ICatalogoService.class, Executions.getCurrent().getDesktop());
        return service.boById(dto);
    }

    public <T extends Object>T  boById(Class clazz, Object id) throws Exception {
        ICatalogoService service = (ICatalogoService) WebServiceLocator.getBean(ICatalogoService.class, Executions.getCurrent().getDesktop());
        return (T)service.boById(clazz, id);
    }
    public List findByExampleDTO(GenericDtoIN  dto) throws Exception{
        ICatalogoService service = (ICatalogoService) WebServiceLocator.getBean(ICatalogoService.class, Executions.getCurrent().getDesktop());
        return service.findByExampleDTO(dto);
    }


    public List getCatalogStatus() throws Exception{
        List l=new  ArrayList() ;
        for(CatalogStatus c: CatalogStatus.values()){
            l.add(c);
        }
        return l;
    }
}
