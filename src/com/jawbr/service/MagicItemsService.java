package com.jawbr.service;

import java.util.List;

import com.jawbr.entity.MagicItems;

public interface MagicItemsService {

	public List<MagicItems> getMagicItems();
	
	public List<MagicItems> getMagicItems(String sortField);

	public MagicItems getMagicItem(int id);

	public void saveMagicItem(MagicItems item);

	public void deleteMagicItem(int id);
	
}
