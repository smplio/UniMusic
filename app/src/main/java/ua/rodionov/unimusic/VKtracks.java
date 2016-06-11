package ua.rodionov.unimusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Дмитрий on 04.06.2016.
 */
public class VKtracks extends Fragment {

    RecyclerView list;
    SongListAdapter listAdapter;
    private ArrayList<song> songs;
    MainActivity mainActivity;

    public VKtracks(){

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mainActivity = (MainActivity)getActivity();
        songs = new ArrayList<>(mainActivity.songs);
        Iterator<song> itr = songs.iterator();
        while (itr.hasNext()) {
            song element = itr.next();
            if(element.getSource() == 0){
                itr.remove();
            }
        }
        listAdapter = new SongListAdapter(getContext(),songs, mainActivity);
        listAdapter.notifyDataSetChanged();
        list.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        list.setLayoutManager(llm);
        list.setAdapter(listAdapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tracks, container, false);

        list = (RecyclerView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
    }
}