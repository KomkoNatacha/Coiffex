package ca.dmi.uqtr.coiffex3.client;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ca.dmi.uqtr.coiffex3.R;
import ca.dmi.uqtr.coiffex3.db.adapteur.ModeleAdapter;


public class Home extends Fragment  {
    private RecyclerView myRecyclerView;
    private ModeleAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        myRecyclerView = view.findViewById(R.id.my_list);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.VERTICAL,
                        false);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 1);
        myRecyclerView.setLayoutManager(glm);
        adapter = new ModeleAdapter(getActivity());
        initModele();
        myRecyclerView.setAdapter(adapter);


        return view;

    }

    private void initModele(){

        adapter.addItem(new Modele("Knowless","Ce sont une variante sans douleur et sans tension des tresses en boîte traditionnelles, où les tresses sont commencées en utilisant vos propres cheveux contrairement aux box braids où un nœud est d'abord formé.", R.drawable.tresse1));
        adapter.addItem(new Modele("Passion twist","Ils sont comme des vanilles ou des twists mais avec des rajouts ayant une texture très souple. On utilise généralement les rajouts pour crochet braids très ondulés ou bouclés.",  R.drawable.tresse2));
        adapter.addItem(new Modele("Braids","C'est un type de coiffure que l'on peut créer par torsion à deux brins. Cette méthode consiste à prendre deux mèches de cheveux, de les vriller dans le même sens puis les enrouler l'une autour de l'autre jusqu'à ce qu'elles forment une mèche en forme de corde.",  R.drawable.tresse4));
        adapter.addItem(new Modele("Dreads","Petites nattes, parfois entrelacées de perles, constituant la coiffure traditionnelle des rastas.",  R.drawable.tresse5));
        adapter.addItem(new Modele("Nattes collées","Ce sont des tresses plaquées sur le cuir chevelu. Tous les types de cheveux peuvent opter pour cette coiffure.",  R.drawable.tresse6));
        adapter.addItem(new Modele("Vanilles","C'est un type de coiffure que l'on peut créer par torsion à deux brins. Cette méthode consiste à prendre deux mèches de cheveux, de les vriller dans le même sens puis les enrouler l'une autour de l'autre jusqu'à ce qu'elles forment une mèche en forme de corde.",  R.drawable.tresse7));
        adapter.addItem(new Modele("Chignon","Cheveux torsadés et roulés sur la nuque ou au-dessus. ",  R.drawable.tresse8));
        adapter.addItem(new Modele("Perruques","C'est une coiffure de faux cheveux d'origine humaine, chevaline ou synthétique portée sur la tête pour des raisons liées à la mode, pour des considérations esthétiques ou professionnelles, ou pour se conformer à une prescription culturelle ",  R.drawable.tresse9));
        adapter.addItem(new Modele("Goddess Braids","Ce sont des tresses de boîte avec des brins bouclés ajoutés à la fin ou tout au long des tresses. Imaginez simplement de longues extensions de vagues de plage mélangées à des tresses de boîte régulières.",  R.drawable.tresse10));
    }
}
