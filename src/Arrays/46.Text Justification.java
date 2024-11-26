https://leetcode.com/problems/text-justification/submissions/1451335525/?envType=problem-list-v2&envId=array

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines=new ArrayList<>();

        int idx=0;
        while(idx<words.length)
        {
            int cnt=words[idx].length();
            int last=idx+1;
            while(last<words.length)
            {
                // Find the last word that fits in the line
                if(cnt+1+words[last].length()>maxWidth) break;
                cnt+=1+words[last].length();
                last++;
            }

            // Build the current line
            StringBuilder sb = new StringBuilder();
            int gaps = last - idx - 1;

            // If it's the last line or contains only one word, left-justify
            if (last == words.length || gaps == 0) {
                for (int i = idx; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                // Fill the rest with spaces
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Distribute spaces evenly
                int spaces = (maxWidth - cnt) / gaps;
                int extraSpaces = (maxWidth - cnt) % gaps;

                for (int i = idx; i < last - 1; i++) {
                    sb.append(words[i]);
                    // Add spaces
                    for (int j = 0; j <= spaces + (i - idx < extraSpaces ? 1 : 0); j++) {
                        sb.append(" ");
                    }
                }
                // Append the last word in the line
                sb.append(words[last - 1]);
            }

            lines.add(sb.toString());
            idx = last;
        }

        return lines;
    }
}