package edu.harrisburgu.cisc349.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private Integer currentTotal = null;
    private String currentOperation = null;
    private boolean startNewNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        setupButtons();
    }

    private void setupButtons() {
        // Setup digit buttons
        int[] digitButtons = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9
        };
        for (int id : digitButtons) {
            Button button = findViewById(id);
            button.setOnClickListener(v -> onDigitPressed(button.getText().toString()));
        }

        // Setup operation buttons
        findViewById(R.id.buttonPlus).setOnClickListener(v -> onOperationPressed("+"));
        findViewById(R.id.buttonMinus).setOnClickListener(v -> onOperationPressed("-"));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> onOperationPressed("*"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> onOperationPressed("/"));

        // Setup equals button
        findViewById(R.id.buttonEquals).setOnClickListener(v -> onEqualsPressed());

        // Setup clear button
        findViewById(R.id.buttonClear).setOnClickListener(v -> clearCalculator());
    }

    private void clearCalculator() {
        display.setText("");
        currentTotal = null;
        currentOperation = null;
        startNewNumber = true;
    }

    private void onDigitPressed(String digit) {
        if (startNewNumber || display.getText().toString().equals("0")) {
            display.setText(digit);
        } else {
            display.append(digit);
        }
        startNewNumber = false;
    }

    private void onOperationPressed(String operation) {
        try {
            int value = Integer.parseInt(display.getText().toString());
            if (currentTotal == null) {
                currentTotal = value;
            } else if (currentOperation != null) {
                calculateResult(value);
            }
            currentOperation = operation;
            startNewNumber = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
            startNewNumber = true;
        }
    }

    private void calculateResult(int secondOperand) {
        if (currentOperation == null || currentTotal == null) return;
        switch (currentOperation) {
            case "+":
                currentTotal += secondOperand;
                break;
            case "-":
                currentTotal -= secondOperand;
                break;
            case "*":
                currentTotal *= secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    currentTotal /= secondOperand;
                } else {
                    display.setText("Error");
                    clearCalculator(); // Reset calculator on error
                    return;
                }
                break;
        }
        display.setText(String.valueOf(currentTotal));
    }

    private void onEqualsPressed() {
        if (currentOperation != null && currentTotal != null) {
            try {
                int value = Integer.parseInt(display.getText().toString());
                calculateResult(value);
                currentOperation = null;
                startNewNumber = true;
            } catch (NumberFormatException e) {
                display.setText("Error");
                startNewNumber = true;
            }
        }
    }
}
