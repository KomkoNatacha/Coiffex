package ca.dmi.uqtr.coiffex3.db.adapteur;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ca.dmi.uqtr.coiffex3.R;
import ca.dmi.uqtr.coiffex3.client.ChoixCoiffure;
import ca.dmi.uqtr.coiffex3.client.Modele;


public class ModeleAdapter  extends RecyclerView.Adapter<ModeleAdapter.MyViewHolder> {
    private static Context context = null;
    private List<Modele> modeles;


    public ModeleAdapter(Context context){
        super();
        this.context = context;
        modeles = new ArrayList<>();

    }
    @NonNull
    @Override
    public ModeleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ModeleAdapter.MyViewHolder holder, int position) {
        Modele currentModele = modeles.get(position);
        holder.setModele(currentModele);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChoixCoiffure.class);
                intent.putExtra("Nom",currentModele.getNom());
                intent.putExtra("Description",currentModele.getDescription());
                intent.putExtra("Image",currentModele.getImg());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modeles.size();
    }

    public void setData(List<Modele> data){
        modeles = data;
        notifyDataSetChanged();
    }
    public void addItem(Modele car) {
        modeles.add(0, car);
        notifyItemInserted(0);
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nom,description;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_image);
            nom = itemView.findViewById(R.id.item_nom);
            description = itemView.findViewById(R.id.item_description);



        }
        public void setModele(Modele currentModele) {

            img.setImageResource(currentModele.getImg());
            nom.setText(currentModele.getNom());
            description.setText(currentModele.getDescription());


        }
    }




}

