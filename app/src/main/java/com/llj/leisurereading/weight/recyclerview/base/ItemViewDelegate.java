package com.llj.leisurereading.weight.recyclerview.base;


/**
 * Created by wjs on 17/2/4.
 */
public interface ItemViewDelegate<T>
{

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);


    void convert(ViewHolder holder, T t, int position);

}
