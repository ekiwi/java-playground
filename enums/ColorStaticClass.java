public class ColorStaticClass {
	public static final ColorStaticClass Red = new ColorStaticClass(0);
	public static final ColorStaticClass Green = new ColorStaticClass(1);
	public static final ColorStaticClass Blue = new ColorStaticClass(2);
	int value;
	ColorStaticClass(int value) { this.value = value; }
}
