package com.learning.ultils

import com.learning.dto.Order


/**
 * implement quick sort
 * pivot is always at position 0
 */
fun <T : Comparable<T>, C> List<C>.sort(f: C.() -> T, order: Order = Order.DESC): List<C> {
    if (this.size <= 1) return this;
    val pivot = this[0];
    var smallerList: MutableList<C> = mutableListOf();
    var biggerList: MutableList<C> = mutableListOf();
    for (personIndex in 1..(this.size - 1)) {
        if (this[personIndex].f() < pivot.f()) smallerList.add(this[personIndex])
        else biggerList.add(this[personIndex]);
    }
    var result: MutableList<C> = mutableListOf();
    if (order == Order.DESC) {
        result.addAll(smallerList.sort(f, order));
        result.add(pivot);
        result.addAll(biggerList.sort(f, order));
    } else {
        result.addAll(biggerList.sort(f, order));
        result.add(pivot);
        result.addAll(smallerList.sort(f, order));
    }
    return result;
}

fun <T> List<T>.findOrNull(predicate: (T) -> Boolean):T? {
    for (element in this) if (predicate(element)) return element
    return null
}