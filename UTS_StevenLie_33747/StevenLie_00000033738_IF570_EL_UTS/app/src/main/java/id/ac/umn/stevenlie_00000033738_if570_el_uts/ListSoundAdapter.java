package id.ac.umn.stevenlie_00000033738_if570_el_uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListSoundAdapter extends RecyclerView.Adapter<ListSoundAdapter.ListViewHolder> {
    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<SFX> listSound;

    public ListSoundAdapter(Context context, ArrayList<SFX> list){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.listSound = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_row_sfx, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        SFX sfx = listSound.get(position);
        String title = sfx.getTitle();
        String newTitle = title.replace("_", " ");
        holder.tvTitle.setText(newTitle);
        holder.tvGenre.setText(sfx.getGenre());
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAt(holder.getAdapterPosition());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sfxDetailsIntent = new Intent(holder.itemView.getContext(), SfxDetailsActivity.class);
                sfxDetailsIntent.putExtra(SfxDetailsActivity.EXTRA_TTITLE, newTitle.toString());
                sfxDetailsIntent.putExtra(SfxDetailsActivity.EXTRA_GENRE, sfx.getGenre().toString());
                sfxDetailsIntent.putExtra(SfxDetailsActivity.EXTRA_URI, sfx.getAudioURI().toString());
                holder.itemView.getContext().startActivity(sfxDetailsIntent);
            }
        });
    }
    public void removeAt(int position) {
        listSound.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listSound.size());
    }

    @Override
    public int getItemCount() {
        return listSound.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvGenre, tvUri;
        ImageButton btn_delete;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.soundPhoto);
            tvTitle = itemView.findViewById(R.id.soundTitle);
            tvGenre = itemView.findViewById(R.id.soundGenre);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }



}
