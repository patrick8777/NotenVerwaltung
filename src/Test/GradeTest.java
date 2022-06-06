package Test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import Management.GradeLb;
import Management.GradeZp;
import org.junit.Test;

import Management.Grade;
/**
 * @author Patrick Stössel
 *
 */

/**
 * JUnit GradeTest
 *
 */
public class GradeTest {

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

    @Test(expected = IllegalArgumentException.class)
    public void gradeValueIsGreaterThanOrEqualTo1()
    {
        final LocalDateTime date = LocalDateTime.now();
        final int value = 0;
        final int weight = 20;
        Grade g = new GradeLb(value, weight, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void gradeValueIsLessThanOrEqualTo6()
    {
        final LocalDateTime date = LocalDateTime.parse("2022-01-01T00:00:00");
        final int value = 7;
        final int weight = 20;
        Grade g = new GradeZp(value, weight, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void weightMustBePositive()
    {
        final LocalDateTime date = LocalDateTime.parse("2022-01-01T00:00:00");
        final int value = 1;
        final int weight = 0;
        Grade g = new GradeLb(value, weight, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dateMustBeInThePast()
    {
        final LocalDateTime date = LocalDateTime.now();
        final int value = 1;
        final float weight = 50f;
        Grade g = new GradeZp(value, weight, date);
    }
    @Test(expected = IllegalArgumentException.class)
    public void dateMustMinusZero()
    {
        final LocalDateTime date = LocalDateTime.now();
        final int value = 1;
        final float weight = -0;
        Grade g = new GradeZp(value, weight, date);
    }
}
