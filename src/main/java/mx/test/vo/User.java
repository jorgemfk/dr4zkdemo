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

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

import org.zkoss.util.resource.Labels;

import mx.dr.util.Base;

@Entity
@Table(name = "dr_user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("MLU")
@SequenceGenerator(name = "dr_cusuario_id_seq", sequenceName =
"dr_cusuario_id_seq", allocationSize = 1)
public class User extends Base implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1798263937864023931L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dr_cusuario_id_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "key")
    private String key;
    @Column(name = "status")
    private String status;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "register_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date registerDate;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(Integer id, String nombre) {
        super();
        this.id = id;
        this.name = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String clave) {
        this.key = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String estatus) {
        this.status = estatus;
    }

    public CatalogStatus getEstatusEnum() {
        return CatalogStatus.getValueOf(status);
    }

    public void setEstatusEnum(CatalogStatus estatus) {
        if(estatus!=null){
        this.status = estatus.getId();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date fechaAlta) {
        this.registerDate = fechaAlta;
    }



    public String getType() {
        return type;
    }

    public void setType(String tipo) {
        this.type = tipo;
    }

 
    public String getEstatusLabel() {
        return Labels.getLabel(CatalogStatus.getLabel(this.status));
    }

    public boolean equals(Object obj){
            if(!(obj instanceof User))
                return false;
            if(id==null || ((User)obj).getId()==null)
                return false;
            return this.id==((User)obj).getId().intValue();
        }
}
