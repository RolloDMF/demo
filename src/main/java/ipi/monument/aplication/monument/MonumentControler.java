package ipi.monument.aplication.monument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/monument")
public class MonumentControler {
	
	@Autowired
	MonumentRepository repo;

	//Methode en get (par defaut)
	@RequestMapping("/{id}")
	@ResponseBody
	public Monument getMonument(@PathVariable("id") Integer id) {
		Monument result = repo.findById(id).get();
		return result;
	}
	
	@RequestMapping("/all")
	@ResponseBody
	public List<Monument> getMonuments() {
		List<Monument> resultList = (List<Monument>) repo.findAll();
		return resultList;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Monument postMonument(@RequestBody Monument m) {
		repo.save(m);
		return m;
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Monument putMonument(@RequestBody Monument m) {
		
		repo.findById(m.getId());
		
		m.setdescription(m.getdescription());
		m.setNom(m.getNom());
		m.setPts(m.getPts());
		m.setUrlAudio(m.getUrlAudio());
		m.setUrlImage(m.getUrlImage());
		
		repo.save(m);
		
		return m;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Monument deleteMonument(@PathVariable("id") Integer id) {
		repo.deleteById(id);
		return null;
	}
}
