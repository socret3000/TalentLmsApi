package com.abba.talentlmsapi.Adapters;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abba.talentlmsapi.Models.User;
import com.abba.talentlmsapi.R;
import com.abba.talentlmsapi.Views.DetailUser;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder>{

    List<User> usuarios;
    int layout;
    Activity activity;


    public UsersAdapter(List<User> usuarios, int layout, Activity activity) {
        this.usuarios = usuarios;
        this.layout = layout;
        this.activity = activity;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {



        View view= LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        return new UserViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        final User usuario=usuarios.get(position);

        String fullName=usuario.getFirst_name()+" "+usuario.getLast_name();
        holder.txtName.setText(fullName);
        holder.txtEmail.setText(usuario.getEmail());
        holder.txtUserType.setText(usuario.getUser_type());
        holder.txtStatus.setText(usuario.getStatus());

        holder.cardContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(activity, DetailUser.class);
                intent.putExtra("id",usuario.getId());
                intent.putExtra("name",usuario.getFirst_name());
                activity.startActivity(intent);

            }
        });





    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtEmail,txtUserType,txtStatus;
        CardView cardContent;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=(TextView)itemView.findViewById(R.id.txtName);
            txtEmail=(TextView)itemView.findViewById(R.id.txtEmail);
            txtUserType=(TextView)itemView.findViewById(R.id.txtUserType);
            txtStatus=(TextView)itemView.findViewById(R.id.txtStatus);
            cardContent=(CardView)itemView.findViewById(R.id.cardContent);


        }
    }


}
