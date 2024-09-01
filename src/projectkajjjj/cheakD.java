package projectkajjjj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class cheakD {
	public static boolean cheakcus(String str) {
		File f = new File("customer.txt");
		int c = 0;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals(str)) {
					c = 1;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("cheak error");
		}
		if (c == 1)
			return false;
		else
			return true;

	}

	public static boolean cheakown(String str) {
		File f = new File("owner.txt");
		int c = 0;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals(str)) {
					c = 1;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("cheak error");
		}
		if (c == 1)
			return false;
		else
			return true;

	}

	public int cheakinfo(String str) {
		File f = new File("infoCustomer.txt");
		Scanner input;
		int i = 0;
		try {
			input = new Scanner(f);

			while (input.hasNext()) {
				i++;
				String s = input.next();
				if (s == str + "all") {
					break;
				} else
					input.next();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int chk(String x) {
		int e = 0;

		try {
			File file = new File("foodlist.txt");
			Scanner input;
			input = new Scanner(file);

			while (input.hasNext()) {
				e++;
				String rn = input.next();

				if (rn.equals(x)) {
					break;
				}

			}
		} catch (FileNotFoundException ee) {

			System.out.println("hello");
		}

		return e;

	}

	public String voucher(String id) {

		File f = new File("voucher.txt");
		int c = 0;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals(id + " " + id + "tk50")) {
					c = 1;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("cheak error");
		}
		if (c == 1)
			return id + "tk50";
		else
			return "This voucher is not available for you";
	}

	public int selectfood(String foodname) {
		int x = 0;
		try {
			File file = new File("temfood.txt");
			Scanner input = new Scanner(file);

			while (input.hasNext()) {
				String d = input.next();
				if (d.equals(foodname)) {
					x = input.nextInt();
					input.close();
					break;
				}

			}

		} catch (Exception e) {
			System.out.println("select food error");
		}

		return x;
	}

	public void customar1() {
		customarD frame = new customarD();
		frame.setVisible(true);
	}
}
