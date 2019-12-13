package org.springframework.samples.escalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lengths")
public class Length extends NamedEntity {

	@Column(name = "cotation")
	@NotNull
	private Integer cotation;

	@Column(name = "under_cotation")
	@NotEmpty
	private String under_cotation;

	/**
	 * Holds value of property roles. FOREIGN KEY (point_id)
	 */
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "point_id", nullable = true) private Point point;
	 */

	@Column(name = "comment")
	@NotEmpty
	private String comment;

	@Column(name = "length_status")
	@NotNull
	private boolean length_status;

	@ManyToOne
	@JoinColumn(name = "point_id")
	private PointType type;

	public PointType getType() {
		return type;
	}

	public void setType(PointType type) {
		this.type = type;
	}

	public Integer getCotation() {
		return cotation;
	}

	public void setCotation(Integer cotation) {
		this.cotation = cotation;
	}

	public String getUnder_cotation() {
		return under_cotation;
	}

	public void setUnder_cotation(String under_cotation) {
		this.under_cotation = under_cotation;
	}

	/*
	 * public Point getPoint() { return point; }
	 * 
	 * 
	 * public void setPoint(Point point) { this.point = point; }
	 */

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isLength_status() {
		return length_status;
	}

	public void setLength_status(boolean length_status) {
		this.length_status = length_status;
	}

}
