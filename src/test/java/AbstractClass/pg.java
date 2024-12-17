package AbstractClass;

import java.util.Arrays;

public class pg {

	public static void main(String[] args) {
		String intro = "i used selenium for automation testing";

		String[] SplitWords = intro.split(" ");

		StringBuilder builder = new StringBuilder();
		for (int i = SplitWords.length - 1; i >= 0; i--) {

			builder = builder.append(SplitWords[i].toString()).append(" ");

		}

		System.out.println(builder);

	}

}
