package Management;

/**
 * Importieren LocalDatime und package Management
 *
 */
import java.time.LocalDateTime;

/**
 * @author Patrick Stössel
 *
 */
/**
 * Die Grade Eltern-Klasse für GradeLb & GradeZp Kind für die Notenbrechnung
 * 
 */

public abstract class Grade {
	/**
	 * Varibalen deklariert
	 * Variablen value Variable weight und date
	 */
	private double value = 0;
	private double weight = 0;
	private LocalDateTime date;
	
	/**
	 * enum Konstante Type Wert bleibt gleich
	 *
	 */
	public enum Type {
		ZP, LB
	}

	/**
	 * Noten Konstruktor übergabe
	 * 
	 * @param value
	 * @param weight
	 * @param date
	 */
	protected Grade(double value, double weight, LocalDateTime date) {
		setValue(value);
		setWeight(weight);
		setDate(date);
	}

	/**
	 * Wert muss zwischen 1-6 sein gesetzt Value float
	 * 
	 * @param value
	 */
	private void setValue(double value) {
		if (value < 1 || value > 6) {
			throw new IllegalArgumentException("Value must be between 1 and 6, " + value + " given.");
		}
		this.value = value;
	}

	/**
	 * Gibt value zurück Datentype float
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Gibt weight zurück Datentype float
	 * 
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Gibt type name zurück Datentype String switch und case für checkbox und Jlist
	 * 
	 * @return Typname der Note
	 */
	abstract public String getTypeName();

	/**
	 * Gewichtung setzen muss zwischen 0-100 sein.
	 * 
	 * @param weight
	 */
	private void setWeight(double weight) {
		if (weight <= 0) {
			throw new IllegalArgumentException("Weight must be positive, " + weight + " given.");
		}
		this.weight = weight;
	}

	/**
	 * Gibt die Zeit zurück date LocalDateTime
	 * 
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Setze Date Zeit muss in der Vergangenheit sein deshalb Zeit jetzt -5 kann ich
	 * ,keine Note eingeben die in der Zukunft ist.
	 * 
	 * @param date
	 */
	private void setDate(LocalDateTime date) {
		if (date.compareTo(LocalDateTime.now().minusSeconds(5)) >= 0) {
			throw new IllegalArgumentException("Date must be in the past, " + date + " given");
		}
		this.date = date;
	}

	public static Grade create(double value, double weight, LocalDateTime date, Type type) {
		switch (type) {
		case ZP:
			return new GradeZp(value, weight, date);
		case LB:
			return new GradeLb(value, weight, date);
		default:
			throw new IllegalArgumentException(type.name());
		}
	}
}
