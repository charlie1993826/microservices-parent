package com.charlie.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Dept implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3689621775302923988L;

	private Long id;
	
	private String dname;
	
	private String db_source;

	public Dept() {
		// TODO Auto-generated constructor stub
	}

	public Dept(Long id, String dname, String db_source) {
		this.id = id;
		this.dname = dname;
		this.db_source = db_source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDb_source() {
		return db_source;
	}

	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}
	
}
