package interfaces;

import collections.CollectionBase;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * IAdapterBase interface
 * This interface contains properties and methods of IAdapterBase class
 * Author: Antonino Razeti
 * Created: 16/01/2021
 * Version: 1.0
 **********************************************************************
 */
public interface IAdapterBase {

    /////////////////////////////
    // Interface
    /**
     * AdapterBase interface
     */
    interface OnAdapterListener {
        void onEdit(Object o, int position);
        void onDelete(Object o, int position);
    }
    /////////////////////////////

    /////////////////////////////
    // Getters
    CollectionBase getFullCollection();
    CollectionBase getFilteredCollection();
    /////////////////////////////

    /////////////////////////////
    // Setters
    void setFullCollection(CollectionBase fullCollection);
    void setFilteredCollection(CollectionBase filteredCollection);
    /////////////////////////////

    /////////////////////////////
    // Functions
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
