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

	
	/**
	 * The maximum value represented by this Slider.
	 *  This must be a value greater than min.
	 */
	public DoubleProperty maxProperty() {
		return slider.maxProperty();
	}
	
	/**
	 * Sets the value of the property max.
	 * @param max
	 */
	public void setMax(Double max) {
		lEnd.setText(Integer.toString(max.intValue()));
		maxProperty().set(max);
	}
	
	/**
	 * Gets the value of the property max.
	 */
	public Double getMax() {
		return maxProperty().get();
	}

	
	/**
	 * The minimum value represented by this Slider. 
	 * This must be a value less than max.
	 */
	public DoubleProperty minProperty() {
		return slider.minProperty();
	}
	
	/**
	 * Sets the value of the property min.
	 * @param min
	 */
	public void setMin(Double min) {
		lStart.setText(Integer.toString(min.intValue()));
		minProperty().set(min);
	}
	
	/**
	 * Gets the value of the property min.
	 */
	public Double getMin() {
		return minProperty().get();
	}

	/**
	 * The current value represented by this Slider. This value must always be between min and max, inclusive. 
	 * If it is ever out of bounds either due to min or max changing or due to itself being changed, then it will be clamped to always remain valid.
	 */
	public DoubleProperty valueProperty() {
		return slider.valueProperty();
	}
	
	/**
	 * Sets the value of the property value.
	 * @param value
	 */
	public void setValue(Double value) {
		lValue.setText(String.format("%.0f",value));
		valueProperty().set(value);
	}
	
	/**
	 * Gets the value of the property value.
	 */
	public Double getValue() {
		return valueProperty().get();
	}
	
	/**
	 *The unit distance between major tick marks.
	 *For example, if the min is 0 and the max is 100 and the majorTickUnit is 25, then there would be 5 tick marks: 
	 *one at position 0, one at position 25, one at position 50, one at position 75, and a final one at position 100.
	 *This value should be positive and should be a value less than the span. Out of range values are essentially the same as disabling tick marks.
	 */
	public DoubleProperty majorTickUnitProperty() {
		return slider.majorTickUnitProperty();
	}
	
	/**
	 * Sets the value of the property majorTickUnit.
	 * @param majorTickUnit
	 */
	public void setMajorTickUnit(Double majorTickUnit) {
		majorTickUnitProperty().set(majorTickUnit);
	}
	
	/**
	 * Gets the value of the property majorTickUnit.
	 */
	public Double getMajorTickUnit() {
		return majorTickUnitProperty().get();
	}
	
	/**
	 * The number of minor ticks to place between any two major ticks. 
	 * This number should be positive or zero. Out of range values will disable disable minor ticks, as will a value of zero.
	 */
	public IntegerProperty minorTickCountProperty() {
		return slider.minorTickCountProperty();
	}
	
	/**
	 * Sets the value of the property minorTickCount.
	 * @param minorTickCount
	 */
	public void setMinorTickCount(Integer minorTickCount) {
		minorTickCountProperty().set(minorTickCount);
	}
	
	/**
	 * Gets the value of the property minorTickCount.
	 */
	public Integer getMinorTickCount() {
		return minorTickCountProperty().get();
	}
	
	/**
	 * Indicates whether the value of the Slider should always be aligned with the tick marks. 
	 * This is honored even if the tick marks are not shown.
	 */
	public BooleanProperty snapToTicksProperty() {
		return slider.snapToTicksProperty();
	}
	
	/**
	 * Sets the value of the property snapToTicks.
	 * @param snapToTicks
	 */
	public void setSnapToTicks(Boolean snapToTicks) {
		snapToTicksProperty().set(snapToTicks);
	}
	
	/**
	 * Gets the value of the property snapToTicks.
	 */
	public Boolean isSnapToTicks() {
		return snapToTicksProperty().get();
	}
}
