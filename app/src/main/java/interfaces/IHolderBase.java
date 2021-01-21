package interfaces;

import android.widget.PopupMenu;

import holders.HolderBase;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * IHolderBase interface
 * This interface contains properties and methods of IHolderBase class
 * Author: Antonino Razeti
 * Created: 15/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface IHolderBase {

    /////////////////////////////
    // Interface
    /**
     * The events listener interface of holder base class
     */
    interface OnHolderListener {
        void onEdit(Object o, int position);
        void onDelete(Object o, int position);
    }
    /////////////////////////////

    /////////////////////////////
    // Getters
    Object getObject();
    PopupMenu getPopupMenu();
    /////////////////////////////


    /////////////////////////////
    // Setters
    void setListener(OnHolderListener listener);
    void setObject(Object object);
    void setPopupMenu(PopupMenu popupMenu, int resourceMenu);
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /**
     * Sets current card with object information
     */
    void setCard();
    /////////////////////////////
}
