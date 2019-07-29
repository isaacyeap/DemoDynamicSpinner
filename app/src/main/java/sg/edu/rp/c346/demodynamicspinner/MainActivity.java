package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btnUpdate;
    Spinner spn1;
    Spinner spn2;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUpdate = findViewById(R.id.buttonUpdate);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);

        alNumbers = new ArrayList<>();
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        /*alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");

        //Get the string-array and store as an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        //Convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));*/

        spn2.setAdapter(aaNumbers);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                //Apply either of the two approaches
                //To load the correct number list based on the selection based on spn1
                if(pos == 0){
                    //Get the string-array and store as an Array
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                else{
                    //Get the string-array and store as an Array
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                aaNumbers.notifyDataSetChanged();
            }
        });

        spn1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                if(pos == 0){
                    //Get the string-array and store as an Array
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                else{
                    //Get the string-array and store as an Array
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                aaNumbers.notifyDataSetChanged();
            }
        });
    }
}