package pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers;

/**
 * Created by Mateusz on 20.04.2017.
 */

public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}