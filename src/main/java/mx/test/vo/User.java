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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import mx.dr.util.Base;

import org.zkoss.util.resource.Labels;

/**
 * User persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "dr_user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("MLU")
@SequenceGenerator(name = "dr_cusuario_id_seq", sequenceName =
"dr_cusuario_id_seq", allocationSize = 1)
public class User extends Base {

    /**
     * serial
     */
    private static final long serialVersionUID = 1798263937864023931L;
    /**
     * user id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dr_cusuario_id_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    /**
     * user key (email)
     */
    @Column(name = "key")
    private String key;
    /**
     * user status
     */
    @Column(name = "status")
    private String status;
    /**
     * user password
     */
    @Column(name = "password")
    private String password;
    /**
     * user full name
     */
    @Column(name = "name")
    private String name;
    /**
     * user type
     */
    @Column(name = "type")
    private String type;
    /**
     * registry date
     */
    @Column(name = "register_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date registerDate;

    /**
     * default constructor
     */
    public User() {
        super();
    }
    
    /**
     * constructor by parameters
     * @param id
     * @param nombre
     */
    public User(Integer id, String nombre) {
        super();
        this.id = id;
        this.name = nombre;
    }



    /**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the registerDate
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
     * 
     * @return status value as enum
     */
    public CatalogStatus getEstatusEnum() {
        return CatalogStatus.getValueOf(status);
    }

    /**
     * set status as enum
     * @param estatus
     */
    public void setEstatusEnum(CatalogStatus estatus) {
        if(estatus!=null){
        this.status = estatus.getId();
        }
    } 

 
    /**
     * 
     * @return the status label
     */
    public String getEstatusLabel() {
        return Labels.getLabel(CatalogStatus.getLabel(this.status));
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj){
            if(!(obj instanceof User))
                return false;
            if(id==null || ((User)obj).getId()==null)
                return false;
            return this.id==((User)obj).getId().intValue();
        }
}
