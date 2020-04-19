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
package br.com.samuka.simplebinarytree.model;

/**
 *
 * @author 'Samuel José Eugênio - https://github.com/samuelgenio'
 */
public class Node {
    
    /**
     * Valor do nó
     */
    public int valor;
    
    /**
     * Raiz do nó
     */
    public Node raiz;
    
    /**
     * Filho da esquerda, sempre terá um valor
     * menor que o nó raiz
     */
    public Node filhoEsq;
    
    /**
     * Filho da direita, sempre terá um valor
     * maior que o nó raiz
     */
    public Node filhoDir;

    public Node(int v) {
        this.valor = v;
        raiz = null;
        filhoEsq = null;
        filhoDir = null;
    }
    
}
