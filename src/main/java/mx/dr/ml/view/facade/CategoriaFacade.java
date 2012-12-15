/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.view.facade;

import java.util.List;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.ml.service.ICatalogoService;
import mx.dr.ml.service.ICategoriaService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.dr4zkdemo.view.model.RegisterCategoria;
import mx.test.vo.Categoria;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author JLMR
 */
public class CategoriaFacade {
    public List findActive() throws Exception{
        ICategoriaService service = (ICategoriaService) WebServiceLocator.getBean(ICategoriaService.class, Executions.getCurrent().getDesktop());
        return service.findActive();
    }

    public List findAll() throws Exception{
        ICategoriaService service = (ICategoriaService) WebServiceLocator.getBean(ICategoriaService.class, Executions.getCurrent().getDesktop());
        return service.findAll();
    }

    public List findCategoriasPadre() throws Exception{
        ICategoriaService service = (ICategoriaService) WebServiceLocator.getBean(ICategoriaService.class, Executions.getCurrent().getDesktop());
        return service.findCategoriasPadre();
    }

    
    public Categoria save(String value) throws Exception{
        ICategoriaService service = (ICategoriaService) WebServiceLocator.getBean(ICategoriaService.class, Executions.getCurrent().getDesktop());
        return service.save(value);
    }
    
    public boolean validaXNombre(String nombre) throws Exception{
        GenericDtoIN  dto= new GenericDtoIN();
        RegisterCategoria vdto=new RegisterCategoria();
        System.out.println(nombre);
        vdto.setNombre(nombre);
        dto.setViewDTO(vdto);
        ICatalogoService service = (ICatalogoService) WebServiceLocator.getBean(ICatalogoService.class, Executions.getCurrent().getDesktop());
        return service.findByExampleDTO(dto).isEmpty();
    }
}
