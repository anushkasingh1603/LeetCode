class Solution {
    public int maximumGap(String skill, String station) {

        int[] left = new int[skill.length()];
        int[] right = new int[skill.length()];

        int j = 0;

        for (int i = 0; i < skill.length(); i++) {
            while (station.charAt(j) != skill.charAt(i)) {
                j++;
            }

            left[i] = j;
            j++;
        }

        j = station.length() - 1;

        for (int i = 0; i < skill.length(); i++) {
            while (station.charAt(j) != skill.charAt(skill.length() - i - 1)) {
                j--;
            }

            right[skill.length() - i - 1] = j;
            j--;
        }

        int answer = 0;

        for (int i = 0; i < skill.length() - 1; i++) {
            answer = Math.max(answer, right[i + 1] - left[i]);
        }

        return answer;
    }
}