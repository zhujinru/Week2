package com.bawei.week2.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week2.R;
import com.bawei.week2.model.bean.GsonBean;
import com.bawei.week2.util.NetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<GsonBean.ResultBean> result;

    public MyAdapter(List<GsonBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.child, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GsonBean.ResultBean resultBean = result.get(position);
        holder.name.setText(resultBean.getCommodityName());
        holder.price.setText(resultBean.getPrice()+"");
        NetUtil.getInstance().getPho(resultBean.getMasterPic(),holder.cImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickL(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.c_image)
        ImageView cImage;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    onItemClickListener onItemClickListener;

    public void setOnItemClickListener(MyAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClickL(int i);
    }
}
