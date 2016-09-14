package com.ashu.core.observer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstumentationHashSet<E> extends ForwardingSet<E> {
	// attempted insertions
	private int count = 0;
	
	public InstumentationHashSet(Set<E> s) {
		super(s);
	}

	@Override
	public boolean add(E e) {
		count++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		count += c.size();
		return super.addAll(c);
	}

    public int getCount() {
		return count;
	}
	
    public static void main(String args[]) {
    	InstumentationHashSet<String> instHashSet = new InstumentationHashSet<>(new HashSet<>());
    	instHashSet.addAll(Arrays.asList("one", "Two", "Three"));
    	System.out.println("count " + instHashSet.getCount());
    	System.out.println("size" + instHashSet.size());
	}
}
