package Management;

import java.time.LocalDateTime;

/**
 * @author Patrick Stössel
 *
 */

/**
 * Kind Klasse Grade zp Elternklasse Grade
 *
 */
public class GradeZp extends Grade
{
    /**
     * Noten Konstruktor Übergabe
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
        return "Zwischenprüfung";
    }
}
