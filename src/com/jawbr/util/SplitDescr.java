package com.jawbr.util;

import com.jawbr.entity.MagicItems;

public class SplitDescr {
	
	// Metodo para dividir a descrição do item magico
	public static void splitDescr(MagicItems item) {
		String[] s = item.getDescr().split("\n");
		item.setDescr_top(s[0]);
		item.setDescr_down(s[1]);
	}
}
