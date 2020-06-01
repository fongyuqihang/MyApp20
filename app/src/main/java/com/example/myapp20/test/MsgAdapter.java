package com.example.myapp20.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp20.R;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;

    public MsgAdapter(List<Msg> mMsgList) {
        this.mMsgList = mMsgList;
    }


    @NonNull
    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.msg_item, parent, false);
        
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgAdapter.ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED){
            //如果是收到的信息，则显示左边的信息布局，将右边的信息布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.RightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else if (msg.getType() == Msg.TYPE_SENT){
            //如果是发出的信息，则显示右边的信息布局，将左边的信息布局隐藏
            holder.leftLayout.setVisibility(View.GONE);
            holder.RightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        LinearLayout RightLayout;
        TextView leftMsg;
        TextView rightMsg;

        public ViewHolder(@NonNull View View) {
            super(View);
             leftLayout = View.findViewById(R.id.left_layout);
             RightLayout = View.findViewById(R.id.right_layout);
             leftMsg = View.findViewById(R.id.left_msg);
             rightMsg = View.findViewById(R.id.right_msg);
        }
    }
}
