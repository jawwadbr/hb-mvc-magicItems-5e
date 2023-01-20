package com.jawbr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "magic_items")
public class MagicItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "indexname")
	private String indexName;
	
	@Column(name = "name")
	private String itemName;
	
	@Column(name = "descr")
	private String descr;
	
	@Column(name = "rarity")
	private String rarity;
	
	@Column(name = "url")
	private String url;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "equipment_category_fk")
	private EquipmentCategory equipCategory;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "source_name_fk")
	private SourceBook sourceBook;
	
	@Transient
	private String descr_top, descr_down;
	
	public MagicItems() {}

	public MagicItems(String itemName, String descr, String rarity, EquipmentCategory equipCategory,
			SourceBook sourceBook) {
		this.itemName = itemName;
		this.descr = descr;
		this.rarity = rarity;
		this.equipCategory = equipCategory;
		this.sourceBook = sourceBook;
	}

	public MagicItems(String itemName, String descr_top, String descr_down, String rarity,
			EquipmentCategory equipCategory, SourceBook sourceBook) {
		this.itemName = itemName;
		this.descr_top = descr_top;
		this.descr_down = descr_down;
		this.rarity = rarity;
		this.equipCategory = equipCategory;
		this.sourceBook = sourceBook;
		
		this.descr = this.descr_top + "\n" + this.descr_down;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public EquipmentCategory getEquipCategory() {
		return equipCategory;
	}

	public void setEquipCategory(EquipmentCategory equipCategory) {
		this.equipCategory = equipCategory;
	}

	public SourceBook getSourceBook() {
		return sourceBook;
	}

	public void setSourceBook(SourceBook sourceBook) {
		this.sourceBook = sourceBook;
	}

	public String getDescr_top() {
		return descr_top;
	}

	public void setDescr_top(String descr_top) {
		this.descr_top = descr_top;
	}

	public String getDescr_down() {
		return descr_down;
	}

	public void setDescr_down(String descr_down) {
		this.descr_down = descr_down;
	}

	@Override
	public String toString() {
		return "MagicItems [id=" + id + ", indexName=" + indexName + ", itemName=" + itemName + ", descr=" + descr
				+ ", rarity=" + rarity + ", url=" + url + ", equipCategory=" + equipCategory + ", sourceBook="
				+ sourceBook + ", descr_top=" + descr_top + ", descr_down=" + descr_down + "]";
	}
	
}
