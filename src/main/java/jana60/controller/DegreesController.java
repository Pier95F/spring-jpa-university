package jana60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Degrees;
import jana60.repository.DegreesRepository;

@Controller
@RequestMapping("/")

public class DegreesController {
	
	@Autowired
	private DegreesRepository repoD;
	
	@GetMapping("/degrees")
	public String degrees(Model model) {
		List<Degrees> degreesList = (List<Degrees>) repoD.findAllByOrderByNameAsc();
		model.addAttribute("degreesList", degreesList);
		return "degrees";
		
	}
}


