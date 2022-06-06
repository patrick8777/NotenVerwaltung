package Management;

import java.time.LocalDateTime;

/**
 * @author Patrick St�ssel
 *
 */

/**
 * Kind Klasse Grade zp Elternklasse Grade
 *
 */
public class GradeZp extends Grade
{
    /**
     * Noten Konstruktor �bergabe
     *
     * @param value
     * @param weight
     * @param date
     */
    public GradeZp(double value, double weight, LocalDateTime date)
    {
        super(value, weight, date);
    }

    @Override
    public String getTypeName()
    {
        return "Zwischenpr�fung";
    }
}
