// 单调队列，用双端队列实现
// 入队时，从队尾开始判断，< 当前元素的从队尾移除
// 出队时，判断队头是否等于当前元素
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        deque<int> q;
        for (int i = 0; i < nums.size(); i++) {
            while (!q.empty() && q.back() < nums[i]) {
                q.pop_back();
            }
            q.push_back(nums[i]);
            if (i >= k - 1) {
                ans.push_back(q.front());
                if (!q.empty() && q.front() == nums[i - k + 1]) {
                    q.pop_front();
                }
            }
        }
        return ans;
    }
};
