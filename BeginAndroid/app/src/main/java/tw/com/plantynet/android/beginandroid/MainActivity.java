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




//    radioGroup.setOnCheckedChangeListener(rdgSexchkChListener);
//    public RadioGroup.OnCheckedChangeListener rdgSexchkChListener =
//            RadioGroup.OnCheckedChangeListener(RadioGroup group, int checkedId)
//
//    {
//        int intChkRb = radioGroup.getCheckedRadioButtonId();
//    }




    public void submit(View view){
        String result = editText.getText().toString();
        int weight = Integer.parseInt(editText2.getText().toString());
        int height = Integer.parseInt(editText3.getText().toString());

//        int bmi = (weight)/((height/100)*(height/100));
        double bmi = 50/(1.44*1.44);
        String bmiValue = String.valueOf(bmi);
        textView.setText(result + bmiValue);
        editText.setText("");
    }


}
