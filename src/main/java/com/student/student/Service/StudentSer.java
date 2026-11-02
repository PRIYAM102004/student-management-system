
package com.student.student.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student.entity.Student;
import com.student.student.Repository.StudentRepo;

@Service
public class StudentSer {

    @Autowired
    StudentRepo repo;

    public Student saveStudent(Student student) {
        return repo.save(student);
    }
    
    
    public  List<Student> getAllStudent(){
    	return repo.findAll();
    }
    
    //find total salary
    public double getAllStdFees() {
    	List <Student> students = repo.findAll();
    	
    	double totalFees=0;
    	for(Student stu:students) {
    		totalFees += stu.getFees();
    	}
    	return totalFees;
    }
    	
    
    
    public Optional<Student> getStudent(int id){
    	return repo.findById(id);
    }
    
    
    public Student updateStudent(Student student) {
    return 	repo.save(student);
    }
    public String deleteEmp(int id) {
    	repo.deleteById(id);
    	return "Student deleted sucessfully!";
    }
}
