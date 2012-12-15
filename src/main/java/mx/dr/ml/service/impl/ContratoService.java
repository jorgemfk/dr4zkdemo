/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service.impl;
import javax.annotation.Resource;
import mx.dr.ml.dao.GenericDao;
import mx.dr.ml.service.IContratoService;
import mx.test.vo.Contrato;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author JLMR
 */
@Scope("prototype")
@Service("IContratoService")
public class ContratoService implements IContratoService{
    @Resource(name = "GenericDao")
    private GenericDao dao;

    @Transactional
    public Contrato findLastContract(String tipo) throws Exception{
        Contrato srch= new Contrato();
        srch.setTipo(tipo);
        return (Contrato) dao.findByExampleDesc(srch, 1, "id").get(0);
    }

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }

}
