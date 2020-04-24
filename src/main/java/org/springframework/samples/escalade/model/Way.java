package org.springframework.samples.escalade.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name = "ways")
public class Way extends NamedEntity {

	/**
	 * Holds value of property roles. FOREIGN KEY (partie_id)
	 */
		
	@ManyToOne(targetEntity = Point.class,  cascade=CascadeType.ALL)
	@JoinColumn(name = "zone_id", nullable = true)
	private Zone zone;

	@OneToMany(targetEntity = Length.class, mappedBy = "way" , cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Length> lengths;

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Set<Length> getLengths() {
		return lengths;
	}

	public void setLengths(Set<Length> lengths) {
		this.lengths = lengths;
	}

	/**
	 * 
	 */
	public Way() {
	}

	@Override
	public String toString() {
		return "Way [zone=" + zone + ", lengths=" + lengths + "]";
	}

	 protected Set<Length> getLengthsInternal() {
	        if (this.lengths == null) {
	            this.lengths = new HashSet<>();
	        }
	        return this.lengths;
	    }
	 /**
	  * 
	  * @return
	  * Parameters:
		property the property to compare
		ignoreCase whether upper and lower case in String values should be ignored
		ascending whether to sort ascending (true) or descending (false)
	  */
	 
	
	 public List<Length> getPetLengths() {
	        List<Length> sortedLengths = new ArrayList<>(getLengthsInternal());
	        PropertyComparator.sort(sortedLengths , new MutableSortDefinition("name", true, true));
	        return Collections.unmodifiableList(sortedLengths );
	    }
	
	
	 public void addLength(Length length) {
			// TODO Auto-generated method stub
				getLengthsInternal().add(length);
				length.setWay(this);
		}
		
	
	 
	 /**
	     * Return the Length with the given name, or null if none found for this Way.
	     *
	     * @param name to test
	     * @return true if length name is already in use
	     */
	    public Length getLength(String name) {
	        return getLength(name, false);
	    }
	 
	    
	    /**
	     * Return the Length with the given name, or null if none found for this Way.
	     *
	     * @param name to test
	     * @return true if length name is already in use
	     */
	    public Length getLength(String name, boolean ignoreNew) {
	        name = name.toLowerCase();
	        for (Length length : getLengthsInternal()) {
	            if (!ignoreNew || !length.isNew()) {
	                String compName = length.getName();
	                compName = compName.toLowerCase();
	                if (compName.equals(name)) {
	                    return length;
	                }
	            }
	        }
	        return null;
	    }
	    
	 
	
	
	

}