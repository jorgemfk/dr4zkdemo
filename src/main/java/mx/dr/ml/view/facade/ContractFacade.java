package mx.dr.ml.view.facade;

import org.zkoss.zk.ui.Executions;

import mx.dr.forms.dto.GenericDtoOneIN;
import mx.dr.ml.service.ICatalogService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.vo.Contract;

public class ContractFacade {
	public Contract getContractCompany(GenericDtoOneIN dto) throws Exception{
		ICatalogService service =  WebServiceLocator.getBean(ICatalogService.class, Executions.getCurrent().getDesktop());
		Contract srch= new Contract();
		srch.setType((String)dto.getParam());
		return (Contract)service.findByExampleDesc(srch,1,"id").get(0);
	}
}
