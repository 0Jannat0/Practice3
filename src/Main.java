import java.util.*;
public class Main {

    public static void main(String[] args) {

        // 1. Create & Put
        HashMap<String, Integer> students = new HashMap<>();
        students.put("Aida", 85);
        students.put("Azat", 92);
        students.put("Dana", 77);
        System.out.println(students);
        System.out.println("Size: " + students.size());


        // 2. Get & ContainsKey
        System.out.println("Aida score: " + students.get("Aida"));
        if (students.containsKey("Mira"))
            System.out.println(students.get("Mira"));
        else
            System.out.println("Mira not found");


        // 3. Update Existing Value
        Integer oldValue = students.put("Dana", 80);
        System.out.println("Old value: " + oldValue);
        System.out.println(students);


        // 4. Remove by Key
        System.out.println("Remove Azat: " + (students.remove("Azat") != null));
        System.out.println("Remove X: " + (students.remove("X") != null));


        // 5. isEmpty & clear
        System.out.println("Is empty before clear: " + students.isEmpty());
        students.clear();
        System.out.println("Is empty after clear: " + students.isEmpty());

        students.put("Aida", 85);
        students.put("Dana", 80);
        students.put("Mira", 88);


        // 6. getOrDefault
        int score1 = students.getOrDefault("Mira", -1);
        if (score1 == -1)
            System.out.println("Not found");
        else
            System.out.println(score1);

        int score2 = students.getOrDefault("Azat", -1);
        if (score2 == -1)
            System.out.println("Not found");
        else
            System.out.println(score2);


        // 7. putIfAbsent
        students.putIfAbsent("Aida", 90);
        students.putIfAbsent("Azat", 88);
        System.out.println(students);


        // 8. replace
        students.replace("Aida", 91);
        students.replace("X", 50);
        System.out.println(students);


        // 9. Iterate over keys, values, entries
        for (String key : students.keySet())
            System.out.println("Key: " + key);

        for (Integer value : students.values())
            System.out.println("Value: " + value);

        for (Map.Entry<String, Integer> entry : students.entrySet())
            System.out.println(entry.getKey() + "=" + entry.getValue());


        // 10. Count score ≥ 80
        int count = 0;
        for (Integer value : students.values())
            if (value >= 80)
                count++;
        System.out.println("Count ≥80: " + count);


        // 11. Find max score
        int max = -1;
        String name = "";
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                name = entry.getKey();
            }
        }
        System.out.println("Max: " + name + " = " + max);


        // 12. Word Frequency
        String text = "Java is fun and Java is powerful and fun";
        String[] words = text.toLowerCase().split(" ");
        HashMap<String, Integer> wordFreq = new HashMap<>();

        for (String w : words) {
            int val = wordFreq.getOrDefault(w, 0);
            wordFreq.put(w, val + 1);
        }
        System.out.println(wordFreq);


        // 13. Character Frequency
        String str = "Mississippi";
        HashMap<Character, Integer> charFreq = new HashMap<>();

        for (char c : str.toCharArray()) {
            int val = charFreq.getOrDefault(c, 0);
            charFreq.put(c, val + 1);
        }
        System.out.println(charFreq);

        char maxChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        System.out.println("Most frequent char: " + maxChar);


        // 14. Group Words by Length
        String[] arr = {"hi","book","java","sun","loop","map"};
        HashMap<Integer, ArrayList<String>> group = new HashMap<>();

        for (String w : arr) {
            int len = w.length();
            if (!group.containsKey(len))
                group.put(len, new ArrayList<String>());
            group.get(len).add(w);
        }
        System.out.println(group);


        // 15. First Non-Repeating Character
        String word = "swiss";
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : word.toCharArray()) {
            int val = freq.getOrDefault(c, 0);
            freq.put(c, val + 1);
        }

        char first = 0;
        for (char c : word.toCharArray()) {
            if (freq.get(c) == 1) {
                first = c;
                break;
            }
        }

        if (first == 0)
            System.out.println("None");
        else
            System.out.println(first);


        // 16. Two-Sum
        int[] nums = {2,7,11,15};
        int target = 9;
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                System.out.println("Indices: " + numMap.get(complement) + ", " + i);
                break;
            }
            numMap.put(nums[i], i);
        }


        // 17. Detect Duplicates
        String[] fruits = {"apple","banana","apple","orange","banana","kiwi"};
        HashMap<String,Integer> freqMap = new HashMap<>();

        for (String f : fruits) {
            int val = freqMap.getOrDefault(f, 0);
            freqMap.put(f, val + 1);
        }

        for (Map.Entry<String,Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1)
                System.out.println("Unique: " + entry.getKey());
            else
                System.out.println("Duplicate: " + entry.getKey() + "=" + entry.getValue());
        }


        // 18. Equals & Order-Insensitivity
        HashMap<String,Integer> m1 = new HashMap<>();
        m1.put("A",1);
        m1.put("B",2);

        HashMap<String,Integer> m2 = new HashMap<>();
        m2.put("B",2);
        m2.put("A",1);

        System.out.println("Equals: " + m1.equals(m2));
        System.out.println("HashCodes: " + m1.hashCode() + " " + m2.hashCode());


        // 19. Remove Entries Conditionally
        HashMap<String,Integer> test = new HashMap<>();
        test.put("A",50);
        test.put("B",70);
        test.put("C",40);

        Iterator<Map.Entry<String,Integer>> it = test.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> entry = it.next();
            if(entry.getValue() < 60)
                it.remove();
        }
        System.out.println(test);


        // 20. Merge Scores
        HashMap<String,Integer> scores1 = new HashMap<>();
        scores1.put("Aida",40);
        scores1.put("Azat",35);
        scores1.put("Dana",50);

        HashMap<String,Integer> scores2 = new HashMap<>();
        scores2.put("Azat",10);
        scores2.put("Dana",5);
        scores2.put("Mira",45);

        for (Map.Entry<String,Integer> entry : scores2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (scores1.containsKey(key)) {
                int sum = scores1.get(key) + value;
                scores1.put(key, sum);
            } else {
                scores1.put(key, value);
            }
        }
        System.out.println(scores1);


        // 21. Invert Map
        HashMap<Integer, ArrayList<String>> inverted = new HashMap<>();

        for (Map.Entry<String,Integer> entry : scores1.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (!inverted.containsKey(value))
                inverted.put(value, new ArrayList<String>());

            inverted.get(value).add(key);
        }
        System.out.println(inverted);


        // 22. Top-2 Frequent Words
        String text2 = "Java is fun and Java is powerful and fun";
        String[] words2 = text2.toLowerCase().split(" ");

        HashMap<String,Integer> freq2 = new HashMap<>();
        for (String w : words2) {
            int val = freq2.getOrDefault(w, 0);
            freq2.put(w, val + 1);
        }

        String top1 = "";
        String top2 = "";
        int max1 = 0;
        int max2 = 0;

        for (Map.Entry<String,Integer> entry : freq2.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();

            if (value > max1) {
                max2 = max1;
                top2 = top1;

                max1 = value;
                top1 = key;
            } else if (value > max2) {
                max2 = value;
                top2 = key;
            }
        }

        System.out.println("Top 1: " + top1 + "=" + max1);
        System.out.println("Top 2: " + top2 + "=" + max2);
    }
}
