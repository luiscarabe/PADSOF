/**
 * 
 */
package es.uam.eps.padsof.p3.exercise.testers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.p3.exercise.OpenQuestion;
import es.uam.eps.padsof.p3.exercise.Option;
import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.course.Course;



/**
 * @author Alejo Luis
 *
 */
public class OpenQuestionTester {
	OpenQuestion oq1;
	Exercise e1;
	Course c1;
	Option o1, o2, o3;
	

	
	@Before
	public void setUp(){
		c1 = new Course("Course 1", "descCourse1");
		e1 = new Exercise("Exercise1", "descExercise1", true, c1);
		oq1 = new OpenQuestion("OpQuestion1", 10.5, e1);
		o1 = new Option("OK");
		o2 = new Option("Huola");
		o3 = new Option("OK");
		oq1.addSolution(o2);
	}
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.OpenQuestion#addSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testAddSolution() {
	    assertNotNull(oq1.getExer());
		assertTrue(oq1.getSolution().size() == 1);
		assertTrue(oq1.addSolution(o1));
		assertTrue(oq1.getSolution().size() == 2);
		assertTrue(oq1.getSolution().contains(o1));
		assertFalse(oq1.addSolution(o3));
		assertTrue(oq1.getSolution().size() == 2);
		/* o1 == o3 */
		assertTrue(oq1.getSolution().contains(o3));
		
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.OpenQuestion#deleteSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testDeleteSolution() {
		assertTrue(oq1.getSolution().size() == 1);
		oq1.deleteSolution(o2);
		assertTrue(oq1.getSolution().isEmpty());
	}

}
