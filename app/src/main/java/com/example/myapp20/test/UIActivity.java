package com.example.myapp20.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp20.R;

import java.util.ArrayList;
import java.util.List;

public class UIActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        //initMsgs消息数据初始化
        initMsgs();
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        //初始化msgAdapter对象
        msgAdapter = new MsgAdapter(msgList);
        //初始化layoutManager对象
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        msgRecyclerView.setLayoutManager(layoutManager);
        //绑定数据
        msgRecyclerView.setAdapter(msgAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)){
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    //当有消息时，刷新RecyclerView的显示
                    msgAdapter.notifyItemInserted(msgList.size()-1);
                    //将RecyclerView定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    //清空输入框内容
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsgs(){
        Msg msg1 = new Msg("今天天气不错！ ", Msg.TYPE_RECEIVED);
        msgList.add(msg1);

        Msg msg2 = new Msg("你叫什么？", Msg.TYPE_SENT);
        msgList.add(msg2);

        Msg msg3 = new Msg("我叫李文", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
