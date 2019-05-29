    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        ArrayList visited = new ArrayList();
        while( node != null ){
            if (visited.contains(node)){
                return true;
            }
            visited.add(node);
            node = node.next;
        }
        return false;
    }


