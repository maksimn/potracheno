package io.github.maksimn.potracheno;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        eventHolder.eventDateTextView.setText(dateToFormattedString(eventInfo.date));
        Resources res = eventHolder.eventDateTextView.getResources();
        eventHolder.eventPersonsTextView.setText(
                res.getQuantityString(R.plurals.persons, eventInfo.persons, eventInfo.persons)
        );
    }

    @Override
    public int getItemCount() {
        return eventInfoList.size();
    }

    public void setEventInfoList(List<EventInfo> eventInfoList) {
        this.eventInfoList = eventInfoList;
    }

    private String dateToFormattedString(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return dayOfMonth + " " + getMonthRusName(month) + ", " + getDayOfWeekRusName(dayOfWeek);
    }

    private String getMonthRusName(int month) {
        switch (month) {
            case 0: return "января";
            case 1: return "февраля";
            case 2: return "марта";
            case 3: return "апреля";
            case 4: return "мая";
            case 5: return "июня";
            case 6: return "июля";
            case 7: return "августа";
            case 8: return "сентября";
            case 9: return "октября";
            case 10: return "ноября";
            case 11: return "декабря";
        }
        return null;
    }

    private String getDayOfWeekRusName(int dayOfWeek) {
        switch (dayOfWeek) {
            case 0: return "понедельник";
            case 1: return "вторник";
            case 2: return "среда";
            case 3: return "четверг";
            case 4: return "пятница";
            case 5: return "суббота";
            case 6: return "воскресенье";
        }
        return null;
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
