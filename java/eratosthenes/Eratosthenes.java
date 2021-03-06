package eratosthenes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Eratosthenes {
	public static final String EXCEPTION_MESSAGE = "数字を指定してください。";

	public static void main(String[] args) {
		Integer num = 0;
		// 引数のチェック
		try {
			num = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			// 数字でない場合エラー表示
			System.out.println(EXCEPTION_MESSAGE);
			return;
		}

		// 指定された数を配列に格納
		LinkedList<Integer> setNumList = new LinkedList<Integer>();
		for (int i = 0; i <= num; i++) {
			if (i != 0 && i != 1)
				setNumList.add(i);
		}

		// 素数を格納する配列
		LinkedList<Integer> primeList = new LinkedList<Integer>();
		
		do {
			// 先頭の数を格納し、その数の倍数をリストから削除
			primeList.add(setNumList.getFirst());
			for (Iterator<Integer> iterator = setNumList.iterator(); iterator
					.hasNext();) {
				Integer judgeNum = (Integer) iterator.next();
				if (judgeNum % primeList.getLast() == 0) {
					iterator.remove();
				}
			}
		} while (primeList.getLast() * primeList.getLast() < setNumList.getLast());

		//２つの配列を結合し、ソートした配列を作成
		TreeSet<Integer> compPrimeList = new TreeSet<Integer>();
		for (Integer integer : primeList) {
			compPrimeList.add(integer);
		}
		for (Integer integer : setNumList) {
			compPrimeList.add(integer);
		}
		System.out.println(compPrimeList);
	}
}
