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
	Option o, o1, o2, o3, o4;
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
		assertTrue(u.addSolution(o3));
		assertTrue(u.getSolution().contains(o3));
	}
	
	o4 = new Option("Five");
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
	 * Test method that shuffles the list of options successfully.
	 */
	@Test
	public void testRandomizeOrderCorrect(){
		u.getAnswers().clear();
		o1 = u.addOption("8");
		o2 = u.addOption("5");
		o3 = u.addOption("7");
		
		u.setRandomOrder(true);
		
		/* 
		 * This Method could not work sometimes. Re-run.
		 * In fact, this "error" prove that Collections.shuffle works.
		 */
		assertTrue(u.randomizeOrder());
		assertTrue(!u.getAnswers().get(0).equals(o1) || !u.getAnswers().get(1).equals(o2)
				|| !u.getAnswers().get(2).equals(o3));
	}
	
	/**
	 * Test method that tries to shuffle the list of options.
	 */
	@Test
	public void testRandomizeOrderError(){
		u.getAnswers().clear();
		o1 = u.addOption("8");
		o2 = u.addOption("5");
		o3 = u.addOption("7");
		
		u.setRandomOrder(false);
		
		/* This Method could not work sometimes. Re-run*/
		assertFalse(u.randomizeOrder());
		assertTrue(u.getAnswers().get(0).equals(o1) && u.getAnswers().get(1).equals(o2)
				&& u.getAnswers().get(2).equals(o3));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.exercise.Question#getExer()}.
	 */
	@Test
	public void testGetExer() {
		assertEquals(e, u.getExer());
	}

}
