package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class MainPessoa {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 1; i<=4; i++) {
			Thread tp = new ThreadPessoa(i, semaforo);
			tp.start();
		}

	}

}
