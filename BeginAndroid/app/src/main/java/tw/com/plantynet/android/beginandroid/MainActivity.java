package tw.com.plantynet.android.beginandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    EditText editText;
    TextView textView;
    RadioGroup radioGroup;
    String regex = "男生";
    EditText editText2;
    EditText editText3;
    ListView listView;
    String msg;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView)findViewById(R.id.textView);
        editText= (EditText)findViewById(R.id.editText);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        listView = (ListView)findViewById(R.id.listView);
        spinner = (Spinner)findViewById(R.id.spinner);



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


       editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    editText2.setText("");
                    editText3.setText("");
                }
            }
        });


        setupSpinner();
       // setupListView();

        }


    public void setupSpinner() {
        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.namespinner, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);


        AdapterView.OnItemSelectedListener spinnerListener =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        textView.setText((String)spinner.getSelectedItem());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        textView.setText("spinner selected nothing");
                    }
                };

        spinner.setOnItemSelectedListener(spinnerListener);

    }

    private void setupListView()
    {
//        List<String> dataList = new ArrayList<String>();
        String[] item = new String[]{String.valueOf(editText.getText())};
        ArrayAdapter<String> listviewadapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,item);

        listView.setAdapter(listviewadapter);
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
            String spinnerText = (String)spinner.getSelectedItem();
            textView.setText(spinnerText);

        }

        setupListView();
        editText.setText("");

    }




}
