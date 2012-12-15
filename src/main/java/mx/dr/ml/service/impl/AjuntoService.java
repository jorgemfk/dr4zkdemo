/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dr.ml.service.impl;

import java.io.ByteArrayInputStream;
import java.util.List;
import javax.annotation.Resource;
import mx.dr.ml.dao.GenericDao;
import mx.dr.util.FileUtils;
import mx.dr.ml.service.IAdjuntoService;
import mx.test.vo.Adjunto;
import mx.test.vo.Documento;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zkoss.util.media.Media;
import org.zkoss.util.resource.Labels;

/**
 *
 * @author JLMR
 */
@Scope("prototype")
@Service("IAdjuntoService")
public class AjuntoService implements IAdjuntoService {

    @Resource(name = "GenericDao")
    private GenericDao dao;

    @Transactional
    public Long saveMedia(Media media, Adjunto adjunto) throws Exception {
        String res = "/mailConfig.properties";
        Documento doc = new Documento();
        doc.setDataContent(media.getByteData());
        dao.save(doc);
        FileUtils.writeToFile(Adjunto.class.getResource(res).getPath().replaceFirst(res, "") + "/../../" + Labels.getLabel("parametro.adjuntos.folder") + "/" + doc.getId() + "." + adjunto.getFormat(), media.getStreamData());
        System.out.println(Adjunto.class.getResource(res).getPath().replaceFirst(res, "") + "/../../" + Labels.getLabel("parametro.adjuntos.folder") + "/" + doc.getId() + "." + adjunto.getFormat());
       
        return doc.getId();
    }

     @Transactional
     public void writeTempFiles() throws Exception{
         String res = "/mailConfig.properties";
         List<Adjunto> ids = dao.find("from Adjunto");
         Documento doc;
         for(Adjunto adjunto :ids){
             doc = dao.get(Documento.class, adjunto.getIddocumento());
             if(doc!=null)
                FileUtils.writeToFile(Adjunto.class.getResource(res).getPath().replaceFirst(res, "") + "/../../" + Labels.getLabel("parametro.adjuntos.folder") + "/" + doc.getId() + "." + adjunto.getFormat(),new ByteArrayInputStream(doc.getDataContent()));
         }
         System.gc();
     }

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }
}
