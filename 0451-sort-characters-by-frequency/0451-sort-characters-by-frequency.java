class Solution {
    public String frequencySort(String s) {
        List<String> res = encode(s);
        Collections.sort(res, new Comparator<String>(){
            @Override
            public int compare(String a, String b)
            {
                // Extract the freq part out of the encoded string
                // Sort according to the freq of the char
                return (int)(Integer.parseInt(b.substring(1))) - (int)(Integer.parseInt(a.substring(1)));
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i ++)
        {
            String charFreq = res.get(i);
            int freq = Integer.parseInt(charFreq.substring(1));
            // Use Java Stream to append a char multiple times
            sb.append(IntStream.range(0, freq).mapToObj(k -> charFreq.substring(0,1)).collect(Collectors.joining("")));
        }
        
        return sb.toString();
    }
    
    private List<String> encode(String s)
    {
        List<String> res = new ArrayList<>();
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i ++)
        {
            int freq = map.getOrDefault(s.charAt(i),0);
            freq ++;
            map.put(s.charAt(i),freq);
        }

        for (Map.Entry<Character,Integer> entry : map.entrySet())
        {
            res.add(entry.getKey()+Integer.toString(entry.getValue()));
        }
        return res;
    }
}