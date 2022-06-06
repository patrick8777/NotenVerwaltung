package Test;
/**
 * importiert JUnit test,JUnit Before Mockito und Controller.Application
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;//import Mockito-Klassee

import Controller.Application;

import static org.mockito.Mockito.*;

import javax.swing.JTextField;

/**
 * @author Patrick Stössel
 */
/**
 * Mockup Test Application Noten falsche Eingaben und richtige Eingaben
 */
public class ApplicationTest {
	Application sut = new Application();

	@Before
	public void setUp() throws Exception {

		/**
		 * Zuerst inkorekte Test mit assertFalse NetagiveTests
		 *
		 */
	}

	@Test
	public void checkGradeInputFirstNameIncorrectEnter() {
		JTextField doc = Mockito.mock(JTextField.class);
		when(doc.getText()).thenReturn("Max");
		assertFalse(new Application().checkGradeInput(doc));
	}

	@Test
	public void checkGradeInputOnlyDoctrinalIncorrectEnter() {
		JTextField doc = Mockito.mock(JTextField.class);
		when(doc.getText()).thenReturn(" ");
		assertFalse(new Application().checkGradeInput(doc));
	}

	@Test
	public void checkGradeInputSpecialCharactersIncorrectEnter() {
		JTextField doc = Mockito.mock(JTextField.class);
		when(doc.getText()).thenReturn("+");
		assertFalse(new Application().checkGradeInput(doc));
	}

	@Test
	public void checkGradeInputCalculateOperationIncorrectEnter() {
		JTextField doc = Mockito.mock(JTextField.class);
		when(doc.getText()).thenReturn("2*3");
		assertFalse(new Application().checkGradeInput(doc));
	}

	@Test
	public void checkGradeInputcommaIncorrectEnter() {
		JTextField doc = Mockito.mock(JTextField.class);
		when(doc.getText()).thenReturn("2,3");
		assertFalse(new Application().checkGradeInput(doc));
	}

	@Test
	public void checkGradeInputIncorrectEnter() {
		JTextField tfdummy = Mockito.mock(JTextField.class);
		// Prüfe DoppelNachnamen soll falsch die Eingabe.
		when(tfdummy.getText()).thenReturn("Stoessel-Tran");
		// Prüfe prüfe umlaute soll falsch die Eingabe.
		when(tfdummy.getText()).thenReturn("ö");
		try {
			assertEquals(false, sut.checkGradeInput(tfdummy));
		} catch (Exception e) {
			fail("test hat nicht funktioert");
		}
	}

	/**
	 * Korekte Test mit assertTrue Postive Tests
	 *
	 */
	@Test
	public void checkGradeInputDotcorrectEnter() {
		JTextField doc = Mockito.mock(JTextField.class);
		when(doc.getText()).thenReturn("5.3");
		assertTrue(new Application().checkGradeInput(doc));
	}

	@Test
	public void checkGradeInputcorrectEnter() {
		JTextField doc = Mockito.mock(JTextField.class);
		when(doc.getText()).thenReturn("5");
		assertTrue(new Application().checkGradeInput(doc));
	}

	@Test
	public void checkGradeInputDotTwocorrectEnter() {
		JTextField doc = Mockito.mock(JTextField.class);
		when(doc.getText()).thenReturn("2.33");
		assertTrue(new Application().checkGradeInput(doc));
	}
}
