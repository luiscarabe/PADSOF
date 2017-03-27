/**
 * 
 */
package es.uam.eps.padsof.p3.educagram.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.p3.course.Course;
import es.uam.eps.padsof.p3.educagram.Educagram;
import es.uam.eps.padsof.p3.user.Student;
import es.uam.eps.padsof.p3.user.User;

/**
 * @author Alejo, Luis
 *
 */
public class EducagramTester {
	Educagram edu;
	User u;
	User u1;
	Student s;
	Student s1;
	Course c;
	Course c1;
	Course c2;
	
	@Before
	public void setup() throws Exception{
		edu = Educagram.getInstance();
		
		edu.readFile();
		
		s = edu.searchStudent("Javier Carrera");
		
		s1 = edu.searchStudent("Invalid User");
		

		
		c2 = edu.searchCourse("ADSOF");

		
		u1 = edu.signIn("Roberto.Paz@aadu.es", "notValidPsw");
		
		u = edu.signIn("Roberto.Paz@aadu.es", "Rerto");
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.educagram.Educagram#readFile()}.
	 * @throws IOException 
	 */
	@Test
	public void testReadFile() throws IOException {
		assertNotNull(edu.getStudents());
		assertEquals(edu.getStudents().get(0).getName(), "Jorge Alcazar");
		assertEquals(edu.getStudents().get(0).getEmail(), "Jorge.Alcazar@esdu.es");
		assertEquals(edu.getStudents().get(0).getPassword(), "JoA");
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.educagram.Educagram#searchStudent(java.lang.String)}.
	 */
	@Test
	public void testSearchStudent() {
		assertEquals(s.getEmail(), "Javier.Carrera@aadu.es");
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.educagram.Educagram#searchInvalidStudent(java.lang.String)}.
	 */
	@Test
	public void testSearchInvalidStudent() {
		assertNull(s1);
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.educagram.Educagram#searchInvalidCourse(java.lang.String)}.
	 */
	@Test
	public void testSearchInvalidCourse() {
		assertNull(c2);
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.educagram.Educagram#searchCourse(java.lang.String)}.
	 */
	@Test
	public void testSearchCourse() {
		c = new Course("PADSOF", "Only testing");
		edu.getCourses().add(c);
		c1 = edu.searchCourse("PADSOF");
		assertEquals(c,c1);
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.educagram.Educagram#InvalidsignIn(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testInvalidSignIn() {
		assertNull(u1);
		
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.educagram.Educagram#signIn(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSignIn() {
		assertEquals(u.getName(), "Roberto Paz");
		
	}

}
