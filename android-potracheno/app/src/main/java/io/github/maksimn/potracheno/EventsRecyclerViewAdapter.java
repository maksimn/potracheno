package io.github.maksimn.potracheno;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class EventsRecyclerViewAdapter extends
        RecyclerView.Adapter<EventsRecyclerViewAdapter.EventHolder> {

    private List<EventInfo> eventInfoList = new ArrayList<>();

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new EventHolder(LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.event_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder eventHolder, int i) {
        EventInfo eventInfo = eventInfoList.get(i);
        eventHolder.eventNameTextView.setText(eventInfo.name);
        eventHolder.eventDateTextView.setText(eventInfo.date.toString());
        eventHolder.eventPersonsTextView.setText(eventInfo.persons + "участников");
    }

    @Override
    public int getItemCount() {
        return eventInfoList.size();
    }

    public void setEventInfoList(List<EventInfo> eventInfoList) {
        this.eventInfoList = eventInfoList;
    }

    public static class EventHolder extends RecyclerView.ViewHolder {
        TextView eventNameTextView;
        TextView eventDateTextView;
        TextView eventPersonsTextView;

        public EventHolder(@NonNull View itemView) {
            super(itemView);
            eventNameTextView = itemView.findViewById(R.id.event_name);
            eventDateTextView = itemView.findViewById(R.id.event_date);
            eventPersonsTextView = itemView.findViewById(R.id.persons_number);
        }
    }
}
