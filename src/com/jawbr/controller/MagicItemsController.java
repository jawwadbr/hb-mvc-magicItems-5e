package com.jawbr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jawbr.entity.MagicItems;
import com.jawbr.service.EquipmentCategoryService;
import com.jawbr.service.MagicItemsService;
import com.jawbr.service.SourceBookService;
import com.jawbr.util.SplitDescr;

@Controller
@RequestMapping("/items")
public class MagicItemsController {
	
	// Inject all Services Layer
	@Autowired
	private MagicItemsService magicItemService;
	
	@Autowired
	private SourceBookService sourceBookService;
	
	@Autowired
	private EquipmentCategoryService equipCategoryService;
	
	@GetMapping("/list")
	public String listMagicItems(Model model) {
		
		List<MagicItems> items  = magicItemService.getMagicItems();
		
		model.addAttribute("magicItem", items);
		
		return "list-items";
	}
	
	@GetMapping("checkItem")
	public String checkItem(@RequestParam("itemId") int id, Model model) {
		
		MagicItems item = magicItemService.getMagicItems(id);
		
		if(item.getDescr_top() == "" || item.getDescr_top() == null) {
			SplitDescr.splitDescr(item);
		}
		
		model.addAttribute("item" ,item);
		
		return "check-item";
	}
}
