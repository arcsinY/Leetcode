class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        int i = 0;
        for (i = 0; i < version1Arr.length && i < version2Arr.length; ++i) {
            int a = Integer.parseInt(version1Arr[i]);
            int b = Integer.parseInt(version2Arr[i]);
            if (a < b) {
                return -1;
            }
            if (a > b) {
                return 1;
            }
        }
        if (i == version1Arr.length && i == version2Arr.length) {
            return 0;
        }
        if (i < version1Arr.length) {
            for (int j = i; j < version1Arr.length; ++j) {
                if (Integer.parseInt(version1Arr[j]) != 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            for (int j = i; j < version2Arr.length; ++j) {
                if (Integer.parseInt(version2Arr[j]) != 0) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
