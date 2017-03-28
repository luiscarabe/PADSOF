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
import es.uam.eps.padsof.p3.exercise.Option;

/**
 * @author Alejo Luis
 *
 */
public class MultiQuestionTester {
	Course c;
	Exercise e;
	MultiQuestion m;
	Option o, o1, o2, o3;
	
	@Before
	public void setUp() throws Exception {
		c = new Course("CN", "All numbers");
		e = new Exercise("Exercise 1", "Insert description here", false, c);
		m = new MultiQuestion("Select all the natural numbers.", 3.5, false, e);
	}

	/**
	 * Test method for to see if the weight is correctly initialized
	 */
	@Test
	public void testGetIniWeight() {
		assertTrue(m.getWeight() == 3.5);
	}
	
	/**
	 * Test method for the weight setter
	 */
	
	@Test
	public void testSetWeight() {
		m.setWeight(4.2);
		assertTrue(m.getWeight() == 4.2);
	}
	
	/**
	 * Test method to see if the title is correctly initialized
	 */
	@Test
	public void testGetIniTitle() {
		assertEquals(m.getTitle(), "Select all the natural numbers.");
	}
	
	/**
	 *Test method for the title setter
	 */
	@Test
	public void testSetTitle(){
		m.setTitle("Select all the natural numbers (2 correct answers).");
		assertEquals(m.getTitle(), "Select all the natural numbers (2 correct answers).");
	}
	
	/**
	 * Test method for correct addOption
	 */
	@Test
	public void testAddOption() {
		
		o = m.addOption("-2");
		o1 = m.addOption("8");
		o2 = m.addOption("5");
		
		assertTrue(m.getAnswers().contains(o));
		assertTrue(m.getAnswers().contains(o1));
		assertTrue(m.getAnswers().contains(o2));
	}
	/**
	 * Test method for incorrect addOption
	 */
	@Test
	public void testIncAddOption(){
		o3 = new Option("Four");
		assertFalse(m.getAnswers().contains(o3));
	}
	
	/**
	 * Test method for delete option
	 */
	@Test
	public void testDeleteOption() {
		o = m.addOption("2");
		assertTrue(m.deleteOption(o));
		assertFalse(m.getAnswers().contains(o));
		
	}
	
	/**
	 * Test method for incorrect delete option
	 */
	@Test
	public void testIncDeleteOption() {
		o = new Option("Four");
		assertFalse(m.deleteOption(o));
		assertFalse(m.getAnswers().contains(o));
		
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
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MultiQuestion#addSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testAddSolution() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MultiQuestion#deleteSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testDeleteSolution() {
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
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MUQuestion#isRandomOrder()}.
	 */
	@Test
	public void testIsRandomOrder() {
		assertTrue(m.isRandomOrder() == false);
		m.setRandomOrder(true);
		assertTrue(m.isRandomOrder() == true);
	}

}
