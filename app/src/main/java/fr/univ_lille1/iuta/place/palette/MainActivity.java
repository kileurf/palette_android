package fr.univ_lille1.iuta.place.palette;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] nom_color;
    int[] color;
    TextView demo;
    static Button lookup;
    static Primary red;
    static Primary blue;
    static Primary vert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom_color = getResources().getStringArray(R.array.color_names);
        color = getResources().getIntArray(R.array.colors);
        demo = (TextView) findViewById(R.id.demo);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        lookup = (Button) findViewById(R.id.lookup);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.color_names, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                demo.setText(nom_color[position]);
                demo.setBackgroundColor(color[position]);
                //parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        red = new Primary((SeekBar)findViewById(R.id.Rouge),(TextView)findViewById(R.id.EditRouge));
        blue = new Primary((SeekBar)findViewById(R.id.Bleu),(TextView)findViewById(R.id.EditBleu));
        vert = new Primary((SeekBar)findViewById(R.id.Vert),(TextView)findViewById(R.id.EditVert));
        lookup.setBackgroundColor(Color.rgb(red.getValue(),vert.getValue(),blue.getValue()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void modifLookup(){
        lookup.setBackgroundColor(Color.rgb(red.getValue(),vert.getValue(),blue.getValue()));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("red", red.getValue());
        savedInstanceState.putInt("vert", vert.getValue());
        savedInstanceState.putInt("blue",blue.getValue());
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        red.setValue(savedInstanceState.getInt("red"));
        vert.setValue(savedInstanceState.getInt("vert"));
        blue.setValue(savedInstanceState.getInt("blue"));
        modifLookup();
    }

}
