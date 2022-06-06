package Management;

import java.time.LocalDateTime;
/**
 * @author Patrick Stössel
 *
 */

/**
 * Kind Klasse Grade Lb Elternklasse Grade
 *
 */
public class GradeLb extends Grade
{
    /**
     * Noten Konstruktor Übergabe
     *
     * @param float value
     * @param float weight
     * @param LocalDateTime date
     */
    public GradeLb(double value, double weight, LocalDateTime date)
    {
        super(value, weight, date);
    }

    @Override
    public String getTypeName()
    {
        return "Leistungsbeurteilung";
    }
}
