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
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.dr.forms.dto.GenericDtoParamsIN;
import mx.dr.forms.view.utils.DtoConverter;
import mx.dr.ml.service.ICatalogService;
import mx.dr.ml.service.ICompanyService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.dr4zkdemo.view.model.RegisterCompanyContact;
import mx.test.dr4zkdemo.view.model.RegisterCompanyMain;
import mx.test.dr4zkdemo.view.model.SearchCompanyMain;
import mx.test.vo.Category;
import mx.test.vo.Company;
import mx.test.vo.User;
import org.zkoss.zk.ui.Executions;

/**
 * A facade is recommended as necessary pattern to implement since dr4zk will make an instance of this.
 * Company facade 
 * @author jorge
 */
public class CompanyFacade {

	/**
     * @see mx.dr.ml.service.ICompanyService#saveNewCompany(GenericDtoIN)
     */
    public void saveNewCompany(GenericDtoIN dto) throws Exception {
        ICompanyService service = (ICompanyService) WebServiceLocator.getBean(ICompanyService.class, Executions.getCurrent().getDesktop());
        service.saveNewCompany(dto);
    }

    /**
     * @see mx.dr.ml.service.ICompanyService#updateCompany(GenericDtoIN)
     */
    public void updateCompany(GenericDtoIN dto) throws Exception {
        ICompanyService service = (ICompanyService) WebServiceLocator.getBean(ICompanyService.class, Executions.getCurrent().getDesktop());
        service.updateCompany(dto);
    }

    /**
     * @see mx.dr.ml.service.ICompanyService#companyById(GenericDtoOneIN)
     */
    public Company companyById(GenericDtoOneIN dto) throws Exception {
        ICompanyService service = (ICompanyService) WebServiceLocator.getBean(ICompanyService.class, Executions.getCurrent().getDesktop());
        return service.companyById(dto);
    }

    /**
     * @see mx.dr.ml.service.ICompanyService#companyByKey(String)
     */
    public boolean companyByKey(RegisterCompanyContact dto) throws Exception {
    	ICompanyService service = (ICompanyService) WebServiceLocator.getBean(ICompanyService.class, Executions.getCurrent().getDesktop());
    	User result=service.companyByKey(dto.getKey());
    	if(result==null){
    		return true;
    	}
    	if(dto.getId()==null){
    		return false;
    	}
    	if( dto.getId().intValue() != result.getId()){
    		return false;
    	}

    	return true;
    }

    /**
     * get all companies belonging to a category
     * @param dto dr4zk object with the necessary parameters to found the companies
     * @return company list
     * @throws Exception if any
     */
    public List requestByCategory(GenericDtoParamsIN dto) throws Exception{
        Integer id= (Integer)dto.get("id");
        GenericDtoIN mydto=new GenericDtoIN();
        SearchCompanyMain comp= new SearchCompanyMain();
        comp.setCategory(new Category(id));
        mydto.setViewDTO(comp);
        ICatalogService service = (ICatalogService) WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
        return DtoConverter.buildResults(service.findByExampleDTO(mydto), SearchCompanyMain.class);
    }

}
