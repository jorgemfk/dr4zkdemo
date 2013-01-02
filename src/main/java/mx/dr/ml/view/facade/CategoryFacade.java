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

import java.util.List;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.ml.service.ICatalogService;
import mx.dr.ml.service.ICategoryService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.dr4zkdemo.view.model.RegisterCategory;
import mx.test.vo.Category;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author JLMR
 */
public class CategoryFacade {
    public List findActive() throws Exception{
        ICategoryService service = (ICategoryService) WebServiceLocator.getBean(ICategoryService.class, Executions.getCurrent().getDesktop());
        return service.findActive();
    }

    public List findAll() throws Exception{
        ICategoryService service = (ICategoryService) WebServiceLocator.getBean(ICategoryService.class, Executions.getCurrent().getDesktop());
        return service.findAll();
    }

    public List findMainCategory() throws Exception{
        ICategoryService service = (ICategoryService) WebServiceLocator.getBean(ICategoryService.class, Executions.getCurrent().getDesktop());
        return service.findMainCategory();
    }

    
    public Category save(String value) throws Exception{
        ICategoryService service = (ICategoryService) WebServiceLocator.getBean(ICategoryService.class, Executions.getCurrent().getDesktop());
        return service.save(value);
    }
    
    public boolean validateXName(RegisterCategory value) throws Exception{
        ICatalogService service = (ICatalogService) WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
        List<Category> result=service.find(Category.class, "name", value.getName());
        if(result.isEmpty()){
        	return true;
        }
        if(value.getId()==null){
        	return false;
        }
        for(Category cat: result){
        	if( value.getId().intValue() != cat.getId()){
        		return false;
        	}
        }
        return true;
    }
}
