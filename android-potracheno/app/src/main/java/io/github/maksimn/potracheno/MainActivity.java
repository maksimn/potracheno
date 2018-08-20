package io.github.maksimn.potracheno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        RecyclerView eventsRecyclerView = findViewById(R.id.events_recycler_view);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        EventsRecyclerViewAdapter eventsRecyclerViewAdapter = new EventsRecyclerViewAdapter();
        eventsRecyclerView.setAdapter(eventsRecyclerViewAdapter);

        // TODO: Выделить эти тестовые данные в отдельную службу, которую потом внедрить через Dagger
        List<EventInfo> eventInfoList = new ArrayList<>();
        EventInfo event1 = new EventInfo();
        event1.name = "Пьянка в рюмочной";
        event1.date = new Date();
        event1.persons = 12;
        EventInfo event2 = new EventInfo();
        event2.name = "Тестовая встреча";
        event2.date = new Date(0);
        event2.persons = 3;

        eventInfoList.add(event1);
        eventInfoList.add(event2);
        eventsRecyclerViewAdapter.setEventInfoList(eventInfoList);
        eventsRecyclerViewAdapter.notifyItemRangeChanged(0, 2);
    }
}
