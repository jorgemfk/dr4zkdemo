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
@Table(name = "ml_company")
@DiscriminatorValue("RES")
public class Company extends User {

   
    public Integer getId(){
        return super.getId();
    }


    private String brand;
   
    private String bio;


    private String link;
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "idcontact")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;
    
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "idaddress")
    private Address address;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idregistry_fiscal")
    private FiscalRegistry fiscalRegistry;

    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idattachment")
    private Attachment logo;

    private Integer phone;

    private String slogan;
    private String specialty;
    private String schedule;

    @Transient
    public String categoryMainName;
    @Transient
    public String categoryName;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String marca) {
        this.brand = marca;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contacto) {
        this.contact = contacto;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address direccion) {
        this.address = direccion;
    }

    public FiscalRegistry getFiscalRegistry() {
        return fiscalRegistry;
    }

    public void setFiscalRegistry(FiscalRegistry registroFiscal) {
        this.fiscalRegistry = registroFiscal;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer telefono) {
        this.phone = telefono;
    }

    public Attachment getLogo() {
        return logo;
    }

    public void setLogo(Attachment adjunto) {
        this.logo = adjunto;
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

    public String getCategoryName(){return category.getName();}

    public String getCategoryMainName(){return category.getFather().getName();}
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoria) {
        this.category = categoria;
    }
    
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String especialidad) {
        this.specialty = especialidad;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String horario) {
        this.schedule = horario;
    }



    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }



}
