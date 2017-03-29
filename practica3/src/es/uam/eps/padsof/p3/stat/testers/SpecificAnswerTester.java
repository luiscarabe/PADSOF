/**
 * 
 */
package es.uam.eps.padsof.p3.stat.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.p3.course.Course;
import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.exercise.OpenQuestion;
import es.uam.eps.padsof.p3.exercise.Option;
import es.uam.eps.padsof.p3.stat.SpecificAnswer;

/**
 * @author Alejo Luis
 *
 */
public class SpecificAnswerTester {
	SpecificAnswer sa;
	OpenQuestion oq;
	Exercise e;
	Course c;
	Option o1, o2, o3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c = new Course("PADSOF", "A description");
		e = new Exercise("PADSOF", "Another description", false, c);
		e.setWeight(10);
		e.setPenalty(0.5);
		oq = new OpenQuestion("Question 1", 3, e);
		o1 = new Option("Solution");
		o2 = new Option("Solution2");
		oq.getSolution().add(o1);
		oq.getSolution().add(o2);
		sa = new SpecificAnswer(oq);
	}

	/**
	 * Test method for ChooseAnswer
	 */
	@Test
	public void testChooseAnswer() {
		assertTrue(sa.chooseAnswer(o1));
		assertTrue(sa.getAnswers().contains(o1));
	}
	
	/**
	 * Test method for Invalid ChooseAnswer
	 */
	@Test
	public void testInvChooseAnswer() {
		sa.chooseAnswer(o1);
		assertFalse(sa.chooseAnswer(o1));
		assertTrue(sa.getAnswers().contains(o1));
	}

	/**
	 * Test method for deleteAnswer
	 */
	@Test
	public void testDeleteAnswer() {
		sa.chooseAnswer(o1);
		sa.deleteAnswer(o1);
		assertFalse(sa.getAnswers().contains(o1));
	}

	/**
	 * Test method for calculateMark with correct answers
	 */
	@Test
	public void testCalculateMark() {
		sa.chooseAnswer(o1);
		sa.chooseAnswer(o2);
		sa.calculateMark();
		assertTrue(sa.getMarkOut10() == 0.3);
	}
	
	/**
	 * Test method for calculateMark with not all answers
	 */
	@Test
	public void testNotAllCalculateMark() {
		sa.chooseAnswer(o1);
		sa.calculateMark();
		assertTrue(sa.getMarkOut10() == -0.05);
	}
	
	/**
	 * Test method for calculateMark with a non-answered question
	 */
	@Test
	public void testNotAnsCalculateMark() {
		sa.calculateMark();
		assertTrue(sa.getMarkOut10() == 0);
	}
	
	/**
	 * Test method for calculateMark with a wrong answer
	 */
	@Test
	public void testNotRightCalculateMark() {
		o3 = new Option("Not valid");
		sa.chooseAnswer(o3);
		sa.calculateMark();
		assertTrue(sa.getMarkOut10() == -0.05);
	}
	

}
