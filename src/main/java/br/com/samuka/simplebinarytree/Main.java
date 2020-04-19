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
package br.com.samuka.simplebinarytree;

import br.com.samuka.simplebinarytree.model.Node;
import br.com.samuka.simplebinarytree.tree.BinaryTree;

/**
 *
 * @author 'Samuel José Eugênio - https://github.com/samuelgenio'
 */
public class Main {

    public static void main(String[] args) {
        
        BinaryTree arvore = new BinaryTree();
        
        arvore.insere(new Node(10), new Node(5));
        
        arvore.insere(new Node(10), new Node(11));
        
        arvore.insere(new Node(10), new Node(8));
        
        arvore.elementos();
        
    }
    
}
