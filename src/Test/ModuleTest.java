package Test;

import Management.Grade;
import Management.GradeLb;
import Management.GradeZp;
import Management.Module;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * @author Paddy
 */
public class ModuleTest
{
    @Test
    public void getName()
    {
        final String name = "Test";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);
        assertEquals(name, m.getName());
    }

    @Test
    public void getLecturer()
    {
        final String name = "Test";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);
        assertEquals(lecturer, m.getLecturer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void moduleNameIsNotEmpty()
    {
        final String name = "";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moduleNameMustContainNonWhiteSpaceCharacters()
    {
        final String name = " ";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lecturerNameIsNotEmpty()
    {
        final String name = "Test";
        final String lecturer = "";
        Module m = new Module(name, lecturer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lecturerNameMustContainNonWhiteSpaceCharacters()
    {
        final String name = "Test";
        final String lecturer = " ";
        Module m = new Module(name, lecturer);
    }

    @Test
    public void itIsPossibleToAddGradesToModule()
    {
        final String name = "Test";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);
        assertEquals(0, m.getGrades().size());

        Grade g = new GradeZp(5, 5, LocalDateTime.parse("2022-01-01T00:00:00"));
        m.addGrade(g);
        assertEquals(1, m.getGrades().size());
        assertEquals(g, m.getGrades().get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itNotIsPossibleToDeleteGradesFromEmptyListTo()
    {
        final String name = "Test";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);
        assertEquals(0, m.getGrades().size());
        m.remove(0);
    }

    @Test
    public void itsIsPossibleToDeleteGradesFromList()
    {
        final String name = "Test";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);
        assertEquals(0, m.getGrades().size());
        Grade g = new GradeLb(5, 5, LocalDateTime.parse("2022-01-01T00:00:00"));
        m.addGrade(g);
        assertEquals(1, m.getGrades().size());
        assertEquals(g, m.getGrades().get(0));
        m.remove(0);
        assertEquals(0, m.getGrades().size());
    }


    @Test
    public void AvargeOneGradeIsSelf()
    {
        final String name = "Test";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);

        Grade g = new GradeLb(5, 5, LocalDateTime.parse("2022-01-01T00:00:00"));
        m.addGrade(g);
        assertEquals(5, m.average(), 0);

        m.remove(0);
        g = new GradeLb(3, 5, LocalDateTime.parse("2022-01-01T00:00:00"));
        m.addGrade(g);
        assertEquals(3, m.average(), 0);
    }

    @Test
    public void AvargeTwoGrades()
    {
        final String name = "Test";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);

        Grade g1 = new GradeLb(5, 5, LocalDateTime.parse("2022-01-01T00:00:00"));
        Grade g2 = new GradeLb(3, 5, LocalDateTime.parse("2022-01-01T00:00:00"));
        m.addGrade(g1);
        m.addGrade(g2);
        assertEquals(4, m.average(), 0);
    }

    @Test
    public void AvargeWeights()
    {
        final String name = "Test";
        final String lecturer = "Thomas Bach";
        Module m = new Module(name, lecturer);

        Grade g1 = new GradeLb(5, 2, LocalDateTime.parse("2022-01-01T00:00:00"));
        Grade g2 = new GradeLb(3, 6, LocalDateTime.parse("2022-01-01T00:00:00"));
        m.addGrade(g1);
        m.addGrade(g2);
        assertEquals(3.5, m.average(), 1);
    }
  
}