package com.example.magnusmain.alarms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.example.magnusmain.alarms.R;
import com.example.magnusmain.alarms.model.Alarmer;


public class NotatRecycleAdapter extends RecyclerView.Adapter<NotatRecycleAdapter.KortViewHolder> {
        private List<Alarmer> mData;
        private LayoutInflater mInflater;

        public NotatRecycleAdapter(Context context, List<Alarmer> data) {
            this.mData = Alarmer.getAlarmListe();
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public KortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.my_list_item, parent, false);
            KortViewHolder holder = new KortViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(KortViewHolder holder, int position) {
            Alarmer currentObj = mData.get(position);
            holder.setData(currentObj, position);
            holder.setListeners();
        }

        @Override
        public int getItemCount() {
            try{
                return mData.size();
            }catch (NullPointerException e){
                System.out.println(e);
            }
            return 0;
        }

        public void removeItem(int position) {
            mData.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mData.size());
            notifyDataSetChanged();
        }

        class KortViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView teksten;
            ImageView sletteKnapp;
            int position;

            public KortViewHolder(View itemView) {
                super(itemView);
                teksten = itemView.findViewById(R.id.notat_text);
            }

            public void setData(Alarmer current, int position) {
                this.teksten.setText(current.getAlarmNavn());
                this.position = position;
                sletteKnapp = itemView.findViewById(R.id.img_slettKnapp);
            }

            public void setListeners() {
                sletteKnapp.setOnClickListener(KortViewHolder.this);
            }

            @Override
            public void onClick(View v) {
                Log.i("onClick before operatio", position + " " + mData.size());
                switch (v.getId()) {
                    case R.id.img_slettKnapp:
                        removeItem(position);
                        break;
                }
                Log.i("onClick after operation", mData.size() + "");
            }
        }
}
