/**
 * Import package Controller
 *
 */
package Controller;

/**
 * Import Java Swing und Grade,GradeZp und Module
 *
 */
import Management.Grade;
import Management.GradeZp;
import Management.Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Patrick Stössel
 */

/**
 * Application Elternklasse
 *
 */
public class Application extends JFrame {
	private JTextField textFieldGradeInput;
	private static ArrayList<Module> modules = new ArrayList<Module>();
	private JTextField textFieldFinalGrade;
	private String currentModuleStr;

	/**
	 * Fügt alle Module zum modules arraylist hinzu
	 *
	 */
	public static void AddBulkToArrayList(Module[] mods) {
		for (int i = 0; i < mods.length; i++) {
			modules.add(mods[i]);
		}
	}

	/**
	 * Aktualsiert die verschiedene design Elemente
	 *
	 */
	public static void updateComboBox(String name, DefaultListModel model, JTextField averageField) {
		for (int i = 0; i < modules.size(); i++) {
			if (modules.get(i).getName() == name) {
				model.clear();
				List<Grade> grades = modules.get(i).getGrades();
				averageField.setText(Double.toString(modules.get(i).calculateAverage()));

				for (int j = 0; j < grades.size(); j++) {
					model.addElement(grades.get(j).getValue() + " | " + grades.get(j).getTypeName());
				}
			}
		}
	}

	/**
	 * Start der Applikation
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/**
		 * Erstellen der Fächern und Module
		 */
		Module mathe = new Module("Mathematik", "Christoff Kurrer");
		mathe.addGrade(new GradeZp(4.0f, 30, LocalDateTime.of(2022, 5, 27, 0, 0)));
		Module eng = new Module("Englisch", "Fabienne");
		Module physik = new Module("Physik", "Christoff Kurrer");
		Module wundr = new Module("Wirtschaft & Recht", "Freddy");
		Module m100 = new Module("Daten charakterisieren", "Urs Bryner");
		Module m101 = new Module("Webauftritt erstellen", "Sven Schirmer");
		Module m104 = new Module("Datenmodell implementieren", "Sven Schirmer");
		Module m105 = new Module("Datenbanken mit SQL bearbeiten", "Sven Schirmer");
		Module m114 = new Module("Codierungsverfahren einsetzen", "Urs Bryner");
		Module m117 = new Module("Netzinfrastruktur realisieren", "Urs Bryner");
		Module m120 = new Module("Benutzerschnittstellen impl.", "ff");
		Module m121 = new Module("Steuerungsaufgaben bearb.", "Urs Bryner");
		Module m122 = new Module("Abläufe mit Scripts/Makros", "Ralph Kabourek");
		Module m123 = new Module("Serverdienste in Betrieb nehmen", "Thomas Houska");
		Module m126 = new Module("Peripheriegeräte einsetzen", "Urs Bryner");
		Module m129 = new Module("LAN-Komponenten in Betrieb n.", "Ralph Kabourek");
		Module m133 = new Module("Web-Applikation realisieren ", "Urs Bryner");
		Module m150 = new Module("E-Business-Applikationen anp.", "Sven Schirmer");
		Module m151 = new Module("DB in Web-Applikation einbind. ", "ff");
		Module m152 = new Module("Multimedia-Inhalte i. Webauftritt", "Urs Bryner");
		Module m153 = new Module("Datenmodelle entwickeln", "Urs Bryner");
		Module m214 = new Module("Benutzer instruieren", "Urs Bryner");
		Module m226a = new Module("Klassenbasiert implementieren", "Sven Schirmer");
		Module m226b = new Module("Objektorientiert implementieren", "Sven Schirmer");
		Module m242 = new Module("Microprozessoranw. realisieren", "Urs Bryner");
		Module m260 = new Module("Office Werkz. praxisor. einsetzen", "Leemmann");
		Module m261 = new Module("Funktion von ICT-Endger. gewähr. ", "Urs Rechtsteiner");
		Module m262 = new Module("Evaluation von ICT-Mitteln durchf", "Leemann");
		Module m263 = new Module("Sicherheit von ICT-Endger. gewähr.", "Urs Bryner");
		Module m302 = new Module("Fortgeschr. Funktionen Office", "Peter Spreger");
		Module m304 = new Module("PC in Betrieb nehmen", "Urs Bryner");
		Module m305 = new Module("Betriebssysteme install adm.", "Thomas Houska");
		Module m306 = new Module("IT Kleinprojekt abwickeln", "Urs Rechtsteiner");
		Module m307 = new Module("Interaktive Webseite erstellen.", "Sven Schirmer");
		Module m335 = new Module("Mobile-Applikation realisieren.", "Peter Spreger");
		Module m407 = new Module("Im Support arbeiten", "Urs Rechtsteiner");
		Module m431 = new Module("IT-Aufträge selbst. durchführen", "Peter Spreger");

