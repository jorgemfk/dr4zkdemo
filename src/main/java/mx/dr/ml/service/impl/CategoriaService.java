/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service.impl;

import java.util.Calendar;
import mx.dr.ml.service.ICategoriaService;
import java.util.List;
import javax.annotation.Resource;
import mx.test.vo.CatalogStatus;
import mx.dr.ml.dao.GenericDao;
import mx.test.vo.Categoria;
import mx.test.vo.CategoriaMain;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author JLMR
 */
@Scope("prototype")
@Service("ICategoriaService")
public class CategoriaService implements ICategoriaService{

    @Resource(name="GenericDao")
    private GenericDao dao;

    @Transactional
    public List findActive() throws Exception {
        List  res= dao.findByNamedParam("from Categoria where status=:status order by nombre", "status", CatalogStatus.ACTIVE.getId());
        System.out.println(res);
        return res;
    }

     @Transactional
    public List findCategoriasPadre() throws Exception {
        return dao.find("from CategoriaMain order by nombre");
    }
    
    @Transactional
    public List findAll() throws Exception {
        List  res= dao.find("from Categoria order by nombre");
        System.out.println(res);
        return res;
    }

    @Transactional
    public Categoria save(String value) throws Exception{
        Categoria vo = new Categoria();
        vo.setNombre(value);
        vo.setStatus(CatalogStatus.INACTIVE.getId());
        vo.setFechaAlta(Calendar.getInstance().getTime());
        vo.setPadre(new CategoriaMain(1));
        dao.save(vo);
        return vo;
    }

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }


}
