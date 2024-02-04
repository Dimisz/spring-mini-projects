package com.uningen.AdvancedCrud;

import com.uningen.AdvancedCrud.dao.AppDAO;
import com.uningen.AdvancedCrud.entity.Instructor;
import com.uningen.AdvancedCrud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			Instructor instructor = findInstructorById(appDAO, 3);
//			System.out.println(instructor);
//			findInstructorById(appDAO, 8);
//			deleteInstructor(appDAO, 5);
//			deleteInstructor(appDAO, 2);
//			InstructorDetail instructorDetail = findInstructorDetail(appDAO, 3);
//			System.out.println(instructorDetail);
//			System.out.println("Associated instructor: " + instructorDetail.getInstructor());
//			deleteInstructorDetailById(appDAO, 8);
			deleteInstructorDetailById(appDAO, 6);

		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO, int id){
		appDAO.deleteInstructorDetailById(id);
	}
	private InstructorDetail findInstructorDetail(AppDAO appDAO, int id){
		return appDAO.findInstructorDetailById(id);
	}
	private Instructor findInstructorById(AppDAO appDAO, int id){
		Instructor i = appDAO.findInstructorById(id);
		if(i == null){
			System.out.println("Could not find the instructor with id: " + id);
		}
		else {
			System.out.println(i);
		}
		return i;
	}
	private void createInstructor(AppDAO appDAO) {

		// create the instructor
		Instructor instructor =
				new Instructor("Chad", "Darby", "darby@luv2code.com");
		// create instructor detail
		InstructorDetail instructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 2 code!");
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);


		// create the instructor
		Instructor instructor2 =
				new Instructor("Jack", "Jones", "jack@luv2code.com");
		// create instructor detail
		InstructorDetail instructorDetail2 =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 3 code!");
		// associate the objects
		instructor2.setInstructorDetail(instructorDetail2);
		// save the instructor
		// this will also save the instructor detail
		// because of Cascade.ALL
		System.out.println("Saving instructor 1");
		System.out.println(instructor);
		appDAO.save(instructor);
		System.out.println("Saving instructor 2");
		System.out.println(instructor2);
		appDAO.save(instructor2);
		System.out.println("Done");
	}

	private void deleteInstructor(AppDAO appDAO, int id){
		System.out.println("Deleting instructor: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done");
	}

}
