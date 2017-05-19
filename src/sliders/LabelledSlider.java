package sliders;

import java.io.IOException;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class LabelledSlider extends GridPane {
	@FXML private Slider slider;
	@FXML private Label lStart;
	@FXML private Label lEnd;
	@FXML private Label lValue;
	
	public LabelledSlider() {
		this(10);
	}
	
	/**
	 * Creates a new LabelledSlider, using 0 as minimum and default value.
	 * @param max maximum value for the slider
	 */
	public LabelledSlider (double max) {
		this(0, max);
	}
	
	/**
	 * Creates a new LabelledSlider, using the given minimum value as the default value.
	 * @param min minimum value for the slider
	 * @param max maximum value for the slider
	 */
	public LabelledSlider(double min, double max) {
		this(min, max, min);
	}
	
	/**
	 * Creates a new LabelledSlider
	 * @param min minimum value for the slider
	 * @param max maximum value for the slider
	 * @param value default value for the slider
	 */
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
		
		setMax(max);
		setMin(min);
		setValue(value);

		setMajorTickUnit(max/10);
		setSnapToTicks(true);
		setMinorTickCount(0); 


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

	
	public DoubleProperty maxProperty() {
		return slider.maxProperty();
	}

	public void setMax(Double max) {
		lEnd.setText(Integer.toString(max.intValue()));
		maxProperty().set(max);
	}
	
	public Double getMax() {
		return maxProperty().get();
	}

	
	public DoubleProperty minProperty() {
		return slider.minProperty();
	}

	public void setMin(Double min) {
		lStart.setText(Integer.toString(min.intValue()));
		minProperty().set(min);
	}
	
	public Double getMin() {
		return minProperty().get();
	}

	
	public DoubleProperty valueProperty() {
		return slider.valueProperty();
	}

	public void setValue(Double value) {
		lValue.setText(String.format("%.0f",value));
		valueProperty().set(value);
	}
	
	public Double getValue() {
		return valueProperty().get();
	}

	public DoubleProperty majorTickUnitProperty() {
		return slider.majorTickUnitProperty();
	}

	public void setMajorTickUnit(Double majorTickUnit) {
		majorTickUnitProperty().set(majorTickUnit);
	}
	
	public Double getMajorTickUnit() {
		return majorTickUnitProperty().get();
	}
	
	
	public IntegerProperty minorTickCountProperty() {
		return slider.minorTickCountProperty();
	}

	public void setMinorTickCount(Integer minorTickCount) {
		minorTickCountProperty().set(minorTickCount);
	}
	
	public Integer getMinorTickCount() {
		return minorTickCountProperty().get();
	}
	
	
	public BooleanProperty snapToTicksProperty() {
		return slider.snapToTicksProperty();
	}
	
	public void setSnapToTicks(Boolean snapToTicks) {
		snapToTicksProperty().set(snapToTicks);
	}
	
	public Boolean getSnapToTicks() {
		return snapToTicksProperty().get();
	}
}
