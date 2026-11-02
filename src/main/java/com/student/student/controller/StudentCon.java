
package com.student.student.controller;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

import com.student.student.Service.StudentSer;
import com.student.student.entity.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StudentCon {

	static Logger log = LoggerFactory.getLogger(StudentCon.class);
    @Autowired
    StudentSer ser;

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
    	log.info("New Student data Stored -> "+ student);
       return ser.saveStudent(student);
    }
    
    @GetMapping("/all")
    public List<Student> getAllStdent(){
    	return ser.getAllStudent();
    }
    
//    find total salary 
    @GetMapping("/totalFees")
    public HashMap<String,Object> getAllStdFees(){
    	double fees =ser.getAllStdFees();
    	
    	HashMap<String ,Object> map = new HashMap<String,Object>();
    	map.put("TotalFees", fees);
    	map.put("msg","All Stdent Fees Calculated");
    	
    	return map;
    }
    
    
    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable int id){
    	return ser.getStudent(id);
    }
    
    @DeleteMapping
    public String deleteStudentParm(@RequestParam int id) {
    	return ser.deleteEmp(id);
    }
    
    @PutMapping("/update")
    public Student updateStudent (@RequestBody Student student) {
    	return ser.updateStudent(student);
    }
}
