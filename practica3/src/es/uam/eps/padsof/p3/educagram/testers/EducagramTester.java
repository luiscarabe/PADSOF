/**
 * 
 */
package es.uam.eps.padsof.p3.educagram.testers;

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
	User u, u1, u2;
	Student s, s1;
	Course c, c1, c2;
	
	@Before
	public void setup() throws Exception{
		edu = Educagram.getInstance();
		
		edu.readFile();
		
		s = edu.searchStudent("Javier Carrera");
		
		s1 = edu.searchStudent("Invalid User");
		

		
		c2 = edu.searchCourse("ADSOF");

		
		u1 = edu.signIn("Roberto.Paz@aadu.es", "notValidPsw");
		
		u = edu.signIn("Roberto.Paz@aadu.es", "Rerto");
		
		u2 = edu.signIn("teacher@teadu.com", "lovingPADSOF");
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
		assertNull(s1);
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

		assertNull(c2);
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.educagram.Educagram#signIn(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSignIn() {
		assertEquals(u.getName(), "Roberto Paz");
		assertNull(u1);
		assertEquals(u2.getName(), "Teacher");
		
	}

}
