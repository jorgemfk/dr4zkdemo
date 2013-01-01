/*
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
import javax.annotation.Resource;
import mx.dr.ml.dao.GenericDao;
import mx.dr.ml.service.IContractService;
import mx.test.vo.Contract;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author JLMR
 */
@Scope("prototype")
@Service("IContractService")
public class ContractService implements IContractService{
    @Resource(name = "GenericDao")
    private GenericDao dao;

    @Transactional
    public Contract findLastContract(String tipo) throws Exception{
        Contract srch= new Contract();
        srch.setType(tipo);
        return (Contract) dao.findByExampleDesc(srch, 1, "id").get(0);
    }

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }

}
