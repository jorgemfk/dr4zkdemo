package mx.dr.ml.view.facade;

import org.zkoss.zk.ui.Executions;

import mx.dr.forms.dto.GenericDtoOneIN;
import mx.dr.ml.service.ICatalogService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.vo.Contract;

/**
 * A facade is recommended as necessary pattern to implement since dr4zk will make an instance of this.
 * Contract facade 
 * @author jorge
 */
public class ContractFacade {
	/**
	 * get the last contract for a company
	 * @param dto dr4zk object with one parameter to found the contract
	 * @return the contract
	 * @throws Exception
	 */
	public Contract getContractCompany(GenericDtoOneIN dto) throws Exception{
		ICatalogService service =  WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
		Contract srch= new Contract();
		srch.setType((String)dto.getParam());
		return (Contract)service.findByExampleDesc(srch,1,"id").get(0);
	}
}
