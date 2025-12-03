/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.digital.dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

/**
 *
 * @author simba
 */
public class GestorArquivos {
    
    // Salva qualquer vetor num arquivo
    public static void salvarVector(Vector<?> vetor, String nomeArquivo) {
        try (ObjectOutputStream gravador = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            gravador.writeObject(vetor);
            // System.out.println("Dados salvos em: " + nomeArquivo); // Debug (Opcional)
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    // Lê o arquivo e devolve o vetor. Se não existir, devolve um vazio.
    public static Vector<?> carregarVector(String nomeArquivo) {
        try (ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (Vector<?>) leitor.readObject();
        } catch (Exception e) {
            // Se der erro (ex: arquivo não existe na primeira vez), retorna lista vazia
            return new Vector<>();
        }
    }
    
}
