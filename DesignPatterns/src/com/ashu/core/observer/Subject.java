package com.ashu.core.observer;

public interface Subject {
  void register (Observer o);
  void unreg(Observer o);
  void notifyObserver();
}
