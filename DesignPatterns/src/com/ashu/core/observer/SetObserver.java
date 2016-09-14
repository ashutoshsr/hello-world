package com.ashu.core.observer;

public interface SetObserver<E> {
 public void added(ObservableSet<E> set, E element);
}
