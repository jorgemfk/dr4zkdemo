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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.util.Base;



@Entity
@Table(name = "ml_category")

public class Category extends Base{
	


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
   
	private Integer id;
        @DRField(columnListWidth = "200px",label=@DRLabel(key=""),actions= {FormActions.LIST})       
	private String name;
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "registry_date")
	private Date registryDate;
        @Column(name = "status")
	private String status;
	@ManyToOne
	@JoinColumn(name = "iduser")
        private User user;
        @ManyToOne
	@JoinColumn(name = "id_category_main")
        
        private MainCategory father;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }
    public Date getFechaAlta() {
        return registryDate;
    }

    public void setFechaAlta(Date fecha_alta) {
        this.registryDate = fecha_alta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CatalogStatus getEstatusEnum() {
        return CatalogStatus.getValueOf(status);
    }

    public void setEstatusEnum(CatalogStatus estatus) {
        if(estatus!=null)
            this.status = estatus.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User usuario) {
        this.user = usuario;
    }

    public MainCategory getFather() {
        return father;
    }

    public void setFather(MainCategory padre) {
        this.father = padre;
    }

    public boolean equals(Object obj){
            if(!(obj instanceof Category))
                return false;
            if(id==null || ((Category)obj).getId()==null)
                return false;
            return this.id==((Category)obj).getId().intValue();
        }
}
