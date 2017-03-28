/**
 * 
 */
package es.uam.eps.padsof.p3.exercise.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.p3.course.Course;
import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.exercise.Option;
import es.uam.eps.padsof.p3.exercise.UniqQuestion;

/**
 * @author Alejo Luis
 *
 */
public class UniqQuestionTester {
	UniqQuestion u;
	Exercise e;
	Course c;
	Option o, o1, o2, o3;
	Boolean b1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c = new Course("BC", "Basic computer");
		e = new Exercise("Exercise1", "descExercise1", true, c);		
		u = new UniqQuestion("How many bits correspond to one byte?", 4.5, false, e);
		
		o = u.addOption("2");
		o1 = u.addOption("8");
		o2 = u.addOption("5");
		o3 = new Option("Four");
		
		b1 = u.addSolution(o1);

	}

	/**¡
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.Question#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		assertEquals(u.getTitle(), "How many bits correspond to one byte?");
		u.setTitle("How many bits correspond to one byte? (Number)");
		assertEquals(u.getTitle(), "How many bits correspond to one byte? (Number)");
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.Question#getWeight()}.
	 */
	@Test
	public void testGetWeight() {
		assertTrue(u.getWeight() == 4.5);
		u.setWeight(4.2);
		assertTrue(u.getWeight() == 4.2);
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MUQuestion#addOption(java.lang.String)}.
	 */
	@Test
	public void testAddOption() {
		assertTrue(u.getAnswers().contains(o));
		assertTrue(u.getAnswers().contains(o1));
		assertTrue(u.getAnswers().contains(o2));
		assertFalse(u.getAnswers().contains(o3));
	}
	

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.UniqQuestion#deleteOption(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testDeleteOption() {
		assertFalse(u.deleteOption(o3));
		assertTrue(u.deleteOption(o2));
		assertFalse(u.getAnswers().contains(o2));
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.UniqQuestion#addSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testAddSolutionOption() {
		u.deleteOption(o2);
		assertFalse(u.addSolution(o2));
		assertTrue(b1);
		assertEquals(u.getSolution().get(0), o1);
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.UniqQuestion#deleteSolution(es.uam.eps.padsof.p3.exercise.Option)}.
	 */
	@Test
	public void testDeleteSolutionOption() {
		assertFalse(u.deleteSolution(o2));
		assertTrue(u.deleteSolution(o1));
		assertTrue(u.getSolution().isEmpty());
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MUQuestion#getNumAns()}.
	 */
	@Test
	public void testGetNumAns() {
		u.deleteOption(o2);
		assertTrue(u.getNumAns() == 2);
		u.addOption("9");
		assertTrue(u.getNumAns() == 3);
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.MUQuestion#isRandomOrder()}.
	 */
	@Test
	public void testIsRandomOrder() {
		assertTrue(u.isRandomOrder() == false);
		u.setRandomOrder(true);
		assertTrue(u.isRandomOrder() == true);
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.Question#getExer()}.
	 */
	@Test
	public void testGetExer() {
		assertEquals(e, u.getExer());
	}

}
