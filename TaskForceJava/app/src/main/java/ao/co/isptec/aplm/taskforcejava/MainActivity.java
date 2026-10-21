package ao.co.isptec.aplm.taskforcejava;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    ArrayList<String> arrWords= new ArrayList<>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.myButton);
        listView = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrWords);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(v -> {
            if(editText.getText().length() > 0){
                String texto = editText.getText().toString();
                arrWords.add(texto);
                arrayAdapter.notifyDataSetChanged();
                editText.getText().clear();
            }
        });

    }
}