		/**
		 * Module und Fächer hinzufügen in die ArrayList
		 */
		AddBulkToArrayList(new Module[] { eng, mathe, physik, wundr, m100, m101, m105, m114, m117, m120, m121, m122,
				m123, m133, m151, m152, m153, m214, m226a });
	}

	/**
	 * Erzeugt das Fenster mit Hintergrund und Noten Titel und icon
	 */
	public Application() {
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBackground(new Color(0, 0, 153));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.class.getResource("/img/PST_logo.png")));
		setTitle("Notenverwaltung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 418);
		getContentPane().setLayout(null);

		/**
		 * TextfeldEndnote ist nicht veränderbar
		 */
		textFieldFinalGrade = new JTextField();
		textFieldFinalGrade.setEditable(false);
		textFieldFinalGrade.setBounds(404, 85, 41, 20);
		getContentPane().add(textFieldFinalGrade);
		textFieldFinalGrade.setColumns(10);

		/**
		 * DefaultListModel enthält alle list elemente
		 */
		DefaultListModel model = new DefaultListModel();

		/**
		 * Jlist ist die Liste für die Ausgabe der Zp und Lb Noten
		 */
		JList list = new JList(model);
		list.setBounds(12, 118, 501, 117);
		getContentPane().add(list);

		/**
		 * Label Notenverwaltung
		 */
		JLabel lblNotenverwaltung = new JLabel("Pers\u00F6nliche Notenverwaltung");
		lblNotenverwaltung.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNotenverwaltung.setBounds(142, 12, 287, 25);
		getContentPane().add(lblNotenverwaltung);

		JComboBox moduleComboBox = new JComboBox();

		/**
		 * addItemListener ist mein Action listener für Hinzufügen der Module
		 */
		moduleComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String name = (String) e.getItem();

				updateComboBox(name, model, textFieldFinalGrade);
			}
		});

		moduleComboBox.setBounds(142, 84, 257, 22);
		getContentPane().add(moduleComboBox);
		for (int i = 0; i < modules.size(); i++) {
			moduleComboBox.addItem(modules.get(i).getName());
		}

		/**
		 * Label für Textfeld Noten hinzufügen
		 *
		 */
		JLabel lblAddGrade = new JLabel("Note hinzuf\u00FCgen");
		lblAddGrade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddGrade.setBounds(219, 236, 118, 16);
		getContentPane().add(lblAddGrade);

		/**
		 * Select box für LB und ZP
		 *
		 */
		JComboBox gradeTypeCombobox = new JComboBox();
		gradeTypeCombobox.setBounds(229, 255, 48, 22);
		getContentPane().add(gradeTypeCombobox);
		gradeTypeCombobox.addItem("ZP");
		gradeTypeCombobox.addItem("LB");

		/**
		 * Textfeld für die Noten eingabe
		 */
		textFieldGradeInput = new JTextField();
		textFieldGradeInput.setBounds(285, 255, 41, 22);
		getContentPane().add(textFieldGradeInput);
		textFieldGradeInput.setColumns(10);

		/**
		 * Label Beschriftungstitel für Module & Fächer
		 */
		JLabel lblModule = new JLabel("F\u00E4cher & Module");
		lblModule.setFont(new Font("Dialog", Font.BOLD, 14));
		lblModule.setBounds(207, 63, 130, 16);
		getContentPane().add(lblModule);

		/**
		 * JComBox DrowDown Menu für die Gewichtung
		 */
		JComboBox gradeWeightsCombobox = new JComboBox();
		gradeWeightsCombobox.setBounds(162, 255, 56, 22);
		getContentPane().add(gradeWeightsCombobox);
		gradeWeightsCombobox.addItem("20");
		gradeWeightsCombobox.addItem("30");
		gradeWeightsCombobox.addItem("40");
		gradeWeightsCombobox.addItem("50");
		gradeWeightsCombobox.addItem("60");
		gradeWeightsCombobox.addItem("70");
		gradeWeightsCombobox.addItem("80");
		gradeWeightsCombobox.addItem("100");

		/**
		 * Absenden Button für die Noteneingabe Mit Regex das nur bestimmte Werte
		 * übergben können. Z.B keine Buchstaben
		 */
		JButton btnSubmitGrade = new JButton("Absenden");
		btnSubmitGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double grade = textFieldGradeInput.getText().length() > 0
						&& textFieldGradeInput.getText().matches("[+-]?([0-9]*[.])?[0-9]+")
								? Double.parseDouble(textFieldGradeInput.getText())
								: 0;
				/**
				 * Die eingegebene Note muss zwischen 1-6 sein.
				 */
				if (textFieldGradeInput.getText().length() > 0 && (grade > 0 && grade < 7)) {
					String module = (String) moduleComboBox.getSelectedItem();
					double weight = Double.parseDouble((String) gradeWeightsCombobox.getSelectedItem());
					Grade.Type type = (String) gradeTypeCombobox.getSelectedItem() == "ZP" ? Grade.Type.ZP
							: Grade.Type.LB;

					/**
					 * Modul hinzufügen
					 */
					Module currentModule = findModule(module);
					Grade g = Grade.create(grade, weight, LocalDateTime.of(2022, 5, 27, 0, 0), type);
					currentModule.addGrade(g);
					updateComboBox(module, model, textFieldFinalGrade);
				}
			}
		});

		btnSubmitGrade.setBounds(338, 254, 91, 25);
		getContentPane().add(btnSubmitGrade);

		/**
		 * Button löschen löscht nur in der Liste die ausgewählte Note
		 */
		JButton btnDelete = new JButton("L\u00F6schen");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 69, 0));
		btnDelete.setBounds(228, 302, 90, 25);
		getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedGrade = list.getSelectedIndex();
				if (selectedGrade == -1) {
					return;
				}

				String module = (String) moduleComboBox.getSelectedItem();
				Module activeModule = findModule((String) moduleComboBox.getSelectedItem());

				activeModule.remove(selectedGrade);
				model.remove(selectedGrade);

				updateComboBox(module, model, textFieldFinalGrade);
			}
		});

		/**
		 * Label für Note zu entfernen
		 */
		JLabel lblGradeDelete = new JLabel("Note entfernen");
		lblGradeDelete.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGradeDelete.setBounds(219, 279, 118, 25);
		getContentPane().add(lblGradeDelete);

		/**
		 * Label für Noten Gewichtung
		 */
		JLabel lblWeighting = new JLabel("Gew.");
		lblWeighting.setFont(new Font("Dialog", Font.BOLD, 14));
		lblWeighting.setBounds(125, 257, 35, 16);
		getContentPane().add(lblWeighting);

		/**
		 * Label für die Endnote ist einfach die Beschriftung
		 */
		JLabel lbZpLbEndnote = new JLabel("Endnote");
		lbZpLbEndnote.setFont(new Font("Dialog", Font.BOLD, 14));
		lbZpLbEndnote.setBounds(396, 63, 67, 16);
		getContentPane().add(lbZpLbEndnote);

	}

	/**
	 * Findet ein modul beim Name wenn es bereits existiert
	 *
	 */
	private Module findModule(String module) {
		for (Module currentModule : modules) {
			if (currentModule.getName() == module) {
				return currentModule;
			}
		}
		return null;
	}

	/**
	 * Für den Mockup Test einen boolean
	 *
	 */
	public boolean checkGradeInput(JTextField textField) {
		Pattern GradePattern = Pattern.compile("[+-]?([1-6]*[.]*)?[1-6]+");

		Matcher match = GradePattern.matcher(textField.getText());

		return match.matches();

	}
}
