/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service.impl;

import java.util.List;
import javax.annotation.Resource;
import mx.dr.ml.dao.GenericDao;
import mx.dr.ml.service.IEstadoService;
import mx.test.vo.Estado;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JLMR
 */
@Scope("prototype")
@Service("IEstadoService")
public class EstadoService implements IEstadoService{
    @Resource(name="GenericDao")
    private GenericDao dao;

    @Transactional
    public List<Estado> findMXEstados() throws Exception {
        Estado estado= new Estado("MX");
        return dao.findByExample(estado,0, "nombre");
    }

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }

}
