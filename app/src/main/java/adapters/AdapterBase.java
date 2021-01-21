package adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import collections.CollectionBase;
import holders.HolderBase;
import interfaces.IAdapterBase;

/*
 **********************************************************************
 * Copyright (c) 2021, TonyHack81
 * All Rights Reserved.
 **********************************************************************
 * AdapterBase class
 *
 * Author: Antonino Razeti
 * Created: 14/01/2021
 * Version: 1.0
 **********************************************************************
 */
public abstract class AdapterBase extends RecyclerView.Adapter<HolderBase> implements IAdapterBase {

    /////////////////////////////
    // Private declarations
    private final Context context;
    private CollectionBase fullCollection;
    private CollectionBase filteredCollection;
    private OnAdapterListener listener;
    /////////////////////////////

    /////////////////////////////
    // Getters

    /**
     * Gets the full collection of current adapter
     * @return CollectionBase
     * @see CollectionBase
     */
    @Override
    public CollectionBase getFullCollection() {
        return fullCollection;
    }

    /**
     * Gets the filtered collection of current adapter
     * @return CollectionBase
     * @see CollectionBase
     */
    @Override
    public CollectionBase getFilteredCollection() {
        return filteredCollection;
    }
    /////////////////////////////

    /////////////////////////////
    // Setters
    /**
     * Sets the full collection of current holder
     * @param fullCollection CollectionBase
     * @see CollectionBase
     */
    @Override
    public void setFullCollection(CollectionBase fullCollection) {
        this.fullCollection = fullCollection;
        notifyDataSetChanged();
    }

    /**
     * Sets the filtered collection of current adapter
     * @param filteredCollection CollectionBase
     * @see CollectionBase
     */
    @Override
    public void setFilteredCollection(CollectionBase filteredCollection) {
        this.filteredCollection = filteredCollection;
        notifyDataSetChanged();
    }
    /////////////////////////////

    /////////////////////////////
    // Constructors

    /**
     * Creates a new instance of AdapterBase given the context, the collection and the events listener of adapter
     * @param context Context
     * @param fullCollection CollectionBase
     * @param listener OnAdapterListener
     * @see CollectionBase
     */
    public AdapterBase(Context context, CollectionBase fullCollection, OnAdapterListener listener) {
        this.context = context;
        this.fullCollection = fullCollection;
        this.listener = listener;
    }
    /////////////////////////////

    /////////////////////////////
    // Functions
    /**
     * Returns the number of elements contained into current adapter
     * @return int
     */
    @Override
    public int getItemCount() {
        return filteredCollection.getCount();
    }
    /////////////////////////////

    /////////////////////////////
    // Methods
    /////////////////////////////
}
