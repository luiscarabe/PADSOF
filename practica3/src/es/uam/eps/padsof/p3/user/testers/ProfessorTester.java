/**
 * 
 */
package es.uam.eps.padsof.p3.user.testers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.p3.user.*;
import es.uam.eps.padsof.p3.course.*;
import es.uam.eps.padsof.p3.educagram.Educagram;

/**
 * @author Alejo Luis
 *
 */
public class ProfessorTester {
	Educagram edu;
	Professor p;
	Course c1, c2;
	Student s1, s2, s3;
	Application a1, a2, a3;
	
	
	@Before
	public void setUp() throws Exception{
		edu = Educagram.getInstance();
		p = new Professor("Luis Alejo", "Luis.Alejo@esdu.es", "alejoluis");
		c1 = p.createCourse("Course 1", "descCourse1");
		c2 = p.createCourse("Course 1", "descCourse2");
		s1 = new Student("Jorge Alcazar", "Jorge.Alcazar@esdu.es", "password1");
		s2 = new Student("Manuel Blanco", "Manuel.Blanco@esdu.es", "password2");
		s3 = new Student("Ana Cordero", "Ana.Cordero@esdu.es", "password3");
		
		a1 = new Application(c1, s1);
		a2 = new Application(c1, s2);
		a3 = new Application(c1, s3);
	}
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Professor#createCourse(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateCourse() {
		assertNotNull(c1);
		assertEquals(c1.getTitle(), "Course 1");
		assertEquals(c1.getDesc(), "descCourse1");
		assertTrue(edu.getCourses().contains(c1));
		assertTrue(p.getAllCourses().contains(c1));
		assertNull(c2);
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Professor#confirmApplication(es.uam.eps.padsof.p3.user.Application, boolean)}.
	 * @throws Exception
	 */
	@Test
	public void testConfirmApplication() throws Exception {
		p.confirmApplication(a1, true);
		assertTrue(s1.getEnrolledCourses().contains(c1));
		assertTrue(c1.getEnrolledStudents().contains(s1));
		assertNull(c1.searchApplication(s1));
		p.confirmApplication(a2, false);
		assertTrue(c1.isNotAdmittedStudent(s2));
		assertNull(c1.searchApplication(s2));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Professor#expellStudent(es.uam.eps.padsof.p3.user.Student, es.uam.eps.padsof.p3.course.Course)}.
	 * @throws Exception 
	 */
	@Test
	public void testExpellStudent() throws Exception {
		p.confirmApplication(a1, true);
		p.confirmApplication(a2, false);
		assertTrue(s1.getEnrolledCourses().contains(c1));
		assertTrue(c1.getEnrolledStudents().contains(s1));
		assertNull(c1.searchApplication(s1));
		assertTrue(c1.isNotAdmittedStudent(s2));
		assertNull(c1.searchApplication(s2));
		
		assertTrue(p.expellStudent(s1, c1));
		assertTrue(c1.getExpelledStudents().contains(s1));
		assertTrue(s1.getExpelledCourses().contains(c1));
		assertFalse(p.expellStudent(s1, c1));
		assertFalse(p.expellStudent(s2, c1));
		assertFalse(p.expellStudent(s1, c2));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Professor#readmitStudent(es.uam.eps.padsof.p3.user.Student, es.uam.eps.padsof.p3.course.Course)}.
	 * @throws  
	 */
	@Test
	public void testReadmitStudent() throws Exception {
		p.confirmApplication(a1, true);
		p.confirmApplication(a2, false);
		c1.getExpelledStudents().add(s3);
		s3.getEnrolledCourses().add(c1);
		p.readmitStudent(s3, c1);
		assertTrue(c1.getEnrolledStudents().contains(s3));
		assertTrue(s3.getEnrolledCourses().contains(c1));
		
		assertFalse(p.readmitStudent(s1, c1));
		assertFalse(p.readmitStudent(s2, c1));
		
	}

}
