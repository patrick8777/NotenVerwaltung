/**
 * package Test
 *
 */
package Test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import Management.Grade;
import Management.GradeLb;

/**
 * @author Patrick Stössel
 *
 */

/**
 * Die GradeLbTest Klasse 
 *
 */
public class GradeLbTest {

		@Test
		public void gettersReturnOriginallyProvidedValues() {
			final LocalDateTime date = LocalDateTime.parse("2022-01-01T00:00:00");
			final int value = 5;
			final int weight = 20;
			Grade g = new GradeLb(value, weight, date);

			assertEquals(value, g.getValue(), 0);
			assertEquals(weight, g.getWeight(), 0);
			assertEquals(date, g.getDate());
		}
	}