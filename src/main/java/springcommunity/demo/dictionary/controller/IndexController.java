package springcommunity.demo.dictionary.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springcommunity.demo.dictionary.domain.Category;
import springcommunity.demo.dictionary.domain.Type;
import springcommunity.demo.dictionary.domain.Word;
import springcommunity.demo.dictionary.service.DatabaseService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private DatabaseService service;
	
	@RequestMapping (value="", method = RequestMethod.GET)
	public String index(Model model){
		List<Word> words = service.findAllWord();
		List<Type> types = service.findAllType();
		List<Category> categories = service.findAllCategory();
		int row = words.size();
		HashMap<String, Type> typeHashMap = new HashMap<String, Type>();
		for(Type type: types){
			typeHashMap.put(type.getId()+"", type);
		}
		model.addAttribute("row", row);
		model.addAttribute("words", words);
		model.addAttribute("types", types);
		model.addAttribute("categories", categories);
		model.addAttribute("typeHashMap", typeHashMap);
		return "index";
	}
	
	@RequestMapping (value="", method = RequestMethod.POST)
	public String showIndex(@RequestParam(value="categoryId") Integer cateId, @RequestParam(value="typeId") Integer typeId, Model model){
		List<Word> words = new ArrayList<Word>();
		List<Type> types = service.findAllType();
		List<Category> categories = service.findAllCategory();
		int row = service.findAllWord().size();
		HashMap<String, Type> typeHashMap = new HashMap<String, Type>();
		for(Type type: types){
			typeHashMap.put(type.getId()+"", type);
		}
		if(cateId == 0 & typeId == 0){
			words = service.findAllWord();
		} else if (cateId != 0 & typeId == 0){
			words = service.findWordsByCate(cateId);
		} else if (cateId == 0 & typeId != 0){
			words = service.findWordsByType(typeId);
		} else {
			words = service.findWordsByCateAndType(cateId, typeId);
		}
		model.addAttribute("row", row);
		model.addAttribute("words", words);
		model.addAttribute("types", types);
		model.addAttribute("categories", categories);
		model.addAttribute("typeHashMap", typeHashMap);
		return "index";
	}

	@RequestMapping(value="search", method = RequestMethod.GET)
    public String keyword(@RequestParam(value="key") String keyword, Model model){
		if(isString(keyword)){
			List<Word> words = service.findByKeyword(keyword);
			List<Type> types = service.findAllType();
			List<Category> categories = service.findAllCategory();
			int row = service.findAllWord().size();
			HashMap<String, Type> typeHashMap = new HashMap<String, Type>();
			for(Type type: types){
				typeHashMap.put(type.getId()+"", type);
			}
			model.addAttribute("row", row);
			model.addAttribute("words", words);
			model.addAttribute("types", types);
			model.addAttribute("categories", categories);
			model.addAttribute("typeHashMap", typeHashMap);
			return "index";
		}
    	     return "redirect:";
    }
	
	@RequestMapping(value="search", method = RequestMethod.POST)
	public String searchKeyword(@RequestParam(value="key") String keyword, Model model){
		return keyword(keyword, model);
	}
	
	@RequestMapping(value="action", method = RequestMethod.POST)
	public String action(@RequestParam(value="wordId") Integer wordId, @RequestParam(value="action") String action, Model model){
		if(action.equalsIgnoreCase("Delete")){
		      service.deleteAWord(wordId);
		      return "redirect:";
		  }
		if(action.equalsIgnoreCase("Edit")){
			Word word = service.findWordById(wordId);
			List<Type> types = service.findAllType();
			model.addAttribute("id", wordId);
			model.addAttribute("word", word);
			model.addAttribute("types", types);
			return "modal";
		}
          return null;		
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insertWord(@ModelAttribute(value="newword") Word newword){
		int CategoryId = getCategoryNo(newword.getName());
		newword.setCategoryId(CategoryId);
		 service.createNewWord(newword);
		 return "redirect:";
	}
	
	
	@RequestMapping(value="modal", method = RequestMethod.POST)
	public String showModal(@ModelAttribute(value="word") Word word){
		int categoryId = getCategoryNo(word.getName());
		word.setCategoryId(categoryId);
		service.updateAWord(word);
		return "redirect:";
	}
	
	public static int getCategoryNo(String word){
		char firstWord = word.toUpperCase().charAt(0);
		int lkm = 0;
		int position = 0;
		for(char alphabe ='A'; alphabe < 'Z'; alphabe++){
			lkm++;
			if(firstWord == alphabe){
				position = lkm;
				break;
			}
		}
		return position;
		
	}
	
	public static boolean isString(String input){
		try {
			Integer.parseInt(input);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}
}
