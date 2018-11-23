#### Classification of Trees
- Complete Binary Trees: is a binary tree in which every level of the tree is fully filled, except for perhaps the last level. To the extent that last level is filled, it is filled left to right.
- Full Binary Trees: is a binary tree in which every node has either zero or two children. That is no nodes can have only one child.
- Perfect Binary Trees: is both full and complete binary tree. All leaf nodes will be at the same level and this level has max no.of nodes. A perfect tree has exactly 2^k - 1 nodes, where k is no.of levels

#### Binary Tree Traversal
- Pre order traversal: printNode, visit Left, visit Right
    ```
    void preOrderTraversal(TreeNode node) {
        if(node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right)
        }
    }
    ```
- In  order traversal: visit Left, printNodem visit Right
    ```
    void inOrderTraversal(TreeNode node) {
        if(node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right)
        }
    }
    ```
- Post order traversal: visit Left, visit Right, printNode
    ```
    void postOrderTraversal(TreeNode node) {
        if(node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right)
            visit(node);
        }
    }
    ```
---
#### Binary Heaps
We will just discuss min-heaps. Max-heaps are essentially equivalent but the elemetns are in descending order rather than ascending order.

A min-heap is a complete binary tree(that is filled other than the rightmost elements on the last level) where each node is smaller than its children. The root, therefore, is the min element in the tree.

##### Insert
- When we insert into minheap, we always start by inserting the element at the bottom. We insert at the rightmost spot as to maintain the complete tree property.
- Then we fix the tree by swapping the new element with its parent, until we find an appropriate spot for the element. We essentially bubble up the min element.
- O(log n), where n is the no.of nodes in the heap

##### Extract Minimum Element
- Finding the min element is easy, coz its always at the top. However removing it is tricky coz you have to rebalance your tree.
- First we remove the min element and swap it with the last element in heap(bottommost, rightmost element).
- Then we bubble down this element, swapping it with one of its children until the min heap property is restored.
- Do we swap it with left child or right child? That depends on their values. Theres no inherent ordering between the left ad right element, but you will need to take the smaller one in order to maintain the min heap ordering.
- O(log n) time
---
#### Tries(Prefix Trees)
- A trie is a variant of an n-ary tree in which characters are stored at each node. Each path down the tree may represent a word.
- The * nodes(sometimes called null nodes) are often used to indicate complete words. For example, the fact that there is a * node under MANY indicates that MANY is a complete word. The existence of MA path indicates that there are words that start with MA.
- The actual implementation of these * nodes might be a special type of child (such as a TerminatingTrieNode which inherits from TrieNode). Or we could use just a boolean flag terminates within the parent node.
- A node in a trie could have anywhere from 1 through ALPHABET_SIZE + 1 children(or 0 through ALPHABET_SIZE if a boolean flag is used instead of * node separately).
- Very commonly a trie is used to store the entire(English) language for quick prefix lookups. While a hash table can quickly look up whether a string is a valid word, it cannot tell us if a string is a prefix of any valid words. A trie can do this very quickly.
- A trie can check if a string is valid prefix in O(k) time, where k is the length of the string. This is actually the same runtime as a hash table will take. Although we often refer to hash table lookups as being O(1) time, this isnt entirely true. A hash table must read through all the characters in the input, which takes O(k) time in the case of a word lookup.
- Many problems involving lists of valid words leverage a trie as an optimization. In situations when we search through the tree on related prefixes repeatedly(like looking up M, then MA, then MAN, then MANy), we might pass around a reference to the current node in the tree. This will allow us to check if Y is a child of MAN rather than starting from the root each time.
---
#### Graphs
- A tree is actually a type of graph, but not all graphs are trees. Simply put a tree is connected graph without cycles.
- A graph is a collection of nodes with edges between some of them.
- Graphs can be directed(one way street with direction or arrows in edges) or undirected(two way street with no direction).
- The graph might consist of multiple isolated subgraphs. If there is a path between every pair of vertices, it is called a connected graph.
- The graph can also have cycles(or not). An acyclic graph is one without cycles.

In programming, there are two ways to represent graphs

##### Adjacency List
- This is the most common way to rep graphs. Every vertex(or node) stores a list of adjacent vertices. In an undirected graph, an edge like (a,b) would be stored twice: once in a's adjacent vertices and once in b's adjacent vertices.

    ```
        class Graph {
            public Node[] nodes;
        }

        class Node {
            public String name;
            public Node[] children;
        }
    ```
- The graph class is used coz unlike in a tree, you cant necessarily reach all the nodes from a single node. You may have disconnected subgraphs as well.
- You dont necessarily need any additional classes to rep a graph. An array(or hash table) of lists can store the adjacency list. This would be a bit more complex, but it isnt quite as clean. We tend to use node classes unless theres a compelling reason not to.

##### Adjacency Matrices
- This is an NxN boolean matrix, where N is no.of nodes, where a true value at matrix[i][j] represents an edge from node i to node j. You can also use an integer matrix with 0s and 1s.
- In an undirected graph, an adjacency matrix will be symmetric. In a directed graph it will not necessarily be.
- This is bit less efficient compared to adj list for dfs or bfs. It has faster lookups on whether an edge is present from i to j. 
- In adj list representation, you can easily iterate through the neighbors of a node. In matrix representation, you will need to iterate all the nodes to identify a nodes neighbors.
---
##### Graph Search
- BFS is better for shortest path.

###### Depth First Search
- Note that preorder and other forms of tree traversal are a form of DFS. The key difference is that when implementing this algorithm for a graph, we must check if the node has been visited. If we dont, we risk getting stuck in an infinite loop.

    ```
        void search(Node root) {
            if(root == null) return;
            visit(root);
            root.visited = true;
            for each(Node n in root.adjacent) {
                if(n.visited == false) search(n);
            }
        }
    ```
###### Breadth First Search
- It uses a queue and is not recursive.
    ```
        void search(Node root) {
            Queue queue = new Queue();
            root.marked = true;
            queue.enqueue(root); // Add to end of queue

            while(!queue.isEmpty()) {
                Node r = queue.dequeue(); // Remove from the front of the queue
                visit(r);
                foreach(Node n in r.adjacent) {
                    if(n.marked == false) {
                        n.marked = true;
                        queue.enqueue(n);
                    }
                }
            }
        }
    ```
###### Bidirectional Search
- It is used to find the shortest path between a source and destination node. It operates by essentially running two simultaneous BFS, one from each node. When their searches collide, we have found a path.
- BFS: Single search from s to t that collides after 4 levels
- Bidirectional Search: Two searches(one from s and one from t) that collide after four levels total(two levels each).
- Why is this faster? - Consider a graph where every node has at most k adjacent nodes and shortest path from node s to node t has length d.
    - In BFS, we would search up to k nodes in 1st level of search. In second level, we would search up to k nodes for each of those first k nodes, so k^2 nodes total so far. We would do this d times so O(k^d) time complexity
    - In BDS, we have two searches that collide after approximately d/2 levels. Hence O(K^(d/2)) time complexity which is very fast compared to previous BFS.