/*
*
*
* Copyright (C) 2012 Jorge Luis Martinez Ramirez
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
* Author: Jorge Luis Martinez Ramirez
* Email: jorgemfk1@gmail.com
*/
package mx.dr.ml.view.facade;

import java.util.ArrayList;
import java.util.List;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.test.vo.CatalogStatus;
import mx.dr.ml.service.ICatalogService;
import mx.dr.ml.service.util.WebServiceLocator;
import org.zkoss.zk.ui.Executions;

/**
 * A facade is recommended as necessary pattern to implement since dr4zk will make an instance of this.
 * Catalog facade 
 * @author jorge
 */
public class CatalogFacade {
	/**
     * @see mx.dr.ml.service.ICatalogService#save(GenericDtoIN)
     */
    public void save(GenericDtoIN dto) throws Exception{
        ICatalogService service = (ICatalogService) WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
        service.save(dto);
    }

    /**
     * @see mx.dr.ml.service.ICatalogService#save(Object)
     */
    public void save(Object o) throws Exception{
        ICatalogService service = (ICatalogService) WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
        service.save(o);
    }
    
    /**
     * @see mx.dr.ml.service.ICatalogService#boById(GenericDtoOneIN)
     */
    public Object boById(GenericDtoOneIN dto) throws Exception{
        ICatalogService service = (ICatalogService) WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
        return service.boById(dto);
    }

    /**
     * @see mx.dr.ml.service.ICatalogService#boById(Class, Object)
     */
    public <T extends Object>T  boById(Class clazz, Object id) throws Exception {
        ICatalogService service = (ICatalogService) WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
        return (T)service.boById(clazz, id);
    }
    
    /**
     * @see mx.dr.ml.service.ICatalogService#findByExampleDTO(GenericDtoIN)
     */
    public List findByExampleDTO(GenericDtoIN  dto) throws Exception{
    	System.out.println("fac: "+ dto.getViewDTO());   	
        ICatalogService service = (ICatalogService) WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
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
