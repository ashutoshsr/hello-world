package threads;

public class AnImmutable {

	private final double areaCode;
	private final double prefix;

	public static void main(String[] args) {

	}

	public double realPart() {
		return prefix;
	}

	public double imaginaryPart() {
		return areaCode;
	}

	public AnImmutable add(AnImmutable c) {
		return new AnImmutable(areaCode + c.areaCode, prefix + c.prefix);
	}

	public AnImmutable subtract(AnImmutable c) {
		return new AnImmutable(areaCode - c.areaCode, prefix - c.prefix);
	}

	public AnImmutable multiply(AnImmutable c) {
		return new AnImmutable(areaCode * c.areaCode - prefix * c.prefix, areaCode * c.areaCode + prefix * c.prefix);
	}

	public AnImmutable(Double ar, Double pre) {

		this.areaCode = (Double) ar;
		this.prefix = (Double) pre;
	}

}
