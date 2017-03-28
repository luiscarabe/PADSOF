/**
 * 
 */
package es.uam.eps.padsof.p3.exercise.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.p3.course.Course;
import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.exercise.MultiQuestion;

/**
 * @author Alejo Luis
 *
 */
public class MultiQuestionTester {
	Course c;
	Exercise e;
	MultiQuestion m;
	
	@Before
	public void setUp() throws Exception {
		c = new Course("CN", "All numbers");
		e = new Exercise("Exercise 1", "Insert description here", false, c);
		m = new MultiQuestion("Select all the natural numbers.", 3.5, false, e);
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.Question#getWeight()}.
	 */
	@Test
	public void testGetWeight() {
		assertTrue(m.getWeight() == 4.5);
		m.setWeight(4.2);
		assertTrue(m.getWeight() == 4.2);
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.Question#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		assertEquals(m.getTitle(), "Select all the natural numbers.");
		m.setTitle("Select all the natural numbers (2 correct answers).");
		assertEquals(m.getTitle(), "Select all the natural numbers (2 correct answers).");
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MultiQuestion#deleteOption(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testDeleteOption() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MultiQuestion#getNumSol()}.
	 */
	@Test
	public void testGetNumSol() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MultiQuestion#addSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testAddSolution() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MUQuestion#getAnswers()}.
	 */
	@Test
	public void testGetAnswers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MUQuestion#getNumAns()}.
	 */
	@Test
	public void testGetNumAns() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MUQuestion#addOption(java.lang.String)}.
	 */
	@Test
	public void testAddOption() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MUQuestion#isRandomOrder()}.
	 */
	@Test
	public void testIsRandomOrder() {
		assertTrue(m.isRandomOrder() == false);
		m.setRandomOrder(true);
		assertTrue(m.isRandomOrder() == true);
	}

}
