/*
 * Copyright (C) 2020 Asconn
 *
 * This file is part of SimpleBinaryTree.
 * SimpleBinaryTree is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * SimpleBinaryTree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>
 */
package br.com.samuka.simplebinarytree.tree;

import br.com.samuka.simplebinarytree.model.Node;
import java.util.ArrayList;

/**
 *
 * @author 'Samuel José Eugênio - https://github.com/samuelgenio'
 */
public class BinaryTree {
    
    /**
     * Raiz da arvore
     */
    private Node raiz;

    public BinaryTree() {
        raiz = null;
    }
    
    /**
     * Insere um Nó à arvore
     * @param pai Nó Pai
     * @param filho No Filho
     */
    public void insere(Node pai, Node filho) {
        
        if (raiz == null) {
            raiz = pai;
            insere(pai, filho);
        } else {
            
            Node node = encontraElemento(pai.valor, raiz);
            
            filho.raiz = (node != null)? node : pai;
            
            if(null == filho.raiz.filhoEsq && filho.raiz.valor >= filho.valor)//caso o pai seja maior
                filho.raiz.filhoEsq = filho;
            else if(null == filho.raiz.filhoDir && filho.raiz.valor < filho.valor)//caso o filho seja menor.
                filho.raiz.filhoDir = filho;
            else
                insere(filho.raiz.filhoEsq, filho);
        }
    }
    
    /**
     * @return Retorna a raiz da arvore
     */
    public Node raiz(){
        return this.raiz;
    }
    
    /**
     * @param node Nó a ser verificado
     * @return retorna o pai do nó
     */
    public Node getFather(Node node){
        return node.raiz;
    }
    
    /**
     * Encontra os filhos do nó
     * @param n Nó a ser verificado
     * @return ArrayList com os nós filhos encontrados
     */
    public ArrayList<Node> childrens(Node n){
        
        ArrayList<Node> childrens = new ArrayList<>();
        
        if(n.filhoEsq != null)
            childrens.add(n.filhoEsq);
        
        if(n.filhoDir != null)
            childrens.add(n.filhoDir);
        
        
        return childrens;
    }
   
    /**
     * Verifica se um nó é interno.
     * Nó interno são aqueles que possuem algum filho
     * @param node Nó a ser verificado
     * @return True para interno false caso externo.
     */
    public boolean verificaInterno(Node node){
        return childrens(node).size() > 0;
    }
    
    /**
     * Verifica se o node é uma raiz
     * @param node Nó a ser verificado
     * @return True caso seja raiz, false caso contrario
     */
    public boolean verificaraiz(Node node){
        return node.raiz.valor == raiz.valor;
    }
    
    public ArrayList<Node> elementos() {
        
        ArrayList<Node> lista = new ArrayList<>();
        lista.add(raiz);
        int i = 0;
        while (i < lista.size()) {
            Node atual = lista.get(i);
            
            if(atual.filhoEsq != null)
                lista.add(atual.filhoEsq);
            
            if(atual.filhoDir != null)
                lista.add(atual.filhoDir);
            
            i++;
        }
        return lista;
    }
    
    /**
     * Retorna o filho da esquerda do valor em questão
     * @param valor valor a ser encontrado
     * @return Valor do nó da esquerda 
     */
    public int getFilhoEsquerda(int valor){
        
        Node node = encontraElemento(valor, null);
        
        if(null != node){
            
            if(verificaInterno(node)){
                if(null != node.filhoEsq)
                    return node.filhoEsq.valor;
                else
                    msg("Erro, Valor [" + valor + "] não possui um filho à esquerda");
            }else
                msg("Erro, Valor [" + valor + "] não está em um nó interno");
        }else
            msg("Erro, Valor [" + valor + "] não encontrado");
        
        return -1;
    }
    
    /**
     * Retorna o filho da direita do valor em questão
     * @param valor valor a ser encontrado
     * @return Valor do nó da esquerda 
     */
    public int getFilhoDireita(int valor){
        
        Node node = encontraElemento(valor, null);
        
        if(null != node){
            
            if(verificaInterno(node)){
                if(null != node.filhoDir)
                    return node.filhoDir.valor;
                else
                    msg("Erro, Valor [" + valor + "] não possui um filho à direitra");
            }else
                msg("Erro, Valor [" + valor + "] não está em um nó interno");
        }else
            msg("Erro, Valor [" + valor + "] não encontrado");
        
        return -1;
    }
    
    public int getIrmao(int valor){
        
        if(raiz.valor == valor){
            msg("Erro, Valor [" + valor + "] é a raiz, não possui irmão");
            return -1;
        }
        
        Node node = encontraElemento(valor, null);
        
        if(null != node){
     
            if(node.raiz.filhoEsq == node)
                return node.raiz.filhoDir.valor;
            else
                return node.raiz.filhoEsq.valor;
            
        }else
            msg("Erro, Valor [" + valor + "] não encontrado");
        
        return -1; 
        
    }
    
    /**
     * Encontra um elemento nó por seu valor
     * @return Nó encontrado
     */
    private Node encontraElemento(int valor, Node node){
        
        if(node == null)
            node = raiz;
        
        if(node.valor == valor)
            return node;
        else if(verificaInterno(node)){
            if(node.valor > valor)
                encontraElemento(valor, node.filhoDir);
            else
                encontraElemento(valor, node.filhoEsq);
        }
        
        return null;
            
    }
    
    /**
     * Mensagem ao usuário.
     * @param msg Mensagem a ser exibida
     */
    private void msg(String msg){
        System.err.println(msg);
    }
    
}
