package fi.haagahelia.course.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@Controller
public class StudentRestController {

	
		private StudentRepository studentRepository; 

		
		// Constructor Injection 
		public StudentRestController(StudentRepository studentRepository) {
			this.studentRepository = studentRepository;
		}
		
	  
		// RESTful service to get all students
	    @RequestMapping(value="/students", method = RequestMethod.GET)
	    public @ResponseBody List<Student> studentListRest() {	
	        return (List<Student>) studentRepository.findAll();
	    }    

		// RESTful service to get student by id
	    @RequestMapping(value="/students/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Student> findStudentRest(@PathVariable("id") Long studentId) {	
	    	return studentRepository.findById(studentId);
	    }       
	    
	   // RESTful service to save new student
	    @RequestMapping(value="/students", method = RequestMethod.POST)
	    public @ResponseBody Student saveNewStudentRest(@RequestBody Student student) {	
	    	return studentRepository.save(student);
	    }    

	    
	    // TODO RESTful service to delete student etc

}
