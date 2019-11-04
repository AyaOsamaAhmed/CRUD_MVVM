package crud.aya.test.com.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import crud.aya.test.com.R;
import crud.aya.test.com.Room.UserEntity;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<UserEntity> entityList = new ArrayList<>();

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        UserEntity currentUser = entityList.get(position);
        holder.userId.setText(String.valueOf(currentUser.getId()));
        holder.userName.setText(currentUser.getName());
        holder.userEmail.setText(currentUser.getEmail());
        holder.userAge.setText(String.valueOf(currentUser.getAge()));
        holder.userNotes.setText(currentUser.getNotes());
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public void setEntityList(List<UserEntity> entityList) {
        this.entityList = entityList;
        notifyDataSetChanged();
    }

    class UserHolder extends RecyclerView.ViewHolder {

        TextView userId;
        TextView userName;
        TextView userEmail;
        TextView userAge;
        TextView userNotes;

        UserHolder(View item_view) {
            super(item_view);

            userId = item_view.findViewById(R.id.user_id);
            userName= item_view.findViewById(R.id.user_name);
            userEmail =item_view.findViewById(R.id.user_email);
            userAge=item_view.findViewById(R.id.user_age);
            userNotes=item_view.findViewById(R.id.user_notes);
        }


    }

}
