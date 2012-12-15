/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.test.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Transient;

/**
 *
 * @author JLMR
 */
@Entity
@Table(name = "ml_empresa")
@DiscriminatorValue("RES")

public class Empresa extends Usuario {

   
    public Integer getId(){
        return super.getId();
    }


    @Column(name = "marca")
    private String marca;
   
    private String bio;


    private String link;
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "idcontacto")
    private Contacto contacto;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;
    
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "iddireccion")
    private Direccion direccion;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idregistro_fiscal")
    private RegistroFiscal registroFiscal;

    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idadjunto")
    private Adjunto adjunto;

    private String telefono;

    private String slogan;
    private String especialidad;
    private String horario;

    @Transient
    public String categoriaPadreNombre;
    @Transient
    public String categoriaNombre;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public RegistroFiscal getRegistroFiscal() {
        return registroFiscal;
    }

    public void setRegistroFiscal(RegistroFiscal registroFiscal) {
        this.registroFiscal = registroFiscal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Adjunto getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(Adjunto adjunto) {
        this.adjunto = adjunto;
    }
 
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategoriaNombre(){return categoria.getNombre();}

    public String getCategoriaPadreNombre(){return categoria.getPadre().getNombre();}
    //@IndexedEmbedded()
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }



    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }



}
