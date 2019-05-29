

    // Complete the hasCycle function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        Set<SinglyLinkedListNode> set = new HashSet<>();
        SinglyLinkedListNode node = head;
        while(node != null) {
            if(set.contains(node)) {
                return true;
            }

            set.add(node);
            node = node.next;
        }

        return false;
    }

