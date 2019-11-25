package com.abba.talentlmsapi.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abba.talentlmsapi.Models.UserCourse;
import com.abba.talentlmsapi.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CoursesViewHolder>{

    ArrayList<UserCourse> cursos;
    int layout;
    Activity activity;


    public CoursesAdapter() {
    }

    public CoursesAdapter(ArrayList<UserCourse> cursos, int layout, Activity activity) {
        this.cursos = cursos;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CoursesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view= LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        return new CoursesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CoursesViewHolder holder, int position) {

        UserCourse curso=cursos.get(position);

        holder.txtName.setText(curso.getName());
        holder.txtInscrito.setText(curso.getEnrolled_on());
        holder.txtPorcentaje.setText(curso.getCompletion_percentage()+"%");
        holder.txtTiempoTotal.setText(curso.getTotal_time());

        holder.cardContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =activity.getPackageManager().getLaunchIntentForPackage("com.talentlms.android");
                if (intent != null) {

                    try
                    {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        activity.startActivity(intent);
                    }catch (Exception ex){}

                } else {

                    try
                    {
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setData(Uri.parse("market://details?id=" + "com.package.name"));
                        activity.startActivity(intent);

                    }catch (Exception ex){}

                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }

    public class CoursesViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtInscrito,txtPorcentaje,txtTiempoTotal;
        CardView cardContent;


        public CoursesViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=(TextView)itemView.findViewById(R.id.txtName);
            txtInscrito=(TextView)itemView.findViewById(R.id.txtInscrito);
            txtPorcentaje=(TextView)itemView.findViewById(R.id.txtPorcentaje);
            txtTiempoTotal=(TextView)itemView.findViewById(R.id.txtTiempoTotal);
            cardContent=(CardView)itemView.findViewById(R.id.cardContent);


        }
    }
}
