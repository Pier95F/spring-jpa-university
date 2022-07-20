package jana60.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping("/teachers/{id}")
	public String teachersDetail(Model model, @PathVariable (name = "id") Integer teacherId) {
		Optional<Teachers> teachers = repoT.findById(teacherId);
		if (teachers.isPresent()) {
			model.addAttribute("teachersList", teachers.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found");
		} return "teachersDetail";
	 } 
}