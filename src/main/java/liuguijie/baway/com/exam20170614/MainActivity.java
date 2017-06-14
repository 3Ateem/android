package liuguijie.baway.com.exam20170614;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    private Button btIntent;
    private TextView text;

    @Override
    protected void onPause() {
        super.onPause();
        edit.getText().append("onPause");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btIntent = (Button) findViewById(R.id.btintent);
        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.name);
        btIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"内容不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("content",edit.getText().toString());
                startActivityForResult(intent,1000);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==1000&&resultCode==1001){
            Bundle bundle = data.getExtras();
            String name = bundle.getString("name");
            text.setText(name);
        }

    }
}
