package com.sda.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sda.demo.model.User;
import com.sda.demo.model.Worker;


public interface WorkerRepo extends JpaRepository<Worker,Long>{
	
	/*User findByEmail(String email);
	 List<Worker> findByCategory_Id(Long categoryId);
	static Worker findByEmailAndPassword(String email, String password) {
		
		return null;
	}
	*/
	Worker findByEmail(String email);

	
	List<Worker> findByCategory_Id(Long categoryId);

}
