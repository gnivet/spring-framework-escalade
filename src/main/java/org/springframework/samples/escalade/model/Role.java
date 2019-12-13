package org.springframework.samples.escalade.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Role extends NamedEntity{
	
	
    @ManyToOne
    @JoinColumn(name = "type_id")        
  
    private RoleType type;
    
	public RoleType getType() {
        return this.type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }
    
}