package tw.com.plantynet.android.beginandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    EditText editText;
    TextView textView;
    RadioGroup radioGroup;
    String regex = "男生";
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView)findViewById(R.id.textView);
        editText= (EditText)findViewById(R.id.editText);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);




        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    editText.setText(editText.getText().toString());
                    submit(v);
                    return true;
                }
                return false;
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                regex = "你是"+radioButton.getText().toString();
            }
        });




        }





    public void submit(View view){
        String result = editText.getText().toString();
        try {
            double weight = Double.parseDouble(editText2.getText().toString());
            double height = Double.parseDouble(editText3.getText().toString());
            double bmi = (weight) / ((height / 100) * (height / 100));
            String bmiValue = String.valueOf((int) bmi);
            textView.setText(result + bmiValue);
        }
        catch(NumberFormatException e){
            textView.setText("plz input your weight and height");

        }



        editText.setText("");
    }


}
