class Solution {
    public List<String> letterCombinations(String A) {

        if(A.equals("")){
            return new ArrayList<>();
        }

        ArrayList < Character > digits[];
        digits = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            digits[i] = new ArrayList < > ();
        }
        // create mapping of digit to letters
        digits[0].add('0');
        digits[1].add('1');
        char c = 'a';
        int k;
        for (int i = 2; i < 10; i++) {
            k = 3;
            // 4 characters possible for number 7 and 9
            if (i == 7 || i == 9)
                k = 4;
            for (int j = 0; j < k; j++) {
                digits[i].add(c);
                c++;
            }
        }
        int i = 0;
        int n = A.length();
        int dig;
        ArrayList < String > res = new ArrayList < > ();
        ArrayList < String > temp = new ArrayList < > ();
        ArrayList < String > x;
        res.add("");
        while (i < n) {
            dig = A.charAt(i) - '0';
            // loop through all possible letters for that index
            for (String str: res) {
                for (char ch: digits[dig]) {
                    String st = str + ch;
                    temp.add(st);
                }
            }
            x = res;
            res = temp;
            temp = x;
            temp.clear();
            i++;
        }
        return res;
        
    }
}