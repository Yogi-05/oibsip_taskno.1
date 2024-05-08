package com.oasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LengthActivity extends AppCompatActivity {

    private EditText editTextValue;
    private Spinner spinnerInputUnit;
    private Spinner spinnerOutputUnit;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        // Initialize views
        editTextValue = findViewById(R.id.editTextMeters);
        spinnerInputUnit = findViewById(R.id.spinnerInputUnits);
        spinnerOutputUnit = findViewById(R.id.spinnerOutputUnits);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        // Populate input unit spinner
        ArrayAdapter<CharSequence> inputUnitAdapter = ArrayAdapter.createFromResource(this,
                R.array.length_units, android.R.layout.simple_spinner_item);
        inputUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInputUnit.setAdapter(inputUnitAdapter);
        // Add hint text as the first item
        spinnerInputUnit.setSelection(0, false); // Select hint text item without triggering onItemSelected listener

        // Populate output unit spinner
        ArrayAdapter<CharSequence> outputUnitAdapter = ArrayAdapter.createFromResource(this,
                R.array.length_units, android.R.layout.simple_spinner_item);
        outputUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOutputUnit.setAdapter(outputUnitAdapter);
        // Add hint text as the first item
        spinnerOutputUnit.setSelection(0, false); // Select hint text item without triggering onItemSelected listener

        // Set OnClickListener for the Convert button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the value from EditText and convert it to string
                String valueString = editTextValue.getText().toString();

                // Check if the input is not empty
                if (!valueString.isEmpty()) {
                    // Convert the string value to double
                    double value = Double.parseDouble(valueString);

                    // Get the selected units from the spinners
                    String inputUnit = spinnerInputUnit.getSelectedItem().toString();
                    String outputUnit = spinnerOutputUnit.getSelectedItem().toString();

                    // Perform conversion
                    double convertedValue = convert(value, inputUnit, outputUnit);

                    // Set the result to TextView
                    textViewResult.setText(String.format("%.2f %s is %.2f %s", value, inputUnit, convertedValue, outputUnit));
                } else {
                    // If input is empty, display an error message
                    textViewResult.setText("Please enter a value");
                }
            }
        });
    }

    // Method to perform conversion based on selected units
    private double convert(double value, String inputUnit, String outputUnit) {
        // Check if the input unit is "Select Unit"
        if (inputUnit.equals(getString(R.string.select_unit)) || outputUnit.equals(getString(R.string.select_unit))) {
            // Prompt the user to choose input and output units
            textViewResult.setText("Please choose both input and output units");
            return 0; // Return 0 as a placeholder
        }

        // Add conversion logic based on input and output units
        // For simplicity, let's assume conversion factors for different units

        // Add more conversion factors for other units as needed
        double conversionFactor = 1.0; // Default value if same units are selected

        // Conversion factors for different units
        //meter to kilometers
        if (inputUnit.equals("Meters") && outputUnit.equals("Kilometers")) {
            conversionFactor = 0.001;
        }
        //kilometers to meters
        else if (inputUnit.equals("Kilometers") && outputUnit.equals("Meters")) {
            conversionFactor = 1000;
        }
        //meter to centimeters
        else if (inputUnit.equals("Meters") && outputUnit.equals("Centimeters")) {
            conversionFactor = 100;
        }
        //centimeters to meters
        else if (inputUnit.equals("Centimeters") && outputUnit.equals("Meters")) {
            conversionFactor = 0.01;
        }
        //meter to millimeters
        else if (inputUnit.equals("Meters") && outputUnit.equals("Millimeters")) {
            conversionFactor = 1000;
        }
        //millimeters to meters
        else if (inputUnit.equals("Millimeters") && outputUnit.equals("Meters")) {
            conversionFactor = 0.001;
        }
        //kilometers to centimeters
        else if (inputUnit.equals("Kilometers") && outputUnit.equals("Centimeters")) {
            conversionFactor = 100000;
        }
        //centimeters to kilometers
        else if (inputUnit.equals("Centimeters") && outputUnit.equals("Kilometers")) {
            conversionFactor = 0.00001;
        }
        //kilometers to millimeters
        else if (inputUnit.equals("Kilometers") && outputUnit.equals("Millimeters")) {
            conversionFactor = 1000000;
        }
        //millimeters to kilometers
        else if (inputUnit.equals("Millimeters") && outputUnit.equals("Kilometers")) {
            conversionFactor = 0.000001;
        }
        //centimeters to millimeters
        else if (inputUnit.equals("Centimeters") && outputUnit.equals("Millimeters")) {
            conversionFactor = 10;
        }
        //millimeters to centimeters
        else if (inputUnit.equals("Millimeters") && outputUnit.equals("Centimeters")) {
            conversionFactor = 0.1;
        }
        //yard to meters
        else if (inputUnit.equals("Yards") && outputUnit.equals("Meters")) {
            conversionFactor = 0.9144;
        }
        //meters to yards
        else if (inputUnit.equals("Meters") && outputUnit.equals("Yards")) {
            conversionFactor = 1.09361;
        }
        //yard to feet
        else if (inputUnit.equals("Yards") && outputUnit.equals("Feet")) {
            conversionFactor = 3;
        }
        //feet to yards
        else if (inputUnit.equals("Feet") && outputUnit.equals("Yards")) {
            conversionFactor = 0.333333;
        }
        //yard to inches
        else if (inputUnit.equals("Yards") && outputUnit.equals("Inches")) {
            conversionFactor = 36;
        }
        //inches to yards
        else if (inputUnit.equals("Inches") && outputUnit.equals("Yards")) {
            conversionFactor = 0.0277778;
        }
        //feet to meters
        else if (inputUnit.equals("Feet") && outputUnit.equals("Meters")) {
            conversionFactor = 0.3048;
        }
        //meters to feet
        else if (inputUnit.equals("Meters") && outputUnit.equals("Feet")) {
            conversionFactor = 3.28084;
        }
        //feet to inches
        else if (inputUnit.equals("Feet") && outputUnit.equals("Inches")) {
            conversionFactor = 12;
        }
        //inches to feet
        else if (inputUnit.equals("Inches") && outputUnit.equals("Feet")) {
            conversionFactor = 0.0833333;
        }
        //inches to meters
        else if (inputUnit.equals("Inches") && outputUnit.equals("Meters")) {
            conversionFactor = 0.0254;
        }
        //meters to inches
        else if (inputUnit.equals("Meters") && outputUnit.equals("Inches")) {
            conversionFactor = 39.3701;
        }
        //mile to kilometers
        else if (inputUnit.equals("Miles") && outputUnit.equals("Kilometers")) {
            conversionFactor = 1.60934;
        }
        //kilometers to miles
        else if (inputUnit.equals("Kilometers") && outputUnit.equals("Miles")) {
            conversionFactor = 0.621371;
        }
        //mile to meters
        else if (inputUnit.equals("Miles") && outputUnit.equals("Meters")) {
            conversionFactor = 1609.34;
        }
        //meters to miles
        else if (inputUnit.equals("Meters") && outputUnit.equals("Miles")) {
            conversionFactor = 0.000621371;
        }
        //mile to feet
        else if (inputUnit.equals("Miles") && outputUnit.equals("Feet")) {
            conversionFactor = 5280;
        }
        //feet to miles
        else if (inputUnit.equals("Feet") && outputUnit.equals("Miles")) {
            conversionFactor = 0.000189394;
        }
        //mile to inches
        else if (inputUnit.equals("Miles") && outputUnit.equals("Inches")) {
            conversionFactor = 63360;
        }
        //inches to miles
        else if (inputUnit.equals("Inches") && outputUnit.equals("Miles")) {
            conversionFactor = 1.57828e-5;
        }
        //mile to yards
        else if (inputUnit.equals("Miles") && outputUnit.equals("Yards")) {
            conversionFactor = 1760;
        }
        //yards to miles
        else if (inputUnit.equals("Yards") && outputUnit.equals("Miles")) {
            conversionFactor = 0.000568182;
        }
        //feet to centimeters
        else if (inputUnit.equals("Feet") && outputUnit.equals("Centimeters")) {
            conversionFactor = 30.48;
        }
        //centimeters to feet
        else if (inputUnit.equals("Centimeters") && outputUnit.equals("Feet")) {
            conversionFactor = 0.0328084;
        }
        //feet to millimeters
        else if (inputUnit.equals("Feet") && outputUnit.equals("Millimeters")) {
            conversionFactor = 304.8;
        }
        //millimeters to feet
        else if (inputUnit.equals("Millimeters") && outputUnit.equals("Feet")) {
            conversionFactor = 0.00328084;
        }
        //inches to centimeters
        else if (inputUnit.equals("Inches") && outputUnit.equals("Centimeters")) {
            conversionFactor = 2.54;
        }
        //centimeters to inches
        else if (inputUnit.equals("Centimeters") && outputUnit.equals("Inches")) {
            conversionFactor = 0.393701;
        }
        //inches to millimeters
        else if (inputUnit.equals("Inches") && outputUnit.equals("Millimeters")) {
            conversionFactor = 25.4;
        }
        //millimeters to inches
        else if (inputUnit.equals("Millimeters") && outputUnit.equals("Inches")) {
            conversionFactor = 0.0393701;
        }
        //mile to centimeters
        else if (inputUnit.equals("Miles") && outputUnit.equals("Centimeters")) {
            conversionFactor = 160934;
        }
        //centimeters to miles
        else if (inputUnit.equals("Centimeters") && outputUnit.equals("Miles")) {
            conversionFactor = 6.2137e-6;
        }
        //mile to millimeters
        else if (inputUnit.equals("Miles") && outputUnit.equals("Millimeters")) {
            conversionFactor = 1609340;
        }
        //millimeters to miles
        else if (inputUnit.equals("Millimeters") && outputUnit.equals("Miles")) {
            conversionFactor = 6.2137e-7;
        }
        //yard to centimeters
        else if (inputUnit.equals("Yards") && outputUnit.equals("Centimeters")) {
            conversionFactor = 91.44;
        }
        //centimeters to yards
        else if (inputUnit.equals("Centimeters") && outputUnit.equals("Yards")) {
            conversionFactor = 0.0109361;
        }
        //yard to millimeters
        else if (inputUnit.equals("Yards") && outputUnit.equals("Millimeters")) {
            conversionFactor = 914.4;
        }
        //millimeters to yards
        else if (inputUnit.equals("Millimeters") && outputUnit.equals("Yards")) {
            conversionFactor = 0.00109361;
        }


        // Perform conversion
        return value * conversionFactor;
    }
}
