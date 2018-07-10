package com.example.magnusmain.alarms.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.example.magnusmain.alarms.NyAlarm;
import com.example.magnusmain.alarms.R;
import com.example.magnusmain.alarms.model.Alarmer;
import static android.view.LayoutInflater.*;
import static com.example.magnusmain.alarms.NyAlarm.getGetAlarmTider;

public class NotatRecycleAdapter extends RecyclerView.Adapter<NotatRecycleAdapter.KortViewHolder> {
        private List<Alarmer> mData;
        private LayoutInflater mInflater;
        private Context mcon;

        public NotatRecycleAdapter(Context context, List<Alarmer> data) {
            this.mData = Alarmer.getAlarmListe();
            this.mInflater = from(context);
            mcon = context;
        }

        @NonNull
        @Override
        public KortViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.my_list_item, parent, false);
            return new KortViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull KortViewHolder holder, int position) {
            Alarmer currentObj = mData.get(position);
            holder.setData(currentObj, position);
            holder.setListeners();
        }

        @Override
        public int getItemCount() {
            try{
                return mData.size();
            }catch (NullPointerException e){
                Log.d("getItemCount", ": ", e);
            }
            return 0;
        }

        private void removeItem(int position) {
            mData.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mData.size());
            notifyDataSetChanged();
        }
        private void endreItem(int position){
            getGetAlarmTider().add(mData.get(position));
            mcon.startActivity(new Intent(mcon, NyAlarm.class));
        }

        class KortViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView teksten;
            ImageView sletteKnapp;
            ImageView endreKnappen;
            TextView alarmTid;
            int position;

            private KortViewHolder(View itemView) {
                super(itemView);

                //lager itemView for å unngå Null
                teksten = itemView.findViewById(R.id.alarm_navn);
                alarmTid = itemView.findViewById(R.id.alarm_tid);
            }

            private void setData(Alarmer current, int position) {
                //Setter dataene til hvert kort

                this.teksten.setText(current.getAlarmNavn());
                this.alarmTid.setText(current.getAlarmTime()+":"+current.getAlarmMinutt());
                this.position = position;
                sletteKnapp = itemView.findViewById(R.id.img_slettKnapp);
                endreKnappen = itemView.findViewById(R.id.img_endreKnappen);
            }

            private void setListeners() {
                sletteKnapp.setOnClickListener(KortViewHolder.this);
                endreKnappen.setOnClickListener(KortViewHolder.this);
            }

            @Override
            public void onClick(View v) {
                Log.i("onClick before operatio", position + " " + mData.size());
                switch (v.getId()) {
                    case R.id.img_slettKnapp:
                        removeItem(position);
                        break;
                    case R.id.img_endreKnappen:
                        //TODO legge til logikk for å endre en lagd alarm
                        endreItem(position);
                        removeItem(position);
                        break;
                }
                Log.i("onClick after operation", mData.size() + "");
            }
        }
}
