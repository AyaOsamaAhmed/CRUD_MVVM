package crud.aya.test.com.Paging;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import crud.aya.test.com.R;

public class ClientAdapter extends PagedListAdapter<Client, ClientAdapter.UserViewHolder> {
public ClientAdapter() {
        super(USER_COMPARATOR);
        }
@NonNull
@Override
public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_list, parent, false);
        return new UserViewHolder(view);
        }
@Override
public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(getItem(position));
        }
public class UserViewHolder extends RecyclerView.ViewHolder {
    private TextView userName;
    private TextView userEmail;
    private ImageView userPic;
    UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.user_name);
        userEmail = itemView.findViewById(R.id.user_email);
        userPic = itemView.findViewById(R.id.user_avatar);
    }
    void bind(Client user) {
        if (user.getFirstName() != null && user.getLastName() != null) {
            userName.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
        }
        if (user.getEmail() != null) {
            userEmail.setText(user.getEmail());
        }
      /*  Glide.with(itemView.getContext())
                .load(user.getAvatar())
                .placeholder(R.drawable.loading)
                .into(userPic);

       */
    }
}
    private static final DiffUtil.ItemCallback<Client> USER_COMPARATOR = new DiffUtil.ItemCallback<Client>() {
        @Override public boolean areItemsTheSame(@NonNull Client oldItem, @NonNull Client newItem) {
            return oldItem.getId() == newItem.getId();
        }
        @SuppressLint("DiffUtilEquals")
        @Override public boolean areContentsTheSame(@NonNull Client oldItem, @NonNull Client newItem) {
            return oldItem == newItem;
        }
    };
}
