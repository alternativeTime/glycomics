package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Structurecomp {

	@Id
	public Long id;
	public String glycanst;
	public String compositionId;
		
	public String glycanType;
	
	@ManyToOne
	public Structure structure;

	public static Model.Finder<Long,Structurecomp> find = new Model.Finder<Long,Structurecomp>(Long.class, Structurecomp.class);

	/*
	 * 
	 * Find matching composition string used in glycosuite
	 */
	public static List<Structurecomp> findStructurecomp(String compositionId, String glycanType){

		if(glycanType != null) {
		return find
				.where()
				.eq("compositionId", compositionId)
				.ieq("glycanType", glycanType)
				.findList();
		}
		else{
		return find
                                .where()
                                .eq("compositionId", compositionId)
                                .findList();

		}
	}

}
