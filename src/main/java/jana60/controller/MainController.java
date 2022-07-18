package jana60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Degrees;
import jana60.model.Departments;
import jana60.model.Teachers;
import jana60.repository.DegreesRepository;
import jana60.repository.DepartmentsRepository;
import jana60.repository.TeacherRepository;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private DepartmentsRepository repo;
	
	@GetMapping
	public String home (Model model)
	{
		return "home";
	}

	@GetMapping("/departments")
	public String departments(Model model) {
		List<Departments> departmentsList = (List<Departments>) repo.findAll();
		model.addAttribute("departmentsList", departmentsList);
		return "departments";
	}

	@Autowired
	private TeacherRepository repoT;
	
	@GetMapping("/teachers")
	public String teachers(Model model) {
		List<Teachers> teachersList = (List<Teachers>) repoT.findAllByOrderByNameAsc();
		model.addAttribute("teachersList", teachersList);
		return "teachers";
		
	}
	
	@Autowired
	private DegreesRepository repoD;
	
	@GetMapping("/degrees")
	public String degrees(Model model) {
		List<Degrees> degreesList = (List<Degrees>) repoD.findAllByOrderByNameAsc();
		model.addAttribute("degreesList", degreesList);
		return "degrees";
		
	}
}
