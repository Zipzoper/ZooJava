package com.github.zipzoper.zoojava.service;

import com.github.zipzoper.zoojava.controller.Zoologico;

public class AutoSaveThread extends Thread {

    private final PersistenciaService persist;
    private final Zoologico zoo;
    private boolean rodando = true;

    public AutoSaveThread(PersistenciaService persist, Zoologico zoo) {
        this.persist = persist;
        this.zoo = zoo;
    }

    @Override
    public void run() {
        while (rodando) {
            try {
                Thread.sleep(10000); // 10 segundos

                if (!zoo.getAnimais().isEmpty()) {
                    persist.salvar(zoo.getAnimais());
                    System.out.println("💾 Auto-save executado automaticamente.");
                }

            } catch (InterruptedException e) {
                System.out.println("⏳ Auto-save interrompido.");
            } catch (Exception e) {
                System.out.println("❌ Erro no auto-save: " + e.getMessage());
            }
        }
    }

    public void parar() {
        rodando = false;
        this.interrupt();
    }
}
