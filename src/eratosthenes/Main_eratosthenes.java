package eratosthenes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main_eratosthenes {
	public static final String EXCEPTION_MESSAGE = "�������w�肵�Ă��������B";

	public static void main(String[] args) {
		Integer num = 0;
		try {
			num = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			// �����łȂ��ꍇ�G���[�\��
			System.out.println(EXCEPTION_MESSAGE);
			return;
		}

		// �w�肳�ꂽ����z��Ɋi�[
		LinkedList<Integer> numList = new LinkedList<Integer>();
		for (int i = 0; i <= num; i++) {
			if (i != 0 && i != 1)
				numList.add(i);
		}

		// �f�����i�[����z��
		LinkedList<Integer> primeList = new LinkedList<Integer>();
		// �擪�̐����i�[���A���̐��̔{�������X�g����폜
		do {
			primeList.add(numList.getFirst());
			for (Iterator<Integer> iterator = numList.iterator(); iterator
					.hasNext();) {
				Integer judgeNum = (Integer) iterator.next();
				if (judgeNum % primeList.getLast() == 0) {
					iterator.remove();
				}
			}
		} while (primeList.getLast() * primeList.getLast() < numList.getLast());

		//�Q�̔z����������A�\�[�g�����z����쐬
		TreeSet<Integer> compPrimeList = new TreeSet<Integer>();
		for (Integer integer : primeList) {
			compPrimeList.add(integer);
		}
		for (Integer integer : numList) {
			compPrimeList.add(integer);
		}
		System.out.println(compPrimeList);
	}
}
