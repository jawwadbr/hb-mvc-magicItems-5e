package com.jawbr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jawbr.entity.EquipmentCategory;
import com.jawbr.entity.MagicItems;
import com.jawbr.entity.SourceBook;
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
		
		SplitDescr.splitDescr(item);
		
		model.addAttribute("item" ,item);
		
		return "check-item";
	}
	
	@GetMapping("/formAddItems")
	public String formAddItems(Model model) {
		
		MagicItems item = new MagicItems();
		
		model.addAttribute("item" ,item);
		
		// Get all source books
		List<SourceBook> source_bookList = sourceBookService.getSourceBook();
		
		// add books in model
		model.addAttribute("source_bookList", source_bookList);
		model.addAttribute("book", new SourceBook());
		
		// Get all equipCategory
		List<EquipmentCategory> equip_list = equipCategoryService.getEquipmentCategory();
		
		// add equipCaegory in model
		model.addAttribute("equip_list", equip_list);
		model.addAttribute("equipC", new EquipmentCategory());
		
		return "addItems-form";
	}
	
	@PostMapping("saveItem")
	public String saveItem(@ModelAttribute("item") MagicItems item) {
		
		String tempDescr = item.getDescr_top() + "\n" + item.getDescr_down();
		item.setDescr(tempDescr);
		
		// Save new item
		magicItemService.saveMagicItem(item);
		
		return "redirect:/items/list";
	}
	
	@GetMapping("/delete")
	public String deleteMagicItem(@RequestParam("itemId") int id) {
		
		// delete the item
		magicItemService.deleteMagicItem(id);
		
		return "redirect:/items/list";
	}
	
	@GetMapping("itemFormForUpdate")
	public String itemFormForUpdate(@RequestParam("itemId") int id, Model model) {
		
		MagicItems item = magicItemService.getMagicItems(id);
		
		SplitDescr.splitDescr(item);
		
		model.addAttribute("item", item);
		
		// Get all source books
		List<SourceBook> source_bookList = sourceBookService.getSourceBook();
				
		// add books in model
		model.addAttribute("source_bookList", source_bookList);
		model.addAttribute("book", new SourceBook());
				
		// Get all equipCategory
		List<EquipmentCategory> equip_list = equipCategoryService.getEquipmentCategory();
				
		// add equipCaegory in model
		model.addAttribute("equip_list", equip_list);
		model.addAttribute("equipC", new EquipmentCategory());
		
		return "addItems-form";
	}
}
