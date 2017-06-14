package liuguijie.baway.com.exam20170614;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by pc on 2017/6/14.
 */

public class SecondActivity extends AppCompatActivity {

    private EditText tx;
    private Button send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tx = (EditText) findViewById(R.id.tx);
        send = (Button) findViewById(R.id.send);
        //接收发送的数据
        final Intent intent = getIntent();
        //根据key值取出value值
        String content = intent.getStringExtra("content");
        tx.setText(content);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("name",tx.getText().toString());
                intent.putExtras(bundle);
                setResult(1001,intent);
                finish();
            }
        });

    }
}
