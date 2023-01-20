package com.jawbr.service;

import java.util.List;

import com.jawbr.entity.MagicItems;

public interface MagicItemsService {

	public List<MagicItems> getMagicItems();

	public MagicItems getMagicItems(int id);

	public void saveMagicItem(MagicItems item);
}
