package com.jawbr.util;

import com.jawbr.entity.MagicItems;

public class SplitDescr {

	// Method to split the Descr, this is needed because of how the DB was made
	public static void splitDescr(MagicItems item) {
		if(item.getDescr_top() == "" || item.getDescr_top() == null) {
			String[] s = item.getDescr().split("\n");
			item.setDescr_top(s[0]);
			//item.setDescr_down(s[1]);
			
			String down = null;
			for (int i=1; i<s.length; i++) {
				if(down == null)
					down = s[i];
				else
					down = down+"<br>"+s[i];
			}
			
			item.setDescr_down(down);
		}
	}
}
