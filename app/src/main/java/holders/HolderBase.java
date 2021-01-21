package holders;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import com.tonyhack.haircut.R;
import tools.Utility;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * HolderBase class
 *
 * Author: Antonino Razeti
 * Created: 15/01/2021
 * Version: 1.0
 **********************************************************************
 */
public abstract class HolderBase extends RecyclerView.ViewHolder implements interfaces.IHolderBase {

    /////////////////////////////
    // Interface
    /////////////////////////////

    /////////////////////////////
    // Private declarations
    private final Context context;
    private OnHolderListener listener;
    private Object object;
    private PopupMenu popupMenu;
    private AppCompatImageButton btn;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the object of current holder
     * @return Object
     */
    @Override
    public Object getObject() {
        return object;
    }

    /**
     * Gets the popup menu of current holder
     * @return PopupMenu
     */
    @Override
    public PopupMenu getPopupMenu() {
        return popupMenu;
    }
    /////////////////////////////

    /////////////////////////////
    // Setters

    /**
     * Sets the events listener of current holder base
     * @param listener OnHolderListener
     */
    @Override
    public void setListener(OnHolderListener listener) {
        this.listener = listener;
    }

    /**
     * Sets the object of current holder
     * @param object Object
     */
    @Override
    public void setObject(Object object) {
        this.object = object;
        if (object != null) {
            setCard();
        }
    }

    /**
     * Sets the popup menu
     * @param popupMenu PopupMenu
     * @param resourceMenu int
     */
    @Override
    public void setPopupMenu(PopupMenu popupMenu, int resourceMenu) {
        this.popupMenu = popupMenu;
        if (popupMenu != null && resourceMenu != 0) {
            popupMenu.getMenuInflater().inflate( resourceMenu, popupMenu.getMenu() );
            try {
                Utility.forceMenuIcons( context, popupMenu );
            } catch (Exception e) {
                Log.d(String.valueOf(R.string.app_name), "setPopupMenu: " + e.getMessage());
            }
        }
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new instance of Holder Base class given the view, the context and the events listener
     * @param itemView
     */
    public HolderBase(@NonNull View itemView, Context context, OnHolderListener listener) {
        super(itemView);
        this.context = context;
        this.listener = listener;
    }
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
