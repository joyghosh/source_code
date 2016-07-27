package adt.stack;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		towerOfHanoiRecursive(n, 'A', 'C', 'B');
	}

	public static void towerOfHanoiRecursive(int n, char from, char to, char aux){
		if(n==1){
			System.out.printf("Move disk 1 from rod %c to rod %c \n", from, to);
			return;
		}
		towerOfHanoiRecursive(n-1, from, aux, to);
		System.out.printf("Move disk %d from rod %c to rod %c \n", n, from, to);
		towerOfHanoiRecursive(n-1, aux, to, from);
	}
}
