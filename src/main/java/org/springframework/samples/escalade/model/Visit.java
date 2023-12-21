package org.springframework.samples.escalade.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    /**
     * Holds value of property date.
     */
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    /**
     * Holds value of property description.
     */
    @NotEmpty
    @Column(name = "description")
    private String description;

    /**
     * Holds value of property site.
     */
    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;


    /**
     * Creates a new instance of Visit for the current date
     */
    public Visit() {
        this.date = LocalDate.now();
    }


    /**
     * Getter for property date.
     *
     * @return Value of property date.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Setter for property date.
     *
     * @param date New value of property date.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter for property description.
     *
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for property description.
     *
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property site.
     *
     * @return Value of property site.
     */
    public Site getSite() {
        return this.site;
    }

    /**
     * Setter for property site.
     *
     * @param site New value of property site.
     */
    public void setSite(Site site) {
        this.site = site;
    }

}
