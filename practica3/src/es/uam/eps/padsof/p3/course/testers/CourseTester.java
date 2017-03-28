/**
 * 
 */
package es.uam.eps.padsof.p3.course.testers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import es.uam.eps.padsof.p3.course.*;
import es.uam.eps.padsof.p3.user.Student;
import es.uam.eps.padsof.p3.user.User;

/**
 * @author Alejo Luis
 *
 */
public class CourseTester {
	Course c1, c2, c3;
	CourseElement u1, u2, u3, u4;
	Student s1, s2, s3;
	
	
	@Before
	public void setUp() throws Exception{
		c1 = new Course("Padsof", "It is known that everyone love it.");
		c2 = new Course("Padsof", "It is known that everyone hate it.");
		c3 = new Course("Soper", "SoperDescription");
		
		u1 = c1.createUnit("Unit 1", "DescriptionUnit 1", true);
		u2 = c1.createUnit("Unit 1", "DescriptionUnit 2", true);
		u4 = c1.createUnit("Unit 4", "DescriptionUnit 4", false);
		
		s1 = new Student("Name1", "Email@1", "password1");
		c1.getEnrolledStudents().add(s1);
		s2 = new Student("Name2", "Email@2", "password2");
		s3 = new Student("Name3", "Email@3", "password3");
		c1.getExpelledStudents().add(s3);
		
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
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#acceptedStudent(es.uam.eps.padsof.p3.user.Student)}.
	 */
	@Test
	public void testAcceptedStudent() {
		assertTrue(c1.acceptedStudent(s1));
		assertFalse(c1.acceptedStudent(s2));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#getTotalAverage()}.
	 */
	@Test
	public void testGetTotalAverage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#expellStudent(es.uam.eps.padsof.p3.user.Student)}.
	 */
	@Test
	public void testExpellStudent() throws Exception{
		assertTrue(c1.expellStudent(s3));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#readmitStudent(es.uam.eps.padsof.p3.user.Student)}.
	 */
	@Test
	public void testReadmitStudent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.course.Course#searchApplication(es.uam.eps.padsof.p3.user.Student)}.
	 */
	@Test
	public void testSearchApplication() {
		fail("Not yet implemented");
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
