/**
 * Sample Skeleton for 'Untitled' Controller Class
 */

package it.polito.tdp.rivers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RiversController {

	private Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="boxRiver"
	private ComboBox<River> boxRiver; // Value injected by FXMLLoader

	@FXML // fx:id="txtStartDate"
	private TextField txtStartDate; // Value injected by FXMLLoader

	@FXML // fx:id="txtEndDate"
	private TextField txtEndDate; // Value injected by FXMLLoader

	@FXML // fx:id="txtNumMeasurements"
	private TextField txtNumMeasurements; // Value injected by FXMLLoader

	@FXML // fx:id="txtFMed"
	private TextField txtFMed; // Value injected by FXMLLoader

	@FXML // fx:id="txtK"
	private TextField txtK; // Value injected by FXMLLoader

	@FXML // fx:id="btnSimula"
	private Button btnSimula; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCompila(ActionEvent event) {
		txtResult.clear();
		try {
			if (boxRiver.getValue() == null) {
				txtResult.appendText("Errore. Effettua una selezione.");
			}
			River river = boxRiver.getValue();

			txtStartDate.setText(model.getFirstDate(river).toString());
			txtEndDate.setText(model.getLastDate(river).toString());
			txtNumMeasurements.setText(String.format("%d", river.getFlows().size()));
			txtFMed.setText(String.format("%f", model.getAvgFlow(river)));

		} catch (RuntimeException e) {
			txtResult.setText("Errore!!!");
		}
	}

	@FXML
	void doSimula(ActionEvent event) {
		txtResult.clear();
		try {

		} catch (RuntimeException e) {
			txtResult.setText("Errore!!!");
		}
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Untitled'.";
		assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Untitled'.";
		assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Untitled'.";
		assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Untitled'.";
		assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Untitled'.";
		assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Untitled'.";
		assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Untitled'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Untitled'.";
	}

	public void setModel(Model m) {
		this.model = m;
		boxRiver.getItems().addAll(model.getAllRivers());
	}
}
