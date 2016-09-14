package threads;

import java.util.concurrent.ConcurrentHashMap;

public class Canonicalization {
	
	private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		Canonicalization canonicalization = new Canonicalization();
		for (int i = 0; i < 200000; i++) {
			canonicalization.intern("Anjali");
			canonicalization.intern("Amma");
			canonicalization.intern("Anjali");
			canonicalization.intern("Ashutosh");
			canonicalization.intern("Anjali");
			canonicalization.intern("Ashutosh");
			canonicalization.intern("Amma");
		}
		for (String string : map.values()) {
			System.out.println(string);
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
	
	public String intern(String s) {
		String previousValue = map.get(s);
		if (previousValue == null) {
			previousValue = map.putIfAbsent(s, s);
			if (previousValue == null) {
				previousValue = s;
			}
		}
		return previousValue;
	}

}
