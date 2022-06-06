package Test;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.Arrays;

import Management.Grade;
import Management.GradeZp;
import junit.framework.TestSuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.mockito.cglib.util.StringSwitcher;

import Controller.Application;
/**
 * @author Patrick Stössel
 *
 */

/**
 * Die GradeZpTest Klasse 
 *
 */
public class GradeZpTest {

	@Test
	 public void gettersReturnOriginallyProvidedValues()
    {
        final LocalDateTime date = LocalDateTime.parse("2022-01-01T00:00:00");
        final int value = 5;
        final int weight = 20;
        Grade g = new GradeZp(value, weight, date);

        assertEquals(value, g.getValue(), 0);
        assertEquals(weight, g.getWeight(), 0);
        assertEquals(date, g.getDate());
    }
}
