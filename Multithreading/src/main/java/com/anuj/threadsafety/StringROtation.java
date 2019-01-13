package com.anuj.threadsafety;

public class StringROtation {
	public static void main(String[] args) {
		System.out.println(Reverse("test"));
	}

	public static String Reverse(String sentence) {

		String normal = "abcdefghijklmnopqrstuvwxyz_,;.?!/\\'";
		String split = "ɐqɔpǝɟbɥıظʞןɯuodbɹsʇnʌʍxʎz‾'؛˙¿¡/\\,";

		normal += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		split += "∀qϽᗡƎℲƃHIſʞ˥WNOԀὉᴚS⊥∩ΛMXʎZ";

		normal += "0123456789";
		split += "0ƖᄅƐㄣϛ9ㄥ86";

		StringBuilder res = new StringBuilder();

		for (int i = sentence.length() - 1; i >= 0; i--) {
			char letter = sentence.charAt(i);
			int a = normal.indexOf(letter);
			res.append((a != -1) ? split.charAt(a) : letter);
		}

		return res.toString();
	}
}
