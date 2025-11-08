package com.example.mycalculator;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final private static char PLUS = '+'; // Addition symbol
    final private static char MINUS = '-'; // Subtraction symbol
    final private static char TIMES = '×'; // Multiplication symbol
    final private static char DIVIDE = '÷'; // Division symbol

    final private static int TRUNCATE_LENGTH = 10; // Max number of symbols that can be shown on the display

    // Buttons corresponding to the digits 0 to 9
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    // Buttons corresponding to the operations and the decimal point
    Button btn_plus, btn_minus, btn_times, btn_divide, btn_equal, btn_clear, btn_dot;
    //Text display
    TextView text_display;

    // method onCreate runs at the beginning of the program
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_display = (TextView) findViewById(R.id.textview_input_display);
        initialize_buttons();
    }

    private void initialize_buttons() {
        // Linking buttons to UI
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_times = (Button) findViewById(R.id.btn_times);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_dot = (Button) findViewById(R.id.btn_dot);

        // Adding on click listeners
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_times.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                addSymbol('0');
                break;
            case R.id.btn1:
                addSymbol('1');
                break;
            case R.id.btn2:
                addSymbol('2');
                break;
            case R.id.btn3:
                addSymbol('3');
                break;
            case R.id.btn4:
                addSymbol('4');
                break;
            case R.id.btn5:
                addSymbol('5');
                break;
            case R.id.btn6:
                addSymbol('6');
                break;
            case R.id.btn7:
                addSymbol('7');
                break;
            case R.id.btn8:
                addSymbol('8');
                break;
            case R.id.btn9:
                addSymbol('9');
                break;
            case R.id.btn_dot:
                addSymbol('.');
                break;
            case R.id.btn_plus:
                addSymbol(PLUS);
                break;
            case R.id.btn_minus:
                addSymbol(MINUS);
                break;
            case R.id.btn_times:
                addSymbol(TIMES);
                break;
            case R.id.btn_divide:
                addSymbol(DIVIDE);
                break;
            case R.id.btn_equal:
                String result = null;
                try {
                    result = evaluate(text_display.getText().toString());
                    text_display.setText(result);
                } catch (Exception e) {
                    text_display.setText("Error");
                }
                break;
            case R.id.btn_clear:
                clear_display();
                break;
        }
    }

    // Evaluate string expression in display window
    public static String evaluate(String expression) throws Exception {
        String result;
        if(expression == "") // edge-case: if nothing has been input, then output 0
            result = "0";
        else {
            // Replacing chosen operator symbols with their standard representations (+,-,*, and /)
            String cleanedExpression = expression.replace(PLUS, '+').replace(MINUS, '-').replace(TIMES, '*').replace(DIVIDE, '/');
            result = MathEval.eval(cleanedExpression);
        }
        // if the string is too long to be displayed, truncate it before displaying
        if(result.length() > TRUNCATE_LENGTH)
                return result.substring(0,TRUNCATE_LENGTH);

        return result;
    }

    // Concatenate symbol to display window
    private void addSymbol(char symbol) {
        // If the "Error" text is currently displayed, clear it before adding any new symbols
        if(text_display.getText().equals("Error"))
            clear_display();

        // Concatenate symbol to display window
        String str = symbol + "";
        text_display.setText(text_display.getText() + str);
    }

    private void clear_display() {
        text_display.setText("");
    }
}
