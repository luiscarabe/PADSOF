/**
 * 
 */
package es.uam.eps.padsof.p3.course.testers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import es.uam.eps.padsof.p3.course.*;

/**
 * @author Alejo Luis
 *
 */
public class CourseTester {
	Course c1;
	CourseElement u1, u2, u3, u4;
	
	
	@Before
	public void setUp() throws Exception{
		c1 = new Course("Padsof", "It is known that everyone love it.");
		
		u1 = c1.createUnit("Unit 1", "DescriptionUnit 1", true);
		u2 = c1.createUnit("Unit 1", "DescriptionUnit 2", true);
		u4 = c1.createUnit("Unit 4", "DescriptionUnit 4", false);
		
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
		fail("Not yet implemented");
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
	public void testExpellStudent() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
