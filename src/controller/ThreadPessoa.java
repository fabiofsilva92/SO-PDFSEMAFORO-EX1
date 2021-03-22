package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread{
	
	
	public ThreadPessoa(int pessoaId, Semaphore semaforo) {
		PessoaId = pessoaId;
		this.semaforo = semaforo;
	}
	
	static int posicao = 0;
	
	private int PessoaId;
	private Semaphore semaforo;
	
	@Override
	public void run() {
		andarCorredor();
		try {
			semaforo.acquire();
			abrirPorta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	
	public void andarCorredor() {
		
		int corredor = 200;
		int percorrido = 0;
		int metros;
		
		while(percorrido<corredor) {
			metros = (int)((Math.random()*3) + 4);
			percorrido = percorrido + metros;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(percorrido > corredor) {
				percorrido = 200;
			}
			System.out.println("#ID "+PessoaId+" -> Andou "+percorrido+" metros.");
		}
		posicao++;
		System.out.println("#ID "+PessoaId+ " -> Posição "+posicao);
	}

	public void abrirPorta() {
		
		int tempo = (int)((Math.random() * 1001)+1000);
		System.out.println("#ID "+PessoaId+" -> Abrindo e cruzando a porta");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#ID "+PessoaId+" -> Cruzou");
	}
	
}
