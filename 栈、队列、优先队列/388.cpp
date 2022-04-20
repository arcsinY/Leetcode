// 用一个栈保存访问到每层目录时，路径的总长度，比如目录结构为：a --> b --> c
// 则栈中数据为 1 --> 3 --> 5（因为包含了目录之间的"/"）
class Solution {
public:
    int lengthLongestPath(string input) {
        stack<int> s;
        int pos = 0;
        int ans = 0;
        while (pos < input.size()) {
            int depth = 1;
            int length = 0;
            // 这是第几层的目录或文件
            while (pos < input.size() && input[pos] == '\t') {
                pos++;
                depth++;
            }
            bool is_file = false;
            // 目录或文件名
            while (pos < input.size() && input[pos] != '\n') {
                if (input[pos] == '.') {
                    is_file = true;
                }
                length++;
                pos++;
            }
            pos++;
            // 当前目录/文件的层级小于已经遍历到的层级，需要回退到上一层
            while (s.size() >= depth) {
                s.pop();
            }
            // 现有路径长度 + 当前目录/文件长度 + "/"
            if (!s.empty()) {
                length += s.top() + 1;
            }
            if (is_file) {
                ans = max(ans, length);
            } else {
                // 是目录，继续加到栈中
                s.push(length);
            }
            
        }
        return ans;
    }
};
