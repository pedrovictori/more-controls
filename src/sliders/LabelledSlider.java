package sliders;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class LabelledSlider extends GridPane {
	@FXML Slider slider;
	@FXML Label lStart;
	@FXML Label lEnd;
	@FXML Label lValue;

	public LabelledSlider(double min, double max, double value) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"ls-horizontal.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} 

		catch (IOException exception) {
			throw new RuntimeException(exception);
		}
		
		slider.setMax(max);
		slider.setMin(min);
		slider.setValue(value);
		lStart.setText(Double.toString(min));
		lEnd.setText(Double.toString(max));
		lValue.setText(Double.toString(value));

		slider.setMajorTickUnit(max/10);
		slider.setSnapToTicks(true);
		slider.setMinorTickCount(0); 


		//add event to slider so it will update its value in the label
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {		
				lValue.setText(String.format("%.0f",new_val));
			}
		});
	}

	/**
	 * Return the slider wrapped inside this Control
	 * @return the Slider instance inside this Control
	 */
	public Slider getSlider() {
		return slider;
	}
}
