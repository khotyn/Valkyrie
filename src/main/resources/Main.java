import java.io.Serializable;
public class Main implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int i = 23547634;
	private static float f = 3.1415926f;
	private static long l = 246616546;
	private static double d = 3.142564556;
	public static void main(String args[]) {
		System.out.println("Hello, world!");
	}

	public String toString(){
		return null;
	}

	@Deprecated
	public void haha(int[] ints, String str){
		//nothing at all;
	}
}

