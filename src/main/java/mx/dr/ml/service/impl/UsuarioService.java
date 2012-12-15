/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dr.ml.service.impl;

import java.util.Calendar;
import javax.annotation.Resource;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.dr.ml.dao.GenericDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.dr.ml.service.IAdjuntoService;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.view.utils.DRMediaUtils;
import mx.dr.forms.dto.DRMedia;
import mx.dr.forms.view.utils.DtoConverter;
import mx.dr.ml.service.IContratoService;
import mx.dr.ml.service.IUsuarioService;
import mx.dr.util.DRGeneralUtils;
import mx.dr.util.MailSender;
import mx.test.dr4zkdemo.view.model.EditEmpresaMain;
import mx.test.dr4zkdemo.view.model.RegisterEmpresaMain;
import mx.test.vo.Adjunto;
import mx.test.vo.CatalogStatus;
import mx.test.vo.Empresa;
import mx.test.vo.Usuario;
import org.springframework.transaction.annotation.Propagation;
import org.zkoss.util.resource.Labels;

/**
 *
 * @author JLMR
 */
@Scope("prototype")
@Service("IUsuarioService")
public class UsuarioService implements IUsuarioService {

    @Resource(name = "GenericDao")
    private GenericDao dao;
    @Resource(name = "IAdjuntoService")
    private IAdjuntoService adjuntoService;
    @Resource(name = "IContratoService")
    private IContratoService contratoService;

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }

    public IAdjuntoService getAdjuntoService() {
        return adjuntoService;
    }

    public void setAdjuntoService(IAdjuntoService adjuntoService) {
        this.adjuntoService = adjuntoService;
    }

    public IContratoService getContratoService() {
        return contratoService;
    }

    public void setContratoService(IContratoService contratoService) {
        this.contratoService = contratoService;
    }





    @Transactional
    public void saveNewEmpresa(GenericDtoIN dto) throws Exception {
        Empresa user = (Empresa) dto.getBos().get(0);

        user.setNombre(user.getMarca());

        user.setEstatus(CatalogStatus.INACTIVE.getId());
        user.setPasword(DRGeneralUtils.stringToMD5(user.getPasword()));
        user.setFechaAlta(Calendar.getInstance().getTime());
        if (dto.getViewDTO() instanceof RegisterEmpresaMain) {
            if (!((RegisterEmpresaMain) dto.getViewDTO()).getEmpresa().getMedias().isEmpty()) {
                DRMedia dtoMedia = ((RegisterEmpresaMain) dto.getViewDTO()).getEmpresa().getMedias().get(0);
                Adjunto logo = (Adjunto) DRMediaUtils.bulidBO(dtoMedia.getMedia(), Adjunto.class);
                logo.setIddocumento(adjuntoService.saveMedia(dtoMedia.getMedia(), logo));
                user.setAdjunto(logo);
            }
        }
        dao.save(user);
    }

    @Transactional
    public void updateEmpresa(GenericDtoIN dto) throws Exception {
        EditEmpresaMain view = (EditEmpresaMain) dto.getViewDTO();

        Empresa user = (Empresa) dao.get(Empresa.class, view.getContacto().getId());
        DtoConverter.buildBO(view, null, user, true);

        if (!view.getEmpresa().getAdjunto().isEmpty()) {
            DRMedia dtoMedia = view.getEmpresa().getAdjunto().get(0);
            if (dtoMedia.getBo() == null) {
                Adjunto logo = (Adjunto) DRMediaUtils.bulidBO(dtoMedia.getMedia(), Adjunto.class);
                logo.setIddocumento(adjuntoService.saveMedia(dtoMedia.getMedia(), logo));
                user.setAdjunto(logo);
            }
        }

        dao.update(user);
        //throw new BusinessException("El registro se hizo correctamente", new Exception());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Usuario usuarioByClave(String clave) throws Exception {
        Usuario usr = new Usuario();
        usr.setClave(clave);
        return (Usuario) dao.findUniqueByExample(usr);
    }



    @Transactional
    public Empresa empresaById(GenericDtoOneIN dto) throws Exception {
        Integer id = Integer.valueOf((String) dto.getParam());
        System.out.println("byid");
        Empresa com = (Empresa) dao.findById(dto.getAclass(), id);
        System.out.println(com);
        return com;
    }


}
