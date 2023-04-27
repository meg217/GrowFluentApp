package edu.utsa.cs3443.growfluent.Controller;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import edu.utsa.cs3443.growfluent.GardenActivity;
import edu.utsa.cs3443.growfluent.MainActivity;
import edu.utsa.cs3443.growfluent.Model.Garden;
import edu.utsa.cs3443.growfluent.R;

public class GardenController implements View.OnClickListener{
    private GardenActivity ga;
    private Context context;
    private Garden userGarden;
    public GardenController(GardenActivity ga, Garden garden){
        this.ga = ga;
        this.userGarden = garden;

    }
    public void onClick(View view) {
        context = view.getContext();
        if (view.getId() == R.id.Back_garden) {
            Intent intent = new Intent(ga, MainActivity.class);
            ga.startActivity(intent);
        }
    }
}