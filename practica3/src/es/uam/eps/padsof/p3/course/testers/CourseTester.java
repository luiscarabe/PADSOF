/**
 * 
 */
package es.uam.eps.padsof.p3.course.testers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import es.uam.eps.padsof.p3.course.*;
import es.uam.eps.padsof.p3.user.Student;
import es.uam.eps.padsof.p3.user.Application;
import es.uam.eps.padsof.p3.stat.CourseStat;

/**
 * @author Alejo Luis
 *
 */
public class CourseTester {
	Course c1, c2, c3;
	CourseElement u1, u2, u3, u4;
	Student s1, s2, s3, s4;
	Application a1, a2, a3;
	CourseStat cs1;
	
	
	@Before
	public void setUp() throws Exception{
		c1 = new Course("Padsof", "It is known that everyone love it.");
		c2 = new Course("Padsof", "It is known that everyone hate it.");
		c3 = new Course("Soper", "SoperDescription");
		
		u1 = c1.createUnit("Unit 1", "DescriptionUnit 1", true);
		u2 = c1.createUnit("Unit 1", "DescriptionUnit 2", true);
		u4 = c1.createUnit("Unit 4", "DescriptionUnit 4", false);
		
		s1 = new Student("Jorge Alcazar", "Jorge.Alcazar@esdu.es", "password1");
		c1.getEnrolledStudents().add(s1);
		s1.getEnrolledCourses().add(c1);
		s2 = new Student("Manuel Blanco", "Manuel.Blanco@esdu.es", "password2");
		s3 = new Student("Ana Cordero", "Ana.Cordero@esdu.es", "password3");
		c1.getExpelledStudents().add(s3);
		s3.getExpelledCourses().add(c1);
		
		s4 = new Student("Eva Fuertes", "Eva.Fuertes@esdu.es", "password4");
		a1 = new Application(c1, s2);
		a2 = new Application(c1, s4);
		a3 = new Application(c2, s2);
		c1.getApplications().add(a1); 
		c1.getApplications().add(a2);
		c2.getApplications().add(a3);
		
		cs1 = new CourseStat();
		cs1.setAverageMark(9.7);
		c1.setCourseStat(cs1);
		
	}
	
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#createUnit(java.lang.String, java.lang.String, boolean)}.
	 */
	@Test
	public void testCreateUnit() {
		
		
		assertTrue(u1 instanceof Unit);
		assertEquals(u1.getTitle(), "Unit 1");
		assertEquals(u1.getDesc(), "DescriptionUnit 1");
		assertEquals(u1.isHidden(), true);
		assertEquals(c1, u1.getCourse());
		assertTrue(c1.getCourseElements().size() == 2);
		
		assertNull(u2);
		assertTrue(c1.getCourseElements().size() == 2);
		
		u3 = c1.createUnit("Unit 2", "DescriptionUntitleUnit 2", false);
		
		assertNotNull(u3);
		assertTrue(c1.getCourseElements().size() == 3);
		assertNotEquals(u1, u3);
		assertTrue(c1.getCourseElements().contains(u1));
		
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#deleteUnit(es.uam.eps.padsof.p3.course.Unit)}.
	 */
	@Test
	public void testDeleteUnit() {
		assertTrue(c1.getCourseElements().contains(u4));
		
		assertTrue(u4 instanceof Unit);
		Unit aux = (Unit) u4;
		assertTrue(c1.deleteUnit(aux));
		
		assertFalse(c1.getCourseElements().contains(u4));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#isEnrolledStudent(es.uam.eps.padsof.p3.user.Student)}.
	 */
	@Test
	public void testIsAcceptedStudent() {
		assertTrue(c1.isEnrolledStudent(s1));
		assertFalse(c1.isEnrolledStudent(s2));
	}

	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#isExpelledStudent(es.uam.eps.padsof.p3.user.Student)}.
	 * @throws Exception
	 */
	@Test
	public void testIsExpelledStudent() throws Exception {
		assertTrue(c1.isExpelledStudent(s3));
		assertFalse(c1.isExpelledStudent(s1));
		
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#isNotAdmittedStudent(es.uam.eps.padsof.p3.user.Student)}.
	 */
	@Test
	public void testIsNotAdmittedStudent() {
		assertTrue(c1.isNotAdmittedStudent(s2));
		assertFalse(c1.isNotAdmittedStudent(s1));
		assertFalse(c1.isNotAdmittedStudent(s3));
	}
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#getTotalAverage()}.
	 */
	@Test
	public void testGetTotalAverage() {
		assertTrue(c1.getTotalAverage() == (double)(9.7));
		assertTrue(c2.getTotalAverage() == -1);
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#expellStudent(es.uam.eps.padsof.p3.user.Student)}.
	 * @throws Exception
	 */
	@Test
	public void testExpellStudent() throws Exception{
		assertFalse(c1.expellStudent(s3));
		assertTrue(c1.expellStudent(s1));
		assertFalse(c1.getExpelledStudents().contains(s2));
		assertFalse(c1.getEnrolledStudents().contains(s1));
		assertTrue(c1.getExpelledStudents().contains(s1));
		assertTrue(c1.getExpelledStudents().contains(s3));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#readmitStudent(es.uam.eps.padsof.p3.user.Student)}.
	 * @throws Exception
	 */
	@Test
	public void testReadmitStudent() throws Exception{
		assertFalse(c1.readmitStudent(s1));
		assertTrue(c1.readmitStudent(s3));
		assertTrue(c1.getEnrolledStudents().contains(s3));
		assertFalse(c1.getExpelledStudents().contains(s3));
		assertTrue(c1.getEnrolledStudents().contains(s1));
		assertFalse(c1.getExpelledStudents().contains(s1));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#searchApplication(es.uam.eps.padsof.p3.user.Student)}.
	 */
	@Test
	public void testSearchApplication() {
		assertNotNull(c1.searchApplication(s2));
		assertNull(c2.searchApplication(s4));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		assertTrue(c1.equals(c2));
		assertFalse(c1.equals(c3));
	}

}
