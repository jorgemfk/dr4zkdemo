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
package mx.dr.ml.service.impl;

import java.util.Calendar;

import javax.annotation.Resource;

import mx.dr.forms.dto.DRMedia;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.dr.forms.view.utils.DRMediaUtils;
import mx.dr.forms.view.utils.DtoConverter;
import mx.dr.ml.dao.GenericDao;
import mx.dr.ml.service.IAttachmentService;
import mx.dr.ml.service.ICompanyService;
import mx.dr.ml.service.IContractService;
import mx.dr.util.DRGeneralUtils;
import mx.test.dr4zkdemo.view.model.EditCompanyMain;
import mx.test.dr4zkdemo.view.model.RegisterCompanyMain;
import mx.test.vo.Attachment;
import mx.test.vo.CatalogStatus;
import mx.test.vo.Company;
import mx.test.vo.User;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * company service implementation
 * @author jorge
 *
 */
@Scope("prototype")
@Service("ICompanyService")
public class CompanyService implements ICompanyService {

	/**
	 * generic dao
	 */
    @Resource(name = "GenericDao")
    private GenericDao dao;
    /**
     * atachment service
     */
    @Resource(name = "IAttachmentService")
    private IAttachmentService adjuntoService;
    /**
     * contract service
     */
    @Resource(name = "IContractService")
    private IContractService contratoService;

 
    /**
     * @see mx.dr.ml.service.ICompanyService#saveNewCompany(GenericDtoIN)
     */
    @Transactional
    public void saveNewCompany(GenericDtoIN dto) throws Exception {
        Company user = (Company) dto.getBos().get(0);

        user.setName(user.getBrand());

        user.setStatus(CatalogStatus.INACTIVE.getId());
        user.setPassword(DRGeneralUtils.stringToMD5(user.getPassword()));
        user.setRegisterDate(Calendar.getInstance().getTime());
        if (dto.getViewDTO() instanceof RegisterCompanyMain) {
            if (!((RegisterCompanyMain) dto.getViewDTO()).getCompany().getMedia().isEmpty()) {
                DRMedia dtoMedia = ((RegisterCompanyMain) dto.getViewDTO()).getCompany().getMedia().get(0);
                Attachment logo = (Attachment) DRMediaUtils.bulidBO(dtoMedia.getMedia(), Attachment.class);
                logo.setIddocument(adjuntoService.saveMedia(dtoMedia.getMedia(), logo));
                user.setLogo(logo);
            }
        }
        dao.save(user);
    }

    /**
     * @see mx.dr.ml.service.ICompanyService#updateCompany(GenericDtoIN)
     */
    @Transactional
    public void updateCompany(GenericDtoIN dto) throws Exception {
        EditCompanyMain view = (EditCompanyMain) dto.getViewDTO();

        Company user = (Company) dao.get(Company.class, view.getContact().getId());
        DtoConverter.buildBO(view, null, user, true);

        if (!view.getCompany().getLogo().isEmpty()) {
            DRMedia dtoMedia = view.getCompany().getLogo().get(0);
            if (dtoMedia.getBo() == null) {
                Attachment logo = (Attachment) DRMediaUtils.bulidBO(dtoMedia.getMedia(), Attachment.class);
                logo.setIddocument(adjuntoService.saveMedia(dtoMedia.getMedia(), logo));
                user.setLogo(logo);
            }
        }

        dao.update(user);
    }

    /**
     * @see mx.dr.ml.service.ICompanyService#companyByKey(String)
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public User companyByKey(String clave) throws Exception {
        User usr = new User();
        usr.setKey(clave);
        return (User) dao.findUniqueByExample(usr);
    }


    /**
     * @see mx.dr.ml.service.ICompanyService#companyById(GenericDtoOneIN)
     */
    @Transactional
    public Company companyById(GenericDtoOneIN dto) throws Exception {
        Integer id = Integer.valueOf((String) dto.getParam());
        System.out.println("byid");
        Company com = (Company) dao.findById(dto.getAclass(), id);
        System.out.println(com);
        return com;
    }

	/**
	 * @return the dao
	 */
	public GenericDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(GenericDao dao) {
		this.dao = dao;
	}

	/**
	 * @return the adjuntoService
	 */
	public IAttachmentService getAdjuntoService() {
		return adjuntoService;
	}

	/**
	 * @param adjuntoService the adjuntoService to set
	 */
	public void setAdjuntoService(IAttachmentService adjuntoService) {
		this.adjuntoService = adjuntoService;
	}

	/**
	 * @return the contratoService
	 */
	public IContractService getContratoService() {
		return contratoService;
	}

	/**
	 * @param contratoService the contratoService to set
	 */
	public void setContratoService(IContractService contratoService) {
		this.contratoService = contratoService;
	}

 
}
