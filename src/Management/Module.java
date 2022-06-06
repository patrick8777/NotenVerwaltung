package Management;
/**
 * Importieren Java ArrList,Java list,Management.Grade und package Management
 *
 */
import java.util.ArrayList;
import java.util.List;
import Management.Grade;
/**
 * @author Patrick Stössel
 *
 */

/**
 * Klasse Module für Module & Fächer
 *
 */
public class Module {
	/**
	 * Varible und ArraList Grade
	 */
	private String name;
	private String lecturer;
	private ArrayList<Grade> grades;
	public float average;

	/**
	 * Konstruktor Module setzen Name des Modul
	 * 
	 * @param name
	 * @param lecturer
	 */
	public Module(String name, String lecturer) {
		setName(name);
		setLecturer(lecturer);
		grades = new ArrayList<Grade>();
	}

	/**
	 * Arraylist Noten zurückgabe
	 * 
	 * @return
	 */
	public ArrayList<Grade> getGrades() {
		return grades;
	}

	/**
	 * Gibt den Namen zurück
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setze Modul Name auch für den JUnit test
	 * 
	 * @param name
	 */
	private void setName(String name) {
		if (name.trim().isEmpty()) {
			throw new IllegalArgumentException("Module name must not be empty.");
		}
		this.name = name;
	}

	/**
	 * Gibt den Dozenten zurück
	 * 
	 * @return
	 */
	public String getLecturer() {
		return lecturer;
	}

	/**
	 * Setze den Doztennamen er muss nicht gleich sein ist auch für den JUnit test
	 * 
	 * @param lecturer
	 */
	private void setLecturer(String lecturer) {
		if (lecturer.trim().isEmpty()) {
			throw new IllegalArgumentException("Lecturer name must not be empty.");
		}
		this.lecturer = lecturer;
	}

	public void addGrade(Grade grade) {
		grades.add(grade);
	}

	/**
	 * Die Berechung für den Durchschnitt der ZP und LB
	 * 
	 * @return
	 */
	public double calculateAverage() {
		double sum = 0;
		double weight = 0;

		for (int i = 0; i < grades.size(); i++) {
			sum += (grades.get(i).getValue() * grades.get(i).getWeight());
			weight += (grades.get(i).getWeight() * 1);
		}
		
		double result = (double) (Math.ceil((sum / (weight)) * 100) / 100);
		System.out.println(result);
		return result >=1 ? result : 1;
	}

	/**
	 * Printet die Durchschnittnote aus.
	 */
	public void printGrades() {
		for (int i = 0; i < grades.size(); i++) {
			if (grades != null) {
				System.out.println(grades.get(i).getValue());

			}
		}
	}

	/**
	 * Noten löschen funktion
	 * 
	 * @param i
	 */
	public void remove(int i) {
		grades.remove(i);
	}

	/**
	 * Vereinfachte Notendurchschnittsberechung
	 * 
	 * @return zurück Summe durch Note
	 */
	public double average() {
		double sum = 0;
		double weight = 0;

		for (Grade grade : grades) {
			sum += grade.getValue();
			weight += grade.getWeight();
		}
		return sum / (grades.size());
	}
}
