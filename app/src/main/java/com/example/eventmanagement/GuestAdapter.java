package com.example.eventmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {

    private List<Guest> guestList;
    private List<Guest> filteredList;

    public GuestAdapter(List<Guest> guestList) {
        this.guestList = guestList;
        this.filteredList = new ArrayList<>(guestList);
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_guest_list_item, parent, false);
        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        Guest guest = filteredList.get(position);
        holder.emailTextView.setText(guest.getEmail());
        holder.genderTextView.setText(guest.getGender());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filter(String text) {
        filteredList.clear();
        if (text.isEmpty()) {
            filteredList.addAll(guestList);
        } else {
            for (Guest guest : guestList) {
                if (guest.getEmail().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(guest);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class GuestViewHolder extends RecyclerView.ViewHolder {
        TextView emailTextView, genderTextView;

        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            emailTextView = itemView.findViewById(R.id.guest_email);
            genderTextView = itemView.findViewById(R.id.guest_gender);
        }
    }
}
