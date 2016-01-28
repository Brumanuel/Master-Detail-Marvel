package com.garcilomanuel.masterdetailmarvel.ui.comiclist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.garcilomanuel.masterdetailmarvel.R;
import com.garcilomanuel.masterdetailmarvel.domain.model.Comic;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel García.
 */
public class ComicRecyclerAdapter
    extends RecyclerView.Adapter<ComicRecyclerAdapter.ViewHolderComic> {

  private List<Comic> comics = new ArrayList<>();
  private OnClick onClick;
  private Context context;

  @Override
  public ViewHolderComic onCreateViewHolder(ViewGroup parent, int viewType) {
    context = parent.getContext();
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_list_item, parent, false);
    return new ViewHolderComic(view);
  }

  @Override
  public void onBindViewHolder(ViewHolderComic holder, int position) {
    final Comic comicInstace = comics.get(position);
    holder.tvName.setText(comicInstace.getTitle());
    holder.tvDate.setText(comicInstace.getAuthor());
    Picasso.with(context).load(comicInstace.getThumnailUri()).into(holder.ivThumbail);

    holder.fLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onClick.onComicClicked(comicInstace);
      }
    });
  }

  @Override
  public int getItemCount() {
    return comics.size();
  }

  public void setOnClick(OnClick onClick) {
    this.onClick = onClick;
  }

  public void updateComics(List<Comic> comics) {
    this.comics = comics;
    notifyDataSetChanged();
  }

  public interface OnClick {
    void onComicClicked(Comic comic);
  }

  public class ViewHolderComic extends RecyclerView.ViewHolder {

    @Bind(R.id.f_layout) public FrameLayout fLayout;
    @Bind(R.id.tv_name) public TextView tvName;
    @Bind(R.id.tv_date) public TextView tvDate;
    @Bind(R.id.iv_thumbail) public ImageView ivThumbail;

    public ViewHolderComic(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
