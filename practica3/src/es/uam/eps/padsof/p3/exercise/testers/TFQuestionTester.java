/**
 * 
 */
package es.uam.eps.padsof.p3.exercise.testers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.p3.course.Course;
import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.exercise.TFQuestion;
import es.uam.eps.padsof.p3.exercise.Option;

/**
 * @author e341020
 *
 */
public class TFQuestionTester {
	TFQuestion otf1;
	Exercise e1;
	Course c1;
	Option o1, o2, o3;
	
	
	
	@Before
	public void setUp(){
		c1 = new Course("Course 1", "descCourse1");
		e1 = new Exercise("Exercise1", "descExercise1", true, c1);
		otf1 = new TFQuestion("OpQuestion1", 10.5, e1);
		o1 = new Option("f");
		o2 = new Option("Huola");
		o3 = new Option("F");
		otf1.setSolution(o2);
	}
	
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.TFQuestion#setSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testSetSolution() {
		assertNotNull(otf1.getExer());
		assertTrue(otf1.getSolution().isEmpty());
		assertTrue(otf1.setSolution(o1));
		assertEquals(otf1.getSolution().get(0).getOption(), "f");
		assertTrue(otf1.getSolution().size() == 1);
		assertFalse(otf1.setSolution(o2));
		assertEquals(otf1.getSolution().get(0).getOption(), "f");
		assertTrue(otf1.getSolution().size() == 1);
		assertTrue(otf1.setSolution(o3));
		assertEquals(otf1.getSolution().get(0).getOption(), "F");
		assertTrue(otf1.getSolution().size() == 1);
		
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.TFQuestion#deleteSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testDeleteSolution() {
		assertNotNull(otf1.getExer());
		assertTrue(otf1.getSolution().isEmpty());
		assertTrue(otf1.setSolution(o1));
		assertEquals(otf1.getSolution().get(0).getOption(), "f");
		assertTrue(otf1.getSolution().size() == 1);
		assertFalse(otf1.deleteSolution(o2));
		assertTrue(otf1.getSolution().size() == 1);
		assertTrue(otf1.deleteSolution(o1));
		assertTrue(otf1.getSolution().isEmpty());
		assertFalse(otf1.deleteSolution(o2));
	}

}
