public class test {
    public static void main(String[] args) {
        String string = "abcdeffgha";
        String[] string1 = string.split("");
        String[] string2 = string1;
        String result = "";
        for (int i = 0; i < string1.length; i++) {
            int count = 0;
            for (int j = 0; j < string1.length; j++) {
                if (string1[j].equals(string2[i])) {
                    count++;
                }
            }
            if (count > 1) {
                if (!result.contains(string2[i])) {
                    result += string2[i] + ",";
                }
            }
        }
        System.out.println("[" + result + "]");
    }
}
