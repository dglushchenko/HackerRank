package week11.trainingthearmy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static class Wizard {
		private Set<Integer> from = new HashSet<Integer>();
		private Set<Integer> to = new HashSet<Integer>();

		public void addFrom(int fromSkill) {
			from.add(fromSkill);
		}

		public void addTo(int toSkill) {
			to.add(toSkill);
		}

		public Set<Integer> getFrom() {
			return from;
		}

		public Set<Integer> getTo() {
			return to;
		}

		public boolean isEmpty() {
			return from.isEmpty() || to.isEmpty();
		}
	}

	private static int solve(int[] skills, Wizard[] wizards) {
		boolean changed = true;
		while (changed) {
			changed = false;
			for (Wizard wizard : wizards) {
				if (wizard.isEmpty()) {
					continue;
				}
				Set<Integer> from = wizard.getFrom();
				Set<Integer> to = wizard.getTo();
				for (int fromSkill = 1; fromSkill < skills.length; fromSkill++) {
					if (skills[fromSkill] > 1 && from.contains(fromSkill)) {
						Iterator<Integer> it = to.iterator();
						int minSkill = Integer.MAX_VALUE;
						int minIndex = Integer.MAX_VALUE;
						while (it.hasNext()) {
							int toSkill = it.next();
							if (skills[toSkill] < minSkill) {
								minSkill = skills[toSkill];
								minIndex = toSkill;
							}
						}
						skills[minIndex]++;
						from.remove(fromSkill);
						skills[fromSkill]--;
						changed = true;
					}
				}
			}
		}

		int count = 0;
		for (int i = 1; i < skills.length; i++) {
			if (skills[i] > 0) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int n = in.nextInt();
			int t = in.nextInt();
			int[] skills = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				skills[i] = in.nextInt();
			}
			Wizard[] wizards = new Wizard[t];
			for (int i = 0; i < t; i++) {
				Wizard wizard = new Wizard();
				int fromSize = in.nextInt();
				for (int j = 0; j < fromSize; j++) {
					wizard.addFrom(in.nextInt());
				}
				int toSize = in.nextInt();
				for (int j = 0; j < toSize; j++) {
					wizard.addTo(in.nextInt());
				}
				wizards[i] = wizard;
			}
			System.out.println(solve(skills, wizards));
		} finally {
			in.close();
		}
	}

}
