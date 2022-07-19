package jana60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Teachers;
import jana60.repository.TeacherRepository;

@Controller
@RequestMapping("/")
public class TeachersController {

	@Autowired
	private TeacherRepository repoT;
	
	@GetMapping("/teachers")
	public String teachers(Model model) {
		List<Teachers> teachersList = (List<Teachers>) repoT.findAllByOrderByNameAsc();
		model.addAttribute("teachersList", teachersList);
		return "teachers";
		
	}
}
