package com.uningen.OneToMany;

import com.uningen.OneToMany.dao.AppDAO;
import com.uningen.OneToMany.entities.Course;
import com.uningen.OneToMany.entities.Instructor;
import com.uningen.OneToMany.entities.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO, 1);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO, 1);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int courseId = 10;
		appDAO.deleteCourseById(courseId);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 100;
		System.out.println("Finding course with id: " + id);
		Course course = appDAO.findCourseById(id);
		if(course == null){
			System.out.println("Could not find a course with id: " + id);
		}
		else {
			System.out.println("Updating the course....");
			course.setTitle("Complete Spring Masterclass");
			appDAO.updateCourse(course);
			System.out.println("Course updated!");
		}
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		// find the instructor
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		if(instructor == null){
			System.out.println("Could not find instructor with id: " + id);
		}
		else {
			instructor.setFirstName("TEST");
			appDAO.updateInstructor(instructor);
			System.out.println("Instructor has been updated!");
			findInstructorWithCoursesJoinFetch(appDAO, id);
		}

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO, int id) {
		System.out.println("Looking for the instuctor with id: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		if(instructor == null){
			System.out.println("No instructor with id: " + id + " found");
		}
		else {
			System.out.println("Found instructor: ");
			System.out.println(instructor);
			List<Course> courses = instructor.getCourses();
			if(courses.isEmpty() || courses == null){
				System.out.println("No courses taught by "
						+ instructor.getFirstName() + " "
								+ instructor.getLastName());
			}
			else {
				System.out.println(instructor.getFirstName() + " "
						+ instructor.getLastName() + " is teaching the following courses:");
				for(Course course: courses){
					System.out.println(course.getTitle() + " course id: " + course.getId());
				}
			}
		}
	}

//	private void findCoursesForInstructor(AppDAO appDAO) {
//	}

	private void findInstructorWithCourses(AppDAO appDAO, int id) {
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		if(instructor == null){
			System.out.println("No instructor with id " + id + " found");
		}
		else {
			System.out.println("Found instructor: " + instructor);
			System.out.println("Looking for courses....");
			List<Course> courses = appDAO.findCoursesByInstructorId(id);
			if(courses == null || courses.isEmpty()){
				System.out.println("No courses found");
			}
			else {
				System.out.println("The associated courses:");
				for(Course course: courses){
					System.out.println(course);
				}
				instructor.setCourses(courses);
				System.out.println(instructor.getCourses());
			}
//			System.out.println(instructor.getCourses());
		}
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 2 code!!!");
		*/

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
