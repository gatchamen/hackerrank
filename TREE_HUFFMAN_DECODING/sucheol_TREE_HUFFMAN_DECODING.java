    void decode(String s, Node root) {
        String decodedString = new String();
        Node cur = root;
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);

            if (a == '0')
                cur = cur.left;
            if (a == '1')
                cur = cur.right;

            if (cur.left == null && cur.right == null){
                decodedString = decodedString + cur.data;
                cur = root;
            }
        }

        System.out.println(decodedString);
    }
